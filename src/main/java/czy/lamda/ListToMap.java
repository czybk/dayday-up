package czy.lamda;

import czy.bean.Account;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListToMap {
    /**
     * List转Map（取其中的两个属性）
     * @param accounts
     * @return
     */
    public Map<Long, String> getIdNameMap(List<Account> accounts) {
        return accounts.stream().collect(Collectors.toMap(Account::getId, Account::getUsername));
    }

    /**
     * list转Map（object为value）
     * @param list
     * @return
     */
    public Map<String, Object> getObjMapByList(List<Account> list){
        return list.stream().collect(Collectors.toMap(account -> getKey(account), o -> o));
    }

    /**
     * list转Map（List为value）
     * @param list
     * @return
     */
    public Map<String, List<Account>> getMapListByList(List<Account> list){
        return list.stream().collect(Collectors.groupingBy(account ->{return getKey(account);}));
    }

    private String getKey(Account account){
        //判断空
        account = Optional.ofNullable(account).orElse(new Account());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(account.getId()).append(account.getUsername());
        return stringBuilder.toString();
    }

}
