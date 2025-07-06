package model;

import java.util.ArrayList;

import model.domain.Product;

public class Database {
	
private static ArrayList<Product> productArray = new ArrayList<>();
	
	static {
		
			// 곡물/시리얼류
		
			productArray.add(new Product(1, "그래놀라", 2000, 55, 30, "곡물/시리얼류"));
			productArray.add(new Product(2, "초코 그래놀라", 2200, 65, 30, "곡물/시리얼류"));
			productArray.add(new Product(3, "오레오 오즈", 2000, 60, 25, "곡물/시리얼류"));
			productArray.add(new Product(4, "콘푸라이트", 1800, 45, 20, "곡물/시리얼류"));
			productArray.add(new Product(5, "후르트링", 1800, 40, 20, "곡물/시리얼류"));
	
			productArray.add(new Product(6, "아몬드 분태", 2000, 50, 10, "견과/씨앗류"));
			productArray.add(new Product(7, "코코넛 청크", 2000, 60, 10, "견과/씨앗류"));
			productArray.add(new Product(8, "카카오 닙스", 2200, 55, 8, "견과/씨앗류"));
			productArray.add(new Product(9, "햄프씨드", 2200, 45, 8, "견과/씨앗류"));
			productArray.add(new Product(10, "치아씨드", 2000, 40, 8, "견과/씨앗류"));
	
			productArray.add(new Product(11, "벌집꿀(벌꿀집)", 3500, 95, 15, "소스/특수토핑"));
			productArray.add(new Product(12, "초코쉘", 2500, 98, 20, "소스/특수토핑"));
			productArray.add(new Product(13, "초코소스", 1000, 35, 10, "소스/특수토핑"));
			productArray.add(new Product(14, "연유", 1000, 30, 10, "소스/특수토핑"));
			productArray.add(new Product(15, "땅콩버터", 1200, 55, 12, "소스/특수토핑"));
	
			productArray.add(new Product(16, "큐브 치즈케이크", 3000, 80, 20, "치즈/케이크류"));
			productArray.add(new Product(17, "슈레드 치즈", 2500, 50, 15, "치즈/케이크류"));
			productArray.add(new Product(18, "치즈큐브", 3000, 50, 20, "치즈/케이크류"));
			productArray.add(new Product(19, "뉴욕치즈케이크", 3500, 90, 25, "치즈/케이크류"));
			productArray.add(new Product(20, "로투스 크럼블", 2500, 60, 15, "치즈/케이크류"));
	
			productArray.add(new Product(21, "바나나", 1800, 35, 40, "과일류"));
			productArray.add(new Product(22, "딸기", 2500, 25, 35, "과일류"));
			productArray.add(new Product(23, "블루베리", 2800, 20, 30, "과일류"));
			productArray.add(new Product(24, "자몽", 3500, 30, 50, "과일류"));
			productArray.add(new Product(25, "망고", 2800, 40, 40, "과일류"));

			productArray.add(new Product(101, "플레인 요거트 아이스크림", 4500, 90, 100, "요거트/아이스크림"));
			productArray.add(new Product(102, "저지방 요거트 아이스크림", 4700, 85, 100, "요거트/아이스크림"));
			productArray.add(new Product(103, "그릭요거트 아이스크림", 5000, 110, 100, "요거트/아이스크림"));
			productArray.add(new Product(104, "플레인 요거트 컵", 4800, 80, 120, "요거트/아이스크림"));
			productArray.add(new Product(105, "그릭요거트 컵", 5200, 105, 120, "요거트/아이스크림"));
			productArray.add(new Product(106, "플레인 프로틴 요거트", 5200, 120, 120, "요거트/아이스크림"));
			productArray.add(new Product(107, "그릭 프로틴 요거트", 5500, 135, 120, "요거트/아이스크림"));
			productArray.add(new Product(108, "플레인 아이스크림 바", 3200, 60, 70, "요거트/아이스크림"));
			productArray.add(new Product(109, "그릭 아이스크림 바", 3500, 75, 70, "요거트/아이스크림"));
			productArray.add(new Product(110, "요아정 미니컵", 2500, 50, 60, "요거트/아이스크림"));

		}
	
		public static ArrayList<Product> getAllProduct(){
			return productArray;
		}
		
		public static void addProduct(Product data) {
			productArray.add(data);
		}
		
		public static void deleteProduct(int index) {
			productArray.remove(index);
		}
		
		public static void updateProduct(int index, String name, int price, int kcal, int gram, String category) {
			Product product = productArray.get(index);
			product.setName(name);
			product.setPrice(price);
			product.setKcal(kcal);
			product.setGram(gram);
			product.setCatagory(category);
			
			productArray.remove(index);
			productArray.add(product);
		}
}

