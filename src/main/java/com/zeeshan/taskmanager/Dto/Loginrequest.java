package com.zeeshan.taskmanager.Dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loginrequest {

    private String username;
    private String password;
}
