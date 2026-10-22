package androidx.room.util;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SneakyThrow {
    private SneakyThrow() {
    }

    public static void reThrow(@NonNull Exception e) throws Throwable {
        sneakyThrow(e);
    }

    private static <E extends Throwable> void sneakyThrow(@NonNull Throwable e) throws Throwable {
        throw e;
    }
}
