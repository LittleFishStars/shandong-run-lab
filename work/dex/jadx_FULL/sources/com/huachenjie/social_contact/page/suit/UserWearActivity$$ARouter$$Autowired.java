package com.huachenjie.social_contact.page.suit;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class UserWearActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        UserWearActivity userWearActivity = (UserWearActivity) obj;
        userWearActivity.mWearType = userWearActivity.getIntent().getIntExtra(UserConstants.SOCIAL_CONTACT_PARAMS.b, userWearActivity.mWearType);
    }
}
