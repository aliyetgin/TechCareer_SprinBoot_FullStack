package com.aliyetgin.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.util.Date;
import java.util.Map;

// LOMBOK
@Data
@AllArgsConstructor
@Builder
@Log4j2

// So that the backend doesn't display null data on the frontend.
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    private int status;
    private String error;
    private String message;
    private String path;
    private Date createdDate;
    private Map<String,String> validationErrors;

    //  Constructor without parameters
    public ApiResult() {
    }

    // Constructor with parameters
    public ApiResult(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Constructor with parameters
    public ApiResult(int status,String path, String message ) {
        this.status = status;
        this.message = message;
        this.path = path;
    }
}