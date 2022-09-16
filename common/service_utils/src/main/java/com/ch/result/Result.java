package com.ch.result;

import io.swagger.models.auth.In;
import lombok.Data;

/**
 * @author chenghao
 * @purpose：统一处理后端返回结果
 * @备注：
 * @data 2022年09月16日 13:17
 */
@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public static <T> Result ok(T data){
        Result<T> result = new Result<>();
        result.setMessage("成功");
        result.setCode(200);
        if ( data != null ) {
            result.setData(data);
        }
     return result;
    }
    public static <T> Result fail(T data){
        Result<T> result = new Result<>();
        result.setMessage("失败");
        result.setCode(201);
        if (data != null){
            result.setData(data);
        }
        return result;
    }


}
