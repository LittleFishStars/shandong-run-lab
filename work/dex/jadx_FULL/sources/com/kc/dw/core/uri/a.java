package com.kc.dw.core.uri;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.kc.dw.activity.SsdWebviewActivity;
import com.kc.dw.core.ad.AdSlot;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements b {
    @Override // com.kc.dw.core.uri.b
    public boolean a(Context context, Uri uri, AdSlot adSlot) {
        if (!uri.getScheme().startsWith("http")) {
            return false;
        }
        Class<? extends Activity> clsWebViewActivity = com.kc.dw.base.a.adConfig() != null ? com.kc.dw.base.a.adConfig().webViewActivity() : null;
        if (clsWebViewActivity == null) {
            clsWebViewActivity = SsdWebviewActivity.class;
        }
        Intent intent = new Intent(context, clsWebViewActivity);
        intent.putExtra("EXTRA_AD_DURL_KEY", new String[]{uri.toString()});
        if (adSlot.getClickUrl() != null) {
            for (String str : adSlot.getClickUrl()) {
                try {
                    Uri uri2 = Uri.parse(str);
                    if (uri2.getHost() != null && "dsp.1rtb.com".equals(uri2.getHost())) {
                        String strSubstring = null;
                        String strSubstring2 = null;
                        for (String str2 : new String(Base64.decode(uri2.getQueryParameter("ext_data"), 3)).split(",")) {
                            if (str2.startsWith("amid=")) {
                                strSubstring = str2.substring(5);
                            } else if (str2.startsWith("uuid=")) {
                                strSubstring2 = str2.substring(5);
                            }
                        }
                        if (!TextUtils.isEmpty(strSubstring)) {
                            intent.putExtra("EXTRA_AD_AMID_KEY", strSubstring);
                            if (!TextUtils.isEmpty(strSubstring2)) {
                                intent.putExtra("EXTRA_AD_UUID_KEY", strSubstring2);
                                break;
                            }
                            break;
                        }
                        continue;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        return true;
    }
}
