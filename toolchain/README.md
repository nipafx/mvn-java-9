# Toolchain

Using [Maven Toolchains][mvn-toolchains] it is easy to define Java 9 in the project's `pom.xml` and let every developer specify their path via the toolchain.

Have a look at [the pom](pom.xml) and put this into `~/.m2/toolchains.xml`:

```xml
<toolchains>
	<!-- JDK toolchains -->
	<toolchain>
		<type>jdk</type>
		<provides>
			<version>1.9</version>
			<vendor>oracle</vendor>
		</provides>
		<configuration>
			<jdkHome>/path/to/your/jdk-9</jdkHome>
		</configuration>
	</toolchain>
	<toolchain>
		<type>jdk</type>
		<provides>
			<version>1.8</version>
			<vendor>oracle</vendor>
		</provides>
		<configuration>
			<jdkHome>/path/to/your/jdk-8</jdkHome>
		</configuration>
	</toolchain>
</toolchains>
```

## Pros and Cons

This is arguably the cleanest approach because it is project-specific and makes obvious in the pom where the Java 9 compiler is supposed to come from.

It requires mucking with the pom, though, which in large legacy projects might not be your first choice.
For a less intrusive way to build on Java 9, look at [the alternatives](..).

[mvn-toolchains]: https://maven.apache.org/guides/mini/guide-using-toolchains.html
