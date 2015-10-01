package com.btanabe.fsdu.processors;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

/**
 * Created by brian on 9/18/15.
 */
public class ListenableFutureWorker {
    private ListeningExecutorService service;

    public ListenableFutureWorker(int maximumNumberOfThreads) {
        buildListeningExecutorService(maximumNumberOfThreads);
    }

    public void buildListeningExecutorService(int maximumNumberOfThreads) {
        service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(maximumNumberOfThreads));
    }
}
