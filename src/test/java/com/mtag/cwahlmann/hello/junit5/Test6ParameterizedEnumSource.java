package com.mtag.cwahlmann.hello.junit5;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EnumSet;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class Test6ParameterizedEnumSource {

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class)
	void test1(TimeUnit timeUnit) {
		assertTrue( //
				EnumSet.allOf(TimeUnit.class) //
						.contains(timeUnit) //
		);
	}

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
	void test2(TimeUnit timeUnit) {
		assertTrue( //
				EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS) //
						.contains(timeUnit)//
		);
	}

}
