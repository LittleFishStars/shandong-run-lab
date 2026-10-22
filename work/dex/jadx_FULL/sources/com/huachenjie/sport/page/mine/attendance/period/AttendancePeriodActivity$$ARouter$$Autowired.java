package com.huachenjie.sport.page.mine.attendance.period;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AttendancePeriodActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        AttendancePeriodActivity attendancePeriodActivity = (AttendancePeriodActivity) obj;
        attendancePeriodActivity.clockTimeData = (ClockTimeData) attendancePeriodActivity.getIntent().getParcelableExtra(UserConstants.MINE_PARAMS.i);
    }
}
