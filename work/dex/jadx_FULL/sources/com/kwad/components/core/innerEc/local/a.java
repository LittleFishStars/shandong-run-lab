package com.kwad.components.core.innerEc.local;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.b;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static final CancelInfo aaE = new CancelInfo();

    private static void aO(AdTemplate adTemplate) {
        AdTemplate.isInnerEcCancelDowngrade = !bo(b.ey(adTemplate));
    }

    public static void aQ(String str) {
        c.d("LoginLocalCounter", "onAuthSuccess: " + str);
        aaE.reset();
    }

    public static boolean bo(int i) {
        c.d("LoginLocalCounter", "checkEnableInnerEc maxCount: " + i);
        return i <= 0 || aaE.getCancelCount() < i;
    }

    public static void f(AdTemplate adTemplate, String str) {
        c.d("LoginLocalCounter", "onAuthFail: " + str);
        aaE.checkAndAdd();
        aO(adTemplate);
    }

    public static void g(AdTemplate adTemplate, String str) {
        c.d("LoginLocalCounter", "onAuthCancel: " + str);
        aaE.checkAndAdd();
        aO(adTemplate);
    }

    public static int getCancelCount() {
        return aaE.getCancelCount();
    }
}
