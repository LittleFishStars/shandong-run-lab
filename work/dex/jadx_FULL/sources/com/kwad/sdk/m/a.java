package com.kwad.sdk.m;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ai;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public final class a {
    public static final String TAG = "Ranger_" + c.class.getSimpleName();

    public static void a(@NonNull d dVar) {
        final List<d.a> list = dVar.bmR;
        if (list == null || list.isEmpty()) {
            return;
        }
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.m.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityCreated */
            public final void a(Activity activity, Bundle bundle) {
                super.a(activity, bundle);
                try {
                    a.a(activity, list);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.e(a.TAG, Log.getStackTraceString(th));
                }
            }
        });
    }

    private static String e(Object obj, String str) {
        Object field;
        return (TextUtils.isEmpty(str) || (field = ab.getField(obj, str)) == null) ? "" : field.getClass().getName();
    }

    public static void a(Activity activity, @NonNull List<d.a> list) {
        try {
            for (d.a aVar : list) {
                if (aVar != null) {
                    String strE = "";
                    if (TextUtils.equals(activity.getClass().getName(), aVar.bmT)) {
                        strE = aVar.bmT;
                    } else if (!TextUtils.isEmpty(aVar.bmU) && activity.getClass().getName().startsWith(aVar.bmT)) {
                        strE = e(activity, aVar.bmU);
                    }
                    if (!TextUtils.isEmpty(strE)) {
                        int iB = ai.b("ksadsdk_perf_ranger_v2", strE, 0) + 1;
                        ai.a("ksadsdk_perf_ranger_v2", strE, iB);
                        com.kwad.sdk.core.d.c.d(TAG, "act:" + strE + " num:" + iB);
                    }
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.e(TAG, "record:" + Log.getStackTraceString(th));
        }
    }
}
