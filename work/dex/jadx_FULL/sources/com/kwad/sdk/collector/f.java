package com.kwad.sdk.collector;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.aw;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f {
    @Nullable
    public static JSONArray Ia() {
        Context context = ServiceProvider.getContext();
        List<g> listBG = bG(context);
        listBG.add(bF(context));
        return g.C(listBG);
    }

    private static g bF(Context context) {
        boolean zDK = aw.dK(context);
        com.kwad.sdk.core.d.c.d("InfoCollector", "queryAccessibilityServicePermission result: " + zDK);
        return new g(com.kuaishou.weapon.p0.g.k, zDK ? g.PERMISSION_GRANTED : g.PERMISSION_DENIED);
    }

    @NonNull
    private static List<g> bG(Context context) {
        String[] strArrDi;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (context != null && (strArrDi = aa.di(context)) != null) {
            for (String str : strArrDi) {
                int iAA = aw.aA(context, str);
                copyOnWriteArrayList.add(new g(str, iAA == 0 ? g.PERMISSION_GRANTED : iAA == -1 ? g.PERMISSION_DENIED : g.aJf));
            }
        }
        return copyOnWriteArrayList;
    }
}
