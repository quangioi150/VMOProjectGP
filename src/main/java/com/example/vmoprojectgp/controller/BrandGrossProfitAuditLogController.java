package com.example.vmoprojectgp.controller;
import com.example.vmoprojectgp.dto.BrandGrossProfitAuditLogDTO;
import com.example.vmoprojectgp.entity.BrandGrossProfitAuditLog;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitAuditLogServiceImpl;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class BrandGrossProfitAuditLogController {
    @Autowired
    private BrandGrossProfitAuditLogServiceImpl brandGrossProfitAuditLogService;
    private BrandGrossProfitServiceImpl brandGrossProfitService;

    public BrandGrossProfitAuditLogController(BrandGrossProfitServiceImpl brandGrossProfitService) {
        this.brandGrossProfitService = brandGrossProfitService;
    }

    @GetMapping( "/brandAudits" )
    public ResponseEntity<List<BrandGrossProfitAuditLog>> get() {
        return ResponseEntity.ok().body(brandGrossProfitAuditLogService.findAllBrandAudit());
    }

    @GetMapping( "api/brands/{brandId}/gross-profit/audit-log" )
    public ResponseEntity<BrandGrossProfitAuditLogDTO> getBrandGrossProfitAuditLog(@PathVariable( "brandId" ) String brandId) {
        BrandGrossProfitAuditLogDTO brandGrossProfit = brandGrossProfitAuditLogService.getBrandGrossProfitAuditLog(brandId);
        return ResponseEntity.ok().body(brandGrossProfit);
    }
}
