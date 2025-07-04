package view;

public class YoajeongToppingView {

    // 토핑 정보를 담는 클래스
    static class Topping {
        int id;
        String name;
        int price;
        int kcal;
        int gram;
        String category;

        Topping(int id, String name, int price, int kcal, int gram, String category) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.kcal = kcal;
            this.gram = gram;
            this.category = category;
        }
    }

    public static void main(String[] args) {
        // 데이터 셋팅
        Topping[] toppings = {
            // 곡물/시리얼류
            new Topping(1, "그래놀라", 2000, 55, 30, "곡물/시리얼류"),
            new Topping(2, "초코 그래놀라", 2200, 65, 30, "곡물/시리얼류"),
            new Topping(3, "오레오 오즈", 2000, 60, 25, "곡물/시리얼류"),
            new Topping(4, "콘푸라이트", 1800, 45, 20, "곡물/시리얼류"),
            new Topping(5, "후르트링", 1800, 40, 20, "곡물/시리얼류"),
            // 견과/씨앗류
            new Topping(6, "아몬드 분태", 2000, 50, 10, "견과/씨앗류"),
            new Topping(7, "코코넛 청크", 2000, 60, 10, "견과/씨앗류"),
            new Topping(8, "카카오 닙스", 2200, 55, 8, "견과/씨앗류"),
            new Topping(9, "햄프씨드", 2200, 45, 8, "견과/씨앗류"),
            new Topping(10, "치아씨드", 2000, 40, 8, "견과/씨앗류"),
            // 소스/특수토핑
            new Topping(11, "벌집꿀(벌꿀집)", 3500, 95, 15, "소스/특수토핑"),
            new Topping(12, "초코쉘", 2500, 98, 20, "소스/특수토핑"),
            new Topping(13, "초코소스", 1000, 35, 10, "소스/특수토핑"),
            new Topping(14, "연유", 1000, 30, 10, "소스/특수토핑"),
            new Topping(15, "땅콩버터", 1200, 55, 12, "소스/특수토핑"),
            // 치즈/케이크류
            new Topping(16, "큐브 치즈케이크", 3000, 80, 20, "치즈/케이크류"),
            new Topping(17, "슈레드 치즈", 2500, 50, 15, "치즈/케이크류"),
            new Topping(18, "치즈큐브", 3000, 50, 20, "치즈/케이크류"),
            new Topping(19, "뉴욕치즈케이크", 3500, 90, 25, "치즈/케이크류"),
            new Topping(20, "로투스 크럼블", 2500, 60, 15, "치즈/케이크류"),
            // 과일류
            new Topping(21, "바나나", 1800, 35, 40, "과일류"),
            new Topping(22, "딸기", 2500, 25, 35, "과일류"),
            new Topping(23, "블루베리", 2800, 20, 30, "과일류"),
            new Topping(24, "자몽", 3500, 30, 50, "과일류"),
            new Topping(25, "망고", 2800, 40, 40, "과일류")
        };

        // 카테고리별로 출력
        String[] categories = {"곡물/시리얼류", "견과/씨앗류", "소스/특수토핑", "치즈/케이크류", "과일류"};
        for (String cat : categories) {
            System.out.println("==== " + cat + " ====");
            System.out.printf("%-4s %-15s %-8s %-10s %-8s\n", "번호", "상품명", "가격(원)", "칼로리", "그람수");
            for (Topping t : toppings) {
                if (t.category.equals(cat)) {
                    System.out.printf("%-4d %-15s %-8d %-10d %-8d\n", t.id, t.name, t.price, t.kcal, t.gram);
                }
            }
            System.out.println();
        }
    }
}
