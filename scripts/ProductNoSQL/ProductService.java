package roboto.machineCruds.modules.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roboto.machineCruds.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> list() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with ID " + id + " not found"));
    }

    public ProductEntity createProduct(ProductDTO productDTO) {
        return productRepository.save(productDTO.mapToEntity());
    }

    public ProductEntity update(ProductEntity oldProduct, ProductDTO productDTO) {
//        oldProduct.setName(productDTO.getName());
//        oldProduct.setPrice(productDTO.getPrice());
        return productRepository.save(oldProduct);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
