package edu.westga.cs1302.nss.test.seismicdata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.nss.model.Earthquake;
import edu.westga.cs1302.nss.model.SeismicData;

class TestSeismicDataGetHighestMagnitude {

	@Test
	void testNoEarthquakeReturnsNegativeValue() {
		SeismicData sm = new SeismicData();

		assertEquals(-1, sm.getHighestMagnitude());
	}
	
	@Test
	void testReturnsMagnitudeOneEarthquake() {
		SeismicData sm = new SeismicData();
		
		Earthquake sally = new Earthquake(LocalDateTime.now(), "1km N of G", 4, 1, 1, 1);
		sm.add(sally);
		
		assertEquals(4, sm.getHighestMagnitude());
	}
	
	@Test
	void testReturnsMagnitudeMultipleEarthquakes() {
		SeismicData sm = new SeismicData();
		
		Earthquake sally = new Earthquake(LocalDateTime.now(), "1km N of G", 4, 1, 1, 1);
		Earthquake jordan = new Earthquake(LocalDateTime.now(), "1km N of Glee", 9, 1, 1, 1);

		sm.add(sally);
		sm.add(jordan);
		
		assertEquals(9, sm.getHighestMagnitude());
	}

}
