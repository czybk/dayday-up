package czy.lamda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ConsumerTest {
    public static void main(String[] args) {

        Map map = new HashMap(){{
            put(1,1);
            put(2,1);
            put(3,1);
        }};
        test(map);
        System.out.println(map.size());
        BiConsumer<String, Integer> biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+integer);
            }
        };
        biConsumer.accept("1",222);
    }


    private static void test(Map param){
        param.put("11111",232332);
    }
}
