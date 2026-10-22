package com.huachenjie.sport.page.mine.sport_test.time;

import android.app.Activity;
import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.FitnessTestPeriod;
import com.huachenjie.sport.bean.ReservePeriod;
import com.huachenjie.sport.bean.SportTestPeriodBean;
import com.huachenjie.sport.bean.YearPeriod;
import com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailActivity;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.fv5;
import com.zj.adlib.v79;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bE\u0010FJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0015\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b$\u0010\u0019R\"\u0010)\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0015\u001a\u0004\b+\u0010\u0017\"\u0004\b,\u0010\u0019R\"\u00101\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u001d\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001d\u00104\u001a\b\u0012\u0004\u0012\u0002020\r8\u0006¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b3\u0010\u0012R#\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0002050\r8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0010\u001a\u0004\b6\u0010\u0012R%\u0010;\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u000108080\r8\u0006¢\u0006\f\n\u0004\b3\u0010\u0010\u001a\u0004\b:\u0010\u0012R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R%\u0010@\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b<\u0010\u0010\u001a\u0004\b?\u0010\u0012R\u001d\u0010D\u001a\b\u0012\u0004\u0012\u0002080A8\u0006¢\u0006\f\n\u0004\b\b\u0010B\u001a\u0004\b*\u0010C¨\u0006G"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "code", "", "v", "D", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lkotlin/Lazy;", "k", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "r", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "f", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "B", "(Ljava/lang/String;)V", "yearCode", "", "K", "I", "t", "()I", "C", "(I)V", "yearIndex", y6b.f, "w", "dayCode", "L", "j", "x", "dayIndex", y6b.g, "p", j.o, "timeCode", "M", "q", "A", "timeIndex", "Lcom/huachenjie/sport/bean/SportTestPeriodBean;", t.d, "periodData", "", j.b, "tabTitles", "", "kotlin.jvm.PlatformType", "u", "isChangeSelect", "m", "y", "selectTimeCache", "n", "selectTimeString", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "()Landroidx/lifecycle/MediatorLiveData;", "confirmEnable", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestChooseTimeVM extends BaseVM {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int yearIndex;

    /* JADX INFO: renamed from: L, reason: from kotlin metadata */
    public int dayIndex;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> confirmEnable;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> selectTimeString;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m799invoke() {
            return new SportModel();
        }
    });

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String yearCode = "";

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public String dayCode = "";

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @Nullable
    public String timeCode = "";

    /* JADX INFO: renamed from: M, reason: from kotlin metadata */
    public int timeIndex = -1;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SportTestPeriodBean> periodData = new MutableLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<String>> tabTitles = new MutableLiveData<>();

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isChangeSelect = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: i, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String selectTimeCache = "";

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/SportTestPeriodBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<SportTestPeriodBean> {
        public a() {
            super(SportTestChooseTimeVM.this, true);
        }

        public void onCCSuccess(@Nullable SportTestPeriodBean data) {
            FitnessTestPeriod fitnessTestPeriod;
            YearPeriod yearPeriod;
            if (data == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            try {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                if (!TextUtils.isEmpty(SportTestChooseTimeVM.this.getYearCode()) && data.getList() != null) {
                    int i2 = 0;
                    for (YearPeriod yearPeriod2 : data.getList()) {
                        int i3 = i2 + 1;
                        String yearMonth = yearPeriod2.getYearMonth();
                        if (yearMonth == null) {
                            yearMonth = "";
                        }
                        arrayList.add(yearMonth);
                        if (Intrinsics.areEqual(SportTestChooseTimeVM.this.getYearCode(), yearPeriod2.getYearMonthCode())) {
                            SportTestChooseTimeVM.this.C(i2);
                        }
                        i2 = i3;
                    }
                }
                List<YearPeriod> list = data.getList();
                List<ReservePeriod> reservePeriods = null;
                List<FitnessTestPeriod> fitnessTestPeriods = (list == null || (yearPeriod = list.get(SportTestChooseTimeVM.this.getYearIndex())) == null) ? null : yearPeriod.getFitnessTestPeriods();
                if (!TextUtils.isEmpty(SportTestChooseTimeVM.this.getYearCode()) && !TextUtils.isEmpty(SportTestChooseTimeVM.this.getDayCode()) && fitnessTestPeriods != null) {
                    int i4 = 0;
                    for (FitnessTestPeriod fitnessTestPeriod2 : fitnessTestPeriods) {
                        int i5 = i4 + 1;
                        if (Intrinsics.areEqual(SportTestChooseTimeVM.this.getDayCode(), fitnessTestPeriod2.getDayCode())) {
                            SportTestChooseTimeVM.this.x(i4);
                            Long dayTimeStamp = fitnessTestPeriod2.getDayTimeStamp();
                            sb.append(v79.Q0(dayTimeStamp != null ? dayTimeStamp.longValue() : 0L, "yyyy/MM/dd"));
                            sb.append("\n");
                        }
                        i4 = i5;
                    }
                }
                if (fitnessTestPeriods != null && (fitnessTestPeriod = fitnessTestPeriods.get(SportTestChooseTimeVM.this.getDayIndex())) != null) {
                    reservePeriods = fitnessTestPeriod.getReservePeriods();
                }
                if (!TextUtils.isEmpty(SportTestChooseTimeVM.this.getYearCode()) && !TextUtils.isEmpty(SportTestChooseTimeVM.this.getDayCode()) && !TextUtils.isEmpty(SportTestChooseTimeVM.this.getTimeCode()) && reservePeriods != null) {
                    for (ReservePeriod reservePeriod : reservePeriods) {
                        int i6 = i + 1;
                        if (Intrinsics.areEqual(SportTestChooseTimeVM.this.getTimeCode(), reservePeriod.getTimeFragmentCode())) {
                            SportTestChooseTimeVM.this.A(i);
                            sb.append(reservePeriod.getReservePeriod());
                            SportTestChooseTimeVM sportTestChooseTimeVM = SportTestChooseTimeVM.this;
                            String string = sb.toString();
                            Intrinsics.checkNotNullExpressionValue(string, "sb.toString()");
                            sportTestChooseTimeVM.y(string);
                            SportTestChooseTimeVM.this.n().setValue(sb.toString());
                        }
                        i = i6;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            SportTestChooseTimeVM.this.o().setValue(arrayList);
            SportTestChooseTimeVM.this.l().setValue(data);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36745a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36745a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36745a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36745a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/time/SportTestChooseTimeVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<Object> {
        public c(SportTestChooseTimeVM sportTestChooseTimeVM) {
            super(sportTestChooseTimeVM, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            fv5.b("预约成功!");
            Activity activityC = ActivityLifecycleManager.l().c(SportTestDetailActivity.class);
            if (activityC != null) {
                activityC.finish();
            }
            Activity activityC2 = ActivityLifecycleManager.l().c(SportTestChooseTimeActivity.class);
            if (activityC2 != null) {
                activityC2.finish();
            }
        }
    }

    public SportTestChooseTimeVM() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>("");
        this.selectTimeString = mutableLiveData;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        this.confirmEnable = mediatorLiveData;
        mediatorLiveData.addSource(mutableLiveData, new b(new Function1<String, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseTimeVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                SportTestChooseTimeVM.this.h().setValue(Boolean.valueOf(!Intrinsics.areEqual(SportTestChooseTimeVM.this.getSelectTimeCache(), str)));
            }
        }));
    }

    public final void A(int i) {
        this.timeIndex = i;
    }

    public final void B(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.yearCode = str;
    }

    public final void C(int i) {
        this.yearIndex = i;
    }

    public final void D(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        k().N(code, this.yearCode, this.dayCode, this.timeCode).u5(Schedulers.io()).G3(d60.c()).p5(new c(this));
    }

    @NotNull
    public final MediatorLiveData<Boolean> h() {
        return this.confirmEnable;
    }

    @NotNull
    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getDayCode() {
        return this.dayCode;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final int getDayIndex() {
        return this.dayIndex;
    }

    public final SportModel k() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<SportTestPeriodBean> l() {
        return this.periodData;
    }

    @NotNull
    /* JADX INFO: renamed from: m, reason: from getter */
    public final String getSelectTimeCache() {
        return this.selectTimeCache;
    }

    @NotNull
    public final MutableLiveData<String> n() {
        return this.selectTimeString;
    }

    @NotNull
    public final MutableLiveData<List<String>> o() {
        return this.tabTitles;
    }

    @Nullable
    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getTimeCode() {
        return this.timeCode;
    }

    /* JADX INFO: renamed from: q, reason: from getter */
    public final int getTimeIndex() {
        return this.timeIndex;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> r() {
        return this.titleBean;
    }

    @NotNull
    /* JADX INFO: renamed from: s, reason: from getter */
    public final String getYearCode() {
        return this.yearCode;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final int getYearIndex() {
        return this.yearIndex;
    }

    @NotNull
    public final MutableLiveData<Boolean> u() {
        return this.isChangeSelect;
    }

    public final void v(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        k().G(code).u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dayCode = str;
    }

    public final void x(int i) {
        this.dayIndex = i;
    }

    public final void y(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectTimeCache = str;
    }

    public final void z(@Nullable String str) {
        this.timeCode = str;
    }
}
