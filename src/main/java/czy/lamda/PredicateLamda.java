package czy.lamda;

import czy.bean.Account;
import czy.bean.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateLamda<T, R, U> {
    public static<T> List<T> predicateList(List<T> list, Predicate<T> predicate){
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Predicate<Account> accountPredicate = account -> BigDecimal.ONE.equals(account.getJe());
        Predicate predicate = accountPredicate.negate();
        BiPredicate<Map, User> biPredicate = new BiPredicate<Map, User>() {
            @Override
            public boolean test(Map map, User user) {
                if(user == null || map == null){
                    return false;
                }
                if(map.get(user.getId()) != null){
                    return true;
                }
                return false;
            }
        };

        List<User> list = new ArrayList<User>(){{
           add(new User(){{setId(111);setUsername("qqq");}});
           add(new User(){{setId(222);setUsername("qqq222");}});

        }};

        Map<Integer, Object> map = new HashMap<Integer, Object>(){{
            put(111, 123);
        }};

        Function<User, Account> function = new Function<User, Account>() {
            @Override
            public Account apply(User user) {
                return null;
            }
        };

        System.out.println(list.stream().filter(o ->  biPredicate.test(map,o)).collect(Collectors.toList()));
    }


}
