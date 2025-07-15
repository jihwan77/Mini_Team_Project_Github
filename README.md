



# JDBC 요아정 장바구니 시스템

## 🦕Team
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/jihwan77">
        <img src="https://avatars.githubusercontent.com/jihwan77" width="150px;" alt=""/>
        <br />
        <sub><b>황지환</b></sub>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/Gill010147">
        <img src="https://avatars.githubusercontent.com/Gill010147" width="150px;" alt=""/>
        <br />
        <sub><b>황병길</b></sub>
      </a>
    
  </tr>
</table>
<hr>

## 📋 프로젝트 소개

요아정(요거트 아이스크림의 정석) 브랜드의 상품 관리 및 장바구니 시스템입니다.  
JDBC를 사용한 데이터베이스 연동과 메모리 기반의 장바구니 관리 기능을 제공합니다.

## 🎯 프로젝트 목표

- **JDBC 기술 활용**: 순수 JDBC를 사용한 데이터베이스 연동 구현
- **MVC 패턴 적용**: Model-View-Controller 아키텍처 적용
- **실무 중심 설계**: 실제 요아정 브랜드의 상품 데이터를 활용한 현실적인 시스템 구현

## 🛠️ 기술 스택

- **언어**: Java 17
- **데이터베이스**: MySQL
- **빌드 도구**: Maven
- **라이브러리**: 
  - Lombok (보일러플레이트 코드 감소)
  - JUnit (테스트)
  - MySQL Connector (JDBC 드라이버)

## 📁 프로젝트 구조

```
gitProject/
├── src/
│   ├── controller/
│   │   └── Controller.java          # 전체 비즈니스 로직 제어
│   ├── model/
│   │   ├── ProductDAO.java          # 상품 DB 접근 객체
│   │   ├── ShoppingCartDAO.java     # 장바구니 메모리 관리
│   │   └── domain/
│   │       ├── ProductDTO.java      # 상품 데이터 객체
│   │       └── ShoppingCartDTO.java # 장바구니 데이터 객체
│   ├── view/
│   │   ├── StartView.java           # 메인 사용자 인터페이스
│   │   ├── SuccessView.java         # 성공 메시지 출력
│   │   └── FailView.java            # 오류 메시지 출력
│   └── util/
│       └── DBUtil.java              # 데이터베이스 연결 유틸리티
├── dbinfo.properties               # 데이터베이스 연결 정보
└── pom.xml                         # Maven 의존성 관리
```

## 🔧 주요 기능

### 1. 상품 관리 시스템
- **전체 상품 목록 조회**: 데이터베이스에서 모든 상품 정보 조회
- **상품 추가**: 새로운 상품을 데이터베이스에 등록
- **상품 삭제**: 기존 상품을 데이터베이스에서 제거
- **상품 수정**: 기존 상품 정보 업데이트

### 2. 장바구니 시스템
- **장바구니 담기**: 선택한 상품을 메모리 기반 장바구니에 추가
- **장바구니 제거**: 장바구니에서 특정 상품 제거
- **장바구니 목록 조회**: 현재 장바구니 내용 및 총 금액/칼로리/무게 정보 확인

### 3. 데이터베이스 연동
- **JDBC 활용**: 순수 JDBC API를 사용한 데이터베이스 연결 및 조작
- **Connection Pool**: 효율적인 데이터베이스 연결 관리
- **트랜잭션 처리**: 데이터 일관성 보장

## 💾 데이터베이스 설계

### 상품 테이블 (Product)
- `id` (INT): 상품 고유 식별자
- `name` (VARCHAR): 상품명
- `price` (INT): 가격
- `kcal` (INT): 칼로리
- `gram` (INT): 무게
- `category` (VARCHAR): 상품 카테고리

### 요아정 상품 카테고리
- **곡물/시리얼류**: 그래놀라, 초코 그래놀라, 오레오 오즈 등
- **견과/씨앗류**: 아몬드 분태, 코코넛 청크, 카카오 닙스 등
- **소스/특수토핑**: 벌집꿀, 초코쉘, 초코소스 등
- **치즈/케이크류**: 큐브 치즈케이크, 슈레드 치즈 등
- **과일류**: 바나나, 딸기, 블루베리 등
- **요거트/아이스크림**: 플레인 요거트, 그릭요거트 등

## 🚀 실행 방법

### 1. 환경 설정
```bash
# MySQL 서버 실행
# 데이터베이스 생성
CREATE DATABASE fisa;
```

### 2. 데이터베이스 연결 정보 설정
```properties
# dbinfo.properties
jdbc.driver=com.mysql.cj.jdbc.Driver
jdbc.url=jdbc:mysql://127.0.0.1:3306/fisa
jdbc.id=root
jdbc.pw=root
```

### 3. 프로젝트 실행
```bash
# Maven 빌드
mvn compile

# 메인 클래스 실행
java -cp target/classes view.StartView
```

## 📱 사용 방법

### 메인 메뉴
```
1. 전체 상품 목록 보기
2. 상품 선택 (장바구니 담기)
3. 상품 제외 (장바구니 제외하기)
4. 장바구니 목록
5. 상품 추가하기
6. 상품 삭제하기
7. 상품 수정하기
```

### 사용 예시
```
번호 입력 : 1
모든 상품의 정보입니다.
상품 id=1, name=그래놀라, price=2000, kcal=55, gram=30, category=곡물/시리얼류

번호 입력 : 2
선택할 상품 번호를 입력하세요 : 1
1장바구니 담기 성공!!!

번호 입력 : 4
현재 장바구니 목록입니다 :
상품 id=1, name=그래놀라, price=2000, kcal=55, gram=30, category=곡물/시리얼류
장바구니에 담은 상품은 1개 입니다.
총 가격은 2000원 입니다.
총 칼로리는 55kcal 입니다.
총 그램은 30g 입니다.
```

## 🔍 핵심 기술 구현

### 1. JDBC 연결 관리
```java
public class DBUtil {
    private static Properties dbinfo = new Properties();
    
    static {
        try {
            dbinfo.load(new FileInputStream("dbinfo.properties"));
            Class.forName(dbinfo.getProperty("jdbc.driver"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            dbinfo.getProperty("jdbc.url"),
            dbinfo.getProperty("jdbc.id"),
            dbinfo.getProperty("jdbc.pw")
        );
    }
}
```

### 2. DAO 패턴 구현
```java
public class ProductDAO {
    public static ArrayList<ProductDTO> getAllProduct() throws SQLException {
        // JDBC를 사용한 상품 조회 로직
    }
    
    public static boolean addProduct(ProductDTO product) throws SQLException {
        // JDBC를 사용한 상품 추가 로직
    }
}
```

### 3. 메모리 기반 장바구니 관리
```java
public class ShoppingCartDAO {
    public static boolean cartAddProduct(int id, ShoppingCartDTO shoppingArray) {
        // 메모리 기반 장바구니 추가 로직
        ArrayList<ProductDTO> cartList = ProductDAO.getAllProduct();
        // 상품 검색 및 장바구니 추가
    }
}
```

## 🎨 프로젝트 특징

### 1. 실무 중심 설계
- **실제 브랜드 활용**: 요아정 프랜차이즈의 실제 상품 데이터 활용
- **현실적인 기능**: 실제 매장에서 사용할 수 있는 기능들로 구성

### 2. 학습 목적 최적화
- **순수 JDBC**: 프레임워크 없이 순수 JDBC API 활용
- **명확한 구조**: MVC 패턴을 명확히 구분하여 학습 효과 극대화

### 3. 확장 가능성
- **모듈화 설계**: 각 기능이 독립적으로 구현되어 확장 용이
- **표준 패턴 적용**: 업계 표준 패턴을 적용하여 유지보수성 향상

## 🚨 주의사항

### 1. 데이터베이스 설정
- MySQL 서버가 실행 중이어야 함
- 데이터베이스 연결 정보가 올바르게 설정되어야 함

### 2. 의존성 관리
- Maven을 통한 의존성 관리 필요
- MySQL Connector 버전 호환성 확인

### 3. 장바구니 데이터
- 장바구니 데이터는 메모리에 저장되어 프로그램 종료 시 삭제됨
- 영구 저장을 위해서는 데이터베이스 연동 필요



## 🚀 트러블 슈팅


### 🟢 1. static 멤버 호출 관련 트러블슈팅
문제
static으로 선언했는데 객체 생성해서 호출해도 되나?

핵심 포인트

static 멤버는 클래스에 소속됨.

클래스명.멤버 형태로 호출하는 것이 권장됨.

객체 생성해서도 접근 가능하지만 혼동을 유발하므로 비권장.

static 멤버는 모든 인스턴스에서 공유됨.

✅ 해결책

ClassName.staticMethod()로 호출할 것.

객체 생성해서 호출하지 않기(혼동 방지).

 ### 🟢 2. 싱글턴 패턴 적용 관련 트러블슈팅
문제
DAO에 static 메서드만 쓰는데 굳이 싱글턴 패턴을 써야 하나?

핵심 포인트

static 메서드만 쓰면 상태 공유, 다형성, 유연성 부족.

싱글턴 패턴은 단일 인스턴스 관리 + 상태 공유 + 테스트 대체 용이.

리소스를 안전하게 관리할 수 있음(DB 커넥션, 설정 등).

✅ 해결책

상태나 자원을 관리하거나 다형성을 고려한다면 싱글턴 패턴 적용.

메서드를 인스턴스 메서드로 전환.

사용 시 ProductDAO.getInstance()로 호출.

 ### 🟢 3. DAO에서 Exception 처리 관련 트러블슈팅
문제
DAO에서 SQLException을 직접 처리하지 않고 throws로 던져야 하나?

핵심 포인트

책임 분리: DAO는 DB 작업만, 예외 처리(로깅·사용자 알림)는 Controller나 Service에서 담당.

유연성 확보: 상위 계층에서 예외에 맞는 처리(재시도, 트랜잭션 롤백 등) 가능.

일관된 예외 흐름: 계층별로 예외 처리 정책을 통일할 수 있음.

✅ 해결책

DAO 메서드에 throws SQLException 선언.

Controller에서 try-catch로 예외 처리.


## 📌 결론 및 회고
>
>
>

## 📈 향후 개선 사항

### 1. 기능 확장
- [ ] 주문 처리 시스템
- [ ] 재고 관리 시스템
- [ ] 사용자 인증 시스템
- [ ] 웹 인터페이스 구현

### 2. 기술 개선
- [ ] Connection Pool 적용
- [ ] 트랜잭션 관리 강화
- [ ] 예외 처리 개선
- [ ] 로깅 시스템 도입

### 3. 성능 최적화
- [ ] 쿼리 최적화
- [ ] 캐싱 시스템 도입
- [ ] 인덱스 설계 개선


