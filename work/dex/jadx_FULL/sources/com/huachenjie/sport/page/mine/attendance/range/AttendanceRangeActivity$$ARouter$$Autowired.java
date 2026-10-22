package com.huachenjie.sport.page.mine.attendance.range;

import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.ISyringe;
import com.alibaba.android.arouter.launcher.ARouter;
import com.huachenjie.common.constants.UserConstants;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AttendanceRangeActivity$$ARouter$$Autowired implements ISyringe {
    private SerializationService serializationService;

    @Override // com.alibaba.android.arouter.facade.template.ISyringe
    public void inject(Object obj) {
        this.serializationService = (SerializationService) ARouter.getInstance().navigation(SerializationService.class);
        AttendanceRangeActivity attendanceRangeActivity = (AttendanceRangeActivity) obj;
        attendanceRangeActivity.locationRangeList = (ArrayList) attendanceRangeActivity.getIntent().getSerializableExtra(UserConstants.MINE_PARAMS.o);
    }
}
