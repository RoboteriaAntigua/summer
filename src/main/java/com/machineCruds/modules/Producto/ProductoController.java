package com.machineCruds.modules.Producto;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

        @GetMapping("/index")
        public ResponseEntity<List<ProductoEntity>> index () {
            List<ProductoEntity> productos = productoRepository.findAll();
            return ResponseEntity.ok(productos);
        }

        @GetMapping("/{id}")
        public ResponseEntity<?> show (@PathVariable long id) {

            ProductoEntity producto = productoRepository
                                        .findById(id)
                                        .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND,"No encontrado") );
            return ResponseEntity.ok(producto);
        }

        @PostMapping("/store")
        public ResponseEntity<?> store (@RequestBody ProductoRequest request) {

            if(!request.validate()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request.getMessage()); 
            }

            try {
                ProductoEntity newProducto = new ProductoEntity( request.getName(), request.getPrice()); 
                ProductoEntity createdProducto = productoRepository.save(newProducto);  
                return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
            }
        }

        @PutMapping("/{id}")
        public ResponseEntity<?> update (@PathVariable Long id, @RequestBody ProductoRequest request) {

            ProductoEntity oldProducto = productoRepository.findById(id)
                                                        .orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"No encontrado"));
            if(!request.validate()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(request.getMessage());
            }

            try {
                oldProducto.setName(request.getName());
                oldProducto.setPrice(request.getPrice());
                productoRepository.save(oldProducto);

                return ResponseEntity.ok(oldProducto);
            } catch (Exception e) {  
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());
            }            
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete (@PathVariable long id) {
            Optional<ProductoEntity> optionalProducto = productoRepository.findById(id);

            if (!optionalProducto.isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
            }

            try {
                productoRepository.deleteById(id);
                return ResponseEntity.ok("Resource Deleted");

            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getCause());

            }
        }
           
    }