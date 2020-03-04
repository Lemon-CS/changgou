package com.changgou.framework.exception;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description: BaseExceptionHandler 全局异常处理<br>
 * date: 2020/3/4 8:50 下午 <br>
 * author: fangpeng <br>
 * version: 1.0 <br>
 */
@ControllerAdvice
public class BaseExceptionHandler {

    /***
     * 异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result error(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR, e.getMessage());
    }

}
    