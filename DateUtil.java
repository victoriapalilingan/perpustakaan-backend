package PerpustakaanOOP;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class DateUtil {
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static boolean isValid(String text) {
        try {
            LocalDate.parse(text, FMT);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDate parse(String text) {
        return LocalDate.parse(text, FMT);
    }

    public static String formatDate(LocalDate date) {
        return date.format(FMT);
    }
}
