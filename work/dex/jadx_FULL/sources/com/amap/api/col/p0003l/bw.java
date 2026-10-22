package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.zj.adlib.a7b;
import com.zj.adlib.zwa;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class bw<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25897a = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public T f752a;

    public bw(Context context, T t) {
        b(context, t);
    }

    public abstract V a(JSONObject jSONObject) throws AMapException;

    public abstract String a();

    public abstract JSONObject a(fh.c cVar);

    public abstract Map<String, String> b();

    public final void b(Context context, T t) {
        this.f751a = context;
        this.f752a = t;
    }

    public final V c() throws AMapException {
        if (this.f752a != null) {
            return d();
        }
        return null;
    }

    public final V d() throws AMapException {
        int i = 0;
        V vA = null;
        fh.c cVarC = null;
        while (i < this.f25897a) {
            try {
                cVarC = fh.c(this.f751a, zwa.t(), a(), b());
                vA = a(a(cVarC));
                i = this.f25897a;
            } catch (Throwable th) {
                a7b.m(th, "AbstractProtocalHandler", "getDataMayThrow AMapException");
                th.printStackTrace();
                i++;
                if (i < this.f25897a) {
                    continue;
                } else {
                    if (cVarC != null && cVarC.f861a != null) {
                        throw new AMapException(cVarC.f861a);
                    }
                    vA = null;
                }
            }
        }
        return vA;
    }
}
