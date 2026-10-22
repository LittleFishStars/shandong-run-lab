package com.baidu.platform.comapi.util;

import com.zj.adlib.bv9;
import com.zj.adlib.u15;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class JsonBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private StringBuilder f26792a = new StringBuilder();
    private boolean b = false;

    private void a() {
        if (this.b) {
            this.f26792a.append(",");
        }
    }

    private void b() {
        this.b = true;
    }

    private void c() {
        this.b = false;
    }

    public JsonBuilder arrayValue() {
        a();
        this.f26792a.append("[");
        c();
        return this;
    }

    public JsonBuilder endArrayValue() {
        this.f26792a.append("]");
        b();
        return this;
    }

    public JsonBuilder endObject() {
        this.f26792a.append("}");
        b();
        return this;
    }

    public String getJson() {
        return this.f26792a.toString();
    }

    public JsonBuilder key(String str) {
        a();
        this.f26792a.append(JSONObject.quote(str));
        this.f26792a.append(u15.f19942b);
        c();
        return this;
    }

    public JsonBuilder object() {
        a();
        this.f26792a.append(bv9.b);
        c();
        return this;
    }

    public JsonBuilder objectValue(String str) {
        a();
        this.f26792a.append(str);
        b();
        return this;
    }

    public JsonBuilder putObjectValue(String str, String str2) {
        if (str2 != null) {
            key(str).objectValue(str2);
        }
        return this;
    }

    public JsonBuilder putStringValue(String str, String str2) {
        if (str2 != null) {
            key(str).value(str2);
        }
        return this;
    }

    public void reset() {
        this.f26792a.setLength(0);
        this.b = false;
    }

    public String toString() {
        return getJson();
    }

    public JsonBuilder value(boolean z) {
        a();
        this.f26792a.append(z);
        b();
        return this;
    }

    public JsonBuilder valueDirect(String str) {
        a();
        this.f26792a.append(str);
        b();
        return this;
    }

    public JsonBuilder value(int i) {
        a();
        this.f26792a.append(i);
        b();
        return this;
    }

    public JsonBuilder value(long j) {
        a();
        this.f26792a.append(j);
        b();
        return this;
    }

    public JsonBuilder value(double d) {
        a();
        this.f26792a.append(String.valueOf(d));
        b();
        return this;
    }

    public JsonBuilder value(String str) {
        a();
        this.f26792a.append(JSONObject.quote(str));
        b();
        return this;
    }

    public JsonBuilder value(Object obj) {
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if (obj instanceof Byte) {
                return value((int) number.byteValue());
            }
            if (obj instanceof Short) {
                return value((int) number.shortValue());
            }
            if (obj instanceof Integer) {
                return value(number.intValue());
            }
            if (obj instanceof Long) {
                return value(number.longValue());
            }
            if (obj instanceof Float) {
                return value(number.floatValue());
            }
            if (obj instanceof Double) {
                return value(number.doubleValue());
            }
        }
        return value(obj.toString());
    }
}
