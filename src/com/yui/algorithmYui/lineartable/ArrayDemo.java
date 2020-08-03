package com.yui.algorithmYui.lineartable;
/**
 * 数组：
 *      数组是一种顺序存储的线性表，所有元素的内存地址都是连续的。
 *
 *      数组的缺点：在很多变成语言中，数组都无法动态修改容量
 *
 * 堆栈区别：
 * java中堆和栈的区别自然是面试中的常见问题，下面几点就是其具体的区别
 * 各司其职
 * 最主要的区别就是栈内存用来存储局部变量和方法调用。
 * 而堆内存用来存储Java中的对象。无论是成员变量，局部变量，还是类变量，它们指向的对象都存储在堆内存中。
 * 独有还是共享
 * 栈内存归属于单个线程，每个线程都会有一个栈内存，其存储的变量只能在其所属线程中可见，即栈内存可以理解成线程的私有内存。
 * 而堆内存中的对象对所有线程可见。堆内存中的对象可以被所有线程访问。
 * */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] array = new int[]{11,22,33};
//        array是局部变量，放在栈空间

        YuiArrayList list = new YuiArrayList();
        list.get(-10);
    }
}
