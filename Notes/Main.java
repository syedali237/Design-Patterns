import java.util.stream.Stream;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.*;

class Main {
	
	public static void main(String[] args) {

		// q1
		List<Integer> list =  Arrays.asList(1,2,3, 10 ,4,5);
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

		// Q2
		
		int product = list.stream().reduce(1, (a,b) -> a * b);
		System.out.println(product);

		// Q3
		double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0);
		System.out.println(avg);
		
		// Q4

		int maxi = list.stream().sorted(Collections.reverseOrder()).findFirst().orElse(null);
		System.out.println(maxi);

		// Q5
		int mini = list.stream().sorted().findFirst().orElse(null);
		System.out.println(mini);
		
		int min = list.stream().min(Integer::compare).orElse(0);
		System.out.println(min);

		// Q6
		long cnt = list.stream().count();
		System.out.println(cnt);

		// Q7

		boolean exists = list.stream().anyMatch(x -> x == 3);
		System.out.println(exists);

		// Q8

		List<Integer> even = list.stream().filter(x -> x % 2 == 0).toList();
		System.out.println(even);

		// Q10

		List<String> words = Arrays.asList("aaaaa", "add" , "a", "ab", "abc" ,"abcd");
		List<String> upper = words.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upper);
		
		// Q20
		
		List<String> sortedLength = words.stream().sorted(Comparator.comparingInt(String::length)).toList();
System.out.println(sortedLength);

		// Q21

		int num = 12345;
		int s = String.valueOf(num).chars()
					.map(Character::getNumericValue).sum();
		System.out.println(s);


		// Input = [1, 2, 3 ,4, 5]; output = [6,6,3];
		int[] arr = {1, 2, 3 ,4, 5};
		int[] resss = IntStream.range(0, (arr.length + 1) / 2).map(i -> (i == arr.length - i - 1 ) ? arr[i] : arr[i] + arr[arr.length - i - 1]).toArray();
		System.out.println(Arrays.toString(resss));

		// find all missing elements between min and max

		List<Integer> listtt = Arrays.asList(4,6,1,2,1,1);
		
		Set<Integer> set = listtt.stream().collect(Collectors.toSet());

		System.out.println(set);

		int minii = listtt.stream().min(Integer::compareTo).get();
		int maxii = listtt.stream().max(Integer::compareTo).get();

		int[] reee = IntStream.rangeClosed(minii, maxii).filter(i -> !set.contains(i)).toArray();;

		System.out.println(Arrays.toString(reee));

		List<String> strArr = Arrays.asList("1,2,3", "3,4,5", "6,abc,7", "8,9,10", "10,2,4");
        	// Output:  [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

			


		// filter employees greated than threshhold

		        List<Employee> employees = Arrays.asList(
            			new Employee("Ali", 50000, 3),
            			new Employee("John", 70000, 6),
            			new Employee("Sara", 60000, 8),
            			new Employee("Mike", 40000, 2)
        		);

		List<Employee> greaterThanThreshold = employees.stream().filter(x -> x.salary > 45000).toList();
		System.out.println(greaterThanThreshold);
		
		// sort names in ascending order

		List<Employee> names = employees.stream().sorted(Comparator.comparing(e -> e.name)).toList();
		System.out.println(names);
		
		// to upper case names

		List<String> uppers = employees.stream().map(e -> e.name.toUpperCase()).toList();

		System.out.println(uppers);
		
		// filter employees with experience > 5 and increase salary by 10 %
		
		List<Employee> experience = employees.stream().filter(x -> x.experience > 5).map(e -> new Employee(e.name, e.salary * 1.1 , e.experience)).collect(Collectors.toList());
		System.out.println(experience);

		void increaseSalary() {
    				employee.stream()
        				.filter(x -> x.experience > 5)
        				.forEach(x -> x.salary = x.salary * 1.1);
		}

		// return elements with numbers

		String[] arss = {"Hello", "1wood", "23bottle", "abc", "a2c"};

		List<String> arres= Arrays.stream(arss).filter(x -> x.chars().anyMatch(Character::isDigit)).collect(Collectors.toList());

		System.out.println(arres);

		
		// list = ["file_28", "file_" , "file_56" , "file_122" ] -----> output = file_ , file_28, file_56, file_122

		List<String> ssd = Arrays.asList("file_28", "file_" , "file_56" , "file_122");

		Map<Integer, String> map = new TreeMap<>();

        	for (int i = 0; i < ssd.size(); i++) {
            		String str = ssd.get(i);

            		String numPart = str.substring(5);

            		int key;
	            if (numPart.isEmpty()) {
                	key = -1;
            	    } else {
                	key = Integer.parseInt(numPart);
            	    }

            	    if (!map.containsKey(key)) {
                	map.put(key, str);
            	    }
        	}

		System.out.println(map);

		List<String> sssdde = new ArrayList<>();

		for (String val : map.values()){
			sssdde.add(val);
		}

		System.out.println(sssdde);


		// Stream :- Given a String with multiple words, Find the second longest word

		String multipleWord = "EPAM Systems lonst secon";

		System.out.println(Arrays.stream(multipleWord.split(" ")).sorted((a,b) -> b.length() - a.length()).skip(1).findFirst().orElse(null));
		
		
		// Given an employee class, find the highest salary on department basis

		
List<Employee1> listss = Arrays.asList(
    new Employee1("Ali", "IT", 50000),
    new Employee1("John", "IT", 70000),
    new Employee1("Sara", "HR", 60000),
    new Employee1("Mike", "HR", 65000)
);

		Map<String, Double> deptMap = listss.stream().collect(Collectors.toMap(
						e -> e.dept,
						e -> e.salary,
						(a, b) -> b > a ? b : a
					));

		System.out.println(deptMap);


		// sum of digits

		System.out.println(String.valueOf(12345).chars().map(c -> c - '0').sum());


		// Sum of digits of list of Integers

		List<Integer> llist = Arrays.asList(123, 45, 67);

		int sssum = llist.stream().flatMapToInt(n -> String.valueOf(n).chars().map(c -> c - '0')).sum();
		
		System.out.println(sssum);

		// return only pallindrome strings

		List<String> list = Arrays.asList("madam", "hello", "racecar", "java", "level");

		List<String> palindromes = list.stream()
    			.filter(s -> s.equals(new StringBuilder(s).reverse().toString()))
    				.toList();

		System.out.println(palindromes);

		

	}
}
	
class Employee {
    String name;
    double salary;
    int experience;

    Employee(String name, double salary, int experience) {
        this.name = name;
        this.salary = salary;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return name + " | " + salary + " | " + experience;
    }
}

	
class Employee1 {
    String name;
    String dept;
    double salary;

    Employee1(String name, String dept, double salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}