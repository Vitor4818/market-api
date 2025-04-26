package com.api_market.api.Controller;

import com.api_market.api.DTO.DadosAtualizarPersonagem;
import com.api_market.api.DTO.PersonagemFilter;
import com.api_market.api.specification.personagemSpecification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.api_market.api.DTO.DadosCadastroPersonagem;
import com.api_market.api.DTO.DadosListagemPersonagem;
import com.api_market.api.Model.Personagem;
import com.api_market.api.Repository.personagemRepository;

import java.util.List;


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
    public Page<DadosListagemPersonagem> listarPersonagem(Pageable paginacao){
    return repository.findAll(paginacao).map(DadosListagemPersonagem::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPersonagem(@RequestBody DadosAtualizarPersonagem dados){
    var personagem = repository.getReferenceById(dados.id());
    personagem.atualizarDados(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirPersonagem(@PathVariable Long id){
    repository.deleteById(id);
    }


    @GetMapping("/buscar")
    public List<Personagem> buscarPersonagem(PersonagemFilter filter){
        Specification <Personagem> spec = personagemSpecification.withFilter(filter);
        return repository.findAll(spec);

    }
}
