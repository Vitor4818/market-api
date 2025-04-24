package com.api_market.api.Controller;

import com.api_market.api.DTO.DadosAtualizarItem;
import com.api_market.api.DTO.DadosCadstroItem;
import com.api_market.api.DTO.DadosListagemItem;
import com.api_market.api.Model.Item;
import com.api_market.api.Repository.itemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class itemController {

    @Autowired
    private itemRepository repository;

    @PostMapping
    public void cadastrarItem(@RequestBody  DadosCadstroItem dados){
        repository.save(new Item(dados));
    }

    @GetMapping
    public Page<DadosListagemItem> listarItem(Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemItem::new);
    }

    @PutMapping
    @Transactional
    public void atualizarItem(@RequestBody  DadosAtualizarItem dados){
        var item = repository.getReferenceById(dados.id());
        item.atualizarItem(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirItem(@PathVariable Long id){
        repository.deleteById(id);
    }

}
