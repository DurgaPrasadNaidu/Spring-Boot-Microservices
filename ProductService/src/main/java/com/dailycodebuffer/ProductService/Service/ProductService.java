package com.dailycodebuffer.ProductService.Service;
import com.dailycodebuffer.ProductService.Model.ProductRequest;
import com.dailycodebuffer.ProductService.Model.ProductResponse;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);

   public  ProductResponse getProductById(long productId);

   public void reduceQuantity(long productId, long quantity);
}
