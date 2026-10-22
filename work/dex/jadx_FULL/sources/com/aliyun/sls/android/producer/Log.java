package com.aliyun.sls.android.producer;

import android.text.TextUtils;
import com.aliyun.sls.android.producer.utils.TimeUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Log {
    private final Map<String, String> content = new LinkedHashMap();
    private final Object lock = new Object();
    private long logTime = TimeUtils.getTimeInMillis();

    private String numberToString(Number value) {
        try {
            return JSONObject.numberToString(value);
        } catch (JSONException unused) {
            return "";
        }
    }

    public Map<String, String> getContent() {
        Map<String, String> map;
        synchronized (this.lock) {
            map = this.content;
        }
        return map;
    }

    public long getLogTime() {
        return this.logTime;
    }

    public void putContent(String key, String value) {
        synchronized (this.lock) {
            this.content.put(key, value);
        }
    }

    public void putContents(Map<String, String> contents) {
        if (contents == null || contents.isEmpty()) {
            return;
        }
        synchronized (this.lock) {
            this.content.putAll(new LinkedHashMap(contents));
        }
    }

    @Deprecated
    public void setLogTime(long logTime) {
        this.logTime = logTime;
    }

    public void putContent(String key, int value) {
        synchronized (this.lock) {
            this.content.put(key, String.valueOf(value));
        }
    }

    public void putContent(String key, long value) {
        synchronized (this.lock) {
            this.content.put(key, String.valueOf(value));
        }
    }

    public void putContent(String key, boolean value) {
        synchronized (this.lock) {
            this.content.put(key, String.valueOf(value));
        }
    }

    public void putContent(String key, float value) {
        synchronized (this.lock) {
            this.content.put(key, String.valueOf(value));
        }
    }

    public void putContent(String key, double value) {
        synchronized (this.lock) {
            this.content.put(key, String.valueOf(value));
        }
    }

    public void putContent(String key, JSONObject object) {
        synchronized (this.lock) {
            try {
                if (object != null) {
                    this.content.put(key, object.toString());
                } else {
                    this.content.put(key, "null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void putContent(String key, JSONArray array) {
        synchronized (this.lock) {
            try {
                if (array != null) {
                    this.content.put(key, array.toString());
                } else {
                    this.content.put(key, "null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void putContent(JSONObject jsonObject) {
        JSONObject jSONObject;
        if (jsonObject == null || jsonObject.length() == 0) {
            return;
        }
        try {
            jSONObject = new JSONObject(jsonObject.toString());
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.isEmpty(next)) {
                Object objOpt = jSONObject.opt(next);
                if (objOpt != null && JSONObject.NULL != objOpt && !(objOpt instanceof Boolean)) {
                    if (objOpt instanceof JSONObject) {
                        linkedHashMap.put(next, ((JSONObject) objOpt).toString());
                    } else if (objOpt instanceof JSONArray) {
                        linkedHashMap.put(next, ((JSONArray) objOpt).toString());
                    } else if (objOpt instanceof Number) {
                        linkedHashMap.put(next, numberToString((Number) objOpt));
                    } else {
                        linkedHashMap.put(next, objOpt.toString());
                    }
                } else {
                    linkedHashMap.put(next, String.valueOf(objOpt));
                }
            }
        }
        putContents(linkedHashMap);
    }
}
