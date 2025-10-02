package com.bychuong.kemshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private double productPrice;
    private String productDescription;
    private String productImage;
    private Integer quantity;
    private Integer categoryId;
}
