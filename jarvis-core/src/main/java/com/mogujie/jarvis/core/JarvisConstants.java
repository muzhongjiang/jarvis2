package com.mogujie.jarvis.core;

/**
 * @author wuya
 *
 */
public interface JarvisConstants {

    public static final String WORKER_AKKA_PATH = "worker";
    public static final String SERVER_AKKA_PATH = "server";
    public static final String SERVER_JOB_STATUS_AKKA_PATH = "jobstatus";
    public static final String SERVER_HEARTBEAT_AKKA_PATH = "heartbeat";
    public static final String LOGSERVER_AKKA_PATH = "logserver";
    public static final String REST_SERVER_AKKA_PATH = "restful";

    public static final String EMPTY_STRING = "";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
}