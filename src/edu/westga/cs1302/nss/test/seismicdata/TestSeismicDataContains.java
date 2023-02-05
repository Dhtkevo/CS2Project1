package edu.westga.cs1302.nss.test.seismicdata;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.nss.model.Earthquake;
import edu.westga.cs1302.nss.model.SeismicData;

class TestSeismicDataContains {

	@Test
	void testContainsNull() {
		SeismicData seis = new SeismicData();

		assertThrows(IllegalArgumentException.class, () ->

		seis.contains(null));
	}

	@Test
	void testContainsOneEarthquake() {
		SeismicData seis = new SeismicData();
		LocalDateTime now = LocalDateTime.now();

		Earthquake e = new Earthquake(now, "Atlanta", 4.4, 2, 1.1, 2.2);

		seis.add(e);
		assertTrue(seis.contains(e));
	}

	@Test
	void testContainsMultipleEarthquakes() {
		SeismicData seis = new SeismicData();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime no = LocalDateTime.of(2020, 3, 3, 3, 3);

		Earthquake e = new Earthquake(no, "Atlanta UGA", 4.4, 2, 1.1, 2.2);
		Earthquake b = new Earthquake(now, "Atlanta", 4.4, 2, 1.1, 2.2);

		seis.add(e);
		seis.add(b);
		assertAll(
				() -> assertTrue(seis.contains(e)),
				() -> assertTrue(seis.contains(b))
				);
	}

}
