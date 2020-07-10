
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

    public class LocalDatePlusSevenDays {

        private static final String DATE__FORMAT = "dd.MM.yyyy";
        private static final DateFormat dateFormat = new SimpleDateFormat(DATE__FORMAT);

        public String localDate() {

            Date currentDate = new Date();
            LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            localDateTime = localDateTime.plusDays(7);
            Date currentDatePlusFourDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

            return dateFormat.format(currentDatePlusFourDay) ;
        }
    }
