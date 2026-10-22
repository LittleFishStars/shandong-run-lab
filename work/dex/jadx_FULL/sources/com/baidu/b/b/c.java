package com.baidu.b.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f26266a;
    private Map b = new HashMap();

    public interface a {
        List a();
    }

    public c(a aVar) {
        this.f26266a = aVar;
        for (com.baidu.b.b.a aVar2 : aVar.a()) {
            this.b.put(aVar2.a(), aVar2);
        }
    }

    public List a() {
        return new ArrayList(this.b.values());
    }
}
