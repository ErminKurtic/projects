import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<myObject> myList = new ArrayList<>();

        generateMethod(myList);
        System.out.println(myList.toString());
        System.out.println("- - - - - - - - \n");
        valueOverTwenty(myList);
        System.out.println("- - - - - - - - \n");
        averageValue(myList);
        System.out.println("- - - - - - - - \n");
        nameToTrue(myList);
    }

    public static boolean randomBoolean() {  //Boolean randomizer
        Random random = new Random();
        boolean randomBool = random.nextBoolean();

        return randomBool;
    }

    public static String randomString() {

        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        StringBuilder sb = new StringBuilder(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String output = sb.toString();
        return output;
    }

    public static int randomNumber(){

        int random = (int)(Math.random()*50+1);
        return random;
    }

    public static void generateMethod(List<myObject> myList){

        for(int i = 0; i < 50; i++){

            myList.add(new myObject(randomBoolean(), randomNumber(), randomString()));


        }
    }

    public static void valueOverTwenty(List<myObject> myList){

        List<myObject> overTwenty = myList
                .stream()
                .filter(x -> x.getValue() > 20)
                .collect(Collectors.toList());


        for(int i = 0; i < overTwenty.size(); i++)
        {
            System.out.println("Bool: " + overTwenty.get(i).getBool());
            System.out.println("Name: " + overTwenty.get(i).getName());
            System.out.println("Value:" + overTwenty.get(i).getValue());
        }

    }

    public static void averageValue(List<myObject> myList){

        OptionalDouble average = myList
                .stream()
                .mapToDouble(x-> x.getValue())
                .average();

        System.out.println("Average values: " + average);
    }

    public static void nameToTrue(List<myObject> myList){

        List<myObject> list = myList
                .stream()
                .filter(x -> x.getBool())
                .peek(x -> {
                    if(x.getBool()){
                        x.setName("This Is True");
                    }
                })
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

}