package interview4.javase.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author HedianTea
 * @email daki9981@qq.com
 * @Date 2024/7/24 20:57
 * @Description:
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    // 温馨提示，本类没有重新复写 hashCode 和 equals 方法
    private Integer id;
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
