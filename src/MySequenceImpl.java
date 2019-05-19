/**
 * Created with IntelliJ IDEA
 * Description:顺序表的实现
 * User: For
 * Date: 2019/5/13
 * Time: 13:38
 */
public class MySequenceImpl implements ISequence{
    private Object[] elem;
    private int usedSize;//有效数据的个数
    private static final int DEFAULT_SIZE=10;

    public MySequenceImpl() {
        this.elem=new Object[DEFAULT_SIZE];
        this.usedSize=0;
    }

    @Override
    public boolean add(int pos, Object data) {
        //pos位置不合适
        if (pos<0||pos>this.usedSize){
            return false;
        }
        if (usedSize==this.size()){
            this.elem=java.util.Arrays.copyOf(this.elem,2*elem.length);
        }
        int i=0;
        for (i = this.usedSize-1; i >=pos; i--) {
            elem[i+1]=elem[i];
        }
        elem[i]=data;
        return true;
    }
    private boolean isEmpty(){
        return this.usedSize==0;
    }
    @Override
    public int search(Object key) {
        if (isEmpty()){//数组为空就不存在
            return -1;
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if (this.elem[i].equals(key)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if (isEmpty()){//数组为空就不存在
            return false;
        }
        for (int i = 0; i <this.usedSize ; i++) {
            if (this.elem[i].equals(key)){
                return true;
            }
        }
        return false;
    }
    //得到pos位置的值
    @Override
    public Object getPos(int pos) {
        if (pos<0||pos>=this.usedSize){
            return null;
        }
        return this.elem[pos];
    }
    //删除第一次出现的关键字key

    @Override
    public Object remove(Object key) {
       //1.找到第一次出现的下标
        //2.对下标 进行判断
        //3.移除
        //4.返回
        int index=search(key);
        if (index==-1){
            return null;
        }
        Object oldData=this.elem[index];
        int i=0;
        for (i = index; i < usedSize-1; i++) {
            this.elem[i]=this.elem[i+1];
        }
        this.usedSize--;
        this.elem[i+1]=null;
        return oldData;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i < usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }

    @Override
    public void clear() {
        for (int i = 0; i <usedSize ; i++) {
            this.elem[i]=null;
        }
    }
}
