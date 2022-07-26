package ioNetty;

import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import reactor.netty.http.client.HttpClient;

public class ReactNettyTest {

    private static final String SERVER_HOST_IP = "SERVER_HOST_IP:PORT";  // 접속할 포트 정의

    public static void main(String[] args) {

        String content = "{\"Name\": \"홍길동\",\"amt\": \"10000\"}";   // data

        HttpClient client = HttpClient.create(); // http 인스턴스 생성

        client.post()
                .uri(SERVER_HOST_IP)   // 보내줄 request uri
                .send(ByteBufFlux.fromString(Mono.just(content))) // send 메서드로 데이터 전송
                .responseContent() // http response
                .aggregate()       // 데이터 집계
                .asString()        // 데이터를 문자열로 변형 .response()
                .log("http-client")
                .block(); // 다음 신호가 수실될때까지 무기한 차단 및 시간이 만료 될때까지 차단
                            // 매개변수 timeout, RuntimeException이 발생하기 전에 기다려야 하는 최대 시간
                            // 제공된 제한시간 만료시  runtimeException  발생
    }
}

