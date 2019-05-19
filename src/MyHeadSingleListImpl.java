/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Date: 2019/5/13
 * Time: 21:24
 */
public class MyHeadSingleListImpl implements ICLinked {
    class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
        //头结点
        public Node(){
            this.data=-1;
            this.next=null;
        }
    }

    private Node head;

    public MyHeadSingleListImpl() {
        this.head = new Node();
        this.head.next=this.head;
    }
    //头插法
    @Override
    public void addFirst(int data) {
        Node node=new Node(data);
        node.next=this.head.next;
        this.head.next=node;
    }
    //尾插法
    @Override
    public void addLast(int data) {
        Node node=new Node(data);
        Node cur=this.head;
        while(cur.next!=this.head){
            cur=cur.next;
        }
        node.next=cur.next;
        cur.next=node;
    }
    //任意位置插入,第一个数据节点为0号下标
    private  void checkIndex(int index){
        if (index<0||index>getLength()){
            throw new UnsupportedOperationException("下标不符合规则");
        }
    }
    private Node searchIndex(int index){
        Node cur=this.head;
        for (int i = 0; i <index ; i++) {
            cur=cur.next;
        }
        return cur;
    }
    @Override
    public boolean addIndex(int index, int data) {
        ///首先要检查下标是否符合规则
        checkIndex(index);
        Node node=new Node(data);
        Node prev=searchIndex(index);
        node.next=prev.next;
        prev.next=node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        while(cur.next!=this.head){
            if (cur.next.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    //删除第一次出现关键字为key的节点
    private Node searchPrev(int key){
        Node cur=this.head;
        while(cur.next!=this.head){
            if (cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        Node prev=searchPrev(key);
        if (prev==null){
            throw new UnsupportedOperationException("不存在key的前驱");
        }
        int oldData=0;
        Node del=prev.next;
        oldData=del.data;
        prev.next=del.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {

        Node prev=this.head;
        Node cur=prev.next;
        while(cur!=this.head) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = prev.next;
                cur = prev.next;
            }
        }
//        Node prev=searchPrev(key);
//        if (prev==null){
//            throw new UnsupportedOperationException("不存在key的前驱");
//        }
//        Node del=prev.next;
//        prev.next=del.next;
//        del=del.next;
    }

    @Override
    public int getLength() {
        Node cur=this.head;
        int count=0;
        while(cur.next!=this.head){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {

        Node cur=this.head;
        while(cur.next!=this.head){
            System.out.print(cur.next.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        Node cur=this.head.next;
        while(cur.next!=this.head){
            this.head.next=cur.next;
            cur=cur.next;
        }
        this.head.next=null;
    }
}
