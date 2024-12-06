package com.backend.ecommerce.application.usecases.product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.backend.ecommerce.domain.models.Currency;
import com.backend.ecommerce.domain.models.Price;
import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.domain.ports.in.price.dtos.PriceSaveDTO;
import com.backend.ecommerce.domain.ports.in.product.dtos.ProductSaveDTO;
import com.backend.ecommerce.domain.ports.in.product.repo.CreateProductRepo;
import com.backend.ecommerce.domain.ports.out.category.CategoryServicePort;
import com.backend.ecommerce.domain.ports.out.company.CompanyServicePort;
import com.backend.ecommerce.domain.ports.out.currency.CurrencyServicePort;
import com.backend.ecommerce.domain.ports.out.price.PriceRepositoryPort;
import com.backend.ecommerce.domain.ports.out.product.ProductRepositoryPort;
import com.backend.ecommerce.infrastructure.entities.CategoryEntity;
import com.backend.ecommerce.infrastructure.entities.CompanyEntity;
import com.backend.ecommerce.infrastructure.entities.PriceEntity;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

public class CreateProductUseCaseImpl implements CreateProductRepo{

    private final ProductRepositoryPort productRepositoryPort;
    private final CategoryServicePort categoryServicePort;
    private final CompanyServicePort companyServicePort;
    private final PriceRepositoryPort priceRepositoryPort;
    private final CurrencyServicePort currencyServicePort;


    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort,
            CategoryServicePort categoryServicePort, CompanyServicePort companyServicePort,
            PriceRepositoryPort priceRepositoryPort, CurrencyServicePort currencyServicePort) {
        this.productRepositoryPort = productRepositoryPort;
        this.categoryServicePort = categoryServicePort;
        this.companyServicePort = companyServicePort;
        this.priceRepositoryPort = priceRepositoryPort;
        this.currencyServicePort = currencyServicePort;
    }


    @Override
    public void createProduct(ProductSaveDTO saveProductDTO) {
        List<CategoryEntity> listCategories = new ArrayList<CategoryEntity>();
        List<PriceEntity> listPrices = new ArrayList<PriceEntity>();
        CompanyEntity findCompany = companyServicePort.getById(saveProductDTO.getCompanyId())
        .orElseThrow(() -> new CompanyNotFoundException("bb7f0616-9c0c-4e11-befb-1b3bdd6b7f65" + saveProductDTO.getCompanyId() + " no fue encontrada"));
        for (UUID category : saveProductDTO.getCategories()) {
            listCategories.add(categoryServicePort.getById(category).orElseThrow());
        }

        ProductEntity product = new ProductEntity(
            saveProductDTO.getCode(),
            saveProductDTO.getName(),
            saveProductDTO.getCharacteristic(),
            saveProductDTO.getQuantity(),
            listPrices,
            listCategories,
            findCompany);

        ProductEntity productSaved = productRepositoryPort.save(product);

        for (PriceSaveDTO price : saveProductDTO.getPrices()) {
            Currency currency = currencyServicePort.getById(price.getCurrencyId()).orElseThrow();
            Price priceSave = new Price(
                new UUID(0, 0),
                price.getValue(),
                currency,
                new Product(productSaved.getId(), null, null, null, null, null, null, null)
            );
            priceRepositoryPort.save(priceSave);
        }
    }

}
