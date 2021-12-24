package until;

public class CheckMoney {
    
    public static Boolean check(Integer money) {

        if (money==10000||money ==20000 || money==50000 || money == 100000 || money == 200000) {
            return true;
        }

        return false;
    }
}