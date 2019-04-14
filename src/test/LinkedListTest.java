package test;

import Algorithm.list.LNode;
import Algorithm.list.LinkedList;

/**
 * @ClassName LinkedListTest
 * @Description 测试LinkedList功能
 * @Author liumingkang
 * @Date 2019-04-14 12:39
 * @Version 1.0
 **/
public class LinkedListTest {


    public static void main(String[] args){

        LinkedList linkedList = new LinkedList();

        linkedList.InitList();

        System.out.println(linkedList.size());

        linkedList.insert("string");

        linkedList.insert("string1");

        linkedList.insert("string2");

        System.out.println(linkedList.size());

        linkedList.print();

        linkedList.clear();

        System.out.println(linkedList.size());




    }


}
