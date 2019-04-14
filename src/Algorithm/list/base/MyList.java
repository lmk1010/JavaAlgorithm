package Algorithm.list.base;

import Algorithm.list.LinearList;

import java.util.List;

/**
 * @ClassName MyList
 * @Description 线性表接口
 * @Author liumingkang
 * @Date 2019-04-13 20:45
 * @Version 1.0
 * @see LinearList
 **/

public interface MyList<T> {

    /**
     * 初始化线性表，需要给定起始大小
     */
    void InitList();

    /**
     * 返回线性表的长度
     */
    int size();

    /**
     * 返回线性表中指定位置的数据
     */
    T get(int index);

    /**
     * 返回指定位置的前驱元素
     **/
    T Prior(int index);

    /**
     * 返回指定位置的后驱元素
     **/
    T Next(int index);

    /**
     * 返回元素x在L中的位置序号
     **/
    int locate(T x);

    /**
     * 在指定位置插入元素
     **/
    void insert(T x, int index);

    /**
     * 删除指定位置的元素
     **/
    void delete(int index);

    /**
     * 判断此线性表是否为空
     **/
    boolean isEmpty();

    /**
     * 清除线性表中所有元素
     **/
    boolean clear();

    /**
     * 查找线性表中元素返回是否存在
     **/
    boolean find(T x);

    /**
     * 打印线性表所有元素 打印格式: 此线性表为:x1---->x2---->x3---->x4---->
     **/
    void print();


}
