Put this into ~/.m2/toolchains.xml:

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
			<jdkHome>/path/to/jdk-9</jdkHome>
		</configuration>
	</toolchain>
	<toolchain>
		<type>jdk</type>
		<provides>
			<version>1.8</version>
			<vendor>oracle</vendor>
		</provides>
		<configuration>
			<jdkHome>/path/to/jdk-8</jdkHome>
		</configuration>
	</toolchain>
</toolchains>
```