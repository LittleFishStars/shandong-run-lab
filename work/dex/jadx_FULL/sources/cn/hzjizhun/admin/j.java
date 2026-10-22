package cn.hzjizhun.admin;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.hzjizhun.admin.cn_oaid.OAIDException;
import cn.hzjizhun.admin.cn_oaid.repeackage.com.bun.lib.MsaIdInterface;
import com.bun.miitmdid.content.StringValues;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j implements sdkdda {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f22745a;

    public class a implements dadkdadds.kdsksdda {
        public a() {
        }

        @Override // cn.hzjizhun.admin.dadkdadds.kdsksdda
        public String a(IBinder iBinder) {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new OAIDException("MsaIdInterface is null");
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new OAIDException("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.f22745a = context;
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public boolean a() {
        Context context = this.f22745a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Throwable th) {
            dddssad.a(th);
            return false;
        }
    }

    @Override // cn.hzjizhun.admin.sdkdda
    public void b(ddakd ddakdVar) {
        if (this.f22745a == null || ddakdVar == null) {
            return;
        }
        c();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f22745a.getPackageName());
        dadkdadds.a(this.f22745a, intent, ddakdVar, new a());
    }

    public final void c() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f22745a.getPackageName());
            this.f22745a.startForegroundService(intent);
        } catch (Throwable th) {
            dddssad.a(th);
        }
    }
}
