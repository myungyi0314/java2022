1. 스프링 부트 스타터 사이트로 이동해서 스프링 부트 기반 프로젝트 생성

 [https://start.spring.io/](https://start.spring.io/)
 
![image](https://user-images.githubusercontent.com/52149400/182078975-ddeb080b-458d-463e-ab8b-668a35f8cd79.png)

2. IntelliJ는 gradle을 통해서 실행하는 것이 기본 설정
   - 속도가 느리다.
   - Preferences >> Build, Execution, Deployment >> Build Tools Gradle
     - Build and run using >> Gradle IntelliJ IDEA
     - Run tests using >> Gradle IntelliJ IDEA

![image](https://user-images.githubusercontent.com/52149400/181707639-1f3bfb6f-bd75-4a12-96c3-b1b686c202c8.png)

3. group + artifact = package name으로 많이 씀
4. jar war 
   - jar(Java Archive) 자바로만 이루어져있는 압축한 파일, jre 자바 환경만 세팅되어있다면 어디서든지, 톰캣도 이미 내장
   - war(Web Application Archive) 웹 어플리케이션(웹에 띄우는) 압축해놓은 파일, 서블릿 컨테스트 페키징, 톰캣 및 웹 커넽이너 등이 필요    
5. Dependencies
   - 초기 의존성 환경세팅, 나중에도 추가 가능 

> JDBC(Java Database Connectivity)는 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
