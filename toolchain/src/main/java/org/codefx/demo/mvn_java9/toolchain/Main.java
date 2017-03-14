package org.codefx.demo.mvn_java9.toolchain;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

public class Main {

	public static void main(String[] args) {
		printCallerClass();
	}

	private static void printCallerClass() {
				Class<?> callerClass = StackWalker
				.getInstance(RETAIN_CLASS_REFERENCE)
				.getCallerClass();
		System.out.println(callerClass);
	}

}
