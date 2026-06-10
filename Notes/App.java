import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashMap;


class App{
	public static void main(String[] args){
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

		// Seperate Even & Odd
		Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0)); 
		
		System.out.println("Even: " + map.get(true));
		System.out.println("Odd: " + map.get(false));

		// Find frequency of each character in a String

		String s = "Hello World, This is Ali";

		Map<Character, Integer> freq = s.chars()
						.mapToObj(c -> (char) c)
						.collect(Collectors.toMap(
							c -> c,
							c -> 1,
							Integer::sum
						));
		System.out.println(freq);

		// Frequency of each element in an array or a list

		List<String> sList = Arrays.asList("Pen", "Apple", "Made");
		Map<String, Integer> freqMap = sList.stream().collect(Collectors.toMap(
									x -> x,
									x -> x.length()
								));

		System.out.println(freqMap);

		//  join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter

		String joined = sList.stream().collect(Collectors.joining("-> " , "[", "]")); 
		System.out.println(joined);


		// Merge two unsorted arr into a sorted one

		int[] a = new int[] {4, 2, 7, 1};
		int[] b = new int[] {8, 3, 9, 5};

		int[] c = IntStream.concat(Arrays.stream(a) , Arrays.stream(b)).sorted().toArray();
		System.out.println(Arrays.toString(c));

		// get 3 max and min numbers

		List<Integer> mini = list.stream().sorted().limit(3).toList();
		List<Integer> maxi = list.stream().sorted(Collections.reverseOrder()).limit(3).toList();

System.out.println("Mini= " + mini + " ,  " + "Maxi= " + maxi);

		// To check two strings are anagrams or not

		
		String s1 = "RaceCar";
		String s2 = "CarRace";

		s1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());

		if (s1.equals(s2)){
			System.out.println(s1);
			System.out.println(s2);
			System.out.println("Two Strings are anagarams");
		}

		// Sort Strings according to increasing order of length

		List<String> sorted = sList.stream().sorted(Comparator.comparing(String::length)).toList();

		System.out.println(sorted);

		// Find common elements between two arrays

		List<Integer> list1 = Arrays.asList(1, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 2, 6, 8, 4);

		list1.stream().filter(x -> list2.contains(x)).forEach(System.out::println);

		// reverse each word of a string

		String str = "hello world worlds";

		String reversed = Arrays.stream(str.split(" ")).
						map(word -> new StringBuffer(word).reverse())
						.collect(Collectors.joining(" "));

		System.out.println(reversed);

		// sum of first 10 natural number

		System.out.println(IntStream.range(1, 11).sum());

		// reverse of int[] arr

		int[] rev = IntStream.rangeClosed(1, a.length).map(i -> a[a.length - i]).toArray();
		
		System.out.println(Arrays.toString(rev));

		// most repeated element in an arr

	        List<String> listss = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Pen", "Note Book", "Pencil");
		
		Map<String, Long> freqMapp = listss.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting()));

		System.out.println(freqMapp);

		Entry<String, Long> mostFrequentElement = freqMapp.entrySet().stream().max(Map.Entry.comparingByValue()).get();

		
		System.out.println("Element: " + mostFrequentElement.getKey() + " Count: " + mostFrequentElement.getValue());

		
		// Palindrome using streams

		String ss = "ROTATOR";


		boolean isPallindrome = IntStream.rangeClosed(1, ss.length() / 2).allMatch(i -> ss.charAt(i) == ss.charAt(ss.length() - i - 1));

		System.out.println(isPallindrome);

		// Extract duplicate elements from an array

		List<Integer> lisst = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);

		Set<Integer> uniqueSet = new HashSet<>();

		Set<Integer> duplicateEl = lisst.stream().filter(x -> !uniqueSet.add(x)).collect(Collectors.toSet());

		System.out.println(duplicateEl);

				

		// first repeated character in a String

		String sss = "Java Concept of the day";

		String strr = sss.toLowerCase();

		System.out.println(strr);

		Map<String, Long> charFreq = Arrays.stream(strr.split("")).collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting()));
		
		System.out.println(charFreq);
	
		String repeated = charFreq.entrySet().stream().filter(x -> x.getValue() > 1).map(x -> x.getKey()).findFirst().get();

		System.out.println(repeated);

		
		// Fibonacci Series

		Stream.iterate(new int[] {0, 1}, f -> new int[] { f[1] , f[0] + f[1]})
						.limit(10)
						.map(f -> f[0])
						.forEach(i -> System.out.print(i + " "));

		System.out.println();
		int[] fib =  new int[]{0,1};
		
		IntStream.range(0, 10)
				.map( i -> {
					int res = fib[0];
					int next = fib[0] + fib[1];
					fib[0] = fib[1];
					fib[1] = next;
					return res;
					}
				).forEach(System.out::println);
		
		
		
		

		
	}
}