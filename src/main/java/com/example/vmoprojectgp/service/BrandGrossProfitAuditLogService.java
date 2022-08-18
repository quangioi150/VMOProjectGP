package com.example.vmoprojectgp.service;

import com.example.vmoprojectgp.dto.BrandGrossProfitAuditLogDTO;
import com.example.vmoprojectgp.entity.BrandGrossProfitAuditLog;

import java.util.List;

public interface BrandGrossProfitAuditLogService {
    List<BrandGrossProfitAuditLog> findAllBrandAudit();
    BrandGrossProfitAuditLogDTO getBrandGrossProfitAuditLog(String brandId);
}
