package edu.westga.cs1302.nss.model;

import java.util.ArrayList;

import edu.westga.cs1302.nss.resources.UI;

/**
 * The class seismic data stores a list of earthquakes.
 * 
 * @author CS1302
 * @version Spring 2023
 */
public class SeismicData {

	private ArrayList<Earthquake> earthquakes;

	/**
	 * Instantiates a new SeismicData object.
	 *
	 * @precondition none
	 * @postcondition size() == 0
	 */
	public SeismicData() {
		this.earthquakes = new ArrayList<Earthquake>();
	}

	/**
	 * Adds a new earthquake to the seismic data object.
	 * 
	 * @precondition earthquake != null && another earthquake with same time and
	 *               location not already present
	 * @postcondition
	 * @param earthquake the earthquake to add
	 * @return true if added, false otherwise
	 */
	public boolean add(Earthquake earthquake) {
		if (earthquake == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.EARTHQUAKE_CANNOT_BE_NULL);
		}

		if (this.contains(earthquake)) {
			throw new IllegalArgumentException(UI.ExceptionMessages.DUPLICATE_EARTHQUAKE);
		}

		int preSize = this.earthquakes.size();

		this.earthquakes.add(earthquake);

		int newSize = this.earthquakes.size();

		if (newSize == preSize + 1) {
			return true;
		}
		return false;

	}

	/**
	 * Checks if duplicate earthquake with same time and location already in data.
	 * 
	 * @precondition earthquake != null
	 * @postcondition none
	 * @param earthquake the specified earthquake
	 * @return true if duplicate exists, false otherwise
	 */
	public boolean contains(Earthquake earthquake) {
		if (earthquake == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.EARTHQUAKE_CANNOT_BE_NULL);
		}

		for (Earthquake quake : this.earthquakes) {
			if (quake.getTime().equals(earthquake.getTime()) && quake.getLocation().equals(earthquake.getLocation())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Adds all the earthquakes to this seismic data.
	 * 
	 * @precondition earthquakes != null
	 * @postcondition no duplicates
	 * @param earthquakes the earthquakes to be added
	 * @return true, if this seismic data object has changed
	 */
	public boolean addAll(ArrayList<Earthquake> earthquakes) {
		if (earthquakes == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.EARTHQUAKES_CANNOT_BE_NULL);
		}

		boolean changed = false;
		for (Earthquake earthquake : earthquakes) {
			if (this.add(earthquake)) {
				changed = true;
			}
		}
		return changed;
	}

	/**
	 * Deletes the specified earthquake from the seismic data.
	 * 
	 * @precondition none
	 * @postcondition if found, size() == size()@prev - 1
	 * @param earthquake the earthquake to delete
	 * @return true if the earthquake was found and deleted, false otherwise
	 */
	public boolean remove(Earthquake earthquake) {
		return this.earthquakes.remove(earthquake);
	}

	/**
	 * Number earthquakes in this seismic data.
	 *
	 * @precondition none
	 * @postcondition none
	 * @return the number of earthquake included in this seismic data.
	 */
	public int size() {
		return this.earthquakes.size();
	}

	/**
	 * Gets the earthquakes of this seismic data object.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the earthquakes
	 */
	public ArrayList<Earthquake> getEarthquakes() {
		return this.earthquakes;
	}

	/**
	 * Creates an array that holds the count of the number of earthquakes in each
	 * segment starting from 0 to segmentRange up to the last segment which includes
	 * the highest magnitude earthquake.
	 * 
	 * @precondition segmentRange >= 0.01
	 * @postcondition none
	 * @param segmentRange the range of the magnitude values
	 * @return array with number of earthquakes of this seismic data that are in
	 *         each segment. Returns null if this seismic data is empty.
	 */
	public int[] countEarthquakesByMagnitudeSegments(double segmentRange) {
		if (segmentRange < 0.01) {
			throw new IllegalArgumentException(UI.ExceptionMessages.INVALID_SEGMENT_RANGE);
		}
		int numSegmentsMinToRange = 0;
		int numSegmentsRangeToMax = 0;

		for (Earthquake quake : this.earthquakes) {
			
		}
		// creates array
		// holds count of number of earthquakes in segment
		// segment starting from 0 to segmentRange

		return null;
	}

	/**
	 * Creates an array that holds the count of the number of earthquakes in each
	 * segment starting from 0 to segmentRange up to the last segment which includes
	 * the highest significance earthquake.
	 * 
	 * @precondition segmentRange >= 1
	 * @postcondition none
	 *
	 * @param segmentRange the range of the significance values
	 * @return array with number of earthquakes of this seismic data that are in
	 *         each segment. Returns null if this seismic data is empty.
	 */
	public int[] countEarthquakesBySignificanceSegments(int segmentRange) {
		// TODO Part 2-A Step 4
		return null;
	}

	/**
	 * Returns the highest magnitude value of a recorded earthquake
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the highest magnitude of a recorded earthquake; a negative value if
	 *         no earthquakes
	 */
	public double getHighestMagnitude() {
		double highestValue = 0;

		for (Earthquake earth : this.earthquakes) {
			if (earth.getMagnitude() > highestValue) {
				highestValue = earth.getMagnitude();
			}
		}
		if (this.earthquakes.isEmpty() || this.earthquakes == null) {
			return -1;
		}

		return highestValue;
	}

	/**
	 * Returns the highest significance value of a recorded earthquake
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the highest significance of a recorded earthquake; a negative value
	 *         if no earthquakes
	 */
	public int getHighestSignificance() {
		int highestValue = 0;

		for (Earthquake earth : this.earthquakes) {
			if (earth.getSignificance() > highestValue) {
				highestValue = earth.getSignificance();
			}
		}
		if (this.earthquakes.isEmpty() || this.earthquakes == null) {
			return -1;
		}

		return highestValue;
	}

	/**
	 * Returns a list of earthquakes whose location contains the specified search
	 * term(s). If there are no earthquakes that match the search term, it returns
	 * an empty list.
	 * 
	 * @precondition searchTerm != null
	 * @param searchTerm the search term(s)
	 * @return the list of earthquakes containing the search term(s) in the location
	 *         or an empty list if there are no earthquakes containing the
	 *         searchTerm (the method should not return null)
	 */
	public ArrayList<Earthquake> getEarthquakesMatchingLocation(String searchTerm) {
		if (searchTerm == null) {
			throw new IllegalArgumentException(UI.ExceptionMessages.SEARCH_TERM_CANNOT_BE_NULL);
		}

		String lowerSearch = searchTerm.toLowerCase();

		ArrayList<Earthquake> matchList = new ArrayList<Earthquake>();
		for (Earthquake quake : this.earthquakes) {
			if (quake.getLocation().toLowerCase().indexOf(lowerSearch) >= 0) {
				matchList.add(quake);
			}
		}
		System.out.println(matchList);
		return matchList;
	}

	@Override
	public String toString() {
		return "#Earthquakes: " + this.size();
	}

}
