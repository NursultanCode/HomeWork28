import java.util.Objects;
import java.util.Random;

public class Product {
    private int weight;
    private ProductType type;
    private int price;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private State state;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int i) {
        Random random = new Random();
        state = State.NORMAL;
        type = ProductType.getProduct(i);
        weight = random.nextInt(10)+1;
        price = type.getPrice()*weight;
    }

    @Override
    public String toString() {
        return "\n" + type + " " + weight + " kg, price is " + price + "soms!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return type == product.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
