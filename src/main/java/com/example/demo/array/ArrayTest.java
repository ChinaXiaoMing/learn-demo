package com.example.demo.array;

public class ArrayTest {

    /**
     * 获取数组元素中最大值
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param doubles
     * @return 元素最大值
     */
    public static double getMax(double[] doubles) {
        double max = 0;
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] > max) {
                max = doubles[i];
            }
        }
        return max;
    }

    /**
     * 求数组元素平均值
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param doubles
     * @return 元素平均值
     */
    public static double getAverage(double[] doubles) {
        double sum = 0;
        for (int i = 0; i < doubles.length; i++) {
            sum += doubles[i];
        }
        return sum / doubles.length;
    }

    /**
     * 复制数组
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param doubles
     * @return 复制数组
     */
    public static double[] copy(double[] doubles) {
        double[] doubles1 = new double[doubles.length];
        for (int i = 0; i < doubles.length; i++) {
            doubles1[i] = doubles[i];
        }
        return doubles1;
    }

    /**
     * 反转数组
     * 时间复杂度O(n) 空间复杂度O(n)
     * @param doubles
     */
    public static void reserve(double[] doubles) {
        double temp;
        for (int i = 0; i < doubles.length / 2; i++) {
            temp = doubles[i];
            doubles[i] = doubles[doubles.length - 1 - i];
            doubles[doubles.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        double[] doubles = {1.1, 2.2, 3.3, 8.7, 7.4};
        double max = getMax(doubles);
        System.out.println("max: " + max);
        double average = getAverage(doubles);
        System.out.println("average: " + average);
        reserve(doubles);
        for (double d : doubles) {
            System.out.print(d + "\t");
        }
    }

}
