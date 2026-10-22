package com.aliyun.vod.qupaiokhttp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class HttpTaskHandler {
    private static HttpTaskHandler httpTaskHandler;
    private static Map<String, List<OkHttpTask>> httpTaskMap;

    private HttpTaskHandler() {
        httpTaskMap = new ConcurrentHashMap();
    }

    public static HttpTaskHandler getInstance() {
        if (httpTaskHandler == null) {
            httpTaskHandler = new HttpTaskHandler();
        }
        return httpTaskHandler;
    }

    public synchronized void addTask(String str, OkHttpTask okHttpTask) {
        if (httpTaskMap.containsKey(str)) {
            List<OkHttpTask> list = httpTaskMap.get(str);
            list.add(okHttpTask);
            httpTaskMap.put(str, list);
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(okHttpTask);
            httpTaskMap.put(str, arrayList);
        }
    }

    public boolean contains(String str) {
        return httpTaskMap.containsKey(str);
    }

    public synchronized void removeTask(String str) {
        if (httpTaskMap.containsKey(str)) {
            httpTaskMap.remove(str);
        }
    }
}
