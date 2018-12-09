# 01、maven 初始化spring-boot项目

- 环境准备安装好java和maven，并配置好环境变量
```
[root@localhost javatest]# java -version
java version "10.0.2" 2018-07-17
Java(TM) SE Runtime Environment 18.3 (build 10.0.2+13)
Java HotSpot(TM) 64-Bit Server VM 18.3 (build 10.0.2+13, mixed mode)
```
```
[root@localhost javatest]# mvn -v
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
Maven home: /usr/local/apache-maven-3.6.0
Java version: 10.0.2, vendor: Oracle Corporation, runtime: /usr/local/jdk-10.0.2
Default locale: zh_CN, platform encoding: UTF-8
OS name: "linux", version: "3.10.0-229.el7.x86_64", arch: "amd64", family: "unix"

```

- 进入工作目录运行命令初始化maven项目。

```
[root@localhost htdocs-java]# mvn archetype:generate -DinteractiveMode=false -DgroupId=com.kusanyao -DartifactId=first-app -Dversion=1.0.0-SNAPSHOT
```
- 初始化完成将自动生成first-app项目目录。
```
[root@localhost htdocs-java]# tree first-app/
first-app/
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── kusanyao
    │               └── App.java
    └── test
        └── java
            └── com
                └── kusanyao
                    └── AppTest.java

9 directories, 3 files

```
- 项目根目录中pom.xml配置文件内容如下：
```
[root@localhost first-app]# cat pom.xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.kusanyao</groupId>
  <artifactId>first-app</artifactId>
  <packaging>jar</packaging>
  <version>1.0.0-SNAPSHOT</version>
  <name>first-app</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
</project>

```

- 在pom.xml中添加基本的依赖配置。

```
  <!-- spring-boot parent配置 -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.0..RELEASE</version>
  </parent>
```
```
    <!-- spring-boot依赖配置 -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```
```
  <!-- spring-boot构建配置 -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>

```
```
  <!-- jdk的版本配置 -->
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
    <java.version>1.8</java.version>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```
- pom.xml完整配置如下：
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.kusanyao</groupId>
  <artifactId>first-app</artifactId>
  <packaging>jar</packaging>
  <version>1.0.0-SNAPSHOT</version>
  <name>first-app</name>
  <url>http://maven.apache.org</url>
  <!-- spring-boot parent配置 -->
  <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.0.RELEASE</version>
  </parent>
  <dependencies>
    <!-- spring-boot依赖配置 -->
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
  </dependencies>
  <!-- spring-boot构建配置 -->
  <build>
    <plugins>
      <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
      </plugin>
    </plugins>
  </build>
  <!-- jdk的版本配置 -->
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.encoding>UTF-8</maven.compiler.encoding>
    <java.version>1.8</java.version>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
</project>

```
- 添加依赖配置完毕，试试打包项目。命令如下：
```
[root@localhost first-app]# mvn -Dmaven.test.skip clean package
```
- 打包完成后生成target目录如下：
```
[root@localhost first-app]# tree target/
target/
├── classes
│   └── com
│       └── kusanyao
│           └── App.class
├── first-app-1.0.0-SNAPSHOT.jar
├── generated-sources
│   └── annotations
├── maven-archiver
│   └── pom.properties
└── maven-status
    └── maven-compiler-plugin
        └── compile
            └── default-compile
                ├── createdFiles.lst
                └── inputFiles.lst

10 directories, 5 files

```
- 运行项目，输出“Hello World!”
```
[root@localhost first-app]# java -jar target/first-app-1.0.0-SNAPSHOT.jar 
Hello World!

```
- 之所以输出“Hello World!”是因为程序主文件代码如下：
```
[root@localhost first-app]# cat src/main/java/com/kusanyao/App.java 
package com.kusanyao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}

```
- 尝试修改主程序文件代码，并再次打包运行。
```
[root@localhost first-app]# cat src/main/java/com/kusanyao/App.java 
package com.kusanyao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "PHP 是世界上最好的语言，没有之一！" );
    }
}

```
```
[root@localhost first-app]# mvn -Dmaven.test.skip clean package
```
```
[root@localhost first-app]# java -jar target/first-app-1.0.0-SNAPSHOT.jar
PHP 是世界上最好的语言，没有之一！

```
- 进一步修改主程序文件代码
- 添加一个web hello controller类
- 再次打包运行。
```
[root@localhost first-app]# cat src/main/java/com/kusanyao/App.java 
package com.kusanyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "PHP 是世界上最好的语言，没有之一！" );
	    SpringApplication.run(App.class, args); // 启动Spring Boot
    }
}

```
```
[root@localhost first-app]# cat src/main/java/com/kusanyao/web/controller/HelloController.java 
package com.kusanyao.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello()
    {
        return "Hello Spring Boot!";
    }
}

```
```
[root@localhost first-app]# java -jar target/first-app-1.0.0-SNAPSHOT.jar
PHP 是世界上最好的语言，没有之一！

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.0.RELEASE)

2018-12-09 04:13:21.907  INFO 9249 --- [           main] com.kusanyao.App                         : Starting App v1.0.0-SNAPSHOT on localhost.localdomain with PID 9249 (/data/htdocs-java/first-app/target/first-app-1.0.0-SNAPSHOT.jar started by root in /data/htdocs-java/first-app)
2018-12-09 04:13:21.916  INFO 9249 --- [           main] com.kusanyao.App                         : No active profile set, falling back to default profiles: default
2018-12-09 04:13:24.625  INFO 9249 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2018-12-09 04:13:24.666  INFO 9249 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2018-12-09 04:13:24.666  INFO 9249 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/9.0.12
2018-12-09 04:13:24.694  INFO 9249 --- [           main] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [/usr/java/packages/lib:/usr/lib64:/lib64:/lib:/usr/lib]
2018-12-09 04:13:24.868  INFO 9249 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2018-12-09 04:13:24.868  INFO 9249 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2774 ms
2018-12-09 04:13:24.937  INFO 9249 --- [           main] o.s.b.w.servlet.ServletRegistrationBean  : Servlet dispatcherServlet mapped to [/]
2018-12-09 04:13:24.944  INFO 9249 --- [           main] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2018-12-09 04:13:24.945  INFO 9249 --- [           main] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2018-12-09 04:13:24.945  INFO 9249 --- [           main] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'formContentFilter' to: [/*]
2018-12-09 04:13:24.945  INFO 9249 --- [           main] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2018-12-09 04:13:25.288  INFO 9249 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2018-12-09 04:13:25.648  INFO 9249 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2018-12-09 04:13:25.657  INFO 9249 --- [           main] com.kusanyao.App                         : Started App in 4.999 seconds (JVM running for 5.899)
```

- 可以看到tomcat也被打包到了jar中，启动的端口是8080。
- 这时已经可以在浏览器访问了。
- 因为浏览器访问的截图在这个编辑器不能上传，所以使用curl模拟访问结果如下：

```
[root@localhost javatest]# curl localhost:8080/hello
Hello Spring Boot!

```