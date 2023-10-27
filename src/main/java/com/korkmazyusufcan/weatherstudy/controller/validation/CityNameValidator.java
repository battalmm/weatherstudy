package com.korkmazyusufcan.weatherstudy.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CityNameValidator implements ConstraintValidator<CityNameConstraint, String> {
    @Override
    public void initialize(CityNameConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cityName, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Input City Name:" + cityName);
        cityName = cityName.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        log.info("Converted City Name:" + cityName);

        boolean isValid = StringUtils.isNotBlank(cityName) && !StringUtils.isNumeric(cityName);

        if(!isValid){
            log.info("City Name Could Not Pass Validation");
            constraintValidatorContext.buildConstraintViolationWithTemplate(cityName).addConstraintViolation();
        }

        return isValid;
    }
}
