package com.kc.dw.core.domain;

import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class AppendInfo {
    private long curAllTimes;
    private String curReqId;
    private String fromId;
    private volatile boolean hasExposed;
    private final LinkedHashMap<String, Long> baseEventTimes = new LinkedHashMap<>();
    private final ConcurrentHashMap<String, LinkedHashMap<String, Long>> eventTimesMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, AtomicInteger> eventCount = new ConcurrentHashMap<>();

    public LinkedHashMap<String, Long> getBaseEventTimes() {
        return this.baseEventTimes;
    }

    public long getCurAllTimes() {
        return this.curAllTimes;
    }

    public String getCurReqId() {
        return this.curReqId;
    }

    public LinkedHashMap<String, Long> getEventTimes(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.eventTimesMap.containsKey(str)) {
            return this.eventTimesMap.get(str);
        }
        LinkedHashMap<String, Long> linkedHashMap = new LinkedHashMap<>(this.baseEventTimes);
        this.eventTimesMap.put(str, linkedHashMap);
        return linkedHashMap;
    }

    public String getFromId() {
        return this.fromId;
    }

    public int incrementAndGetEventCount(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (this.eventCount.containsKey(str)) {
                return this.eventCount.get(str).incrementAndGet();
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            this.eventCount.put(str, atomicInteger);
            return atomicInteger.get();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isHasExposed() {
        return this.hasExposed;
    }

    public void setCurAllTimes(long j) {
        this.curAllTimes = j;
    }

    public void setCurReqId(String str) {
        this.curReqId = str;
    }

    public void setFromId(String str) {
        this.fromId = str;
    }

    public void setHasExposed(boolean z) {
        this.hasExposed = z;
    }
}
