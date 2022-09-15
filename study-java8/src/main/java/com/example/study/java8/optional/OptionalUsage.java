package com.example.study.java8.optional;

import java.util.Optional;

/**
 * Optional api
 */
public class OptionalUsage {
    public static void main(String[] args) {
        //1、创建Optinal，get()会抛出异常
        Optional<Insurance> emptyOptional = Optional.<Insurance>empty();
        //抛出异常提示：No value present
//        emptyOptional.get();

        //2、of创建，get（）,不会抛异常
        Optional<Insurance> ofInsurance = Optional.of(new Insurance());
//        ofInsurance.get();

        //3、ofNullable：上面两者综合
        //3.1、为null时，调get()抛出异常：No value present
        Optional<Insurance> ofNullableOptionalNull = Optional.ofNullable(null);
//        ofNullableOptionalNull.get();

        //3.2、不为null时，调get()不报错
        Optional<Insurance> ofNullableOptionalNotNull = Optional.ofNullable(new Insurance());
//        ofNullableOptionalNotNull.get();


        System.out.println("=====================================================");

        //orElseGet --不为null就返回值，否则返回一个构造的对象supplier
//        Insurance orElseGetInsurance = ofNullableOptionalNull.orElseGet(Insurance::new);
//        System.out.println(orElseGetInsurance);

        //orElse ----不为null就返回值，否则返回一个引用
//        Insurance orElseInsurance = ofNullableOptionalNull.orElse(new Insurance());
//        System.out.println(orElseInsurance);

        //orElseThrow ---不为null就返回值，否则返回一个异常对象
//        Insurance orElseThrowInsurance = ofNullableOptionalNull.orElseThrow(RuntimeException::new);

        //orElseThrow---不为null就返回值，否则返回自定义异常构造的对象
//        Insurance defineOrElseThrowInsurance = ofNullableOptionalNull.orElseThrow(() -> new RuntimeException("yanxizhu Exception"));


        System.out.println("=====================================================");
        //filter使用

        //1、empty
        //调用get（）,都会报错：No value present: 因为name字段不存在
//        Optional<Insurance> insurance = emptyOptional.filter(t -> t.getName() == null);
//        Optional<Insurance> insurance = emptyOptional.filter(t -> t.getName() != null);
//        insurance.get();

        //2、of
        //不报错，因为name字段存在，且满足name==null
//        Optional<Insurance> insurance = ofInsurance.filter(t -> t.getName() == null);
        //报错，因为name虽然存在，但是name!=null,不成立，会返回empty空，使用get()时就会抛出异常：No value present
//        Optional<Insurance> insurance = ofInsurance.filter(t -> t.getName() != null);
//        insurance.get();

        //3、ofNullable
        //都报错：ofNullableOptional,会走empty创建的Optional，字段不存在，直接get获取值为空，报错：No value present
//        Optional<Insurance> insurance = ofNullableOptionalNull.filter(t -> t.getName() != null);
//        Optional<Insurance> insurance = ofNullableOptionalNull.filter(t -> t.getName() == null);
//        insurance.get();

        //不会报错,走of方法创建的Optional，name字段存在，且name==null，所以不报错
//        Optional<Insurance> insurance = ofNullableOptionalNotNull.filter(t -> t.getName() == null);
        //报错，因为虽然name存在，但是name!=null不成立，返回empty，get(）就报错了
//        Optional<Insurance> insurance = ofNullableOptionalNotNull.filter(t -> t.getName() != null);
//        insurance.get();


        //使用时不确定是否为empty，所以直接使用ofNullableOptional创建Optional.



        System.out.println("=====================================================");
        //map使用
//        Optional<String> stringOptional = ofNullableOptionalNotNull.map(t -> t.getName());
//        //有值则返回，没值则返回给定值
//        System.out.println(stringOptional.orElse("-1"));
//        //判断值是否存在
//        System.out.println(stringOptional.isPresent());
//        //存在值，则打印输出，没有值，不打印。
//        stringOptional.ifPresent(System.out::println);


        System.out.println("=====================================================");
        //flatMap使用
//        Optional<Cat> cat = Optional.ofNullable(new Cat());
//        //map将结果包装成Optional
//        Optional<Optional<Eat>> eat = cat.map(c -> c.getEat());
//        //flatMap不会
//        Optional<Eat> eat1 = cat.flatMap(c -> c.getEat());


        //范例：获取值时，校验值可能为空。
//        String insuranceName = getInsuranceName(new Insurance());
        String insuranceName = getInsuranceName(null);
        System.out.println(insuranceName);
    }

    public static String getInsuranceName(Insurance insurance) {
        Optional<String> optional = Optional.ofNullable(insurance).map(Insurance::getName);
        return optional.orElse("-1");
    }
}

