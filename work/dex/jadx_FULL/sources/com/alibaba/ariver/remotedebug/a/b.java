package com.alibaba.ariver.remotedebug.a;

import com.alibaba.fastjson.JSONObject;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24378a = 1;

    public interface a {
        void a(String str, int i, String str2);

        void a(byte[] bArr);

        void c();

        void c(String str);

        void d(String str);

        void e(String str);
    }

    void a(String str, Map<String, String> map, JSONObject jSONObject);

    void b(int i, String str);

    boolean b(String str);
}
