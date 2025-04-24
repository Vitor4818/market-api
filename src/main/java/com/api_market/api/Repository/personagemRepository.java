package com.api_market.api.Repository;

import com.api_market.api.Model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface personagemRepository extends JpaRepository <Personagem, Long> {
}
