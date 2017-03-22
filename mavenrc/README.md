# `mavenrc`

Maven can apparently be configured with the [mostly undocumented][jira-mavenrc-doc] files `~/.mavenrc` (for current user) and `/etc/mavenrc` (for all users).
In there, environment variables and command line options for the Java command can be configured.

With this, it is easy to set `JAVA_HOME` just for the Maven command, which will lead to it running with the specified version.
Here's the content of that file:

```
JAVA_HOME="/path/to/your/jdk-9"
```

## Pros and Cons

If you not only want to compile with Java 9 but also use Java 9 features, you still have to specify the target `1.9` in your [pom](pom.xml).
Note that this puts the pom into an awkward state where it is supposed to use JDK 9 but does not reference where it might come from (unlike the [toolchain approach](../toolchain))


[jira-mavenrc-doc]: https://issues.apache.org/jira/browse/MNGSITE-246
