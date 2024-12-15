# 이커머스 - 물품 구매, 판매

### 기능[5]
1. 회원 가입: 판매자/소비자의 PW, 이름, 계좌번호, 전화번호를 기입한 뒤 계정을 생성한다. ID는 등록한 순서대로 부여받는다.


2. 로그인/로그아웃: 판매자/소비자이 회원가입을 할 때 만든 계정의 이름, PW를 기입한 뒤 
판매자/소비자의 이름, PW가 맞는지 확인한 후에 로그인을 하게 한다. 판매자의 경우에만 로그인한 회원인 
판매자/소비자의 정보를 받아 온다. 로그아웃 기능도 가능하다.


3. 판매자/소비자(회원)- 1에서처럼 계정을 만들 수 있고, 정보를 가져오거나(조회), 수정, 삭제할 수도 있다.
삭제할 시에는 고객, 판매자의 ID, 이름, PW를 기입한 뒤 맞는지 확인한 뒤 삭제한다.
판매자의 경우에는 로그인한 회원의 정보를 가져올 수 있다. [5][36][37][38]


4. 상품 - 상품의 기본 정보인 상품 이름, 가격, 정보, 상품번호 등을 기입한 뒤 물품 등록. 
상품 ID는 등록한 순서대로 부여한다. 물품을 생성, 조회, 수정, 삭제할 수 있다.


5. 장바구니 - 장바구니의 기본 정보인 장바구니 이름, 장바구니 내 상품의 총 개수, 가격 총합, 장바구니 번호 등을
기입한 뒤 등록한다. 장바구니 ID는 등록 순서대로 부여된다. 장바구니를 생성, 조회, 수정, 삭제할 수 있다. 


6. 주문 - 주문 1개당 여러 개의 물품을 추가할 수 있다. 주문의 기본 정보 주문 이름, 소비자 ID, 장바구니 ID를 기입하고,
각 물품 당 상품 ID, 상품 이름, 주문한 상품 개수 등을 입력한다. 주문 ID, 주문 물품의 ID는 주문한 순서대로 부여된다.
주문, 주문 물품 명단을 추가, 조회, 수정, 삭제할 수 있다. [6]~[28] 

소비자를 계정으로 누가 어떤 주문을 했고, 주문 내 어떤 물품을 주문했는지 주문 정보를 가져올 수 있다. [39] 특정한 주문을 할 때는 
특정 주문과 주문 내 모든 상품들 정보 가져올 수 있고,[20]~[24] 한 번에 전체 조회 시 모든 주문과 주문 내
모든 상품들 정보 가져올 수 있다.[41]~[46] 특히 [43]


7. 소비자 리뷰 - 소비자 리뷰의 기본 정보인 카테고리, 소비자 ID, 상품 ID, 점수, 제목, 내용 등을 기입한 뒤 등록한다.
소비자 리뷰 번호는 등록 순서대로 부여된다. 소비자 리뷰를 생성, 조회, 수정, 삭제할 수 있다.
만들 때는 제목, 내용을 필수로 하고, 점수에 제약을 걸어 조건에 맞게 정보를 작성한다. [4][29][30][35]


8. 판매자 리뷰 - 판매자 리뷰의 기본 정보인 카테고리, 판매자 ID, 점수, 제목, 내용 등을 기입한 뒤 등록한다.
판매자 리뷰 번호는 등록 순서대로 부여된다. 판매자 리뷰를 생성, 조회, 수정, 삭제할 수 있다.
만들 때는 제목, 내용을 필수로 하고, 제목, 내용, 점수에 제약을 걸어 조건에 맞게 정보를 작성한다.[4][29][30][35]


9. ResponseEntity를 이용해 http 요청을 보낸 뒤 판매자/고객, 상품, 장바구니, 주문,
소비자 리뷰, 판매자 리뷰를 등록, 조회, 수정, 삭제한다. [3][4][5]


10. 새 계정(소비자/판매자 계정)을 만들 때는 PW, 이름에, 새 상품, 장바구니, 주문을
만들 때는 이름을 필수로 하고, 제약을 걸어 조건에 맞게 정보를 작성한다. [3][4][5]


11. 이름 중복 방지 - 판매자, 소비자, 물품, 장바구니, 주문, 소비자 리뷰, 판매자 리뷰를 만들거나 수정할 시에는 
DuplicationNameException 을 통해 주요 키의 같은 이름이 생기지 않도록 하였다. [4][31][32][33][34]


12. 상품, 장바구니, 소비자 리뷰, 판매자 리뷰는 전체 조회 시 한 번에 모두 정보를 가져올 수 있다.(조회 가능)[40]

### build.gradle
Spring Web, Spring Data JPA, H2 Database, Lombok, Spring Security, Validation [5]

### 기술 스택
Java, Spring, H2 Database [5]

### ERD
<img width="1063" alt="스크린샷 2024-12-15 오후 3 37 29 (1)" src="https://github.com/user-attachments/assets/804d55d8-f07e-48ca-8ef1-1927885910a1" />

[5][47]~[51]
