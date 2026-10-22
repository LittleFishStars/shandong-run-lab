package com.huachenjie.compat.page.account;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class CancelAccountSubmitActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        CancelAccountSubmitActivity cancelAccountSubmitActivity = (CancelAccountSubmitActivity) obj;
        cancelAccountSubmitActivity.ticket = cancelAccountSubmitActivity.getIntent().getExtras() == null ? cancelAccountSubmitActivity.ticket : cancelAccountSubmitActivity.getIntent().getExtras().getString(UserConstants.MINE_PARAMS.b, cancelAccountSubmitActivity.ticket);
        cancelAccountSubmitActivity.com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE java.lang.String = cancelAccountSubmitActivity.getIntent().getExtras() == null ? cancelAccountSubmitActivity.com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE java.lang.String : cancelAccountSubmitActivity.getIntent().getExtras().getString(UserConstants.MINE_PARAMS.c, cancelAccountSubmitActivity.com.aliyun.vod.log.core.AliyunLogCommon.TERMINAL_TYPE java.lang.String);
    }
}
