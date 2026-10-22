package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class wu1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, Object> f20570a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f45691a = new ArrayList();

    public static wu1 h(wu1 wu1Var, long j) {
        return wu1Var.e("exo_len", j);
    }

    public static wu1 i(wu1 wu1Var, @Nullable Uri uri) {
        return uri == null ? wu1Var.d("exo_redir") : wu1Var.f("exo_redir", uri.toString());
    }

    public final wu1 a(String str, Object obj) {
        this.f20570a.put((String) sb0.g(str), sb0.g(obj));
        this.f45691a.remove(str);
        return this;
    }

    public Map<String, Object> b() {
        HashMap map = new HashMap(this.f20570a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f45691a));
    }

    public wu1 d(String str) {
        this.f45691a.add(str);
        this.f20570a.remove(str);
        return this;
    }

    public wu1 e(String str, long j) {
        return a(str, Long.valueOf(j));
    }

    public wu1 f(String str, String str2) {
        return a(str, str2);
    }

    public wu1 g(String str, byte[] bArr) {
        return a(str, Arrays.copyOf(bArr, bArr.length));
    }
}
