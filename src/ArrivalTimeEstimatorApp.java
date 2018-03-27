import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class ArrivalTimeEstimatorApp {

	public static void main(String[] args) {
		
		System.out.println("Arrival Time Estimator");
		
		String choice = "Y";
		while (choice.equalsIgnoreCase("Y")) {
			
			String yearString = Console.getString("Enter departure date (YYYY-MM-DD): ");
			String timeString = Console.getString("     Enter departure time (HH:00): ");
			
			String LocalDateTimeString = yearString + "T" + timeString;
			
			LocalDateTime departureDateTime = LocalDateTime.parse(LocalDateTimeString);
			
			int numOfMiles = Console.getInt(     "        Enter the number of miles: ");
			int mph = Console.getInt(            "            Enter the average mph: ");
			
			int hours = numOfMiles / mph;
			int minutes = numOfMiles % mph;
			LocalDateTime dateTimeOfArrival = departureDateTime.plusHours(hours).plusMinutes(minutes);
			
			DateTimeFormatter yearFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
			
			
			String msg ="Estimated Time of Arrival:\n"
					  + "          Hours: " + hours + "\n"
					  + "        Minutes: " + minutes + "\n"
					  + "Date of Arrival: " + dateTimeOfArrival.getMonth() + ". " + dateTimeOfArrival.getDayOfMonth() + "," + dateTimeOfArrival.getYear() + "\n"
					  + "Time of Arrival: " + dateTimeOfArrival.getHour() + ":" + dateTimeOfArrival.getMinute();
			
			System.out.println(msg);
			
			choice = Console.getString("Continue?  (y/n): ", "Y", "N");
		}

			
		System.out.println("Later.");
	}

}
