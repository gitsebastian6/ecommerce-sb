package com.backend.ecommerce.application.services.product;

import java.util.List;
import java.util.UUID;

import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.domain.ports.in.product.service.GetAllProductsService;
import com.backend.ecommerce.domain.ports.in.product.service.GetByIdProductService;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;
public class ProductService implements IProductService {

    private final GetByIdProductService getByIdProductService;
    private final GetAllProductsService getAllProductsService;


    public ProductService(GetByIdProductService getByIdProductService, GetAllProductsService getAllProductsService) {
        this.getByIdProductService = getByIdProductService;
        this.getAllProductsService = getAllProductsService;
    }

    @Override
    public List<Product> getAllProducts() {
        return getAllProductsService.getAllProducts();
    }

    @Override
    public Product getByIdProduct(UUID productId) {
        return getByIdProductService.getByIdProduct(productId).stream()
                    .map(ProductEntity::toDomainModel).findFirst().get();


        // return jpaProductService.findAll().stream()
        //         .map(ProductEntity::toDomainModel)
        //         .collect(Collectors.toList());


        // return new Product(
        //         product.getId(),
        //         product.getName(),
        //         product.getCharacteristic(),
        //         product.getQuantity(),
        //         product.getPrices()
        //         productId, null, null, null, null, null, null, null)
    }
    
}
