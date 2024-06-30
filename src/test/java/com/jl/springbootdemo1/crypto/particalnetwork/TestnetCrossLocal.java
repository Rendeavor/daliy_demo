package com.jl.springbootdemo1.crypto.particalnetwork;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Random;

public class TestnetCrossLocal {


    public static Robot robot = null;
    public static final int SECONDS = 1000;


    // 键盘按键休眠时间
    public static int getKeySleep() {
        return getRandomInt(300, 500);
    }

    // 页面加载时等待时间
    public static int getPageLoadSleep() {
        return getRandomInt(5000, 6000);
    }

    // 鼠标移动休眠时间
    public static int getMoveSleep() {
        return getRandomInt(800, SECONDS);
    }

    // 点击Send 按钮后等待的时间
    public static int getSendLoadSleep() {
        return 10 * SECONDS;
    }

    // 等待confirm 确认框的时间
    public static int getConfirmSleep() {
        return getRandomInt(6 * SECONDS, 8 * SECONDS);
    }

    // OKX 钱包确认时间
    public static int getWalletConfirmSleep() {
        return getRandomInt(10 * SECONDS, 12 * SECONDS);
    }


    // 页面加载等待时间
    public static void pageLoadSleep() throws InterruptedException {
        Thread.sleep(getPageLoadSleep());
    }

    // 鼠标移动
    public static void moveMouse(int x, int y) throws InterruptedException {
        robot.mouseMove(x, y);
        Thread.sleep(getMoveSleep());
    }

    // 键盘按键
    public static void enterKey(int key) throws InterruptedException {
        robot.keyPress(key);
        Thread.sleep(getKeySleep()); // 键盘按键休眠时间
        robot.keyRelease(key);
    }

    // 左键点击
    public static void leftClick() throws InterruptedException {

        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(getKeySleep());
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }


    // 获取随机金额
    public static void getRandomAmount() throws InterruptedException {

        enterKey(KeyEvent.VK_0);
        enterKey(KeyEvent.VK_PERIOD);
        enterKey(KeyEvent.VK_0);
        enterKey(KeyEvent.VK_0);
        enterKey(KeyEvent.VK_0);

        int[] arr = new int[]{49, 50, 51, 52, 53, 54, 55, 56, 57};
        int index = getRandomInt(0, 8);
        System.out.println("【" + LocalDateTime.now() + "】>>> " + index);
        enterKey(arr[index]);
    }


    public static void getRandomCrossNetWork() throws InterruptedException {

        // 移动到网络选择
        moveMouse(2261, 938);
        leftClick();

//        int[] networkArr = new int[]{952,1008,1069,1126,1185,1244};
        int[] networkArr = new int[]{1008,1008,1126,1126,1244,1244};
//        int[] networkArr = new int[]{1008,1008,1069,1126,1244,1244};
        int randomIndex = getRandomInt(0, 5);
        moveMouse(2228, networkArr[randomIndex]);
        leftClick();
    }


    // 获取一个随机整数
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }


    public static void main(String[] args) throws AWTException, InterruptedException {

        robot = new Robot();

        // 获取鼠标当前位置
        Thread.sleep(5000);
        System.out.println("3秒后执行交互");
        Point point = MouseInfo.getPointerInfo().getLocation();
        System.out.println("当前鼠标位置：" + point);




//        for (int i = 0; i < 50; i++) {
//
//            long startTime = System.currentTimeMillis();
//            System.out.println("当前已交互：" + i);
//            crossOne();
//            Thread.sleep(3000,5000);
//            System.out.println("交互完成，耗时：" + ((System.currentTimeMillis() - startTime)/1000));
//        }

        for (int i = 0; i < 5; i++) {
            long startTime = System.currentTimeMillis();
            System.out.println("当前已交互：" + i);
            purchaseNFT();
            Thread.sleep(getRandomInt(2000, 3000));
            System.out.println("交互完成，耗时：" + ((System.currentTimeMillis() - startTime)/1000));
        }
    }

    /**
     * 交互一次
     * @throws InterruptedException
     */
    public static void crossOne() throws InterruptedException {


        enterKey(KeyEvent.VK_F5); // 刷新页面
        pageLoadSleep();

        // open wallet
        moveMouse(2500, 1330);
        leftClick();


        // send
        Thread.sleep(getSendLoadSleep());
        moveMouse(2177, 906);
        leftClick();

        // ETH
        moveMouse(2258, 735);
        leftClick();
        Thread.sleep(getRandomInt(500, 2000));

        // USDG
        leftClick();

        // 通讯录
        moveMouse(2486,843);
        Thread.sleep(SECONDS);
        leftClick();

        // 第一个钱包地址
        moveMouse(2251, 736);
        leftClick();
        Thread.sleep(SECONDS);

        // 选择交互网络
        getRandomCrossNetWork();

        // amount
        moveMouse(2220,1045);
        leftClick();
        getRandomAmount();

        // next
        moveMouse(2313,1228);
        leftClick();

        // send
        Thread.sleep(getSendLoadSleep());
        leftClick();


        // 人机交互
//        Thread.sleep(getConfirmSleep());
//        moveMouse(2214,1158);
//        leftClick();

        // 钱包确认
        Thread.sleep(getWalletConfirmSleep());
        moveMouse(2451,660);
        leftClick();

    }


    /**
     * 购买NFT
     * @throws InterruptedException
     */
    public static void purchaseNFT() throws InterruptedException {
        robot.mouseWheel(3000);

        // 1、purchase
        moveMouse(797, 612);
        leftClick();

        // 2、center purchase
        moveMouse(1100, 616);
        leftClick();

        // 3、radio
        moveMouse(1087, 715);
        leftClick();

        // 4、next
        moveMouse(1273, 985);
        leftClick();
        Thread.sleep(getWalletConfirmSleep());

        // 5、order purchase
        moveMouse(1270, 922);
        leftClick();

        // 6、 robot verify
//        Thread.sleep(getRandomInt(6000, 7000));
//        moveMouse(1160, 840);
//        leftClick();

        // 7、okx confirm
        Thread.sleep(getRandomInt(6000, 7000));
        moveMouse(2451, 655);
        leftClick();


        // 8、close
        Thread.sleep(getWalletConfirmSleep());
        moveMouse(1485, 452);
        leftClick();
        Thread.sleep(getRandomInt(2000, 3000));

        // 9、back
        moveMouse(776, 225);
        leftClick();
    }


    @Test
    public void fun1() {
        System.out.println((int) (Math.random() * 10));
    }
}
