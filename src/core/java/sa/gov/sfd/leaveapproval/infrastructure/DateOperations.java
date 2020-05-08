/*
 * Copyright (c) 2020. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package sa.gov.sfd.leaveapproval.infrastructure;

import java.time.LocalDate;
import java.time.chrono.HijrahEra;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author abdullahalgarni on 16/04/2020 AD
 * @project leaveSystem
 **/
public class DateOperations {

    private static final DateTimeFormatter formatter_AH = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter formatter_AD = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public  LocalDate toHijri(LocalDate gregorianDate) {
        final String hijrahDateString = HijrahChronology.INSTANCE.date(gregorianDate).format(formatter_AH);

        return LocalDate.parse(hijrahDateString, formatter_AH);
    }


    public  LocalDate toGregorian(LocalDate hijriDate) {
        final HijrahDate hijrahDate = HijrahChronology.INSTANCE.date(HijrahEra.AH,
                hijriDate.get(ChronoField.YEAR_OF_ERA), hijriDate.get(ChronoField.MONTH_OF_YEAR),
                hijriDate.get(ChronoField.DAY_OF_MONTH));

        return IsoChronology.INSTANCE.date(hijrahDate);
    }

    public  LocalDate nowHijri() {
        final String hijrahDateString = HijrahChronology.INSTANCE.dateNow().format(formatter_AH);

        return LocalDate.parse(hijrahDateString, formatter_AH);
    }

    public  LocalDate nowGregorian() {

        return LocalDate.now();
    }

    public long daysBetween2Dates(LocalDate h1, LocalDate h2){
        return DAYS.between(h1, h2);
    }

    public  LocalDate formateHijri(String HijriDate) {
        return LocalDate.parse(HijriDate, formatter_AH);
    }

    public  LocalDate formateGregorian(String gregorianDate) {

        return LocalDate.parse(gregorianDate, formatter_AD);
    }



}
