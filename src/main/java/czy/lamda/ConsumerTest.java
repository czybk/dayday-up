package czy.lamda;

import java.util.function.BiConsumer;

public class ConsumerTest {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println(s+integer);
            }
        };
        biConsumer.accept("1",222);
    }

}
