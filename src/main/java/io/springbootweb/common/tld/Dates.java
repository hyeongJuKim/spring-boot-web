package io.springbootweb.common.tld;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Dates {
    private Dates() {}

    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        if (localDateTime == null) {
            return "";
        }
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}
