# Executable

In the `maven-compiler-plugin` the executable to be used for compilation [can be explicitly named](https://maven.apache.org/plugins/maven-compiler-plugin/compile-mojo.html#executable):

```xml
<build>
	<plugins>
		<!-- target Java 9 -->
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<version>3.6.1</version>
			<configuration>
				<source>1.9</source>
				<target>1.9</target>
				<release>9</release>
				<!-- fork compilation and use the specified executable -->
				<fork>true</fork>
				<executable>javac9</executable>
			</configuration>
		</plugin>
	</plugins>
</build>
```

For `executable` to have an effect, [the `fork` option](https://maven.apache.org/plugins/maven-compiler-plugin/compile-mojo.html#fork) needs to be set to `true`, which tells Maven to launch the compiler in a separate process.

## Improvements

In the example above I simply use `javac9`.
That works for me because I symlinked `/bin/javac9` (as well as `java9`, `jar9`, `jdeps9`) to `/opt/jdk-9/bin/javac` and `/opt/jdk-9` to whatever JDK 9 EA build I am currently using (e.g. `/opt/jdk-9-b163`).
Your and your team's setup might differ of course an there are two ways to improve this.

### Command Line Option

If you are just experimenting you could consider specifying the property on the command line instead:

```
mvn -Dmaven.compiler.fork -Dmaven.compiler.executable=javac9 clean install
```

This _only_ works if you do not also set it in `<configuration>`, though.

### `settings.xml`

To make the compiler change less static, you can use a self-defined user property and ask developers to define it in their `settings.xml`.
See [the Maven docs](https://maven.apache.org/plugins/maven-compiler-plugin/examples/compile-using-different-jdk.html) for more on that.

## Pros and Cons

To compile with Java 9, for example to check whether your project builds without errors, the command line flag is a low ceremony approach as it requires no other changes (assuming you do not already specify the executable in `<configration>`).

If you not only want to compile with Java 9 but also use Java 9 features, you still have to specify the target `1.9`.
This starts bloating the command line.
If you put it into the pom, consider referencing the executable relative to some property, every developer has to set.
But if you're going down that road, why not use the [toolchain](../toolchain)?
