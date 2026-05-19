package util;

public class ValidationUtils {

    // Validate Text
    public static boolean isEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // Validate Phone Number
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{9,15}");
    }

    // Validate National ID
    public static boolean isValidNationalId(String nationalId) {
        return nationalId != null && nationalId.matches("\\d+");
    }

    // Validate Email
    public static boolean isValidEmail(String email) {
        return email != null &&
                email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Validate Positive Number
    public static boolean isPositive(double number) {
        return number > 0;
    }

    // Validate Positive Integer
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Validate Password
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 4;
    }

    // Validate Date Text
    public static boolean isValidDate(String date) {
        return date != null &&
                date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
}
// package util;

// public class ValidationUtils {

//     public static boolean isNotEmpty(String value) {
//         return value != null && !value.trim().isEmpty();
//     }

//     public static boolean isValidPhone(String phone) {
//         return phone != null && phone.matches("\\d{7,15}");
//     }

//     public static boolean isValidNationalId(String id) {
//         return id != null && id.length() >= 6;
//     }

//     public static boolean isValidLicense(String license) {
//         return license != null && license.length() >= 5;
//     }

//     public static boolean isPositive(double value) {
//         return value > 0;
//     }
// }