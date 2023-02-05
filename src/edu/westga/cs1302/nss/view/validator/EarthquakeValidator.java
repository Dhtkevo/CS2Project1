package edu.westga.cs1302.nss.view.validator;

import edu.westga.cs1302.nss.resources.UI;

/**
 * The validator for Earthquake objects.
 * 
 * @author CS1302
 * @version Spring 2023
 */
public class EarthquakeValidator {

	private String yearError;
	private String monthError;
	private String dayError;
	private String hourError;
	private String minuteError;
	private String secondError;
	private String locationError = "";
	private String magnitudeError;
	private String significanceError;
	private String distanceError;
	private String depthError;

	/**
	 * Instantiates a new validator for earthquake entries.
	 * 
	 * @precondition none
	 * @postcondition all fields are empty
	 */
	public EarthquakeValidator() {
		this.reset();
	}

	/**
	 * Returns the yearError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the yearError
	 */
	public String getYearError() {
		return this.yearError;
	}

	/**
	 * Returns the monthError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the monthError
	 */
	public String getMonthError() {
		return this.monthError;
	}

	/**
	 * Returns the dayError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the dayError
	 */
	public String getDayError() {
		return this.dayError;
	}

	/**
	 * Returns the hourError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the hourError
	 */
	public String getHourError() {
		return this.hourError;
	}

	/**
	 * Returns the minuteError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the minuteError
	 */
	public String getMinuteError() {
		return this.minuteError;
	}

	/**
	 * Returns the secondError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the secondError
	 */
	public String getSecondError() {
		return this.secondError;
	}

	/**
	 * Returns the locationError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the locationError
	 */
	public String getLocationError() {
		return this.locationError;
	}

	/**
	 * Returns the magnitudeError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the magnitudeError
	 */
	public String getMagnitudeError() {
		return this.magnitudeError;
	}

	/**
	 * Returns the significanceError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the significanceError
	 */
	public String getSignificanceError() {
		return this.significanceError;
	}

	/**
	 * Returns the distanceError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the distanceError
	 */
	public String getDistanceError() {
		return this.distanceError;
	}

	/**
	 * Returns the depthError of this Validator.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the depthError
	 */
	public String getDepthError() {
		return this.depthError;
	}

	/**
	 * Found error.
	 *
	 * @precondition none
	 * @postcondition none
	 * @return true, if a preceding call to a validation method detected an error
	 */
	public boolean foundError() {
		return !this.yearError.isEmpty() || !this.monthError.isEmpty() || !this.dayError.isEmpty()
				|| !this.hourError.isEmpty() || !this.minuteError.isEmpty() || !this.secondError.isEmpty()
				|| !this.locationError.isEmpty() || !this.magnitudeError.isEmpty() || !this.significanceError.isEmpty()
				|| !this.distanceError.isEmpty() || !this.depthError.isEmpty();
	}

	/**
	 * Reset.
	 */
	public void reset() {
		this.yearError = "";
		this.monthError = "";
		this.dayError = "";
		this.hourError = "";
		this.minuteError = "";
		this.secondError = "";
		this.magnitudeError = "";
		this.significanceError = "";
		this.distanceError = "";
		this.depthError = "";

	}

	/**
	 * Validates year. Removes trailing and leading spaces from the incoming string.
	 * A valid year is a positive whole number of exactly 4 digit, and cannot start
	 * with zero. Checks if the resulting string represents a valid year and sets a
	 * suitable error message. Whether or not the value is within the correct bounds
	 * and it is legal in the context of the other specified time variables will be
	 * checked in the Earthquake constructor.
	 * 
	 * @precondition none
	 * @postcondition getYearError().isEmpty() if the passed-in string represents a
	 *                valid year; otherwise getYearError() returns a suitable error
	 *                message
	 * @param yearString the incoming string supposedly representing the year
	 * @return the year value represented by yearString after leading and trailing
	 *         spaces have been removed; null if yearString does not represent a
	 *         valid year
	 */
	public Integer validateYear(String yearString) {

		String newStr = yearString.trim();
		if (newStr.matches("^[1-9]\\d{3}$")) {
			int year = Integer.parseInt(newStr);
			return year;
		}
		this.yearError = UI.Text.YEAR_FOUR_DIGITS;
		return null;

	}

	/**
	 * Validates month. Removes trailing and leading spaces from the incoming
	 * string. A valid month is a positive whole number of at most two digits and
	 * cannot start with zero. Checks if the resulting string represents a valid
	 * month and sets a suitable error message. Whether or not the value is within
	 * the correct bounds and it is legal in the context of the other specified time
	 * variables will be checked in the Earthquake constructor.
	 * 
	 * @precondition none
	 * @postcondition getMonthError().isEmpty() if the passed-in string represents a
	 *                valid month; otherwise getMonthError() returns a suitable
	 *                error message
	 * @param monthString the incoming string supposedly representing the month
	 * @return the month value represented by monthString after leading and trailing
	 *         spaces have been removed; null if monthString does not represent a
	 *         valid month
	 */
	public Integer validateMonth(String monthString) {

		String newStr = monthString.trim();
		if (newStr.matches("^[1-9]\\d{0,1}$")) {
			int month = Integer.parseInt(newStr);
			return month;
		}
		this.monthError = UI.Text.CANNOT_START_WITH_ZERO;
		return null;

	}

	/**
	 * Validates day. Removes trailing and leading spaces from the incoming string.
	 * Checks if the resulting string represents a valid day and sets a suitable
	 * error message. This validator must ensure that the string representing the
	 * day is a positive whole number with at most two digits. Whether or not the
	 * value is within the correct bounds and it is legal in the context of the
	 * other specified time variables will be checked in the Earthquake constructor.
	 * 
	 * @precondition none
	 * @postcondition getDayError().isEmpty() if the passed-in string represents a
	 *                valid day; otherwise getDayError() returns a suitable error
	 *                message
	 * @param dayString the incoming string supposedly representing the day
	 * @return the day value represented by dayString after leading and trailing
	 *         spaces have been removed; null if dayString does not represent a
	 *         valid day
	 */
	public Integer validateDay(String dayString) {

		String newStr = dayString.trim();
		if (newStr.matches("\\d{1,2}")) {
			int day = Integer.parseInt(newStr);
			return day;
		}
		this.dayError = UI.Text.TOO_MANY_DIGITS;
		return null;

	}

	/**
	 * Validates hour. Removes trailing and leading spaces from the incoming string.
	 * Checks if the resulting string represents a valid hour and sets a suitable
	 * error message. This validator must ensure that the string representing the
	 * hour is a positive whole number with at most two digits. Whether or not the
	 * value is within the correct bounds will be checked in the Earthquake
	 * constructor.
	 * 
	 * @precondition none
	 * @postcondition getHourError().isEmpty() if the passed-in string represents a
	 *                valid hour; otherwise getHourError() returns a suitable error
	 *                message
	 * @param hourString the incoming string supposedly representing the hour
	 * @return the hour value represented by hourString after leading and trailing
	 *         spaces have been removed; null if hourString does not represent a
	 *         valid hour
	 */
	public Integer validateHour(String hourString) {
		String newStr = hourString.trim();
		if (newStr.matches("\\d{1,2}")) {
			int hour = Integer.parseInt(newStr);
			return hour;
		}

		this.hourError = UI.Text.TOO_MANY_DIGITS;
		return null;

	}

	/**
	 * Validates minute. Removes trailing and leading spaces from the incoming
	 * string. Checks if the resulting string represents a valid minute and sets a
	 * suitable error message. This validator must ensure that the string
	 * representing the minute is a positive whole number with at most two digits.
	 * Whether or not the value is within the correct bounds will be checked in the
	 * Earthquake constructor.
	 * 
	 * @precondition none
	 * @postcondition getMinuteError().isEmpty() if the passed-in string represents
	 *                a valid minute; otherwise getMinuteError() returns a suitable
	 *                error message
	 * @param minuteString the incoming string supposedly representing the minute
	 * @return the minute value represented by minuteString after leading and
	 *         trailing spaces have been removed; null if minuteString does not
	 *         represent a valid minute
	 */
	public Integer validateMinute(String minuteString) {
		String newStr = minuteString.trim();
		if (newStr.matches("\\d{1,2}")) {
			int min = Integer.parseInt(newStr);
			return min;
		}

		this.minuteError = UI.Text.TOO_MANY_DIGITS;
		return null;

	}

	/**
	 * Validates seconds. Removes trailing and leading spaces from the incoming
	 * string. Checks if the resulting string represents a valid second and sets a
	 * suitable error message. This validator must ensure that the string
	 * representing the second is a positive whole number with at most two digits.
	 * Whether or not the value is within the correct bounds will be checked in the
	 * Earthquake constructor.
	 * 
	 * @precondition none
	 * @postcondition getSecondError().isEmpty() if the passed-in string represents
	 *                a valid second; otherwise getSecondError() returns a suitable
	 *                error message
	 * @param secondString the incoming string supposedly representing the second
	 * @return the second value represented by secondString after leading and
	 *         trailing spaces have been removed; null if secondString does not
	 *         represent a valid second
	 */
	public Integer validateSecond(String secondString) {
		String newStr = secondString.trim();
		if (newStr.matches("\\d{1,2}")) {
			int sec = Integer.parseInt(newStr);
			return sec;
		}

		this.secondError = UI.Text.TOO_MANY_DIGITS;
		return null;

	}

	/**
	 * Validates location. A valid location has to be a String starting with a
	 * positive whole number of at most three digits (can also be zero but should
	 * not start with zero if there are more digits) followed by "km" followed by a
	 * sequence (1-3 characters in length) representing a combination of the four
	 * cardinal points (N, S, E, W) followed by the word "of" and a location. For
	 * example: "11km SSW of King City" is a valid match, "11 km NE of Little Sitkin
	 * Island" is also valid, but notice the space between the value 11 and "km".
	 * "12KM NE of Salem" is not valid because KM is in caps. The words km and of
	 * must be lower case letters, and the cardinal points must be upper case
	 * letters. The location should not contain commas.
	 * 
	 * @precondition none
	 * @postcondition getLocationError().isEmpty() if the passed-in string
	 *                represents a valid location; otherwise getLocationError()
	 *                returns a suitable error message
	 * @param locationString the incoming string supposedly representing the
	 *                       location
	 * @return the location value represented by locationString; null if
	 *         locationString does not represent a valid location
	 */
	public String validateLocation(String locationString) {

		if (locationString.matches("(0|\\d{1,3}) {0,1}km [NSEW]{1,3} of .+")) {
			return locationString;
		}

		this.locationError = UI.Text.LOCATION_IS_INVALID;
		return null;

	}

	/**
	 * Validates magnitude. Removes trailing and leading spaces from the incoming
	 * string. Checks if the resulting string represents a valid magnitude and sets
	 * a suitable error message. This validator must ensure that the string
	 * representing the magnitude is a positive number between 0.01 and 10 (incl.)
	 * and cannot have more than two digits after the decimal point.
	 * 
	 * @precondition none
	 * @postcondition getMagnitudeError().isEmpty() if the passed-in string
	 *                represents a valid magnitude; otherwise getMagnitudeError()
	 *                returns a suitable error message
	 * @param magnitudeString the incoming string supposedly representing the
	 *                        magnitude
	 * @return the magnitude value represented by magnitudeString after leading and
	 *         trailing spaces have been removed; null if magnitudeString does not
	 *         represent a valid magnitude
	 */
	public Double validateMagnitude(String magnitudeString) {
		String newStr = magnitudeString.trim();
		if (newStr.matches("10(.0|.00)?|[1-9]|^[0-9].\\d{1,2}")) {
			double mag = Double.parseDouble(newStr);
			return mag;
		}

		this.magnitudeError = UI.ExceptionMessages.MAGNITUDE_OUT_OF_RANGE;
		return null;

	}

	/**
	 * Validates significance. Removes trailing and leading spaces from the incoming
	 * string. Checks if the resulting string represents a valid significance and
	 * sets a suitable error message. This validator must ensure that the string
	 * representing the significance is a positive number that can have at most four
	 * digits and cannot start with zero.
	 * 
	 * @precondition none
	 * @postcondition getSignificanceError().isEmpty() if the passed-in string
	 *                represents a valid significance; otherwise
	 *                getSignificanceError() returns a suitable error message
	 * @param significanceString the incoming string supposedly representing the
	 *                           significance of an earthquake
	 * @return the significance value represented by significanceString after
	 *         leading and trailing spaces have been removed; null if
	 *         significanceString does not represent a valid significance
	 */
	public Integer validateSignificance(String significanceString) {
		String newStr = significanceString.trim();
		if (newStr.matches("^[1-9]\\d{0,3}")) {
			int sig = Integer.parseInt(newStr);
			return sig;
		}

		this.significanceError = UI.ExceptionMessages.SIGNIFICANCE_OUT_OF_RANGE;
		return null;

	}

	/**
	 * Validates distance. Removes trailing and leading spaces from the incoming
	 * string. Checks if the resulting string represents a valid distance and sets a
	 * suitable error message. This validator must ensure that the string
	 * representing the distance is a positive number between 0 and 7.1 (incl.)
	 * 
	 * 
	 * @precondition none
	 * @postcondition getDistanceError().isEmpty() if the passed-in string
	 *                represents a valid distance; otherwise getDistanceError()
	 *                returns a suitable error message
	 * @param distanceString the incoming string supposedly representing the
	 *                       distance
	 * @return the distance value represented by distanceString after leading and
	 *         trailing spaces have been removed; null if distanceString does not
	 *         represent a valid distance
	 */
	public Double validateDistance(String distanceString) {
		String newStr = distanceString.trim();
		if (newStr.matches("[0-7]|([0-6].\\d|[0-6].\\d\\d)|[7].[0-1]")) {
			Double dis = Double.parseDouble(newStr);
			return dis;
		}

		this.distanceError = UI.ExceptionMessages.DISTANCE_OUT_OF_RANGE;
		return null;

	}

	/**
	 * Validates depth. Removes trailing and leading spaces from the incoming
	 * string. Checks if the resulting string represents a valid depth and sets a
	 * suitable error message. This validator must ensure that the string
	 * representing the depth is a whole number greater than or equal to zero.
	 * 
	 * 
	 * @precondition none
	 * @postcondition getDepthError().isEmpty() if the passed-in string represents a
	 *                valid depth; otherwise getDepthError() returns a suitable
	 *                error message
	 * @param depthString the incoming string supposedly representing the depth
	 * @return the depth value represented by depthString after leading and trailing
	 *         spaces have been removed; null if depthString does not represent a
	 *         valid depth
	 */
	public Double validateDepth(String depthString) {
		String newStr = depthString.trim();
		if (newStr.matches("^\\d+(.\\d|.\\d\\d)?")) {
			Double depth = Double.parseDouble(newStr);
			return depth;
		}

		this.depthError = UI.ExceptionMessages.DEPTH_CANNOT_BE_NEGATIVE;
		return null;

	}

}
