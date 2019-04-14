package Algorithm.list;


import Algorithm.list.base.MyList;

import java.util.List;

/**
 * @ClassName LinearList
 * @Description 线性表Java实现 注:默认返回index下标全部为0开始
 * @Author liumingkang
 * @Date 2019-04-13 20:45
 * @Version 1.0
 **/
public class LinearList<T> implements MyList<T> {

    private Object[] data; //data数组

    private int maxsize; //初始线性表的长度

    @Override
    public void initList(int maxsize) {
        if (maxsize <= 0) {
            System.err.println("JavaAlgorithm:初始化容量不能为0！");
        }
        this.data = new Object[maxsize];
        this.maxsize = maxsize;
    }

    @Override
    public int size() {
        return this.maxsize;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            System.err.println("JavaAlgorithm:非法的下标序号！");
            return null;
        }
        return (T) this.data[index];
    }

    @Override
    public T Prior(int index) {
        if (index < 0) {
            System.err.println("JavaAlgorithm:非法的下标序号！");
            return null;
        }
        if (index == 0) {
            System.err.println("JavaAlgorithm:此节点为头节点，无前驱节点！");
            return null;
        }
        return (T) this.data[index - 1];
    }

    @Override
    public T Next(int index) {
        if (index < 0) {
            System.err.println("JavaAlgorithm:非法的下标序号！");
            return null;
        }
        if (index == this.maxsize - 1) {
            System.err.println("JavaAlgorithm:此节点为末节点，无后驱节点！");
            return null;
        }
        return (T) this.data[index + 1];
    }

    @Override
    public int locate(Object x) {
        if (x == null) {
            System.err.println("JavaAlgorithm:Object为空！");
            return -1;
        }
        for (int i = 0; i < this.maxsize - 1; i++) {
            if (this.data[i] == x) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean insert(T x, int index) {
        if (index < 0 || index > this.maxsize) {
            System.err.println("JavaAlgorithm:非法的下标序号！");
            return false;
        }
        if (this.data[maxsize - 1] != null) {
            System.err.println("JavaAlgorithm:线性表已满！");
            return false;
        }
        if (x == null) {
            System.err.println("JavaAlgorithm:Object为空！");
            return false;
        }
        if (this.data[index] == null) {
            int i = 0;
            while (this.data[i] != null) {
                i++;
            }
            this.data[i] = x;
        }
        for (int i = this.data.length - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = x;
        return true;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        if (this.data.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = null;
        }
        return true;
    }

    @Override
    public boolean find(T x) {
        return false;
    }

    @Override
    public void print() {
        for (int i = 0; i < this.data.length; i++) {
            System.out.print(" 线性表为:" + this.data[i]);
        }
    }
}
