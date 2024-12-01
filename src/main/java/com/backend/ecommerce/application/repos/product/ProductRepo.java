package com.backend.ecommerce.application.repos.product;

import java.util.UUID;

import com.backend.ecommerce.domain.ports.in.product.dtos.ProductSaveDTO;
import com.backend.ecommerce.domain.ports.in.product.repo.CreateProductRepo;
import com.backend.ecommerce.domain.ports.in.product.repo.DeleteProductRepo;

public class ProductRepo implements IProductRepo {

    private final CreateProductRepo createProductRepo;
    private final DeleteProductRepo deleteProductRepo;

    public ProductRepo(CreateProductRepo createProductRepo, 
            DeleteProductRepo deleteProductRepo) {
        this.createProductRepo = createProductRepo;
        this.deleteProductRepo = deleteProductRepo;
    }

    @Override
    public void createProduct(ProductSaveDTO product) {
        createProductRepo.createProduct(product);
    }

    @Override
    public Boolean deleteByIdProduct(UUID productId) {
        return deleteProductRepo.deleteProduct(productId);
    }


}
