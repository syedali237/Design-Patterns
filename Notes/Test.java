import java.util.*;
import java.util.stream.*;


class Test {



	public static void main(String[] args){


			// RAVI TEJA


		        List<Employee> employees = Arrays.asList(
            			new Employee("Ali", 50000, 3),
            			new Employee("John", 70000, 6),
            			new Employee("Sara", 60000, 8),
            			new Employee("Mike", 40000, 2)
        		);

			// filter empoyess greater than threshold
			// change employee name to uppercase
			// sort names in ascending order
			// increase salary of employee with experience > 5 year by 10%
			
			System.out.println(employees.stream().filter(e -> e.salary > 55000).toList());
			
			System.out.println(employees.stream().map(e -> e.name.toUpperCase()).toList());

			System.out.println(employees.stream().sorted(Comparator.comparing(Employee::getName)).toList());

			
			
			employees.stream().filter(e -> e.experience > 5).forEach(e -> e.salary = e.salary * 1.10);

			System.out.println(employees);


			// MAYANK

			// find all the missing numbers between the min and max elements
			// return a list of sum of first and last index till middle

			
			List<Integer> list = Arrays.asList(3,4,1,5,9);

			Set<Integer> set = list.stream().collect(Collectors.toSet());			


			int mini = list.stream().sorted().findFirst().get();
			int maxi = list.stream().sorted(Collections.reverseOrder()).findFirst().get();
			System.out.println(mini + " , " + maxi);
			
			int[] res = IntStream.rangeClosed(mini, maxi).filter(x -> !set.contains(x)).toArray();

			System.out.println(Arrays.toString(res));	


			int[] arr = {1,2,3,4,5};

			int[] res1 = IntStream.rangeClosed(0, arr.length / 2).map(i -> (i == arr.length - i - 1) ? arr[i] : arr[i] + arr[arr.length - i - 1]).toArray();

			System.out.println(Arrays.toString(res1));


			
			// RAJ 
			
			// find all numbers that starts with 2
			// frequency of each character in a String

      			List<Integer> numbers = Arrays.asList(
    					2, 23, 45, 267, 89, 201, 12, 29, 300, 222, 2101
			);

			System.out.println(numbers.stream().filter(x -> String.valueOf(x).startsWith("2")).map(x -> x).collect(Collectors.toList()));

			String input = "Java Stream API is Powerful and Flexible".toLowerCase();

			Map<Character, Long> freqMap = input.chars()
        				.mapToObj(c -> (char) c)
        				.filter(c -> c != ' ')
        				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

			System.out.println(freqMap);



			// Return only pallindromic string

			List<String> lisst = Arrays.asList("madam", "hello", "racecar", "java", "level");

			System.out.println(lisst.stream().filter(s -> s.equals(new StringBuilder(s).reverse().toString())).toList());

			


			// Parshuram


        		List<String> words = Arrays.asList(
				"apple", "banana", "orange", "apple", "orange", "banana",
				"banana", "apple", "grape", "orange", "apple", "orange", "apple"
			);

    			Long cnt = words.stream().collect(Collectors.counting());
    			System.out.println(cnt);

    			Map<String, Long> mapp = words.stream().collect(Collectors.groupingBy(
        				s -> s,
        				Collectors.counting()
    			));

    			String second = mapp.entrySet().stream().sorted((a,b) ->  Long.compare(b.getValue() ,a.getValue())).skip(1).map(e -> e.getKey())
            			.findFirst()
            				.orElse(null);

    			System.out.println(second);


			// NISHANT

			// find the strings starting with a number

			List<String> listtt = Arrays.asList("Hello", "1wood", "23bottle", "abc");

			System.out.println(listtt.stream().filter(s -> Character.isDigit(s.charAt(0))).toList());

		
			// in sequence

			List<String> ssd = Arrays.asList("file_28", "file_" , "file_56" , "file_122");


			Map<Integer, String> map = new TreeMap<>();

			for (int i = 0; i < ssd.size(); i++){
				
				String str = ssd.get(i);
				
				String num = str.substring(5);

				int key;

				if (!num.isEmpty()){
					key = Integer.parseInt(num);
				} else {
					key = -1;
				}

				if(!map.containsKey(key)){
					map.put(key, str);
				}
			}

			List<String> ressd = new ArrayList<>();

			for (String val : map.values()){
				ressd.add(val);
			}

			System.out.println(ressd);
			

			// Stream :- Given a String with multiple words, Find the second longest word

			// String words = "EPAM Systems lonst second";

			
			
			// Product of array except itself

			int[] array = {1,2,0,4,6};
			int count = (int) Arrays.stream(array).filter(x -> x == 0).count();

			System.out.println(count);

			if (count > 1){
				 System.out.println(Arrays.toString(new int[array.length]));
			}

			int product = Arrays.stream(array).filter(x -> x != 0).reduce(1, (a,b) -> a * b);

			System.out.println(product);
	
			// int[] result = new int[array.length];

			int[] result = IntStream.range(0, array.length).map(i -> ).toArray();
			System.out.println(Arrays.toString(result));
			
						

			
		
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

String getName() { return this.name; }

    @Override
    public String toString() {
        return name + " | " + salary + " | " + experience;
    }
}