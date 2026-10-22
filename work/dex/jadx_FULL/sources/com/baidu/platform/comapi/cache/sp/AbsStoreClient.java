package com.baidu.platform.comapi.cache.sp;

import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AbsStoreClient {
    private final String key;
    private final a service;

    public AbsStoreClient(SpStorageConfig spStorageConfig, String str) {
        this.service = a.a(spStorageConfig);
        this.key = str;
    }

    private void check() {
        if (TextUtils.isEmpty(this.key)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean readBoolean(boolean z) {
        check();
        return this.service.a(this.key, z);
    }

    public float readFloat(float f) {
        check();
        return this.service.a(this.key, f);
    }

    public int readInt(int i) {
        check();
        return this.service.a(this.key, i);
    }

    public long readLong(long j) {
        check();
        return this.service.a(this.key, j);
    }

    public String readString(String str) {
        check();
        return this.service.a(this.key, str);
    }

    public void remove() {
        check();
        this.service.a(this.key);
    }

    public void writeBoolean(boolean z) {
        check();
        this.service.b(this.key, z);
    }

    public void writeFloat(float f) {
        check();
        this.service.b(this.key, f);
    }

    public void writeInt(int i) {
        check();
        this.service.b(this.key, i);
    }

    public void writeLong(long j) {
        check();
        this.service.b(this.key, j);
    }

    public void writeString(String str) {
        check();
        this.service.b(this.key, str);
    }
}
