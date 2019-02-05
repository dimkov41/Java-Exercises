package chushka.service;

import chushka.domain.entity.Product;
import chushka.domain.entity.enums.Type;
import chushka.domain.models.service.ProductServiceModel;
import chushka.domain.models.view.ProductViewModel;
import chushka.repository.ProductRepository;
import chushka.repository.ProductRepositoryImpl;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ModelMapper modelMapper;
    private ProductRepository productRepository;

    @Inject
    public ProductServiceImpl(ProductRepository productRepository) {
        this.modelMapper = new ModelMapper();
        this.productRepository = productRepository;
    }

    @Override
    public void save(ProductServiceModel productServiceModel) {
        Product product = this.modelMapper.map(productServiceModel,Product.class);
        product.setType(Type.valueOf(productServiceModel.getType()));
        this.productRepository.save(product);
    }

    @Override
    public List<ProductViewModel> getAllProducts() {
        List<ProductViewModel> productViewModelList = new LinkedList<>();

        this.productRepository.getAllProductsNames()
                .forEach(product -> {
                    ProductViewModel p = this.modelMapper.map(product,ProductViewModel.class);
                    productViewModelList.add(p);
                });

        return productViewModelList;
    }

    @Override
    public ProductViewModel findByName(String name) {
        if(this.productRepository.findByName(name) == null){
            return null;
        }
        ProductViewModel productViewModel = this.modelMapper.map(this.productRepository.findByName(name),ProductViewModel.class);
        return productViewModel;
    }
}
