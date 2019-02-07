package chushka.repository;

import chushka.domain.entity.Product;

import java.util.List;

public interface ProductRepository extends GenericRepository<Product,Long> {
    List<Product> getAllProductsNames();
}
