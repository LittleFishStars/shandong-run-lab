package com.beizi.fusion;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class dg implements dp {
    private static final dp c;
    private static final dp d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a6 f27175a;
    private final ConcurrentMap b = new ConcurrentHashMap();

    public static class a implements dp {
        private a() {
        }
    }

    static {
        c = new a();
        d = new a();
    }

    public dg(a6 a6Var) {
        this.f27175a = a6Var;
    }
}
