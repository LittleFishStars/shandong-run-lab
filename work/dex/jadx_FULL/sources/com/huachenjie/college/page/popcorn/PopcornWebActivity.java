package com.huachenjie.college.page.popcorn;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.webview.WebViewActivity;
import com.zj.adlib.sh9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class PopcornWebActivity extends WebViewActivity<PopcornWebVm> {
    public static final String z = "android";

    @Override // com.huachenjie.common.webview.WebViewActivity
    public void l0(@NonNull WebView webView) {
        webView.addJavascriptInterface(new PopcornJavascriptApi(this, webView, sh9.f(this.url, "token")), "android");
    }

    public void x0(String str, long j, long j2, String str2) {
        ((PopcornWebVm) ((BaseVmActivity) this).f8507a).i(str, j, j2, str2);
    }
}
