package com.huachenjie.social_contact.page;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class SuperPackActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        SuperPackActivity superPackActivity = (SuperPackActivity) obj;
        superPackActivity.packCode = superPackActivity.getIntent().getExtras() == null ? superPackActivity.packCode : superPackActivity.getIntent().getExtras().getString(UserConstants.SOCIAL_CONTACT_PARAMS.c, superPackActivity.packCode);
    }
}
