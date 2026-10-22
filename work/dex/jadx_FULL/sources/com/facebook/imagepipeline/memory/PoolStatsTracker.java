package com.facebook.imagepipeline.memory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface PoolStatsTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f29997a = "buckets_used_";
    public static final String b = "used_count";
    public static final String c = "used_bytes";
    public static final String d = "free_count";
    public static final String e = "free_bytes";
    public static final String f = "soft_cap";
    public static final String g = "hard_cap";

    void a(int i);

    void b();

    void c();

    void d(BasePool basePool);

    void e(int i);

    void f(int i);

    void g(int i);
}
