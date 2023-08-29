package czy.lamda;

import czy.bean.ActivityInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompareList {

    /**
     * 过滤两个list<Bean>数据的策略(bean对象可以不同)
     *
     * @param otherList     被比较的List<bean>
     * @param otherFunction 被比较的Function(目的是为了组装key)
     * @param thisFunction  调用此方法方的Function(目的是为了组装key)
     * @return
     */
    public static  <E, M, V> Predicate<E> distinctByOtherList(List<M> otherList, Function<M, V> otherFunction, Function<E, V> thisFunction) {
        Set<V> otherKeySet = otherList.stream().map(otherFunction).collect(Collectors.toSet());
        return e -> Boolean.TRUE.equals(otherKeySet.contains(thisFunction.apply(e)));
    }

    public static void main(String[] args) {
        List<ActivityInfo> list1 = new ArrayList<ActivityInfo>(){{
            add(new ActivityInfo(){{
                setActivityName("111");
            }});
            add(new ActivityInfo(){{
                setActivityName("222");
            }});
        }};
        List<ActivityInfo> list2 = new ArrayList<ActivityInfo>(){{
            add(new ActivityInfo(){{
                setActivityName("111");
            }});
            add(new ActivityInfo(){{
                setActivityName("333");
            }});
        }};
        Function<ActivityInfo, String> umDishFunction = umDish -> umDish.getActivityName();
        List<ActivityInfo> collect1 = list1.stream().filter(distinctByOtherList(list2, ActivityInfo::getActivityName, umDishFunction)).collect(Collectors.toList());
        System.out.println(collect1);//setActivityName("111");
    }
}
