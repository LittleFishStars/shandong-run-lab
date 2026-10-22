package com.huachenjie.sport.page.mine.choose_classes;

import android.text.TextUtils;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.alibaba.fastjson.JSONObject;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.sport.R;
import com.huachenjie.sport.api.SportModel;
import com.huachenjie.sport.bean.ClassDetailBean;
import com.huachenjie.sport.bean.RemainCountBean;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.gq1;
import com.zj.adlib.n76;
import com.zj.adlib.s72;
import com.zj.adlib.y6b;
import com.zj.adlib.ze1;
import com.zj.adlib.zn1;
import huachenjie.sdk.http.subscriber.DialogVMSubscriber;
import java.util.Date;
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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bQ\u0010RJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020 8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020%8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010(R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00118\u0006¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0\u00118\u0006¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020.0\u00118\u0006¢\u0006\f\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016R\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020.0\u00118\u0006¢\u0006\f\n\u0004\b,\u0010\u0014\u001a\u0004\b5\u0010\u0016R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0006¢\u0006\f\n\u0004\b\u0019\u00108\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0006¢\u0006\f\n\u0004\b&\u00108\u001a\u0004\b2\u0010:R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u0018078\u0006¢\u0006\f\n\u0004\b=\u00108\u001a\u0004\b>\u0010:R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0018078\u0006¢\u0006\f\n\u0004\b@\u00108\u001a\u0004\bA\u0010:R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\u0018078\u0006¢\u0006\f\n\u0004\bC\u00108\u001a\u0004\bD\u0010:R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u0006078\u0006¢\u0006\f\n\u0004\b\n\u00108\u001a\u0004\b+\u0010:R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u00118\u0006¢\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016R\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020G0\u00118\u0006¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b/\u0010\u0016R%\u0010L\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010G0G0\u00118\u0006¢\u0006\f\n\u0004\b0\u0010\u0014\u001a\u0004\bK\u0010\u0016R%\u0010N\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010\u00060\u00060\u00118\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\bM\u0010\u0016R%\u0010P\u001a\u0010\u0012\f\u0012\n J*\u0004\u0018\u00010\u00180\u00180\u00118\u0006¢\u0006\f\n\u0004\b\"\u0010\u0014\u001a\u0004\bO\u0010\u0016¨\u0006S"}, d2 = {"Lcom/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "E", "D", y6b.g, "", "courseCode", "q", "F", "f", "Ljava/lang/String;", "n", "()Ljava/lang/String;", "G", "(Ljava/lang/String;)V", "code", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "i", "Landroidx/lifecycle/MutableLiveData;", "y", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "", "a", "Z", j.o, "()Z", "H", "(Z)V", ClassesDetailActivity.y, "Lcom/huachenjie/sport/api/SportModel;", "Lkotlin/Lazy;", "r", "()Lcom/huachenjie/sport/api/SportModel;", ze1.k, "Lcom/zj/adlib/gq1;", "b", j.b, "()Lcom/zj/adlib/gq1;", "commonModel", "Lcom/huachenjie/sport/bean/ClassDetailBean;", "j", "m", "classDetailData", "", "k", "p", "courseEndTime", t.d, "w", "serverTime", "s", "newServerTime", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "t", "()Landroidx/lifecycle/MediatorLiveData;", "remainCountString", "classCountString", "c", "C", "isShowLocation", "d", "B", "isShowIntroduction", "e", "A", "isShowButton", "buttonString", "", "buttonColor", "buttonTextColor", "kotlin.jvm.PlatformType", "v", "resetCourseCount", "u", "resetCourseCode", "x", "startChooseCourse", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class ClassesDetailVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> remainCountString;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isFromMyCourse;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> classCountString;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> isShowLocation;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> isShowIntroduction;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> isShowButton;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MediatorLiveData<String> buttonString;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<ClassDetailBean> classDetailData;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Long> courseEndTime;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Long> serverTime;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Long> newServerTime;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> buttonColor;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> buttonTextColor;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> resetCourseCount;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> resetCourseCode;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> startChooseCourse;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String code = "";

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy model = LazyKt.lazy(new Function0<SportModel>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailVM$model$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SportModel m772invoke() {
            return new SportModel();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy commonModel = LazyKt.lazy(new Function0<gq1>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailVM$commonModel$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final gq1 m771invoke() {
            return new gq1();
        }
    });

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM$a", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends DialogVMSubscriber<JSONObject> {
        public a() {
            super(ClassesDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data != null) {
                ClassesDetailVM classesDetailVM = ClassesDetailVM.this;
                if (data.containsKey("serverTime")) {
                    classesDetailVM.s().setValue(Long.valueOf(data.getLongValue("serverTime")));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM$b", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/RemainCountBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends DialogVMSubscriber<RemainCountBean> {
        public final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(ClassesDetailVM.this, true);
            this.f = str;
        }

        public void onCCSuccess(@Nullable RemainCountBean data) {
            Integer remainCount;
            if (data == null || (remainCount = data.getRemainCount()) == null) {
                return;
            }
            ClassesDetailVM classesDetailVM = ClassesDetailVM.this;
            String str = this.f;
            classesDetailVM.v().setValue(Integer.valueOf(remainCount.intValue()));
            classesDetailVM.u().setValue(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM$c", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/huachenjie/sport/bean/ClassDetailBean;", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends DialogVMSubscriber<ClassDetailBean> {
        public c() {
            super(ClassesDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable ClassDetailBean data) {
            if (data != null) {
                ClassesDetailVM classesDetailVM = ClassesDetailVM.this;
                Date dateI = s72.i(data.getElectiveEndDate(), "yyyy-MM-dd HH:mm");
                if (dateI != null) {
                    Intrinsics.checkNotNullExpressionValue(dateI, "date");
                    classesDetailVM.p().setValue(Long.valueOf(dateI.getTime()));
                }
            }
            ClassesDetailVM.this.m().setValue(data);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0006\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM$d", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "Lcom/alibaba/fastjson/JSONObject;", "data", "", "onCCSuccess", "onFinish", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends DialogVMSubscriber<JSONObject> {
        public d() {
            super(ClassesDetailVM.this, false);
        }

        public void onFinish() {
            ClassesDetailVM.this.D();
        }

        public void onCCSuccess(@Nullable JSONObject data) {
            if (data != null) {
                ClassesDetailVM classesDetailVM = ClassesDetailVM.this;
                if (data.containsKey("serverTime")) {
                    classesDetailVM.w().setValue(Long.valueOf(data.getLongValue("serverTime")));
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0006"}, d2 = {"com/huachenjie/sport/page/mine/choose_classes/ClassesDetailVM$e", "Lhuachenjie/sdk/http/subscriber/DialogVMSubscriber;", "", "data", "", "onCCSuccess", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class e extends DialogVMSubscriber<Object> {
        public e() {
            super(ClassesDetailVM.this, true);
        }

        public void onCCSuccess(@Nullable Object data) {
            ClassesDetailVM.this.u().setValue("");
            ClassesDetailVM.this.x().setValue(Boolean.TRUE);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class f implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f36638a;

        public f(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f36638a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f36638a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f36638a.invoke(obj);
        }
    }

    public ClassesDetailVM() {
        MutableLiveData<ClassDetailBean> mutableLiveData = new MutableLiveData<>();
        this.classDetailData = mutableLiveData;
        this.courseEndTime = new MutableLiveData<>();
        this.serverTime = new MutableLiveData<>();
        this.newServerTime = new MutableLiveData<>();
        MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();
        this.remainCountString = mediatorLiveData;
        this.classCountString = new MediatorLiveData<>();
        this.isShowLocation = new MediatorLiveData<>();
        this.isShowIntroduction = new MediatorLiveData<>();
        MediatorLiveData<Boolean> mediatorLiveData2 = new MediatorLiveData<>();
        this.isShowButton = mediatorLiveData2;
        this.buttonString = new MediatorLiveData<>();
        this.buttonColor = new MutableLiveData<>(Integer.valueOf(zn1.a(R.color.color_main_v2)));
        this.buttonTextColor = new MutableLiveData<>(Integer.valueOf(zn1.a(R.color.white)));
        this.resetCourseCount = new MutableLiveData<>(-1);
        this.resetCourseCode = new MutableLiveData<>("");
        this.startChooseCourse = new MutableLiveData<>(Boolean.FALSE);
        mediatorLiveData.addSource(mutableLiveData, new f(new Function1<ClassDetailBean, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ClassDetailBean classDetailBean) {
                MediatorLiveData<String> mediatorLiveDataT = ClassesDetailVM.this.t();
                StringBuilder sb = new StringBuilder();
                sb.append(classDetailBean.getRemainCount());
                sb.append((char) 20154);
                mediatorLiveDataT.setValue(sb.toString());
                MediatorLiveData<String> mediatorLiveDataL = ClassesDetailVM.this.l();
                StringBuilder sb2 = new StringBuilder();
                sb2.append(classDetailBean.getCourseCount());
                sb2.append((char) 20154);
                mediatorLiveDataL.setValue(sb2.toString());
                ClassesDetailVM.this.C().setValue(Boolean.valueOf(!TextUtils.isEmpty(classDetailBean.getCourseLocation())));
                ClassesDetailVM.this.B().setValue(Boolean.valueOf(!TextUtils.isEmpty(classDetailBean.getCourseIntroduction())));
            }
        }));
        mediatorLiveData2.addSource(mutableLiveData, new f(new Function1<ClassDetailBean, Unit>() { // from class: com.huachenjie.sport.page.mine.choose_classes.ClassesDetailVM.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ClassDetailBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ClassDetailBean classDetailBean) {
                Long value = ClassesDetailVM.this.w().getValue();
                if (value == null) {
                    value = Long.valueOf(System.currentTimeMillis());
                }
                long jLongValue = value.longValue();
                Long value2 = ClassesDetailVM.this.p().getValue();
                if (value2 == null) {
                    value2 = 0L;
                }
                long jLongValue2 = value2.longValue();
                MediatorLiveData<Boolean> mediatorLiveDataA = ClassesDetailVM.this.A();
                Boolean bool = Boolean.TRUE;
                mediatorLiveDataA.setValue(bool);
                if (jLongValue > jLongValue2) {
                    ClassesDetailVM.this.A().setValue(Boolean.FALSE);
                    return;
                }
                if (ClassesDetailVM.this.getIsFromMyCourse()) {
                    ClassesDetailVM.this.j().setValue("重新选课");
                    ClassesDetailVM.this.i().setValue(Integer.valueOf(zn1.a(R.color.color_main_v2)));
                    ClassesDetailVM.this.k().setValue(Integer.valueOf(zn1.a(R.color.white)));
                } else {
                    if (Intrinsics.areEqual(classDetailBean.getSelected(), bool)) {
                        ClassesDetailVM.this.j().setValue("我已选课");
                        ClassesDetailVM.this.i().setValue(Integer.valueOf(zn1.a(R.color.color_D7D7D7)));
                        ClassesDetailVM.this.k().setValue(Integer.valueOf(zn1.a(R.color.black)));
                        return;
                    }
                    Integer remainCount = classDetailBean.getRemainCount();
                    if ((remainCount != null ? remainCount.intValue() : 0) <= 0) {
                        ClassesDetailVM.this.j().setValue("名额已满");
                        ClassesDetailVM.this.i().setValue(Integer.valueOf(zn1.a(R.color.color_D7D7D7)));
                        ClassesDetailVM.this.k().setValue(Integer.valueOf(zn1.a(R.color.black)));
                    } else {
                        ClassesDetailVM.this.j().setValue("我要选课");
                        ClassesDetailVM.this.i().setValue(Integer.valueOf(zn1.a(R.color.color_main_v2)));
                        ClassesDetailVM.this.k().setValue(Integer.valueOf(zn1.a(R.color.white)));
                    }
                }
            }
        }));
    }

    @NotNull
    public final MediatorLiveData<Boolean> A() {
        return this.isShowButton;
    }

    @NotNull
    public final MediatorLiveData<Boolean> B() {
        return this.isShowIntroduction;
    }

    @NotNull
    public final MediatorLiveData<Boolean> C() {
        return this.isShowLocation;
    }

    public final void D() {
        n76.e(this, r().q(this.code)).p5(new c());
    }

    public final void E() {
        n76.e(this, o().C()).p5(new d());
    }

    public final void F() {
        n76.e(this, r().L(this.resetCourseCode.getValue())).p5(new e());
    }

    public final void G(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.code = str;
    }

    public final void H(boolean z) {
        this.isFromMyCourse = z;
    }

    public final void h() {
        n76.e(this, o().C()).p5(new a());
    }

    @NotNull
    public final MutableLiveData<Integer> i() {
        return this.buttonColor;
    }

    @NotNull
    public final MediatorLiveData<String> j() {
        return this.buttonString;
    }

    @NotNull
    public final MutableLiveData<Integer> k() {
        return this.buttonTextColor;
    }

    @NotNull
    public final MediatorLiveData<String> l() {
        return this.classCountString;
    }

    @NotNull
    public final MutableLiveData<ClassDetailBean> m() {
        return this.classDetailData;
    }

    @NotNull
    /* JADX INFO: renamed from: n, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final gq1 o() {
        return (gq1) this.commonModel.getValue();
    }

    @NotNull
    public final MutableLiveData<Long> p() {
        return this.courseEndTime;
    }

    public final void q(@NotNull String courseCode) {
        Intrinsics.checkNotNullParameter(courseCode, "courseCode");
        n76.e(this, r().g(courseCode)).p5(new b(courseCode));
    }

    @NotNull
    public final SportModel r() {
        return (SportModel) this.model.getValue();
    }

    @NotNull
    public final MutableLiveData<Long> s() {
        return this.newServerTime;
    }

    @NotNull
    public final MediatorLiveData<String> t() {
        return this.remainCountString;
    }

    @NotNull
    public final MutableLiveData<String> u() {
        return this.resetCourseCode;
    }

    @NotNull
    public final MutableLiveData<Integer> v() {
        return this.resetCourseCount;
    }

    @NotNull
    public final MutableLiveData<Long> w() {
        return this.serverTime;
    }

    @NotNull
    public final MutableLiveData<Boolean> x() {
        return this.startChooseCourse;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> y() {
        return this.titleBean;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public final boolean getIsFromMyCourse() {
        return this.isFromMyCourse;
    }
}
