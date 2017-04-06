# Maven Java 9

Different ways to build projects on Java 9 with Maven.
The goal is to be able to simply run `mvn clean install` and then launch the resulting JAR with `java -jar target/demo-java-9.jar`.

* [`<executable>`](executable)
* [.mavenrc](mavenrc)
* [toolchain](toolchain)

Some approaches are more intrusive, others more brittle - have a look at the individual solutions for a small discussion of its pros and cons.

## 💥 Compiler Arguments 💥

In case you're trying to use some of the new command line options like `--add-modules`, be aware that the following doesn't work:

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-compiler-plugin</artifactId>
	<version>3.6.1</version>
	<configuration>
		<compilerArgs>
			<arg>--add-modules java.xml.bind</arg>
		</compilerArgs>
		<fork>true</fork>
	</configuration>
</plugin>
```

With this configuration I got errors like the following:

```
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] javac: invalid flag: --add-modules java.xml.bind
Usage: javac <options> <source files>
use --help for a list of possible options
```

Apparently [it's common knowledge](https://twitter.com/rfscholte/status/849969556332437504) that `<arg>` will put arguments that contain a space into quotes before passing them, so I had to do the following instead:

```xml
<compilerArgs>
	<arg>--add-modules</arg><arg>java.xml.bind</arg>
</compilerArgs>
```

Obvious, right? 🤔
