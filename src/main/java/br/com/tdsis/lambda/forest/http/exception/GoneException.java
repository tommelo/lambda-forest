package br.com.tdsis.lambda.forest.http.exception;

import org.apache.http.HttpStatus;

/**
 * The GoneException class
 * <p>
 * This is a concrete class of the the HttpException class. 
 * It represents a method not allowed http response.
 * 
 * @author fsantana
 * @version 0.0.2
 * @since 0.0.2
 * @see {@link HttpStatus#SC_GONE}
 */
public class GoneException extends HttpException {

    private static final long serialVersionUID = 3099405537692347007L;
    private static final int HTTP_STATUS = HttpStatus.SC_GONE;

    public GoneException() {
        super(HTTP_STATUS);
    }

    public GoneException(Object entity) {
        super(entity, HTTP_STATUS);
    }

    public GoneException(final String message, final Throwable cause) {
        super(HTTP_STATUS, message, cause);
    }

    public GoneException(Object entity, final String message, final Throwable cause) {
        super(entity, HTTP_STATUS, message, cause);
    }

}
