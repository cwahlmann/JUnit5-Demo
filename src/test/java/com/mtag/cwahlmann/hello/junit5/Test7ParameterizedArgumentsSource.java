package com.mtag.cwahlmann.hello.junit5;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class Test7ParameterizedArgumentsSource {

	// ------------------- with one parameter of type Pojo --

	static class MyArgumentsProvider implements ArgumentsProvider {
		@Override
		public Stream<? extends Arguments> //
				provideArguments(ExtensionContext context) throws Exception {
			return Stream.of( //
					Arguments.of(new Pojo(10)), //
					Arguments.of(new Pojo(20)) //
			);
		}
	}

	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider.class)
	void test1(Pojo argument) {
	}

	// ------------------- with two parameters --

	static class MyArgumentsProvider2 implements ArgumentsProvider {
		@Override
		public Stream<? extends Arguments> //
				provideArguments(ExtensionContext context) throws Exception {
			return Stream.of( //
					Arguments.of("foo", 1), //
					Arguments.of("bar", 2) //
			);
		}
	}

	@ParameterizedTest
	@ArgumentsSource(MyArgumentsProvider2.class)
	void test2(String s, int i) {
	}
}
