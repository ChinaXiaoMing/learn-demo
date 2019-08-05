package com.example.demo.algorithms.part1;

import javax.swing.*;
import java.awt.*;

public class Demo {

    /**
     * 欧几里得算法：返回两个非负整数p和q的最大公约数（递归实现）
     * @param p
     * @param q
     * @return 最大公约数
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    /**
     * 获取整数绝对值
     * @param x
     * @return
     */
    public static int abs(int x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }

    /**
     * 判断一个数是否为素数
     * @param x
     * @return
     */
    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 求平方根（牛顿迭代法）
     * 时间复杂度O(n)
     * @param x
     * @return
     */
    public static double sqrt(double x) {
        if (x < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double sqrt = x;
        while (Math.abs(sqrt - x / sqrt) > err * sqrt) {
            sqrt = (x / sqrt + sqrt) / 2.0;
        }
        return sqrt;
    }

    /**
     * 计算直角三角形斜边
     * @param a
     * @param b
     * @return
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    public static void main(String[] args) {
//        int x = gcd(6, 9);
//        System.out.println(x);
//        int abs = abs(-3);
//        System.out.println("abs: " + abs);
//        boolean prime = isPrime(15);
//        System.out.println("isPrime: " + prime);
//        double sqrt = sqrt(9);
//        System.out.println("sqrt: " + sqrt);
//        double c = hypotenuse(3.0, 4.0);
//        System.out.println("c: " + c);
        JFrame jFrame = new JFrame("jframe");
        jFrame.setBounds(350, 200, 600, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("hello world");
        JButton jButton = new JButton("登录");
        JPanel jPanel = new JPanel();
        jPanel.add(jButton);
        jFrame.add(jPanel);
        jFrame.setVisible(true);

    }

}
