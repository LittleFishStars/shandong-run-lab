package com.huachenjie.run.page.activities_run;

import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.amap.api.fence.GeoFence;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.DanmuBean;
import com.huachenjie.run.bean.NearRunStd;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.model.RunRequestModel;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ll7;
import com.zj.adlib.r90;
import com.zj.adlib.y6b;
import com.zj.adlib.ye3;
import com.zj.adlib.ys8;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b[\u0010\\J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u001b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000eJ\u0017\u0010\u001a\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\u001e\u001a\u00020\nR\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001f\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001f8\u0006¢\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020)0\u001f8\u0006¢\u0006\f\n\u0004\b*\u0010\"\u001a\u0004\b+\u0010$R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060-0\u001f8\u0006¢\u0006\f\n\u0004\b.\u0010\"\u001a\u0004\b/\u0010$R\u001f\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001010\u001f8\u0006¢\u0006\f\n\u0004\b2\u0010\"\u001a\u0004\b3\u0010$R\u001f\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050\u001f8\u0006¢\u0006\f\n\u0004\b6\u0010\"\u001a\u0004\b7\u0010$R%\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u000209\u0018\u00010-0\u001f8\u0006¢\u0006\f\n\u0004\b:\u0010\"\u001a\u0004\b;\u0010$R\u001f\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001f8\u0006¢\u0006\f\n\u0004\b=\u0010\"\u001a\u0004\b>\u0010$R%\u0010C\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u000e0\u000e0\u001f8\u0006¢\u0006\f\n\u0004\bA\u0010\"\u001a\u0004\bB\u0010$R%\u0010F\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u000e0\u000e0\u001f8\u0006¢\u0006\f\n\u0004\bD\u0010\"\u001a\u0004\bE\u0010$R%\u0010J\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010G0G0\u001f8\u0006¢\u0006\f\n\u0004\bH\u0010\"\u001a\u0004\bI\u0010$R%\u0010M\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010G0G0\u001f8\u0006¢\u0006\f\n\u0004\bK\u0010\"\u001a\u0004\bL\u0010$R%\u0010O\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u000e0\u000e0\u001f8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\"\u001a\u0004\bN\u0010$R%\u0010Q\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010\u000e0\u000e0\u001f8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\"\u001a\u0004\bP\u0010$R%\u0010S\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010G0G0\u001f8\u0006¢\u0006\f\n\u0004\b\b\u0010\"\u001a\u0004\bR\u0010$R\u001f\u0010U\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u001f8\u0006¢\u0006\f\n\u0004\b7\u0010\"\u001a\u0004\bT\u0010$R%\u0010Z\u001a\u0010\u0012\f\u0012\n @*\u0004\u0018\u00010G0G0V8\u0006¢\u0006\f\n\u0004\b!\u0010W\u001a\u0004\bX\u0010Y\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ReadyVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "K", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lcom/huachenjie/common/bean/GeoFenceDetail;", GeoFence.BUNDLE_KEY_FENCE, j.b, "Q", "", "pickedKm", "L", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "", "schoolCode", "N", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "detail", "n", "J", "T", "M", "G", "content", "R", "m", "(Ljava/lang/Integer;)V", "O", "I", "H", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/BindingTitleBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "D", "()Landroidx/lifecycle/MutableLiveData;", "titleBean", "b", "C", ReadyActivity.y, "Lcom/huachenjie/run/bean/RunPlanBean;", "c", "q", ReadyActivity.x, "", "d", "s", "geoFenceListData", "Lcom/huachenjie/run/bean/NearRunStd;", "e", "w", "nearRunStd", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "f", "p", "centerPointLiveData", "Lcom/huachenjie/run/bean/DanmuBean;", y6b.f, "r", "danmuList", y6b.g, j.o, "selectedTargetKm", "kotlin.jvm.PlatformType", "i", "u", "goalValueText", "j", "t", "goalTipText", "", "k", "A", "showGoalTip", t.d, "x", "noGoalSelected", "y", "runningCountText", "E", "totalDistanceText", "F", "isNfcCheckedIn", "v", "myUsableFence", "Landroidx/lifecycle/MediatorLiveData;", "Landroidx/lifecycle/MediatorLiveData;", "B", "()Landroidx/lifecycle/MediatorLiveData;", "showNfcCheckIn", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public final class ReadyVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MediatorLiveData<Boolean> showNfcCheckIn;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<BindingTitleBean> titleBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<SunshineRunDetail> sunshineRunDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<RunPlanBean> currentRunPlan;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<GeoFenceDetail>> geoFenceListData;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<NearRunStd> nearRunStd;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<HCJLatLng> centerPointLiveData;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<DanmuBean>> danmuList;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selectedTargetKm;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> goalValueText;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> goalTipText;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> showGoalTip;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> noGoalSelected;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> runningCountText;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> totalDistanceText;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isNfcCheckedIn;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<GeoFenceDetail> myUsableFence;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35785a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35785a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35785a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35785a.invoke(obj);
        }
    }

    public ReadyVM() {
        MutableLiveData<RunPlanBean> mutableLiveData = new MutableLiveData<>();
        this.currentRunPlan = mutableLiveData;
        this.geoFenceListData = new MutableLiveData<>();
        this.nearRunStd = new MutableLiveData<>();
        this.centerPointLiveData = new MutableLiveData<>();
        this.danmuList = new MutableLiveData<>();
        this.selectedTargetKm = new MutableLiveData<>(null);
        this.goalValueText = new MutableLiveData<>("0.0");
        this.goalTipText = new MutableLiveData<>("");
        Boolean bool = Boolean.FALSE;
        this.showGoalTip = new MutableLiveData<>(bool);
        this.noGoalSelected = new MutableLiveData<>(bool);
        this.runningCountText = new MutableLiveData<>("0");
        this.totalDistanceText = new MutableLiveData<>("0");
        this.isNfcCheckedIn = new MutableLiveData<>(bool);
        MutableLiveData<GeoFenceDetail> mutableLiveData2 = new MutableLiveData<>();
        this.myUsableFence = mutableLiveData2;
        final MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>(bool);
        mediatorLiveData.addSource(mutableLiveData, new a(new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyVM$showNfcCheckIn$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunPlanBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RunPlanBean runPlanBean) {
                ReadyVM.S(mediatorLiveData, this);
            }
        }));
        mediatorLiveData.addSource(mutableLiveData2, new a(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyVM$showNfcCheckIn$1$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable GeoFenceDetail geoFenceDetail) {
                ReadyVM.S(mediatorLiveData, this);
            }
        }));
        this.showNfcCheckIn = mediatorLiveData;
    }

    public static final void S(MediatorLiveData<Boolean> mediatorLiveData, ReadyVM readyVM) {
        RunPlanBean value = readyVM.currentRunPlan.getValue();
        boolean z = false;
        if ((value != null ? value.getTouchCheckType() : 0) == 1) {
            GeoFenceDetail value2 = readyVM.myUsableFence.getValue();
            if (value2 != null && value2.isAliTapEnable()) {
                z = true;
            }
        }
        mediatorLiveData.setValue(Boolean.valueOf(z));
    }

    @NotNull
    public final MutableLiveData<Boolean> A() {
        return this.showGoalTip;
    }

    @NotNull
    public final MediatorLiveData<Boolean> B() {
        return this.showNfcCheckIn;
    }

    @NotNull
    public final MutableLiveData<SunshineRunDetail> C() {
        return this.sunshineRunDetail;
    }

    @NotNull
    public final MutableLiveData<BindingTitleBean> D() {
        return this.titleBean;
    }

    @NotNull
    public final MutableLiveData<String> E() {
        return this.totalDistanceText;
    }

    @NotNull
    public final MutableLiveData<Boolean> F() {
        return this.isNfcCheckedIn;
    }

    public final void G() {
        BaseViewModelExtKt.b(this, false, false, null, null, new ReadyVM$loadLatestBarrage$1(this, null), 15, null);
    }

    public final int H() {
        return MoreDistanceDialog.INSTANCE.f(I());
    }

    public final int I() {
        SchoolRule schoolDemandRule;
        SunshineRunDetail value = this.sunshineRunDetail.getValue();
        return (int) ((value == null || (schoolDemandRule = value.getSchoolDemandRule()) == null) ? 0L : schoolDemandRule.getSingleMinDistance());
    }

    public final void J() {
        BaseViewModelExtKt.b(this, true, false, null, null, new ReadyVM$nearbyRunStd$1(this, null), 14, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object K(Continuation<? super Unit> continuation) {
        ReadyVM$nearbyRunStdInternal$1 readyVM$nearbyRunStdInternal$1;
        ReadyVM readyVM;
        List<NearRunStd.RunUserList> runUserList;
        if (continuation instanceof ReadyVM$nearbyRunStdInternal$1) {
            readyVM$nearbyRunStdInternal$1 = (ReadyVM$nearbyRunStdInternal$1) continuation;
            int i = readyVM$nearbyRunStdInternal$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                readyVM$nearbyRunStdInternal$1.label = i - Integer.MIN_VALUE;
            } else {
                readyVM$nearbyRunStdInternal$1 = new ReadyVM$nearbyRunStdInternal$1(this, continuation);
            }
        } else {
            readyVM$nearbyRunStdInternal$1 = new ReadyVM$nearbyRunStdInternal$1(this, continuation);
        }
        Object objM = readyVM$nearbyRunStdInternal$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = readyVM$nearbyRunStdInternal$1.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM);
            RunRequestModel runRequestModel = RunRequestModel.f35764a;
            readyVM$nearbyRunStdInternal$1.L$0 = this;
            readyVM$nearbyRunStdInternal$1.label = 1;
            objM = runRequestModel.m(readyVM$nearbyRunStdInternal$1);
            if (objM == coroutine_suspended) {
                return coroutine_suspended;
            }
            readyVM = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            readyVM = (ReadyVM) readyVM$nearbyRunStdInternal$1.L$0;
            ResultKt.throwOnFailure(objM);
        }
        NearRunStd nearRunStd = (NearRunStd) objM;
        readyVM.nearRunStd.setValue(nearRunStd);
        readyVM.runningCountText.setValue(String.valueOf(nearRunStd != null ? nearRunStd.getTotalStudent() : 0));
        MutableLiveData<String> mutableLiveData = readyVM.totalDistanceText;
        String strA = ll7.f43096a.a(nearRunStd != null ? nearRunStd.getTotalDistance() : 0L, 0);
        if (strA == null) {
            strA = "";
        }
        mutableLiveData.setValue(strA);
        NearRunStd.RunUserList runUserList2 = (nearRunStd == null || (runUserList = nearRunStd.getRunUserList()) == null) ? null : (NearRunStd.RunUserList) CollectionsKt.firstOrNull(runUserList);
        if (runUserList2 != null) {
            readyVM.centerPointLiveData.setValue(new HCJLatLng(runUserList2.getLat(), runUserList2.getLng()));
        }
        if (readyVM.myUsableFence.getValue() == null) {
            List<GeoFenceDetail> value = readyVM.geoFenceListData.getValue();
            if (value != null && !value.isEmpty()) {
                z = false;
            }
            if (!z) {
                readyVM.P();
            }
        }
        return Unit.INSTANCE;
    }

    public final Integer L(Integer pickedKm) {
        if (pickedKm == null || pickedKm.intValue() == 0) {
            return pickedKm;
        }
        int iH = H();
        if (pickedKm.intValue() < iH) {
            return null;
        }
        int I = I();
        if (pickedKm.intValue() == iH && iH * 1000 == I) {
            return null;
        }
        return pickedKm;
    }

    public final void M() {
        BaseViewModelExtKt.b(this, false, false, null, null, new ReadyVM$queryPreRunCheckIn$1(this, null), 13, null);
    }

    public final void N(@NotNull String schoolCode) {
        Intrinsics.checkNotNullParameter(schoolCode, "schoolCode");
        BaseViewModelExtKt.b(this, true, false, null, null, new ReadyVM$querySchoolFences$1(this, schoolCode, null), 14, null);
    }

    public final void O() {
        SchoolRule schoolDemandRule;
        Integer value = this.selectedTargetKm.getValue();
        SunshineRunDetail value2 = this.sunshineRunDetail.getValue();
        long singleMinDistance = (value2 == null || (schoolDemandRule = value2.getSchoolDemandRule()) == null) ? 0L : schoolDemandRule.getSingleMinDistance();
        String strH = ll7.f43096a.h(Long.valueOf(singleMinDistance), false, true);
        if (value == null) {
            this.noGoalSelected.setValue(Boolean.FALSE);
            this.goalValueText.setValue(strH);
            this.showGoalTip.setValue(Boolean.valueOf(singleMinDistance > 0));
            this.goalTipText.setValue(ys8.f(R.string.run_ready_goal_tip, strH));
            return;
        }
        if (value.intValue() == 0) {
            this.noGoalSelected.setValue(Boolean.TRUE);
            this.goalValueText.setValue(ys8.e(R.string.run_ready_no_goal));
            this.showGoalTip.setValue(Boolean.FALSE);
            this.goalTipText.setValue("");
            return;
        }
        this.noGoalSelected.setValue(Boolean.FALSE);
        this.goalValueText.setValue(value.toString());
        this.showGoalTip.setValue(Boolean.TRUE);
        this.goalTipText.setValue(ys8.f(R.string.run_ready_goal_tip, value.toString()));
    }

    public final void P() {
        final List<GeoFenceDetail> value = this.geoFenceListData.getValue();
        List<GeoFenceDetail> list = value;
        if (list == null || list.isEmpty()) {
            this.myUsableFence.setValue(null);
            return;
        }
        HCJAddressInfo hCJAddressInfoO = r90.o();
        Map<String, GeoFenceDetail> mapA = hCJAddressInfoO != null ? ye3.f46013a.a(new HCJLatLng(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng()), value) : null;
        if (mapA == null || mapA.isEmpty()) {
            o((GeoFenceDetail) CollectionsKt.firstOrNull(value));
        } else {
            BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.run.page.activities_run.ReadyVM$resolveUsableFence$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @NotNull
                public final Boolean invoke(@NotNull ResultException resultException) {
                    Intrinsics.checkNotNullParameter(resultException, o.f);
                    this.this$0.o((GeoFenceDetail) CollectionsKt.firstOrNull(value));
                    return Boolean.FALSE;
                }
            }, null, new ReadyVM$resolveUsableFence$2(mapA, this, value, null), 9, null);
        }
    }

    public final void Q() {
        String runPlanCode;
        String strK;
        Integer numL;
        RunPlanBean value = this.currentRunPlan.getValue();
        if (value == null || (runPlanCode = value.getRunPlanCode()) == null || (strK = MoreDistanceDialog.INSTANCE.k(runPlanCode)) == null) {
            return;
        }
        MutableLiveData<Integer> mutableLiveData = this.selectedTargetKm;
        if (Intrinsics.areEqual(strK, "0")) {
            numL = 0;
        } else if (Intrinsics.areEqual(strK, MoreDistanceDialog.VALUE_MIN)) {
            numL = null;
        } else {
            Integer intOrNull = StringsKt.toIntOrNull(strK);
            if (intOrNull == null) {
                return;
            } else {
                numL = L(Integer.valueOf(intOrNull.intValue()));
            }
        }
        mutableLiveData.setValue(numL);
        O();
    }

    public final void R(@NotNull String content) {
        Intrinsics.checkNotNullParameter(content, "content");
        BaseViewModelExtKt.b(this, false, false, null, null, new ReadyVM$sendDanmu$1(content, null), 13, null);
    }

    public final void T(@NotNull GeoFenceDetail fence) {
        Intrinsics.checkNotNullParameter(fence, GeoFence.BUNDLE_KEY_FENCE);
        GeoFenceDetail value = this.myUsableFence.getValue();
        if (Intrinsics.areEqual(value != null ? value.getFenceCode() : null, fence.getFenceCode())) {
            return;
        }
        o(fence);
    }

    public final void m(@Nullable Integer pickedKm) {
        this.selectedTargetKm.setValue(L(pickedKm));
        O();
    }

    public final void n(@NotNull SunshineRunDetail detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.sunshineRunDetail.setValue(detail);
        MoreDistanceDialog.Companion bVar = MoreDistanceDialog.INSTANCE;
        RunPlanBean value = this.currentRunPlan.getValue();
        bVar.j(value != null ? value.getRunPlanCode() : null);
        this.selectedTargetKm.setValue(null);
        O();
        Q();
        BaseViewModelExtKt.b(this, false, false, null, null, new ReadyVM$applyPreloadedDetail$1(this, null), 15, null);
    }

    public final void o(GeoFenceDetail fence) {
        this.myUsableFence.setValue(fence);
        if (this.centerPointLiveData.getValue() != null) {
            return;
        }
        if (fence != null) {
            this.centerPointLiveData.setValue(new HCJLatLng(fence.getLat(), fence.getLng()));
            return;
        }
        HCJAddressInfo hCJAddressInfoO = r90.o();
        if (hCJAddressInfoO != null) {
            this.centerPointLiveData.setValue(new HCJLatLng(hCJAddressInfoO.getLat(), hCJAddressInfoO.getLng()));
        }
    }

    @NotNull
    public final MutableLiveData<HCJLatLng> p() {
        return this.centerPointLiveData;
    }

    @NotNull
    public final MutableLiveData<RunPlanBean> q() {
        return this.currentRunPlan;
    }

    @NotNull
    public final MutableLiveData<List<DanmuBean>> r() {
        return this.danmuList;
    }

    @NotNull
    public final MutableLiveData<List<GeoFenceDetail>> s() {
        return this.geoFenceListData;
    }

    @NotNull
    public final MutableLiveData<String> t() {
        return this.goalTipText;
    }

    @NotNull
    public final MutableLiveData<String> u() {
        return this.goalValueText;
    }

    @NotNull
    public final MutableLiveData<GeoFenceDetail> v() {
        return this.myUsableFence;
    }

    @NotNull
    public final MutableLiveData<NearRunStd> w() {
        return this.nearRunStd;
    }

    @NotNull
    public final MutableLiveData<Boolean> x() {
        return this.noGoalSelected;
    }

    @NotNull
    public final MutableLiveData<String> y() {
        return this.runningCountText;
    }

    @NotNull
    public final MutableLiveData<Integer> z() {
        return this.selectedTargetKm;
    }
}
