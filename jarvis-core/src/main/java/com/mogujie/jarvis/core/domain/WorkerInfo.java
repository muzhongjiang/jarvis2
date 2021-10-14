/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: wuya
 * Create Date: 2015年6月14日 下午8:13:35
 */
package com.mogujie.jarvis.core.domain;

import com.mogujie.jarvis.core.JarvisConstants;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class WorkerInfo {

    private String ip;
    private int port;
    private String akkaPath;

    public WorkerInfo(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getAkkaRootPath() {
        if (akkaPath == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("akka.tcp://");
            sb.append(JarvisConstants.WORKER_AKKA_SYSTEM_NAME);
            sb.append("@");
            sb.append(ip);
            sb.append(":");
            sb.append(port);
            akkaPath = sb.toString();
        }

        return akkaPath;
    }

    public String getWorkerPath() {
        return getAkkaRootPath() + JarvisConstants.WORKER_AKKA_USER_PATH;
    }



}
