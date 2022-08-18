package com.example.vmoprojectgp.service;

import com.example.vmoprojectgp.dao.BrandGrossProfitAuditLogRepository;
import com.example.vmoprojectgp.dto.*;
import com.example.vmoprojectgp.entity.*;
import com.example.vmoprojectgp.exception.ManagementException;
import com.example.vmoprojectgp.mapper.BrandGrossProfitAuditLogMapper;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitAuditLogServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
public class BrandGrossProfitAuditLogServiceTest {
    @Mock
    BrandGrossProfitAuditLogRepository auditLogRepository;
    @Mock
    BrandGrossProfitAuditLogMapper auditLogMapper;
    MockMvc mockMvc;
    @Spy
    @InjectMocks
    BrandGrossProfitAuditLogServiceImpl auditLogService;
    String email = "vmo.holding@gmail.com";
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
        this.mockMvc = MockMvcBuilders.standaloneSetup(auditLogService)
                .build();
    }

    @Test( expected = ManagementException.class )
    public void testGetBGP_throwException() {
        when(auditLogRepository.findBrandGrossProfitAuditLogByBrandId(anyString())).thenReturn(null);
        auditLogService.getBrandGrossProfitAuditLog("1234567");
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

    private BrandGrossProfitAuditLogDTO buildAuditLogDTO() {
        BrandGrossProfitAuditLogDTO auditLogDTO = new BrandGrossProfitAuditLogDTO();
        BrandGrossProfit brandGrossProfit = buildBrandGrossProfit();
        auditLogDTO.setEvent("CREATE");
        auditLogDTO.setBrandId(brandGrossProfit.getBrandId());
        auditLogDTO.setAfter(auditLogDTO.getAfter());
        return auditLogDTO;
    }
}
