package com.byazt.zb;

import android.os.Build;
import com.zj.adlib.ou9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 184, 42})
public class i {
    public static void c(com.byazt.nl.uj ujVar) {
        tt(ujVar);
        try {
            ujVar.setJavaScriptEnabled(true);
            ujVar.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            sp.c(ou9.c, "setJavaScriptEnabled error", th);
        }
        try {
            ujVar.setSupportZoom(false);
        } catch (Throwable th2) {
            sp.c(ou9.c, "setSupportZoom error", th2);
        }
        ujVar.setLoadWithOverviewMode(true);
        ujVar.setUseWideViewPort(true);
        ujVar.setDomStorageEnabled(true);
        ujVar.setAllowFileAccess(false);
        ujVar.setBlockNetworkImage(false);
        ujVar.setDisplayZoomControls(false);
        int i = Build.VERSION.SDK_INT;
        ujVar.setAllowFileAccessFromFileURLs(false);
        ujVar.setAllowUniversalAccessFromFileURLs(false);
        ujVar.setSavePassword(false);
        boolean z = i >= 28;
        try {
            if (z) {
                if (z) {
                    ujVar.setLayerType(2, null);
                }
                ujVar.setMixedContentMode(0);
            }
            ujVar.setLayerType(0, null);
        } catch (Throwable th3) {
            sp.c(ou9.c, "setLayerType error", th3);
        }
        ujVar.setMixedContentMode(0);
    }

    private static void tt(com.byazt.nl.uj ujVar) {
        try {
            ujVar.removeJavascriptInterface("searchBoxJavaBridge_");
            ujVar.removeJavascriptInterface("accessibility");
            ujVar.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            sp.c(ou9.c, "removeJavascriptInterfacesSafe error", th);
        }
    }
}
