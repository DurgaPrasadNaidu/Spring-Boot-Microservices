package com.dailycodebuffer.ProductService.Service;

import com.dailycodebuffer.ProductService.Entity.Product;
import com.dailycodebuffer.ProductService.Exception.ProductServiceCustomException;
import com.dailycodebuffer.ProductService.Model.ProductRequest;
import com.dailycodebuffer.ProductService.Model.ProductResponse;
import com.dailycodebuffer.ProductService.Repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);

        log.info("Product Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {

        log.info("Get product by id{}:" +" ",productId);
        Product product=productRepository.findById(productId).
                orElseThrow(() -> new
                        ProductServiceCustomException("Product with given id is not found","PRODUCT_NOT_FOUND"));
        ProductResponse productResponse
                = new ProductResponse();

        copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
       log.info("Reducing the quantity of ordered product",productId);

       Product product=
               productRepository.
                       findById(productId).
                       orElseThrow( ()->new
                               ProductServiceCustomException("product  not found","PRODUCT_NOTFOUND")
       );

        if(product.getQuantity() < quantity) {
            throw new ProductServiceCustomException(
                    "Product does not have sufficient Quantity",
                    "INSUFFICIENT_QUANTITY"
            );
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity updated Successfully");


    }
}
