package com.byazt.yv;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 499, 13})
public class tt implements com.byazt.gj.ve {
    public static volatile tt c;
    public final CopyOnWriteArraySet<com.byazt.gj.ve> tt = new CopyOnWriteArraySet<>();

    private tt() {
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.gj.ve
    public void tt(boolean z, JSONObject jSONObject) {
        Iterator<com.byazt.gj.ve> it = this.tt.iterator();
        while (it.hasNext()) {
            it.next().tt(z, jSONObject);
        }
    }

    @Override // com.byazt.gj.ve
    public void c(String str, String str2, String str3) {
        Iterator<com.byazt.gj.ve> it = this.tt.iterator();
        while (it.hasNext()) {
            it.next().c(str, str2, str3);
        }
    }

    @Override // com.byazt.gj.ve
    public void c(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        Iterator<com.byazt.gj.ve> it = this.tt.iterator();
        while (it.hasNext()) {
            it.next().c(z, str, str2, str3, str4, str5, str6);
        }
    }

    @Override // com.byazt.gj.ve
    public void c(boolean z, JSONObject jSONObject) {
        Iterator<com.byazt.gj.ve> it = this.tt.iterator();
        while (it.hasNext()) {
            it.next().c(z, jSONObject);
        }
    }
}
