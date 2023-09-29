# spring boot web service

## 목적
스프링부트 & Java 기반 웹서비스 템플릿 서비스입니다.  
배울 것 : spring boot settings, java 17, gradle, 배포 자동화

## Stack
- Front-End : 
- Back-End : Java17, Spring Boot3
- Data : 
- Build : Gradle

## TODO::
 - 공통
   - LocalDateTime format 변경 태그 라이브러리 생성
 - 목록 페이지
   - [O] 긴 텍스트 내용 .. 처리
   - [X] 페이징
 - 상세 페이지
   - [O] 스타일
   - [o] textarea 개행 처리
   - [O] 등록한 파일 다운로드
     - [x] 파일 객체 : root dir 별도 관리, path에는 그 뒤의 경로만 저장. 
   - [O] 뒤로가기 버튼
     - [X] 페이징 유지
   - [O] 수정하기 버튼
 - 등록,수정 페이지
  - [O] 등록 기능
  - [X] 등록 할 때 수정일시 값 설정하지 않기
  - [O] 수정 기능
    - [X] 수정일시 등록
    - [O] 파일 수정(기존파일 물리삭제)

