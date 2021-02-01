import java.util.ArrayList;
import java.util.Random;

public class Dealer {
    private int capacity;
    private int speed;
    int startMoney;
    private int money;
    ArrayList<Product> products;
    private Country country;
    private int distance;
    int days = 1;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //dealer constructor
    public Dealer() {
        products = new ArrayList<>();
        Random r =new Random();
        speed = 3;
        capacity = 100;
        money = 100;
        country = Country.getCountry();
        distance = r.nextInt(20)+80;
        startMoney = money;
    }

    @Override
    public String toString() {
        return  "We are starting our road to "+country+ " distance is "+distance+
                "\n We bought:"+
                "\n"+products+
                "\n" + "Speed of our track is "+speed+
                "\n" + "Money we have after "+money+"\n";
    }

    public void getProducts(){
        int count =0 ;
        while (count<6){
            Product product = new Product(count);
            if (product.getWeight()<capacity && product.getPrice()<money){
                products.add(product);
                this.setMoney(this.getMoney()-product.getPrice());
                this.setCapacity(this.capacity - product.getWeight());
            }else {
                break;
            }
            count++;
        }
    }
    public void startRoad(){
        if (distance<=0){
            System.out.println("You are in "+country);
            printStatistic();
        }else {
            Random r = new Random();
            int n = r.nextInt(7);
            switch (n){
                case 0:
                    System.out.println(days+" day!");
                    Operations.normalDay(this);
                    days++;
                    break;
                case 1:
                    System.out.println(days+" day!");
                    Operations.rainyDay(this);
                    days++;
                    break;
                case 2:
                    System.out.println(days+" day!");
                    Operations.GoodRoad(this);
                    days++;
                    break;
                case 3:
                    System.out.println(days+" day!");
                    Operations.wheelBroke(this);
                    days++;
                    break;
                case 4:
                    System.out.println(days+" day!");
                    Operations.river(this);
                    days++;
                    break;
                case 5:
                    System.out.println(days+" day!");
                    Operations.metLocal(this);
                    days++;
                    break;
                case 6:
                    System.out.println(days+" day!");
                    Operations.robbers(this);
                    days++;
                    break;
        }
        if (products.size()>0){
            startRoad();
        }else {
            System.out.println("There is no products, rubbers take all!");
        }
        }
    }

    private void printStatistic() {
        int totalPrice = 0;
        int moneyWas = 0;
        for (Product p:products
             ) {
            System.out.println("I bought "+ p.getType()+" for "+p.getPrice()+"; state is "+ p.getState() +" sell it for "+String.format("%.2f",p.getPrice()*p.getState().getI()));
            totalPrice+=p.getPrice()*p.getState().getI();
            moneyWas+=p.getPrice();
        }
        System.out.println("______________________________________________________");
        if (products.size()==0){
            System.out.println("Robbers have your all products, you are bankrupt!");
        }else {
            System.out.println("I had money "+ (startMoney) + " And after we have "+(totalPrice+money));
        }
    }
}
