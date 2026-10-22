package com.hailiang.advlib.open.oaid.hla;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.bun.miitmdid.content.StringValues;
import com.hailiang.advlib.open.oaid.OAIDException;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public class d implements com.hailiang.advlib.open.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f32590a;

    @Keep
    public class a implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f32591a;

        public a(d dVar) {
            this.f32591a = dVar;
        }

        @Override // com.hailiang.advlib.open.oaid.hla.f.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            com.hailiang.advlib.open.oaid.hl.hl.hl.a aVarA = com.hailiang.advlib.open.oaid.hl.hl.hl.a.b.a(iBinder);
            if (aVarA == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (aVarA.e()) {
                return aVarA.a();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public d(Context context) {
        this.f32590a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f32590a.getPackageName());
            this.f32590a.startForegroundService(intent);
        } catch (Exception unused) {
        }
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public void a(com.hailiang.advlib.open.oaid.a aVar) {
        if (this.f32590a == null || aVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f32590a.getPackageName());
        f.a(this.f32590a, intent, aVar, new a(this));
    }

    @Override // com.hailiang.advlib.open.oaid.b
    public boolean a() {
        Context context = this.f32590a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
