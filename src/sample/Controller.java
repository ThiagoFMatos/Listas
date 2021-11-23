package sample;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,5,6,6,7,7,7,8,3,8,8);
        final int N=3;
        System.out.println(nSizeParts(l,N));
        System.out.println(nTimeParts(l,N));
    }
    private static <T> List<List<T>> nSizeParts(List<T> objs, final int N) {
        return new ArrayList<>(IntStream.range(0, objs.size()).boxed().collect(
                Collectors.groupingBy(e->e/N,Collectors.mapping(e->objs.get(e), Collectors.toList())
                )).values());
    }
    private static <T> List<List<T>> nTimeParts(List<T> objs, final int N) {
        return new ArrayList<>(IntStream.range(0, objs.size()).boxed().collect(
                Collectors.groupingBy(e->e%N,Collectors.mapping(e->objs.get(e), Collectors.toList())
                )).values());
    }
}