package com.kc.dw.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f39348a;

    static {
        Collections.synchronizedList(new ArrayList());
    }

    public static String a() {
        if (TextUtils.isEmpty(f39348a)) {
            Charset charset = d1.f39359a;
            f39348a = new String(Base64.decode("bXNfdXVpZA==", 0));
        }
        return f39348a;
    }

    public static String a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sbA = com.kc.dw.activity.a.a("([?&])");
        sbA.append(a());
        sbA.append("=[^&]*");
        String string = sbA.toString();
        StringBuilder sbA2 = com.kc.dw.activity.a.a("$1");
        sbA2.append(a());
        sbA2.append("=ABC");
        String strReplaceAll = str.replaceAll(string, sbA2.toString());
        if (TextUtils.isEmpty(strReplaceAll)) {
            return null;
        }
        return i.b(strReplaceAll);
    }
}
