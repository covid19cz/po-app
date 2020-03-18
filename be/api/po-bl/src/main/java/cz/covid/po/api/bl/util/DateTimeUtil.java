package cz.covid.po.api.bl.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateTimeUtil {

    public static final ZoneId ZONE_PRAGUE = ZoneId.of("Europe/Prague");
    private static final DateTimeFormatter DMYHMS_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    private static final DateTimeFormatter DMY_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /**
     * @return current UTC time with zone
     */
    public OffsetDateTime utc() {
        return OffsetDateTime.now(ZoneOffset.UTC);
    }

    /**
     * @return current Europe/Prague time with zone
     */
    public OffsetDateTime localTime() {
        return OffsetDateTime.now(ZONE_PRAGUE);
    }

    /**
     * Format time with format: dd.MM.yyyy HH:mm:ss.
     *
     * @param time time
     *
     * @return formatted time
     */
    public String formatTime(OffsetDateTime time) {
        if (time == null) {
            return null;
        }
        return DMYHMS_FORMAT.format(toLocalDateTime(time));
    }

    /**
     * Format date with format: dd.MM.yyyy.
     *
     * @param date date
     *
     * @return formatted date
     */
    public String formatDate(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return DMY_FORMAT.format(toLocalDateTime(date));
    }

    /**
     * Format date with format: yyyy-MM-dd.
     *
     * @param date date
     *
     * @return formatted date
     */
    public String formatDateIso(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DateTimeFormatter.ISO_LOCAL_DATE.format(date);
    }

    public LocalDateTime toLocalDateTime(OffsetDateTime time) {
        if (time == null) {
            return null;
        }
        return LocalDateTime.ofInstant(time.toInstant(), ZONE_PRAGUE);
    }

    /**
     * Format date with format: dd.MM.yyyy.
     *
     * @param date date
     *
     * @return formatted date
     */
    public String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DMY_FORMAT.format(date);
    }

    /**
     * Convert {@link LocalDate} to utc {@link OffsetDateTime}.
     *
     * @param date date
     *
     * @return utc date date
     */
    public OffsetDateTime toOffsetDateTime(LocalDate date) {
        if (date == null) {
            return null;
        }

        return toOffsetDateTime(date.atStartOfDay());
    }

    public OffsetDateTime toOffsetDateTime(LocalDateTime time) {
        if (time == null) {
            return null;
        }
        return time.atOffset(getLocalOffset(time));
    }

    public LocalDate toLocalDate(OffsetDateTime date) {
        if (date == null) {
            return null;
        }
        return LocalDate.ofInstant(date.toInstant(), ZONE_PRAGUE);
    }

    private ZoneOffset getLocalOffset(LocalDateTime time) {
        return ZONE_PRAGUE.getRules().getOffset(time);
    }
}
