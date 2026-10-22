package com.aliyun.tea;

import com.aliyun.tea.utils.StringUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TeaException extends RuntimeException {
    private static final long serialVersionUID = 1;
    public Map<String, Object> accessDeniedDetail;
    public String code;
    public Map<String, Object> data;
    public String description;
    public String message;
    public Integer statusCode;

    public TeaException() {
    }

    public Map<String, Object> getAccessDeniedDetail() {
        return this.accessDeniedDetail;
    }

    public String getCode() {
        return this.code;
    }

    public Map<String, Object> getData() {
        return this.data;
    }

    public String getDescription() {
        return this.description;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return StringUtils.isEmpty((CharSequence) this.message) ? super.getMessage() : this.message;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setAccessDeniedDetail(Map<String, Object> map) {
        this.accessDeniedDetail = map;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(Map<String, Object> map) {
        this.data = map;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setStatusCode(Integer num) {
        this.statusCode = num;
    }

    public TeaException(String str, Throwable th) {
        super(str, th);
        setMessage(str);
    }

    public TeaException(Map<String, ?> map) {
        setCode(String.valueOf(map.get("code")));
        setMessage(String.valueOf(map.get("message")));
        setDescription(String.valueOf(map.get("description")));
        if (map.get("accessDeniedDetail") instanceof Map) {
            setAccessDeniedDetail((Map) map.get("accessDeniedDetail"));
        }
        Object obj = map.get("data");
        if (obj == null) {
            return;
        }
        if (obj instanceof Map) {
            Map<String, Object> map2 = (Map) obj;
            this.data = map2;
            if (map2.containsKey("statusCode")) {
                setStatusCode(Integer.valueOf(Integer.parseInt(String.valueOf(this.data.get("statusCode")))));
                return;
            }
            return;
        }
        HashMap map3 = new HashMap();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                map3.put(field.getName(), field.get(obj));
            } catch (Exception unused) {
            }
        }
        this.data = map3;
    }
}
