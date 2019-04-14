package Algorithm.list;

/**
 * @ClassName LNode
 * @Description 为链表的节点
 * @Author liumingkang
 * @Date 2019-04-14 12:23
 * @Version 1.0
 **/
public class LNode<T>{

    //Node节点里的数据
    public T data;
    //Node存储的下一Node的位置
    public LNode<T> next;

    public LNode() {
    }

    public LNode(T data) {
        this.data = data;
    }
}
