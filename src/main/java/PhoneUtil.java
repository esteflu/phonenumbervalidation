
public interface PhoneUtil {

    public String getCountryISO2FromPhoneNumber(String phoneNumber);

    public String getSanitizedPhoneNumber(String phoneNumber, String countryISO2);

    public boolean isMobileNumber(String phoneNumber, String countryISO2);

    public boolean isFixedOrMobileNumber(String phoneNumber, String countryISO2);

    public boolean isFixedNumber(String phoneNumber, String countryISO2);

    public boolean isValidInternationalPhoneNumber(String phoneNumber);

    public boolean isValidPhoneNumber(String phoneNumber, String countryISO2);

}
