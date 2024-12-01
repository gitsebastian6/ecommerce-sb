package com.backend.ecommerce.infrastructure.config.order;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ecommerce.infrastructure.adapters.jpa.product.services.product.JpaProductServiceAdapter;
import com.backend.ecommerce.infrastructure.config.customer.CustomerRepo;
import com.backend.ecommerce.infrastructure.entities.CustomerEntity;
import com.backend.ecommerce.infrastructure.entities.OrderEntity;
import com.backend.ecommerce.infrastructure.entities.ProductEntity;

@Component
public class OrderBusiness {
    
    private final OrderRepo orderRepo;
    private final JpaProductServiceAdapter productRepo;
    private final CustomerRepo customerRepo;

    @Autowired
    public OrderBusiness(OrderRepo orderRepo, JpaProductServiceAdapter productRepo, CustomerRepo customerRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.customerRepo = customerRepo;
    }


    public List<OrderEntity> getOrders(){
        return orderRepo.findAll();
    }

    public OrderEntity getByIdOrder(UUID id){
        return orderRepo.findById(id).get();
    }

    public void create(SaveOrderDTO saveOrderDTO){
        List<ProductEntity> listProducts = new ArrayList<ProductEntity>();
        CustomerEntity customer = customerRepo.findById(saveOrderDTO.getCustomer()).orElseThrow();

        for (UUID price : saveOrderDTO.getProducts()) {
            listProducts.add(productRepo.getById(price).get());
        }
        OrderEntity orderEntity = new OrderEntity(
            saveOrderDTO.getDate(),
            listProducts,
            customer
        );
        orderRepo.save(orderEntity);
    }

    public void delete(UUID id){
        orderRepo.deleteById(id);
    }
}
