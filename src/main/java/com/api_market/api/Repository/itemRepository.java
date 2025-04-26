package com.api_market.api.Repository;

import com.api_market.api.Model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface itemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {
}
