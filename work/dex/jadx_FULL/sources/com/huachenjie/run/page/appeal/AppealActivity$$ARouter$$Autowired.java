package com.huachenjie.run.page.appeal;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class AppealActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object target) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        AppealActivity appealActivity = (AppealActivity) target;
        appealActivity.runRecordCode = appealActivity.getIntent().getExtras() == null ? appealActivity.runRecordCode : appealActivity.getIntent().getExtras().getString("runRecordCode", appealActivity.runRecordCode);
        appealActivity.semesterCode = appealActivity.getIntent().getExtras() == null ? appealActivity.semesterCode : appealActivity.getIntent().getExtras().getString("semesterCode", appealActivity.semesterCode);
    }
}
