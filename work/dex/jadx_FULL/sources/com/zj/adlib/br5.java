package com.zj.adlib;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.moduleinstall.InstallStatusListener;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class br5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final InstallStatusListener f40821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f15622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Executor f15623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15624a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public InstallStatusListener f40822a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public Executor f15626a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List f15625a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f15627a = true;

        @NonNull
        @CanIgnoreReturnValue
        public a a(@NonNull OptionalModuleApi optionalModuleApi) {
            this.f15625a.add(optionalModuleApi);
            return this;
        }

        @NonNull
        public br5 b() {
            return new br5(this.f15625a, this.f40822a, this.f15626a, this.f15627a, null);
        }

        @NonNull
        public a c(@NonNull InstallStatusListener installStatusListener) {
            return d(installStatusListener, null);
        }

        @NonNull
        @CanIgnoreReturnValue
        public a d(@NonNull InstallStatusListener installStatusListener, @Nullable Executor executor) {
            this.f40822a = installStatusListener;
            this.f15626a = executor;
            return this;
        }
    }

    public /* synthetic */ br5(List list, InstallStatusListener installStatusListener, Executor executor, boolean z, c2c c2cVar) {
        yw6.m(list, "APIs must not be null.");
        yw6.b(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            yw6.m(installStatusListener, "Listener must not be null when listener executor is set.");
        }
        this.f15622a = list;
        this.f40821a = installStatusListener;
        this.f15623a = executor;
        this.f15624a = z;
    }

    @NonNull
    public static a d() {
        return new a();
    }

    @NonNull
    public List<OptionalModuleApi> a() {
        return this.f15622a;
    }

    @Nullable
    public InstallStatusListener b() {
        return this.f40821a;
    }

    @Nullable
    public Executor c() {
        return this.f15623a;
    }

    @ShowFirstParty
    public final boolean e() {
        return this.f15624a;
    }
}
