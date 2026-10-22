package com.ipd.dsp.internal.u0;

import android.content.Context;
import android.os.Process;
import com.alibaba.android.arouter.utils.Consts;
import com.beizi.fusion.BeiZis;
import com.ipd.dsp.internal.c2.k;
import com.octopus.ad.Octopus;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.LinkedList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    public static final String b = "SF";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Integer> f38553a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38554a = new a();
    }

    public interface c<T> {
        T a(LinkedList<Class<?>> linkedList) throws Throwable;
    }

    public static a a() {
        return b.f38554a;
    }

    public void b() {
        Context context;
        this.f38553a.add(0);
        if (a("com.tencent.smtt.sdk.WebView", -1, "smtt.WebView", null) && (context = com.ipd.dsp.internal.l1.a.a().getContext()) != null && context.checkPermission("android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0) {
            QbSdk.initX5Environment(context, (QbSdk.PreInitCallback) null);
        }
        a(new String[]{"com.beizi.fusion.BeiZis", "com.beizi.ad.BeiZi"}, 1, 7, null, new c() { // from class: com.zj.adlib.hda
            @Override // com.ipd.dsp.internal.u0.a.c
            public final Object a(LinkedList linkedList) {
                return BeiZis.getSdkVersion();
            }
        });
        a("com.octopus.ad.Octopus", 9, new c() { // from class: com.zj.adlib.eea
            @Override // com.ipd.dsp.internal.u0.a.c
            public final Object a(LinkedList linkedList) {
                return Octopus.getSdkVersion();
            }
        });
    }

    public a() {
        this.f38553a = new ArrayList<>();
    }

    public final void a(String str, int i, c<String> cVar) {
        a(str, i, null, cVar);
    }

    public final boolean a(String str, int i, String str2, c<String> cVar) {
        return a(new String[]{str}, 0, i, str2, cVar);
    }

    public final boolean a(String[] strArr, int i, int i2, String str, c<String> cVar) {
        String strA;
        try {
            LinkedList<Class<?>> linkedList = new LinkedList<>();
            for (String str2 : strArr) {
                try {
                    linkedList.add(Class.forName(str2, false, a.class.getClassLoader()));
                } catch (ClassNotFoundException e) {
                    if (i == 1) {
                        throw e;
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                if (i2 >= 0) {
                    this.f38553a.add(Integer.valueOf(i2));
                }
                String strA2 = a(linkedList.get(0).getName(), str);
                if (cVar != null) {
                    try {
                        strA = cVar.a(linkedList);
                    } catch (Throwable unused) {
                        strA = "error";
                    }
                } else {
                    strA = "exist";
                }
                k.d(b, strA2 + ": " + strA);
                return true;
            }
            throw new IllegalStateException();
        } catch (Throwable unused2) {
            k.e(b, a(strArr[0], str) + " not exist");
            return false;
        }
    }

    public static String a(String str, String str2) {
        return str2 == null ? str.substring(str.lastIndexOf(Consts.DOT) + 1) : str2;
    }

    public boolean a(Integer num) {
        try {
            return this.f38553a.contains(num);
        } catch (Throwable unused) {
            return false;
        }
    }
}
