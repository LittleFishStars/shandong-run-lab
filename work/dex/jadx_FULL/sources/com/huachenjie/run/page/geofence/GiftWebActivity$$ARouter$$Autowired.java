package com.huachenjie.run.page.geofence;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class GiftWebActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object target) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        GiftWebActivity giftWebActivity = (GiftWebActivity) target;
        giftWebActivity.title = giftWebActivity.getIntent().getExtras() == null ? giftWebActivity.title : giftWebActivity.getIntent().getExtras().getString("title", giftWebActivity.title);
        giftWebActivity.url = giftWebActivity.getIntent().getExtras() == null ? giftWebActivity.url : giftWebActivity.getIntent().getExtras().getString("url", giftWebActivity.url);
    }
}
