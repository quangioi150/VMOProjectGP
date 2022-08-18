package com.example.vmoprojectgp.service.impl;
import com.example.vmoprojectgp.dao.BrandGrossProfitAuditLogRepository;
import com.example.vmoprojectgp.dao.BrandGrossProfitRepository;
import com.example.vmoprojectgp.dto.BrandGrossProfitDTO;
import com.example.vmoprojectgp.entity.BrandGrossProfit;
import com.example.vmoprojectgp.entity.BrandGrossProfitAuditLog;
import com.example.vmoprojectgp.exception.Errors;
import com.example.vmoprojectgp.exception.ManagementException;
import com.example.vmoprojectgp.mapper.BrandGrossProfitMapper;
import com.example.vmoprojectgp.mapper.BrandGrossProfitMapperImpl;
import com.example.vmoprojectgp.service.BrandGrossProfitService;
import com.example.vmoprojectgp.validation.ValidatorHandler;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BrandGrossProfitServiceImpl implements BrandGrossProfitService {
    @Autowired
    private BrandGrossProfitAuditLogRepository brandGrossProfitAuditLogRepository;

    @Autowired
    private BrandGrossProfitRepository brandGrossProfitRepository;

    private BrandGrossProfitMapper brandGrossProfitMapper = new BrandGrossProfitMapperImpl();

    @Override
    public BrandGrossProfitDTO createBrandGrossProfit(BrandGrossProfitDTO brandGrossProfitDTO) {
        validBrandGrossProfitDTO(brandGrossProfitDTO);
        BrandGrossProfit brandGrossProfit = brandGrossProfitMapper.toEntity(brandGrossProfitDTO);
        BrandGrossProfitAuditLog brandGrossProfitAuditLog = new BrandGrossProfitAuditLog();
        brandGrossProfitAuditLog.setBrandId(brandGrossProfit.getBrandId());
        brandGrossProfitAuditLog.setEvent("CREATE");
        brandGrossProfitAuditLog.setBefore(brandGrossProfit.getBefore());
        brandGrossProfitAuditLog.setAfter(brandGrossProfit.getAfter());
        brandGrossProfitAuditLogRepository.save(brandGrossProfitAuditLog);
        brandGrossProfitRepository.save(brandGrossProfit);
        return brandGrossProfitDTO;
    }

    private boolean validBrandGrossProfitDTO(BrandGrossProfitDTO brandGrossProfitDTO) {
        List<Errors> errorsList = new ArrayList<>();
        if (!ValidatorHandler.validateBrandId(brandGrossProfitDTO.getBrandId())) {
            errorsList.add(new Errors("GP-001", "brand id not found in brand content type"));
        }

        if (!ValidatorHandler.ValidateListEmail(brandGrossProfitDTO.getSettlementReportEmails())) {
            errorsList.add(new Errors("GP-003", "settlement report email is incorrect email format"));
        }
        if (!ValidatorHandler.ValidateListEmail(brandGrossProfitDTO.getDailyReportEmails())) {
            errorsList.add(new Errors("GP-004", "daily report email is incorrect email format"));
        }
        if (!ValidatorHandler.ValidateEffectiveDate(brandGrossProfitDTO.getGrossProfit().getEffectiveDate(), brandGrossProfitDTO.getGrossProfit().getExpiredDate())) {
            errorsList.add(new Errors("GP-005", "effectiveDate must be before expiredDate"));
        }
        if (!ValidatorHandler.isEquals(brandGrossProfitDTO)) {
            errorsList.add(new Errors("GP-006", "Total value in sections must equal to percent"));
        }
        if (BrandIdExists(brandGrossProfitDTO.getBrandId()) || Strings.isNullOrEmpty(brandGrossProfitDTO.getBankCode())) {
            errorsList.add(new Errors("GP-007", "Gross profit for brand id already exist. Cannot be create"));
        }
        if (errorsList.size() > 0) {
            throw new ManagementException(errorsList, "error");
        }
        return true;
    }

    @Transactional
    public Optional<BrandGrossProfit> findByBrandId(String brandId) {
        return brandGrossProfitRepository.findByBrandId(brandId);
    }

    public boolean BrandIdExists(String brandId) {
        return findByBrandId(brandId).isPresent();
    }

    @Override
    public List<BrandGrossProfit> findAllBrand() {
        return brandGrossProfitRepository.findAll();
    }

    @Override
    public BrandGrossProfitDTO getBrandGrossProfit(@PathVariable( "brandId" ) String brandId) {
        BrandGrossProfit brandGrossProfit = brandGrossProfitRepository.findByBrandId(brandId).get();
        brandGrossProfit.setGrossProfit(brandGrossProfit.getGrossProfit());
        return brandGrossProfitMapper.toDTO(brandGrossProfit);
    }

    @Override
    public BrandGrossProfitDTO updateBrandGrossProfit(@PathVariable( "brandId" ) String brandId, @RequestBody BrandGrossProfitDTO brandGrossProfitDTO) {
        BrandGrossProfitAuditLog brandGrossProfitAuditLog = new BrandGrossProfitAuditLog();
        brandGrossProfitAuditLog.setEvent("UPDATE");
        BrandGrossProfit brandGrossProfit = brandGrossProfitRepository.findByBrandId(brandId).get();
        brandGrossProfitAuditLog.setAfter(brandGrossProfit.getAfter());
        BrandGrossProfit brandGrossProfitUpdate = brandGrossProfitMapper.toEntity(brandGrossProfitDTO);
        brandGrossProfitAuditLog.setBefore(brandGrossProfit.getBefore());
        brandGrossProfitUpdate.setId(brandGrossProfit.getId());
        brandGrossProfitAuditLog.setId(brandGrossProfit.getId());
        brandGrossProfitAuditLogRepository.save(brandGrossProfitAuditLog);
        brandGrossProfitRepository.save(brandGrossProfitUpdate);
        return brandGrossProfitDTO;
    }

}
