package com.practice.crnk.exception.mappers;

import java.util.List;

import javax.annotation.Priority;

import org.jooq.exception.NoDataFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import io.crnk.core.engine.document.ErrorData;
import io.crnk.core.engine.error.ErrorResponse;
import io.crnk.core.engine.error.ExceptionMapper;
import io.crnk.core.utils.Prioritizable;

/**
 * @author nrmaridu
 * @since May 11, 2020
 */
@Component
public class NoDataFoundExceptionMapper implements ExceptionMapper<NoDataFoundException>, Prioritizable {
    private final static int NOT_FOUND_STATUS_CODE = 404;

    @Override
    public ErrorResponse toErrorResponse(NoDataFoundException exception) {
        return ErrorResponse.builder()
            .setStatus(NOT_FOUND_STATUS_CODE)
            .setSingleErrorData(ErrorData.builder()
                .setTitle("Not Found")
                .setDetail("The requested object could not be found.")
                .setStatus(String.valueOf(NOT_FOUND_STATUS_CODE))
                .build())
            .build();
    }

    @Override
    public NoDataFoundException fromErrorResponse(ErrorResponse errorResponse) {
        List<ErrorData> errorData = (List<ErrorData>) errorResponse.getErrors();
        if (!CollectionUtils.isEmpty(errorData)) {
            return new NoDataFoundException(errorData.get(0).getTitle());
        }
        return new NoDataFoundException("data not found");
    }

    @Override
    public boolean accepts(ErrorResponse errorResponse) {
        return errorResponse.getHttpStatus() == NOT_FOUND_STATUS_CODE;
    }

    @Override
    public int getPriority() {
        return 1;
    }
}
