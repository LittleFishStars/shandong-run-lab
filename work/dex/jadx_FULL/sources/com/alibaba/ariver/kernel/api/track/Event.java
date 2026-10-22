package com.alibaba.ariver.kernel.api.track;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class Event {
    private static final String b = "_key";
    private static final String c = "_tms";
    private static final String d = "_cst";
    private static final String e = "_rsn";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f24222a;
    protected long timestamp;
    protected String trackId;

    public static class Behavior extends Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24223a;
        private String b;

        public Behavior(String str) {
            super();
            setTrackId(str);
        }

        public String getParam() {
            return this.b;
        }

        public String getType() {
            return this.f24223a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return this.f24223a;
        }

        public Behavior setParam(String str) {
            this.b = str;
            return this;
        }

        public Behavior setType(String str) {
            this.f24223a = str;
            return this;
        }
    }

    public static class Cost extends Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f24224a;

        public Cost(long j) {
            super();
            this.f24224a = j;
        }

        public long getCost() {
            return this.f24224a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return Long.toString(this.f24224a);
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public Map<String, String> toMap() {
            Map<String, String> map = super.toMap();
            map.put(Event.d, Long.toString(this.f24224a));
            return map;
        }
    }

    public static class Error extends Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24225a;

        public Error(String str) {
            super();
            this.f24225a = str;
        }

        public String getReason() {
            return this.f24225a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return this.f24225a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public Map<String, String> toMap() {
            Map<String, String> map = super.toMap();
            map.put(Event.e, this.f24225a);
            return map;
        }
    }

    public static class Stub extends Event {
        public Stub() {
            super();
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return Long.toString(this.timestamp);
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public Map<String, String> toMap() {
            Map<String, String> map = super.toMap();
            map.put(Event.c, Long.toString(this.timestamp));
            return map;
        }

        public Stub(long j) {
            super();
            this.timestamp = j;
        }
    }

    public Map<String, String> getAttrData() {
        return this.f24222a;
    }

    public String getKey() {
        return this.trackId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public abstract String getValue();

    public Event putAttr(EventAttr eventAttr, int i) {
        return putAttr(eventAttr.value(), Integer.valueOf(i));
    }

    public void setAttrData(Map<String, String> map) {
        this.f24222a = map;
    }

    public Event setTrackId(String str) {
        this.trackId = str;
        return this;
    }

    public Map<String, String> toMap() {
        HashMap map = new HashMap();
        map.put("_key", this.trackId);
        map.put(c, Long.toString(this.timestamp));
        Map<String, String> map2 = this.f24222a;
        if (map2 != null && !map2.isEmpty()) {
            map.putAll(this.f24222a);
        }
        return map;
    }

    public String toString() {
        return StringUtils.map2String(toMap());
    }

    public Event putAttr(EventAttr eventAttr, long j) {
        return putAttr(eventAttr.value(), Long.valueOf(j));
    }

    public static class Fatal extends Event {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f24226a;
        private String b;
        private String c;

        public Fatal(String str, String str2, String str3) {
            super(str);
            setReason(str2);
            setFailCode(str3);
        }

        public String getFailCode() {
            return this.c;
        }

        public String getReason() {
            return this.f24226a;
        }

        public String getType() {
            return this.b;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return this.f24226a;
        }

        public void setFailCode(String str) {
            this.c = str;
        }

        public void setReason(String str) {
            this.f24226a = str;
            putAttr(EventAttr.Key_fatalReason, str);
        }

        public void setType(String str) {
            this.b = str;
            putAttr(EventAttr.Key_fatalType, str);
        }

        public Fatal(String str, String str2, String str3, String str4) {
            super(str);
            setReason(str2);
            setType(str3);
            setFailCode(str4);
        }
    }

    private Event() {
        this.timestamp = SystemClock.elapsedRealtime();
    }

    public Event putAttr(EventAttr eventAttr, String str) {
        return putAttr(eventAttr.value(), str);
    }

    public Event putAttr(String str, Object obj) {
        if (str == null || str.length() <= 0 || obj == null || str.charAt(0) == '_') {
            return this;
        }
        if (this.f24222a == null) {
            this.f24222a = new HashMap();
        }
        this.f24222a.put(str, obj.toString());
        return this;
    }

    private Event(String str) {
        this.timestamp = SystemClock.elapsedRealtime();
        this.trackId = str;
    }
}
