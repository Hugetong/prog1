public class Warehouse {
    public static void main(String[] args) {
        //Product[] products = Product.getRandomProducts(20);
        /*
        for (Product product : products) {
            System.out.println(product);
        }*/
        Product[] products = Product.getRandomProducts(20);
        Product[][] gang = new Product[10][2];
        int numb = 0;
        for (int i =0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                gang[i][j] = products[numb++];
            }
        }
        System.out.println("\nUnsorted:");
        printgang(gang);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = i; k < 10; k++) {
                    for (int l = (k == i) ? (j + 1) : 0; l < 2; l++) {
                        if (gang[i][j].getCategory().toString().charAt(0) > gang[k][l].getCategory().toString().charAt(0) ||
                                (gang[i][j].getCategory().toString().charAt(0) == gang[k][l].getCategory().toString().charAt(0) &&
                                        gang[i][j].getPrice() > gang[k][l].getPrice())) {
                            Product temp = gang[i][j];
                            gang[i][j] = gang[k][l];
                            gang[k][l] = temp;
                        }
                    }
                }
            }
        }

        // 최종적으로 정렬된 2차원 배열 출력
        System.out.println("\nSorted:");
        printgang(gang);
    }
        public static void printgang(Product[][] gang) {
            System.out.println(" \t\t[0]\t\t\t\t[1]");
            for (int i = 0; i < gang.length; i++) {
                System.out.print("[" + i + "]");
                for (int j = 0; j < gang[i].length; j++) {
                    System.out.print(" " + gang[i][j] + "\t\t");
                }
                System.out.println();
            }
        }


        /*// 배열 정렬
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length - 1 - i; j++) {
                // 카테고리로 먼저 정렬
                if (products[j].getCategory().compareTo(products[j+1].getCategory()) > 0) {
                    Product temp = products[j];
                    products[j] = products[j+1];
                    products[j+1] = temp;
                }
                // 카테고리가 같다면 가격으로 정렬
                else if (products[j].getCategory() == products[j+1].getCategory() &&
                        products[j].getPrice() > products[j+1].getPrice()) {
                    Product temp = products[j];
                    products[j] = products[j+1];
                    products[j+1] = temp;
                }
            }
        }*/

        /*// 정렬된 배열 출력
        System.out.println("\nSorted:");
        for (Product product : products) {
            System.out.println(product);
        }*/

}
