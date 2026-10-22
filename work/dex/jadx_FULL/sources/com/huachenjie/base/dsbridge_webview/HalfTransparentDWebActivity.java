package com.huachenjie.base.dsbridge_webview;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014¨\u0006\u0005"}, d2 = {"Lcom/huachenjie/base/dsbridge_webview/HalfTransparentDWebActivity;", "Lcom/huachenjie/base/dsbridge_webview/PayWebViewActivity;", "()V", "initView", "", "base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HalfTransparentDWebActivity extends PayWebViewActivity {
    @Override // com.huachenjie.base.dsbridge_webview.DWebViewActivity, com.huachenjie.common.base.BaseActivity
    public void initView() {
        super.initView();
        ((DWebViewActivity) this).f7185a.getWebView().setBackgroundColor(0);
        Drawable background = ((DWebViewActivity) this).f7185a.getWebView().getBackground();
        if (background == null) {
            return;
        }
        background.setAlpha(0);
    }
}
