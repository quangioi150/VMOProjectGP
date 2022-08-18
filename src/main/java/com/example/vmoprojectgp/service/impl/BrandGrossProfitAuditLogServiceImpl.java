package com.example.vmoprojectgp.service.impl;
import com.example.vmoprojectgp.dao.BrandGrossProfitAuditLogRepository;
import com.example.vmoprojectgp.dto.BrandGrossProfitAuditLogDTO;
import com.example.vmoprojectgp.entity.BrandGrossProfitAuditLog;
import com.example.vmoprojectgp.mapper.BrandGrossProfitAuditLogMapper;
import com.example.vmoprojectgp.mapper.BrandGrossProfitAuditLogMapperImpl;
import com.example.vmoprojectgp.service.BrandGrossProfitAuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@Service
public class BrandGrossProfitAuditLogServiceImpl implements BrandGrossProfitAuditLogService {
    @Autowired
    private BrandGrossProfitAuditLogRepository brandGrossProfitAuditLogRepository;
    private final BrandGrossProfitAuditLogMapper brandGrossProfitAuditLogMapper = new BrandGrossProfitAuditLogMapperImpl();

    @Override
    public List<BrandGrossProfitAuditLog> findAllBrandAudit() {
        return brandGrossProfitAuditLogRepository.findAll();
    }

    @Override
    public BrandGrossProfitAuditLogDTO getBrandGrossProfitAuditLog(@PathVariable( "brandId" ) String brandId) {
        BrandGrossProfitAuditLog brandGrossProfitAuditLog = brandGrossProfitAuditLogRepository.findBrandGrossProfitAuditLogByBrandId(brandId).get();
        return brandGrossProfitAuditLogMapper.toDTO(brandGrossProfitAuditLog);
    }
}
