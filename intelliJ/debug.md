# 목차
1. [디버깅이란](#디버깅) 
2. [디버깅 버튼](#%EF%B8%8F디버깅-버튼)


# ✔디버깅
프로그래밍 과정중에 발생하는 오류나 비정상적인 연산, 즉 버그를 찾고 수정하는 것
- 프로그램 흐름을 살펴보면서 데이터 값을 확인하기 위해 사용하는 기능이다.
- 주로 logical한 에러를 디버깅하는 용도로 사용한다. (메뉴 > Debug)

# Breakpoint
- 디버깅 시 프로그램 실행 중 멈추는 구간을 설정하는 기능
- 코드 라인 넘버 옆 공백부분에 마우스 좌클릭을 하기만 하면 됌
- show line numbers 필수
- 현재 설정한 브레이크 포인트를 확인하려면 상단 Run > View Breakpoints

![image](https://user-images.githubusercontent.com/52149400/180338822-bc0dca23-9194-44df-9378-e7921177711e.png)

- Break Point를 우클릭 하게되면, 조건으로 Break를 걸 수 있음

![image](https://user-images.githubusercontent.com/52149400/180339407-81a20898-19fd-497b-b910-54bf5f842924.png)


이후 디버깅을 실행한 프로그램이 Breakpoint에 도달하게 되면 프로그램이 멈추고 해당 라인에서의 변수 및 정보 값을 보여준다.
그리고  breakpoint위에서 마우스 우클릭을 해서 나오는 창에 오느 때에 실행할지 조건값 설정이 가능하다.
(ex) 조건 i>20 이라고 설정하면 i가 21 이상일때만 break가 걸린다.)

디버깅이 실행되면 프로그램이 실행하게 되고 Breakpoint에 프로그램이 멈추게 되는데 하단 메뉴에는 다양한 디버깅 메뉴들을 확인 가능하다.


# ✔️디버깅 버튼

![image](https://user-images.githubusercontent.com/52149400/180341542-b048f8d3-9f01-47f2-80bd-5688a8df33d6.png)



| button | 설명 |
|--|--|
|Resume Program| 다음 Breakpoint 이동(다음 빨강 점 있는 곳으로) |
|Stop | 현재 디버그 중지 |
|View Breakpoint| 현재 Breakpoint확인 및 옵션 값 설정
|Mute Breakpoints| Breakpoint 비활성화 그냥 넘어갈 수 있도록 설정

## [프로그램 흐름 제어 버튼]

![img1 daumcdn](https://user-images.githubusercontent.com/52149400/180339018-acb40f08-28b9-4bdb-a0ec-036ee8002916.png)


| button | 설명 |
|--|--|
|Show Excution Point| 현재 실행 포인트로 커서가 바로 이동
|Step over| 현재 Breakpoint를 실행한 다음에 `다음 라인`으로 이동하는 버튼
|Step into| 현재 위치의 메소드 확인하고 내부(메소드)로 이동
|Force Step Into| step into에서 stepping* 설정을 무시하고 실행하는 버튼
|Step Out| 현재 break된 라인에서 호출한 곳으로 빠져나감
|Drop Frame| 현재 라인이 실행되기 전으로 되돌리는 버튼
|Run to Cursor| 현재 커서까지 디버그 (기존에 Break Point로 설정한게 아닌, 단발성으로 Break를 지정하고 확인할 때 유용)
|Evaluate Expression| Break된 상태에서 코드를 실행해 값을 확인 (실행된 코드는 실제 실행된 것) 


* Stepping 기능은 디버그의 설정 기능 중 하나로 디버그 중 건너뛸 수 있는 요소를 지정할 수 있습니다. [File → Settings]을 누르고 Stepping 메뉴창에서 어떤 메뉴를 스킵 할 것인지에 대해서 설정할 수 있습니다.



---

### [🔼위로](#목차)

참조 
* https://zzang9ha.tistory.com/390
* https://velog.io/@guri/%EC%9D%B8%ED%85%94%EB%A6%AC%EC%A0%9C%EC%9D%B4Intellij-%EB%94%94%EB%B2%84%EA%B1%B0-%EC%82%AC%EC%9A%A9%EB%B2%95-Debugging-%ED%95%98%EA%B8%B0
* https://jojoldu.tistory.com/149
