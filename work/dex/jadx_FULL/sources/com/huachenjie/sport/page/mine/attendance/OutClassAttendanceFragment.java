package com.huachenjie.sport.page.mine.attendance;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.widget.calendar.CalendarView;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.CalendarDate;
import com.huachenjie.sport.databinding.FragmentAttendanceOutClassBinding;
import com.noober.background.view.BLTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0014\u0010\u001c\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0014\u0010\u001e\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\r¨\u0006#"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/OutClassAttendanceFragment;", "Lcom/huachenjie/sport/page/mine/attendance/BaseAttendanceFragment;", "Lcom/huachenjie/sport/page/mine/attendance/AttendanceSubVM;", "", "getLayoutResId", "", "onResume", "Lcom/huachenjie/sport/databinding/FragmentAttendanceOutClassBinding;", "getMBinding", "()Lcom/huachenjie/sport/databinding/FragmentAttendanceOutClassBinding;", "mBinding", "Landroid/view/View;", "getRlAttendanceCount", "()Landroid/view/View;", "rlAttendanceCount", "getLlAttendanceStats", "llAttendanceStats", "Landroid/widget/ImageView;", "getIvAttendanceCountArrow", "()Landroid/widget/ImageView;", "ivAttendanceCountArrow", "Lcom/huachenjie/base/widget/calendar/CalendarView;", "getCalendarView", "()Lcom/huachenjie/base/widget/calendar/CalendarView;", "calendarView", "getTvToday", "tvToday", "getIvCalendarPre", "ivCalendarPre", "getIvCalendarNext", "ivCalendarNext", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class OutClassAttendanceFragment extends BaseAttendanceFragment<AttendanceSubVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.attendance.OutClassAttendanceFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/OutClassAttendanceFragment$a;", "", "Lcom/huachenjie/sport/bean/CalendarDate;", "currentDay", "startDay", "endDay", "Lcom/huachenjie/sport/page/mine/attendance/OutClassAttendanceFragment;", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final OutClassAttendanceFragment a(@NotNull CalendarDate currentDay, @NotNull CalendarDate startDay, @NotNull CalendarDate endDay) {
            Intrinsics.checkNotNullParameter(currentDay, "currentDay");
            Intrinsics.checkNotNullParameter(startDay, "startDay");
            Intrinsics.checkNotNullParameter(endDay, "endDay");
            OutClassAttendanceFragment outClassAttendanceFragment = new OutClassAttendanceFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(UserConstants.MINE_PARAMS.d, 2);
            bundle.putParcelable(UserConstants.MINE_PARAMS.e, currentDay);
            bundle.putParcelable(UserConstants.MINE_PARAMS.f, startDay);
            bundle.putParcelable(UserConstants.MINE_PARAMS.g, endDay);
            outClassAttendanceFragment.setArguments(bundle);
            return outClassAttendanceFragment;
        }
    }

    private final FragmentAttendanceOutClassBinding getMBinding() {
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.FragmentAttendanceOutClassBinding");
        return (FragmentAttendanceOutClassBinding) binding;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public CalendarView getCalendarView() {
        CalendarView calendarView = getMBinding().f13443a;
        Intrinsics.checkNotNullExpressionValue(calendarView, "mBinding.calendarView");
        return calendarView;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public ImageView getIvAttendanceCountArrow() {
        ImageView imageView = getMBinding().f13438a;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.ivAttendanceCountArrow");
        return imageView;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public View getIvCalendarNext() {
        ImageView imageView = getMBinding().f13449b;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.ivCalendarNext");
        return imageView;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public View getIvCalendarPre() {
        ImageView imageView = getMBinding().c;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.ivCalendarPre");
        return imageView;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    public int getLayoutResId() {
        return R.layout.fragment_attendance_out_class;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public View getLlAttendanceStats() {
        LinearLayout linearLayout = getMBinding().f13450b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.llAttendanceStats");
        return linearLayout;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public View getRlAttendanceCount() {
        RelativeLayout relativeLayout = getMBinding().f13440a;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.rlAttendanceCount");
        return relativeLayout;
    }

    @Override // com.huachenjie.sport.page.mine.attendance.BaseAttendanceFragment
    @NotNull
    public View getTvToday() {
        BLTextView bLTextView = getMBinding().f13452b;
        Intrinsics.checkNotNullExpressionValue(bLTextView, "mBinding.tvToday");
        return bLTextView;
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((AttendanceSubVM) ((BaseVMFragment) this).mState).O();
    }
}
