package com.huachenjie.sport.page.mine.attendance;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.triver.basic.api.RequestPermission;
import com.byazt.hv.TTDownloadField;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.huachenjie.base.bean.TabEntity;
import com.huachenjie.base.widget.semester.SemesterDrawer;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.CalendarDate;
import com.huachenjie.sport.databinding.ActivityAttendanceBinding;
import com.huachenjie.sport.page.mine.attendance.AttendanceActivity;
import com.huachenjie.sport.page.mine.signin.NumberSignInDialog;
import com.kuaishou.weapon.p0.bo;
import com.kuaishou.weapon.p0.t;
import com.lxj.xpopup.enums.PopupPosition;
import com.zj.adlib.ai9;
import com.zj.adlib.fv5;
import com.zj.adlib.h46;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.r5a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.r)
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\t\u001a\u00020\u0007H\u0014J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0012\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0011J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\u0016\u0010 \u001a\u00020\u00072\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001eH\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010$¨\u0006*"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceActivity;", "Lcom/huachenjie/common/base/data_binding/BaseVmActivity;", "Lcom/huachenjie/sport/page/mine/attendance/AttendanceVM;", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "", "init", "initViewModel", "v0", "w0", "", "outsideConfigCode", "q0", "Lcom/huachenjie/common/bean/SemesterBean;", bo.g, "", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "index", "Lcom/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment;", "Lcom/huachenjie/sport/page/mine/attendance/AttendanceSubVM;", "o0", "t0", "s0", "x0", "", "semesterData", "u0", "n0", "", "a", "Z", "hasInit", "c", "fromClockSuccess", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nAttendanceActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AttendanceActivity.kt\ncom/huachenjie/sport/page/mine/attendance/AttendanceActivity\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,326:1\n13374#2,3:327\n1#3:330\n*S KotlinDebug\n*F\n+ 1 AttendanceActivity.kt\ncom/huachenjie/sport/page/mine/attendance/AttendanceActivity\n*L\n98#1:327,3\n*E\n"})
public final class AttendanceActivity extends BaseVmActivity<AttendanceVM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public boolean hasInit;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public boolean fromClockSuccess;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceActivity$a;", "", "Landroid/view/View;", "v", "", "b", "c", "d", "f", "<init>", "(Lcom/huachenjie/sport/page/mine/attendance/AttendanceActivity;)V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public static final void e(BaseAttendanceFragment baseAttendanceFragment, AttendanceActivity attendanceActivity) {
            Intrinsics.checkNotNullParameter(baseAttendanceFragment, "$fragment");
            Intrinsics.checkNotNullParameter(attendanceActivity, "this$0");
            baseAttendanceFragment.requestData(null);
            baseAttendanceFragment.requestRecordDataByClock(String.valueOf(((AttendanceVM) ((BaseVmActivity) attendanceActivity).f8507a).i().getValue()));
        }

        public final void b(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            AttendanceActivity.this.finish();
        }

        public final void c(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).j().getValue() != null) {
                List<SemesterBean> value = ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).j().getValue();
                Intrinsics.checkNotNull(value);
                if (!value.isEmpty()) {
                    List<SemesterBean> value2 = ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).j().getValue();
                    if (value2 != null) {
                        AttendanceActivity.this.u0(value2);
                        return;
                    }
                    return;
                }
            }
            ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).m();
        }

        public final void d(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            final BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO0 = AttendanceActivity.this.o0(0);
            if (baseAttendanceFragmentO0 != null) {
                final AttendanceActivity attendanceActivity = AttendanceActivity.this;
                NumberSignInDialog.newInstance(new NumberSignInDialog.OnSignInSuccessCallback() { // from class: com.zj.adlib.oc0
                    @Override // com.huachenjie.sport.page.mine.signin.NumberSignInDialog.OnSignInSuccessCallback
                    public final void a() {
                        AttendanceActivity.a.e(baseAttendanceFragmentO0, attendanceActivity);
                    }
                }).show(attendanceActivity.getSupportFragmentManager(), "number_sign_id");
            }
        }

        public final void f(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ActivityAttendanceBinding activityAttendanceBinding = (ActivityAttendanceBinding) AttendanceActivity.this.getBinding();
            if (activityAttendanceBinding != null) {
                AttendanceActivity attendanceActivity = AttendanceActivity.this;
                int currentTab = activityAttendanceBinding.f13093a.getCurrentTab();
                if (currentTab == 0) {
                    attendanceActivity.v0();
                } else {
                    if (currentTab != 1) {
                        return;
                    }
                    attendanceActivity.w0();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceActivity$b", "Lcom/flyco/tablayout/listener/OnTabSelectListener;", "", "position", "", "b", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements OnTabSelectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActivityAttendanceBinding f36582a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AttendanceActivity f13720a;

        public b(ActivityAttendanceBinding activityAttendanceBinding, AttendanceActivity attendanceActivity) {
            this.f36582a = activityAttendanceBinding;
            this.f13720a = attendanceActivity;
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void a(int position) {
        }

        @Override // com.flyco.tablayout.listener.OnTabSelectListener
        public void b(int position) {
            this.f36582a.c.setVisibility(position == 0 ? 0 : 8);
            this.f13720a.x0(position);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36583a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36583a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36583a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36583a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceActivity$d", "Lcom/huachenjie/base/widget/semester/SemesterDrawer$OnConfirmListener;", "Lcom/huachenjie/common/bean/SemesterBean;", "semesterCode", "", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements SemesterDrawer.OnConfirmListener {
        public d() {
        }

        @Override // com.huachenjie.base.widget.semester.SemesterDrawer.OnConfirmListener
        public void a(@Nullable SemesterBean semesterCode) {
            if (semesterCode != null) {
                ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).h().setValue(semesterCode);
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceActivity$e", "Lcom/huachenjie/base/qr_code_scan/a;", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "", "result", "", "lng", "lat", "", t.d, "", "s", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class e extends com.huachenjie.base.qr_code_scan.a {
        public e() {
            super(true);
        }

        @Override // com.huachenjie.base.qr_code_scan.a
        public boolean l(@Nullable AppCompatActivity activity, @NotNull String result, double lng, double lat) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (StringsKt.startsWith$default(result, "student-course-attend", false, 2, (Object) null)) {
                j(activity, result, lng, lat);
                return true;
            }
            fv5.b("考勤失败");
            return true;
        }

        @Override // com.huachenjie.base.qr_code_scan.a
        public void s() {
            BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO0 = AttendanceActivity.this.o0(0);
            if (baseAttendanceFragmentO0 != null) {
                AttendanceActivity attendanceActivity = AttendanceActivity.this;
                baseAttendanceFragmentO0.requestData(null);
                baseAttendanceFragmentO0.requestRecordDataByClock(String.valueOf(((AttendanceVM) ((BaseVmActivity) attendanceActivity).f8507a).i().getValue()));
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"com/huachenjie/sport/page/mine/attendance/AttendanceActivity$f", "Lcom/huachenjie/base/qr_code_scan/a;", "Landroidx/appcompat/app/AppCompatActivity;", TTDownloadField.TT_ACTIVITY, "", "result", "", "lng", "lat", "", t.d, "", "s", "a", "Ljava/lang/String;", "w", "()Ljava/lang/String;", "x", "(Ljava/lang/String;)V", "outsideConfigCode", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class f extends com.huachenjie.base.qr_code_scan.a {

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @Nullable
        public String outsideConfigCode;

        public f() {
            super(true);
        }

        @Override // com.huachenjie.base.qr_code_scan.a
        public boolean l(@Nullable AppCompatActivity activity, @NotNull String result, double lng, double lat) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.length() >= 20 || !h46.f42049a.m(result)) {
                fv5.b("签到失败");
                return true;
            }
            this.outsideConfigCode = result;
            j(activity, result, lng, lat);
            return true;
        }

        @Override // com.huachenjie.base.qr_code_scan.a
        public void s() {
            AttendanceActivity.this.q0(this.outsideConfigCode);
        }

        @Nullable
        /* JADX INFO: renamed from: w, reason: from getter */
        public final String getOutsideConfigCode() {
            return this.outsideConfigCode;
        }

        public final void x(@Nullable String str) {
            this.outsideConfigCode = str;
        }
    }

    public static /* synthetic */ void r0(AttendanceActivity attendanceActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        attendanceActivity.q0(str);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62VarA = new i62(Integer.valueOf(R.layout.activity_attendance), Integer.valueOf(ok0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(ok0.k), new a());
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(R.layo…m(BR.click, ClickProxy())");
        return i62VarA;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle savedInstanceState) {
        ((AttendanceVM) ((BaseVmActivity) this).f8507a).o().setValue(ai9.e());
        t0();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
        ((AttendanceVM) ((BaseVmActivity) this).f8507a).i().observe(this, new c(new Function1<CalendarDate, Unit>() { // from class: com.huachenjie.sport.page.mine.attendance.AttendanceActivity.initViewModel.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((CalendarDate) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(CalendarDate calendarDate) {
                if (calendarDate != null) {
                    ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).m();
                }
            }
        }));
        ((AttendanceVM) ((BaseVmActivity) this).f8507a).h().observe(this, new c(new Function1<SemesterBean, Unit>() { // from class: com.huachenjie.sport.page.mine.attendance.AttendanceActivity.initViewModel.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemesterBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemesterBean semesterBean) {
                if (semesterBean == null) {
                    return;
                }
                if (!AttendanceActivity.this.hasInit) {
                    AttendanceActivity.this.s0();
                    return;
                }
                BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO0 = AttendanceActivity.this.o0(0);
                if (baseAttendanceFragmentO0 != null) {
                    CalendarDate value = ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).i().getValue();
                    if (value == null) {
                        value = new CalendarDate(0, 0, 0, 7, null);
                    }
                    baseAttendanceFragmentO0.changeCalendarRange(value, ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).t(semesterBean.getStartTime()), ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).t(semesterBean.getEndTime()), false);
                }
                BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO1 = AttendanceActivity.this.o0(1);
                if (baseAttendanceFragmentO1 != null) {
                    CalendarDate value2 = ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).i().getValue();
                    if (value2 == null) {
                        value2 = new CalendarDate(0, 0, 0, 7, null);
                    }
                    baseAttendanceFragmentO1.changeCalendarRange(value2, ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).t(semesterBean.getStartTime()), ((AttendanceVM) ((BaseVmActivity) AttendanceActivity.this).f8507a).t(semesterBean.getEndTime()), AttendanceActivity.this.fromClockSuccess);
                }
                if (AttendanceActivity.this.fromClockSuccess) {
                    AttendanceActivity.this.fromClockSuccess = false;
                }
            }
        }));
    }

    public final BaseAttendanceFragment<AttendanceSubVM> n0(int index) {
        CalendarDate value = ((AttendanceVM) ((BaseVmActivity) this).f8507a).i().getValue();
        if (value == null) {
            value = new CalendarDate(0, 0, 0, 7, null);
        }
        Q q = ((BaseVmActivity) this).f8507a;
        AttendanceVM attendanceVM = (AttendanceVM) q;
        SemesterBean value2 = ((AttendanceVM) q).h().getValue();
        CalendarDate calendarDateT = attendanceVM.t(value2 != null ? value2.getStartTime() : 0L);
        Q q2 = ((BaseVmActivity) this).f8507a;
        AttendanceVM attendanceVM2 = (AttendanceVM) q2;
        SemesterBean value3 = ((AttendanceVM) q2).h().getValue();
        CalendarDate calendarDateT2 = attendanceVM2.t(value3 != null ? value3.getEndTime() : 0L);
        return index == 0 ? InClassAttendanceFragment.INSTANCE.a(value, calendarDateT, calendarDateT2) : OutClassAttendanceFragment.INSTANCE.a(value, calendarDateT, calendarDateT2);
    }

    @Nullable
    public final BaseAttendanceFragment<AttendanceSubVM> o0(int index) {
        String[] stringArray;
        Resources resources = getResources();
        if (resources == null || (stringArray = resources.getStringArray(R.array.attendance_title)) == null) {
            return null;
        }
        boolean z = false;
        if (index >= 0 && index < stringArray.length) {
            z = true;
        }
        if (!z) {
            return null;
        }
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(stringArray[index]);
        if (fragmentFindFragmentByTag instanceof BaseAttendanceFragment) {
            return (BaseAttendanceFragment) fragmentFindFragmentByTag;
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO0;
        super.onActivityResult(requestCode, resultCode, data);
        ActivityAttendanceBinding activityAttendanceBinding = (ActivityAttendanceBinding) getBinding();
        if (activityAttendanceBinding == null || (baseAttendanceFragmentO0 = o0(activityAttendanceBinding.f13093a.getCurrentTab())) == null) {
            return;
        }
        baseAttendanceFragmentO0.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    public final SemesterBean p0() {
        return ((AttendanceVM) ((BaseVmActivity) this).f8507a).h().getValue();
    }

    public final void q0(@Nullable String outsideConfigCode) {
        Object next;
        if (outsideConfigCode != null) {
            BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO0 = o0(1);
            if (baseAttendanceFragmentO0 != null) {
                baseAttendanceFragmentO0.changePlanCode(outsideConfigCode);
            }
            this.fromClockSuccess = true;
        }
        List<SemesterBean> value = ((AttendanceVM) ((BaseVmActivity) this).f8507a).j().getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((SemesterBean) next).getStatus() == 1));
            SemesterBean semesterBean = (SemesterBean) next;
            if (semesterBean != null) {
                ((AttendanceVM) ((BaseVmActivity) this).f8507a).h().setValue(semesterBean);
            }
        }
        BaseAttendanceFragment<AttendanceSubVM> baseAttendanceFragmentO1 = o0(1);
        if (baseAttendanceFragmentO1 != null) {
            baseAttendanceFragmentO1.requestRecordDataByClock(String.valueOf(((AttendanceVM) ((BaseVmActivity) this).f8507a).i().getValue()));
        }
    }

    public final void s0() {
        String[] stringArray;
        ActivityAttendanceBinding activityAttendanceBinding = (ActivityAttendanceBinding) getBinding();
        if (activityAttendanceBinding != null) {
            activityAttendanceBinding.f13093a.setOnTabSelectListener(new b(activityAttendanceBinding, this));
            ArrayList<CustomTabEntity> arrayList = new ArrayList<>();
            Resources resources = getResources();
            if (resources == null || (stringArray = resources.getStringArray(R.array.attendance_title)) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(stringArray, "resources?.getStringArra…tendance_title) ?: return");
            for (String str : stringArray) {
                Intrinsics.checkNotNullExpressionValue(str, "name");
                arrayList.add(new TabEntity(str));
            }
            activityAttendanceBinding.f13093a.setTabData(arrayList);
            x0(0);
        }
        this.hasInit = true;
    }

    public final void t0() {
        ((AttendanceVM) ((BaseVmActivity) this).f8507a).r();
    }

    public final void u0(List<SemesterBean> semesterData) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SemesterBean value = ((AttendanceVM) ((BaseVmActivity) this).f8507a).h().getValue();
        SemesterDrawer semesterDrawer = new SemesterDrawer(context, value != null ? value.getSemesterCode() : null, semesterData, false, false, 16, null);
        semesterDrawer.setListener(new d());
        new r5a.b(getContext()).q0(PopupPosition.Right).U(false).b0(true).r(semesterDrawer).show();
    }

    public final void v0() {
        com.huachenjie.common.page.qrcode.a.f33831a.a(new e(), true);
    }

    public final void w0() {
        com.huachenjie.common.page.qrcode.a.f33831a.a(new f(), true);
    }

    public final void x0(int index) {
        String[] stringArray;
        Resources resources = getResources();
        if (resources == null || (stringArray = resources.getStringArray(R.array.attendance_title)) == null) {
            return;
        }
        int i = 0;
        if ((index >= 0 && index < stringArray.length) && !TextUtils.isEmpty(stringArray[index])) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(stringArray[index]);
            if (fragmentFindFragmentByTag == null || !fragmentFindFragmentByTag.isVisible()) {
                FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
                int length = stringArray.length;
                int i2 = 0;
                while (i < length) {
                    String str = stringArray[i];
                    int i3 = i2 + 1;
                    Fragment fragmentFindFragmentByTag2 = supportFragmentManager.findFragmentByTag(str);
                    if (TextUtils.equals(stringArray[index], str)) {
                        if (fragmentFindFragmentByTag2 == null) {
                            fragmentTransactionBeginTransaction.add(R.id.fragment_container, n0(i2), str);
                        } else if (fragmentFindFragmentByTag2.isHidden()) {
                            fragmentTransactionBeginTransaction.show(fragmentFindFragmentByTag2);
                        }
                    } else if (fragmentFindFragmentByTag2 != null && !fragmentFindFragmentByTag2.isHidden()) {
                        fragmentTransactionBeginTransaction.hide(fragmentFindFragmentByTag2);
                    }
                    i++;
                    i2 = i3;
                }
                fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                supportFragmentManager.executePendingTransactions();
            }
        }
    }
}
