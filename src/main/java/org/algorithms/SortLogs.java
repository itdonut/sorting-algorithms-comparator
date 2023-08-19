package org.algorithms;

import java.time.LocalDateTime;

/**
 * @author Serhiy Paranchuk
 * @project Algorithms
 */

public class SortLogs {
    private final int elemCount;
    private final int execTime;
    private final int maxElem;
    private final Algorithms algorithm;
    private final Types dataType;
    private final LocalDateTime localDateTime;

    public SortLogs(int elemCount, int execTime, int maxElem, Algorithms algorithm, Types dataType, LocalDateTime localDateTime) {
        this.elemCount = elemCount;
        this.execTime = execTime;
        this.maxElem = maxElem;
        this.algorithm = algorithm;
        this.dataType = dataType;
        this.localDateTime = localDateTime;
    }

    public int getElemCount() {
        return elemCount;
    }

    public int getExecTime() {
        return execTime;
    }

    public int getMaxElem() {
        return maxElem;
    }

    public Algorithms getAlgorithm() {
        return algorithm;
    }

    public Types getDataType() {
        return dataType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
