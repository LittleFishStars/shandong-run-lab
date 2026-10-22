package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
class m implements ConfigReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f37375a = new ConcurrentHashMap();
    private final k b;

    public m(Context context, String str) {
        this.b = new k(context, str);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String str, String str2) {
        String str3 = this.f37375a.get(str);
        if (str3 != null) {
            return str3;
        }
        String strA = this.b.a(str, str2);
        if (strA == null) {
            return str2;
        }
        this.f37375a.put(str, strA);
        return strA;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
