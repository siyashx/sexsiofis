package com.biglikuryer.sexsiofis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class LoginRequest {

    private String phoneNumber;
    private String password;
}
