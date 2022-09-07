package com.example.study.java8.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * 创建Stream的方式
 * 1、通过Collection
 * 2、通过values
 * 3、通过Arrays
 * 4、通过file
 * 5、通过iterate创建,无限的创建
 * 6、通过Generate创建
 * 7、自定义Supplier，创建Stream
 */
public class CreateStream {
    public static void main(String[] args) {
        createStreamByCollection().forEach(System.out::println);

        System.out.println("================================");

        createStreamByValues().forEach(System.out::println);

        System.out.println("================================");
        createStreamByArrays().forEach(System.out::println);

        System.out.println("================================");
        createStreamByFile().forEach(System.out::println);

        System.out.println("================================");
        createStreamByIterate().forEach(System.out::println);

        System.out.println("================================");
        crateStreamByGenerate().forEach(System.out::println);

        System.out.println("================================");
        createStreamByDefine().forEach(System.out::println);
    }

    /**
     * 1、通过Collection创建Stream，数据顺序和放入顺序一致
     * @return
     */
    public static Stream<String> createStreamByCollection(){
        List<String> list = Arrays.asList(new String("Hello"), new String("world"), new String("please"));
        return list.stream();
    }

    /**
     * 2、通过values创建Stream，顺序一致
     * @return
     */
    public static Stream<String> createStreamByValues(){
        return Stream.of("Hello","world","please");
    }

    /**
     * 3、通过Arrays创建，顺序一致
     * @return
     */
    public static Stream<String> createStreamByArrays(){
        return Arrays.stream(new String[]{"Hello","world","please"});
    }

    /**
     * 4、通过file创建
     * @return
     */
    public static Stream<String> createStreamByFile(){
        Path path = Paths.get("D:\\software\\workspace\\IdeaProjects\\study\\study-java8\\src\\main\\java\\com\\example\\study\\java8\\streams\\CreateStream.java");
        try {
            Stream<String> stream = Files.lines(path);
            return stream;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * 5、通过iterate创建,无限的创建
     * @return
     */
    public static Stream<Integer> createStreamByIterate(){
        return Stream.iterate(0, n->n+2).limit(10);
    }

    /**
     * 6、通过Generate创建
     * @return
     */
    public static Stream<Double> crateStreamByGenerate(){
        return Stream.generate(Math::random).limit(10);
    }


    /**
     * 自定义Supplier，创建Stream
     * @return
     */
    public static Stream<Obj> createStreamByDefine(){
        return Stream.generate(new ObjSupplier()).limit(10);
    }



    static class ObjSupplier implements Supplier<Obj> {

        int index =0;
        Random random = new Random(System.currentTimeMillis());
        @Override
        public Obj get() {
            index = random.nextInt(100);
            return new Obj(index, "Name->"+index);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    static class Obj{
        private Integer id;
        private String name;
    }
}
