package io.github.guiwespinola.productcsv.repository;

import io.github.guiwespinola.productcsv.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCodeIgnoreCase(String code);
}
