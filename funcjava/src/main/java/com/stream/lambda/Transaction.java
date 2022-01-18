package com.stream.lambda;

public class Transaction {

    private Currency currency;
    private int amount;

    Transaction(int amount, Currency currency){
        this.currency = currency;
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public String getCurrency(){
        return currency.getCurrency();
    }
    
}
