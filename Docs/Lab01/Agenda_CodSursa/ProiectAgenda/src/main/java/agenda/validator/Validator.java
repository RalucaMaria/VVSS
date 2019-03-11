package agenda.validator;

import java.util.List;

public interface Validator<E> {

    void validate (E e, List<String> errors);

}
