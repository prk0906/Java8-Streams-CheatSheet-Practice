package StreamMethods;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class Streams {
    public static void main(String[] args) {
        //1.Separate odd and even numbers in a list of integers
        evenAndOddSeperation();
        //2.Remove duplicate elements from a list using Java 8 streams
        removeDuplicateElements();
        //3.Find the frequency of each character in a string using Java 8 streams
        characterFrequency();
        //4.Find the frequency of each element in an array or a list
        wordFrequency();
        //5.Sort a given list of decimals in reverse order
        sortInReverseOrder();
        //6.Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter
        joiningStrings();
        //7.Print the numbers from a given list of integers that are multiples of 5
        multiplesOf5();
        //8.Find the maximum and minimum of a list of integers
        maxMinNumber();
        //9.Merge two unsorted arrays into a single sorted array using Java 8 streams
        mergeTwoUnsortedArrays();
        //10.Merge two unsorted arrays into a single sorted array without duplicates
        mergeTwoUnsortedArraysWithoutDuplicates();
        //11.Get the three maximum and three minimum numbers from a given list of integers
        threeMinimumAndMaximumnumbers();
        //12.Check if two strings are anagrams or not using Java 8 streams
        isAnagram();
        //13.Find the sum of all digits of a number in Java 8
        sumOf();
        //14.Find the second largest number in an integer array
        secondLargestNumber();
        //15.Sort a list of strings according to the increasing order of their length
        sortedByLengthOfString();
        //16.Find the sum and average of all elements in an integer array
        calculateSumAndAverage();
        //17.Find the common elements between two arrays
        commonElements();
        //18.Reverse each word of a string using Java 8 streams
        reverseOfEachWord();
        //19.Find the sum of the first 10 natural numbers
        sumOfFirstTenNaturalNumbers();
        //20.Reverse an integer array
        int [] numberArray ={1,2,3,4,5,6,7,8,9,10};
        reverseArray(numberArray);
        //21.Most Repeated Element
        mostRepeatedElement();
        //22. Check given string is plaindrome or not
        isPalindrome();
        //23.Find strings in a list that start with a number
        stringStartNumber();
        //24.Extract duplicate elements from an array
        extractDuplicateElements();
        //25.Print duplicate characters in a string
        duplicateCharacters();
        //26.Find first Repeating Character
        firstRepeatingCharacter();
        //27.Find the first non-repeated character in a string
        firstNonRepeatingChar();
        //28.Generate the Fibonacci series
        Fibonacci();
        //29.Reverse each word in String
        reverseEachWordOfString();
        //30.Print first 10 odd numbers
        firstTenOddNumbers();
        //31.Get last element in the array
        lastElementInArray();
        //32.Calculate the age of person in years
        ageCalculation();
        //33.Extract words which are starting with #
        wordStartsWithHash();
    }

    private static void wordStartsWithHash() {
        String[] input = new String[]{
                "This JEP is #mainly for scientific #applications",
                "and it makes #floating-point operations consistently #strict.",
                "The default #floating-point operations are #strict or strictfp,"
        };
        List<String> list = Arrays.stream(input)
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .filter(word->word.startsWith("#"))
                .map(word->word.replaceAll("[^a-zA-Z]",""))
                .distinct()
                .toList();
        System.out.println("33.words which are starting with #");
        System.out.println(list);
    }

    private static void ageCalculation() {
        LocalDate birthDate = LocalDate.of(2000,6,9);
        LocalDate currentDate = LocalDate.now();
        int years = Period.between(birthDate, currentDate).getYears();
        System.out.println("32.the age of person in years");
        System.out.println(years);
    }

    private static void lastElementInArray() {
        int[] intArray = {0,1,2,3,4,5};
        int lastElementInArray = Arrays.stream(intArray)
                .reduce((first, second) -> second)
                .getAsInt();
        System.out.println("31.last element in the array");
        System.out.println(lastElementInArray);
    }

    private static void firstTenOddNumbers() {
        List<Integer> firstTenOddNumbers = Stream.iterate(1, i -> i + 2)
                .limit(10)
                .toList();
        System.out.println("30.First 10 odd numbers.");
        System.out.println(firstTenOddNumbers);
    }

    private static void reverseEachWordOfString() {
        String str = "Hello world";
        String list = Arrays.stream(str.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(joining(" "));
        System.out.println("29.Reverse each word in String");
        System.out.println(list);
    }

    private static void Fibonacci() {
        int n = 5;
        List<Integer> Fibonacci = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(n)
                .map(t -> t[0])
                .toList();
        System.out.println("29.Fibonacci Series");
        System.out.println(Fibonacci);
    }

    private static void firstNonRepeatingChar() {
        String word = "praveen";
        Character firstNonrepeatingChar = word.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(i -> i, counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println("27.first non-repeated character in a string");
        System.out.println(firstNonrepeatingChar);
    }

    private static void firstRepeatingCharacter() {
        String word = "rohttoh";
        Character firstRepeatingCharacter = word.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(i -> i, LinkedHashMap::new, counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println("26. First Repeating Character");
        System.out.println(firstRepeatingCharacter);
    }

    private static void duplicateCharacters() {
        String word = "rohttoh";
        List<Character> duplicateCharacters = word.chars()
                .mapToObj(c -> (char) c)
                .collect(groupingBy(ch -> ch, counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("25.Duplicate Characters in Strings");
        System.out.println("Approach 1");
        System.out.println(duplicateCharacters);
        System.out.println("Approach 2");
        Set<Character> set = new HashSet<>();
        List<Character> list = word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !set.add((char) c))
                .toList();
        System.out.println(list);

    }

    private static void extractDuplicateElements() {
        List<Integer> duplicateElements = Arrays.asList(1, 2,2,2,3, 3, 4, 5,1,1,56, 7, 8, 9, 10);
        List<Integer> extractDuplicateElements = duplicateElements.stream()
                .collect(groupingBy(i -> i, counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println("24.Duplicate elements in Array");
        System.out.println(extractDuplicateElements);
    }

    private static void stringStartNumber() {
        String [] words= {"rohit","foo","nemo","target1","12Target","2robot"};
        List<String> stringStartNumber = Arrays.stream(words)
                .filter(word -> Character.isDigit(word.charAt(0)))
                .toList();
        System.out.println("23.Strings Starts with Number");
        System.out.println(stringStartNumber);
    }

    private static void isPalindrome() {
        String str = "MOM";
        boolean b = IntStream.range(0, str.length() / 2)
                .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
        System.out.println("22. Plaindrome or not");
        if(b)
            System.out.println("Palindrome");
        else
            System.out.println("not Plaindrome");
    }

    private static void mostRepeatedElement() {
        int [] elements = {2,3,1,4,4,1,4,333,3,333,2,2,2,5,222};
        Map<Integer, Long> frequency = Arrays.stream(elements)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Long maxFrequency = frequency.values()
                .stream()
                .max(Comparator.comparingLong(i -> i))
                .get();
        List<Integer> mostRepeatedElement = frequency.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey).toList();
        System.out.println("21.Most Repeated Element");
        System.out.println(mostRepeatedElement);
    }

    private static void reverseArray(int[] numberArray) {
        List<Integer> reversedList = Arrays.stream(numberArray)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("20.Reverse an integer array");
        System.out.println(reversedList);
    }

    private static void sumOfFirstTenNaturalNumbers() {
        int sum = IntStream.rangeClosed(1, 10)
                .sum();
        System.out.println("19.sum of the first 10 natural numbers");
        System.out.println("Approach 1->"+sum);
        int sum1 = IntStream.rangeClosed(1, 10)
                .reduce(0,(a,b)->a+b);
        System.out.println("Approach 2->"+sum1);
    }

    private static void reverseOfEachWord() {
        String stmt = "java is OOP language";
        String reversedString = Arrays.stream(stmt.split(" "))
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println("18.Reverse each word of a string");
        System.out.println(reversedString);
    }

    private static void commonElements() {
        List<Integer> oneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> twoToTen = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> commonNumbers = oneToTen.stream()
                .filter(twoToTen::contains)
                .toList();
        System.out.println("17.The common elements between two List");
        System.out.println(commonNumbers);
    }

    private static void calculateSumAndAverage() {
        List<Integer> oneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics num = oneToTen.stream()
                .collect(summarizingInt(Integer::intValue));
        System.out.println("16.the sum and average of all elements in an integer array");
        System.out.println(num.getSum());
        System.out.println(num.getAverage());
    }

    private static void sortedByLengthOfString() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        List<String> sortedNames = names.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("15.Sort a list of strings according to the increasing order of their length");
        System.out.println(sortedNames);
    }

    private static void secondLargestNumber() {
        List<Integer> oneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer i = oneToTen.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();
        System.out.println("14.the second largest number in an integer array");
        System.out.println(i);
    }

    private static void sumOf() {
        List<Integer> oneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = oneToTen.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("13.the sum of all digits of a number Approach1");
        System.out.println(sum);
        System.out.println("13.the sum of all digits of a number Approach2");
        Integer reduce = oneToTen.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    private static void isAnagram() {
        String str1 = "listen";
        String str2 = "slient";
        //Approach 1
        char[] splitIt = str1.toCharArray();
        char[] splitIt2 = str2.toCharArray();
        Arrays.sort(splitIt);
        Arrays.sort(splitIt2);
        System.out.println("12.Approach 1 for two strings are anagrams or not");
        if(Arrays.equals(splitIt,splitIt2))
            System.out.println("Given Strings are Anagram");
        else
            System.out.println("Given Strings are not Anagram");
        //Approach2
        System.out.println("Approach 2 for two strings are anagrams or not");
        String collect = str1.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .sorted()
                .collect(Collectors.joining());
        String collect1 = str2.chars()
                .mapToObj(ch -> String.valueOf((char) ch))
                .sorted()
                .collect(Collectors.joining());
        if(collect.equals(collect1))
            System.out.println("Given two Strings are Anagram");
        else
            System.out.println("Given two Strings are not Anagram");
    }

    private static void threeMinimumAndMaximumnumbers() {
        List<Integer> randomNumbers = List.of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> minimumNumber = randomNumbers.stream()
                .sorted()
                .limit(3)
                .toList();
        System.out.println("11.the three maximum and three minimum numbers from a given list of integers");
        System.out.println("Minimum Number\n"+minimumNumber);
        List<Integer> maximum = randomNumbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("Maximum Numbers\n"+maximum);
    }

    private static void mergeTwoUnsortedArraysWithoutDuplicates() {
        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int [] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};
        int[] array = IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2))
                .sorted()
                .distinct()
                .toArray();
        System.out.println("10.Merge two unsorted arrays into a single sorted array without duplicates");
        System.out.println(Arrays.toString(array));
    }

    private static void mergeTwoUnsortedArrays() {
        int [] randomNumbers ={12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43};
        int [] randomNumber2 = {4, 3, 2, 5, 6, 78, 98, 53, 90};
        int[] array = IntStream.concat(Arrays.stream(randomNumbers), Arrays.stream(randomNumber2))
                .sorted()
                .toArray();
        System.out.println("9.Merge two unsorted arrays into a single sorted array");
        System.out.println(Arrays.toString(array));
    }

    private static void maxMinNumber() {
        List<Integer> randomNumbers = List.of(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        Integer maxNumber = randomNumbers.stream()
                .max(Comparator.comparingInt(i -> i))
                .get();
        System.out.println("8.the maximum and minimum of a list of integers");
        System.out.println("Maximun Number: "+maxNumber);
        Integer minNumber = randomNumbers.stream()
                .min(Comparator.comparingInt(i -> i))
                .get();
        System.out.println("Minium Number: "+minNumber);
    }

    private static void multiplesOf5() {
        List<Integer> randomNumbers = Arrays.asList(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        List<Integer> numbersMultipleOf5 = randomNumbers.stream()
                .filter(n -> n % 5 == 0)
                .toList();
        System.out.println("7.the numbers from a given list of integers that are multiples of 5");
        System.out.println(numbersMultipleOf5);
    }

    private static void joiningStrings() {
        List<String> languageList = Arrays.asList("java", "c++", "c", "C sharp", "python", "kotlin", "scala");
        String joiningString = languageList.stream()
                .collect(Collectors.joining(",", "[", "]"));
        System.out.println("6.Join a list of strings with '[' as prefix, ']' as suffix, and ',' as delimiter");
        System.out.println(joiningString);
    }

    private static void sortInReverseOrder() {
        List<Integer> randomNumbers = Arrays.asList(12, 32, 2, 4, 777, 5, 32, 890, 422, 44, 99, 43);
        //Approach 1
        List<Integer> sortInReverseOrder = randomNumbers.stream()
                .sorted((x1, x2) -> x2 - x1)
                .toList();
        //Approach 2
        List<Integer> reverseOrder = randomNumbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("5.Sort a given list of decimals in reverse order");
        System.out.println(sortInReverseOrder);
        System.out.println(reverseOrder);
    }

    private static void wordFrequency() {
        List<String> names = Arrays.asList("rohit", "urmila", "rohit", "urmila", "ram", "sham", "sita", "gita");
        Map<String, Long> wordFrequency = names.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        System.out.println("4.the frequency of each element in an array or a list");
        System.out.println(wordFrequency);
    }

    private static void characterFrequency() {
        String name = "PraveenKumar";
        Map<Character, Long> characterFrequency = name.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        System.out.println("3.the frequency of each character in a string");
        System.out.println(characterFrequency);
    }

    private static void removeDuplicateElements() {
        List<Integer> oneToTen = Arrays.asList(8,9,10,2,3,6,5,7,5,6,7);
        List<Integer> removeDuplicateElements = oneToTen.stream()
                .distinct().toList();
        System.out.println("2.Remove duplicate elements from a list");
        System.out.println(removeDuplicateElements);
    }

    private static void evenAndOddSeperation() {
        List<Integer> oneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<String, List<Integer>> evenAndOddSeperation = oneToTen.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0?"Even":"Odd"));
        System.out.println(evenAndOddSeperation);
        Map<Boolean, List<Integer>> result = oneToTen.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        List<Integer> Even = result.get(true);
        List<Integer> odd = result.get(false);
        System.out.println("1.Separate odd and even numbers");
        System.out.println(Even);
        System.out.println(odd);
    }
}
