package com.alibaba.alibclinkpartner.smartlink.b;

import android.text.TextUtils;
import com.alibaba.alibclinkpartner.smartlink.util.ALSLLogUtil;
import com.alibaba.alibclinkpartner.smartlink.util.g;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f23569a = new HashMap();
    private String b;

    private a() {
    }

    public static a a() {
        return new a();
    }

    private String c() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("https://wgo.mmstat.com/%s?", this.b));
        stringBuffer.append(g.a(this.f23569a));
        return stringBuffer.toString();
    }

    public a a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
        }
        return this;
    }

    public a a(Map<String, String> map) {
        if (map != null) {
            this.f23569a.putAll(map);
        }
        return this;
    }

    public boolean b() throws Throwable {
        String strC = c();
        ALSLLogUtil.d("ALSLAplus", "send", "Aplus打点上报的url = " + strC);
        com.alibaba.alibclinkpartner.smartlink.a.a.a(strC, (Map<String, String>) null);
        return true;
    }
}
