# eGovFrame-Practice

이 저장소는 eGovFrame 기반의 실습용 프로젝트입니다. 

## 소개

- eGovFrame 기반 웹 애플리케이션 실습
- Android 앱과의 연동 및 소셜 로그인, 푸시 알림 등의 기능 연습
- 실무 환경과 유사한 개발 환경 구성 및 배포 연습
- Firebase Cloud Messaging(FCM), Kakao, Google SDK 등을 이용한 인증/연동 예제 포함

## Languages
Java, Kotlin, Javascript, CSS, HTML, Batchfile

## 개발 툴 및 다운로드 링크

| 개발 툴             | 공식 다운로드 사이트                                                                                        | 비고                          |
|---------------------|--------------------------------------------------------------------------------------------------------------|-----------------------------|
| Apache Tomcat 9.0   | [tomcat.apache.org/download-90.cgi](https://tomcat.apache.org/download-90.cgi)                               | 웹 서버, 최신 9.0.x 버전 제공 |
| Eclipse             | [eclipse.org/downloads](https://www.eclipse.org/downloads/)                                                  | 대표 Java 통합 개발 환경      |
| JDK 8 (웹 서버용)   | [oracle.com/java/technologies/javase/javase8-archive-downloads.html](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) | 장기 지원(Java 8)           |
| JDK 17 (앱/최신용)  | [oracle.com/java/technologies/downloads/#jdk17](https://www.oracle.com/java/technologies/downloads/#jdk17)   | Java 17 LTS 추천            |
| MySQL 8.0           | [dev.mysql.com/downloads/mysql/](https://dev.mysql.com/downloads/mysql/)                                     | 오픈소스 데이터베이스        |
| Android Studio      | [developer.android.com/studio](https://developer.android.com/studio)                                         | 구글 공식 안드로이드 개발툴  |

| 개발 툴             | DOCKER 설치 명령                                                                                             | 비고                       |
|---------------------|--------------------------------------------------------------------------------------------------------------|-----------------------------|
| RabbitMQ            | docker run -d -e TZ-Asia/Seoul --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management               |                             |
| Zipkin              | docker run --name zipkin -d -p 9411:9411 -e TZ=Asia/Seoul openzipkin/zipkin                                  |                             |

## 필요한 API KEY

이 프로젝트를 실행하기 위해서는 다음과 같은 외부 서비스 API KEY가 필요합니다.  
실제 키 값은 **소스 코드에 직접 커밋하지 말고**, 별도의 환경설정 파일이나 시스템 환경 변수로 관리하세요.

### 1. Firebase Admin SDK Key

- Firebase 프로젝트 생성 후 서비스 계정 키(JSON) 발급
- 주요 사용처
  - 서버 사이드에서 Firebase Auth 및 Cloud Messaging(Firebase Cloud Messaging) 사용
  - Custom Token 발급 등 백엔드 연동 [web:9]
- 권장 설정 방법
  - `config/firebase/` 폴더 등 키 파일을 두고, 경로만 환경 변수로 관리
  - 예: `FIREBASE_ADMIN_SDK_PATH=/path/to/serviceAccountKey.json` [web:9]

### 2. Kakao SDK Key

- Kakao Developers에서 애플리케이션 생성 후 다음 키 발급
  - REST API 키
  - JavaScript 키 (웹/프론트에서 사용하는 경우)
  - Android, iOS용 네이티브 앱 키 (모바일 앱에서 사용하는 경우) [web:9]
- 주요 사용처
  - 카카오 로그인, 사용자 정보 조회, 기타 카카오 API 연동 [web:7][web:9]
- 권장 설정 방법
  - `application-*.properties` 또는 eGovFrame 설정 파일에 `${KAKAO_REST_API_KEY}` 등으로 참조
  - IDE/서버 환경 변수로 실제 값을 주입 [web:7]

### 3. Google SDK Key

- Google Cloud Console 또는 Firebase Console에서 다음 정보 발급
  - OAuth 2.0 Client ID / Client Secret
  - 필요시 API Key (Maps, Places 등 추가 서비스 사용 시) [web:7]
- 주요 사용처
  - Google 로그인(OAuth2), Firebase 연동, 기타 Google API 호출 [web:7]
- 권장 설정 방법
  - `GOOGLE_CLIENT_ID`, `GOOGLE_CLIENT_SECRET` 환경 변수로 관리
  - Redirect URL(e.g. `http://localhost:8080/auth/google/callback`)은 구글 콘솔과 서버 설정 양쪽에서 동일하게 맞출 것 [web:7]

## 참고

- eGovFrame  사이트: https://www.egovframe.go.kr/
- eGovFrame Mobile 사이트 http://m.egovframe.go.kr/mguide3.5/
- Android 개발자 사이트 https://developer.android.com/reference
- Kotlin DOCS 사이트 https://kotlinlang.org/docs/api-references.html
- Java DOCS 사이트 https://docs.oracle.com/javaee/7/index.html
- MSA service mesh 참조 https://spring.io/microservices

## 라이선스

Copyright <2014> "전자정부 표준프레임워크"

전자정부 표준프레임워크 DeviceAPI는 
아래와 같은 라이선스를 적용받는 오픈소스 소프트웨어를 기반으로 만들어졌습니다. 

Apache License 2.0
Brian Gladman AES License
BSD 2-clause "Simplified" License
BSD 3-clause "New" or "Revised" License
Do What The F*ck You Want To Public License
ISC License
MIT License
Public Domain
zlib License


전자정부 표준프레임워크 DeviceAPI를 수정 혹은 확장한 2차적 저작물을 사용하거나 배포하여 발생하는 모든 손해나 법적 문제에 대해 
전자정부 표준프레임워크의 저작권자는 일체의 책임을 지지 않습니다.

전자정부 표준프레임워크 DeviceAPI에 사용된 오픈 소스소프트웨어의 라이선스는 OSSLicenses 파일을 참조하십시오




