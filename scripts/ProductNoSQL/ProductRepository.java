package roboto.machineCruds.modules.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, Long> {
    
}


