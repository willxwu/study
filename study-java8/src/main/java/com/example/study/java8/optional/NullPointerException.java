package com.example.study.java8.optional;

import java.util.Optional;

/**
 * 根据用户拿到保险名字
 */
public class NullPointerException {
    public static void main(String[] args) {
        //肯定会包空指针异常
//        String insuranceNameByPerson = getInsuranceNameByPerson(new Person());
        //原始写法,做了空指针判断
        String insuranceNameByCheckPerson = getInsuranceNameByCheckPerson(new Person());
//        System.out.println(insuranceNameByCheckPerson);

        //Opional写法
        String insuranceNameByOptional = getInsuranceNameByOptional(null);
        System.out.println(insuranceNameByOptional);

    }

    //Opional写法
    public static String getInsuranceNameByOptional(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("-1");
    }

    //flatMap不会把结果包装成Optional，map会。


    //原始写法判断
    public static String getInsuranceNameByCheckPerson(Person person) {
        if(null != person) {
            if(null != person.getCar()) {
                Car car = person.getCar();
                if (null != car) {
                    Insurance insurance = car.getInsurance();
                    if (null != insurance) {
                        return  insurance.getName();
                    }
                }
            }
        }
        return "UNKNOWN";
    }

    public static String getInsuranceNameByPerson(Person person){
        return person.getCar().getInsurance().getName();
    }
}
