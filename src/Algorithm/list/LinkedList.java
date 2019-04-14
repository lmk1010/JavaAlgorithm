package Algorithm.list;

import Algorithm.list.base.List;
import Algorithm.list.base.MyList;
import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * @ClassName LinkedList
 * @Description Java实现单链表 默认实现带头节点的单链表
 * @Author liumingkang
 * @Date 2019-04-14 12:23
 * @Version 1.0
 **/
public class LinkedList<T> implements MyList<T> {

    public LNode<T> head;

    public void InitList(){
        //初始化单链表头节点
        head = new LNode<>();
        //重置头节点指向为空
        head.next=null;
        //头节点默认不存储数据
        head.data=null;
        System.err.println("[Algorithm]:初始化单链表完成!");
    }

    public int size(){
        int count = 0;
        LNode p;
        if (head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        p = head;
        try{
            //对链表进行遍历
            while (p.next!=null){
                count++;
                p = p.next;
            }
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现指针异常！");
        }
        return count;
    }

    //默认实现是头插法
    public void insert(T x){
        LNode temp,n;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        //初始化待插入节点
        n = new LNode(x);
        //进行插入替换next指向
        temp = head.next;
        head.next = n;
        n.next = temp;
        //打印结果
        System.err.println("[Algorithm]:插入节点完成！");
    }

    //如果使用头插法进行添加节点，注意此时节点顺序相反
    public T get(int index){
        LNode p;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        if (index>size() || index<1){
            System.err.println("[Algorithm]:输入下标超出链表长度！");
        }
        p = head;
        if (index>size()){
            System.err.println("[Algorithm]:错误的下标序号！");
            return null;
        }
        try{
            while(index>0){
                p = p.next;
                index--;
            }
            return (T) p.data;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现指针异常！");
            return null;
        }
    }

    public LNode getNode(int index){
        LNode p;
        if (head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        if (index>size() || index<1){
            System.err.println("[Algorithm]:输入下标超出链表长度！");
        }
        p = head;
        if (index>size()){
            System.err.println("[Algorithm]:错误的下标序号！");
            return null;
        }
        try{
            while(index>0){
                p = p.next;
                index--;
            }
            return p;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现指针异常！");
            return null;
        }
    }


    //并未复用此段代码是为了看的清楚
    public T Prior(int index) {
        LNode q;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        if (index>size() || index<0){
            System.err.println("[Algorithm]:输入下标超出链表长度！");
        }
        if (index==0){
            System.err.println("[Algorithm]:该结点为头节点！");
        }
        q = head;
        //找到要插入位置的前驱结点
        while (q.next!=null && (index-1)>0){
            q = q.next;
            index--;
        }
        return (T) q.data;
    }


    public T Next(int index) {
        LNode n;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        n = head;
        if (index>size() || index<0){
            System.err.println("[Algorithm]:输入下标超出链表长度！");
        }
        if (index==size()){
            System.err.println("[Algorithm]:此节点为末结点，无后驱结点！");
        }
        //找到要插入位置的后驱结点
        while (n.next!=null && (index+1)>0){
            n = n.next;
            index--;
        }
        return (T) n.data;
    }

    public int locate(T x){
        LNode p;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        int count = 0;
        try{
            p = this.head.next;
            while (p!=null){
                count++;
                if (p.data==x){
                    break;
                }
                p = p.next;
            }
            return count;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现指针异常！");
            return -1;
        }
    }


    public void insert(T x, int index) {
        LNode p,q;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        int count = 0;
        p = new LNode(x);
        q = head;
        //找到要插入位置的前驱结点
        while (q.next!=null && (index-1)>0){
            q = q.next;
            index--;
        }
        //加入结点
        LNode temp = q.next;
        q.next = p.next;
        p.next = temp;
        System.err.println("[Algorithm]:结点插入成功!");
    }

    public void delete(int index){
        LNode p,q;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        int count = 0;
        try{
            q = this.head;
            while (q.next!=null && (index-1)>0){
                q = q.next;
                index--;
            }
            p = q.next;
            //开始执行删除节点P
            q.next = p.next;
            p.next = null;

            System.err.println("[Algorithm]:删除节点完毕！");
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现指针异常！");
        }

    }

    @Override
    public boolean isEmpty() {
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        if (this.head.next==null){
            System.err.println("[Algorithm]:链表为空");
            return true;
        }
        System.err.println("[Algorithm]:链表不为空");
        return false;
    }


    public boolean clear() {
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        //置空头节点next域
        this.head.next = null;
        //对于java而言自动回收LNode节点
        System.err.println("[Algorithm]:已经置空");
        return true;
    }

    @Override
    public boolean find(T x) {
        LNode p;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        try{
            p = this.head.next;
            while (p!=null){
                if (p.data==x){
                    break;
                }
                p = p.next;
            }
            return true;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现指针异常！");
            return false;
        }
    }

    public void print(){
        LNode p;
        int count = 1;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化,请先执行init！");
        }
        p = this.head.next;
        while(p!=null){
            System.err.println("结点--"+count+" data:"+p.data);
            p = p.next;
            count++;
        }
    }

}
