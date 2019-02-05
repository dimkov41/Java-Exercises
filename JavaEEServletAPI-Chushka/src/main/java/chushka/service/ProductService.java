package chushka.service;

import chushka.domain.models.service.ProductServiceModel;
import chushka.domain.models.view.ProductViewModel;

import java.util.List;

public interface ProductService{
    void save(ProductServiceModel product);

    List<ProductViewModel> getAllProducts();

    ProductViewModel findByName(String name);
}
