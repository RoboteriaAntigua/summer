package roboto.machineCruds.modules.Llave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import roboto.machineCruds.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class LlaveService {

    @Autowired
    private LlaveRepository llaveRepository;

    public List<LlaveEntity> list() {
        return llaveRepository.findAll();
    }

    public LlaveEntity getLlaveById(long id) {
        return llaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Llave with ID " + id + " not found"));
    }

    public LlaveEntity createLlave(LlaveDTO llaveDTO) {
        return llaveRepository.save(llaveDTO.mapToEntity());
    }

    public LlaveEntity update(LlaveEntity oldLlave, LlaveDTO llaveDTO) {
        oldLlave.setName(llaveDTO.getName());
        oldLlave.setPrice(llaveDTO.getPrice());
        return llaveRepository.save(oldLlave);
    }

    public void delete(long id) {
        llaveRepository.deleteById(id);
    }
}
