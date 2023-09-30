# spring boot web service

## 목적
스프링부트 & Java 기반 웹서비스 템플릿 서비스입니다.  
배울 것 : spring boot settings, java 17, gradle, 배포 자동화

## Stack
- Front-End : 
- Back-End : Java17, Spring Boot3
- Data : Jpa, H2
- Build : Gradle

## TODO::
 - 공통
   - [X] LocalDateTime format 변경 태그 라이브러리 생성
   - [X] textarea 개행
   - [X] show data 개행
   - [ ] Lyrcies의 필드명 리랙토링
   - [ ] nav 공통 선언 -> include, import 등 어떤것을 사용할까?
   - [ ] JPA 쿼리 메시지 출력. https://shanepark.tistory.com/415
   - [X] file
     - [X] upload, download
     - [ ] root dir 별도 관리, path에는 그 뒤의 경로만 저장.
   - [ ] 등록, 수정과 같은 action일 때 confirm 띄우기
   - [X] BaseEntity 사용 (createDT, modDT)
- Template
  - list
    - [ ] show list
    - [ ] paging
    - [ ] 긴 텍스트내용 ... 처리
  - regist
    - [ ] show page
    - [ ] insert
      - [ ] 수정일 등록하지 않기
    - [X] update
    - [X] file
- Lyrices
  - list
  - regist
