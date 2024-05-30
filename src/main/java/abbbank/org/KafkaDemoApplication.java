package abbbank.az;

import abbbank.az.consumer.KafkaConsumer;
import abbbank.az.dto.KafkaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@RequiredArgsConstructor
@EnableKafka
public class KafkaDemoApplication implements CommandLineRunner {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaConsumer kafkaConsumer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        for (int i = 0; i < 10; i++) {
            KafkaDto kafkaDto = new KafkaDto();
            kafkaDto.setName("Kafka Demo " + i);
            kafkaDto.setId(i);
              kafkaTemplate.send("my_first_topic_1", "key " + i, kafkaDto  );
        }
        kafkaConsumer.listerKafkaDto(null);
    }
}
