package com.zj.adlib;

import android.app.Activity;
import android.content.Intent;
import com.huachenjie.base.dsbridge_webview.interceptor.CloseInterceptor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class cf2 implements CloseInterceptor {
    @Override // com.huachenjie.base.dsbridge_webview.interceptor.CloseInterceptor
    public void a(Activity activity, JSONObject json) {
        Intent intent = new Intent();
        String strOptString = json.optString("result");
        i4a.a("close result:" + strOptString);
        intent.putExtra("result", strOptString);
        activity.setResult(-1, intent);
    }
}
