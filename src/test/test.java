import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zhy
 * @since : 2020/11/17 17:05
 */
public class test {
    public static void main(String... args) {


        Double dt=20191000319d;
        Double double1 = 123456789.123456789;
        DecimalFormat decimalFormat = new DecimalFormat("#");//格式化设置
       // System.out.println(decimalFormat.format(dt));
        //System.out.printf(""+ new String(dt.toString()));
        String ba="-123412312.00";

        Double d = new Double(ba);
        if(d.compareTo(0d)>0) {
            System.out.printf("" + d);
        }


        //再看几个例子：数组字母小写变大写
        List<String> list= Arrays.asList("a", "b", "c", "d");

        List<String> collect =list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        //数组所有元素，按某种规律计算：
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]
    }
}
