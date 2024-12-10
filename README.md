# 이커머스 - 물품 구매, 판매

### 기능
1. 회원 가입: 판매자/고객의 PW, 이름, 계좌번호, 전화번호를 기입한 뒤 계정을 생성한다. ID는 등록한 순서대로 부여받는다.

2. 로그인/로그아웃: 판매자/고객이 회원가입을 할 때 만든 계정의 이름, PW를 기입한 뒤 판매자.고객의 이름, 
PW가 맞는지 확인한 후에 로그인을 하게 한다. 로그인한 회원인 고객/판매자의 정보를 받아 온다. 로그아웃 기능도 가능하다.

3. 고객/판매자(회원)- 1에서처럼 계정을 만들 수 있고, 정보를 조회, 수정, 삭제할 수도 있다.
삭제할 시에는 고객, 판매자의 ID, PW를 기입한 뒤 맞는지 확인한 뒤 삭제한다. 판매자의 경우에는 로그인한 회원의 정보를 가져올 수 있다.

4. 상품 - 상품의 기본 정보인 상품 이름, 가격, 정보, 상품번호 등을 기입한 뒤 물품 등록. 
상품 ID는 등록한 순서대로 부여한다. 물품을 생성, 조회, 수정, 삭제할 수 있다.

5. 장바구니 - 장바구니의 기본 정보인 장바구니 이름, 장바구니 내 상품의 총 개수, 가격 총합, 장바구니 번호 등을
기입한 뒤 등록한다. 장바구니 ID는 등록 순서대로 부여된다. 장바구니를 생성, 조회, 수정, 삭제할 수 있다.

6. 주문 - 주문 1개당 여러 개의 물품을 추가할 수 있다. 주문의 기본 정보 주문 이름, 고객 ID, 장바구니 ID를 기입하고,
각 물품 당 상품 ID, 상품 이름, 주문한 상품 개수 등을 입력한다. 주문 ID, 주문 물품의 ID는 주문한 순서대로 부여된다.
주문, 주문 물품 명단을 추가, 조회, 수정, 삭제할 수 있다.

7. ResponseEntity를 이용해 http 요청을 보낸 뒤 판매자/고객, 상품, 장바구니, 주문을 등록, 조회, 수정, 삭제한다.

8. 새 계정을 만들 때는 PW, 이름에, 새 상품, 장바구니, 주문을 만들 때는 이름에 제약을 걸어 조건에 맞게 정보를 작성한다.[3]

### build.gradle
Spring Web, Spring Data JPA, H2 Database, Lombok, Spring Security, Validation [3]

### 기술 스택
Java, Spring, H2 Database [3]

### ERD

### 출처
[1] 미상, 제로베이스, 미상, Part3._예제를 통해 학습하는 스프링(Java)_Chapter 01.사전 준비, P4

[2] 미상, 제로베이스, 미상, Part3._예제를 통해 학습하는 스프링(Java)_Chapter 01.사전 준비, P10

[3] create 관련 기능 모두 - mgcztech576(본인), Github, ecommercemain, 
https://github.com/mgcztech576/ecommercemain.git, 2023.10.16, [5]의 전반적인 출처

[4] change 관련 기능 모두 - mtgv999(본인), Github, SpringAssignment2,
https://github.com/mtgv999/SpringAssignment2, 2024.05.16

[5] 프로젝트 전반적인 내용을 기반. Commit 방법 - mtgv999(본인), Github, Ecommerce,
https://github.com/mtgv999/Ecommerce, 2024.06.17

[6] chatgpt, response to "public class OrdersItem extends BaseEntity{ @Id @GeneratedValue(strategy = 
GenerationType.IDENTITY)~.productID(ordersRegister.getProductID()).build();}} OrdersRegister에서
한 번에 만들려고 하려면 어떻게 OrdersRegister를 수정해야 됩니까?", 
https://chatgpt.com/c/675295af-86d8-8006-8122-bf1c710d828b, 2024.12.05~07 사이, https://chatgpt.com/

[7] chatgpt, response to "public class Orders extends BaseEntity{@Id//주문 @GeneratedValue(strategy = 
GenerationType.IDENTITY)~ private int ordersCount;//주문한 상품 개수 private Long cost;//상품 가격 
private String category;//분류의 내용을 수정하고 싶은데 어떤 클래스에다 어떤 내용을 추가/수정해야 되나요?",
https://chatgpt.com/c/675295af-86d8-8006-8122-bf1c710d828b, 2024.12.05~07 사이, https://chatgpt.com/

[8] chatgpt, response to "public class OrdersItem extends BaseEntity{ @Id @GeneratedValue(strategy =
GenerationType.IDENTITY)~ {"consumerID": 12, "productID": 14,"productName": "15","sellerID": 0,"ordersCount": 0,
"cost": 0,"category": ""}]}에 있는 내용: 즉 각 아이템을 수정하려면 어떻게 OrdersRegister의 내용을 수정해야 됩니까?",
https://chatgpt.com/c/675295af-86d8-8006-8122-bf1c710d828b, 2024.12.05~07 사이, https://chatgpt.com/

[9] chatgpt, response to "public class OrdersItem extends BaseEntity{ @Id @GeneratedValue(strategy = 
GenerationType.IDENTITY)~.productID(ordersRegister.getProductID()).build();}} OrdersRegister에서
한 번에 만들려고 하려면 어떻게 OrdersRegister를 수정해야 됩니까?",
https://chatgpt.com/c/675295af-86d8-8006-8122-bf1c710d828b, 2024.12.05~07 사이, https://chatgpt.com/

[10] chatgpt, response to "{"ordersName": "1230","consumerID": 12,"cartID": 0,~private String category;//분류}
의 내용을 수정하려고 하는데 어떻게 해야 Service, Controller, Orders, OrdersItem, Repository 등의 클래스를 어떻게 바꿔야 가능합니까?
https://chatgpt.com/c/6753ea12-1188-8006-9a14-c72ebcfdfa6e, 2024.12.05~07 사이, https://chatgpt.com/

[11] chatgpt, response to "public class Orders extends BaseEntity{@Id//주문 @GeneratedValue(strategy = 
GenerationType.IDENTITY)~@ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "orders_number") 
private Orders orders;}여기에서 내용을 어떻게 수정해야 productID/Name, sellerID,
orders, ordersCount, cost, category를 수정할 수 있나요",
https://chatgpt.com/c/67540226-ced0-8006-ac16-337a46ef706d, 2024.12.05~07 사이, https://chatgpt.com/

[12] chatgpt, response to "public class Orders extends BaseEntity{@Id//주문 @GeneratedValue(strategy = 
GenerationType.IDENTITY)~ private Long productID;//상품 ID} 에서 어떻게 해야 OrdersController/ 
OrdersService 클래스에서 여러 개의 물건을 주문 명단에다 포함시킬 수 있습니까?",
https://chatgpt.com/c/67505fcc-dfe8-8006-81ef-70e608a3745e, 2024.12.05~07 사이, https://chatgpt.com/

[13] chatgpt, response to "public class Orders extends BaseEntity{@Id//주문 @GeneratedValue(strategy =
GenerationType.IDENTITY) private ~ private Long productID;//상품 ID}에서 어떻게 해야 OrdersController/ 
OrdersService 클래스에서 여러 종류의 물건을 주문 명단에다 포함시킬 수 있습니까?",
https://chatgpt.com/c/67505fcc-dfe8-8006-81ef-70e608a3745e, 2024.12.05~07 사이, https://chatgpt.com/

[14] chatgpt, response to "public Orders createOrder(OrdersRequest ordersRequest) {Orders orders = 
new Orders();~"quantity": 1,"cost": 1200000}]} 형식으로 나오게 하려면 어떻게 코드를 고쳐야 되겠습니까?",
https://chatgpt.com/c/67505fcc-dfe8-8006-81ef-70e608a3745e, 2024.12.05~07 사이, https://chatgpt.com/

[15] chatgpt, response to "위 코드에서 OrdersItemRepository도 새로 만들어야 되나요?",
https://chatgpt.com/c/67505fcc-dfe8-8006-81ef-70e608a3745e, 2024.12.05~07 사이, https://chatgpt.com/

[16] chatgpt, response to "그러면 한 주문에 여러 종류의 물품이 담기려면 OrdersItemRepository 에다 어떤 코드를 넣어야 됩니까?",
https://chatgpt.com/c/67505fcc-dfe8-8006-81ef-70e608a3745e, 2024.12.05~07 사이, https://chatgpt.com/

[17] chatgpt, response to "public class OrdersService에서 public Orders createOrders
(OrdersRegister ordersRegister){Orders orders = new Orders();~{"productID": 102,"productName": "노트북",
"quantity": 1,"cost": 1200000 }]} 이런 결과가 나오나요? 한 주문에 여러 상품을 포함하는 경우입니다.,
https://chatgpt.com/c/6752e20c-7e10-8006-ad8c-978f90423485, 2024.12.05~07 사이, https://chatgpt.com/

[18] chatgpt, response to "### POST http://localhost:8080/orders/create Content-Type: application/json"
~"productID": 102, "productName": "노트북","quantity": 1,"cost": 1200000 }]},
https://chatgpt.com/c/6752e20c-7e10-8006-ad8c-978f90423485, 2024.12.05~07 사이, https://chatgpt.com/

[19] chatgpt, response to "public class Orders extends BaseEntity{@Id//주문 @GeneratedValue(strategy = 
GenerationType.IDENTITY) ~ @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "orders_number")
private Orders orders;}//[6]을 바탕으로 누가 어떤 주문을 했는 지 알 수 있으려면 코드를 어떻게 짜야 됩니까?",
https://chatgpt.com/c/6753ea12-1188-8006-9a14-c72ebcfdfa6e, 2024.12.05~07 사이, https://chatgpt.com/

[20] chatgpt, response to "{"ordersName": "1230","consumerID": 12,"cartID": 0,~조회~ @ManyToOne
(fetch = FetchType.LAZY)@JoinColumn(name = "orders_number")private Orders orders;}에서 코드를 어떻게 바꿔야 됩니까?",
https://chatgpt.com/c/67544a7c-5ecc-8006-ab3d-aa378910c64b, 2024.12.07 사이, https://chatgpt.com/

[21] chatgpt, response to "위 코드를 바탕으로 한 주문에 여러 개의 물품을 주문한 것에 대한 조회 가 가능한 코드 가능합니까?",
https://chatgpt.com/c/67544a7c-5ecc-8006-ab3d-aa378910c64b, 2024.12.07 사이, https://chatgpt.com/

[22] chatgpt, response to "위 코드에서 Controller에서 Service로, 다시 Service에서 Repository로 가는 코드와 
OrdersItem, Orders 코드를 활용해서 여러 개 물품을 주문한 것에 대한 조회에 관한 가능합니까?",
https://chatgpt.com/c/67544a7c-5ecc-8006-ab3d-aa378910c64b, 2024.12.07, https://chatgpt.com/

[23] chatgpt, response to "위 코드에서 Service는 클래스로 부탁드립니다. Class Service",
https://chatgpt.com/c/67544a7c-5ecc-8006-ab3d-aa378910c64b, 2024.12.07, https://chatgpt.com/

[24] chatgpt, response to "위 코드대로라면 조회는 되지만, 결과가 Response file saved.
> 2024-12-07T223910.200.json Response code: 200; Time: 86ms (86 ms); Content length: 
243588 bytes (243.59 kB) Cookies are preserved between requests:
> >C:\Users\OWNER\IdeaProjects\ECommerceA2\.idea\httpRequests\http-client.cookies 처럼 안 보입니다.
> 어떻게 해야 조회 결과를 볼 수 있나요?",
https://chatgpt.com/c/67544a7c-5ecc-8006-ab3d-aa378910c64b, 2024.12.07, https://chatgpt.com/

[25] chatgpt, response to "{"customerName": "John Doe", "orderName": "Electronics Order", "items":
[{"ordersItemID": 1}와 같은 결과가 나오려면 맨 위 코드에 기반한 http 요청에서 어떤 변수에 어떤 값을 대입해야 됩니까?
~"productID": 101, "productName": "Smartphone", "sellerID": 201, "ordersCount": 2,"cost": 500,
"category": "Electronics"}, {"ordersItemID": 2, "productID": 102, "productName": "Laptop", "sellerID": 202,
"ordersCount": 1, "cost": 1500,"category": "Electronics"}]}",
https://chatgpt.com/c/6753ea12-1188-8006-9a14-c72ebcfdfa6e, 2024.12.10, https://chatgpt.com/

[26] chatgpt, response to "제가 원한 결과는 주문번호를 통해 누가 어떤 주문을 했는지 그 결과를 가져오는 것입니다.
위의 createOrder를 getOrdersDetail로 바꿀 때 코드가 달라지나요? 그 전제하에  {"ordersName": "Electronics Order",
// orderName에 해당 "consumer": {"name": "John Doe" // customerName에 해당 },"ordersItems": [{"ordersItemID": 1,
"productID": 101, "productName": "Smartphone", "sellerID": 201, "ordersCount": 2, "cost": 500, 
"category": "Electronics"}, {"ordersItemID": 2, "productID": 102, "productName": "Laptop", "sellerID": 202,
"ordersCount": 1, "cost": 1500, "category": "Electronics"}]}의 결과를 조회하고 싶습니다.",
https://chatgpt.com/c/6753ea12-1188-8006-9a14-c72ebcfdfa6e, 2024.12.10, https://chatgpt.com/

[27] chatgpt, "그럼 위에 http 요청에서 어떤 변수에 어떤 값을 대입해야 되나요?",
https://chatgpt.com/c/6753ea12-1188-8006-9a14-c72ebcfdfa6e, 2024.12.10, https://chatgpt.com/

[28] chatgpt, response to "{"ordersName": "1230", "consumerID": 12, "cartID": 0, "ordersItems":
[{"consumerID": 12, "productID": 12, "productName": "13", ~ }의 내용을 수정하려고 하는데 어떻게 해야
Service, Controller, Orders, OrdersItem, Repository 등의 클래스를 어떻게 바꿔야 가능합니까?
private Orders orders;}//[6]을 바탕으로 누가 어떤 주문을 했는 지 알 수 있으려면 코드를 어떻게 짜야 됩니까?",
https://chatgpt.com/c/6753ea12-1188-8006-9a14-c72ebcfdfa6e, 2024.12.10, https://chatgpt.com/