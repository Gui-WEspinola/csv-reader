package io.github.guiwespinola.productcsv.entity.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    @CsvBindByName(column = "CODE")
    private String code;

    @CsvBindByName(column = "NAME")
    private String name;

    @CsvBindByName(column = "CATEGORY")
    private String category;

    @CsvBindByName(column = "PRICE")
    private BigDecimal price;

    @CsvBindByName(column = "QUANTITY")
    private Integer quantity;
}
