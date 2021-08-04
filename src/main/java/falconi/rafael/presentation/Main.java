package falconi.rafael.presentation;

import falconi.rafael.logic.Salary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {
        System.out.println("pleas insert the path with the .txt file");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileReader fileReader=new FileReader(name);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String employee=bufferedReader.readLine();
        Salary salary=new Salary(employee);
        System.out.println(salary.getPayment());
    }
}
