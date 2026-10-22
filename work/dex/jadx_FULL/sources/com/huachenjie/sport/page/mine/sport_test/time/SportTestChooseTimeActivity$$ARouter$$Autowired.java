package com.huachenjie.sport.page.mine.sport_test.time;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class SportTestChooseTimeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        SportTestChooseTimeActivity sportTestChooseTimeActivity = (SportTestChooseTimeActivity) obj;
        sportTestChooseTimeActivity.testCode = sportTestChooseTimeActivity.getIntent().getExtras() == null ? sportTestChooseTimeActivity.testCode : sportTestChooseTimeActivity.getIntent().getExtras().getString("testCode", sportTestChooseTimeActivity.testCode);
        sportTestChooseTimeActivity.yearCode = sportTestChooseTimeActivity.getIntent().getExtras() == null ? sportTestChooseTimeActivity.yearCode : sportTestChooseTimeActivity.getIntent().getExtras().getString("yearCode", sportTestChooseTimeActivity.yearCode);
        sportTestChooseTimeActivity.dayCode = sportTestChooseTimeActivity.getIntent().getExtras() == null ? sportTestChooseTimeActivity.dayCode : sportTestChooseTimeActivity.getIntent().getExtras().getString("dayCode", sportTestChooseTimeActivity.dayCode);
        sportTestChooseTimeActivity.timeCode = sportTestChooseTimeActivity.getIntent().getExtras() == null ? sportTestChooseTimeActivity.timeCode : sportTestChooseTimeActivity.getIntent().getExtras().getString("timeCode", sportTestChooseTimeActivity.timeCode);
    }
}
