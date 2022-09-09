package com.hasan.payload.request;

import com.hasan.entity.Address;
import lombok.Data;

import java.util.List;

import javax.validation.constraints.*;
@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private List<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private List<Address> addressList;


}