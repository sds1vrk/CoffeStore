# 커피 주문 관리 애플리케이션

![image-20210928163742990](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928163742990.png)

### 프로젝트 구성도

- BackEnd : gc-coffe
- FrontEnd : kdt-react-order-ui



### 목차

- 요구 사항 분석
- 프로젝트 환경
- 프로젝트 설명
  - Block Diagram
  - 관리자 - 상품 관리
    - Sequence Diagram
    - 코드 설명 및 실습
  - 소비자 - 상품 주문
    - Sequence Diagram
    - 코드 설명 및 실습
- TO DO 





### 요구 사항

- 고객들이 커피를 온라인 웹으로 주문하는 사이트 제작
  - 커피에 대한 Coffe Bean Package는 현재 4개만 존재하고 추가 및 삭제 가능
- 페이지
  - 관리자 입장에서는 상품 판매 페이지, 추가 페이지 필요
  - 고객 입장에서는 상품 구매 페이지 필요
- 기타 사항
  - 상품은 매일 전날 오후 2시 ~ 오후 2시까지 주문 모아서 처리

![image-20210928165102486](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928165102486.png)



### 개발 환경

- OS : Window 10

- IDEA : IntelliJ Ultimate Version

- Back END 

  – 프레임워크 : Spring Boot

  – 언어 : JAVA 11

  – DB : MySQL 8 (Docker 이용)

- Front END 

  – React, Thymeleaf



### 프로젝트 Diagram

- Block Diagram

  ​	![image-20210928135042520](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928135042520.png)

- DB Table

![image-20210928135243625](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928135243625.png)



- ### Product(관리자 - 상품 관리)

  - #### Sequence Diagram

    ​	![image-20210928161530682](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928161530682.png)

  - #### 프로젝트 구성도 및 코드 설명

    ![image-20210928162155790](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928162155790.png)

  - #### 단위 테스트

<img src="https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928162244209.png" alt="image-20210928162244209"  />



### Order(고객 - 상품 주문)

- #### Sequence Diagram

  ​	![image-20210928202638141](https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928202638141.png)

  - ### 프로젝트 패키지 구성도 및 코드 설명

<img src="https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928202857747.png" alt="image-20210928202857747" style="zoom: 50%;" />

<img src="https://raw.githubusercontent.com/sds1vrk/CoffeStore/main/img/image-20210928202912195.png" alt="image-20210928202912195" style="zoom: 67%;" />





- TO DO
  - 상품 취소 및 수정 기능
  - 회원 가입 페이지
  - 게시물 기능

