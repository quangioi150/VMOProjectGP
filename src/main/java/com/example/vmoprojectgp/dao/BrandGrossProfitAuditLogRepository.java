package com.example.vmoprojectgp.dao;

import com.example.vmoprojectgp.entity.BrandGrossProfitAuditLog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BrandGrossProfitAuditLogRepository extends MongoRepository<BrandGrossProfitAuditLog,String> {
    Optional<BrandGrossProfitAuditLog> findBrandGrossProfitAuditLogByBrandId(String brandId);

}
