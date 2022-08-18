package com.example.vmoprojectgp.validation;
import com.example.vmoprojectgp.dto.BrandGrossProfitDTO;
import com.example.vmoprojectgp.dto.SegmentsDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class ValidatorHandler {
    private static final String EMAILS = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]" + "+\\.[a-zA-Z]{2,6}$";
    private static final String BRANDID = "\\d{7}";
    private static String Effective_date = null;

    public static boolean ValidateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAILS);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean ValidateListEmail(List<String> emails) {
        for (String mail : emails) {
            if (!ValidateEmail(mail)) {
                return false;
            }
        }
        return true;
    }

    public static boolean ValidateEffectiveDate(ZonedDateTime effectiveDate, ZonedDateTime expiredDate) {
        if (expiredDate.isBefore(effectiveDate)) {
            return true;
        }
        return false;
    }

    public static boolean isEquals(BrandGrossProfitDTO brandGrossProfitDTO) {
        List<SegmentsDTO> segments = brandGrossProfitDTO.getGrossProfit().getSegments();
        double percent = brandGrossProfitDTO.getGrossProfit().getPercent();
        for (int i = 0; i <= segments.size(); i++) {
            if (segments.get(i).getValue() == percent) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean validateBrandId(String brandId) {
        Pattern pattern = Pattern.compile(BRANDID);
        Matcher matcher = pattern.matcher(brandId);
        return matcher.matches();
    }
}