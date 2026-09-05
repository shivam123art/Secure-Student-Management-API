package com.shivam.studentmanagenement.exception;
import java.util.Map;
public class ErrorResponse {
    private int status;
private String message;
private String timestamp;
private Map<String,String> errors;
public ErrorResponse(int status, String message, String timestamp,Map<String, String> errors) {
    this.status = status;
    this.message = message;
    this.timestamp = timestamp;
    this.errors = errors;
}
public int getStatus(){
    return  status;
}
public String getMessage(){
    return message;
}
public String getTimestamp(){
    return timestamp;
}
public Map<String,String> getErrors(){
    return errors;

}
}
