package util;

public class ValidationUtils {

    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{7,15}");
    }

    public static boolean isValidNationalId(String id) {
        return id != null && id.length() >= 6;
    }

    public static boolean isValidLicense(String license) {
        return license != null && license.length() >= 5;
    }

    public static boolean isPositive(double value) {
        return value > 0;
    }
}