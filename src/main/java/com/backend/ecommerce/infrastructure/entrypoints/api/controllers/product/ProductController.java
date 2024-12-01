package com.backend.ecommerce.infrastructure.entrypoints.api.controllers.product;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ecommerce.application.repos.product.IProductRepo;
import com.backend.ecommerce.application.services.product.IProductService;
import com.backend.ecommerce.domain.models.Product;
import com.backend.ecommerce.domain.ports.in.product.dtos.ProductSaveDTO;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
public class ProductController {
    

    private final IProductService productService;
    private final IProductRepo productRepo;

    public ProductController(IProductService productService, IProductRepo productRepo) {
        this.productService = productService;
        this.productRepo = productRepo;
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProduct(@RequestBody ProductSaveDTO createDtoProduct){
        productRepo.createProduct(createDtoProduct);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByIdProduct(@PathVariable("id") UUID id){
        productRepo.deleteByIdProduct(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Product>>  getByIdProduct(@PathVariable("id") UUID id){
        return Mono.just(ResponseEntity.ok(productService.getByIdProduct(id)));
    }


    @GetMapping("/")
    public Mono<ResponseEntity<List<Product>>> getAllProducts(){
        return Mono.just(ResponseEntity.ok(productService.getAllProducts()));
    }

    @GetMapping("/health")
    public String ok() throws Exception {
        return "ok";
    }
    
    // @GetMapping(path = "/report",produces = "application/pdf")
    // public byte[] getReport() throws IOException {
    //     List<Product> listProducts =  productService.getAllProducts();
    //     return ReportPdfConfig.createReport(listProducts).toByteArray();
    // }

}
