package com.api_market.api.Controller;

import com.api_market.api.DTO.DadosCadstroItem;
import com.api_market.api.Model.Item;
import com.api_market.api.Repository.itemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class itemController {

    @Autowired
    private itemRepository repository;

    @PostMapping
    public void cadastrarItem(@RequestBody  DadosCadstroItem dados){
    repository.save(new Item(dados));
    }


}
