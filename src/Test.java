
/**
 * Created with IntelliJ IDEA
 * Description:
 * User: For
 * Date: 2019/5/14
 * Time: 9:30
 */
public class Test {
    public static void main(String[] args) {
        MyHeadSingleListImpl myHeadSingleList=new MyHeadSingleListImpl();
        myHeadSingleList.addFirst(1);
        myHeadSingleList.addFirst(2);
        myHeadSingleList.addFirst(3);
        myHeadSingleList.display();
        myHeadSingleList.addLast(1);
        myHeadSingleList.addLast(2);
        myHeadSingleList.addLast(3);
        myHeadSingleList.display();
        myHeadSingleList.addIndex(0,0);
        myHeadSingleList.addIndex(1,1);
        myHeadSingleList.addIndex(2,2);
        myHeadSingleList.display();
        System.out.println(myHeadSingleList.getLength());
        myHeadSingleList.remove(1);
        myHeadSingleList.display();
        myHeadSingleList.removeAllKey(1);
        myHeadSingleList.display();
        System.out.println(myHeadSingleList.contains(2));
        myHeadSingleList.clear();
        myHeadSingleList.display();
    }
}
