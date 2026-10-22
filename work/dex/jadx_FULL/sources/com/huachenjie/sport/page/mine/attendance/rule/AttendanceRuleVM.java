package com.huachenjie.sport.page.mine.attendance.rule;

import androidx.p002lifecycle.MutableLiveData;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.OutsideAttendanceRule;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\n8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\f\u0010\u000fR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\n8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0014\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "outsideConfigCode", "", "j", "Lcom/zj/adlib/gq1;", "a", "Lcom/zj/adlib/gq1;", "commonModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleAdapter;", "mAdapter", "Lcom/huachenjie/common/bean/OutsideAttendanceRule;", y6b.g, "attendanceRule", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendanceRuleVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final gq1 commonModel = new gq1();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AttendanceRuleAdapter> mAdapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<OutsideAttendanceRule> attendanceRule = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/common/bean/OutsideAttendanceRule;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<OutsideAttendanceRule> {
        public a() {
            super(AttendanceRuleVM.this, true);
        }

        public void onCCSuccess(@Nullable OutsideAttendanceRule data) {
            if (data != null) {
                AttendanceRuleVM attendanceRuleVM = AttendanceRuleVM.this;
                attendanceRuleVM.h().setValue(data);
                AttendanceRuleAdapter value = attendanceRuleVM.i().getValue();
                if (value != null) {
                    value.setList(data.getSignPeriodList());
                }
            }
        }
    }

    @NotNull
    public final MutableLiveData<OutsideAttendanceRule> h() {
        return this.attendanceRule;
    }

    @NotNull
    public final MutableLiveData<AttendanceRuleAdapter> i() {
        return this.mAdapter;
    }

    public final void j(@NotNull String outsideConfigCode) {
        Intrinsics.checkNotNullParameter(outsideConfigCode, "outsideConfigCode");
        n76.e(this, this.commonModel.o(outsideConfigCode)).p5(new a());
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> k() {
        return this.titleBean;
    }
}
