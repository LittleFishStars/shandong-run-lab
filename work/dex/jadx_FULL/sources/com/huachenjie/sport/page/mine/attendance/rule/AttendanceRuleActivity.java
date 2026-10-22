package com.huachenjie.sport.page.mine.attendance.rule;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.LocationRangeBean;
import com.huachenjie.common.bean.OutsideAttendanceRule;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.attendance.rule.AttendanceRuleActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.t)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "h0", "", "x", "Ljava/lang/String;", "planName", "y", DetailActivity.x, "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendanceRuleActivity extends BaseVmActivity<AttendanceRuleVM> {

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.h)
    @JvmField
    @Nullable
    public String planName;

    /* JADX INFO: renamed from: y, reason: from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.j)
    @JvmField
    @Nullable
    public String planCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleActivity$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/attendance/rule/AttendanceRuleActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            ArrayList<LocationRangeBean> arrayList;
            MutableLiveData<OutsideAttendanceRule> mutableLiveDataH;
            OutsideAttendanceRule value;
            Intrinsics.checkNotNullParameter(view, "view");
            AttendanceRuleVM attendanceRuleVM = (AttendanceRuleVM) ((BaseVmActivity) AttendanceRuleActivity.this).f8507a;
            if (attendanceRuleVM == null || (mutableLiveDataH = attendanceRuleVM.h()) == null || (value = mutableLiveDataH.getValue()) == null || (arrayList = value.getLocationList()) == null) {
                arrayList = new ArrayList<>();
            }
            com.huachenjie.base.qr_code_scan.a.Companion companion = com.huachenjie.base.qr_code_scan.a.INSTANCE;
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            companion.b(context, arrayList);
        }
    }

    public static final void i0(AttendanceRuleActivity attendanceRuleActivity, View view) {
        Intrinsics.checkNotNullParameter(attendanceRuleActivity, "this$0");
        attendanceRuleActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_attendance_rule), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void h0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((AttendanceRuleVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        BindingTitleBean statusBarHeight = bindingTitleBean.setStatusBarHeight(value.intValue());
        StringBuilder sb = new StringBuilder();
        String str = this.planName;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        sb.append("考勤规则");
        ((AttendanceRuleVM) ((BaseVmActivity) this).f8507a).k().setValue(statusBarHeight.setTitleName(sb.toString()).setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(R.color.black))).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendanceRuleActivity.i0(this.f45789a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        h0();
        ((AttendanceRuleVM) ((BaseVmActivity) this).f8507a).i().setValue(new AttendanceRuleAdapter());
        AttendanceRuleVM attendanceRuleVM = (AttendanceRuleVM) ((BaseVmActivity) this).f8507a;
        String str = this.planCode;
        if (str == null) {
            str = "";
        }
        attendanceRuleVM.j(str);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
