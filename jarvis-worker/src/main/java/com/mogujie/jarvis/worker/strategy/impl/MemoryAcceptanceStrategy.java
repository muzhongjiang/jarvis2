/*
 * 蘑菇街 Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 *
 * Author: wuya
 * Create Date: 2015年8月31日 下午7:57:49
 */

package com.mogujie.jarvis.worker.strategy.impl;

import com.google.common.base.CharMatcher;
import com.google.common.io.Files;
import com.mogujie.jarvis.core.domain.TaskDetail;
import com.mogujie.jarvis.core.util.ConfigUtils;
import com.mogujie.jarvis.worker.WorkerConfigKeys;
import com.mogujie.jarvis.worker.strategy.AcceptanceResult;
import com.mogujie.jarvis.worker.strategy.AcceptanceStrategy;
import com.sun.jna.Platform;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import oshi.PlatformEnum;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.List;

/**
 * @author wuya
 */
@Slf4j
public class MemoryAcceptanceStrategy implements AcceptanceStrategy {

    private static final String DECIMAL_FORMAT = "#0.00";
    private static final double MAX_MEMORY_USAGE = ConfigUtils.getWorkerConfig().getDouble(WorkerConfigKeys.WORKER_MEMORY_USAGE_THRESHOLD, 0.9);

    @Override
    public AcceptanceResult accept(TaskDetail taskDetail) throws Exception {
        try {
            PlatformEnum currentPlatform = PlatformEnum.getValue(Platform.getOSType());
            switch (currentPlatform) {
                case LINUX: {
                    List<String> lines = Files.readLines(new File("/proc/meminfo"), StandardCharsets.UTF_8);
                    long memTotal = Long.parseLong(CharMatcher.digit().retainFrom(lines.get(0)));
                    long memFree = Long.parseLong(CharMatcher.digit().retainFrom(lines.get(1)));
                    long buffers = Long.parseLong(CharMatcher.digit().retainFrom(lines.get(2)));
                    long cached = Long.parseLong(CharMatcher.digit().retainFrom(lines.get(3)));
                    double currentMemoryUsage = (memTotal - memFree - buffers - cached) / (double) memTotal;
                    if (Double.isNaN(currentMemoryUsage)) {
                        currentMemoryUsage = 0;
                    }
                    if (currentMemoryUsage > MAX_MEMORY_USAGE) {
                        return new AcceptanceResult(false,
                                "client当前内存使用率" + new DecimalFormat(DECIMAL_FORMAT).format(currentMemoryUsage) + ", 超过阈值" + MAX_MEMORY_USAGE);
                    }
                }
                break;
                case MACOS:
                case WINDOWS:
                default:
                    log.warn("暂时不支持当前操作系统");

            }

        } catch (IOException e) {
            log.error(ExceptionUtils.getFullStackTrace(e));
            return new AcceptanceResult(false, e.getMessage());
        }

        return new AcceptanceResult(true, "");
    }

}
