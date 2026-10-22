package com.kwad.sdk.core.local;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.request.model.f;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {
    private static volatile a aSN;
    public static ThreadLocal<SimpleDateFormat> aSO = new ThreadLocal<SimpleDateFormat>() { // from class: com.kwad.sdk.core.local.a.1
        @Nullable
        private static SimpleDateFormat Md() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override // java.lang.ThreadLocal
        @Nullable
        public final /* synthetic */ SimpleDateFormat initialValue() {
            return Md();
        }
    };

    public static a LY() {
        if (aSN == null) {
            synchronized (a.class) {
                if (aSN == null) {
                    aSN = new a();
                }
            }
        }
        return aSN;
    }

    public static boolean LZ() {
        List<f> listEw = ew(15);
        if (listEw.size() == 0) {
            return true;
        }
        long j = -1;
        int i = 0;
        for (f fVar : listEw) {
            i += fVar.count;
            long j2 = fVar.aXx;
            if (j2 > j) {
                j = j2;
            }
        }
        c.d("AdCounter", "onBind localCountCheck: allCount: " + i + ", lastShowTime: " + j);
        if (i > Mb()) {
            return false;
        }
        return j + (Mc() * 1000) <= System.currentTimeMillis();
    }

    public static List<f> Ma() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String string = getString("ksadsdk_local_ad_task_info_adstyle_data");
        ArrayList<f> arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                f fVar = new f();
                fVar.parseJson(jSONObject);
                arrayList.add(fVar);
            }
        } catch (Exception unused) {
        }
        ArrayList arrayList2 = new ArrayList();
        for (f fVar2 : arrayList) {
            if (a(fVar2)) {
                arrayList2.add(fVar2);
            }
        }
        return arrayList2;
    }

    private static int Mb() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 30;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getInt("reward_aggregation_max_per_day", 30);
    }

    private static long Mc() {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return 1200L;
        }
        return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getLong("reward_aggregation_min_interval", 1200L);
    }

    private static void T(String str, String str2) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putString(str, str2).apply();
    }

    private static boolean a(@NonNull f fVar) {
        long j = fVar.aXx;
        if (j <= 0) {
            return false;
        }
        SimpleDateFormat simpleDateFormat = aSO.get();
        return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date()));
    }

    public static void cG(AdTemplate adTemplate) {
        if (adTemplate.watched) {
            c.d("AdCounter", "startWatchAd this ad has been watched.");
        } else {
            cH(adTemplate);
        }
    }

    private static void cH(AdTemplate adTemplate) {
        boolean z;
        int iEW = e.eW(adTemplate);
        int iEI = e.eI(adTemplate);
        List listMa = Ma();
        if (listMa == null || listMa.size() == 0) {
            listMa = new ArrayList();
            listMa.add(new f(iEI, iEW, 1, System.currentTimeMillis()));
        } else {
            Iterator it = listMa.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                f fVar = (f) it.next();
                if (fVar.adStyle == iEI && fVar.taskType == iEW) {
                    fVar.count++;
                    if (!a(fVar)) {
                        fVar.count = 1;
                        fVar.aL(System.currentTimeMillis());
                    }
                    z = true;
                    break;
                }
            }
            if (!z) {
                listMa.add(new f(iEI, iEW, 1, System.currentTimeMillis()));
            }
        }
        T("ksadsdk_local_ad_task_info_adstyle_data", ac.Y(listMa).toString());
        adTemplate.watched = true;
    }

    @NonNull
    private static List<f> ew(int i) {
        ArrayList arrayList = new ArrayList();
        List<f> listMa = Ma();
        if (listMa != null && listMa.size() != 0) {
            for (f fVar : listMa) {
                if (15 == fVar.adStyle) {
                    arrayList.add(fVar);
                }
            }
        }
        return arrayList;
    }

    public static void g(int i, long j) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).edit().putInt("reward_aggregation_max_per_day", i).putLong("reward_aggregation_min_interval", j).apply();
    }

    private static String getString(String str) {
        Context context = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext();
        if (context == null) {
            return null;
        }
        try {
            return context.getSharedPreferences("ksadsdk_local_ad_task_info", 0).getString(str, null);
        } catch (Throwable th) {
            c.printStackTrace(th);
            return null;
        }
    }
}
