package com.zj.adlib;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class as1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<yc9> f40599a = new ArrayList();

    public void a(yc9 yc9Var) {
        this.f40599a.add(yc9Var);
    }

    public void b(Path path) {
        for (int size = this.f40599a.size() - 1; size >= 0; size--) {
            vj9.b(path, this.f40599a.get(size));
        }
    }
}
