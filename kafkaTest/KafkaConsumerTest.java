package kafkaTest;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;



public class KafkaConsumerTest {

    private static final String TOPIC_NAME = "jmpark";
    private static final String TOPIC_ES = "mapped_event";
    private static final String KAFKA_IP = "SERVER HOST IP:PORT";

    public static void main(String[] args) {
        Properties props = new Properties();

        props.put("bootstrap.servers",  KAFKA_IP); // kafka server host 및 port 설정
        props.put("group.id", "jmpark-group-id-1"); // group-id 설정
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // key deserializer
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); // value deserializer

        // consumer 생성
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        // topic 설정
        consumer.subscribe(Collections.singletonList(TOPIC_NAME));

        try {
            // 메시지를 가져오기 위해 카프카에 지속적으로 poll()
            // 상태를 주기적으로 검사하여 일정한 조건을 만족할 때 송수신 등의 자료처리
            while (true) {

                    // 계속 loop를 돌면서 producer의 message를 띄운다.
                    // 비정상적으로 loop종료시 브로커는 해당 파티션을 다른 컨슈머에게 넘김
                    // 일정 시간 대기하면서 브로커로부터 컨슈머 레코드 목록을 읽어 온다
                    ConsumerRecords<String, String> records = consumer.poll(100);
                    // 읽어온 컨슈머 레코드 목록을 순회
                    for (ConsumerRecord<String, String> record : records)
                        System.out.println(record.value());
            }
        } catch (Exception e) {

        } finally {
            // 컨슈머 종료
            consumer.close();
        }
    }
}
