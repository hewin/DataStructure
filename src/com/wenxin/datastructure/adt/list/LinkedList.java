package com.wenxin.datastructure.adt.list;

public class LinkedList {
    Object array = null;
    int current;
    int capacity;

    //默认空间大小是10
    public LinkedList(){
        this(10);
    }

    public LinkedList(int init){
        if(init< 0){
            throw new RuntimeException("数组大小错误"+init);
        }else{
            this.array = new Object[init];
            this.current = 0;
            capacity = init;
        }
    }

}
