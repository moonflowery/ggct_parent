package com.ch.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月20日 00:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GgktException extends RuntimeException{
    private Integer code;
    private String msg;

}
