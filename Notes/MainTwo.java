import java.util.*;
import java.util.stream.*;

public class MainTwo{

	public static void main(String[] args){

		// Sum
		List<Integer> num = List.of(1,2,3,6,4,5);
		int sum = num.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

		
		// Product
		int product = num.stream().reduce(1, (a,b) -> a * b);
		System.out.println(product);

		// Average 
		double avg = num.stream().mapToInt(Integer::intValue).average().orElse(0);
		
		System.out.println(avg);

		// maximum element
		int maxi = num.stream().sorted(Collections.reverseOrder()).findFirst().orElse(null);
		System.out.println(maxi);

		// filter out even numbers

		List<Integer> even = num.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.out.println(even);

		// string to Uppercase

		List<String> words = List.of("abcdedff" , "word" ,"hello", "syed");
		
		List<String> upper = words.stream().map(s -> s.toUpperCase()).toList();

		System.out.println(upper);

		// duplicate elements from a list

		List<Integer> list = List.of(1,1,2,3,4,4,5,6);

		System.out.println(list.stream().distinct().toList());
		
		
		// sort list by length
	
		List<String> byLength = words.stream().sorted(Comparator.comparingInt(String::length)).toList();
		System.out.println(byLength);
		
		// Sum of digits of a Number
		
		int number = 12345;
		
		int sumNum = String.valueOf(number).chars().map(x -> Character.getNumericValue(x)).sum();

		System.out.println(sumNum);

		// Factorial of a Number

		int num1 = 5;

		int fact = IntStream.rangeClosed(1, num1).reduce(1, (a,b) -> a * b);
		System.out.println(fact);

		// second largest 

		int secondLargest = num.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
		System.out.println(secondLargest);

		// longest string

		String longest = words.stream().max(Comparator.comparingInt(String::length)).orElse("");

		System.out.println(longest);

		// group by Length

		Map<Integer, List<String>> lengthMap = words.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(lengthMap);
		

		// merge two lists

		List<Integer> list1 = List.of(1, 2, 3);
List<Integer> list2 = List.of(4, 5, 6);
List<Integer> merged = Stream.concat(list1.stream(), list2.stream())
    .collect(Collectors.toList());
System.out.println("Merged List: " + merged);

		// occurenec of each element
		
		List<String> wordss = List.of("apple", "banana", "apple", "orange");
		Map<String, Long> cntMap = wordss.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println(cntMap);


		// occurence of each character in a String

		String input = "hello";

		Map<Character, Long> charCnt = input.chars().mapToObj(c -> (char) c)
						.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		System.out.println(charCnt);
		
	
		// Occurence of each word in a String

		String inputt = "hello world hello";
		Map<String, Long> wordCounts = Arrays.stream(inputt.split(" "))
    			.collect(Collectors.groupingBy(s -> s, 						Collectors.counting()));
		System.out.println("Word Counts: " + wordCounts);
		

		// Vowel Count

		Map<Character, Long> vowels = inputt.chars()
						.mapToObj(c -> (char) c)
						.filter(c -> "aeiou".contains(String.valueOf(c))).collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		System.out.println(vowels);

		
		// most frequent element in a string 
		

		String inp = "syyyyeeedd";

		Character most = inp.chars().mapToObj(c -> (char) c)
						.collect(Collectors.groupingBy(c -> c, Collectors.counting())).entrySet()
						.stream().max(Map.Entry.comparingByValue()).map(x -> x.getKey()).orElse(null);

		System.out.println(most);

		
		

		
	}
}