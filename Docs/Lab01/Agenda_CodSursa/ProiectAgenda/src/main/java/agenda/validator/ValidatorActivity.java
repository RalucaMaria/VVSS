package agenda.validator;

import agenda.model.base.Activity;

import java.util.List;

public class ValidatorActivity implements Validator<Activity> {

    public void validateActivity(Activity entity) throws ValidatorException {
        String errMsg="";
        if (entity.getName().equals(""))
            errMsg+="Activitatea nu are nume";
        if (entity.getDescription().equals(""))
            errMsg+="Activitatea nu are descriere";
        if (entity.getDuration().equals(""))
            errMsg+="Durata nu poate fi goala!";
        if (errMsg!="")
            throw new ValidatorException(errMsg);
    }

    @Override
    public void validate(Activity activity, List<String> errors) {

    }

}
