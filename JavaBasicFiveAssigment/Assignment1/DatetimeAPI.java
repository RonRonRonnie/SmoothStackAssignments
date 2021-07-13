package JavaBasicFiveAssigment.Assignment1;


import java.time.*;
import java.time.temporal.*;


class DatetimeAPI implements TemporalQuery<Boolean> {
    public static void main(String[] args) {
        //1. ZonedDateTime to store birthday in years, months, days, seconds, and nanoseconds
        ZonedDateTime zonedDateTimeOf = ZonedDateTime.of(1999, 12, 19, 7, 6, 30, 6, ZoneId.of("UTC"));
        System.out.println(zonedDateTimeOf);
        System.out.println("**********************************************");
        //2.find the date of the previous Thursday
        TemporalAdjuster temporalAdjuster
                = TemporalAdjusters.previous(
                DayOfWeek.THURSDAY);

        // using adjuster for local date-time
        LocalDate localDate
                = LocalDate.of(2021, 11, 13);
        LocalDate previousDOW
                = localDate.with(temporalAdjuster);

        System.out.println(
                "Previous day of the week "
                        + "having THURSDAY for localdate "
                        + localDate + " is: "
                        + previousDOW);

        System.out.println("**********************************************");
        //3.difference between a ZoneId and a ZoneOffset
        //ZoneId is a representation of the time-zone such as ‘Europe/Paris‘.
        ZoneId zone = ZoneId.of("America/Los_Angeles");
        //ZoneOffset extends ZoneId and defines the fixed offset of the current time-zone with GMT/UTC, such as +02:00.
        LocalDateTime now = LocalDateTime.now();
        ZoneOffset zoneOffSet = zone.getRules().getOffset(now);
        System.out.println(zoneOffSet);
        System.out.println("**********************************************");
        //4. convert an Instant to a ZonedDateTime and convert a ZonedDateTime to an Instant
        //convert an Instant to a ZonedDateTime
        Instant instant = Instant.now();
        System.out.println("Instant : " + instant);
        // Japan = UTC+9
        ZonedDateTime jpTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println("ZonedDateTime : " + jpTime);
        System.out.println("OffSet : " + jpTime.getOffset());

        System.out.println("**********************************************");
        //convert a ZonedDateTime to an Instant
        LocalDateTime dateTime = LocalDateTime.of(2021, Month.JULY, 13, 7, 29, 38);
        ZonedDateTime jp1Time = dateTime.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println("ZonedDateTime : " + jp1Time);
        // Convert to instant UTC+0/Z , java.time helps to reduce 9 hours
        Instant instant1 = jp1Time.toInstant();

        System.out.println("Instant : " + instant1);

        //5. reports the length of each month within that year.
        MonthsInYear(2020);
        System.out.println("**********************************************");
        //6. lists all of the Mondays in that month.
        ListMondays(Month.JANUARY);
        System.out.println("**********************************************");

        //7. tests whether a given date occurs on Friday the 13th.

        DatetimeAPI datetimeAPI = new DatetimeAPI();
        LocalDate localDate1
                = LocalDate.of(2021, 07, 13);
        boolean occurs;
        occurs = datetimeAPI.queryFrom(localDate1);
        if(!occurs){
            System.out.println("given date do not occurs on Friday the 13th.");
        }else {
            System.out.println("given date do occurs on Friday the 13th.");
        }

    }

    public static void MonthsInYear(int year) {

        try {
            Year test = Year.of(year);
        } catch (DateTimeException exc) {
            System.out.printf("%d is not a valid year.%n", year);
            throw exc;     // Rethrow the exception.
        }

        System.out.printf("For the year %d:%n", year);
        for (Month month : Month.values()) {
            YearMonth ym = YearMonth.of(year, month);
            System.out.printf("%s: %d days%n", month, ym.lengthOfMonth());
        }

    }

    public static void ListMondays(Month month) {
        System.out.printf("For the month of %s:%n", month);
        LocalDate date = Year.now().atMonth(month).atDay(1).
                with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        Month mi = date.getMonth();
        while (mi == month) {
            System.out.printf("%s%n", date);
            date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            mi = date.getMonth();

        }

    }

    @Override
    public Boolean queryFrom(TemporalAccessor temporal) {
        return ((temporal.get(ChronoField.DAY_OF_MONTH) == 13) &&
                (temporal.get(ChronoField.DAY_OF_WEEK) == 5));
    }
}