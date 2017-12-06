package java8_4datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class DateTimeEx {

	public static void main(String[] args) {
		// LocalDate sınıfı ile tarihsel zaman temsil edilir. Örneğin:
		// 10/10/2010 tarihini LocalDate ile temsil edebiliriz.
		reviewLocalDate();

		// LocalTime sınıfı ile saatsel zaman temsil edilir. Örneğin: 20:11 ,
		// 18:15:55 saatlerini LocalTime ile temsil edebiliriz. LocalTime ile saat,
		// dakika, saniye, salise temsil edilebilir.
		reviewLocalTime();

		// LocalDateTime sınıfı ile hem tarihsel hem saatsel zaman temsil
		// edilir.
		// Örneğin: 10/10/2010 15:22:33 zamanını LocalDateTime ile sınıfsal olarak
		// temsil edebiliriz.
		reviewLocalDateTime();

		// ZoneId sınıfı, dünya üzerindeki saat dilimlerinin Java taraflı nesnel
		// karşılığını temsil için oluşturulan yeni bir Java 8 bileşenidir.
		// Java 8 için tüm saat dilimlerinin listelenmesi için ZoneId sınıfının
		// getAvailableZoneIds metodu kullanılabilmektedir. Örneğin aşağıdaki kod, tüm
		// saat dilimlerini sıralı olarak listelemektedir.
		reviewZoneId();

		// ZonedDateTime sınıfı aslında saat dilimi katıştırılmış LocalDateTime
		// sınıfıdır desek yeridir. LocalDateTime sınıfından farkı genel olarak temsil
		// ettiği zamanı saat dilimi içerir olarak sunmasıdır.
		reviewZondeDateTime();
	}

	private static void reviewLocalDate() {
		// "of" metodu ile LocalDate nesnesi oluşturulabilir.
		LocalDate.of(1988, 07, 16); // 1988-07-16
		LocalDate.of(1988, Month.JULY, 16); // 1988-07-16 (Month enum)

		// "now" metodu ile o anın tarihi elde edilir.
		LocalDate now = LocalDate.now(); // 2017-11-30

		/**
		 * "with***" metodu ile eldeki bir LocalDate için gün, ay, yıl alanları
		 * düzenlenebilir. LocalDate sınıfı immutable’dir. Bu sebeple with metodu farklı
		 * bir LocalDate nesne döndürür. O anki nesneyi düzenlemez.
		 */
		LocalDate now1 = LocalDate.now(); // 2017-11-30
		now1.withYear(2016); // 2016-11-30
		now1.withMonth(8).withDayOfMonth(17); // 2017-08-17
		now1.with(ChronoField.YEAR, 2012).with(ChronoField.MONTH_OF_YEAR, 8).with(ChronoField.DAY_OF_MONTH, 3); // 2012-08-03

		/**
		 * "plus***" metodu ile eldeki bir LocalDate için gün, ay, yıl alanları
		 * artırılabilir. LocalDate sınıfı immutable’dir. Bu sebeple plus metodu farklı
		 * bir LocalDate nesne döndürür. O anki nesneyi düzenlemez.
		 */
		now.plusWeeks(2).plusDays(3).plusYears(3).plusDays(7); //
		now.plus(2, ChronoUnit.WEEKS).plus(3, ChronoUnit.YEARS).plus(3, ChronoUnit.DECADES); //

		/**
		 * "minus***" metodu ile eldeki bir LocalDate için gün, ay, yıl alanları
		 * azaltılabilir. LocalDate sınıfı immutable’dir. Bu sebeple minus metodu farklı
		 * bir LocalDate nesne döndürür. O anki nesneyi düzenlemez.
		 */
		now.minusDays(5).minusMonths(2); //
		now.minus(2, ChronoUnit.WEEKS).minus(3, ChronoUnit.YEARS).minus(33, ChronoUnit.DAYS); //

	}

	private static void reviewLocalTime() {

		LocalTime now = LocalTime.now();

		LocalTime time = LocalTime.of(18, 20, 55); // 18:20:55

		time.getHour(); // 18
		time.getMinute(); // 20
		time.getSecond(); // 55

		time = LocalTime.NOON; // 12:00
		time = LocalTime.MIDNIGHT; // 00:00

		LocalTime.parse("10:05"); // 10:05

		time.plusSeconds(45).minusSeconds(5).minus(5, ChronoUnit.SECONDS); // 18:20:35
	}

	private static void reviewLocalDateTime() {

		LocalDateTime now = LocalDateTime.now();

		LocalDateTime dateTime = LocalDateTime.of(2017, Month.NOVEMBER, 30, 16, 15, 00);

		dateTime.getYear(); // 2017
		dateTime.getMonth(); // NOVEMBER
		dateTime.getDayOfMonth(); // 30
		dateTime.getHour(); // 16
		dateTime.getMinute(); // 15
		dateTime.getSecond(); // 00

		// LocalDateTime2LocalDate ve LocalDateTime2LocalTime
		LocalDate date = dateTime.toLocalDate();
		LocalTime time = dateTime.toLocalTime();

		dateTime.minusDays(3).plusYears(3).plusMinutes(3).minusWeeks(5).plusSeconds(2).plus(3, ChronoUnit.DECADES)
				.minus(3, ChronoUnit.DECADES);
	}

	private static void reviewZoneId() {

		Set<String> zones = ZoneId.getAvailableZoneIds();
		zones.stream().sorted().forEach(System.out::println);

		ZoneId.systemDefault(); // Europe/Athens

	}

	private static void reviewZondeDateTime() {

		ZonedDateTime.now();
		/* 2014-04-05T16:33:16.320+03:00[Europe/Athens] */

		ZoneId istanbul = ZoneId.of("Europe/Istanbul");
		ZonedDateTime.now(istanbul);
		// 2014-04-05T16:33:16.330+03:00[Europe/Istanbul]

		// Japonyada tarih/saat kaç?
		ZonedDateTime japan = ZonedDateTime.now(ZoneId.of("Japan"));
		// 2014-04-05T22:33:16.331+09:00[Japan]

		// Bir ZonedDateTime nesnesi LocalDateTime, LocalDate ve LocalTime
		// karşılıklarına dönüştürülebilmektedir.
		LocalDateTime localDateTime = japan.toLocalDateTime();
		/* 2014-04-05T22:33:16.331 */

		LocalDate localDate = japan.toLocalDate(); // 2014-04-05
		LocalTime localTime = japan.toLocalTime(); // 22:33:16.331
	}

}
