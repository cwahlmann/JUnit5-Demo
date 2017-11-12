package com.mtag.cwahlmann.hello.junit5.extension;

import java.lang.reflect.Method;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class LoggingExtension implements TestInstancePostProcessor {

	// -- org.junit.jupiter.api.extension:
	// AfterAllCallback
	// AfterEachCallback
	// AfterTestExecutionCallback
	// BeforeAllCallback
	// BeforeEachCallback
	// BeforeTestExecutionCallback
	// ExecutionCondition
	// ParameterResolver
	// TestExecutionExceptionHandler
	// TestInstancePostProcessor
	// TestTemplateInvocationContextProvider

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
		Logger logger = LoggerFactory.getLogger(testInstance.getClass());
		Method method = testInstance.getClass().getMethod("setLogger", Logger.class);

		method.invoke(testInstance, logger);
	}
}
