package br.com.tdsis.lambda.forest.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import br.com.tdsis.lambda.forest.domain.DefaultResponseError;
import br.com.tdsis.lambda.forest.http.RequestBodyDeserializerStrategy;
import br.com.tdsis.lambda.forest.http.exception.BadRequestException;
import br.com.tdsis.lambda.forest.http.exception.HttpException;
import br.com.tdsis.lambda.forest.http.exception.InternalServerErrorException;

/**
 * The JSON request body deserializer strategy
 * 
 * @author nmelo
 * @version 1.0.0
 * @since 1.0.0
 */
public class JsonRequestBodyDeserializerStrategy implements RequestBodyDeserializerStrategy {

    public static final String INVALID_JSON_MESSAGE = "Invalid JSON";   
    public static final String INVALID_JSON_ATTRIBUTE = "Invalid JSON attribute: %1s";

    @Override
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String body, Class<?> entityClass) throws HttpException {
        ObjectMapper mapper = new ObjectMapper();

        try {

            return (T) mapper.readValue(body, entityClass);
            
        } catch (JsonParseException e) {
            throw new BadRequestException(new DefaultResponseError(INVALID_JSON_MESSAGE));  

        } catch (JsonMappingException e) {
            String message = INVALID_JSON_MESSAGE;
            
            if (e instanceof UnrecognizedPropertyException){                
                message = String.format(INVALID_JSON_ATTRIBUTE, 
                        ((UnrecognizedPropertyException) e).getPropertyName());
            }
                
            throw new BadRequestException(new DefaultResponseError(message));               
            
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage(), e);
        }

    }

}
