package com.huachenjie.sport.page.mine.attendance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.basic.api.RequestPermission;
import com.huachenjie.base.widget.calendar.Calendar;
import com.huachenjie.base.widget.calendar.CalendarUtil;
import com.huachenjie.base.widget.calendar.CalendarView;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.run.page.activities_run.DetailActivity;
import com.huachenjie.sport.bean.CalendarDate;
import com.huachenjie.sport.page.mine.attendance.AttendanceSubVM;
import com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment;
import com.zj.adlib.fv5;
import com.zj.adlib.h40;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000 P*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0004:\u0001QB\u0007¢\u0006\u0004\bN\u0010OJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J8\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\b\u0010\u0014\u001a\u00020\nH$J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0005H\u0014J&\u0010!\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u000e\u0010#\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\n\u0010$\u001a\u0004\u0018\u00010\u0007H\u0004J\b\u0010%\u001a\u00020\u0005H\u0014J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010'\u001a\u00020&H\u0016J\"\u00103\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u000101H\u0016J\u000e\u00105\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u0007R\u0016\u00106\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u00108R\u0016\u0010\u001d\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00108R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u00108R\u0016\u00109\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010=\u001a\u00020&8$X¤\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0014\u0010?\u001a\u00020&8$X¤\u0004¢\u0006\u0006\u001a\u0004\b>\u0010<R\u0014\u0010C\u001a\u00020@8$X¤\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010G\u001a\u00020D8$X¤\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020&8$X¤\u0004¢\u0006\u0006\u001a\u0004\bH\u0010<R\u0014\u0010K\u001a\u00020&8$X¤\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010<R\u0014\u0010M\u001a\u00020&8$X¤\u0004¢\u0006\u0006\u001a\u0004\bL\u0010<¨\u0006R"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment;", "Lcom/huachenjie/sport/page/mine/attendance/AttendanceSubVM;", "VM", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/sport/page/mine/attendance/AttendanceClickHandler;", "", "requestCalendarData", "", "attendDate", "requestRecordData", "", "year", "month", "minYear", "minMonth", "maxYear", "maxMonth", "updateMonthNavVisibility", "startTapOutsideClock", "toggleStatsExpand", "getLayoutResId", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "initDataAfterView", "Lcom/huachenjie/sport/bean/CalendarDate;", "currentDay", "startDay", "endDay", "", "hasPlanCode", "changeCalendarRange", "requestData", "requestRecordDataByClock", "getCurrentSemesterCode", "initViewModel", "Landroid/view/View;", "v", "clickAttendanceCount", "clickPreMonth", "clickNextMonth", "clickToday", "clickAttendanceRule", "clickAttendancePlan", "clickRefreshTapResult", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", DetailActivity.x, "changePlanCode", "type", "I", "Lcom/huachenjie/sport/bean/CalendarDate;", "statsExpanded", "Z", "getRlAttendanceCount", "()Landroid/view/View;", "rlAttendanceCount", "getLlAttendanceStats", "llAttendanceStats", "Landroid/widget/ImageView;", "getIvAttendanceCountArrow", "()Landroid/widget/ImageView;", "ivAttendanceCountArrow", "Lcom/huachenjie/base/widget/calendar/CalendarView;", "getCalendarView", "()Lcom/huachenjie/base/widget/calendar/CalendarView;", "calendarView", "getTvToday", "tvToday", "getIvCalendarPre", "ivCalendarPre", "getIvCalendarNext", "ivCalendarNext", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nBaseAttendanceFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseAttendanceFragment.kt\ncom/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,315:1\n1#2:316\n*E\n"})
public abstract class BaseAttendanceFragment<VM extends AttendanceSubVM> extends BaseVMFragment<VM> implements AttendanceClickHandler {

    @Deprecated
    public static final int CODE_SELECT_PLAN = 100;

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    public static final long STATS_ANIMATION_DURATION = 300;
    private boolean statsExpanded;
    private int type;

    @NotNull
    private CalendarDate currentDay = new CalendarDate(0, 0, 0, 7, null);

    @NotNull
    private CalendarDate startDay = new CalendarDate(0, 0, 0, 7, null);

    @NotNull
    private CalendarDate endDay = new CalendarDate(0, 0, 0, 7, null);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment$a;", "", "", "year", "month", "", "a", "CODE_SELECT_PLAN", "I", "", "STATS_ANIMATION_DURATION", "J", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int year, int month) {
            StringBuilder sb;
            if (month > 9) {
                sb = new StringBuilder();
                sb.append(year);
                sb.append('-');
            } else {
                sb = new StringBuilder();
                sb.append(year);
                sb.append("-0");
            }
            sb.append(month);
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment$b", "Lcom/huachenjie/base/widget/calendar/CalendarView$OnCalendarSelectListener;", "Lcom/huachenjie/base/widget/calendar/Calendar;", "calendar", "", "onCalendarOutOfRange", "", "isClick", "onCalendarSelect", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements CalendarView.OnCalendarSelectListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAttendanceFragment<VM> f36601a;

        public b(BaseAttendanceFragment<VM> baseAttendanceFragment) {
            this.f36601a = baseAttendanceFragment;
        }

        @Override // com.huachenjie.base.widget.calendar.CalendarView.OnCalendarSelectListener
        public void onCalendarOutOfRange(@NotNull Calendar calendar) {
            Intrinsics.checkNotNullParameter(calendar, "calendar");
        }

        @Override // com.huachenjie.base.widget.calendar.CalendarView.OnCalendarSelectListener
        public void onCalendarSelect(@NotNull Calendar calendar, boolean isClick) {
            Intrinsics.checkNotNullParameter(calendar, "calendar");
            if (isClick) {
                if (((BaseAttendanceFragment) this.f36601a).currentDay.getTimeMillis() < ((BaseAttendanceFragment) this.f36601a).startDay.getTimeMillis() || ((BaseAttendanceFragment) this.f36601a).currentDay.getTimeMillis() > ((BaseAttendanceFragment) this.f36601a).endDay.getTimeMillis()) {
                    this.f36601a.getTvToday().setVisibility(8);
                } else {
                    this.f36601a.getTvToday().setVisibility(calendar.isCurrentDay() ? 8 : 0);
                }
                BaseAttendanceFragment<VM> baseAttendanceFragment = this.f36601a;
                String dateString = calendar.getDateString();
                Intrinsics.checkNotNullExpressionValue(dateString, "calendar.dateString");
                baseAttendanceFragment.requestRecordData(dateString);
            }
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36602a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36602a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36602a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36602a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment$d", "Lcom/huachenjie/base/qr_code_scan/a;", "", "s", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends com.huachenjie.base.qr_code_scan.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseAttendanceFragment<VM> f36603a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f13724a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(BaseAttendanceFragment<VM> baseAttendanceFragment, String str) {
            super(true);
            this.f36603a = baseAttendanceFragment;
            this.f13724a = str;
        }

        @Override // com.huachenjie.base.qr_code_scan.a
        public void s() {
            FragmentActivity activity = this.f36603a.getActivity();
            AttendanceActivity attendanceActivity = activity instanceof AttendanceActivity ? (AttendanceActivity) activity : null;
            if (attendanceActivity != null) {
                attendanceActivity.q0(this.f13724a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataAfterView$lambda$5(BaseAttendanceFragment baseAttendanceFragment, int i, int i2) {
        Intrinsics.checkNotNullParameter(baseAttendanceFragment, "this$0");
        ((AttendanceSubVM) ((BaseVMFragment) baseAttendanceFragment).mState).z().setValue(Companion.a(i, i2));
        baseAttendanceFragment.requestCalendarData();
        Calendar minRangeCalendar = baseAttendanceFragment.getCalendarView().getMinRangeCalendar();
        Calendar maxRangeCalendar = baseAttendanceFragment.getCalendarView().getMaxRangeCalendar();
        baseAttendanceFragment.updateMonthNavVisibility(i, i2, minRangeCalendar.getYear(), minRangeCalendar.getMonth(), maxRangeCalendar.getYear(), maxRangeCalendar.getMonth());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDataAfterView$lambda$6(BaseAttendanceFragment baseAttendanceFragment, View view) {
        Intrinsics.checkNotNullParameter(baseAttendanceFragment, "this$0");
        baseAttendanceFragment.toggleStatsExpand();
    }

    private final void requestCalendarData() {
        String currentSemesterCode = getCurrentSemesterCode();
        if (currentSemesterCode != null) {
            Q q = ((BaseVMFragment) this).mState;
            AttendanceSubVM attendanceSubVM = (AttendanceSubVM) q;
            String value = ((AttendanceSubVM) q).z().getValue();
            if (value == null) {
                value = "";
            }
            Intrinsics.checkNotNullExpressionValue(value, "mState.currentSelectedMonth.value ?: \"\"");
            attendanceSubVM.R(currentSemesterCode, value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestRecordData(String attendDate) {
        String currentSemesterCode = getCurrentSemesterCode();
        if (currentSemesterCode != null) {
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).S(currentSemesterCode, attendDate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTapOutsideClock() {
        String value = ((AttendanceSubVM) ((BaseVMFragment) this).mState).y().getValue();
        if (value == null || value.length() == 0) {
            fv5.b("暂无考勤计划");
            return;
        }
        FragmentActivity activity = getActivity();
        AppCompatActivity appCompatActivity = activity instanceof AppCompatActivity ? (AppCompatActivity) activity : null;
        if (appCompatActivity == null) {
            return;
        }
        new d(this, value).u(appCompatActivity, value, 2);
    }

    private final void toggleStatsExpand() {
        this.statsExpanded = !this.statsExpanded;
        getLlAttendanceStats().setVisibility(this.statsExpanded ? 0 : 8);
        getIvAttendanceCountArrow().animate().rotation(this.statsExpanded ? 0.0f : -90.0f).setDuration(300L).start();
    }

    private final void updateMonthNavVisibility(int year, int month, int minYear, int minMonth, int maxYear, int maxMonth) {
        getIvCalendarPre().setVisibility((year == minYear && month == minMonth) ? 8 : 0);
        getIvCalendarNext().setVisibility((year == maxYear && month == maxMonth) ? 8 : 0);
    }

    public final void changeCalendarRange(@NotNull CalendarDate currentDay, @NotNull CalendarDate startDay, @NotNull CalendarDate endDay, boolean hasPlanCode) {
        Intrinsics.checkNotNullParameter(currentDay, "currentDay");
        Intrinsics.checkNotNullParameter(startDay, "startDay");
        Intrinsics.checkNotNullParameter(endDay, "endDay");
        if (!hasPlanCode) {
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).y().setValue(null);
            MutableLiveData<Boolean> mutableLiveDataJ = ((AttendanceSubVM) ((BaseVMFragment) this).mState).J();
            Boolean bool = Boolean.FALSE;
            mutableLiveDataJ.setValue(bool);
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).K().setValue(bool);
        }
        this.currentDay = currentDay;
        this.startDay = startDay;
        this.endDay = endDay;
        getCalendarView().setRange(startDay.getYear(), startDay.getMonth(), 1, endDay.getYear(), endDay.getMonth(), CalendarUtil.getMonthDaysCount(endDay.getYear(), endDay.getMonth()));
        int i = 0;
        if (currentDay.getTimeMillis() >= startDay.getTimeMillis() && currentDay.getTimeMillis() <= endDay.getTimeMillis()) {
            Calendar calendar = new Calendar();
            calendar.setYear(currentDay.getYear());
            calendar.setMonth(currentDay.getMonth());
            calendar.setDay(currentDay.getDay());
            getCalendarView().setCurrentDay(calendar);
            getCalendarView().scrollToCurrent();
            getCalendarView().setSingleSelect(getCalendarView().getCurrentDay());
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).z().setValue(Companion.a(calendar.getYear(), calendar.getMonth()));
            updateMonthNavVisibility(currentDay.getYear(), currentDay.getMonth(), startDay.getYear(), startDay.getMonth(), endDay.getYear(), endDay.getMonth());
            requestData(currentDay.toString());
        } else {
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).z().setValue(Companion.a(startDay.getYear(), startDay.getMonth()));
            getIvCalendarPre().setVisibility(8);
            View ivCalendarNext = getIvCalendarNext();
            if ((endDay.getYear() != startDay.getYear() || endDay.getMonth() <= startDay.getMonth()) && endDay.getYear() <= startDay.getYear()) {
                i = 8;
            }
            ivCalendarNext.setVisibility(i);
            requestData(((AttendanceSubVM) ((BaseVMFragment) this).mState).z().getValue() + "-01");
        }
        getTvToday().setVisibility(8);
    }

    public final void changePlanCode(@NotNull String planCode) {
        Intrinsics.checkNotNullParameter(planCode, DetailActivity.x);
        ((AttendanceSubVM) ((BaseVMFragment) this).mState).y().setValue(planCode);
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickAttendanceCount(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        toggleStatsExpand();
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickAttendancePlan(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        ARouter.getInstance().build(RoutePathConstants.Sport.s).withString(UserConstants.MINE_PARAMS.j, ((AttendanceSubVM) ((BaseVMFragment) this).mState).y().getValue()).navigation(getActivity(), 100);
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickAttendanceRule(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        ARouter.getInstance().build(RoutePathConstants.Sport.t).withString(UserConstants.MINE_PARAMS.h, ((AttendanceSubVM) ((BaseVMFragment) this).mState).o().getValue()).withString(UserConstants.MINE_PARAMS.j, ((AttendanceSubVM) ((BaseVMFragment) this).mState).y().getValue()).navigation();
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickNextMonth(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        getCalendarView().scrollToNext();
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickPreMonth(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        getCalendarView().scrollToPre();
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickRefreshTapResult(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (Intrinsics.areEqual(((AttendanceSubVM) ((BaseVMFragment) this).mState).m().getValue(), Boolean.TRUE)) {
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).P();
            return;
        }
        Context context = getContext();
        if (context != null) {
            h40.a(context);
        }
    }

    @Override // com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler
    public void clickToday(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        getCalendarView().scrollToCurrent();
        getCalendarView().setSingleSelect(getCalendarView().getCurrentDay());
        getTvToday().setVisibility(8);
        requestRecordData(this.currentDay.toString());
    }

    @NotNull
    public abstract CalendarView getCalendarView();

    @Nullable
    public final String getCurrentSemesterCode() {
        SemesterBean semesterBeanP0;
        FragmentActivity activity = getActivity();
        AttendanceActivity attendanceActivity = activity instanceof AttendanceActivity ? (AttendanceActivity) activity : null;
        if (attendanceActivity == null) {
            return null;
        }
        if (!(!attendanceActivity.isFinishing())) {
            attendanceActivity = null;
        }
        if (attendanceActivity == null || (semesterBeanP0 = attendanceActivity.p0()) == null) {
            return null;
        }
        return semesterBeanP0.getSemesterCode();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        i62 i62Var = new i62(Integer.valueOf(getLayoutResId()), Integer.valueOf(ok0.p0), ((BaseVMFragment) this).mState);
        Integer numValueOf = Integer.valueOf(ok0.k);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type com.huachenjie.sport.page.mine.attendance.AttendanceClickHandler");
        i62 i62VarA = i62Var.a(numValueOf, this);
        Intrinsics.checkNotNullExpressionValue(i62VarA, "DataBindingConfig(getLay…s AttendanceClickHandler)");
        return i62VarA;
    }

    @NotNull
    public abstract ImageView getIvAttendanceCountArrow();

    @NotNull
    public abstract View getIvCalendarNext();

    @NotNull
    public abstract View getIvCalendarPre();

    public abstract int getLayoutResId();

    @NotNull
    public abstract View getLlAttendanceStats();

    @NotNull
    public abstract View getRlAttendanceCount();

    @NotNull
    public abstract View getTvToday();

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.type = arguments.getInt(UserConstants.MINE_PARAMS.d);
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).w().setValue(Integer.valueOf(this.type));
            CalendarDate calendarDate = (CalendarDate) arguments.getParcelable(UserConstants.MINE_PARAMS.e);
            if (calendarDate != null) {
                this.currentDay = calendarDate;
            }
            CalendarDate calendarDate2 = (CalendarDate) arguments.getParcelable(UserConstants.MINE_PARAMS.f);
            if (calendarDate2 != null) {
                Intrinsics.checkNotNullExpressionValue(calendarDate2, "date");
                this.startDay = calendarDate2;
            }
            CalendarDate calendarDate3 = (CalendarDate) arguments.getParcelable(UserConstants.MINE_PARAMS.g);
            if (calendarDate3 != null) {
                Intrinsics.checkNotNullExpressionValue(calendarDate3, "date");
                this.endDay = calendarDate3;
            }
        }
        ((AttendanceSubVM) ((BaseVMFragment) this).mState).E().setValue(new AttendanceAdapter());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initDataAfterView() {
        changeCalendarRange(this.currentDay, this.startDay, this.endDay, false);
        getCalendarView().setOnCalendarSelectListener(new b(this));
        getCalendarView().setOnMonthChangeListener(new CalendarView.OnMonthChangeListener() { // from class: com.zj.adlib.kn0
            @Override // com.huachenjie.base.widget.calendar.CalendarView.OnMonthChangeListener
            public final void onMonthChange(int i, int i2) {
                BaseAttendanceFragment.initDataAfterView$lambda$5(this.f42862a, i, i2);
            }
        });
        getRlAttendanceCount().setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ln0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BaseAttendanceFragment.initDataAfterView$lambda$6(this.f43106a, view);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
        ((AttendanceSubVM) ((BaseVMFragment) this).mState).x().observe(this, new c(new Function1<Map<String, Calendar>, Unit>(this) { // from class: com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment.initViewModel.1
            final /* synthetic */ BaseAttendanceFragment<VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, Calendar>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Map<String, Calendar> map) {
                this.this$0.getCalendarView().setSchemeDate(map);
            }
        }));
        ((AttendanceSubVM) ((BaseVMFragment) this).mState).M().observe(this, new c(new Function1<Boolean, Unit>(this) { // from class: com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment.initViewModel.2
            final /* synthetic */ BaseAttendanceFragment<VM> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ((AttendanceSubVM) ((BaseVMFragment) this.this$0).mState).M().setValue(Boolean.FALSE);
                    this.this$0.startTapOutsideClock();
                }
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode != 100 || data == null) {
            return;
        }
        String stringExtra = data.getStringExtra(UserConstants.MINE_PARAMS.j);
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        ((AttendanceSubVM) ((BaseVMFragment) this).mState).y().setValue(stringExtra);
        Calendar selectedCalendar = getCalendarView().getSelectedCalendar();
        if (selectedCalendar != null) {
            requestData(selectedCalendar.getDateString());
        }
    }

    public final void requestData(@Nullable String attendDate) {
        String currentSemesterCode = getCurrentSemesterCode();
        if (currentSemesterCode != null) {
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).Q(currentSemesterCode, attendDate);
        }
    }

    public final void requestRecordDataByClock(@NotNull String attendDate) {
        String currentSemesterCode;
        Intrinsics.checkNotNullParameter(attendDate, "attendDate");
        Calendar selectedCalendar = getCalendarView().getSelectedCalendar();
        if (selectedCalendar != null && this.currentDay.getYear() == selectedCalendar.getYear() && this.currentDay.getMonth() == selectedCalendar.getMonth() && this.currentDay.getDay() == selectedCalendar.getDay() && (currentSemesterCode = getCurrentSemesterCode()) != null) {
            ((AttendanceSubVM) ((BaseVMFragment) this).mState).S(currentSemesterCode, attendDate);
        }
    }
}
