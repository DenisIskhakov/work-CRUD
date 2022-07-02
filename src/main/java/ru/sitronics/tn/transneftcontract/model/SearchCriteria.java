package ru.sitronics.tn.transneftcontract.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    private boolean or = false;

    public SearchCriteria(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }
    public SearchCriteria(){}

    public SearchCriteria(String key, String operation, Object value, boolean or) {
        this.key = key;
        this.operation = operation;
        this.value = value;
        this.or = or;
    }

    public boolean isOrPredicate() {
        return or;
    }

}