package com.kc.dw.cache.media.datasouce;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f39224a;
    public RandomAccessFile b;
    public File c;
    public File d;
    public File e;
    public volatile long f;

    public b(String str) {
        this.f = -2147483648L;
        try {
            this.c = com.kc.dw.core.bquery.c.a(str, (String) null);
            this.d = com.kc.dw.core.bquery.c.a(str, "temp");
            this.e = com.kc.dw.core.bquery.c.a(str, "last_meta_temp");
            if (a()) {
                this.f39224a = new RandomAccessFile(this.c, "r");
                this.f = this.c.length();
            } else {
                this.f39224a = new RandomAccessFile(this.d, "r");
                this.b = new RandomAccessFile(this.e, "r");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a() {
        File file = this.c;
        return file != null && file.exists();
    }
}
