package com.backend.ecommerce.infrastructure.config.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.backend.ecommerce.application.services.product.ProductService;
import com.backend.ecommerce.application.usecases.product.GetAllProductUseCaseImpl;
import com.backend.ecommerce.application.usecases.product.GetByIdProductUseCaseImpl;
import com.backend.ecommerce.domain.ports.out.product.ProductServicePort;
import com.backend.ecommerce.infrastructure.adapters.jpa.product.services.product.JpaProductServiceAdapter;

@Configuration
public class ApplicationServiceConfig {

    @Bean
    public ProductService productService(
        @Qualifier("productServicePort") ProductServicePort productServicePort,
        GetByIdProductUseCaseImpl getByIdProductUseCaseImpl, 
        GetAllProductUseCaseImpl getAllProductUseCaseImpl) {
        
        return new ProductService(
            new GetByIdProductUseCaseImpl(productServicePort),
            new GetAllProductUseCaseImpl(productServicePort) 
        );
    
    }

    @Bean 
    ProductServicePort productServicePort(
        JpaProductServiceAdapter jProductServiceAdapter
    ) {
        return jProductServiceAdapter;
    }

    @Bean
    public GetByIdProductUseCaseImpl getByIdProductUseCaseImpl(ProductServicePort productServicePort) {
        return new GetByIdProductUseCaseImpl(productServicePort);
    }
    @Bean
    public GetAllProductUseCaseImpl GetAllProductUseCaseImpl(ProductServicePort productServicePort) {
        return new GetAllProductUseCaseImpl(productServicePort);
    }

}
