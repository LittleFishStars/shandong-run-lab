package com.huachenjie.sport.page.mine.attendance.photo;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AttendancePhotoActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        AttendancePhotoActivity attendancePhotoActivity = (AttendancePhotoActivity) obj;
        attendancePhotoActivity.clockTimeData = (ClockTimeData) attendancePhotoActivity.getIntent().getParcelableExtra(UserConstants.MINE_PARAMS.i);
        attendancePhotoActivity.code = attendancePhotoActivity.getIntent().getExtras() == null ? attendancePhotoActivity.code : attendancePhotoActivity.getIntent().getExtras().getString(UserConstants.MINE_PARAMS.k, attendancePhotoActivity.code);
    }
}
