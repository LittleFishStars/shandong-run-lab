package com.aliyun.svideosdk.common.b.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.common.utils.d;
import com.aliyun.common.utils.g;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Hashtable<K, String> f25630a = new Hashtable<>();
    private String b;

    public a(String str) {
        this.b = str;
    }

    public synchronized String a(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(this.b);
        sb.append(File.separator);
        sb.append(str);
        sb.append(".jpeg");
        try {
            d.a(bitmap, sb.toString(), "image/jpeg");
            return sb.toString();
        } catch (IOException unused) {
            Log.e("AliYunLog", "Create cache file failed!");
            return null;
        }
    }

    public synchronized void a() {
        Hashtable<K, String> hashtable = this.f25630a;
        if (hashtable != null) {
            for (Map.Entry<K, String> entry : hashtable.entrySet()) {
                if (!TextUtils.isEmpty(entry.getValue())) {
                    g.a(entry.getValue());
                }
            }
            this.f25630a.clear();
        }
    }

    public synchronized void a(K k, String str) {
        if (str != null) {
            if (!this.f25630a.containsKey(k)) {
                this.f25630a.put(k, str);
            }
        }
    }

    public synchronized boolean a(K k) {
        return this.f25630a.containsKey(k);
    }

    public synchronized Bitmap b(K k) {
        String str = this.f25630a.get(k);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        return d.a(str, (BitmapFactory.Options) null);
    }
}
