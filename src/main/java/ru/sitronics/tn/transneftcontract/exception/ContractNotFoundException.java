package ru.sitronics.tn.transneftcontract.exception;

public class ContractNotFoundException extends RuntimeException {
    public ContractNotFoundException(String message) {
        super(message);
    }
}
