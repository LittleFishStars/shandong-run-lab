package com.kc.dw.cache;

import android.graphics.Bitmap;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39218a;

    public a(String str) {
        this.f39218a = str;
    }

    @Override // com.kc.dw.cache.d
    public void a() {
    }

    @Override // com.kc.dw.cache.d
    public void a(Bitmap bitmap, byte[] bArr, boolean z) {
        try {
            b.f39219a.remove(com.kc.dw.core.bquery.c.b(this.f39218a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.cache.d
    public void b(int i) {
        try {
            b.f39219a.remove(com.kc.dw.core.bquery.c.b(this.f39218a));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
