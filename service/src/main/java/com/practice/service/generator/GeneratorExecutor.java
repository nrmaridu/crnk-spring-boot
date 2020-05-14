package com.practice.service.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.crnk.core.boot.CrnkBoot;
import io.crnk.core.module.discovery.EmptyServiceDiscovery;
import io.crnk.gen.openapi.OpenAPIGeneratorConfig;
import io.crnk.gen.openapi.OpenAPIGeneratorModule;
import io.crnk.gen.openapi.OutputFormat;
import io.crnk.meta.MetaModule;
import io.crnk.meta.MetaModuleConfig;
import io.crnk.meta.provider.resource.ResourceMetaProvider;

/**
 * @author nrmaridu
 * @since May 10, 2020
 */
public class GeneratorExecutor {

    public static void main(String[] args) throws IOException {
        MetaModule metaModule;
        MetaModuleConfig metaConfig = new MetaModuleConfig();
        metaConfig.addMetaProvider(new ResourceMetaProvider());
        metaModule = MetaModule.createServerModule(metaConfig);

        CrnkBoot crnkBoot = new CrnkBoot();
        crnkBoot.setServiceDiscovery(new EmptyServiceDiscovery());
        //crnkBoot.addModule(new ConfigModule());
        crnkBoot.addModule(metaModule);
        crnkBoot.boot();

        //generateFile(metaModule);
        gen();
    }

    public static void generateFile(MetaModule metaModule) throws IOException {
        File buildDir = new File("src/main/resources");
        OpenAPIGeneratorModule generatorModule = new OpenAPIGeneratorModule();
        generatorModule.getConfig().setBuildDir(buildDir);
        generatorModule.getConfig().setTemplateName("openapi-template.yml");
        generatorModule.getConfig().setOutputSorted(true);  // Ensures deterministic output
        generatorModule.initDefaults(buildDir);
        generatorModule.generate(metaModule.getLookup());
    }

    public static void gen() throws IOException {
        OpenAPIGeneratorConfig config = new OpenAPIGeneratorConfig();
        config.setBuildDir(Files.createDirectories(Path.of("target", "openapi")).toFile());
        config.setOutputFormat(OutputFormat.JSON);
        config.setProjectName("crnk-spring-boot");
        config.setProjectVersion("2.0.0");



        MetaModuleConfig metaConfig = new MetaModuleConfig();
        metaConfig.addMetaProvider(new ResourceMetaProvider());
        MetaModule metaModule = MetaModule.createServerModule(metaConfig);

        CrnkBoot boot = new CrnkBoot();
        boot.setServiceDiscovery(new EmptyServiceDiscovery());
        boot.addModule(metaModule);
        boot.boot();

        OpenAPIGeneratorModule openAPIGeneratorModule = new OpenAPIGeneratorModule();
        openAPIGeneratorModule.setConfig(config);
        openAPIGeneratorModule.initDefaults(config.getBuildDir());

        openAPIGeneratorModule.generate(metaModule.getLookup());
    }


}
