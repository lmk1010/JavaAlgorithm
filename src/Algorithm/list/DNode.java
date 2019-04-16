package Algorithm.list;

/**
 * @ClassName DNode
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-04-16 22:03
 * @Version 1.0
 **/
public class DNode<T> {

    //Node存储的前一Node的位置
    public DNode<T> rear;
    //Node节点里的数据
    public T data;
    //Node存储的下一Node的位置
    public DNode<T> next;

    public DNode() {
    }

    public DNode(T data) {
        this.data = data;
    }
}
