package com.ipd.dsp.internal.q0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class c extends com.ipd.dsp.internal.q0.a {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38521a;

        static {
            int[] iArr = new int[com.ipd.dsp.internal.i0.a.values().length];
            f38521a = iArr;
            try {
                iArr[com.ipd.dsp.internal.i0.a.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38521a[com.ipd.dsp.internal.i0.a.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38521a[com.ipd.dsp.internal.i0.a.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38521a[com.ipd.dsp.internal.i0.a.PRE_ALLOCATE_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f38521a[com.ipd.dsp.internal.i0.a.FILE_BUSY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f38521a[com.ipd.dsp.internal.i0.a.SAME_TASK_BUSY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public abstract void canceled(@NonNull com.ipd.dsp.internal.f0.f fVar);

    public abstract void completed(@NonNull com.ipd.dsp.internal.f0.f fVar);

    public abstract void error(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull Exception exc);

    public abstract void started(@NonNull com.ipd.dsp.internal.f0.f fVar);

    @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
    public void taskEnd(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc, @NonNull com.ipd.dsp.internal.r0.a.b bVar) {
        switch (a.f38521a[aVar.ordinal()]) {
            case 1:
                completed(fVar);
                break;
            case 2:
                canceled(fVar);
                break;
            case 3:
            case 4:
                error(fVar, exc);
                break;
            case 5:
            case 6:
                warn(fVar);
                break;
            default:
                com.ipd.dsp.internal.g0.c.c("DownloadListener3", "Don't support " + aVar);
                break;
        }
    }

    @Override // com.ipd.dsp.internal.r0.a.InterfaceC0914a
    public final void taskStart(@NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.r0.a.b bVar) {
        started(fVar);
    }

    public abstract void warn(@NonNull com.ipd.dsp.internal.f0.f fVar);
}
