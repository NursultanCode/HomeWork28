import java.util.Random;

public enum Country {
    BISHKEK,
    TALAS,
    NARYN,
    JALAL_ABAD,
    OSH,
    BATKEN;
    public static Country getCountry(){
        Random r = new Random();
        int n = r.nextInt(6);
        return switch (n) {
            case 0 -> Country.BISHKEK;
            case 1 -> Country.TALAS;
            case 2 -> Country.NARYN;
            case 3 -> Country.JALAL_ABAD;
            case 4 -> Country.OSH;
            default -> Country.BATKEN;
        };
    }
}
