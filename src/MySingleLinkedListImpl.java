/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Date: 2019/5/13
 * Time: 19:13
 */
public class MySingleLinkedListImpl implements ILinked {

    //用内部类定义一个结点
    class Node{
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //定义一个头结点
    private Node head;
    public MySingleLinkedListImpl() {
        this.head=null;
    }
    //头插法
    @Override
    public void addFirst(int data) {
        Node node=new Node(data);
        //第一次插入
        if (this.head==null){
            this.head=node;
        }else{
            node.next=this.head.next;
            this.head=node;
        }
    }
    //尾插法
    @Override
    public void addLast(int data) {

        Node node=new Node(data);
        if (this.head==null){
            this.head=node;
        }
        Node cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }

    //任意位置插入,第一个数据节点为0号下标
    private Node searchIndex(int index){
        if (index<0||index>getLength()){
            throw new UnsupportedOperationException("位置不合法");
        }
        Node cur=this.head;
        int count=0;
        for (int i = 0; i < index-1; i++) {
            cur=cur.next;
            count++;
        }
        return cur;
    }
    @Override
    public boolean addIndex(int index, int data) {
        Node node=new Node(data);
        if (index==0){
            addFirst(data);
            return true;
        }
        //找到要插入的下标
        Node cur=searchIndex(index);//实际上是要找到插入的前驱
        node.next=cur.next;
        cur.next=node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    @Override
    public boolean contains(int key) {
        Node cur=this.head;
        if (this.head==null){
            return false;
        }
            while(cur.next!=null){
                if (cur.next.data==key){
                    return true;
                }
                cur=cur.next;
            }
        return false;
    }
    //删除第一次出现关键字为key的节点3.3 链表面试题
    private Node searchPrev(int key){
        Node cur=this.head.next;
        while(cur!=null){
            if (cur.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        if (this.head==null){//1.先判断链表是否为空
            throw new UnsupportedOperationException("链表为空");
        }
        int oldData=0;
        if (this.head.data==key){//2.不为空时，看头结点是否是是要删除的结点
            oldData=this.head.data;
            this.head=this.head.next;
            return oldData;
        }
        Node prev=searchPrev(key);//3.如果不是要删除的头结点，则在后面找是否存在key
        if (prev==null){//表示没有找到关键字key
            throw new UnsupportedOperationException("没有找到key的前驱");
        }
        Node del=prev.next;//表示找到了key，将其删除，并返回要删除的数据。
        oldData=del.data;
        prev.next=del.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {

        if (this.head==null){//1.先判断链表是否为空
            return;
        }//不为空时，从头开始遍历，找到key关键字的前驱。
        if (this.head.data==key){
            this.head=this.head.next;
        }
        Node prev=this.head;
        Node cur=this.head.next;
        while(cur!=null){
            if (cur.data==key){
                prev.next=cur.next;
                cur=prev.next;
            }else {
                prev = cur;
                cur = prev.next;
            }
        }
    }

    @Override
    public int getLength() {
        if (this.head==null){
            return 0;
        }
        int count=0;
        Node cur=this.head;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur=this.head;
        while (cur != null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        while (this.head.next!=null){
            Node del=this.head.next;
            this.head.next=del.next;
        }
        this.head=null;
    }
    public void clear1(){
        Node cur=this.head.next;
        while(cur!=null){
            this.head.next=cur.next;
            cur=cur.next;
        }
        this.head=null;
    }
}
