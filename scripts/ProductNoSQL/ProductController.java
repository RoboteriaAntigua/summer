package roboto.machineCruds.modules.Product;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;


@RestController
@RequestMapping("/api/product")
@ConditionalOnProperty(
        prefix = "modules",         // The section in your YAML
        name = "product",            // The specific key
        havingValue = "true",       // The value to match
        matchIfMissing = false      // If 'modules.product' is not present, disable this bean
)
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public ResponseEntity<List<ProductEntity>> index() {
        return ResponseEntity.ok(productService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> show(@PathVariable String id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/store")
    public ResponseEntity<ProductEntity> store(@Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @Valid @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.update(productService.getProductById(id), productDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        productService.getProductById(id);
        productService.delete(id);
        return ResponseEntity.ok("Resource Deleted");
    }

}