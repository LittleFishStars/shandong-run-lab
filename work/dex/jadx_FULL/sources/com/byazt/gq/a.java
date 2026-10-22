package com.byazt.gq;

import android.net.Uri;
import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.su.DownloadModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 52, 34})
public class a {
    public final ConcurrentHashMap<String, String> c;
    public final ConcurrentHashMap<String, String> tt;

    @com.byazt.zqa.c(c = {0, 1, 52, 464})
    public static class c {
        public static a c = new a();
    }

    public static a c() {
        return c.c;
    }

    private String ve(String str) {
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.equals("https", scheme) || !lastPathSegment.endsWith(".apk")) {
                return null;
            }
            this.c.put(str, lastPathSegment);
            return lastPathSegment;
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }

    public void tt(String str) {
        Iterator<Map.Entry<String, String>> it = this.tt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            if (TextUtils.equals(next.getValue(), str)) {
                it.remove();
                this.c.remove(next.getKey());
            }
        }
    }

    private a() {
        this.c = new ConcurrentHashMap<>();
        this.tt = new ConcurrentHashMap<>();
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || this.tt.containsKey(str2)) {
            return;
        }
        this.tt.put(str2, str);
    }

    public String c(String str) {
        if (TextUtils.isEmpty(str) || this.tt.isEmpty() || !this.tt.containsKey(str)) {
            return null;
        }
        String strVe = ve(str);
        if (this.c.containsValue(strVe)) {
            for (Map.Entry<String, String> entry : this.c.entrySet()) {
                if (TextUtils.equals(entry.getValue(), strVe)) {
                    String str2 = this.tt.get(entry.getKey());
                    this.tt.put(str, str2);
                    if (!this.c.containsKey(str)) {
                        this.c.put(str, strVe);
                    }
                    return str2;
                }
            }
        }
        return this.tt.get(str);
    }

    public String c(DownloadModel downloadModel) {
        String strVe = ve(downloadModel.getDownloadUrl());
        if (strVe == null || TextUtils.isEmpty(strVe)) {
            return null;
        }
        String strN = com.byazt.w.a.n(strVe + downloadModel.getPackageName());
        this.tt.put(downloadModel.getDownloadUrl(), strN);
        return strN;
    }
}
