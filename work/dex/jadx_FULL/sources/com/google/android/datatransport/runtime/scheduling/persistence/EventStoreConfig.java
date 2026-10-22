package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@AutoValue
abstract class EventStoreConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30444a = 200;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f1952a = 10485760;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final EventStoreConfig f1953a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();
    public static final int b = 10000;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f1954b = 604800000;
    public static final int c = 81920;

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract EventStoreConfig a();

        public abstract Builder b(int i);

        public abstract Builder c(long j);

        public abstract Builder d(int i);

        public abstract Builder e(int i);

        public abstract Builder f(long j);
    }

    public static Builder a() {
        return new a.b();
    }

    public abstract int b();

    public abstract long c();

    public abstract int d();

    public abstract int e();

    public abstract long f();

    public Builder g() {
        return a().f(f()).d(d()).b(b()).c(c()).e(e());
    }
}
