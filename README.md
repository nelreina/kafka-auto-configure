### com.nelreina.libs
## kafka-auto-configure

Library for auto configure kafka in spring boot applications with camel-starter-kafka!


#### Maven Dependency
```xml
 <dependency>
    <groupId>com.nelreina.libs</groupId>
    <artifactId>kafka-auto-configure</artifactId>
    <version>0.0.1</version>
  </dependency>
```

#### Usage in Camel Route
```java
@Autowired
private KafkaConfig kafkaConfig;

...
from(kafkaConfig.getKafkaCamelRoute())
  .log("${body}");
...

```

