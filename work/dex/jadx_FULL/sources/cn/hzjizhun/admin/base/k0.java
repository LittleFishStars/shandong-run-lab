package cn.hzjizhun.admin.base;

import cn.hzjizhun.admin.base.ad.RcSdk;
import com.zj.adlib.c0b;
import com.zj.adlib.jha;
import com.zj.adlib.kha;
import com.zj.adlib.m3b;
import com.zj.adlib.mib;
import com.zj.adlib.rvb;
import com.zj.adlib.ydb;
import com.zj.adlib.zmb;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f22701a;

    public static void a() {
        if (f22701a) {
            return;
        }
        try {
            f22701a = true;
            File file = new File(RcSdk.e().getExternalCacheDir(), g.b("cn.hzjizhun.admin.base".getBytes()));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "temp_p");
            if (file2.exists()) {
                return;
            }
            kha khaVar = new kha();
            m3b.b(khaVar);
            jha.b(khaVar);
            c0b.b(khaVar);
            try {
                rvb rvbVarA = rvb.a();
                khaVar.f42822a = rvbVarA.b;
                khaVar.b = rvbVarA.f19444a;
            } catch (Throwable unused) {
            }
            JSONObject jSONObjectB = khaVar.b();
            zmb.a().getClass();
            boolean zE = zmb.e();
            boolean zB = f0.b();
            boolean zC = zmb.a().c();
            boolean zB2 = zmb.a().b();
            zmb.a().getClass();
            boolean zD = zmb.d();
            boolean zD2 = n0.d();
            jSONObjectB.put("isProxy", zE);
            jSONObjectB.put("hasSign", zB);
            jSONObjectB.put("isApkInDebug", zC);
            jSONObjectB.put("isAdbDebug", zB2);
            jSONObjectB.put("isDeviceInVPN", zD);
            jSONObjectB.put("mobileRoot", zD2);
            String strC = g.c(jSONObjectB.toString());
            mib mibVarA = mib.a();
            ydb ydbVar = new ydb(file2, strC);
            mibVarA.getClass();
            mib.f18226a.submit(ydbVar);
        } catch (Throwable unused2) {
        }
    }
}
