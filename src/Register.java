import java.util.ArrayList;

public class Register {

    ArrayList<Bank> banks;

    public Register (){
        banks = new ArrayList<>();
    }

    public ArrayList<Bank> getBanks() {
        return banks;
    }
    public void setBanks(ArrayList<Bank> banks) {
        this.banks = banks;
    }

/*    public boolean findedBank (String ID){
        for (Bank b : this.banks){
            if (b.getID().equalsIgnoreCase(ID)) return true;
        }
        return false;
    }*/

    public Bank getBankByID(String ID){

        Bank bRes = null;

        for(Bank b : this.banks){
            if (b.getID().equalsIgnoreCase(ID)){
                bRes = b;
                break;
            }
        }
        return bRes;
    }

    public Bank getBankByGivenAccountIBAN(String IBAN){

        String code = IBAN.substring(5, 14);
        Bank bRes = null;

        for (Bank b : this.banks){
            if (b.getID().equalsIgnoreCase(code)){
                bRes = b;
                break;
            }
        }
        return bRes;
    }

    public Account getAccountByIBAN(String IBAN){

        Account aRes = null;

        for (Bank b : this.banks){
            for (Account a : b.getAccounts()){
                if (a.getIBAN().equalsIgnoreCase(IBAN)){
                    aRes = a;
                    break;
                }
            }
        }
        return aRes;
    }

    public void registerTransation(Account sendingAccount, Account receivingAccount, double transAmount){

        Bank sendingBank = this.getBankByGivenAccountIBAN(sendingAccount.getIBAN());
        Bank receivingBank = this.getBankByGivenAccountIBAN(receivingAccount.getIBAN());

        sendingBank.setBankTotalCredit(sendingBank.getBankTotalCredit() - transAmount);
        receivingBank.setBankTotalCredit(receivingBank.getBankTotalCredit() + transAmount);

        sendingAccount.setCredit(sendingAccount.getCredit() - transAmount);
        receivingAccount.setCredit(receivingAccount.getCredit() + transAmount);

    }
}
