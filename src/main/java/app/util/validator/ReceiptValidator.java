package app.util.validator;

import app.model.Receipt;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ReceiptValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Receipt.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
