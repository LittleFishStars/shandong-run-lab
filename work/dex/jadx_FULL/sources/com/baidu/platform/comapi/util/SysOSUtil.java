package com.baidu.platform.comapi.util;

import com.baidu.platform.comapi.util.a.a;
import com.baidu.platform.comapi.util.a.b;
import com.baidu.vi.VIContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SysOSUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SysOSUtil f26795a = new SysOSUtil();
    private b b = null;
    private a c = null;
    private boolean d = false;
    private String e = "";
    private String f = "";
    private String g = "";

    private SysOSUtil() {
    }

    public static SysOSUtil getInstance() {
        return f26795a;
    }

    public String getCompatibleSdcardPath() {
        b bVar = this.b;
        return bVar != null ? bVar.a() : "";
    }

    public float getDensity() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a();
        }
        return 1.0f;
    }

    public int getDensityDPI() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b();
        }
        return 1;
    }

    public String getExternalFilesDir() {
        b bVar = this.b;
        return bVar != null ? bVar.b() : "";
    }

    public String getGLRenderer() {
        return this.g;
    }

    public String getGLVersion() {
        return this.f;
    }

    public String getNetType() {
        return this.e;
    }

    public String getOutputCache() {
        b bVar = this.b;
        return bVar != null ? bVar.c() : "";
    }

    public String getOutputDirPath() {
        b bVar = this.b;
        return bVar != null ? bVar.d() : "";
    }

    public int getScreenHeight() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    public int getScreenWidth() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.d();
        }
        return 0;
    }

    public String getSdcardPath() {
        b bVar = this.b;
        return bVar != null ? bVar.e() : "";
    }

    public void init(b bVar, a aVar) {
        if (this.d) {
            return;
        }
        this.b = bVar;
        this.c = aVar;
        if (bVar == null) {
            this.b = new b();
        }
        if (this.c == null) {
            this.c = new a();
        }
        this.b.a(VIContext.getContext());
        this.c.a(VIContext.getContext());
        try {
            NetworkUtil.registerNetwork(VIContext.getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = true;
    }

    public void setGLInfo(String str, String str2) {
        if (this.g.equals(str2) && this.f.equals(str)) {
            return;
        }
        this.f = str;
        this.g = str2;
    }

    public void updateNetType(String str) {
        this.e = str;
    }
}
