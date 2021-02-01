public class Main {
    public static void main(String[] args) {
        Dealer dealer = new Dealer();
        dealer.getProducts();
        System.out.println(dealer.toString());
        dealer.startRoad();
    }
}
