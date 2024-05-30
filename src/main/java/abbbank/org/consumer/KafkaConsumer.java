package abbbank.az.consumer;


import abbbank.az.dto.KafkaDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {


    @KafkaListener(topics = "my_first_topic_1", groupId = "kafka-group")
    public void listerKafkaDto(KafkaDto kafkaDto) {
        System.out.println("Received message from Consumer 1: " + kafkaDto);
    }


//    @KafkaListener(topics = "my_first_topic", groupId = "kafka-group")
//    public void listerKafkaDto2(KafkaDto kafkaDto) {
//        System.out.println("Received message from Consumer 2:  " + kafkaDto);
//    }
//
//
//    @KafkaListener(topics = "my_first_topic", groupId = "kafka-group")
//    public void listerKafkaDto3(KafkaDto kafkaDto) {
//        System.out.println("Received message from Consumer 3:  " + kafkaDto);
//    }
}
