package com.api_market.api.Controller;

import com.api_market.api.DTO.DadosAtualizarPersonagem;
import com.api_market.api.DTO.PersonagemFilter;
import com.api_market.api.specification.personagemSpecification;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api_market.api.DTO.DadosCadastroPersonagem;
import com.api_market.api.DTO.DadosListagemPersonagem;
import com.api_market.api.Model.Personagem;
import com.api_market.api.Repository.personagemRepository;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personagem")
public class personagemController {

    @Autowired
    private personagemRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarPersonagem(@RequestBody @Valid DadosCadastroPersonagem dados) {
        var personagem = new Personagem(dados);
        repository.save(personagem);
        return ResponseEntity.created(URI.create("/personagem/" + personagem.getId())).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPersonagem>> listarPersonagem(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemPersonagem::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizarPersonagem(@RequestBody @Valid DadosAtualizarPersonagem dados) {
        var personagem = repository.getReferenceById(dados.id());
        personagem.atualizarDados(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirPersonagem(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Personagem>> buscarPersonagem(PersonagemFilter filter) {
        Specification<Personagem> spec = personagemSpecification.withFilter(filter);
        var personagens = repository.findAll(spec);
        return ResponseEntity.ok(personagens);
    }
}
