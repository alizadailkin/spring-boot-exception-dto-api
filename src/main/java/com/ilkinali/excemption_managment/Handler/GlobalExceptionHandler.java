package com.ilkinali.excemption_managment.Handler;

import com.ilkinali.excemption_managment.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@ControllerAdvice  // exception catch elemek ucun
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiEror> handleBaseException(BaseException exception, WebRequest request) {

        return  ResponseEntity.badRequest().body(creatApiEror(exception.getMessage(),request));


    }
    public <E >ApiEror<E> creatApiEror(E message ,WebRequest request){
        ApiEror apiEror = new ApiEror();

        apiEror.setStatus(HttpStatus.BAD_REQUEST.value());
        Exception <E>exception = new Exception();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostname());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);
        apiEror.setException(exception);

        return apiEror;

    }
    private String getHostname() {
        try {
            InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            System.out.println("Error" + e.getMessage());
        }
        return null;
    }





}
