package com.kwad.sdk.utils;

import android.view.MotionEvent;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class b {
    public static boolean a(al.a aVar, List<Integer> list) {
        int iAbs = Math.abs(aVar.VE() - aVar.VG());
        int iAbs2 = Math.abs(aVar.VF() - aVar.VH());
        if (list == null || list.isEmpty() || list.size() < 2) {
            return iAbs > 20 || iAbs2 > 20;
        }
        int iAtan2 = (int) ((Math.atan2(iAbs2, iAbs) * 180.0d) / 3.141592653589793d);
        return iAtan2 > list.get(0).intValue() && iAtan2 < list.get(1).intValue();
    }

    public static boolean g(al.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (Math.abs(aVar.VG() - aVar.VE()) > 20) || (Math.abs(aVar.VH() - aVar.VF()) > 20);
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, AdTemplate adTemplate) {
        boolean z = false;
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        float fAbs = Math.abs(motionEvent2.getRawX() - motionEvent.getRawX());
        float fAbs2 = Math.abs(motionEvent2.getRawY() - motionEvent.getRawY());
        List<Integer> listX = com.kwad.sdk.core.response.helper.a.X(adInfoEO);
        if (listX == null || listX.isEmpty() || listX.size() < 2) {
            return fAbs > 20.0f || fAbs2 > 20.0f;
        }
        int iAtan2 = (int) ((Math.atan2(fAbs2, fAbs) * 180.0d) / 3.141592653589793d);
        if (iAtan2 > listX.get(0).intValue() && iAtan2 < listX.get(1).intValue()) {
            z = true;
        }
        if (z) {
            adTemplate.swipeAngle = iAtan2;
        }
        return z;
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        return ((Math.abs(motionEvent2.getX() - motionEvent.getX()) > 20.0f ? 1 : (Math.abs(motionEvent2.getX() - motionEvent.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent2.getY() - motionEvent.getY()) > 20.0f ? 1 : (Math.abs(motionEvent2.getY() - motionEvent.getY()) == 20.0f ? 0 : -1)) > 0);
    }
}
