package roboto.machineCruds.modules.Llave;

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


@RestController
@RequestMapping("/api/llave")
public class LlaveController {

    @Autowired
    private LlaveService llaveService;

    @GetMapping("/index")
    public ResponseEntity<List<LlaveEntity>> index() {
        return ResponseEntity.ok(llaveService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LlaveEntity> show(@PathVariable long id) {
        return ResponseEntity.ok(llaveService.getLlaveById(id));
    }

    @PostMapping("/store")
    public ResponseEntity<LlaveEntity> store(@Valid @RequestBody LlaveDTO llaveDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(llaveService.createLlave(llaveDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody LlaveDTO llaveDTO) {
        return ResponseEntity.ok(llaveService.update(llaveService.getLlaveById(id), llaveDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        llaveService.getLlaveById(id);
        llaveService.delete(id);
        return ResponseEntity.ok("Resource Deleted");
    }

}
