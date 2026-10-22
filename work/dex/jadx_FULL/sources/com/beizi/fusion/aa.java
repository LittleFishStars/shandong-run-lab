package com.beizi.fusion;

import android.content.Context;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.NativeModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class aa implements dc, wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected w9 f27001a;
    protected NativeModel b;
    protected Context c;
    protected String d;
    protected hc.a e;

    @Override // com.beizi.fusion.dc
    public void a(Context context, NativeModel nativeModel, String str) {
        this.c = context;
        this.f27001a = a();
        this.b = nativeModel;
        this.d = str;
    }

    @Override // com.beizi.fusion.wa
    public va d() {
        return this.f27001a;
    }

    public w9 a() {
        return new w9();
    }
}
