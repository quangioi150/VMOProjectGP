package com.example.vmoprojectgp.controller;
import com.example.vmoprojectgp.dto.*;
import com.example.vmoprojectgp.entity.Company;
import com.example.vmoprojectgp.entity.Segments;
import com.example.vmoprojectgp.service.impl.BrandGrossProfitAuditLogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith( MockitoJUnitRunner.class )
@WebMvcTest( BrandGrossProfitAuditLogController.class )
public class BrandGrossProfitAuditLogControllerTest {
    @Mock
    BrandGrossProfitAuditLogServiceImpl brandGrossProfitAuditLogService;
    @Mock
    MockMvc mockMvc;
    @Mock
    ObjectMapper mapper = new ObjectMapper();
    @InjectMocks
    BrandGrossProfitAuditLogController brandGrossProfitAuditLogController;

    String email = "ngocquan.holding1@gmail.com";
    String email1 = "ngocquan15@gmail.com";
    ZoneId nepalZoneId = ZoneId.of("Asia/Kathmandu");
    ZoneId zoneId1 = ZoneId.of("Asia/Ho_Chi_Minh");
    ZonedDateTime effectiveDate = ZonedDateTime.of(2021, 6, 22, 0, 0, 0, 0, zoneId1);
    ZonedDateTime expiredDate = ZonedDateTime.of(1985, 12, 30, 0, 0, 0, 0, nepalZoneId);
    SegmentsDTO segmentsDTO = new SegmentsDTO("Name", 20.0);
    Segments segments = new Segments("Name", 20.0);
    List<SegmentsDTO> list = new ArrayList();
    CompanyDTO companyDTO = new CompanyDTO("VMO", "Ha Noi", "My Dinh", "IDMC 18", "Ton That thuyet", "1800");
    Company company = new Company("VMO", "Ha Noi", "My Dinh", "IDMC 18", "Ton That thuyet", "1800");
    List<String> emailList = new ArrayList<>();

    private Object List;
    private Object Segments;

    @Before
    public void setUp() {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.mockMvc = MockMvcBuilders.standaloneSetup(brandGrossProfitAuditLogController).build();
    }

    @Test
    public void testGetBGP_success() throws Exception {
        List<BrandGrossProfitAuditLogDTO> AuditLogDTOList = buildListAuditLogDTO();
        when(brandGrossProfitAuditLogService.getBrandGrossProfitAuditLog(anyString())).thenReturn((BrandGrossProfitAuditLogDTO) AuditLogDTOList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/brands/1234567/gross-profit/audit-log")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(AuditLogDTOList)))
                .andExpect(status().isOk()).andReturn();
    }

    private StatusResultMatchers status() {
        return null;
    }


    private List<BrandGrossProfitAuditLogDTO> buildListAuditLogDTO() {
        BrandGrossProfitAuditLogDTO brandAuditLogDTO = new BrandGrossProfitAuditLogDTO();
        BrandGrossProfitDTO brandGrossProfitDTO = buildBrandGrossProfitDTO();
        brandAuditLogDTO.setEvent("CREATE");
        brandAuditLogDTO.setBrandId(brandGrossProfitDTO.getBrandId());
        brandAuditLogDTO.setAfter(brandGrossProfitDTO.getAfter());
        return (List<BrandGrossProfitAuditLogDTO>) brandAuditLogDTO;
    }

    private BrandGrossProfitDTO buildBrandGrossProfitDTO() {
        emailList.add(email);
        emailList.add(email1);
        list.add(segmentsDTO);
        GrossProfitDTO grossProfitDTO = new GrossProfitDTO(20.0, effectiveDate, expiredDate, list);
        GrossProfitOldDTO grossProfitOldDTO = new GrossProfitOldDTO(20.0, effectiveDate, expiredDate, list);
        GrossProfitNewDTO grossProfitNewDTO = new GrossProfitNewDTO(20.0, effectiveDate, expiredDate, list);
        return new BrandGrossProfitDTO("62e37038152b943df9a1c648", "1234567", "Micheal", "Techcombank", "CREATE", emailList, emailList, "1234567890123", grossProfitOldDTO, grossProfitNewDTO, companyDTO, true, grossProfitDTO);
    }

}
