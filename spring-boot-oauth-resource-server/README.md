# spring-boot-practice


Spring Boot Practice


## 开发过程中:
###  启动：
- mvn spring-boot:run
- 在IDE中运行java应用程序启动

### debug模式启动
- mvn spring-boot:run -Drun.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"

[https://docs.spring.io/spring-boot/docs/1.3.0.BUILD-SNAPSHOT/maven-plugin/run-mojo.html#jvmArguments](https://docs.spring.io/spring-boot/docs/1.3.0.BUILD-SNAPSHOT/maven-plugin/run-mojo.html#jvmArguments)
- 在IDE中debug模式运行java应用程序启动


## Running as a packaged application
### 直接运行
- java -jar target/myproject-0.0.1-SNAPSHOT.jar

### debug模式
 java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n -jar target/myproject-0.0.1-SNAPSHOT.jar
 
 
### 应用自动重启
      更改代码后， IDE自动编译，classpath的字节码文件变化，spring boot会自动重启，如果IDE不管用，请mvn compile 手动编译.
           
## 文档
### 生成

mvn test -Dspring.profiles.active=doc

## 访问
[http://localhost:8989/springBoot/swagger-ui.html](http://localhost:8989/springBoot/swagger-ui.html)

[http://localhost:8989/springBoot/v2/api-docs](http://localhost:8989/springBoot/v2/api-docs)


- enunciate两种文档生成[https://github.com/stoicflame/enunciate](https://github.com/stoicflame/enunciate),
  而且支持Lombok，见[https://github.com/stoicflame/enunciate/wiki/Lombok](https://github.com/stoicflame/enunciate/wiki/Lombok)
--------------------------
--------------------------
--------------------------
--------------------------



# 项目目录
--------------------------

- 对sping boot的扩展：[https://github.com/sdcuike/spring-boot-practice/tree/spring-boot-extend](https://github.com/sdcuike/spring-boot-practice/tree/spring-boot-extend)

--------------------------

- spring-boot-mybatis demo [https://github.com/sdcuike/spring-boot-practice/tree/spring-boot-mybatis](https://github.com/sdcuike/spring-boot-practice/tree/spring-boot-mybatis)
 
  辅助插件使用：
 ![https://raw.githubusercontent.com/sdcuike/spring-boot-practice/spring-boot-mybatis/src/test/resources/images/WechatIMG1.png](https://raw.githubusercontent.com/sdcuike/spring-boot-practice/spring-boot-mybatis/src/test/resources/images/WechatIMG1.png)

# 外部简化开发工具

- 数据库版本管理 [liquibase 使用](https://github.com/sdcuike/liquibase-demo)，[官网](http://www.liquibase.org)

- MyBatis 代码生成[使用](https://github.com/sdcuike/mybatis-generator-core-1.3.5-demo),[官网](http://www.mybatis.org/generator/)
