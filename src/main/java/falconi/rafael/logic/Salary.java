package falconi.rafael.logic;

import java.util.*;

public class Salary {
    private static List<String> week = Arrays.asList("MO", "TU", "WE", "TH", "FT");
    private static List<String> weekend = Arrays.asList("SA", "SU");
    private HashMap<String, Integer> weekSalary =
            new HashMap<String, Integer>() {{
                put("morning", 25);
                put("day", 15);
                put("nigth", 20);
            }};
    private HashMap<String, Integer> weekendSalary =
            new HashMap<String, Integer>() {{
                put("morning", 30);
                put("day", 20);
                put("nigth", 25);
            }};

    private String employee;

    public Salary(String employee) {
        this.employee = employee;
    }

    public String getPayment() {
        String[] days = employee.split("=");
        int total = this.getWorkDays(days[1]);
        return "The amount to pay " + days[0] + " is: " + total + " USD";
    }

    public int getWorkDays(String days) {
        int total = 0;
        ArrayList<String> workDays = new ArrayList<String>(Arrays.asList(days.split(",")));
        for (String day :
                workDays) {
            total += this.salaryDay(day);

        }
        return total;
    }

    public int salaryDay(String dayInfo) {
        String day = dayInfo.substring(0, 2);
        String entryHour = dayInfo.substring(2, 4);
        String outHour = dayInfo.substring(8, 10);
        return getPayDay(day, Integer.parseInt(entryHour), Integer.parseInt(outHour));
    }

    public int getPayDay(String day, int introHour, int outHour) {
        int salary = outHour - introHour;
        if (this.week.contains(day)) {
            salary = salary * this.getSalaryHour(introHour);
        } else if (this.weekend.contains(day)) {
            salary = this.getSalaryHourWeekend(introHour) * salary;
        }
        return salary;

    }

    public int getSalaryHour(int hour) {
        int salaryHour = 0;
        if (0 <= hour && hour <= 8) {
            salaryHour = this.weekSalary.get("morning");
        } else if (9 <= hour && hour <= 15) {
            salaryHour = this.weekSalary.get("day");
        } else {
            salaryHour = this.weekSalary.get("nigth");
        }

        return salaryHour;
    }

    public int getSalaryHourWeekend(int hour) {
        int salaryHour = 0;
        if (0 <= hour && hour <= 8) {
            salaryHour = this.weekendSalary.get("morning");
        } else if (9 <= hour && hour <= 15) {
            salaryHour = this.weekendSalary.get("day");
        } else {
            salaryHour = this.weekendSalary.get("nigth");
        }
        return salaryHour;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
