package com.vishall.framework.retry;

import com.vishall.framework.listeners.TestListener;
import com.vishall.framework.utils.LoggersUtil;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private static final Logger log = LoggersUtil.getLogger(RetryAnalyzer.class);

    private int retryCount = 0;
    //max retry should always be 1, so it's final
    private static final int max_Retry = 1;

    @Override
    public boolean retry(ITestResult result) {
        if(retryCount>=max_Retry){
            return false;
        }

        //fetching the error
        Throwable error = result.getThrowable();

        if(error==null){
            return false;
        }
        //if the error is present in isRetryable method, then increase the retr count by 1
        //and return true, so that retry can be done.
        if(isRetryable(error)){
            retryCount++;
            log.info("Retrying test: "+result.getMethod().getMethodName());
            return true;
        }
        return false;

    }
    private boolean isRetryable(Throwable error){
        return error instanceof org.openqa.selenium.TimeoutException
                || error instanceof org.openqa.selenium.StaleElementReferenceException;
    }
}
