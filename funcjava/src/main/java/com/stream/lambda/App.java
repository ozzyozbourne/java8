package com.stream.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class App {
    
   static List<Transaction> transactionsRupeeList = new ArrayList<>();
   static List<Transaction> transactionsDollarList = new ArrayList<>();
   static List<Transaction> transactionsPoundList = new ArrayList<>();
   static List<Transaction> transactionsBitcoinList = new ArrayList<>();
   static List<Transaction> allTransactions = new ArrayList<>();
   static Map<String, List<Transaction>> transactionsByCurrency = new HashMap<>();


    private App() {
    }


    public static void main(String[] args) {
        
        StreamImplementaion();
       // nonStreamImplementaion();
        
    }


    static void streamImplementation(){
        transactionsByCurrency = allTransactions.stream()
                                                .filter((Transaction t) -> t.getAmount() > 99)
                                                .collect(Collectors.groupingBy(Transaction::getCurrency));
    }

    static void filterExpensiveTransctionAndGroupByCurrency(){
        for(Transaction transaction: allTransactions){
            if(transaction.getAmount() > 99){
                String currencyString  = transaction.getCurrency();
                List<Transaction> transactionsForCurrency = 
                transactionsByCurrency.get(currencyString);
                if(transactionsForCurrency == null){
                    transactionsForCurrency = new ArrayList<>();
                    transactionsByCurrency.put(currencyString, transactionsForCurrency);
                }
                transactionsForCurrency.add(transaction);

            }
        }
    }


    static void StreamImplementaion(){
        fillAllCurrenciesValues();
        streamImplementation();
        printMap();
    }

    static void nonStreamImplementaion(){
        fillAllCurrenciesValues();
        filterExpensiveTransctionAndGroupByCurrency();
        printMap();
    }

    static void printMap(){
        for(String curString : transactionsByCurrency.keySet()){
            System.out.println("Currency is --- " + curString);
            System.out.println();
            System.out.println("All the transactions in that currency are ---");
            for(Transaction transaction : transactionsByCurrency.get(curString)){
                System.out.println(transaction.getAmount());
            }
        }
    }

    

    static void fillAllCurrenciesValues(){
       
        fillTransactionObjRupee();
        fillTransactionObjDollar();
        fillTransactionObjPound();
        fillTransactionObjBitcoin();
        allTransactions.addAll(transactionsRupeeList);
        allTransactions.addAll(transactionsDollarList);
        allTransactions.addAll(transactionsPoundList);
        allTransactions.addAll(transactionsBitcoinList);

    }

    static void fillTransactionObjRupee(){
        Currency rupee = new Currency("Rupee");
        for(int i = 1; i<=10; i++){
            transactionsRupeeList.add(new Transaction(i * 100 , rupee));
        }
    }

    static void fillTransactionObjDollar(){

        Currency dollar = new Currency("Dollar");
        for(int i = 1; i<=10; i++){
            transactionsRupeeList.add(new Transaction(i * 100, dollar));
        }
    }

    static void fillTransactionObjPound(){
        Currency pound = new Currency("Pound");
        for(int i = 1; i<=10; i++){
            transactionsRupeeList.add(new Transaction(i * 100, pound));
        }
    }

    static void fillTransactionObjBitcoin(){

        Currency bitcoin = new Currency("Bitcoin");
        for(int i = 1; i<=10; i++){
            transactionsRupeeList.add(new Transaction(i * 100, bitcoin));
        }
    }


}


