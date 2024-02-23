package com.storage800.demo.entity.client.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDto {

    private long id;

    private String name;

    private String lastName;

    private String number;
}
