package io.github.guiwespinola.productcsv.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    private String category;

    private BigDecimal price;

    private Integer quantity;
}
