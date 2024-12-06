package com.backend.ecommerce.application.usecases.product;


public class CompanyNotFoundException extends RuntimeException {
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
