package com.huachenjie.social_contact.page;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.bean.PayBean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class PayActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        PayActivity payActivity = (PayActivity) obj;
        payActivity.com.huachenjie.common.constants.UserConstants.SOCIAL_CONTACT_PARAMS.a java.lang.String = (PayBean) payActivity.getIntent().getParcelableExtra(UserConstants.SOCIAL_CONTACT_PARAMS.f33737a);
    }
}
