package com.backend.ecommerce.application.usecases.product.dtos;


public class ProductRequestDto {
    
    private Long productId;
    private String companyId;

    private String name;
    private Integer price;

    private String code;
    private String characteristic;
    public ProductRequestDto(){

    }
    
    public ProductRequestDto(Long productId, String companyId, String name, Integer price, String code, String characteristic) {
        this.productId = productId;
        this.companyId = companyId;
        this.name = name;
        this.price = price;
        this.code = code;
        this.characteristic = characteristic;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getCharacteristic() {
        return characteristic;
    }
    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }
}
