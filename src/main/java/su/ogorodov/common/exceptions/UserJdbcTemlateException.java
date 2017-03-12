package su.ogorodov.common.exceptions;

import org.springframework.dao.EmptyResultDataAccessException;

/**
 * Created by User on 11.03.2017.
 */
public class UserJdbcTemlateException extends EmptyResultDataAccessException {
    public UserJdbcTemlateException(int expectedSize) {
        super(expectedSize);
    }
}
