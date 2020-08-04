package com.yui.algorithmYui.lineartable;
/**
 * 自定义动态数组
 *
 *      动态数组（Dynamic Array）接口设计
 *
 *      int size();//元素的数量
 *      boolean isEmpty();//是否为空
 *      boolean contains(E element);//是否包含某个元素
 *      void add(E element);//添加元素到最后面
 *      E get(int index);//返回index位置对应的元素
 *      E set(int index, E element);//设置index位置的元素
 *      void add(int index, E element);//往index位置添加元素
 *      E remove(int index);//删除index位置对应的元素
 *      int indexOf(E element);//查看元素的位置
 *      void clear();//清除所有元素
 * */
public class YuiArrayList {
    //因为是提供给外界调用的，所以都是public，因为要创建对象才能使用其中的方法，所以我们这里不能用static，static是直接类名然后使用

    /**
     * 元素的数量
     * */
    private int size;
    /**
     * 所有的元素
     * */
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public YuiArrayList(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY)?DEFAULT_CAPACITY:capaticy;//可以设计成，当小于默认值，直接选择默认值
        elements = new int[capaticy];
    }

    public YuiArrayList(){
        this(DEFAULT_CAPACITY);
    }


    /**
     * 清除所有元素
     * */
    public void clear(){
        if(size < 100){

        }
        //设计一：因为销毁内存和重新申请内存是耗时间的，所以清掉比较耗费性能。因此，这边直接=0，没有销毁，新内容过来直接覆盖。
        size = 0;

//        //设计二：针对size的大小进行区别处理，变0或者清空
//        if(size < 100){
//            size = 0;
//        }else{
//            elements = null;
//        }
    }

    /**
     * 元素的数量
     * @return
     * */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     * */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     * */
    public boolean contains(int element){
        return indexOf(element) != ELEMENT_NOT_FOUND;//判断是否存在
    }

    /**
     * 添加元素到尾部
     * @param
     * */
    public void add(int element){
        ensureCapacity(size+1);
        elements[size++] = element;
    }


    /**
     * 保证要有capacity的容量
     * @param capacity
     * */
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity){
            return;
        }
        int newCapacity = oldCapacity + (oldCapacity>>1);//旧容量1.5倍，位运算
        int[] newElements = new int[newCapacity];
        for(int i = 0;i < size ;i++){
            newElements[i] = elements[i];
        }
        elements = newElements;//指向新的数组

        System.out.println(oldCapacity + "扩容为" + newCapacity );

    }

    /**
     * 获取index位置的元素
     * @param index
     * @return
     * */
    public int get(int index){
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 设置index位置的元素
     * @param index
     * @param element
     * @return 原来的元素
     * */
    public int set(int index,int element){
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }


    /**
     * 检查数组越界
     * */
    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void rangeCheck(int index){
        if(index<0 || index >= size){//判断是否小于0或者是否越界
            outOfBounds(index);
        }
    }

    private void rangeCheckForAdd(int index){
        if(index<0 || index > size) {//判断是否小于0或者是否比长度大1
            outOfBounds(index);
        }
    }

    /**
     * 在index位置插入一个元素
     * @param index
     * @param element
     * */
    public void add(int index, int element){
        rangeCheckForAdd(index);
        ensureCapacity(size+1);
        for (int i = size - 1; i >= index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;

    }

    /**
     * 删除index位置的元素
     * @param index
     * @return 返回删除的元素
     * */
    public int remove(int index){
        rangeCheck(index);
        int old = elements[index];
        for (int i = index + 1; i <= size-1; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return old;
    }

    /**
     * 查看元素的索引
     * @param element
     * @return
     * */
    public int indexOf(int element){
        for(int i = 0;i < size; i++){
            if(elements[i] == element){
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString(){//自定义toString
        StringBuilder string = new StringBuilder();
        //打印出size = 3,[99,88,77]这种形式
        string.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if(i != 0){
                string.append(",");
            }
            string.append(elements[i]);
//            if(i!=size-1){
//                string.append(",");
//            }
        }
        string.append("]");

        return string.toString();
    }

}
