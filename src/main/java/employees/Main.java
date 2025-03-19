package employees;

import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void comain(String[] args) {
        String people = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000, yoe=10, iq=140}
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=1300, yoe=14, iq=100}
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=2300, yoe=8, iq=105}
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=1630, yoe=3, iq=115}
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=5, yoe=10, iq=100}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=300, dr=10}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=100, dr=4}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=200, dr=2}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=500, dr=8}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=175, dr=20}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=4}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=5}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=6}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=9}
                
                Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}  
                
                
                
                
                
              Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=6}
              Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=9}
              Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=6}
              Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=9}
                
       
               
                
                """;

        String peopleRegex = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}), \\s*(?<role>\\w+)\\n";
        Pattern pat = Pattern.compile(peopleRegex);
        Matcher mat = pat.matcher(people);


        String progRegex = "\\w+=(?<locpd>\\w),\\w+=(?<yoe>\\w),\\w+=(?<iq>\\w)";
        Pattern coderPat = Pattern.compile(progRegex);
        matcher coderMat

        int totalSalaries = 0;

        while (mat.find()) {
            totalSalaries += switch(mat.group("role")) {
                case "Programmer" -> {
                    yield 3000;
                }
                case "Manager" -> {
                    yield 3500;
                }
                case "Analyst" -> {
                    yield 2500;
                }
                case "CEO" -> {
                    yield 5000;
                }
                default -> 0;
            };

        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();





        System.out.printf("The total payout should be %s%n ", currencyInstance.format(totalSalaries));


    }

}
