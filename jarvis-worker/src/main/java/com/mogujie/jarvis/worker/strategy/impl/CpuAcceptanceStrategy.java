
package com.mogujie.jarvis.worker.strategy.impl;

import com.google.common.io.Files;
import com.mogujie.jarvis.core.domain.Pair;
import com.mogujie.jarvis.core.domain.TaskDetail;
import com.mogujie.jarvis.core.util.ConfigUtils;
import com.mogujie.jarvis.core.util.ThreadUtils;
import com.mogujie.jarvis.worker.WorkerConfigKeys;
import com.mogujie.jarvis.worker.strategy.AcceptanceResult;
import com.mogujie.jarvis.worker.strategy.AcceptanceStrategy;
import com.sun.jna.Platform;
import lombok.extern.slf4j.Slf4j;
import oshi.PlatformEnum;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

/**
 * @author wuya
 */
@Slf4j
public class CpuAcceptanceStrategy implements AcceptanceStrategy {

    private static final String DECIMAL_FORMAT = "#0.00";
    public static final double MAX_CPU_USAGE = ConfigUtils.getWorkerConfig().getDouble(WorkerConfigKeys.WORKER_CPU_USAGE_THRESHOLD, 0.85);

    @Override
    public AcceptanceResult accept(TaskDetail taskDetail) throws Exception {
        try {
            PlatformEnum currentPlatform = PlatformEnum.getValue(Platform.getOSType());
            switch (currentPlatform) {
                case LINUX: {
                    Pair<Long, Long> pair1 = getCpuStat();
                    ThreadUtils.sleep(1000);
                    Pair<Long, Long> pair2 = getCpuStat();
                    double currentCpuUsage = ((pair2.getFirst() - pair2.getSecond()) - (pair1.getFirst() - pair1.getSecond()))
                            / (double) (pair2.getFirst() - pair1.getFirst());
                    if (Double.isNaN(currentCpuUsage)) {
                        currentCpuUsage = 0;
                    }

                    if (currentCpuUsage > MAX_CPU_USAGE) {
                        return new AcceptanceResult(false,
                                "client当前CPU使用率" + new DecimalFormat(DECIMAL_FORMAT).format(currentCpuUsage) + ", 超过阈值" + MAX_CPU_USAGE);
                    }
                }
                break;
                case MACOS:
                case WINDOWS:
                default:
                    log.warn("暂时不支持当前操作系统");
            }
        } catch (Exception e) {
            return new AcceptanceResult(false, e.getMessage());
        }

        return new AcceptanceResult(true, "");
    }

    private Pair<Long, Long> getCpuStat() throws IOException {

        String line = Files.readFirstLine(new File("/proc/stat"), StandardCharsets.UTF_8);
        String[] tokens = line.split("\\s+");
        long idleCpuTime = Long.parseLong(tokens[4]);
        long totalCpuTime = 0;
        for (int i = 1, len = tokens.length; i < len; i++) {
            totalCpuTime += Long.parseLong(tokens[i]);
        }
        return new Pair<Long, Long>(totalCpuTime, idleCpuTime);
    }
}
