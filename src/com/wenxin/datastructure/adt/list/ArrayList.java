package com.wenxin.datastructure.adt.list;

/*
 * @function: 顺序表方式实现的list，包括增删改查功能
 * @Data: 20171031
 * @Author: jianjunchen
 * @email: 1130128509@qq.com
 *
 */

public class ArrayList<T> {
    Object[] array = null;
    int current;
    int capacity;

    //默认空间大小是10
    public ArrayList(){
        this(10);
    }

    public ArrayList(int init){
        if(init< 0){
            throw new RuntimeException("数组大小错误"+init);
        }else{
            this.array = new Object[init];
            this.current = 0;
            capacity = init;
        }
    }

    //增：添加元素
    public boolean add(T element){
        boolean success = true;
        ensureCapacity(current);
        this.array[current] = element;
        current++;
        return success;
    }


    //删：根据id删除元素
    public boolean removeById(int index){
        boolean removeSuccess;
        if(index > 0 && index < current){
            Object[] newArray = new Object[array.length-1];
            boolean deleteItemFoud = false;
            for (int i = 0; i < array.length; i++){
                if(i != index){
                    if(deleteItemFoud){
                        newArray[i-1] = array[i];
                    }else{
                        newArray[i] = array[i];
                    }
                }else{
                    deleteItemFoud = true;
                }
            }
            array = newArray;
            removeSuccess = true;
        }else{
            removeSuccess = false;
        }
        return  removeSuccess;
    }

    //改：修改元素
    public boolean changeByIndex(int index, Object object){
        if(index > 0 && index < current){
            array[index] = object;
            return true;
        }else {
            throw new ArrayIndexOutOfBoundsException("index:"+index+" out of bounds!");
        }
    }

    //查：根据index获取线性表存储元素
    public Object getByInedx(int index) {
        if(index > 0 && index < current){
            return array[index];
        }else {
            throw new ArrayIndexOutOfBoundsException("index:"+index+" out of bounds!");
        }
    }


    //删除最后一个元素
    public boolean removeLast(){
        boolean removeSuccess;
        if(current > 0 && capacity > 0 && array[0] != null){
            array[current-1] = null;
            current--;
            removeSuccess = true;
        }else{
            removeSuccess = false;
        }
        return  removeSuccess;
    }

    //判断array是否还有空间，如果没有，进行扩容
    private void ensureCapacity(int cur){
        if(cur == capacity){
            this.capacity = this.capacity + 10;
            Object[] newData = new Object[capacity];
            for (int i = 0; i < cur; i++){
                newData[i] = array[i];
            }

            this.array = newData;
        }
    }

}
