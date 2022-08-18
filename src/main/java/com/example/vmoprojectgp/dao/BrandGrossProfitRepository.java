package com.example.vmoprojectgp.dao;

import com.example.vmoprojectgp.entity.BrandGrossProfit;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BrandGrossProfitRepository extends MongoRepository<BrandGrossProfit,String> {
    Optional<BrandGrossProfit> findByBrandId(String brandId);

}

