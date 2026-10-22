package com.byazt.az;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.yv.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 971, 20})
public class c {
    public final ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    public final Map<String, String> tt = new HashMap();
    public final SharedPreferences.Editor uj;
    public final SharedPreferences ve;

    public c(Context context) {
        SharedPreferences sharedPreferencesTt = u.tt(context);
        this.ve = sharedPreferencesTt;
        this.uj = sharedPreferencesTt.edit();
    }

    public void c(String str, String str2) {
        this.c.writeLock().lock();
        try {
            this.tt.put(str, str2);
            com.byazt.tf.c.c("__kite", "updateMemoryCacheBySync# update mem success, key: ".concat(String.valueOf(str)));
        } finally {
            this.c.writeLock().unlock();
        }
    }

    public void tt(String str, String str2) {
        try {
            this.uj.putString(str, str2);
            this.uj.commit();
        } catch (Exception e) {
            com.byazt.tf.c.tt("__kiteupdateDiskCache# error " + e.getMessage());
        }
    }

    public String c(String str) {
        String str2 = this.tt.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.c.readLock().lock();
        try {
            String string = this.tt.get(str);
            if (TextUtils.isEmpty(string)) {
                string = this.ve.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    this.tt.put(str, string);
                    if (com.byazt.tf.c.tt()) {
                        com.byazt.tf.c.c("__kitegetCacheOrFromDisk# check cache: " + str + " is empty, read from sp and update cache.");
                    }
                }
            }
            return string != null ? string : "";
        } finally {
            this.c.readLock().unlock();
        }
    }
}
