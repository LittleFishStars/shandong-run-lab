package com.kwad.library.solder.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.library.solder.lib.b.c;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static void a(Context context, @NonNull b bVar, com.kwad.library.solder.lib.ext.b.c cVar) {
        i.DQ().a(context, new c(bVar), cVar);
    }

    public static com.kwad.library.b.a n(Context context, String str) {
        com.kwad.library.solder.lib.a.a aVarP = i.DQ().p(context, str);
        if (aVarP != null && aVarP.isLoaded() && (aVarP instanceof com.kwad.library.b.a)) {
            return (com.kwad.library.b.a) aVarP;
        }
        return null;
    }

    public static void o(Context context, String str) {
        i.DQ().o(context, str);
    }

    public static void a(Context context, @NonNull b bVar, com.kwad.library.solder.lib.ext.b.a aVar) {
        i.DQ().a(context, new com.kwad.library.solder.lib.b.a(bVar), aVar);
    }
}
