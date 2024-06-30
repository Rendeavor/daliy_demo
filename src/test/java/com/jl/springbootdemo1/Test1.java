package com.jl.springbootdemo1;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Test1 {



    @Test
    public void fun1(){

        File root = new File("F://");
        File[] files = root.listFiles();

        showFile(root);
    }


    public void showFile(File file){

        String fileName = file.getName();
        if(!file.isDirectory() &&
//                (fileName.endsWith(".mp3") || fileName.endsWith(".mp4"))){
                (fileName.endsWith(".avi") || fileName.endsWith("AVI"))){
            System.out.println(file.getAbsolutePath());

        }else{

            // F:\DCIM\1
            File[] root = file.listFiles();
            if(root != null && root.length > 0){

                for (File childFile : root) {
                    showFile(childFile);
                }
            }

        }


    }



    @Test
    public void fun2() throws InterruptedException {


        String targetUrl = "https://pioneer.particle.network/zh-CN/point";

        File cacheFile = new File("E:\\temp\\chromeDriver\\2\\cache");
        // 配置环境变量
        System.setProperty("webdriver.chrome.driver", "E:\\temp\\chromeDriver\\2\\chromedriver.exe");
        // 允许所有请求
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--disable-gpu"); // 谷歌文档提到需要加上这个属性来规避bug
//        options.addArguments("--disable-software-rasterizer"); //禁用3D软件光栅化器
//        options.addArguments("--no-sandbox");// 为了让linux root用户也能执行
        // 优化参数
//        options.addArguments("--disable-dev-shm-usage"); //解决在某些VM环境中，/dev/shm分区太小，导致Chrome失败或崩溃
//        options.addArguments("--user-data-dir=" + cacheFile.getAbsolutePath()); //解决打开页面出现data;空白页面情况,因为没有缓存目录
//        options.addArguments("--disk-cache-dir=" + cacheFile.getAbsolutePath()); //指定Cache路径
//        options.addArguments("--incognito") ; //无痕模式
//        options.addArguments("--disable-plugins"); //禁用插件,加快速度
//        options.addArguments("--disable-extensions"); //禁用扩展
//        options.addArguments("--disable-popup-blocking"); //关闭弹窗拦截
//        options.addArguments("--ignore-certificate-errors"); //  禁现窗口最大化
//        options.addArguments("--allow-running-insecure-content");  //关闭https提示 32位
//        options.addArguments("--disable-infobars");  //禁用浏览器正在被自动化程序控制的提示  ,但是高版本不生效



        WebDriver driver = new ChromeDriver(options);
        driver.get(targetUrl);


        Thread.sleep(5000);
        // data-testid="connect-wallet-button"

        //TODO 查找元素之前，先确定元素有没有加载
//        WebElement connectWalletBtn = driver.findElement(By.xpath("//button[@data-testid='connect-wallet-button']"));
//        connectWalletBtn.click();
//
//        WebElement toWallet = driver.findElement(By.xpath("//button[@class='wallet-option-button'][1]"));
//        toWallet.click();


//        driver.quit();

    }


}
