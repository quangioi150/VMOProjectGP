package com.example.vmoprojectgp.service;

import com.example.vmoprojectgp.dto.BrandGrossProfitDTO;
import com.example.vmoprojectgp.entity.BrandGrossProfit;

import java.util.List;

public interface BrandGrossProfitService {
    BrandGrossProfitDTO createBrandGrossProfit(BrandGrossProfitDTO brandGrossProfitDTO);

    List<BrandGrossProfit> findAllBrand();

    BrandGrossProfitDTO getBrandGrossProfit(String brandId);

    BrandGrossProfitDTO updateBrandGrossProfit(String brandId, BrandGrossProfitDTO brandGrossProfitDTO);
}
