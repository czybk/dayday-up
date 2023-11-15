package czy.lamda;

import czy.bean.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class ReduceTest {

    /**
     * function取对象不同属性的加和
     * @param list
     * @param function
     * @return
     */
    private BigDecimal getSumDecimal(List<Account> list, Function<Account, BigDecimal> function){
        return list.stream().map(function).filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
