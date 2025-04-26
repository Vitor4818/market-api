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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item")
public class itemController {

    @Autowired
    private itemRepository repository;

    @PostMapping
    public ResponseEntity<Void> cadastrarItem(@RequestBody @Valid DadosCadstroItem dados) {
        var item = new Item(dados);
        repository.save(item);
        return ResponseEntity.created(URI.create("/item/" + item.getId())).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemItem>> listarItem(Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemItem::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizarItem(@RequestBody @Valid DadosAtualizarItem dados) {
        var item = repository.getReferenceById(dados.id());
        item.atualizarItem(dados);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirItem(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Item>> buscarItem(ItemFilter filter) {
        Specification<Item> spec = ItemSpecification.withFilters(filter);
        var itens = repository.findAll(spec);
        return ResponseEntity.ok(itens);
    }
}
