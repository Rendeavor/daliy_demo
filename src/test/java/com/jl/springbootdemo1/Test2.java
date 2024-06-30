package com.jl.springbootdemo1;

import java.awt.*;

public class Test2 {

    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();
        boolean flag = false;
        // 创建一个线程在后台运行

        while (true) {
            Point location = MouseInfo.getPointerInfo().getLocation();
            System.out.println(location);
            if (flag) {
                robot.mouseMove((int) location.getX(), (int) (location.getY() + 1));
                flag = false;
            } else {
                robot.mouseMove((int) location.getX(), (int) (location.getY() - 1));
                flag = true;
            }

            Thread.sleep(1000 * 60 * 5);
        }


    }
}
