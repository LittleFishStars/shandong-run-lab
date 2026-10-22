package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
class h implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32596a;

    @Keep
    public class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h f32597a;

        public a(h hVar) {
            this.f32597a = hVar;
        }

        @Override // com.hailiang.advlib.open.oaid.hla.f.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a aVarA = com.hailiang.advlib.open.oaid.hl.hlb.hl.hl.a.b.a(iBinder);
            if (aVarA != null) {
                return aVarA.a();
            }
            throw new OAIDException("IDeviceIdService is null");
        }
    }

    public h(Context context) {
        this.f32596a = context;
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f32596a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        f.a(this.f32596a, intent, aVar, new a(this));
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f32596a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
