package br.com.tdsis.lambda.forest.http.exception;

import org.apache.http.HttpStatus;

/**
 * The BadGatewayException class
 * <p>
 * This is a concrete class of the the HttpException class. 
 * It represents a method not allowed http response.
 * 
 * @author fsantana
 * @version 0.0.2
 * @since 0.0.2
 * @see {@link HttpStatus#SC_BAD_GATEWAY}
 */
public class BadGatewayException extends HttpException {

    private static final long serialVersionUID = 3099405537692347007L;
    private static final int HTTP_STATUS = HttpStatus.SC_BAD_GATEWAY;

    public BadGatewayException() {
        super(HTTP_STATUS);
    }

    public BadGatewayException(Object entity) {
        super(entity, HTTP_STATUS);
    }

    public BadGatewayException(final String message, final Throwable cause) {
        super(HTTP_STATUS, message, cause);
    }

    public BadGatewayException(Object entity, final String message, final Throwable cause) {
        super(entity, HTTP_STATUS, message, cause);
    }

}
