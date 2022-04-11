package com.zyapaar.api.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResoursourceNotFound extends  RuntimeException{

    String resourceName;
    String fieldName;
    String fieldValue;

    public ResoursourceNotFound(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
