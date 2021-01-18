package com.cognizant.exception;

import java.util.Date;

import lombok.Data;

@Data
public class ApiError {
private Integer errorCode;
private String errorMsg ;
private Date errorDate;
}
