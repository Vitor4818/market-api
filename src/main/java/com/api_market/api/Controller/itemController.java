package com.api_market.api.Controller;

import com.api_market.api.DTO.DadosAtualizarItem;
import com.api_market.api.DTO.DadosCadstroItem;
import com.api_market.api.DTO.DadosListagemItem;
import com.api_market.api.DTO.ItemFilter;
import com.api_market.api.Model.Item;
import com.api_market.api.Repository.itemRepository;
import com.api_market.api.specification.ItemSpecification;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class itemController {

    @Autowired
    private itemRepository repository;

    @PostMapping
    public void cadastrarItem(@RequestBody @Valid DadosCadstroItem dados){
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

    @GetMapping("buscar")
    public List<Item> buscarItem(ItemFilter filter){
        Specification<Item> spec = ItemSpecification.withFilters(filter);
        return repository.findAll(spec);
    }



}
