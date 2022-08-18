package com.example.vmoprojectgp.controller;
import com.example.vmoprojectgp.dto.BrandGrossProfitDTO;
import com.example.vmoprojectgp.entity.BrandGrossProfit;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BrandGrossProfitController {
    @Autowired
    private BrandGrossProfitServiceImpl brandGrossProfitService;

    public BrandGrossProfitController(BrandGrossProfitServiceImpl brandGrossProfitService) {
        this.brandGrossProfitService = brandGrossProfitService;
    }

    @GetMapping( "/brands" )
    public ResponseEntity<List<BrandGrossProfit>> get() {
        return ResponseEntity.ok().body(brandGrossProfitService.findAllBrand());
    }

    @PostMapping( "api/brands/{brandId}/gross-profit" )
    public ResponseEntity<BrandGrossProfitDTO> createBrandGrossProfit(@Valid @RequestBody BrandGrossProfitDTO brandGrossProfitDTO) {
        BrandGrossProfitDTO brandGrossProfit = brandGrossProfitService.createBrandGrossProfit(brandGrossProfitDTO);
        return ResponseEntity.ok().body(brandGrossProfit);
    }

    @GetMapping( "api/brands/{brandId}/gross-profit" )
    public ResponseEntity<BrandGrossProfitDTO> getBrandGrossProfit(@PathVariable( "brandId" ) String brandId) {
        return ResponseEntity.ok().body(brandGrossProfitService.getBrandGrossProfit(brandId));
    }
    @GetMapping( value = "search" )
    @ResponseBody
        public ResponseEntity<BrandGrossProfitDTO> searchBrandId(@RequestParam("brandId") String brandId) {
            return ResponseEntity.ok().body(brandGrossProfitService.getBrandGrossProfit(brandId));
        }
    @PutMapping( "api/brands/{brandId}/gross-profit" )
    public ResponseEntity<BrandGrossProfitDTO> updateBrandGrossProfit(@PathVariable( "brandId" ) String brandId, @RequestBody BrandGrossProfitDTO brandGrossProfitDTO) {
        BrandGrossProfitDTO brandGrossProfit = brandGrossProfitService.updateBrandGrossProfit(brandId, brandGrossProfitDTO);
        return ResponseEntity.ok().body(brandGrossProfitDTO);
    }

}
