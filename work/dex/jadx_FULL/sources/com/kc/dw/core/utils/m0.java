package com.kc.dw.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.kc.dw.activity.SsdOpenDeepLinkActivity;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f39386a;

    @Keep
    public interface a {
        void a(boolean z);
    }

    @Keep
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m0 f39387a = new m0();
    }

    public static Intent a(String str) throws URISyntaxException {
        Intent uri = Intent.parseUri(str, 0);
        uri.addCategory("android.intent.category.BROWSABLE");
        uri.setComponent(null);
        uri.setSelector(null);
        uri.setFlags(268435456);
        return uri;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006c A[Catch: all -> 0x0073, TryCatch #1 {all -> 0x0073, blocks: (B:14:0x002a, B:16:0x0038, B:32:0x0068, B:34:0x006c, B:35:0x006f, B:31:0x0065, B:10:0x0023, B:5:0x0012, B:7:0x0018, B:18:0x003d, B:26:0x0056, B:28:0x005e, B:27:0x005a), top: B:40:0x0012, inners: #0, #2 }] */
    public static void a(Context context, String str, String str2, String[] strArr, String str3, boolean z) {
        Intent uri;
        Intent intentA;
        if (z) {
            SsdOpenDeepLinkActivity.startOpenDeepLinkActivity(context, str, str2, strArr, str3);
            return;
        }
        com.kc.dw.core.router.helper.a.a(new j0(-1L));
        Intent intent = null;
        try {
            try {
                uri = !TextUtils.isEmpty(str3) ? Intent.parseUri(b2.a(str3, str), 0) : null;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (uri == null || uri.resolveActivity(com.kc.dw.base.a.getContext().getPackageManager()) == null) {
                try {
                    if (TextUtils.isEmpty(str2)) {
                        a(strArr, 4);
                    } else {
                        try {
                            uri = a2.a(str, context);
                            if (uri == null) {
                                a(strArr, 3);
                                intentA = a(str);
                                intent = intentA;
                                if (p0.i != null) {
                                    f.a(str, intent);
                                }
                                context.startActivity(intent);
                            }
                            a(strArr, 1);
                        } catch (Throwable unused) {
                            a(strArr, 3);
                            intentA = a(str);
                        }
                    }
                    intentA = a(str);
                    intent = intentA;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                if (p0.i != null) {
                    f.a(str, intent);
                }
                context.startActivity(intent);
            }
            a(strArr, 1);
            intent = uri;
            if (p0.i != null) {
                f.a(str, intent);
            }
            context.startActivity(intent);
        } catch (Throwable th3) {
            LogUtil.d("ClickHandler", "jumpDeepLink2 error");
            th3.printStackTrace();
        }
    }

    public static void a(boolean z) {
        try {
            m0 m0Var = b.f39387a;
            a aVar = m0Var.f39386a;
            if (aVar != null) {
                aVar.a(z);
                m0Var.f39386a = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String[] strArr, int i) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        f.a(g0.b(strArr, i));
    }
}
