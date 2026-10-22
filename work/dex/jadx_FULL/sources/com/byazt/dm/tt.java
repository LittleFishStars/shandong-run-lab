package com.byazt.dm;

import android.text.TextUtils;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 204, 13})
public class tt {

    public interface c<T> {
        T tt();
    }

    public static <T> T c(boolean z, String str, @NonNull c<T> cVar) {
        try {
            return cVar.tt();
        } catch (Throwable th) {
            if (th instanceof com.byazt.dm.c) {
                throw th;
            }
            ve.c().c(z, th, str);
            if (TextUtils.isEmpty(str)) {
                throw th;
            }
            return null;
        }
    }

    public static <T> T c(c<T> cVar) {
        return (T) c(true, null, cVar);
    }

    public static void c(final Runnable runnable) {
        c(new c<Void>() { // from class: com.byazt.dm.tt.1
            @Override // com.byazt.dm.tt.c
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Void tt() {
                runnable.run();
                return null;
            }
        });
    }
}
