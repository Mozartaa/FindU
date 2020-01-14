package org.bigdatahealth.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Result implements Serializable {


    private boolean success;

    private String message;


    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
