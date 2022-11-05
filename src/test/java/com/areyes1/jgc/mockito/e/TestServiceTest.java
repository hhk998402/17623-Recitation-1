package com.areyes1.jgc.mockito.e;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * The Class JUnitServiceTestExample.
 */
public class TestServiceTest {

	@Test
	public void testSimpleInt() {
		// create mock
		TestService testService = spy(TestService.class);

		// define return value for method getUniqueId()
		doReturn(44).when(testService).getUniqueId();

		// use mock in test....
		assertEquals(44, testService.getUniqueId());
	}

	/**
	 * Test more than one return value.
	 */
	// Demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue() {
		//create spy
		TestService testService = spy(TestService.class);

		//Mock call to someMethod
		doNothing().when(testService).someMethod("");

		assertEquals(12, testService.testing(12));
		assertEquals(13, testService.testing(13));
	}

	@Test
	public void testVerify() {
		// create and configure mock
		TestService testService = spy(TestService.class);

		//Mock call to someMethod
		doNothing().when(testService).someMethod("");

		// call method testing on the mock with parameter 12
		testService.testing(12);

		// now check if method testing was called with the parameter 12
		verify(testService).testing(12);

		// was the method called twice?
		verify(testService, times(1)).testing(anyInt());

		// other alternatives for verifiying the number of method calls for a
		// method
		verify(testService, atLeast(1)).testing(anyInt());
		verify(testService, atMost(1)).testing(anyInt());
	}

}
