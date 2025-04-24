package com.api_market.api.Controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import com.api_market.api.DTO.DadosCadastroPersonagem;
import com.api_market.api.DTO.DadosListagemPersonagem;
import com.api_market.api.Model.Personagem;
import com.api_market.api.Repository.personagemRepository;


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

}
