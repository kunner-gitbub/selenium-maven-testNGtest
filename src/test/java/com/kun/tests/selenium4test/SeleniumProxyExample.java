package com.kun.tests.selenium4test;

/**
 * ClassName: SeleniumProxyExample
 * Package: com.kun.tests.selenium4test
 * Description:
 *
 * @Author KunJiang
 * @Create 11/26/24 9:55 PM
 * @Version 1.0
 */

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumProxyExample {
    public static void main(String[] args) {
        // 设置代理地址
        String proxyAddress = "123.45.67.89:8080"; // 替换为实际代理地址

        // 配置代理
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(proxyAddress);
        proxy.setSslProxy(proxyAddress);

        // 添加代理到 ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);
        options.addArguments("--ignore-certificate-errors"); // 忽略证书错误
        options.addArguments("--disable-gpu"); // 禁用 GPU 渲染

        // 使用 WebDriverManager 自动下载和管理 ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);

        try {
            // 打开测试网站
            driver.get("https://www.whatismyip.com/");
            System.out.println("Page Title: " + driver.getTitle());
        } finally {
            // 关闭浏览器
            driver.quit();
        }
    }
}

