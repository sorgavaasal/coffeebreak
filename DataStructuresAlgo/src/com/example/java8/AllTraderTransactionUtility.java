package com.example.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import com.example.common.classes.Trader;
import com.example.common.classes.Transaction;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;
import static java.util.Comparator.comparing;

public class AllTraderTransactionUtility {
	
	public static List<Trader> getMockTraderData() {
		List<Trader> allTraders = new ArrayList<>();
		allTraders.add(new Trader("Munnusaamy", "Tanjore"));
		allTraders.add(new Trader("Kandasaamy", "Trichy"));
		allTraders.add(new Trader("Kannamma", "Mayavaram"));
		allTraders.add(new Trader("Veerasaamy", "Tirukaatupalli"));
		allTraders.add(new Trader("SubbuLakshmi", "Boodaloor"));
		allTraders.add(new Trader("LalithaKamalam", "Boodaloor"));
		allTraders.add(new Trader("Kamatchi", "Trichy"));
		return allTraders;
	}
	
	public static List<Transaction> getMockTransactionData(List<Trader> traderData) {
		
		List<Transaction> transactionList = new ArrayList<>();
		transactionList.add(new Transaction(traderData.get(0), 2010, 1500));
		transactionList.add(new Transaction(traderData.get(1), 2010, 2900));
		transactionList.add(new Transaction(traderData.get(2), 2009, 1200));
		transactionList.add(new Transaction(traderData.get(0), 2011, 1200));
		transactionList.add(new Transaction(traderData.get(1), 2011, 1300));
		transactionList.add(new Transaction(traderData.get(3), 2012, 500));
		transactionList.add(new Transaction(traderData.get(4), 2013, 1800));
		transactionList.add(new Transaction(traderData.get(5), 2014, 2000));
		transactionList.add(new Transaction(traderData.get(6), 2015, 1200));
		return transactionList;
	}
	

	public static void main(String[] args) {
		List<Trader> traderData = getMockTraderData();
		List<Transaction> transactionData = getMockTransactionData(traderData);
		
		//* First question in the exercise 
		//* Find all transaction in the year 2011 and sort them by low to high 
		List<Transaction> trans2011Data = transactionData.stream()
		.filter((Transaction trans) -> trans.getYear() == 2011)
		.sorted(comparing(Transaction::getValue))
		.collect(toList());
		
		for (Transaction transaction: trans2011Data)
			System.out.println(transaction.getValue() + " " + transaction.getTrader().toString());
		
		//*Second question 
		//* what are the unique cities where the traders work 
		
		traderData.stream()
		.sorted(comparing(Trader::getCity))
		.map(Trader::getCity)
		.distinct()
		.collect(toList())
		.forEach(System.out::println);
		
		//* Third question 
		//* Find all traders from Trichy and sort them by name 
		traderData.stream()
		.filter((Trader trader) -> trader.getCity().equals("Trichy"))
		.sorted(comparing(Trader::getName))
		.collect(toList())
		.forEach(System.out::println);
		
		//* Fourth question 
		//* return a string of all the traders name in sorted order 
		String traderName = traderData.stream()
		.sorted(comparing(Trader::getName))
		.map(Trader::getName)
		.reduce("", (a, b) -> a + " " + b);
		System.out.println("all trander name " + traderName);
		
		//*same functionality for the above can be achieved using the 
		//*the joining method in the collect API
		traderName = traderData.stream()
					.sorted(comparing(Trader::getName))
					.map(Trader::getName)
					.collect(joining(" "));
		System.out.println("all trader name generated with joinging api " +traderName);
		
		//* fifth question
		//* are there any trader based out of Tanjore
		System.out.println(transactionData.stream()
				.anyMatch(transaction -> "Tanjore".equals(transaction.getTrader().getCity())));
		
		//* sixth question 
		//* print all transaction values for trader based out of Boodaloor 
		transactionData.stream()
		.filter((Transaction transaction) -> "Boodaloor".equals(transaction.getTrader().getCity()))
		.map(Transaction::getValue)
		.forEach(System.out::println);
		
		//* seventh question
		//* what is the highest value of all the transaction 
		Optional<Integer> highTranVal = transactionData.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(highTranVal.get());
		
		//* eighth question 
		//* what is the smallest value of all the transaction
		Optional<Integer> lowTranVal = transactionData.stream().map(Transaction::getValue).reduce(Integer::min);
		System.out.println(lowTranVal.get());
		Optional<Transaction> lowTranValInOpt = transactionData.stream().min(comparing(Transaction::getValue));
		System.out.println(lowTranValInOpt.map(Transaction::getValue).get());
	}

}
