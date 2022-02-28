package com.security.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HttpRespone {
    private int httpStatusCode; // 200, 201, 400
    private HttpStatus httpStatus;
    private String reason;
    private String message;
}
