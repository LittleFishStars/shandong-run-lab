package com.hailiang.advlib.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.Log;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class a implements _factory {
    private static a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private _factory f32572a = null;
    private Context b;
    private final QMConfig c;

    private a(QMConfig qMConfig) {
        this.c = qMConfig;
        this.b = qMConfig.getContext();
        c();
        d = this;
    }

    public static a a(QMConfig qMConfig) {
        a aVar = d;
        return aVar != null ? aVar : new a(qMConfig);
    }

    private boolean a() {
        if (this.f32572a == null) {
            Log.e("ICliFactory", "repeat loadInstance!");
            c();
        }
        if (this.f32572a != null) {
            return true;
        }
        Log.e("ICliFactory", "Instance not present!");
        return false;
    }

    private void b() {
        hl.hl.hl.hla.a.a().a("remoteInit");
        this.f32572a = c.a(this.b, this.c, "10.447");
        hl.hl.hl.hla.a.a().b("remoteInit");
    }

    private void c() {
        hl.hl.hl.hla.a.a().a("loadR");
        if (c.a(_factory.class)) {
            Log.i("ICliFactory", "Well, our remote class didn't load yet, invoke _bootstrap() ...");
            hl.hl.hl.hl.a.a(this.c);
        }
        hl.hl.hl.hla.a.a().b("loadR");
        b();
    }

    @Override // com.hailiang.advlib.core._factory
    public void appListFromClientNotice() {
        if (a()) {
            this.f32572a.appListFromClientNotice();
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public IMultiAdRequest createNativeMultiAdRequest() {
        return c.b();
    }

    @Override // com.hailiang.advlib.core._factory
    public void notifyMsg(int i, Bundle bundle) {
        if (a()) {
            this.f32572a.notifyMsg(i, bundle);
        }
    }

    @Override // com.hailiang.advlib.core._factory, java.lang.Runnable
    public void run() {
        if (a()) {
            this.f32572a.run();
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void setAppList(List<PackageInfo> list) {
        if (a()) {
            this.f32572a.setAppList(list);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void setImageAutoDownload(boolean z) {
        if (a()) {
            this.f32572a.setImageAutoDownload(z);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void terminate() {
        if (a()) {
            this.f32572a.terminate();
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void useDebugServer(int i) {
        if (a()) {
            this.f32572a.useDebugServer(i);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void useDebugServer(boolean z) {
        if (a()) {
            this.f32572a.useDebugServer(z);
        }
    }

    @Override // com.hailiang.advlib.core._factory
    public void whenPermDialogReturns(int i, String[] strArr, int[] iArr) {
        if (a()) {
            this.f32572a.whenPermDialogReturns(i, strArr, iArr);
        }
    }
}
