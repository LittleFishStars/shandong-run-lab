package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.zj.adlib.a7b;
import com.zj.adlib.yua;
import com.zj.adlib.ywa;
import com.zj.adlib.zwa;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cu extends it {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f25908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f788a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f789a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yua f790a;

    public interface a {
        void a(String str, yua yuaVar);
    }

    public cu(Context context) {
        this.f25908a = context;
        if (this.f789a == null) {
            this.f789a = new f(context, "");
        }
    }

    public static String a(Context context) {
        return FileUtil.getMapBaseStorage(context);
    }

    public static void e(String str, byte[] bArr) throws Throwable {
        FileUtil.writeDatasToFile(str, bArr);
    }

    public final void b() {
        ywa.a().b(this);
    }

    public final void c(yua yuaVar) {
        this.f790a = yuaVar;
    }

    public final void d(String str) {
        f fVar = this.f789a;
        if (fVar != null) {
            fVar.b(str);
        }
    }

    @Override // com.amap.api.col.p0003l.it
    public final void runTask() {
        String str;
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                f fVar = this.f789a;
                if (fVar != null) {
                    f.a aVarM = fVar.m();
                    if (aVarM == null || aVarM.f836a == null) {
                        str = null;
                    } else {
                        str = a(this.f25908a) + "/custom_texture_data";
                        e(str, aVarM.f836a);
                    }
                    a aVar = this.f788a;
                    if (aVar != null) {
                        aVar.a(str, this.f790a);
                    }
                }
                a7b.d(this.f25908a, zwa.t());
            }
        } catch (Throwable th) {
            a7b.m(th, "CustomStyleTask", "download customStyle");
            th.printStackTrace();
        }
    }

    public final void a() {
        this.f25908a = null;
        if (this.f789a != null) {
            this.f789a = null;
        }
    }

    public final void b(a aVar) {
        this.f788a = aVar;
    }
}
