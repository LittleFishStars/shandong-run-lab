package com.huachenjie.sport.page.mine.sport_test.time;

import android.os.Bundle;
import android.view.View;
import androidx.coroutines.ViewDataBinding;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.base.data_binding.BaseVMFragment;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.FitnessTestPeriod;
import com.huachenjie.sport.bean.ReservePeriod;
import com.huachenjie.sport.bean.SportTestPeriodBean;
import com.huachenjie.sport.bean.YearPeriod;
import com.huachenjie.sport.databinding.FragmentSportTestChooseTimeBinding;
import com.igexin.push.g.o;
import com.zj.adlib.i62;
import com.zj.adlib.ok0;
import com.zj.adlib.v79;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeFragment;", "Lcom/huachenjie/common/base/data_binding/BaseVMFragment;", "Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeVM;", "", "initViewModel", "Lcom/zj/adlib/i62;", "getDataBindingConfig", "Landroid/os/Bundle;", "savedInstanceState", "init", "Landroid/view/View;", "view", "onViewCreated", "<init>", "()V", "Companion", "a", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestChooseTimeFragment extends BaseVMFragment<SportTestChooseTimeVM> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeFragment$a;", "", "", "index", "Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeFragment;", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SportTestChooseTimeFragment a(int index) {
            Bundle bundle = new Bundle();
            bundle.putInt("index", index);
            SportTestChooseTimeFragment sportTestChooseTimeFragment = new SportTestChooseTimeFragment();
            sportTestChooseTimeFragment.setArguments(bundle);
            return sportTestChooseTimeFragment;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36742a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36742a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36742a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36742a.invoke(obj);
        }
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    @NotNull
    public i62 getDataBindingConfig() {
        ((BaseVMFragment) this).mState = (Q) getActivityScopeViewModel(SportTestChooseTimeVM.class);
        return new i62(Integer.valueOf(R.layout.fragment_sport_test_choose_time), Integer.valueOf(ok0.p0), ((BaseVMFragment) this).mState);
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void init(@Nullable Bundle savedInstanceState) {
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVMFragment
    public void initViewModel() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        List<YearPeriod> list;
        YearPeriod yearPeriod;
        final List<FitnessTestPeriod> fitnessTestPeriods;
        Intrinsics.checkNotNullParameter(view, "view");
        ViewDataBinding binding = getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.sport.databinding.FragmentSportTestChooseTimeBinding");
        FragmentSportTestChooseTimeBinding fragmentSportTestChooseTimeBinding = (FragmentSportTestChooseTimeBinding) binding;
        Bundle arguments = getArguments();
        final int i = arguments != null ? arguments.getInt("index") : 0;
        SportTestPeriodBean value = ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).l().getValue();
        if (value == null || (list = value.getList()) == null || (yearPeriod = list.get(i)) == null || (fitnessTestPeriods = yearPeriod.getFitnessTestPeriods()) == null) {
            return;
        }
        final SportTestChooseDateAdapter sportTestChooseDateAdapter = new SportTestChooseDateAdapter();
        fragmentSportTestChooseTimeBinding.f13509a.setAdapter(sportTestChooseDateAdapter);
        sportTestChooseDateAdapter.setList(fitnessTestPeriods);
        if (i == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getYearIndex()) {
            sportTestChooseDateAdapter.i(((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getDayIndex());
        }
        final List<ReservePeriod> reservePeriods = fitnessTestPeriods.get(sportTestChooseDateAdapter.getCheckedIndex()).getReservePeriods();
        final SportTestChooseTimeAdapter sportTestChooseTimeAdapter = new SportTestChooseTimeAdapter();
        fragmentSportTestChooseTimeBinding.b.setAdapter(sportTestChooseTimeAdapter);
        sportTestChooseTimeAdapter.setList(reservePeriods);
        if (i == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getYearIndex() && sportTestChooseDateAdapter.getCheckedIndex() == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getDayIndex()) {
            sportTestChooseTimeAdapter.i(((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getTimeIndex());
        } else {
            sportTestChooseTimeAdapter.i(-1);
        }
        ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).u().observe(getViewLifecycleOwner(), new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeFragment.onViewCreated.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                Intrinsics.checkNotNullExpressionValue(bool, o.f);
                if (bool.booleanValue()) {
                    if (i == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getYearIndex() && sportTestChooseDateAdapter.getCheckedIndex() == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getDayIndex()) {
                        sportTestChooseTimeAdapter.i(((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getTimeIndex());
                    } else {
                        sportTestChooseTimeAdapter.i(-1);
                    }
                }
            }
        }));
        final int i2 = i;
        sportTestChooseDateAdapter.j(new Function1<Integer, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeFragment.onViewCreated.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                sportTestChooseTimeAdapter.setList(fitnessTestPeriods.get(i3).getReservePeriods());
                if (i2 == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getYearIndex() && sportTestChooseDateAdapter.getCheckedIndex() == ((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getDayIndex()) {
                    sportTestChooseTimeAdapter.i(((SportTestChooseTimeVM) ((BaseVMFragment) this).mState).getTimeIndex());
                } else {
                    sportTestChooseTimeAdapter.i(-1);
                }
            }
        });
        final int i3 = i;
        sportTestChooseTimeAdapter.j(new Function1<Integer, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeFragment.onViewCreated.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke(((Number) obj).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i4) {
                String yearMonthCode;
                String timeFragmentCode;
                ReservePeriod reservePeriod;
                String reservePeriod2;
                ReservePeriod reservePeriod3;
                List<YearPeriod> list2;
                YearPeriod yearPeriod2;
                ((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).C(i3);
                SportTestChooseTimeVM sportTestChooseTimeVM = (SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState;
                SportTestPeriodBean value2 = ((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).l().getValue();
                String str = "";
                if (value2 == null || (list2 = value2.getList()) == null || (yearPeriod2 = list2.get(i3)) == null || (yearMonthCode = yearPeriod2.getYearMonthCode()) == null) {
                    yearMonthCode = "";
                }
                sportTestChooseTimeVM.B(yearMonthCode);
                ((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).x(sportTestChooseDateAdapter.getCheckedIndex());
                SportTestChooseTimeVM sportTestChooseTimeVM2 = (SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState;
                String dayCode = fitnessTestPeriods.get(sportTestChooseDateAdapter.getCheckedIndex()).getDayCode();
                if (dayCode == null) {
                    dayCode = "";
                }
                sportTestChooseTimeVM2.w(dayCode);
                ((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).A(i4);
                SportTestChooseTimeVM sportTestChooseTimeVM3 = (SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState;
                List<ReservePeriod> list3 = reservePeriods;
                if (list3 == null || (reservePeriod3 = list3.get(i4)) == null || (timeFragmentCode = reservePeriod3.getTimeFragmentCode()) == null) {
                    timeFragmentCode = "";
                }
                sportTestChooseTimeVM3.z(timeFragmentCode);
                ((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).u().setValue(Boolean.TRUE);
                Long dayTimeStamp = fitnessTestPeriods.get(sportTestChooseDateAdapter.getCheckedIndex()).getDayTimeStamp();
                StringBuilder sb = new StringBuilder(v79.Q0(dayTimeStamp != null ? dayTimeStamp.longValue() : 0L, "yyyy/MM/dd"));
                sb.append("\n");
                List<ReservePeriod> reservePeriods2 = fitnessTestPeriods.get(sportTestChooseDateAdapter.getCheckedIndex()).getReservePeriods();
                if (reservePeriods2 != null && (reservePeriod = reservePeriods2.get(((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).getTimeIndex())) != null && (reservePeriod2 = reservePeriod.getReservePeriod()) != null) {
                    str = reservePeriod2;
                }
                sb.append(str);
                ((SportTestChooseTimeVM) ((BaseVMFragment) SportTestChooseTimeFragment.this).mState).n().setValue(sb.toString());
            }
        });
    }
}
