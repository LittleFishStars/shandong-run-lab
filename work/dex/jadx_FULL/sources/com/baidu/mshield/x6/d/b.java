package com.baidu.mshield.x6.d;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.c;
import com.baidu.mshield.x6.f.f;
import com.baidu.mshield.x6.f.h;
import java.net.URLEncoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26759a;
    public String b = "";

    public b(Context context) {
        this.f26759a = context;
    }

    public static synchronized b a(Context context) {
        return new b(context);
    }

    public String b(String str) {
        return a() + e("f/2/sig") + "?skey=" + d(str);
    }

    public String c(String str) {
        return a() + e("c/11/z") + "?skey=" + d(str);
    }

    public String d(String str) {
        return URLEncoder.encode(Base64.encodeToString(h.d(str.getBytes(), e.a(c.b(this.f26759a)).getBytes()), 0));
    }

    public final String e(String str) {
        String strA;
        try {
            String strA2 = f.a();
            String strB = f.b();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            try {
                strA = f.a(strA2, strB, jCurrentTimeMillis);
            } catch (Throwable th) {
                f.b(th);
                strA = "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append("/250");
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER + strA2);
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER + jCurrentTimeMillis);
            stringBuffer.append(WVNativeCallbackUtil.SEPERATER + strA);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            f.b(th2);
            return "";
        }
    }

    public final String a() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        String strF = f.f(this.f26759a);
        if (!TextUtils.isEmpty(strF)) {
            this.b = strF;
        }
        return this.b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(a());
        if (com.baidu.mshield.x6.c.b.b()) {
            sb.append(e("f/2/ejc"));
        } else {
            sb.append(e("f/2/jc"));
        }
        sb.append("?skey=");
        sb.append(d(str));
        return sb.toString();
    }
}
