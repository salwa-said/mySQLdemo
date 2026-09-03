package com.cl.mysqldemo.exceptions;

import java.util.Date;

public record ErrorResponse(int status, String error, String message, Date timeStamp) {

}
