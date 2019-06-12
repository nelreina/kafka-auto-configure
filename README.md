### com.nelreina.libs
## kafka-auto-configure

Library for auto configure kafka in spring boot applications with camel-starter-kafka!


#### Maven Dependency
```xml
 <dependency>
    <groupId>com.github.nelreina</groupId>
    <artifactId>kafka-auto-configure</artifactId>
    <version>0.0.1</version>
  </dependency>
```

#### Application YAML
```yaml
kafka:
  broker: 127.0.0.1:9092
  topic: mytopic
  group-id: mygroup
  offset-reset: earliest
  consumers-count: 1
  auto-commit-enable: false
```

#### Usage in Camel Route
```java
@Autowired
private KafkaConfig kafkaConfig;

...
// in near future will be getCamelConsumerRoute()
from(kafkaConfig.getKafkaCamelRoute())
  .log("${body}");
...

```
###Notes
Only works for Consumer for now. 
