package com.alibaba.ariver.kernel.api.track;

import androidx.annotation.Keep;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Keep
public class JSAPICallRecord {
    private String mAction;
    private long mEnd;
    private String mTrackId;
    private long mStart = -1;
    private final Map<String, Object> mMap = new ConcurrentHashMap();

    public JSAPICallRecord(String str, String str2) {
        this.mTrackId = str;
        this.mAction = str2;
    }

    private <T> T getValue(String str, T t) {
        T t2 = (T) this.mMap.get(str);
        return t2 != null ? t2 : t;
    }

    public String getAction() {
        return this.mAction;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public Object getExtra(String str) {
        return this.mMap.get(str);
    }

    public int getExtraInt(String str) {
        return ((Integer) getValue(str, 0)).intValue();
    }

    public long getExtraLong(String str) {
        return ((Long) getValue(str, 0L)).longValue();
    }

    public String getExtraString(String str) {
        return (String) getValue(str, "");
    }

    public long getStart() {
        return this.mStart;
    }

    public String getTrackId() {
        return this.mTrackId;
    }

    public void putExtra(String str, Object obj) {
        this.mMap.put(str, obj);
    }

    public void setEnd(long j) {
        this.mEnd = j;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.mStart > 0) {
            sb.append("start");
            sb.append("=");
            sb.append(this.mStart);
            sb.append("|");
        }
        if (this.mEnd > this.mStart) {
            sb.append("end");
            sb.append("=");
            sb.append(this.mEnd);
            sb.append("|");
        }
        for (Map.Entry<String, Object> entry : this.mMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                sb.append(key);
                sb.append("=");
                sb.append(value);
                sb.append("|");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
