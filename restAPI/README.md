# 목차
- [✔HTTP](#http)
- [✔REST](#rest-api)
- [✔RESTFUL](#restful-api)

# ✔HTTP
- 웹 에서 클라이언트(웹 브라우저)와 웹 서버 간에 정보를 주고받기 위해 사용되는 네트워크 프로토콜입니다.

- 일반적으로 웹 브라우저는 웹 서버의 80번 포트를 통해 HTTP통신을 함

- 웹 브라우저(client)가 HTTP요청(request)을 보내면, 웹 서버에서는 HTTP응답(response)을 반환한다.

## HTTPS
- 보안을 위한 조치가 추가된 버전 SSL 프로토콜을 사용해 사용자가 데이터를 보내는 경우 암호화 되어 전송된다.
- Secure Socket Layer의 약자로 SSL 프로토콜은 간단하게 웹서버와 브라우저 사이의 보안을 위해 만들어졌다.
  - 신뢰가 있는 사이트라고 인증을 해주기 위한 인증서, openssl을 통해 발급 받아야함 

# ✔REST API
- URI는 정보의 자원을 표시, HTTP METHOD에는 자원의 행위를 명시
- 어떤 자원에 대해 CRUD(Create, Read, Update, Delete) 연산을 수행하기 위해 URI(Resource)로
GET, POST 등의 방식(Method)을 사용하여 요청을 보내며, 요청을 위한 자원은 특정한 형태(Representation of Resource)로 표현됩니다.
- 자원(resource)의 표현(representation)에 의한 상태 전달
- REST는 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나

## uri 자원
- 모든 자원에는 고유한 ID가 존재하고, 이 자원은 Server에 존재합니다.
- 자원을 구별하는 ID는 '/exgroups/:exgroup_id'와 같은 HTTP URI 입니다.
- Client는 URI를 이용해 자원을 지정하고 해당 자원의 상태(정보)에 대한 조작을 Server에 요청합니다.


## method
- HTTP 프로토콜의 Method를 사용합니다.
- HTTP 프로토콜은 GET, POST, PUT, PATCH, DELETE의 Method를 제공합니다. ( CRUD )
- 첫 번째, URI는 정보의 자원을 표현해야 한다.
- 두 번째, 자원에 대한 행위는 HTTP Method(GET, POST, PUT, PATCH, DELETE)로 표현한다.
- 행위(Method)는 URI에 포함하지 않는다.


GET | Read : 정보 요청, URI가 가진 정보를 검색하기 위해 서버에 요청한다.
-- | --
POST | Create : 정보 입력, 클라이언트에서 서버로 전달하려는 정보를 보낸다.
PUT | Update : 정보 업데이트, 주로 내용을 갱신하기 위해 사용한다. (데이터 전체를 바꿀 때)
PATCH | Update : 정보 업데이트, 주로 내용을 갱신하기 위해 사용한다. (데이터 일부만 바꿀 때)
DELETE | Delete : 정보 삭제, (안전성 문제로 대부분 서버에서 비활성화한다.)



## 표현
- Client와 Server가 데이터를 주고받는 형태로 JSON, XML, TEXT, RSS 등이 있습니다.
- JSON, XML을 통해 데이터를 주고 받는 것이 일반적입니다.
## HTTP 응답 상태 코드 사용
- 클라이언트는 해당 요청에 대한 실패, 처리완료 또는 잘못된 요청 등에 대한 피드백을 
상태 코드를 통해 서버에게 보낸 요청이 어떻게 처리되었는지 알 수 있다.

# ✔RESTFUL API 
- RESTful API는 이해하기 쉽고 사용하기 쉬운 REST API를 만드는 것을 목적 
- REST의 설계 규칙을 잘 지켜서 설계된 API를 RESTful한 API라고 함

--- 
[✔참조](https://life-with-coding.tistory.com/414)

[✔restful차이](https://dev-coco.tistory.com/97?category=1067193)
