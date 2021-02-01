import java.util.Random;

public enum ProductType {
    MEAT (4),
    DRIED (3),
    FRUITS (3),
    GRAIN (3),
    FLOUR (4),
    FABRICS (2),
    PAINT (5);
    private final int price;

    ProductType(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public static ProductType getProduct(int i){
        return switch (i) {
            case 0 -> ProductType.MEAT;
            case 1 -> ProductType.DRIED;
            case 2 -> ProductType.FRUITS;
            case 3 -> ProductType.GRAIN;
            case 4 -> ProductType.FLOUR;
            case 5 -> ProductType.FABRICS;
            default -> ProductType.PAINT;
        };
    }


}
