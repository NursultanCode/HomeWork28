import java.util.Random;

public class Operations {
    public static void normalDay(Dealer dealer){
        dealer.setDistance(dealer.getDistance()-dealer.getSpeed());
        System.out.println("It was normal day!");
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }
    public static void rainyDay(Dealer dealer){
        dealer.setDistance(dealer.getDistance()-(dealer.getSpeed()-2));
        System.out.println("It was rainy day, I moved slow!");
        Random r = new Random();
        int n = r.nextInt(3);
        if (n==0){
            flawed(dealer);
        }else {
            System.out.println("You are lucky, Your products state not changed!");
        }
        if (dealer.getDistance()>0)System.out.println("We have "+dealer.getDistance()+"\n");
    }
    public static void GoodRoad(Dealer dealer){
        dealer.setDistance(dealer.getDistance()-(dealer.getSpeed()+2));
        System.out.println("You have speed UP");
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }

    public static void wheelBroke(Dealer dealer) {
        System.out.println("We have broke wheels, and stay for day!");
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }

    public static void river(Dealer dealer) {
        System.out.println("River stopped me!");
    }

    public static void metLocal(Dealer dealer) {
        Random r = new Random();
        int n = r.nextInt(4)+3;
        System.out.println("Met for local and cut part of road!");
        dealer.setDistance(dealer.getDistance()-(dealer.getSpeed()+n));
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }


    public static void robbers(Dealer dealer) {
        System.out.println("Your truck is caught by Robbers!");
        if (dealer.getMoney()>0){
            System.out.println("Robbers take money 1 som!");
            dealer.setMoney(dealer.getMoney()-1);
        }else {
            int max = 0;
            int pos = 0;
            for (int i = 0; i <dealer.products.size(); i++) {
                if (dealer.products.get(i).getPrice()>max){
                    max = dealer.products.get(i).getPrice();
                    pos = i;
                }
            }
            if (dealer.products.size()==0){
                System.out.println("There is no product to robbers!");
            }else {
                System.out.println("Robbers take your product "+dealer.products.get(pos).getType());
                dealer.products.remove(pos);
            }

        }
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }

    public static void trade(Dealer dealer){
        Random r = new Random();
        int n = r.nextInt(dealer.products.size());
        dealer.setMoney((int) (dealer.getMoney()+dealer.products.get(n).getPrice()*dealer.products.get(n).getState().getI()));
        System.out.println("We have sold "+ dealer.products.get(n).getType());
        System.out.println("Our money is " + dealer.getMoney());
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }

    public static void flawed(Dealer dealer){
        Random r = new Random();
        System.out.println("The product is flawed!");
        int a = r.nextInt(dealer.products.size());
        switch (dealer.products.get(a).getState()){
            case NORMAL -> dealer.products.get(a).setState(State.SLIGHTLY_FLAWED);
            case SLIGHTLY_FLAWED -> dealer.products.get(a).setState(State.HALF_FLAWED);
            case HALF_FLAWED -> dealer.products.get(a).setState(State.ALMOST_ALL_FLAWED);
            case ALMOST_ALL_FLAWED, ALL_FLAWED -> dealer.products.get(a).setState(State.ALL_FLAWED);
        }
        if (dealer.getDistance()>0) System.out.println("We have "+dealer.getDistance()+"\n");
    }
}
