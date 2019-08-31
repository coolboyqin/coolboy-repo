package com.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Result {
    private int id ;
    private int userId;
    private String prize;
}
