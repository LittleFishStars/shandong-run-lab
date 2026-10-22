package com.alibaba.ariver.commonability.file.proxy;

import android.text.TextUtils;
import androidx.collection.LruCache;
import com.alibaba.ariver.commonability.file.MD5Util;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24036a = "apml";
    private static b b = null;
    private static final String c = "LocalIdTool";
    private Map<String, String> d = new HashMap();
    private LruCache<String, String> e = new LruCache<>(1000);
    private RVFileAbilityProxy f;

    private b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f = (RVFileAbilityProxy) RVProxy.get(RVFileAbilityProxy.class);
        RVLogger.e(c, "LocalIdTool init time=" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static synchronized b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private String c(String str) {
        RVFileAbilityProxy rVFileAbilityProxy = this.f;
        return rVFileAbilityProxy != null ? rVFileAbilityProxy.queryPathByLocalId(str) : "";
    }

    private static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(f24036a);
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        RVLogger.d(c, "decodeToPath>localId = " + str);
        if (!d(str)) {
            return str;
        }
        String strC = this.d.get(str);
        if (strC != null) {
            a(str, strC);
        } else {
            strC = c(str);
            if (TextUtils.isEmpty(strC)) {
                return str;
            }
            this.d.put(str, strC);
        }
        return strC;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        if (TextUtils.isEmpty(str) || str.startsWith(f24036a)) {
            return str;
        }
        String str2 = this.e.get(str);
        if (str2 == null) {
            str2 = f24036a + MD5Util.getMD5String(str);
            this.d.put(str2, str);
            this.e.put(str, str2);
        }
        a(str2, str);
        return str2;
    }

    private void a(String str, String str2) {
        RVFileAbilityProxy rVFileAbilityProxy = this.f;
        if (rVFileAbilityProxy != null) {
            rVFileAbilityProxy.saveIdWithPath(str, str2);
        }
    }
}
