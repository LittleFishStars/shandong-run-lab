package com.kc.bw.okhttp.cache;

import android.content.ContentValues;
import android.database.Cursor;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.model.HttpHeaders;
import com.kc.bw.okhttp.utils.IOUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CacheEntity<T> implements Serializable {
    public static final long CACHE_NEVER_EXPIRE = -1;
    public static final long serialVersionUID = -4337711009801627866L;
    public T data;
    public boolean isExpire;
    public String key;
    public long localExpire;
    public HttpHeaders responseHeaders;
    public static final String KEY = dexg.dexa("lfz");
    public static final String LOCAL_EXPIRE = dexg.dexa("mpdbmFyqjsf");
    public static final String HEAD = dexg.dexa("ifbe");
    public static final String DATA = dexg.dexa("ebub");

    public static <T> ContentValues getContentValues(CacheEntity<T> cacheEntity) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY, cacheEntity.getKey());
        contentValues.put(LOCAL_EXPIRE, Long.valueOf(cacheEntity.getLocalExpire()));
        contentValues.put(HEAD, IOUtils.toByteArray(cacheEntity.getResponseHeaders()));
        contentValues.put(DATA, IOUtils.toByteArray(cacheEntity.getData()));
        return contentValues;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> CacheEntity<T> parseCursorToBean(Cursor cursor) {
        CacheEntity<T> cacheEntity = (CacheEntity<T>) new CacheEntity();
        int columnIndex = cursor.getColumnIndex(KEY);
        if (columnIndex >= 0) {
            cacheEntity.setKey(cursor.getString(columnIndex));
        }
        int columnIndex2 = cursor.getColumnIndex(LOCAL_EXPIRE);
        if (columnIndex2 >= 0) {
            cacheEntity.setLocalExpire(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex(HEAD);
        if (columnIndex3 >= 0) {
            cacheEntity.setResponseHeaders((HttpHeaders) IOUtils.toObject(cursor.getBlob(columnIndex3)));
        }
        int columnIndex4 = cursor.getColumnIndex(DATA);
        if (columnIndex4 >= 0) {
            cacheEntity.setData(IOUtils.toObject(cursor.getBlob(columnIndex4)));
        }
        return cacheEntity;
    }

    public boolean checkExpire(CacheMode cacheMode, long j, long j2) {
        if (cacheMode == CacheMode.DEFAULT) {
            return getLocalExpire() < j2;
        }
        return j != -1 && getLocalExpire() + j < j2;
    }

    public T getData() {
        return this.data;
    }

    public String getKey() {
        return this.key;
    }

    public long getLocalExpire() {
        return this.localExpire;
    }

    public HttpHeaders getResponseHeaders() {
        return this.responseHeaders;
    }

    public boolean isExpire() {
        return this.isExpire;
    }

    public void setData(T t) {
        this.data = t;
    }

    public void setExpire(boolean z) {
        this.isExpire = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLocalExpire(long j) {
        this.localExpire = j;
    }

    public void setResponseHeaders(HttpHeaders httpHeaders) {
        this.responseHeaders = httpHeaders;
    }

    public String toString() {
        return dexg.dexa("DbdifFoujuz|lfz>(") + this.key + '\'' + dexg.dexa("-!sftqpotfIfbefst>") + this.responseHeaders + dexg.dexa("-!ebub>") + this.data + dexg.dexa("-!mpdbmFyqjsf>") + this.localExpire + '}';
    }
}
