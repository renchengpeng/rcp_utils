package com.bee.sys.utils;

import java.io.Serializable;
import java.util.concurrent.Callable;

import com.bee.framework.ui.utils.IdWorker;


public class WorkIdThread implements Callable<IdWorker>, Serializable{

    private  long workId;
    private long datacenterId;
    private static final long serialVersionUID = 1L;


    public WorkIdThread(long workId, long datacenterId) {
        super();
        this.workId = workId;
        this.datacenterId = datacenterId;
    }



    @Override
    public IdWorker call() throws Exception {
        System.out.println("当前线程=========="+Thread.currentThread().getId()+Thread.currentThread().getName());
        return new IdWorker(this.workId,this.datacenterId);
    }

}

	