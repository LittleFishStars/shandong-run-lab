package com.huachenjie.sport.page.mine.attendance.plan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendancePlanBean;
import com.huachenjie.sport.page.mine.attendance.plan.AttendancePlanActivity;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.zn1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.Sport.s)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "i0", "", "x", "Ljava/lang/String;", DetailActivity.x, "<init>", "()V", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendancePlanActivity extends BaseVmActivity<AttendancePlanVM> {

    /* JADX INFO: renamed from: x, reason: from kotlin metadata */
    @Autowired(name = UserConstants.MINE_PARAMS.j)
    @JvmField
    @Nullable
    public String planCode;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanActivity$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "(Lcom/huachenjie/sport/page/mine/attendance/plan/AttendancePlanActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            AttendancePlanActivity.this.finish();
        }
    }

    public static final void h0(AttendancePlanActivity attendancePlanActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<AttendancePlanBean> data;
        AttendancePlanBean attendancePlanBean;
        Intrinsics.checkNotNullParameter(attendancePlanActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Intent intent = new Intent();
        AttendancePlanAdapter value = ((AttendancePlanVM) ((BaseVmActivity) attendancePlanActivity).f8507a).i().getValue();
        intent.putExtra(UserConstants.MINE_PARAMS.j, (value == null || (data = value.getData()) == null || (attendancePlanBean = data.get(i)) == null) ? null : attendancePlanBean.getOutsideConfigCode());
        attendancePlanActivity.setResult(-1, intent);
        attendancePlanActivity.finish();
    }

    public static final void j0(AttendancePlanActivity attendancePlanActivity, View view) {
        Intrinsics.checkNotNullParameter(attendancePlanActivity, "this$0");
        attendancePlanActivity.finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_attendance_plan), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    public final void i0() {
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = ((BaseVM) ((AttendancePlanVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue();
        Intrinsics.checkNotNull(value);
        ((AttendancePlanVM) ((BaseVmActivity) this).f8507a).k().setValue(bindingTitleBean.setStatusBarHeight(value.intValue()).setTitleName("选择考勤计划").setBackground(zn1.a(R.color.white)).setBackIconResId(R.drawable.ic_back_black).setBackTintColor(Integer.valueOf(zn1.a(R.color.black))).setTitleTextColor(zn1.a(R.color.color_2C3E50)).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.tc0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AttendancePlanActivity.j0(this.f44887a, view);
            }
        }));
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        i0();
        ((AttendancePlanVM) ((BaseVmActivity) this).f8507a).i().setValue(new AttendancePlanAdapter());
        ((AttendancePlanVM) ((BaseVmActivity) this).f8507a).j();
        ((AttendancePlanVM) ((BaseVmActivity) this).f8507a).h().setValue(this.planCode);
        AttendancePlanAdapter value = ((AttendancePlanVM) ((BaseVmActivity) this).f8507a).i().getValue();
        if (value != null) {
            value.setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.sc0
                @Override // com.chad.library.adapter.base.listener.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    AttendancePlanActivity.h0(this.f44658a, baseQuickAdapter, view, i);
                }
            });
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }
}
