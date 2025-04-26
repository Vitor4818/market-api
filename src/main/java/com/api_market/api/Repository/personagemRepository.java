package com.api_market.api.Repository;

import com.api_market.api.Model.Personagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface personagemRepository extends JpaRepository <Personagem, Long>, JpaSpecificationExecutor<Personagem> {
}
