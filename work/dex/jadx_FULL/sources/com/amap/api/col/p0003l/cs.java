package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.zj.adlib.a7b;
import com.zj.adlib.wwa;
import com.zj.adlib.ywa;
import com.zj.adlib.zwa;
import java.io.File;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cs extends it {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25907a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f787a;
    public String f;
    public String g;
    public String h;

    public interface a {
        void a(byte[] bArr, int i);

        void b(byte[] bArr, int i);
    }

    public cs(Context context, a aVar, int i, String str) {
        this.f = null;
        this.g = null;
        this.h = null;
        this.f25907a = context;
        this.f785a = aVar;
        this.K = i;
        if (this.f786a == null) {
            this.f786a = new e(context, "", i != 0);
        }
        this.f786a.b(str);
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append(str == null ? "" : str);
        sb.append(".amapstyle");
        this.f = sb.toString();
        this.g = context.getCacheDir().getPath();
    }

    public final void a() {
        this.f25907a = null;
        if (this.f786a != null) {
            this.f786a = null;
        }
    }

    public final void b(String str) {
        e eVar = this.f786a;
        if (eVar != null) {
            eVar.c(str);
        }
        this.h = str;
    }

    public final void c(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        wwa.a(this.f25907a, "amap_style_config", "lastModified".concat(str), str2);
    }

    public final void d(String str, byte[] bArr) {
        if (str == null || bArr == null || this.g == null) {
            return;
        }
        FileUtil.saveFileContents(this.g + File.separator + str, bArr);
    }

    public final byte[] e(String str) {
        if (str == null || this.g == null) {
            return null;
        }
        return FileUtil.readFileContents(this.g + File.separator + str);
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        Object objB = wwa.b(this.f25907a, "amap_style_config", "lastModified".concat(str), "");
        if (!(objB instanceof String) || objB == "") {
            return null;
        }
        return (String) objB;
    }

    @Override // com.amap.api.col.p0003l.it
    public final void runTask() {
        byte[] bArr;
        JSONObject jSONObject;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                if (this.f786a != null) {
                    String str = this.h + this.f;
                    String strF = f(str);
                    if (strF != null) {
                        this.f786a.d(strF);
                    }
                    byte[] bArrE = e(str);
                    a aVar = this.f785a;
                    if (aVar != null && bArrE != null) {
                        aVar.a(bArrE, this.K);
                    }
                    e.a aVarM = this.f786a.m();
                    if (aVarM != null && (bArr = aVarM.f793a) != null) {
                        try {
                            jSONObject = new JSONObject(new String(bArr));
                        } catch (JSONException unused) {
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            if (this.f785a == null) {
                                IAMapDelegate iAMapDelegate = this.f787a;
                                if (iAMapDelegate != null) {
                                    iAMapDelegate.setCustomMapStyle(iAMapDelegate.getMapConfig().isCustomStyleEnable(), aVarM.f793a);
                                }
                            } else if (!Arrays.equals(aVarM.f793a, bArrE)) {
                                this.f785a.b(aVarM.f793a, this.K);
                            }
                            d(str, aVarM.f793a);
                            c(str, aVarM.f791a);
                        }
                    }
                }
                a7b.d(this.f25907a, zwa.t());
                IAMapDelegate iAMapDelegate2 = this.f787a;
                if (iAMapDelegate2 != null) {
                    iAMapDelegate2.setRunLowFrame(false);
                }
            }
        } catch (Throwable th) {
            a7b.m(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void b() {
        ywa.a().b(this);
    }

    public cs(Context context, IAMapDelegate iAMapDelegate) {
        this.f = null;
        this.g = null;
        this.h = null;
        this.K = 0;
        this.f25907a = context;
        this.f787a = iAMapDelegate;
        if (this.f786a == null) {
            this.f786a = new e(context, "");
        }
    }
}
