package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.zj.adlib.u15;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class ak {
    @WorkerThread
    public static String a(Context context, String str, al.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String strAv = al.av(context, al.a(str, aVar));
        String strDQ = bf.dQ(context);
        if (!TextUtils.isEmpty(strDQ)) {
            strAv = strAv.replace("__MAC__", strDQ).replace("__MAC2__", an.md5(strDQ)).replace("__MAC3__", an.md5(strDQ.replace(u15.f19942b, "")));
        }
        String strDO = bf.dO(context);
        if (!TextUtils.isEmpty(strDO)) {
            strAv = strAv.replace("__IMEI__", strDO).replace("__IMEI2__", an.md5(strDO)).replace("__IMEI3__", an.sha1(strDO));
        }
        String oaid = bf.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            strAv = strAv.replace("__OAID__", oaid).replace("__OAID2__", an.md5(oaid));
        }
        String strDP = bf.dP(context);
        if (!TextUtils.isEmpty(strDP)) {
            strAv = strAv.replace("__ANDROIDID2__", an.md5(strDP)).replace("__ANDROIDID3__", an.sha1(strDP)).replace("__ANDROIDID__", strDP);
        }
        return al.d(context, strAv, z);
    }

    public static void f(AdTemplate adTemplate, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        Context context = ServiceProvider.getContext();
        if (!TextUtils.isEmpty(bf.dQ(context))) {
            if (str2.contains("__MAC__")) {
                arrayList.add("__MAC__");
            }
            if (str2.contains("__MAC2__")) {
                arrayList.add("__MAC2__");
            }
            if (str2.contains("__MAC3__")) {
                arrayList.add("__MAC3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    com.kwad.sdk.commercial.i.a.a(adTemplate, "MAC", str, str2, (String) it.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bf.dO(context))) {
            if (str2.contains("__IMEI__")) {
                arrayList.add("__IMEI__");
            }
            if (str2.contains("__IMEI2__")) {
                arrayList.add("__IMEI2__");
            }
            if (str2.contains("__IMEI3__")) {
                arrayList.add("__IMEI3__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.kwad.sdk.commercial.i.a.a(adTemplate, "IMEI", str, str2, (String) it2.next());
                }
                arrayList.clear();
            }
        }
        if (!TextUtils.isEmpty(bf.getOaid())) {
            if (str2.contains("__OAID__")) {
                arrayList.add("__OAID__");
            }
            if (str2.contains("__OAID2__")) {
                arrayList.add("__OAID2__");
            }
            if (!arrayList.isEmpty()) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    com.kwad.sdk.commercial.i.a.a(adTemplate, "OAID", str, str2, (String) it3.next());
                }
                arrayList.clear();
            }
        }
        if (TextUtils.isEmpty(bf.dP(context))) {
            return;
        }
        if (str2.contains("__ANDROIDID__")) {
            arrayList.add("__ANDROIDID__");
        }
        if (str2.contains("__ANDROIDID2__")) {
            arrayList.add("__ANDROIDID2__");
        }
        if (str2.contains("__ANDROIDID3__")) {
            arrayList.add("__ANDROIDID3__");
        }
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            com.kwad.sdk.commercial.i.a.a(adTemplate, "ANDROID", str, str2, (String) it4.next());
        }
        arrayList.clear();
    }
}
