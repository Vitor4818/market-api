package personagem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personagem")
public class personagemController {

    @Autowired
    private personagemRepository repository;

@PostMapping
@Transactional
    public void cadastrarPersonagem(@RequestBody DadosCadastroPersonagem dados){
    repository.save(new Personagem(dados));
}

@GetMapping
    public Page<Personagem> listarPersonagem(Pageable paginacao){
    return repository.findAll(paginacao).map(Personagem::new);
    }

}
