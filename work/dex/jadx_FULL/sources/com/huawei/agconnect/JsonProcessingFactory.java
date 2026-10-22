package com.huawei.agconnect;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class JsonProcessingFactory {
    private static final Map<String, JsonProcessor> PROCESSOR_MAP = new HashMap();

    public interface JsonProcessor {
        String processOption(AGConnectOptions aGConnectOptions);
    }

    public static Map<String, JsonProcessor> getProcessors() {
        return PROCESSOR_MAP;
    }

    public static void registerProcessor(String str, JsonProcessor jsonProcessor) {
        PROCESSOR_MAP.put(str, jsonProcessor);
    }
}
