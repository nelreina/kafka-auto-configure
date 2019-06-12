package com.nelreina.libs;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka")
@Data
@NoArgsConstructor
public class KafkaConfig {

  private String broker;
  private String topic;
  private String groupId;
  private OffsetReset offsetReset = OffsetReset.EARLIEST;
  private int consumersCount = 1;
  private boolean autoCommitEnable = true;

  public final String getKafkaCamelRoute(){
    return this.getKafkaCamelRoute(this.groupId);
  }

  public final String getKafkaCamelRoute(String groupId) {
    String route = "kafka:" + this.topic;
    route += "?brokers=" + this.broker;
    route += "&groupId=" + groupId;
    route += "&autoOffsetReset=" + this.offsetReset.toString().toLowerCase();
    route += "&consumersCount=" + this.consumersCount;
    route += "&autoCommitEnable=" + this.autoCommitEnable;
    return route;
  }


}

enum OffsetReset {
  EARLIEST, LATEST, NONE
}