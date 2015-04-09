import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class PhoneUtilImplTest {

    @Test
    public void sanitize_non_valid_number_in_se_formats() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();
        String validPhoneNumber = "+46721234567";

        String sanitizedNumber = phoneUtil.getSanitizedPhoneNumber("0721234567", "SE");
        assertTrue(sanitizedNumber.equals(validPhoneNumber));

        sanitizedNumber = phoneUtil.getSanitizedPhoneNumber("+46721234567", "SE");
        assertTrue(sanitizedNumber.equals(validPhoneNumber));

        sanitizedNumber = phoneUtil.getSanitizedPhoneNumber("+460721234567", "SE");
        assertTrue(sanitizedNumber.equals(validPhoneNumber));

        sanitizedNumber = phoneUtil.getSanitizedPhoneNumber("00460721234567", "SE");
        assertTrue(sanitizedNumber.equals(validPhoneNumber));
    }

    @Test
    public void is_a_valid_mobile_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertTrue(phoneUtil.isMobileNumber("0721234567", "SE"));
        assertTrue(phoneUtil.isMobileNumber("+46721234567", "SE"));
        assertTrue(phoneUtil.isMobileNumber("+460721234567", "SE"));

        assertTrue(phoneUtil.isMobileNumber(phoneUtil.createExampleMobileNumber("SE"), "SE"));
        assertTrue(phoneUtil.isMobileNumber(phoneUtil.createExampleMobileNumber("DE"), "DE"));
        assertTrue(phoneUtil.isMobileNumber(phoneUtil.createExampleMobileNumber("IT"), "IT"));
    }

    @Test
    public void is_not_a_valid_mobile_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertFalse(phoneUtil.isMobileNumber("031272727", "SE"));
        assertFalse(phoneUtil.isMobileNumber("+4631272727", "SE"));
        assertFalse(phoneUtil.isMobileNumber("+46031272727", "SE"));

        assertFalse(phoneUtil.isMobileNumber(phoneUtil.createExampleFixedNumber("SE"), "SE"));
        assertFalse(phoneUtil.isMobileNumber(phoneUtil.createExampleFixedNumber("DE"), "DE"));
        assertFalse(phoneUtil.isMobileNumber(phoneUtil.createExampleFixedNumber("IT"), "IT"));
    }

    @Test
    public void is_a_valid_fixed_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertTrue(phoneUtil.isFixedNumber("031272727", "SE"));
        assertTrue(phoneUtil.isFixedNumber("+4631272727", "SE"));
        assertTrue(phoneUtil.isFixedNumber("+46031272727", "SE"));
        assertTrue(phoneUtil.isFixedNumber("+390212345678", "IT"));

        assertTrue(phoneUtil.isFixedNumber(phoneUtil.createExampleFixedNumber("SE"), "SE"));
        assertTrue(phoneUtil.isFixedNumber(phoneUtil.createExampleFixedNumber("DE"), "DE"));
    }

    @Test
    public void is_a_valid_fixed_number_or_mobile_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertTrue(phoneUtil.isFixedOrMobileNumber("+4540123456", "DK"));
        assertTrue(phoneUtil.isFixedOrMobileNumber("40123456", "DK"));
    }

    @Test
    public void is_a_valid_phone_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertTrue(phoneUtil.isValidPhoneNumber("031272727", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("0046031272727", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("004631272727", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("+4631272727", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("+46031272727", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("+390212345678", "IT"));
        assertTrue(phoneUtil.isValidPhoneNumber("0721234567", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("+46721234567", "SE"));
        assertTrue(phoneUtil.isValidPhoneNumber("+460721234567", "SE"));
    }

    @Test
    public void is_a_valid_international_phone_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertTrue(phoneUtil.isValidInternationalPhoneNumber("+46721234567"));
        assertTrue(phoneUtil.isValidInternationalPhoneNumber("+460721234567"));
        assertTrue(phoneUtil.isValidInternationalPhoneNumber("+4631272727"));
        assertTrue(phoneUtil.isValidInternationalPhoneNumber("+46031272727"));
        assertTrue(phoneUtil.isValidInternationalPhoneNumber("+4540123456"));
    }

    @Test
    public void is_not_a_valid_international_phone_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertFalse(phoneUtil.isValidInternationalPhoneNumber("031272727"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("0046031272727"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("004631272727"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("0721234567"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+12"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+46"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+463"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+4631"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+46312"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+463127"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+4631272"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+46312727"));
        assertFalse(phoneUtil.isValidInternationalPhoneNumber("+463127272"));
    }

    @Test
    public void get_country_letter_language_code_from_phone_number() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();

        assertTrue(phoneUtil.getCountryISO2FromPhoneNumber("+46721234567").equals("SE"));
        assertTrue(phoneUtil.getCountryISO2FromPhoneNumber("+460721234567").equals("SE"));
        assertTrue(phoneUtil.getCountryISO2FromPhoneNumber("+4631272727").equals("SE"));
        assertTrue(phoneUtil.getCountryISO2FromPhoneNumber("+46031272727").equals("SE"));
        assertTrue(phoneUtil.getCountryISO2FromPhoneNumber("+4540123456").equals("DK"));
    }

    @Test
    public void createExampleNumber() {
        PhoneUtilImpl phoneUtil = new PhoneUtilImpl();
        System.out.println("Example phone numbers:");
        System.out.println("----------------------\n");
        System.out.println("Sweden:");
        System.out.println("(Fixed) " + phoneUtil.createExampleFixedNumber("SE"));
        System.out.println("(Mobile) " + phoneUtil.createExampleMobileNumber("SE"));
        System.out.println("\nNorway:");
        System.out.println("(Fixed) " + phoneUtil.createExampleFixedNumber("NO"));
        System.out.println("(Mobile) " + phoneUtil.createExampleMobileNumber("NO"));
        System.out.println("\nGermany:");
        System.out.println("(Fixed) " + phoneUtil.createExampleFixedNumber("DE"));
        System.out.println("(Mobile) " + phoneUtil.createExampleMobileNumber("DE"));
        System.out.println("\nItaly:");
        System.out.println("(Fixed) " + phoneUtil.createExampleFixedNumber("IT"));
        System.out.println("(Mobile) " + phoneUtil.createExampleMobileNumber("IT"));
        System.out.println("\nRussia:");
        System.out.println("(Fixed) " + phoneUtil.createExampleFixedNumber("RU"));
        System.out.println("(Mobile) " + phoneUtil.createExampleMobileNumber("RU"));
        System.out.println("\nKazakhstan:");
        System.out.println("(Fixed) " + phoneUtil.createExampleFixedNumber("KZ"));
        System.out.println("(Mobile) " + phoneUtil.createExampleMobileNumber("KZ"));
    }
}