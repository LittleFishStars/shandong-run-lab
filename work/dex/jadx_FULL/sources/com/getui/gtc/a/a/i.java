package com.getui.gtc.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.text.TextUtils;
import android.util.Base64;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f30247a;
    public Runnable b;

    public i(Context context) {
        this.f30247a = context;
    }

    public static String a(String str, k kVar) {
        try {
            if (kVar.f30255a != 2 || TextUtils.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("value\\s*=\\s*\"(1[3-9][0-9]\\d{8})\"").matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return null;
        }
    }

    public static boolean a(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
            return false;
        }
    }

    public final void a(final Network network) {
        com.getui.gtc.f.c.a(0L, new com.getui.gtc.f.e() { // from class: com.getui.gtc.a.a.i.4
            @Override // com.getui.gtc.f.e
            public final void a(String str) {
                com.getui.gtc.i.c.a.d("pm vd http url failed:".concat(String.valueOf(str)));
            }

            @Override // com.getui.gtc.f.e
            public final void a(Map<String, String> map, Map<String, String> map2) {
                String str = map2.get("sdk.gtc.type305.cm.ad.gtc_skip");
                if (TextUtils.isEmpty(str)) {
                    com.getui.gtc.i.c.a.d("pm vd http url == null");
                    return;
                }
                k kVar = new k();
                kVar.f30255a = 2;
                final i iVar = i.this;
                byte[] bArrDecode = Base64.decode(str.getBytes(), 2);
                for (int length = bArrDecode.length - 1; length > 0; length--) {
                    bArrDecode[length] = (byte) (bArrDecode[length] ^ bArrDecode[length - 1]);
                }
                bArrDecode[0] = (byte) (bArrDecode[0] ^ com.google.common.base.a.A);
                String str2 = new String(bArrDecode);
                Network network2 = network;
                final boolean z = network2 != null;
                d dVar = new d(str2, kVar, network2);
                dVar.e = new e() { // from class: com.getui.gtc.a.a.i.5
                    @Override // com.getui.gtc.a.a.e
                    public final void a(Object obj) throws Throwable {
                        if (obj instanceof j) {
                            j jVar = (j) obj;
                            i iVar2 = i.this;
                            String str3 = jVar.b;
                            int i = jVar.c;
                            k kVar2 = jVar.d;
                            boolean z2 = z;
                            Runnable runnable = iVar2.b;
                            if (runnable != null) {
                                runnable.run();
                            }
                            String strA = i.a(str3, kVar2);
                            if (TextUtils.isEmpty(strA)) {
                                com.getui.gtc.i.c.a.d("p faild parseData type=" + i + " data = release");
                                com.getui.gtc.a.g.a(1, new o(z2 ? -4 : -1, "", ""));
                                return;
                            }
                            com.getui.gtc.i.c.a.d("p success parseData type=" + i + " data = release");
                            com.getui.gtc.a.g.a(1, new o(z2 ? -3 : 0, "", strA));
                        }
                    }
                };
                new b(dVar).run();
            }
        });
    }
}
