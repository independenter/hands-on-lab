package com.dbapp.core.config;

import com.dbapp.core.exception.LabException;
import com.dbapp.core.response.Response;
import com.dbapp.core.response.ResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     * @param request
     * @param e
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = LabException.class)
    @ResponseBody
    public Response  baseExceptionHandler(HttpServletRequest request, LabException e){
        logger.error("发生业务异常：",e);
        return Response.error(e.getCode(),e.getMessage());
    }

    /**
     * 处理自定义的业务异常
     * @param request
     * @param e
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response  exceptionHandler(HttpServletRequest request, Exception e){
        logger.error("发生业务异常：",e);
        return Response.error(ResponseEnum.ERROR.getCode(),e.getMessage());
    }

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = NoHandlerFoundException.class)
//    @ResponseBody
//    public Response handleResourceNotFoundException(NoHandlerFoundException e) {
//        logger.error(e.getMessage(), e);
//        return Response.error(ResponseEnum.ERROR.getCode(),"Not Found");
//    }
}
