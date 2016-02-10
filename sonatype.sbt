// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "com.github.kypeli"

// To sync with Maven central, you need to supply the following information:
pomExtra in Global := (
    <url>https://github.com/kypeli/sversion</url>
        <licenses>
          <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
          </license>
        </licenses>
        <scm>
          <connection>scm:git:github.com:kypeli/sversion.git</connection>
          <developerConnection>scm:git:git@github.com:kypeli/sversion.git</developerConnection>
          <url>github.com/kypeli/sversion</url>
        </scm>
        <developers>
          <developer>
          <id>kypeli</id>
          <name>Johan Paul</name>
          <url>http://www.johanpaul.com</url>
          </developer>
        </developers>
)

