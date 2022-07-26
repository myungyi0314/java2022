package kafkaTest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.IOException;
import java.util.Properties;

import java.util.UUID;


public class KafkaProducerTest {

    private static final String TOPIC_TEST_NAME = "jmpark";  // test_topic_name
    private static final String TOPIC_ES = "mapped_event";  // topic_name
    private static final String KAFKA_IP = "SERVER HOST IP:PORT";

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties configs = new Properties(); // k
        configs.put("bootstrap.servers", KAFKA_IP); // kafka host 및 server 설정
        configs.put("acks", "all");    // acks(확인 응답) // 자신이 보낸 메시지에 대해 카프카로부터 확인을 기다리지 않습니다.
        configs.put("block.on.buffer.full", "true");        // 서버로 보낼 레코드를 버퍼링 할 때 사용할 수 있는 전체 메모리의 바이트수
        configs.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");   // serialize 설정
        configs.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");    // serialize 설정

        // producer 생성
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configs);

        // message 전달
        int count = 0;
        Gson gson = new Gson(); // Java Object <-> Json 문자열 (Json object <-> Java object) 양방향 변환도와줌
        JsonObject jsonobject = new JsonObject(); // json 타입으로 만들어줄 객체
        jsonobject.addProperty("@index", "jmparktest08");
        jsonobject.addProperty("@index_day", "2022.07");
        jsonobject.addProperty("category", "event");
        jsonobject.addProperty("action", "myungyi genius");
        jsonobject.addProperty("userid", "myungyi");

        // Start time
        long startTime = System.currentTimeMillis(); // 현재시각을 밀리세컨드 단위로 반환
        System.out.println("스타트타임 >>>>>>>>>>>>>>>>>>>>>>>>>"+startTime);
        while (true) {

            String uuid = UUID.randomUUID().toString(); // UUID 생성
            jsonobject.addProperty("@id", uuid);

            // String json = gson.toJson(jsonobject); // JsonObject를 Json 문자열로 변환

            // ProducerRecord 를 생성하고, send() 메시지를 사용하여 mapped_event TOPIC으로 메시지를 전송
            producer.send(new ProducerRecord<String, String>(TOPIC_ES, jsonobject.toString()));

            if (count > 1) { // count가 오른쪽 숫자 보다 크게 되면 멈춤
                break;
            }
            count++;   // count +1씩 증가

//            Thread.sleep(1000); // 1초

        }
        // 종료
        producer.flush();
        // producer 닫기
        producer.close();

        // End time
        long endTime = System.currentTimeMillis(); // 현재시각을 밀리세컨드 단위로 반환
        System.out.println("앤드타임 >>>>>"+endTime);
        System.out.println("소요시간 >>>>>"+(endTime-startTime));

    }
}
