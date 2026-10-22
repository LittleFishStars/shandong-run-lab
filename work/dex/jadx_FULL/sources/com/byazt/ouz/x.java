package com.byazt.ouz;

import com.byazt.omf.d;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 71})
public class x {
    public static void c(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        d jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.tt("notifyAdClicked", (JSONObject) null);
        }
        com.byazt.atv.sp uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.c("notifyAdClicked", (Map<String, String>) null);
        }
    }
}
