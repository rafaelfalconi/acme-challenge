package falconi.rafael;

import falconi.rafael.logic.Salary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryTest {
    Salary salary;

    @Before
    public void before() {
        salary = new Salary("RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00");
    }

    @Test
    public void setEmployee() {
        assertEquals(215
                , salary.getWorkDays("MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00"), 10);
    }

    @Test
    public void getSalaryHour() {
        assertEquals(15, salary.getSalaryHour(10));
    }

    @Test
    public void getSalaryHourWeekend() {
        assertEquals(20, salary.getSalaryHourWeekend(10));
    }

    @Test
    public void getPayDay() {
        assertEquals(25, salary.getPayDay("SU", 20, 21));
    }

    @Test
    public void salaryDay() {
        assertEquals(25, salary.salaryDay("SU20:00-21:00"));
    }

    @Test
    public void getWorkDays(){
        assertEquals(215, salary.getWorkDays("MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00"));
    }

    @Test
    public void getPayment(){
        assertEquals("The amount to pay RENE is: 215 USD",salary.getPayment());
    }
}