package JavaStreams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));

        //Group Employee by City

        /*Map<String, List<Employee>> cityEmpMap = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Employees grouped by city :: \n" + cityEmpMap);

        Map<String, List<Employee>> deptEmpMap = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName));
        System.out.println("Employees grouped by dept :: \n" + deptEmpMap);

        Set<String> cities = empList.stream().map(it->it.getCity()).collect(Collectors.toSet());
        System.out.println("City Set :: \n" + cities);*/


        //boolean b = empList.stream().map(it->it.getSalary()).red

        List<Integer> numbers = Arrays.asList( 2,1, 3, 4, 5, 6);
        //filter even numbers
        /*List<Integer> evenNums = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNums);
        int n = numbers.stream().max(Integer::compareTo).orElse(-1);
        System.out.println(n);

        List<Integer> sortedList = numbers.stream().sorted().toList();
        System.out.println(sortedList);

        List<Integer> newSortedList = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(newSortedList);*/
        String [] arr = {"Object","data","Test","java","string","desktop","Java"};
        Test test = (intStrs) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for(String str : intStrs)
            {
                stringBuilder.append(str+" ");
            }
            System.out.println(stringBuilder.toString());
        };

      //  test.test(arr);

       /* Map<String, Integer> hMap = Arrays.stream(arr).collect(Collectors.toMap(t->t, t->t.length()));
        System.out.println(hMap.toString());*/

        Set<Integer> sqNUms = numbers.stream().map(t->t*t).collect(Collectors.toSet());
        System.out.println("sqNUms: "+sqNUms);
    }
}
