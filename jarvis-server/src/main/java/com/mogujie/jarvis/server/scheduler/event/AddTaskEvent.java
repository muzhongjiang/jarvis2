/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: guangming
 * Create Date: 2015年11月5日 下午7:44:51
 */

package com.mogujie.jarvis.server.scheduler.event;

import java.util.Map;
import java.util.Set;

/**
 * @author guangming
 *
 */
public class AddTaskEvent extends DAGJobEvent {
    private Map<Long, Set<Long>> dependTaskIdMap;
    private long scheduleTime;

    /**
     * @param jobId
     * @param dependTaskIdMap
     */
    public AddTaskEvent(long jobId, Map<Long, Set<Long>> dependTaskIdMap, long scheduleTime) {
        super(jobId);
        this.dependTaskIdMap = dependTaskIdMap;
        this.scheduleTime = scheduleTime;
    }

    public AddTaskEvent(long jobId, Map<Long, Set<Long>> dependTaskIdMap) {
        super(jobId);
        this.dependTaskIdMap = dependTaskIdMap;
        this.scheduleTime = 0;
    }

    public Map<Long, Set<Long>> getDependTaskIdMap() {
        return dependTaskIdMap;
    }

    public void setDependTaskIdMap(Map<Long, Set<Long>> dependTaskIdMap) {
        this.dependTaskIdMap = dependTaskIdMap;
    }

    public long getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(long scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

}