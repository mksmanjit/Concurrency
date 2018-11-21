package foo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.TimeZone;

public final class DateUtil {

	public static LocalDateTime convertToLocalDateTime(long timestamp) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), TimeZone.getDefault().toZoneId());
	}
	
	public static long converToTimeStamp(LocalDateTime localDateTime) {
		return localDateTime.toEpochSecond(ZoneOffset.UTC) * 1000;
	}
	
}
