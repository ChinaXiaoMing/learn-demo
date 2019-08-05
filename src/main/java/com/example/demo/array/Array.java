package com.example.demo.array;

/**
 * @author xiaoming
 */
public class Array {

    private String[] strArray;
    private int length = 0;

    public Array(int length) {
        strArray = new String[length];
    }

    /**
     * 检测数组是否包含某个元素，存在则返回元素首次出现的元素下标，不存在则返回-1
     * @param elem 数组元素
     * @return
     */
    public int containers(String elem) {
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (strArray[i].equals(elem)) {
                index = i;
                break;
            }
        }
        return index;
    }

    //插入元素
    public void insert(String elem) {
        strArray[length] = elem;
        length++;
    }

    //删除指定元素
    public boolean delete(String elem) {
        int index = -1;
        if ((index = containers(elem)) != -1) {
            for (int i = index + 1; i < length; i++) {
                strArray[i - 1] = strArray[i];
            }
            length--;
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        for (int i = 0; i < length; i++) {
            System.out.print(strArray[i] + "\t");
        }
    }

}
