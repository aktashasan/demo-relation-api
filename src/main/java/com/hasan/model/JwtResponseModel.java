package com.hasan.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class JwtResponseModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final String token;
}
