package com.example.vmoprojectgp.controller;
import com.example.vmoprojectgp.dao.BrandGrossProfitAuditLogRepository;
import com.example.vmoprojectgp.dao.BrandGrossProfitRepository;
import com.example.vmoprojectgp.dto.*;
import com.example.vmoprojectgp.entity.*;
import com.example.vmoprojectgp.exception.BadRequestAlertException;
import com.example.vmoprojectgp.exception.ManagementException;
import com.example.vmoprojectgp.mapper.BrandGrossProfitMapper;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitAuditLogServiceImpl;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
@WebMvcTest( BrandGrossProfitController.class )
public class BrandGrossProfitControllerTest {
    @Mock
    BrandGrossProfitMapper brandGrossProfitMapper;
    @Mock
    BrandGrossProfitRepository brandGrossProfitRepository;
    @Mock
    BrandGrossProfitAuditLogRepository brandGrossProfitAuditLogRepository;
    MockMvc mockMvc;
    @Spy
    @InjectMocks
    BrandGrossProfitServiceImpl brandGrossProfitService;
    BrandGrossProfitAuditLogServiceImpl brandGrossProfitAuditLogService;
    String email = "ngocquan.holding1@gmail.com";
    String email1 = "ngocquan15@gmail.com";
    ZoneId nepalZoneId = ZoneId.of("Asia/Kathmandu");
    ZoneId zoneId1 = ZoneId.of("Asia/Ho_Chi_Minh");
    ZonedDateTime effectiveDate = ZonedDateTime.of(2021, 6, 22, 0, 0, 0, 0, zoneId1);
    ZonedDateTime expiredDate = ZonedDateTime.of(1985, 12, 30, 0, 0, 0, 0, nepalZoneId);
    List<String> emailList = new ArrayList<>();
    SegmentsDTO segmentsDTO = new SegmentsDTO("Name", 20.0);
    Segments segments = new Segments("Name", 20.0);
    List<SegmentsDTO> list = new ArrayList();
    CompanyDTO companyDTO = new CompanyDTO("VMO", "Ha Noi", "My Dinh", "IDMC 18", "Ton That thuyet", "1800");
    Company company = new Company("VMO", "Ha Noi", "My Dinh", "IDMC 18", "Ton That thuyet", "1800");

    private Object List;
    private Object Segments;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(brandGrossProfitService).build();
    }

    @Test
    public void testCreateBrand_success() {
        BrandGrossProfitDTO brandGrossProfitDTO = buildBrandGrossProfitDTO();
        BrandGrossProfit brandGrossProfit = buildBrandGrossProfit();
        BrandGrossProfitAuditLog auditLog = buildAuditLog();
        doReturn(false).when(brandGrossProfitService).BrandIdExists(anyString());
        when(brandGrossProfitMapper.toEntity(any(BrandGrossProfitDTO.class))).thenReturn(brandGrossProfit);
        when(brandGrossProfitRepository.save(any(BrandGrossProfit.class))).thenReturn(brandGrossProfit);
        when(brandGrossProfitRepository.findByBrandId(anyString())).thenReturn(java.util.Optional.of(brandGrossProfit));
        when(brandGrossProfitAuditLogRepository.save(any())).thenReturn(auditLog);
        BrandGrossProfitDTO result = brandGrossProfitService.createBrandGrossProfit(brandGrossProfitDTO);
        Assert.assertEquals(result.getBrandId(), brandGrossProfit.getBrandId());
        Assert.assertEquals(brandGrossProfit.getTaxId(), result.getTaxId());
        Assert.assertEquals(auditLog.getEvent(), "CREATE");
    }

    @Test
    public void testUpdateBrand_success() {
        BrandGrossProfitDTO brandGrossProfitDTO = buildBrandGrossProfitDTO();
        BrandGrossProfit brandGrossProfit = buildBrandGrossProfit();
        BrandGrossProfitAuditLog auditLog = buildAuditLog();
        auditLog.setEvent("UPDATE");
        doReturn(true).when(brandGrossProfitService).BrandIdExists(anyString());
        when(brandGrossProfitMapper.toEntity(any(BrandGrossProfitDTO.class))).thenReturn(brandGrossProfit);
        when(brandGrossProfitRepository.save(any(BrandGrossProfit.class))).thenReturn(brandGrossProfit);
        when(brandGrossProfitRepository.findByBrandId(anyString())).thenReturn(java.util.Optional.of(brandGrossProfit));
        when(brandGrossProfitAuditLogRepository.save(any(BrandGrossProfitAuditLog.class))).thenReturn(auditLog);
        BrandGrossProfitDTO result = brandGrossProfitService.updateBrandGrossProfit("1234567", brandGrossProfitDTO);
        Assert.assertEquals(result.getBrandId(), brandGrossProfit.getBrandId());
        Assert.assertEquals(brandGrossProfit.getId(), result.getId());
        Assert.assertEquals(auditLog.getEvent(), "UPDATE");
    }

    @Test( expected = ManagementException.class )
    public void testUpdate_throwException() {
        BrandGrossProfitDTO brandGrossProfitDTO = buildBrandGrossProfitDTO();
        doReturn(false).when(brandGrossProfitService).BrandIdExists(anyString());
        brandGrossProfitService.updateBrandGrossProfit("1234567", brandGrossProfitDTO);
    }

    @Test( expected = BadRequestAlertException.class )
    public void testCreate_whenBrandIdIsExist_thenThrowBadRequest() {
        BrandGrossProfitDTO brandGrossProfitDTO = buildBrandGrossProfitDTO();
        doReturn(true).when(brandGrossProfitService).BrandIdExists(anyString());
        brandGrossProfitService.createBrandGrossProfit(brandGrossProfitDTO);
    }

    private BrandGrossProfit buildDateBrand() {
        GrossProfit grossProfit = new GrossProfit(20.0, Date.from(Instant.now()), Date.from(Instant.now()), (List<Segments>) segments);
        GrossProfitOld grossProfitOld = new GrossProfitOld(20.0, Date.from(Instant.now()), Date.from(Instant.now()), (List<Segments>) segments);
        GrossProfitNew grossProfitNew = new GrossProfitNew(20.0, Date.from(Instant.now()), Date.from(Instant.now()), (List<Segments>) segments);
        BrandGrossProfit brandGrossProfit = new BrandGrossProfit("62e37053152b943df9a1c64b", "5745981", "Micheal", "Techcombank", "CREATE", emailList, emailList, grossProfitOld, grossProfitNew, "1234567890123", company, true, grossProfit);
        brandGrossProfit.setBrandId("BrandId:");
        return brandGrossProfit;
    }

    private BrandGrossProfitDTO buildDateBrandDTO() {
        GrossProfitDTO grossProfitDTO = new GrossProfitDTO();
        GrossProfitOldDTO grossProfitOldDTO = new GrossProfitOldDTO(20.0, effectiveDate, expiredDate, (List<SegmentsDTO>) segmentsDTO);
        GrossProfitNewDTO grossProfitNewDTO = new GrossProfitNewDTO(20.0, effectiveDate, expiredDate, (List<SegmentsDTO>) segmentsDTO);
        BrandGrossProfitDTO dto = new BrandGrossProfitDTO("62e37053152b943df9a1c64b", "5745981", "Micheal", "Techcombank", "CREATE", emailList, emailList, "1234567890123", grossProfitOldDTO, grossProfitNewDTO, companyDTO, true, grossProfitDTO);
        dto.setBrandId("BrandId:");
        dto.setBankCode("BankCode:");
        dto.setEnabled(dto.isEnabled());
        dto.setSettlementReportEmails(dto.getSettlementReportEmails());
        dto.setDailyReportEmails(dto.getDailyReportEmails());
        dto.setGrossProfit(dto.getGrossProfit());
        dto.setCompanyInfo(dto.getCompanyInfo());
        dto.setPayeeName("PayeeName");
        return dto;
    }

    private BrandGrossProfitDTO buildBrandGrossProfitDTO() {
        emailList.add(email);
        emailList.add(email1);
        list.add(segmentsDTO);
        GrossProfitDTO grossProfitDTO = new GrossProfitDTO(20.0, effectiveDate, expiredDate, list);
        GrossProfitOldDTO grossProfitOldDTO = new GrossProfitOldDTO(20.0, effectiveDate, expiredDate, list);
        GrossProfitNewDTO grossProfitNewDTO = new GrossProfitNewDTO(20.0, effectiveDate, expiredDate, list);
        return new BrandGrossProfitDTO("62e37053152b943df9a1c64b", "5745981", "Micheal", "Techcombank", "CREATE", emailList, emailList, "1234567890123", grossProfitOldDTO, grossProfitNewDTO, companyDTO, true, grossProfitDTO);
    }

    private BrandGrossProfit buildBrandGrossProfit() {
        emailList.add(email);
        emailList.add(email);
        List<Segments> list = new ArrayList();
        list.add(segments);
        GrossProfit grossProfit = new GrossProfit(20.0, Date.from(Instant.now()), Date.from(Instant.now()), list);
        GrossProfitOld grossProfitOld = new GrossProfitOld(20.0, Date.from(Instant.now()), Date.from(Instant.now()), list);
        GrossProfitNew grossProfitNew = new GrossProfitNew(20.0, Date.from(Instant.now()), Date.from(Instant.now()), list);
        return new BrandGrossProfit("62e37053152b943df9a1c64b", "5745981", "Micheal", "Techcombank", "CREATE", emailList, emailList, grossProfitOld, grossProfitNew, "1234567890123", company, true, grossProfit);
    }

    private BrandGrossProfitAuditLog buildAuditLog() {
        BrandGrossProfitAuditLog auditLog = new BrandGrossProfitAuditLog();
        BrandGrossProfit brandGrossProfit = buildBrandGrossProfit();
        auditLog.setEvent("CREATE");
        auditLog.setBrandId(brandGrossProfit.getBrandId());
        auditLog.setAfter(brandGrossProfit.getAfter());
        return auditLog;
    }
}
