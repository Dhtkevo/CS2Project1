package edu.westga.cs1302.nss.test.seismicdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.nss.model.Earthquake;
import edu.westga.cs1302.nss.model.SeismicData;

class TestSeismicDataGetEarthquakesMatchingLocation {

	@Test
	void testReturnsEmptyList() {
		SeismicData sm = new SeismicData();
		
		assertTrue(sm.getEarthquakesMatchingLocation("Milk").isEmpty());
	}
	
	@Test
	void testMatchReturnsSingleMatchingEarthquakeLowercase() {
		SeismicData sm = new SeismicData();
		
		Earthquake e = new Earthquake(LocalDateTime.now(), "2km N of Atlanta", 3, 3, 3, 3);
		sm.add(e);
		
		assertEquals(1, sm.getEarthquakesMatchingLocation("atlanta").size());
	}
	
	@Test
	void testMatchReturnsMultipleMatchingEarthquakesLowercase() {
		SeismicData sm = new SeismicData();
		
		Earthquake e = new Earthquake(LocalDateTime.now(), "2km N of Atlanta", 3, 3, 3, 3);
		Earthquake f = new Earthquake(LocalDateTime.now(), "25km N of Atlanta Georgia", 3, 3, 3, 3);

		sm.add(e);
		sm.add(f);
		
		
		assertEquals(2, sm.getEarthquakesMatchingLocation("atlanta").size());
	}
	
	@Test
	void testMatchReturnsSingleMatchingEarthquakeUppercase() {
		SeismicData sm = new SeismicData();
		
		Earthquake e = new Earthquake(LocalDateTime.now(), "2km N of Atlanta", 3, 3, 3, 3);
		sm.add(e);
		
		assertEquals(1, sm.getEarthquakesMatchingLocation("ATLANTA").size());
	}
	
	@Test
	void testMatchReturnsMultipleMatchingEarthquakesUppercase() {
		SeismicData sm = new SeismicData();
		
		Earthquake e = new Earthquake(LocalDateTime.now(), "2km N of Atlanta", 3, 3, 3, 3);
		Earthquake f = new Earthquake(LocalDateTime.now(), "25km N of Atlanta Georgia", 3, 3, 3, 3);

		sm.add(e);
		sm.add(f);
		
		
		assertEquals(2, sm.getEarthquakesMatchingLocation("ATLANTA").size());
	}

}
