package com.backend.ecommerce.infrastructure.adapters.jpa.product.repositories;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.backend.ecommerce.domain.ports.out.product.ProductRepositoryPort;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

@Component
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {

    private final JpaProductRepository jpaProductRepository;

    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository) {
        this.jpaProductRepository = jpaProductRepository;
    }

    @Override
    public boolean deleteById(UUID productId) {
        // Optional<ProductEntity> product = jpaProductService.findById(productId);
        // if(product.isPresent()){
        //     jpaProductRepository.delete(product.get());
        // }
         jpaProductRepository.deleteById(productId);
        return false;
    }

    @Override
    public ProductEntity save(ProductEntity saveProduct) {
        // List<PriceEntity> convertedPrices = saveProduct.getPrices().stream()
        //     .map(priceModel -> {
        //         PriceEntity priceEntity = new PriceEntity();
        //         priceEntity.setCurrency(new CurrencyEntity(
        //             priceModel.getCurrency().getId(),
        //             priceModel.getCurrency().getDescription()
        //         ));
        //         priceEntity.setId(priceModel.getId());
        //         priceEntity.setValue(priceModel.getValue());
        //         return priceEntity;
        //     }).collect(Collectors.toList());

        // List<CategoryEntity> convertedCategories = saveProduct.getCategories().stream()
        //     .map(categoryModel -> new CategoryEntity(
        //         categoryModel.getId(),
        //         categoryModel.getDescription()
        //     )).collect(Collectors.toList());
        

        // CompanyEntity convertedCompany = new CompanyEntity();
        // convertedCompany.setId(saveProduct.getCompany().getId());
        // System.out.println(convertedCompany);        
        // System.out.println(saveProduct.getCompany());

        // convertedCompany.setNit(saveProduct.getCompany().getNit());
        // convertedCompany.setName(saveProduct.getCompany().getName());
        // convertedCompany.setAddress(saveProduct.getCompany().getAddress());
        // convertedCompany.setPhone(saveProduct.getCompany().getPhone());

        ProductEntity productEntity = new ProductEntity(
            saveProduct.getCode(),
            saveProduct.getName(),
             saveProduct.getCharacteristic(), 
             saveProduct.getQuantity(), null, saveProduct.getCategories(), saveProduct.getCompany());
        
     
        return  jpaProductRepository.save(productEntity);
    }
}