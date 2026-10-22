package com.huachenjie.sport.page.mine.sport_test.detail;

import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.R;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.SportTestDetailBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.v79;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0006¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R%\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u001c*\u0004\u0018\u00010\u001b0\u001b0\u00068\u0006¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0013\u0010\u000bR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u0019¨\u0006#"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "code", "", "n", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lkotlin/Lazy;", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Lcom/huachenjie/sport/bean/SportTestDetailBean;", "j", y6b.g, "detailData", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "k", "()Landroidx/lifecycle/MediatorLiveData;", "testStatusString", "", "kotlin.jvm.PlatformType", "testStatusBgColor", "b", t.d, "testTimeString", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestDetailVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> testStatusString;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> testTimeString;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SportTestDetailBean> detailData;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> testStatusBgColor;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m788invoke() {
            return new SportModel();
        }
    });

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/sport_test/detail/SportTestDetailVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/SportTestDetailBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<SportTestDetailBean> {
        public a() {
            super(SportTestDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable SportTestDetailBean data) {
            if (data == null) {
                return;
            }
            SportTestDetailVM.this.h().setValue(data);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36720a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36720a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36720a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36720a.invoke(obj);
        }
    }

    public SportTestDetailVM() {
        MutableLiveData<SportTestDetailBean> mutableLiveData = new MutableLiveData<>();
        this.detailData = mutableLiveData;
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.testStatusString = mediatorLiveData;
        this.testStatusBgColor = new MutableLiveData<>(Integer.valueOf(zn1.a(R.color.color_8997A4)));
        this.testTimeString = new MediatorLiveData<>();
        mediatorLiveData.addSource(mutableLiveData, new b(new Function1<SportTestDetailBean, Unit>() { // from class: com.huachenjie.sport.page.mine.sport_test.detail.SportTestDetailVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SportTestDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SportTestDetailBean sportTestDetailBean) {
                String string;
                StringBuilder sb = new StringBuilder();
                Integer fitnessType = sportTestDetailBean.getFitnessType();
                if (fitnessType != null && fitnessType.intValue() == 3) {
                    sb.append("补测");
                } else {
                    sb.append("体测");
                }
                Integer fitnessTestStatus = sportTestDetailBean.getFitnessTestStatus();
                if (fitnessTestStatus != null && fitnessTestStatus.intValue() == 1) {
                    sb.append("待开始");
                    SportTestDetailVM.this.j().setValue(Integer.valueOf(zn1.a(R.color.color_main_v2)));
                } else if (fitnessTestStatus != null && fitnessTestStatus.intValue() == 2) {
                    sb.append("进行中");
                    SportTestDetailVM.this.j().setValue(Integer.valueOf(zn1.a(R.color.color_FF762F)));
                } else {
                    sb.append("已结束");
                    SportTestDetailVM.this.j().setValue(Integer.valueOf(zn1.a(R.color.color_8997A4)));
                }
                SportTestDetailVM.this.k().setValue(sb.toString());
                MediatorLiveData<String> mediatorLiveDataL = SportTestDetailVM.this.l();
                Integer reserveTimeStatus = sportTestDetailBean.getReserveTimeStatus();
                if (reserveTimeStatus != null && reserveTimeStatus.intValue() == 1) {
                    StringBuilder sb2 = new StringBuilder();
                    Long reserveStartTime = sportTestDetailBean.getReserveStartTime();
                    sb2.append(v79.Q0(reserveStartTime != null ? reserveStartTime.longValue() : 0L, "yyyy/MM/dd HH:mm"));
                    sb2.append("开始预约");
                    string = sb2.toString();
                } else if (reserveTimeStatus != null && reserveTimeStatus.intValue() == 2) {
                    StringBuilder sb3 = new StringBuilder();
                    Long reserveEndTime = sportTestDetailBean.getReserveEndTime();
                    sb3.append(v79.Q0(reserveEndTime != null ? reserveEndTime.longValue() : 0L, "yyyy/MM/dd HH:mm"));
                    sb3.append("结束预约");
                    string = sb3.toString();
                } else {
                    string = "";
                }
                mediatorLiveDataL.setValue(string);
            }
        }));
    }

    @NotNull
    public final MutableLiveData<SportTestDetailBean> h() {
        return this.detailData;
    }

    @NotNull
    public final SportModel i() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<Integer> j() {
        return this.testStatusBgColor;
    }

    @NotNull
    public final MediatorLiveData<String> k() {
        return this.testStatusString;
    }

    @NotNull
    public final MediatorLiveData<String> l() {
        return this.testTimeString;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> m() {
        return this.titleBean;
    }

    public final void n(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        i().E(code).u5(Schedulers.io()).G3(d60.c()).p5(new a());
    }
}
