package agenda.validator;

import agenda.model.base.User;

import java.util.List;

public class ValidatorUser implements Validator<User>{

    public void validate(User entity) throws ValidatorException {
        String errMsg="";
        if (entity.getName().equals(""))
            errMsg+="Userul nu are nume";
        if (entity.getUsername().equals(""))
            errMsg+="Userul nu are username";
        if (errMsg!="")
            throw new ValidatorException(errMsg);
    }

    @Override
    public void validate(User user, List<String> errors) {

    }

}
