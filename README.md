![Java CI with Maven](https://github.com/NageswaraRaoMaridu/crnk-spring-boot/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master&event=push)

# crnk-spring-boot
Crnk integration with spring boot application to provide json:api compatible API

#### Software requriements
1. Postgres DB
2. Java 1.8 +
3. Lombok plugin (for IDE) - annotation processing needs to be enabled in IDE

#### DB setup
1. postgres was used as DBMS
2. Run the command ```CREATE DATABASE "crnk-university"``` from postgres console to create the database. Pgadmin can also be used.
3. To setup the DB schema, execute ```create_tables.sql``` file from the path ```src/main/resources/db```

#### Steps to execute
1. If you are running project using command line, replace the environment variables in ```application.yml``` file with appropriate values. Incase of IDE, environment variables can be configiured in run configuration.
2. ``` mvn clean install ``` to download the dependencies, compile and package the jar
3. Run the command ```java -jar target/crnk-spring-boot-0.0.1-SNAPSHOT.jar``` to run the packaged jar
4. If you are using IDE, you can directly run the main application class ```CrnkSpringBootApplication.java```




[![HitCount](http://hits.dwyl.com/NageswaraRaoMaridu/crnk-spring-boot.svg)](http://hits.dwyl.com/NageswaraRaoMaridu/crnk-spring-boot)
