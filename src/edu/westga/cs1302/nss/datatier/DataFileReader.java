package edu.westga.cs1302.nss.datatier;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import edu.westga.cs1302.nss.model.Earthquake;
import edu.westga.cs1302.nss.model.Network;
import edu.westga.cs1302.nss.model.Station;
import edu.westga.cs1302.nss.resources.GeneralConstants;
import edu.westga.cs1302.nss.resources.UI;
import edu.westga.cs1302.nss.resources.UI.ExceptionMessages;

/**
 * Reads seismic data from a file with extension Constants.FILE_EXTENSION which
 * is a CSV file with the following format:
 * station,year,month,day,hour,minute,second,location,magnitude,significance,distance,depth
 * 
 * @author CS1302
 * @version Spring 2023
 */
public class DataFileReader {

	private File seismicDataFile;

	/**
	 * Instantiates a new seismic data file reader.
	 *
	 * @precondition seismicDataFile != null
	 * @postcondition none
	 * @param seismicDataFile the seismic data file
	 */
	public DataFileReader(File seismicDataFile) {
		if (seismicDataFile == null) {
			throw new IllegalArgumentException(ExceptionMessages.FILE_CANNOT_BE_NULL);
		}
		this.seismicDataFile = seismicDataFile;
	}

	/**
	 * Reads all the earthquake data from the file one line at a time where each
	 * line contains information about the earthquake as well as the station where
	 * it was recorded. Parses each line and creates an earthquake object and stores
	 * it in the corresponding station of the passed in network.
	 * 
	 * @precondition network != null
	 * @postcondition none
	 * @param network the network to load from file
	 * @return the list of names of all newly added stations
	 * @throws FileNotFoundException
	 */
	public ArrayList<String> loadAllEarthquakesToStations(Network network) throws FileNotFoundException {
		if (network == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.NETWORK_CANNOT_BE_NULL);
		}

		int lineNumber = 1;
		String errorLine = "";
		try (Scanner input = new Scanner(this.seismicDataFile)) {
			while (input.hasNextLine()) {
				try {
					String line = input.nextLine();
					errorLine = line;
					String[] allLines = line.split(GeneralConstants.FIELD_SEPARATOR);

					String stationName = allLines[0].toString();
					int year = Integer.parseInt(allLines[1]);
					int month = Integer.parseInt(allLines[2]);
					int day = Integer.parseInt(allLines[3]);
					int hour = Integer.parseInt(allLines[4]);
					int min = Integer.parseInt(allLines[5]);
					int seconds = Integer.parseInt(allLines[6]);
					String location = allLines[7].toString();
					double magnitude = Double.parseDouble(allLines[8]);
					int significance = Integer.parseInt(allLines[9]);
					double distance = Double.parseDouble(allLines[10]);
					double depth = Double.parseDouble(allLines[11]);

					Earthquake earthquake = new Earthquake(LocalDateTime.of(year, month, day, hour, min, seconds),
							location, magnitude, significance, distance, depth);

					network.addStation(stationName);
					network.addEarthquake(stationName, earthquake);
				} catch (Exception ex) {
					System.err.println(
							"Error reading file, Line #" + lineNumber + ": " + ex.getMessage() + ", " + errorLine);
				} finally {
					lineNumber++;
				}
			}
		} catch (FileNotFoundException exception) {
			System.err.println(exception.getMessage());
		}
		ArrayList<String> stationList = new ArrayList<String>();

		for (Station stat : network.getStations()) {
			String station = stat.toString();
			stationList.add(station);
		}
		return stationList;
	}
}
