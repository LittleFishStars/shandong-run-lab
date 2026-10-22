package com.kc.dw.core.router.log;

import com.kc.dw.core.router.log.EventBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class EventBean<T extends EventBean> implements Serializable {
    private static final long serialVersionUID = 1;
    public int ad_type;
    public int adn;
    public long all_times;
    public int app_id;
    public Map<String, Object> data;
    public String event;
    public long msec = System.currentTimeMillis();
    public int network;
    public String pid;
    public LinkedHashMap<String, Long> timeline;
    public String uuid;

    public T init(String str) {
        this.event = str;
        this.msec = System.currentTimeMillis();
        return this;
    }

    public T init(String str, long j, LinkedHashMap<String, Long> linkedHashMap) {
        this.event = str;
        this.msec = j;
        this.timeline = linkedHashMap;
        return this;
    }

    public T init(String str, LinkedHashMap<String, Long> linkedHashMap) {
        this.event = str;
        this.msec = System.currentTimeMillis();
        this.timeline = linkedHashMap;
        return this;
    }

    public void put2Data(String str, Object obj) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, obj);
    }
}
