package com.huachenjie.common.webview;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class WebViewActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object target) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        WebViewActivity webViewActivity = (WebViewActivity) target;
        webViewActivity.title = webViewActivity.getIntent().getExtras() == null ? webViewActivity.title : webViewActivity.getIntent().getExtras().getString("title", webViewActivity.title);
        webViewActivity.url = webViewActivity.getIntent().getExtras() == null ? webViewActivity.url : webViewActivity.getIntent().getExtras().getString("url", webViewActivity.url);
    }
}
