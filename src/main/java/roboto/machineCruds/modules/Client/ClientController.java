package roboto.machineCruds.modules.Client;

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
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/index")
    public ResponseEntity<List<ClientEntity>> index() {
        return ResponseEntity.ok(clientService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> show(@PathVariable long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("/store")
    public ResponseEntity<ClientEntity> store(@Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.createClient(clientDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.update(clientService.getClientById(id), clientDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        clientService.getClientById(id);
        clientService.delete(id);
        return ResponseEntity.ok("Resource Deleted");
    }

}
