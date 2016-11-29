package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Collectors.*;
import java.util.stream.Stream;
import java.util.stream.Collector;
import java.util.stream.Collector.*;

public class TestData {

	public static List<Fruit> getAllFruits() {
		List<Fruit> fruits = new ArrayList<Fruit>();
		fruits.add(new Fruit("Peach", 90, 50, "Red"));
		fruits.add(new Fruit("Banana", 200, 10, "Yellow"));
		fruits.add(new Fruit("Pomegranate", 200, 70, "Red"));
		fruits.add(new Fruit("Apple", 300, 150, "Red"));
		fruits.add(new Fruit("Watermelon", 30, 20, "Red"));
		return fruits;
	}
	public static void printFruits(List<Fruit> fruits) {
		fruits.stream().forEach(System.out::println);
	}

	public static List<News> getAllNews() {
		List<News> newsList = new ArrayList<News>();
		newsList.add(new News(1, "Tom", "Anand", "Very nice article on budget"));
		newsList.add(new News(2, "Ivan", "Bipin", "Good budget description"));
		newsList.add(new News(1, "Tom", "Narang", "How can you write such an article?"));
		newsList.add(new News(2, "Jerry", "Mitul", "I agree with you!!"));
		newsList.add(new News(2, "James", "Anand", "This seems to be paid news for glorifying the budget"));
		newsList.add(new News(3, "Sara", "Daji", "Good article"));
		return newsList;
	}
	public static void printNews(List<News> newsList) {
		newsList.stream().forEach(System.out::println);
	}

	public static List<Transaction> getAllTransactions() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(new Transaction(new Trader("Anand", "Pune"), 2016, 10000));
		transactions.add(new Transaction(new Trader("Neeraja", "Indore"), 2015, 25000));
		transactions.add(new Transaction(new Trader("Yog", "Mumbai"), 2011, 33000));
		transactions.add(new Transaction(new Trader("Lokesh", "Nagpur"), 2016, 200000));
		transactions.add(new Transaction(new Trader("Komal", "Pune"), 2011, 80000));
		transactions.add(new Transaction(new Trader("Ishwar", "Indore"), 2016, 12000));
		return transactions;
	}
	
	public static void printTransactions(List<Transaction> transactions) {
		transactions.stream().forEach(System.out::println);
	}
	
	public static void main(String[] args) 
	{

		List<Fruit> fruits=getAllFruits();
		
		List<Fruit> fruitcal=fruits.stream().filter(fruit->fruit.getCalories()<100)
		.sorted(Comparator.comparing(Fruit::getCalories)).collect(Collectors.toList());
		printFruits(fruitcal);
		
		System.out.println("__________________________________________________________");
		
		Map<String, List<Fruit>> colorFruit = fruits.stream().collect(Collectors.groupingBy(Fruit::getColor));
		for (Map.Entry entry : colorFruit.entrySet()) 
		{
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		System.out.println("__________________________________________________________");
		
		List<Fruit> fruitRed=fruits.stream().filter(fruit -> fruit.getColor()=="Red")
		.sorted(Comparator.comparing(Fruit::getPrice)).collect(Collectors.toList());
		printFruits(fruitRed);
		
		System.out.println("__________________________________________________________");
				
		List<News> news=getAllNews();
		
		Map<Integer, Long> countsId =news.stream().collect(Collectors.groupingBy(News::getNewsId, Collectors.counting()));
		System.out.println(countsId.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

		
		System.out.println("__________________________________________________________");
		
		long l=news.stream().filter(n-> n.getComment().contains("budget")).count();
		System.out.println("No. of times the Budget word appears in comments of all user : "+l);
		
		System.out.println("__________________________________________________________");
		
		Map<String, Long> newCmtUsr = news.stream().collect(Collectors.groupingBy(News::getCommentByUser,Collectors.counting()));
		for (Map.Entry entry : newCmtUsr.entrySet()) 
		{
		    System.out.println(entry.getKey() + ", " + entry.getValue());
		}
		
		System.out.println("__________________________________________________________");
		
		List<Transaction> trans=getAllTransactions();
		List<Transaction> trns2011=trans.stream().filter(tr -> tr.getYear()==2011).
				sorted(Comparator.comparing(Transaction::getYear)).collect(Collectors.toList());
		printTransactions(trns2011);
		
		System.out.println("__________________________________________________________");
		
		List<Trader> trader=trans.stream().map(Transaction::getTrader).collect(Collectors.toList());
		List<String> cityTrader = trader.stream().map(Trader::getCity).distinct()
				.collect(Collectors.toList());
		System.out.println(cityTrader);
		
		System.out.println("__________________________________________________________");
		
		List<Trader> trdPune=trader.stream().filter(tr -> tr.getCity()=="Pune").
				sorted(Comparator.comparing(Trader::getCity)).collect(Collectors.toList());
		System.out.println(trdPune);
		
		System.out.println("__________________________________________________________");
		
		List<String> nameTrader = trader.stream().
				sorted(Comparator.comparing(Trader::getName))
				.map(Trader::getName).collect(Collectors.toList());
		System.out.println(nameTrader);
		
		System.out.println("__________________________________________________________");
		
		System.out.print("Are there any traders based in Indore : ");
		boolean traderIndore=trader.stream().anyMatch(tr -> tr.getCity()=="Indore");
		if(traderIndore)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		System.out.println("__________________________________________________________");
		
		List<Transaction> trnsDelhi=trans.stream().filter(tr -> tr.getTrader().getCity()=="Delhi").
				collect(Collectors.toList());//.forEach(System.out::println);
		if(trnsDelhi.isEmpty())
			System.out.println("No Traders at Delhi..");
		else
			printTransactions(trnsDelhi);
		
		System.out.println("__________________________________________________________");
		
		Optional<Integer> trnsValMax = trans.stream().collect(Collectors.maxBy(Comparator.comparing(Transaction::getValue))).map(Transaction::getValue);
		System.out.println(trnsValMax);
		
		System.out.println("__________________________________________________________");
		
		Optional<Transaction> trnsValMin = trans.stream().collect(Collectors.minBy(Comparator.comparing(Transaction::getValue)));
		System.out.println(trnsValMin);
		
		System.out.println("__________________________________________________________");
		
		Map<String,Long> userNews=news.stream().collect(Collectors.groupingBy(News::getPostedByUser,Collectors.counting()));
		System.out.println(userNews.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey());

		
	}
}
























