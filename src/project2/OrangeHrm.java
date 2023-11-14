package project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class OrangeHrm {

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/"; //storing base url
    static WebDriver driver; // intializing the driver

    public static void main(String[] args) { // main method
        Scanner scanner = new Scanner(System.in); // using scanner for choosing the browser
        System.out.println("Please enter the browser name "); //
        String browserName = scanner.nextLine();


        choosingBrowser(browserName); // calling the method
        checkLoginFunctionality(); // calling the method
        scanner.close(); // closing the browser
        
    }

    public static void choosingBrowser(String browserName) { // using this method for choosing the browser
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");

        }
    }

    public static void checkLoginFunctionality() { // method used for automating the URL
        driver.get(baseUrl); // entering the URL
        driver.manage().window().maximize(); // maximising the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // implicit timeout
        System.out.println("Title of the page is : " + driver.getTitle()); // getting title
        System.out.println("The current URL is : " + driver.getCurrentUrl()); // getting current URL
        System.out.println("Page source is " + driver.getPageSource()); // printing the pagesource
        driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
        System.out.println("Current Url is : " + driver.getCurrentUrl()); // printing out current URL
        driver.navigate().back(); // clicking on back button
        driver.navigate().refresh(); // refreshing the page
        driver.findElement(By.name("username")).sendKeys("Vishal"); // entering username
        driver.findElement(By.name("password")).sendKeys("Password"); // entering password
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.close(); // closing the browser
    }
}