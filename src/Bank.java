import java.util.ArrayList;

public class Bank {

    private String ID;
    private Double bankTotalCredit;
    private ArrayList<Account> accounts;

    private Exception tooMuchChars = new Exception("Il codice identificativo della Banca deve essere composto da 10 caratteri.");

    public Bank(){
        accounts = new ArrayList<>();
        bankTotalCredit = 0.0;
    }

    public Bank(String ID, Double bankTotalCredit) throws Exception{
        if (ID.length() == 10)
        {
            this.ID = ID;
            this.bankTotalCredit = bankTotalCredit;
            accounts = new ArrayList<>();
        } else throw this.tooMuchChars;

    }

    public String getID() {
        return ID;
    }
    public void setID(String ID) throws Exception{
        if (ID.length() == 10) {
            this.ID = ID;
        } else throw this.tooMuchChars;
    }

    public Double getBankTotalCredit() {
        return bankTotalCredit;
    }
    public void setBankTotalCredit(Double bankTotalCredit) {
        this.bankTotalCredit = bankTotalCredit;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getAccountByID(String accountID){

        Account aRes = null;

        for (Account a : this.accounts){
            if (a.getIBAN().equalsIgnoreCase(accountID)){
                aRes = a;
                break;
            }
        }

        return aRes;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public Double calcBankTotalCredit(){
        Double finalRes = 0.0;

        for(Account acc : this.accounts){
            finalRes += acc.getCredit();
        }

        return finalRes;
    }

    public boolean registerAccount(Account account){ return this.accounts.add(account); }

    public boolean removeAccount(Account account){ return this.accounts.remove(account); }
}
