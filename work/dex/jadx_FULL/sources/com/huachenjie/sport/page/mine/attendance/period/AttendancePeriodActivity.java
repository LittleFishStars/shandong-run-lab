package com.huachenjie.sport.page.mine.attendance.period;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.basic.api.RequestPermission;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.ClockTime;
import com.huachenjie.common.bean.ClockTimeData;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.period.AttendancePeriodActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.u)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\"\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0007H\u0002R\u001a\u0010\u0015\u001a\u00020\n8\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/period/AttendancePeriodActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/attendance/period/AttendancePeriodVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "j0", "K", "I", "h0", "()I", "CODE_REQUEST_PHOTO", "Lcom/huachenjie/common/bean/ClockTimeData;", "a", "Lcom/huachenjie/common/bean/ClockTimeData;", "clockTimeData", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePeriodActivity extends BaseVmActivity<AttendancePeriodVM> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public final int CODE_REQUEST_PHOTO = 1002;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.i)
    @JvmField
    @Nullable
    public ClockTimeData clockTimeData;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/period/AttendancePeriodActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/attendance/period/AttendancePeriodActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            AttendancePeriodActivity.this.finish();
        }
    }

    public static final void i0(AttendancePeriodAdapter attendancePeriodAdapter, ClockTimeData clockTimeData, AttendancePeriodActivity attendancePeriodActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(attendancePeriodAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(clockTimeData, "$data");
        Intrinsics.checkNotNullParameter(attendancePeriodActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        ClockTime clockTime = attendancePeriodAdapter.getData().get(i);
        if (clockTime.getStartTimeStatus() == 2 || clockTime.getEndTimeStatus() == 2) {
            attendancePeriodAdapter.h(i);
            if (clockTimeData.getImgFlag()) {
                ARouter.getInstance().build(RoutePathConstants.Sport.v).withParcelable(UserConstants.MINE_PARAMS.i, attendancePeriodActivity.clockTimeData).withString(UserConstants.MINE_PARAMS.k, clockTime.getTimeFrameCode()).navigation(attendancePeriodActivity, attendancePeriodActivity.CODE_REQUEST_PHOTO);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(UserConstants.MINE_PARAMS.j, clockTimeData.getOutsideConfigCode());
            intent.putExtra(UserConstants.MINE_PARAMS.k, clockTime.getTimeFrameCode());
            intent.putExtra(UserConstants.MINE_PARAMS.m, clockTimeData.getLng());
            intent.putExtra(UserConstants.MINE_PARAMS.n, clockTimeData.getLat());
            attendancePeriodActivity.setResult(-1, intent);
            attendancePeriodActivity.finish();
        }
    }

    public static final void k0(AttendancePeriodActivity attendancePeriodActivity, View view) {
        Intrinsics.checkNotNullParameter(attendancePeriodActivity, "this$0");
        attendancePeriodActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_attendance_period), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    /* JADX INFO: renamed from: h0, reason: from getter */
    public final int getCODE_REQUEST_PHOTO() {
        return this.CODE_REQUEST_PHOTO;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        final AttendancePeriodAdapter value;
        j0();
        ((AttendancePeriodVM) ((BaseVmActivity) this).f8507a).i().setValue(new AttendancePeriodAdapter());
        final ClockTimeData clockTimeData = this.clockTimeData;
        if (clockTimeData != null && (value = ((AttendancePeriodVM) ((BaseVmActivity) this).f8507a).i().getValue()) != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.qc0
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    AttendancePeriodActivity.i0(value, clockTimeData, this, baseQuickAdapter, view, i);
                }
            });
            value.setList(clockTimeData.getClockTimeList());
        }
        ((AttendancePeriodVM) ((BaseVmActivity) this).f8507a).h().setValue(this.clockTimeData);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((AttendancePeriodVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((AttendancePeriodVM) ((BaseVmActivity) this).f8507a).j().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("选择考勤时段").setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(R.color.black))).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.pc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendancePeriodActivity.k0(this.f43947a, view);
            }
        }));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == this.CODE_REQUEST_PHOTO && resultCode == -1) {
            setResult(-1, data);
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
