package com.huachenjie.sport.page.mine.attendance.plan;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AttendancePlanActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        AttendancePlanActivity attendancePlanActivity = (AttendancePlanActivity) obj;
        attendancePlanActivity.com.huachenjie.run.page.activities_run.DetailActivity.x java.lang.String = attendancePlanActivity.getIntent().getExtras() == null ? attendancePlanActivity.com.huachenjie.run.page.activities_run.DetailActivity.x java.lang.String : attendancePlanActivity.getIntent().getExtras().getString(UserConstants.MINE_PARAMS.j, attendancePlanActivity.com.huachenjie.run.page.activities_run.DetailActivity.x java.lang.String);
    }
}
