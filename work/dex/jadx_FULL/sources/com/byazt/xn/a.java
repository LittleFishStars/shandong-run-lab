package com.byazt.xn;

import android.text.TextUtils;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.sl;
import com.byazt.gqp.yp;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 34})
public class a extends m {
    public HttpURLConnection c;
    public sl n = null;
    public yp tt;
    public long uj;
    public long ve;

    public a(HttpURLConnection httpURLConnection, yp ypVar) {
        this.c = httpURLConnection;
        this.tt = ypVar;
    }

    @Override // com.byazt.gqp.m
    public nu a() {
        try {
            return new sp(this.c);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.byazt.gqp.m
    public long c() {
        return this.ve;
    }

    @Override // com.byazt.gqp.m, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            a().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.gqp.m
    public String n() throws IOException {
        return this.c.getResponseMessage();
    }

    @Override // com.byazt.gqp.m
    public com.byazt.gqp.a sp() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.c.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || ve() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.byazt.gqp.a((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public String toString() {
        return "";
    }

    @Override // com.byazt.gqp.m
    public long tt() {
        return this.uj;
    }

    @Override // com.byazt.gqp.m
    public boolean uj() {
        return ve() >= 200 && ve() < 300;
    }

    @Override // com.byazt.gqp.m
    public int ve() {
        try {
            return this.c.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.byazt.gqp.m
    public sl x() {
        return this.n;
    }

    @Override // com.byazt.gqp.m
    public String c(String str) {
        return this.c.getHeaderField(str);
    }

    @Override // com.byazt.gqp.m
    public String c(String str, String str2) {
        return !TextUtils.isEmpty(c(str)) ? c(str) : str2;
    }
}
