package Algorithm.list;

import Algorithm.list.base.MyList;

/**
 * @ClassName DouLinkedLIst
 * @Description Java实现双向链表 默认带头节点 序号下标从1开始 todo 需要测试功能是否完全正常
 * @Author liumingkang
 * @Date 2019-04-16 22:00
 * @Version 1.0
 **/
public class DouLinkedLIst<T> implements MyList<T> {

    private DNode<T> head;

    @Override
    public void InitList() {
        //初始化头节点 JVM分配堆内存空间
        head = new DNode<T>();
        //初始化'指针'为空
        head.rear=null;
        head.next=null;
        //默认数据为空 头节点不存储data数据
        head.data=null;
        //打印
        System.err.println("[Algorithm]:初始化双向链表完成!");
    }

    @Override
    public int size() {
        int count = 0;
        DNode p = head;
        while (p.next!=null){
            count++;
            p = p.next;
        }
        return count;
    }

    @Override
    public T get(int index) {
        if (index>this.size() || index<1){
            System.err.println("[Algorithm]:下标参数不合法！");
        }
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！");
        }
        DNode p;
        p = this.head;
        try{
            while (p.next!=null && index>0){
                p = p.next;
                index--;
            }
            return (T) p.data;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现异常！空指向！");
            return null;
        }
    }

    @Override
    public T Prior(int index) {
        if (index>this.size() || index<1){
            System.err.println("[Algorithm]:下标参数不合法！");
        }
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！ ");
        }
        DNode p = this.head;
        try{
            while (p.next!=null && index>0){
                p = p.next;
                index--;
            }
            return (T) p.rear.data;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现异常！空指向！");
            return null;
        }
    }

    @Override
    public T Next(int index) {
        if (index>this.size() || index<1){
            System.err.println("[Algorithm]:下标参数不合法！");
        }
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！  ");
        }
        DNode p = this.head;
        try{
            while (p.next!=null && index>0){
                p = p.next;
                index--;
            }
            if (p.next!=null){
                return (T) p.next.data;
            }else{
                System.err.println("[Algorithm]:此节点已经是末节点了！");
                return null;
            }
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现异常！空指向！");
            return null;
        }
    }

    @Override
    public int locate(T x) {
        int count = 0;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！  ");
        }
        DNode p = this.head;
        try{
            while (p.next!=null){
                count++;
                if (p.data==x){
                    return count;
                }
            }
            return -1;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现异常！空指向！");
            return -1;
        }
    }

    @Override
    public void insert(T x, int index) {
        if (index>this.size() || index<1){
            System.err.println("[Algorithm]:下标参数不合法！");
        }
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！   ");
        }
        if (x==null){
            System.err.println("[Algorithm]:要插入结点data数据不能为空");
        }
        DNode p;
        p = this.head;
        try{
            while (p.next!=null && index>0){
                index--;
                p = p.next;
            }
            DNode r = p.rear;
            //新增node
            DNode n = new DNode(x);
            //开始插入
            int length = this.size();
            //前驱和插入结点
            DNode temp = r.next;
            r.next = n;
            n.rear = temp;
            //插入结点和后驱
            p.rear = n;
            n.next = p;
            if (length == this.size()-1){
                System.err.println("[Algorithm]:链表插入成功！");
            }else{
                System.err.println("[Algorithm]:链表插入失败！");
            }
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现异常！空指向！");
        }

    }

    @Override
    public void delete(int index) {
        // todo 删除
    }

    @Override
    public boolean isEmpty() {
        if (this.size()>0){
            return false;
        }
        if (this.head.next==null){
            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (this.head == null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！   ");
        }
        this.head.next = null;
        return true;
    }


    @Override
    public boolean find(T x) {
        if (x==null){
            System.err.println("[Algorithm]:输入数据不合法！");
        }
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！ ");
        }
        DNode p;
        p = this.head;
        try{
            while (p.next != null){
                p = p.next;
                if (p.data == x){
                    return true;
                }
            }
            return false;
        }catch (NullPointerException e){
            System.err.println("[Algorithm]:链表出现异常！空指向！");
            return false;
        }
    }

    @Override
    public void print() {
        int count = 0;
        if (this.head==null){
            System.err.println("[Algorithm]:链表未初始化！请先执行init！ ");
        }
        DNode p = this.head;
        while (p.next != null){
            count++;
            System.err.println("结点--"+count+" data:"+p.data);
            p = p.next;
        }
    }
}
