package czy.fel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import com.greenpineyu.fel.FelEngine;
import com.greenpineyu.fel.FelEngineImpl;
import com.greenpineyu.fel.context.FelContext;
import czy.bean.Goods;
import org.junit.Test;

public class FelDemo {
    /**
     * 使用常量
     */
    @Test
    public void test0() {
        FelEngine felEngine = new FelEngineImpl();
        Object result = felEngine.eval("2*3");
        System.out.println(result);
    }
    /**
     * 使用变量
     */
    @Test
    public void test2() {
        FelEngine felEngine = new FelEngineImpl();
        FelContext ctx = felEngine.getContext();
        ctx.set("count", 10);
        ctx.set("price", 100);
        Object result = felEngine.eval("count*price");
        System.out.println(result);
    }

    /**
     * 使用变量的方法和属性
     */
    @Test
    public void test3() {
        FelEngine felEngine = new FelEngineImpl();
        FelContext ctx = felEngine.getContext();
        Goods good = Goods.randomGoods();
        ctx.set("good", good);

        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        ctx.set("map", map);

        //取不存在的方法属性,返回null
        Object result = felEngine.eval("good.size");
        System.out.println("result:" + result);

        //调用good的toString
        result = felEngine.eval("good.toString");
        System.out.println("result:" + result);

        //获取name（分别调用  name() 方法 和  getName() 方法，name(优先) ，不会取直接获取私有字段）
        result = felEngine.eval("good.name");
        System.out.println("result:goodname:" + result);

        //调用有参方法  name(int  i)
        result = felEngine.eval("good.name(1)");
        System.out.println("result:good.name(1)-------" + result);


        //获取 map 的 value
        result = felEngine.eval("map.key1");
        System.out.println("result:" + result);
    }


    /**
     * 使用集合，直接用下标获取 集合元素
     */
    @Test
    public void test4() {
        FelEngine felEngine = new FelEngineImpl();
        FelContext ctx = felEngine.getContext();

        // 数组
        int[] intArray = { 1, 2, 3 };
        ctx.set("intArray", intArray);
        String exp = "intArray[0]";
        System.out.println(exp + "->" + felEngine.eval(exp));

        // List
        List<Integer> list = Arrays.asList(1, 2, 3);
        ctx.set("list", list);
        exp = "list[0]";
        System.out.println(exp + "->" + felEngine.eval(exp));

        // 集合
        Collection<String> coll = Arrays.asList("a", "b", "c");
        ctx.set("coll", coll);
        // 获取集合最前面的元素。执行结果为"a"
        exp = "coll[0]";
        System.out.println(exp + "->" + felEngine.eval(exp));

        // 迭代器
        Iterator<String> iterator = coll.iterator();
        ctx.set("iterator", iterator);
        // 获取迭代器最前面的元素。执行结果为"a"
        exp = "iterator[0]";
        System.out.println(exp + "->" + felEngine.eval(exp));

        //Map
        Map<String, String> m = new HashMap<String, String>();
        m.put("name", "HashMap");
        ctx.set("map", m);
        exp = "map.name";
        System.out.println(exp + "->" + felEngine.eval(exp));

        // 多维数组
        int[][] intArrays = { { 11, 12 }, { 21, 22 } };
        ctx.set("intArrays", intArrays);
        exp = "intArrays[0][0]";
        System.out.println(exp + "->" + felEngine.eval(exp));

        // 多维综合体，支持数组、集合的任意组合。
        List<int[]> listArray = new ArrayList<int[]>();
        listArray.add(new int[] { 1, 2, 3 });
        listArray.add(new int[] { 4, 5, 6 });
        ctx.set("listArray", listArray);
        exp = "listArray[0][0]";
        System.out.println(exp + "->" + felEngine.eval(exp));
    }

}
