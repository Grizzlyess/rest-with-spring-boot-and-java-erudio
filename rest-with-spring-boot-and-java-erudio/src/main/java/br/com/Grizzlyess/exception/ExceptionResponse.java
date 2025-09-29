package br.com.Grizzlyess.exception;

import java.util.Date;

public record ExceptionResponse (Date timestamp, String message, String details){}
