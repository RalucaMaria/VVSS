package agenda.validator;

import agenda.model.base.Contact;

import java.util.List;

public class ValidatorContact implements Validator<Contact>{

    public void validateContact(Contact entity) throws ValidatorException {
        String errMsg="";
        if (entity.getName().equals(""))
            errMsg+="Contactul nu are nume";
        if (entity.getAddress().equals(""))
            errMsg+="Contactul nu are adresa";
        if (entity.getTelefon().equals(""))
            errMsg+="Contactul nu are nr de telefon";
        if (errMsg!="")
            throw new ValidatorException(errMsg);
    }

    @Override
    public void validate(Contact contact, List<String> errors) {

    }

}
