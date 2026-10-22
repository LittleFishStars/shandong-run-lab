package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i) {
        android.os.Trace.beginAsyncSection(str, i);
    }

    public static void endAsyncSection(@NonNull String str, int i) {
        android.os.Trace.endAsyncSection(str, i);
    }

    public static void setCounter(@NonNull String str, int i) {
        android.os.Trace.setCounter(str, i);
    }
}
