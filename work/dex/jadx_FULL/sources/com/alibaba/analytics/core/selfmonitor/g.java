package com.alibaba.analytics.core.selfmonitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f23787a;
    private List<h> f = Collections.synchronizedList(new ArrayList());

    public void a(h hVar) {
        this.f.add(hVar);
    }

    public void a(f fVar) {
        h hVar = f23787a;
        if (hVar != null) {
            hVar.a(fVar);
        }
        for (int i = 0; i < this.f.size(); i++) {
            this.f.get(i).a(fVar);
        }
    }
}
