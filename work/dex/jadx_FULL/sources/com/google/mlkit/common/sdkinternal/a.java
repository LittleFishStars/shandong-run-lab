package com.google.mlkit.common.sdkinternal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.mlkit_common.zzle;
import com.google.android.gms.internal.mlkit_common.zzln;
import com.zj.adlib.hnd;
import com.zj.adlib.iod;
import com.zj.adlib.qcd;
import com.zj.adlib.rbd;
import com.zj.adlib.snd;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class a implements Closeable {

    @KeepForSdk
    public static final int K = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cleaner.Cleanable f32455a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicBoolean f6626a = new AtomicBoolean();
    public final String f;

    /* JADX INFO: renamed from: com.google.mlkit.common.sdkinternal.a$a, reason: collision with other inner class name */
    @KeepForSdk
    public static class C0763a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Cleaner f32456a;

        public C0763a(@NonNull Cleaner cleaner) {
            this.f32456a = cleaner;
        }

        @NonNull
        @KeepForSdk
        public a a(@NonNull Object obj, int i, @NonNull Runnable runnable) {
            return new a(obj, i, this.f32456a, runnable, iod.b("common"));
        }
    }

    public a(Object obj, final int i, Cleaner cleaner, final Runnable runnable, final hnd hndVar) {
        this.f = obj.toString();
        this.f32455a = cleaner.b(obj, new Runnable() { // from class: com.zj.adlib.elc
            @Override // java.lang.Runnable
            public final void run() {
                this.f41467a.a(i, hndVar, runnable);
            }
        });
    }

    public final /* synthetic */ void a(int i, hnd hndVar, Runnable runnable) {
        if (!this.f6626a.get()) {
            Log.e("MlKitCloseGuard", String.format(Locale.ENGLISH, "%s has not been closed", this.f));
            qcd qcdVar = new qcd();
            rbd rbdVar = new rbd();
            rbdVar.b(zzle.zzb(i));
            qcdVar.h(rbdVar.c());
            hndVar.d(snd.f(qcdVar), zzln.HANDLE_LEAKED);
        }
        runnable.run();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6626a.set(true);
        this.f32455a.clean();
    }
}
