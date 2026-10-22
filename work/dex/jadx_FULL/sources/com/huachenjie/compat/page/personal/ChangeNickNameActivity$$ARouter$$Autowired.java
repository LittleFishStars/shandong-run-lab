package com.huachenjie.compat.page.personal;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class ChangeNickNameActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        ChangeNickNameActivity changeNickNameActivity = (ChangeNickNameActivity) obj;
        changeNickNameActivity.K = changeNickNameActivity.getIntent().getIntExtra(UserConstants.USER_PARAMS.f33739a, changeNickNameActivity.K);
        changeNickNameActivity.x = changeNickNameActivity.getIntent().getExtras() == null ? changeNickNameActivity.x : changeNickNameActivity.getIntent().getExtras().getString(UserConstants.USER_PARAMS.b, changeNickNameActivity.x);
        changeNickNameActivity.y = changeNickNameActivity.getIntent().getExtras() == null ? changeNickNameActivity.y : changeNickNameActivity.getIntent().getExtras().getString(UserConstants.USER_PARAMS.c, changeNickNameActivity.y);
    }
}
