package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;



public class Main {

    static class NrCost {
        int index = 0;
        int cost = 0;

        public NrCost(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

    }

    static class City {
        String name = "Undefined";
        int p = 0; // neighbor cities number
        List<NrCost> nrList = new ArrayList<>();

        public City(String name, int p) {
            Scanner scanner = new Scanner(System.in);
            this.name = name;
            this.p = p;
            for (int i = 0; i < p; i++) {
                System.out.println("enter index and cost");
                nrList.add(new NrCost(scanner.nextInt(), scanner.nextInt()));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //task1();
        //task2();
        //task3();

    }

    public static void task1() throws IOException {
        System.out.println("------Task 1------");
        int n = 0;
        while (n <= 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // also Scanner may be used
            System.out.println("input >0 integer value");
            n = Integer.parseInt(br.readLine());
            if (n <= 0) {
                System.out.println("value is invalid, try again");
            }
        }
        for (int i = 0; i < n; i++) {

            System.out.print("() ");
        }
        System.out.println();
    }

    public static void task2() throws IOException {
        System.out.println("------Task 2------");
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter number of test");
        int s = scanner.nextInt();
        System.out.println("Enter number of cities");
        int n = scanner.nextInt();

        List<City> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter name city and P ");
            cities.add(new City(br.readLine()/*name*/, scanner.nextInt()/*P*/));
        }
        System.out.println("Enter number of path to find");
        int r = scanner.nextInt();

        for (int i = 0; i < r; i++) {
            System.out.println("enter source");
            String source = br.readLine();
            System.out.println("enter destination");
            String destination = br.readLine();
            int posSource = 0;
            int posDestination = 0;
            for (int j = 0; j < n; j++) {
                if (source.equals(cities.get(j).name)) {posSource = j;} // System.out.println(cities.get(j).name+" "+posSource); debug

                if (destination.equals(cities.get(j).name)) {posDestination = j;} //System.out.println(cities.get(j).name+" "+ posDestination); debug
            }
            System.out.println("------Result------");
            System.out.println(getShortestPath(cities, posSource, posDestination));
        }




    }

    public static void task3() {
        System.out.println("------Task 3------");
        String s = String.valueOf(getFactorial(100));
        sumDigits(s);
    }

    public static BigInteger getFactorial(int n) {
        if (n < 0) {
            return BigInteger.ZERO;
        } else if (n > 0) {
            BigInteger factorial = BigInteger.ONE;
            for (int i = 1; i <= n; i++) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        } else {
            return BigInteger.ONE;
        }
    }

    public static void sumDigits(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Long.parseLong(s.substring(i, i + 1));
            //System.out.print(s.charAt(i)+"|"); just for debug nothing special)))
        }
        System.out.println("\n" + sum);
    }

    public static int getShortestPath(List<City> cities, int source, int destination) {
        int min = 0;
        int sum = 0;
        int i = 0;
        int index = source;

        while(source!=destination)
        {
            System.out.println(cities.get(index).nrList.get(i).cost);
            if(min < cities.get(index).nrList.get(i).cost)
            {
                min = cities.get(index).nrList.get(i).cost;
                index = cities.get(index).nrList.get(i).index-1;
                //System.out.println(index); debug
            }
            i++;
            if(i >= cities.get(index).p){
                source = index+1;
                i = 0;
                sum += min;
                min = 0;
            }
            //System.out.println(sum); debug
        }


        return sum;
    }
}

