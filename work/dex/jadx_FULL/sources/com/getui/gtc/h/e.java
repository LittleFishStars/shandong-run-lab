package com.getui.gtc.h;

import android.util.Base64;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.http.Call;
import com.getui.gtc.base.http.Request;
import com.getui.gtc.base.http.Response;
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f30375a;

    public interface a {
        void a(String str);
    }

    public static void a(final String str, final String str2, final a aVar) {
        d.f30374a.newCall(new Request.Builder().url(str).method("GET").logFlags(1).tag("fetch servers").build()).enqueue(new Call.Callback() { // from class: com.getui.gtc.h.e.1
            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onFailure(Call call, Exception exc) {
                com.getui.gtc.i.c.a.b("Failed! = " + call.request().url());
                com.getui.gtc.i.c.a.b(exc);
                if (e.f30375a < 3) {
                    e.b();
                    try {
                        Thread.sleep(e.f30375a * 5000);
                    } catch (InterruptedException unused) {
                    }
                    e.a(str, str2, aVar);
                }
            }

            @Override // com.getui.gtc.base.http.Call.Callback
            public final void onResponse(Call call, Response response) {
                e.c();
                byte[] body = response.getBody();
                try {
                    byte[] bArrDecode = Base64.decode(str2, 2);
                    String str3 = new String(CryptTools.decrypt("AES/CFB/NOPADDING", CryptTools.wrapperKey("AES", bArrDecode), new IvParameterSpec(CryptTools.digest("MD5", bArrDecode)), body));
                    com.getui.gtc.i.c.a.a("fetch servers from " + call.request().url() + " :" + str3);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(str3);
                    }
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
        });
    }

    public static /* synthetic */ int b() {
        int i = f30375a;
        f30375a = i + 1;
        return i;
    }

    public static /* synthetic */ int c() {
        f30375a = 0;
        return 0;
    }
}
