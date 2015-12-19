package com.btanabe.fsdu.processors;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by Brian on 12/12/15.
 */
public class BoundedThreadPoolExecutor {
    public static BoundedThreadPoolExecutor thisInstance;

    private static ListeningExecutorService threadPool;

    public BoundedThreadPoolExecutor(int maxThreadPoolSize) {
        threadPool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(maxThreadPoolSize));
    }

    public static void initialize(int maxThreadPoolSize) {
        thisInstance = new BoundedThreadPoolExecutor(maxThreadPoolSize);
    }

    public static BoundedThreadPoolExecutor getInstance() {
        if (thisInstance == null) {
            thisInstance = new BoundedThreadPoolExecutor(300);
        }

        return thisInstance;
    }

    public static <OutputClazz> ListenableFuture<OutputClazz> queueAndExecuteTask(Callable<OutputClazz> task) throws ExecutionException, InterruptedException {
        ListenableFuture<OutputClazz> future = threadPool.submit(task);
        future.get();
        return future;
    }
}
