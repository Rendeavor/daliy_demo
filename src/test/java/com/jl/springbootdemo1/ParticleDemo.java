package com.jl.springbootdemo1;

import com.alibaba.fastjson2.util.DateUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class ParticleDemo {


    // 0x6618f0affad621982bd3f2bb500a2e2cc614e07e (第三个钱包地址)


    public static Robot robot = null;
    public static final int keySleep = 300;
    public static final int loadSleep = 10000;

    // 8
    public static void main(String[] args) throws AWTException, InterruptedException {

        robot = new Robot();

        // 获取鼠标当前位置
        Thread.sleep(5000);
        System.out.println("3秒后执行交互");
        Point point = MouseInfo.getPointerInfo().getLocation();
        System.out.println("当前鼠标位置：" + point);



        //  初始位置[x=1775,y=656]   57
        // 1 当前鼠标位置：java.awt.Point[x=1783,y=644]
        // 当前鼠标位置：java.awt.Point[x=1783,y=703] 59
        // 当前鼠标位置：java.awt.Point[x=1776,y=761] 58
        // 当前鼠标位置：java.awt.Point[x=1776,y=811] 50




        // 当前鼠标位置：java.awt.Point[x=1774,y=662]
        // 当前鼠标位置：java.awt.Point[x=1774,y=721]
        // 当前鼠标位置：java.awt.Point[x=1769,y=778]
        // 当前鼠标位置：java.awt.Point[x=1742,y=836]03
        //

        for (int i = 0; i < 50; i++) {

            System.out.println("当前已交互：" + i);
            once();
//            Thread.sleep(10000,20000);
            Thread.sleep(3000,5000);
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.println("当前已交互：" + i);
//            purchaseNFT();
//            Thread.sleep(getRandomInt(2000, 3000));
//        }
    }

    public static void once() throws InterruptedException {

        robot.keyPress(KeyEvent.VK_F5);
        robot.keyRelease(KeyEvent.VK_F5);
        Thread.sleep(getRandomInt(5000, 6000));
        robot.mouseWheel(10);

        // open wallet
        robot.mouseMove(1193, 885);
        Thread.sleep(getRandomInt(500, 2000));
        leftClick();
        Thread.sleep(getRandomInt(4000, 6000));
        // send
        robot.mouseMove(1667, 618);
        leftClick();
        Thread.sleep(3000);
        // ETH
        robot.mouseMove(1720, 451);
        leftClick();
        Thread.sleep(getRandomInt(500, 2000));

        // USDG
        leftClick();

        // 通讯录
        robot.mouseMove(1973, 554);
        Thread.sleep(getRandomInt(500, 2000));
        leftClick();
        // 第一个钱包地址
        robot.mouseMove(1766, 448);
        leftClick();
        Thread.sleep(getRandomInt(500, 2000));

        // 选择交互网络
//        robot.mouseMove(1775,656);
//        leftClick();
//
//        robot.mouseMove(1783,642); // 移到最上面
//        int count = 644;
//        int randomInt = getRandomInt(1, 6);
//        count += (randomInt * 57);
//        robot.mouseMove(1783, count);
//        leftClick();

        // amount
        robot.mouseMove(1680, 758);
        leftClick();
        clickKey();

        // next
        robot.mouseMove(1790, 940);
        leftClick();
        Thread.sleep(getRandomInt(9000, 12000));

        // send
        leftClick();


        // 人机交互
//        Thread.sleep(getRandomInt(9000, 12000));
//        robot.mouseMove(1706, 872);
//        leftClick();

        // 钱包确认
        robot.mouseMove(1934, 662);
        Thread.sleep(getRandomInt(6000, 8000));
        leftClick();

        // X 按钮
//        robot.mouseMove(1983, 762);
//        Thread.sleep(getRandomInt(5000, 6000));
//        leftClick();
    }


    public static void leftClick() throws InterruptedException {
        Thread.sleep(getRandomInt(500, 2000));
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(getRandomInt(500, 2000));
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }


    public static void clickKey() throws InterruptedException {
        // 0x31   0x39
        // 49 57
        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);
        Thread.sleep(getRandomInt(500, 2000));

        robot.keyPress(KeyEvent.VK_PERIOD);
        robot.keyRelease(KeyEvent.VK_PERIOD);
        Thread.sleep(getRandomInt(500, 2000));

        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);
        Thread.sleep(getRandomInt(500, 2000));

        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);
        Thread.sleep(getRandomInt(500, 2000));

        robot.keyPress(KeyEvent.VK_0);
        robot.keyRelease(KeyEvent.VK_0);

        int[] arr = new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57};
        int index = getRandomInt(0, 8);
        System.out.println("【" + LocalDateTime.now() + "】>>> " + index);
        robot.keyPress(arr[index]);
        robot.keyRelease(arr[index]);
    }


    // 获取一个随机整数
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }


    public static void purchaseNFT() throws InterruptedException {
        robot.mouseWheel(3000);
        // 1、purchase
        robot.mouseMove(535, 325);
        leftClick();

        // 2、center purchase
        robot.mouseMove(856, 616);
        leftClick();

        // 3、radio
        robot.mouseMove(830, 571);
        leftClick();

        // 4、next
        robot.mouseMove(1016, 838);
        leftClick();
        Thread.sleep(getRandomInt(6000, 7000));

        // 5、order purchase
        robot.mouseMove(1011, 774);
        leftClick();

        // 6、 robot verify
        Thread.sleep(getRandomInt(6000, 7000));
        robot.mouseMove(905, 698);
        leftClick();

        // 7、okx confirm
        Thread.sleep(getRandomInt(6000, 7000));
        robot.mouseMove(1950, 660);
        leftClick();
        Thread.sleep(getRandomInt(6000, 7000));

        // 8、close
        robot.mouseMove(1226, 306);
        leftClick();
        Thread.sleep(getRandomInt(2000, 3000));

        // 9、back
        robot.mouseMove(529, 223);
        leftClick();
    }


    @Test
    public void fun1() {
        System.out.println((int) (Math.random() * 10));
    }

}
