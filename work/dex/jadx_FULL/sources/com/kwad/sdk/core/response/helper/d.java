package com.kwad.sdk.core.response.helper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    public static long eA(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eE(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String eB(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : eE(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String eC(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : eE(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean eD(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && e.eG(adTemplate)) {
            return eE(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    private static AdStyleInfo eE(@NonNull AdTemplate adTemplate) {
        return e.eO(adTemplate).adStyleInfo;
    }

    public static List<String> eF(@NonNull AdTemplate adTemplate) {
        AdStyleInfo adStyleInfoEE = eE(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = adStyleInfoEE.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
