package com.huachenjie.sport.page.mine.attendance.period;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.ClockTimeData;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0005\u001a\u0004\b\u0004\u0010\u0007R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/period/AttendancePeriodVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "j", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/page/mine/attendance/period/AttendancePeriodAdapter;", "mAdapter", "Lcom/huachenjie/common/bean/ClockTimeData;", "k", y6b.g, "clockTimeData", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePeriodVM extends BaseVM {

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AttendancePeriodAdapter> mAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClockTimeData> clockTimeData = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<ClockTimeData> h() {
        return this.clockTimeData;
    }

    @NotNull
    public final MutableLiveData<AttendancePeriodAdapter> i() {
        return this.mAdapter;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> j() {
        return this.titleBean;
    }
}
