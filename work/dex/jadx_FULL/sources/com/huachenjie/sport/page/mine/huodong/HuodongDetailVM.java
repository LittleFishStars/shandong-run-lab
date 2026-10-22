package com.huachenjie.sport.page.mine.huodong;

import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.HuodongDetailBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.fv5;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00118\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\u001a8\u0006¢\u0006\f\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001eR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001a8\u0006¢\u0006\f\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001eR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001eR\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020 0\u001a8\u0006¢\u0006\f\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001eR\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001eR\u001d\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001eR\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010\u001eR\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u001c\u001a\u0004\b6\u0010\u001eR\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b8\u0010\u001eR\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b4\u0010\u001c\u001a\u0004\b:\u0010\u001eR\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b6\u0010\u001c\u001a\u0004\b<\u0010\u001eR\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a8\u0006¢\u0006\f\n\u0004\b.\u0010\u001c\u001a\u0004\b>\u0010\u001e¨\u0006B"}, d2 = {"Lcom/huachenjie/sport/page/mine/huodong/HuodongDetailVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "activityCode", "", "j", j.o, "", "timeMillion", "", "A", "Lcom/huachenjie/sport/api/SportModel;", "a", "Lcom/huachenjie/sport/api/SportModel;", j.b, "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "y", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "Lcom/huachenjie/sport/bean/HuodongDetailBean;", "huodongData", "Landroidx/lifecycle/MediatorLiveData;", "", "Landroidx/lifecycle/MediatorLiveData;", "s", "()Landroidx/lifecycle/MediatorLiveData;", "signButtonStatus", "", "b", "t", "signButtonVisible", "c", "r", "runButtonVisible", "d", "q", "runButtonText", "e", "p", "runButtonEnable", "f", "m", "huodongStartDay", y6b.f, "n", "huodongStartTime", y6b.g, "k", "huodongEndDay", t.d, "huodongEndTime", "w", "signStartDay", "x", "signStartTime", "u", "signEndDay", "v", "signEndTime", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongDetailVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Integer> signButtonStatus;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> signButtonVisible;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> runButtonVisible;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> runButtonText;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> runButtonEnable;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> huodongStartDay;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> huodongStartTime;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> huodongEndDay;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> huodongEndTime;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> signStartDay;

    /* JADX INFO: renamed from: j, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<HuodongDetailBean> huodongData;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> signStartTime;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> signEndDay;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> signEndTime;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final SportModel model = new SportModel();

    /* JADX INFO: renamed from: i, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/huodong/HuodongDetailVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/HuodongDetailBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<HuodongDetailBean> {
        public a() {
            super(HuodongDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable HuodongDetailBean data) {
            if (data == null) {
                return;
            }
            HuodongDetailVM.this.i().setValue(data);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36695a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36695a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36695a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36695a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/sport/page/mine/huodong/HuodongDetailVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<JSONObject> {
        public c() {
            super(HuodongDetailVM.this, true);
        }

        public void onFailed(int code, @Nullable String message) {
            super.onFailed(code, message);
            HuodongDetailBean huodongDetailBean = null;
            if (code == 5003) {
                MutableLiveData<HuodongDetailBean> mutableLiveDataI = HuodongDetailVM.this.i();
                HuodongDetailBean value = HuodongDetailVM.this.i().getValue();
                if (value != null) {
                    value.setSignUpStatus(7);
                    value.setActivityStatus(3);
                } else {
                    value = null;
                }
                mutableLiveDataI.setValue(value);
            }
            if (code == 5004) {
                MutableLiveData<HuodongDetailBean> mutableLiveDataI2 = HuodongDetailVM.this.i();
                HuodongDetailBean value2 = HuodongDetailVM.this.i().getValue();
                if (value2 != null) {
                    value2.setSignUpStatus(3);
                    value2.getSignUpCount();
                    value2.getSignUpLimit();
                    huodongDetailBean = value2;
                }
                mutableLiveDataI2.setValue(huodongDetailBean);
            }
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            MutableLiveData<HuodongDetailBean> mutableLiveDataI = HuodongDetailVM.this.i();
            HuodongDetailBean value = HuodongDetailVM.this.i().getValue();
            if (value != null) {
                value.setSignUpStatus(4);
                value.setSignUpCount(value.getSignUpCount() + 1);
                fv5.b("报名成功");
            } else {
                value = null;
            }
            mutableLiveDataI.setValue(value);
        }
    }

    public HuodongDetailVM() {
        MutableLiveData<HuodongDetailBean> mutableLiveData = new MutableLiveData<>();
        this.huodongData = mutableLiveData;
        MediatorLiveData<Integer> mediatorLiveData = new MediatorLiveData<>();
        this.signButtonStatus = mediatorLiveData;
        this.signButtonVisible = new MediatorLiveData<>();
        this.runButtonVisible = new MediatorLiveData<>();
        this.runButtonText = new MediatorLiveData<>("");
        this.runButtonEnable = new MediatorLiveData<>(Boolean.FALSE);
        MediatorLiveData<String> mediatorLiveData2 = new MediatorLiveData<>();
        this.huodongStartDay = mediatorLiveData2;
        this.huodongStartTime = new MediatorLiveData<>();
        this.huodongEndDay = new MediatorLiveData<>();
        this.huodongEndTime = new MediatorLiveData<>();
        this.signStartDay = new MediatorLiveData<>();
        this.signStartTime = new MediatorLiveData<>();
        this.signEndDay = new MediatorLiveData<>();
        this.signEndTime = new MediatorLiveData<>();
        mediatorLiveData.setValue(2);
        mediatorLiveData2.addSource(mutableLiveData, new b(new Function1<HuodongDetailBean, Unit>() { // from class: com.huachenjie.sport.page.mine.huodong.HuodongDetailVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HuodongDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(HuodongDetailBean huodongDetailBean) {
                HuodongDetailBean value = HuodongDetailVM.this.i().getValue();
                if (value != null) {
                    HuodongDetailVM huodongDetailVM = HuodongDetailVM.this;
                    List listA = huodongDetailVM.A(value.getActivityStartTime());
                    boolean z = false;
                    huodongDetailVM.m().setValue(listA.get(0));
                    huodongDetailVM.n().setValue(listA.get(1));
                    List listA2 = huodongDetailVM.A(value.getActivityEndTime());
                    huodongDetailVM.k().setValue(listA2.get(0));
                    huodongDetailVM.l().setValue(listA2.get(1));
                    List listA3 = huodongDetailVM.A(value.getSignUpStartTime());
                    huodongDetailVM.w().setValue(listA3.get(0));
                    huodongDetailVM.x().setValue(listA3.get(1));
                    List listA4 = huodongDetailVM.A(value.getSignUpEndTime());
                    huodongDetailVM.u().setValue(listA4.get(0));
                    huodongDetailVM.v().setValue(listA4.get(1));
                    huodongDetailVM.s().setValue(Integer.valueOf(value.getSignUpStatus()));
                    MediatorLiveData<Boolean> mediatorLiveDataT = huodongDetailVM.t();
                    if (value.getActivityStatus() != 4 && value.getActivityStatus() != 5 && value.getActivityStatus() != 6) {
                        z = true;
                    }
                    mediatorLiveDataT.setValue(Boolean.valueOf(z));
                    if (value.getActivityType() != 2) {
                        huodongDetailVM.r().setValue(Boolean.FALSE);
                        return;
                    }
                    if (value.getActivityStatus() != 4 || value.getSignUpStatus() != 4) {
                        if (value.getActivityStatus() != 6) {
                            huodongDetailVM.r().setValue(Boolean.FALSE);
                            return;
                        }
                        MediatorLiveData<Boolean> mediatorLiveDataR = huodongDetailVM.r();
                        Boolean bool = Boolean.TRUE;
                        mediatorLiveDataR.setValue(bool);
                        huodongDetailVM.q().setValue("查看结果");
                        huodongDetailVM.p().setValue(bool);
                        return;
                    }
                    MediatorLiveData<Boolean> mediatorLiveDataR2 = huodongDetailVM.r();
                    Boolean bool2 = Boolean.TRUE;
                    mediatorLiveDataR2.setValue(bool2);
                    if (value.getRunFlag()) {
                        huodongDetailVM.q().setValue("已完成");
                        huodongDetailVM.p().setValue(Boolean.FALSE);
                    } else {
                        huodongDetailVM.q().setValue("开始跑步");
                        huodongDetailVM.p().setValue(bool2);
                    }
                }
            }
        }));
    }

    public final List<String> A(long timeMillion) {
        return CollectionsKt.listOf(new String[]{new SimpleDateFormat("MM/dd", Locale.CHINA).format(new Date(timeMillion)), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(timeMillion))});
    }

    @NotNull
    public final MutableLiveData<HuodongDetailBean> i() {
        return this.huodongData;
    }

    public final void j(@NotNull String activityCode) {
        Intrinsics.checkNotNullParameter(activityCode, "activityCode");
        if (TextUtils.isEmpty(activityCode)) {
            fv5.b("未查询到活动code!");
        } else {
            this.model.C(activityCode).u5(Schedulers.io()).G3(d60.c()).p5(new a());
        }
    }

    @NotNull
    public final MediatorLiveData<String> k() {
        return this.huodongEndDay;
    }

    @NotNull
    public final MediatorLiveData<String> l() {
        return this.huodongEndTime;
    }

    @NotNull
    public final MediatorLiveData<String> m() {
        return this.huodongStartDay;
    }

    @NotNull
    public final MediatorLiveData<String> n() {
        return this.huodongStartTime;
    }

    @NotNull
    /* JADX INFO: renamed from: o, reason: from getter */
    public final SportModel getModel() {
        return this.model;
    }

    @NotNull
    public final MediatorLiveData<Boolean> p() {
        return this.runButtonEnable;
    }

    @NotNull
    public final MediatorLiveData<String> q() {
        return this.runButtonText;
    }

    @NotNull
    public final MediatorLiveData<Boolean> r() {
        return this.runButtonVisible;
    }

    @NotNull
    public final MediatorLiveData<Integer> s() {
        return this.signButtonStatus;
    }

    @NotNull
    public final MediatorLiveData<Boolean> t() {
        return this.signButtonVisible;
    }

    @NotNull
    public final MediatorLiveData<String> u() {
        return this.signEndDay;
    }

    @NotNull
    public final MediatorLiveData<String> v() {
        return this.signEndTime;
    }

    @NotNull
    public final MediatorLiveData<String> w() {
        return this.signStartDay;
    }

    @NotNull
    public final MediatorLiveData<String> x() {
        return this.signStartTime;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> y() {
        return this.titleBean;
    }

    public final void z(@Nullable String activityCode) {
        if (TextUtils.isEmpty(activityCode)) {
            fv5.b("未查询到活动code!");
            return;
        }
        SportModel sportModel = this.model;
        Intrinsics.checkNotNull(activityCode);
        sportModel.O(activityCode).u5(Schedulers.io()).G3(d60.c()).p5(new c());
    }
}
