package com.byazt.uy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1180, 13})
public class tt {
    public Map<ve, List<c>> c = new HashMap();
    public Map<String, String> tt = new HashMap();
    public final List<Object> ve = new CopyOnWriteArrayList();
    public final List<Object> uj = new CopyOnWriteArrayList();
    public final List<Object> n = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Object> f29121a = new CopyOnWriteArrayList();
    public a sp = null;

    @Nullable
    public List<c> c(ve veVar) {
        return this.c.get(veVar);
    }

    @NonNull
    public List<Object> tt() {
        return this.uj;
    }

    @Nullable
    public a uj() {
        return this.sp;
    }

    @NonNull
    public List<Object> ve() {
        return this.f29121a;
    }

    public void c(Map<? extends String, ? extends String> map) {
        this.tt.putAll(map);
    }

    public Map<String, String> c() {
        return this.tt;
    }

    public void c(a aVar) {
        this.sp = aVar;
    }
}
