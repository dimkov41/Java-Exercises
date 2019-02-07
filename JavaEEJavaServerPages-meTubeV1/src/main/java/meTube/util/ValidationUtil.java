package meTube.util;

import javax.validation.Validation;

public class ValidationUtil {
    private javax.validation.Validator validator;

    public ValidationUtil() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public <M> boolean isValid(M model){
        return this.validator.validate(model).size() == 0;
    }
}
