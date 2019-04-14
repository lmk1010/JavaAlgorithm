package Algorithm;


import Algorithm.list.LinearList;

/**
 * @ClassName MainTest
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-04-13 22:38
 * @Version 1.0
 **/
public class MainTest {


    public static void main(String[] args) {

        LinearList<String> linearList = new LinearList<>();

        linearList.initList(10);

        linearList.insert("hello", 1);

        linearList.print();

    }
}
