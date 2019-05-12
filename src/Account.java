import java.util.Random;

public class Account {

    private String IBAN;
    private Double credit;
    private static String[] alphabet = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public Account(){}

    public Account(String IBAN, Double credit){
        this.IBAN = IBAN;
        this.credit = credit;
    }

    public static String generateIBAN(String bankID, String accountNumber){

        String nation = "IT";
        String checkNumb = "";

        Random rndGen = new Random();
        int a = rndGen.nextInt(100);
        if (a <= 9) checkNumb += "0" + a;

        String CIN = alphabet[rndGen.nextInt(25)];

        return nation + checkNumb + CIN + bankID + accountNumber;
    }

    public String getIBAN() {
        return IBAN;
    }
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public Double getCredit() {
        return credit;
    }
    public void setCredit(Double credit) {
        this.credit = credit;
    }

    @Override
    public String toString(){
        return "Account with IBAN: " + this.getIBAN() + " ! Total credit is: " + this.getCredit();
    }
}
