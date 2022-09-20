package com.ch.exception;

import com.ch.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author chenghao
 * @purpose：统一异常处理：为了解决出现异常，返回的就不是我们定义的
 * Result结果集了
 * @备注：   使用的是spring的统一异常处理器@ExceptionHandler
 *          1. ☝️全局：不管是什么异常都会处理，相当于顶级的Exception
 *          2. 特定：比如空指针，算数异常等
 *          3.自定：自己写，手动抛出:try catch,throw new GgcktExcption
 *
 *  第一步创建异常处理类，第二，在这个类上使用aop，@ControllerAdvice
 *  第三步：类中编写处理方法，并在方法添加注解@ExceptionHandler
 * @data 2022年09月20日 00:23
 */

@ControllerAdvice //aop,维护原始类
public class GlobleExceptionHandler {

    /*
     * @Description:  全局异常处
     * @Author: chenghao
     * @Date: 2022/9/20 00:36
     * @param e
     * @return: com.ch.result.Result
     **/
    //注意：之前Controller上为Rest...，现在没有，不会返回json
    @ResponseBody  //所以
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {
        return Result.fail(null).message("执行全局异常处理");
    }

    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public Result error(ArithmeticException e) {
        e.printStackTrace();
         return Result.fail(null).message("执行运算异常");
    }

    //那么如果出现10/0，到底执行哪儿个异常呢？？？？
    //说明：出现异常先找有没有属于它的。就近原则
    @ResponseBody
    @ExceptionHandler(GgktException.class)
    public Result error(GgktException e) {
        e.printStackTrace();
        return Result.fail(null).code(e.getCode()).message(e.getMsg());
    }


}
