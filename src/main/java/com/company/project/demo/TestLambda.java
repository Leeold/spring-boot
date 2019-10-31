package com.company.project.demo;

import com.alibaba.druid.support.json.JSONUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class TestLambda {
    List<Employee> employeeList = Arrays.asList(
            new Employee("张三", 18,9999.99),
            new Employee("李四", 38,5555.99),
            new Employee("王五", 50,6666.66),
            new Employee("赵六", 16,3333.33),
            new Employee("田七", 10,7777.77)
            );
    @Test
    public void test1(){
        this.employeeList.stream().filter(x -> x.getAge() > 30).forEach(System.out::println);
    }
    @Test
    public void test2(){
       Consumer<String> con = (x)->System.out.println(x);
    }
}
