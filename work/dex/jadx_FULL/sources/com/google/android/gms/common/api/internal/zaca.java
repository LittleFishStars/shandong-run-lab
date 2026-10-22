package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface zaca {
    ConnectionResult a(long j, TimeUnit timeUnit);

    boolean b();

    boolean c();

    void d(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr);

    @Nullable
    ConnectionResult e(@NonNull Api api);

    BaseImplementation.ApiMethodImpl f(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl);

    BaseImplementation.ApiMethodImpl g(@NonNull BaseImplementation.ApiMethodImpl apiMethodImpl);

    boolean h(SignInConnectionListener signInConnectionListener);

    void j();

    void k();

    void l();

    ConnectionResult m();

    void n();
}
