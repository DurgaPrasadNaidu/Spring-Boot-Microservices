package com.dailycodebuffer.ProductService.Model;

import lombok.Data;

@Data
public class ProductRequest {
    private long price;

    private long quantity;

    private String name;
}
