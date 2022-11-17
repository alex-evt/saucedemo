package org.tms.tests.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.tms.driver.DriverSingleton;

import java.util.concurrent.TimeUnit;

public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult){
        System.out.println(String.format(
                "======================================== STARTING TEST %s ========================================",
                iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult){
        System.out.println(String.format(
                "======================================== FINISHED TEST %s Duration: %ss ========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }
    @Override
    public void onTestFailure(ITestResult iTestResult){
        System.out.println(String.format(
                "======================================== FAILED TEST %s Duration: %ss ========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(String.format(
                "======================================== SKIPPING TEST %s ========================================",
                iTestResult.getName()));
        takeScreenshot();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    public long getExecutionTime(ITestResult iTestResult){
        return TimeUnit.MILLISECONDS
                .toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }
    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenshot(){
        return ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
