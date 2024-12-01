package com.backend.ecommerce.infrastructure.config.product;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.backend.ecommerce.application.repos.product.ProductRepo;
import com.backend.ecommerce.application.usecases.product.CreateProductUseCaseImpl;
import com.backend.ecommerce.application.usecases.product.DeleteProductUseCaseImpl;
import com.backend.ecommerce.domain.ports.out.category.CategoryServicePort;
import com.backend.ecommerce.domain.ports.out.company.CompanyServicePort;
import com.backend.ecommerce.domain.ports.out.currency.CurrencyServicePort;
import com.backend.ecommerce.domain.ports.out.price.PriceRepositoryPort;
import com.backend.ecommerce.domain.ports.out.product.ProductRepositoryPort;
import com.backend.ecommerce.infrastructure.adapters.jpa.category.repositories.JpaCategoryRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.category.services.JpaCategoryServiceAdapter;
import com.backend.ecommerce.infrastructure.adapters.jpa.company.repositories.JpaCompanyRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.company.services.JpaCompanyServiceAdapter;
import com.backend.ecommerce.infrastructure.adapters.jpa.currency.repositories.JpaCurrencyRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.currency.services.JpaCurrencyService;
import com.backend.ecommerce.infrastructure.adapters.jpa.price.repositories.JpaPriceRepository;
import com.backend.ecommerce.infrastructure.adapters.jpa.price.repositories.JpaPriceRepositoryAdapter;
import com.backend.ecommerce.infrastructure.adapters.jpa.product.repositories.JpaProductRepositoryAdapter;

@Configuration
public class ApplicationRepoConfig {

    @Bean
    public ProductRepo productRepo(
        @Qualifier("productRepositoryPort") ProductRepositoryPort productRepoPort,
        @Qualifier("categoryRepositoryPort") CategoryServicePort categoryServicePort,
        @Qualifier("companyRepositoryPort") CompanyServicePort companyServicePort,
        @Qualifier("priceRepositoryPort") PriceRepositoryPort priceRepositoryPort,
        @Qualifier("currencyRepositoryPort") CurrencyServicePort currencyServicePort,
        CreateProductUseCaseImpl createProductUseCaseImpl, 
        DeleteProductUseCaseImpl deleteProductUseCaseImp ) {
        
        return new ProductRepo(
            new CreateProductUseCaseImpl(productRepoPort, categoryServicePort, companyServicePort, priceRepositoryPort, currencyServicePort),
            new DeleteProductUseCaseImpl(productRepoPort)    
        );
    }

    @Primary
    @Bean
    public ProductRepositoryPort productRepositoryPort(JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
         return jpaProductRepositoryAdapter;
    }
    @Bean
    public JpaCategoryServiceAdapter categoryRepositoryPort(JpaCategoryRepository jpaCategoryRepository) {
        return new JpaCategoryServiceAdapter(jpaCategoryRepository);
    }
    @Bean
    public JpaCompanyServiceAdapter companyRepositoryPort(JpaCompanyRepository jpaCompanyRepository) {
        return new JpaCompanyServiceAdapter(jpaCompanyRepository);
    }
    @Bean
    public JpaPriceRepositoryAdapter priceRepositoryPort(JpaPriceRepository priceRepositoryPort) {
        return new JpaPriceRepositoryAdapter(priceRepositoryPort);
    }
    @Bean
    public JpaCurrencyService currencyRepositoryPort(JpaCurrencyRepository jpaCurrencyRepository) {
        return new JpaCurrencyService(jpaCurrencyRepository);
    }

    @Bean
    public DeleteProductUseCaseImpl deleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        return new DeleteProductUseCaseImpl(productRepositoryPort);
    }    
    @Bean
    public CreateProductUseCaseImpl createProductUseCaseImpl(
        ProductRepositoryPort productRepoPort,
        CategoryServicePort categoryServicePort,
        CompanyServicePort companyServicePort,
        PriceRepositoryPort priceRepositoryPort,
        CurrencyServicePort currencyServicePort) {
        return new CreateProductUseCaseImpl(productRepoPort, categoryServicePort,companyServicePort, priceRepositoryPort, currencyServicePort);
    }

}
