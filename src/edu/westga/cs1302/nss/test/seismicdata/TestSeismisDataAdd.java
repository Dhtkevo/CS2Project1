package edu.westga.cs1302.nss.test.seismicdata;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.nss.model.Earthquake;
import edu.westga.cs1302.nss.model.SeismicData;

class TestSeismisDataAdd {

	@Test
	void testAddNullEarthquake() {
		SeismicData seis = new SeismicData();

		assertThrows(IllegalArgumentException.class, () -> seis.add(null));
	}

	@Test
	void testAddDuplicateEarthquakeThrowsException() {
		SeismicData seis = new SeismicData();
		LocalDateTime now = LocalDateTime.now();

		Earthquake e = new Earthquake(now, "Atlanta", 4.4, 2, 1.1, 2.2);
		Earthquake f = new Earthquake(now, "Atlanta", 4.4, 2, 1.1, 2.2);

		seis.add(e);

		assertThrows(IllegalArgumentException.class, () -> seis.add(f));
	}

	@Test
	void testAddMethodWorks() {
		SeismicData seis = new SeismicData();
		LocalDateTime now = LocalDateTime.now();

		Earthquake e = new Earthquake(now, "Atlanta", 4.4, 2, 1.1, 2.2);

		seis.add(e);
		assertTrue(seis.contains(e));
	}

}
