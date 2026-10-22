package com.huachenjie.run.page.geofence;

import androidx.camera.video.AudioStats;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.blankj.utilcode.util.CollectionUtils;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.ClockMode;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.NewOpenTimesBean;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GeoFenceListV2Adapter;
import com.ipd.dsp.internal.i.q;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ai9;
import com.zj.adlib.aw8;
import com.zj.adlib.n76;
import com.zj.adlib.r90;
import com.zj.adlib.ys8;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0007\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u001e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0012R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010\u0012R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0012R.\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\r\u0010%\"\u0004\b&\u0010'¨\u0006+"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceV2VM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", t.d, "", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "geoFenceDetailList", "k", "Lcom/zj/adlib/aw8;", "a", "Lcom/zj/adlib/aw8;", "sunshineModel", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "mGeoFenceDetail", "Landroidx/lifecycle/MediatorLiveData;", "", "Landroidx/lifecycle/MediatorLiveData;", "j", "()Landroidx/lifecycle/MediatorLiveData;", "n", "(Landroidx/lifecycle/MediatorLiveData;)V", "mGeoFenceOpenTimes", "", "b", "contains", "Lcom/huachenjie/common/bean/ClockMode;", "c", "clockMode", "Lcom/huachenjie/run/adapter/GeoFenceListV2Adapter;", "adapter", "d", "distanceStr", "Lcom/huachenjie/common/bean/BindingTitleBean;", "e", "titleBean", "()Landroidx/lifecycle/MutableLiveData;", "m", "(Landroidx/lifecycle/MutableLiveData;)V", "mFenceListData", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGeoFenceV2VM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GeoFenceV2VM.kt\ncom/huachenjie/run/page/geofence/GeoFenceV2VM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,142:1\n1045#2:143\n*S KotlinDebug\n*F\n+ 1 GeoFenceV2VM.kt\ncom/huachenjie/run/page/geofence/GeoFenceV2VM\n*L\n131#1:143\n*E\n"})
public final class GeoFenceV2VM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public aw8 sunshineModel = new aw8();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MutableLiveData<GeoFenceDetail> mGeoFenceDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public MediatorLiveData<String> mGeoFenceOpenTimes = new MediatorLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<Boolean> contains = new MediatorLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<ClockMode> clockMode = new MediatorLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MutableLiveData<GeoFenceListV2Adapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<String> distanceStr = new MediatorLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<BindingTitleBean> titleBean = new MediatorLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<List<GeoFenceDetail>> mFenceListData = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n+ 2 GeoFenceV2VM.kt\ncom/huachenjie/run/page/geofence/GeoFenceV2VM\n*L\n1#1,328:1\n131#2:329\n*E\n"})
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return ComparisonsKt.compareValues(Long.valueOf(((GeoFenceDetail) t).getDistance()), Long.valueOf(((GeoFenceDetail) t2).getDistance()));
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014¨\u0006\u0007"}, d2 = {"com/huachenjie/run/page/geofence/GeoFenceV2VM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "data", "", "onCCSuccess", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<List<? extends GeoFenceDetail>> {
        public b() {
            super(true);
        }

        public void onCCSuccess(@Nullable List<? extends GeoFenceDetail> data) {
            GeoFenceV2VM.this.k(data);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35883a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35883a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35883a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35883a.invoke(obj);
        }
    }

    public GeoFenceV2VM() {
        this.clockMode.setValue(null);
        this.clockMode.addSource(this.mGeoFenceDetail, new c(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceV2VM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GeoFenceDetail geoFenceDetail) {
                Intrinsics.checkNotNullParameter(geoFenceDetail, "data");
                GeoFenceV2VM.this.clockMode.setValue(ClockMode.id2Object(geoFenceDetail.getClockMode()));
            }
        }));
        this.contains.addSource(this.mGeoFenceDetail, new c(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceV2VM.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GeoFenceDetail geoFenceDetail) {
                Intrinsics.checkNotNullParameter(geoFenceDetail, "data");
                HCJMapUtils hCJMapUtilsCreateMapUtils = HCJMapEntry.getInstance().createMapUtils();
                boolean zContainsLocation = false;
                if (r90.o() != null) {
                    if (!(r90.o().getLat() == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                        zContainsLocation = hCJMapUtilsCreateMapUtils.containsLocation(new HCJLatLng(r90.o().getLat(), r90.o().getLng()), geoFenceDetail.getFenceList(), false);
                    }
                }
                GeoFenceV2VM.this.contains.setValue(Boolean.valueOf(zContainsLocation));
                if (zContainsLocation) {
                    GeoFenceV2VM.this.distanceStr.setValue("你在此区域");
                    return;
                }
                if (geoFenceDetail.getDistance() == 0) {
                    GeoFenceV2VM.this.distanceStr.setValue("");
                    return;
                }
                GeoFenceV2VM.this.distanceStr.setValue(BigDecimal.valueOf(geoFenceDetail.getDistance()).divide(BigDecimal.valueOf(1000L), 2, 4).toString() + ys8.e(R.string.kilometer));
            }
        }));
        this.mGeoFenceOpenTimes.addSource(this.mGeoFenceDetail, new c(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceV2VM.3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(GeoFenceDetail geoFenceDetail) {
                String str;
                ArrayList<NewOpenTimesBean> newOpenTimes = geoFenceDetail.getNewOpenTimes();
                String str2 = "";
                if (newOpenTimes != null && newOpenTimes.size() > 0) {
                    String weekTime = newOpenTimes.get(0).getWeekTime();
                    if (!newOpenTimes.get(0).getOpenTimes().isEmpty()) {
                        weekTime = weekTime + q.a.i + newOpenTimes.get(0).getOpenTimes().get(0);
                    }
                    if (newOpenTimes.get(0).getOpenTimes().size() > 1) {
                        str = weekTime + q.a.i + newOpenTimes.get(0).getOpenTimes().get(1);
                    } else {
                        if (newOpenTimes.size() > 1) {
                            weekTime = weekTime + q.a.i + newOpenTimes.get(1).getWeekTime();
                            if (!newOpenTimes.get(1).getOpenTimes().isEmpty()) {
                                str = weekTime + q.a.i + newOpenTimes.get(1).getOpenTimes().get(0);
                            }
                        }
                        str2 = weekTime;
                    }
                    str2 = str;
                }
                GeoFenceV2VM.this.j().setValue(str2);
            }
        }));
    }

    @NotNull
    public final MutableLiveData<List<GeoFenceDetail>> i() {
        return this.mFenceListData;
    }

    @NotNull
    public final MediatorLiveData<String> j() {
        return this.mGeoFenceOpenTimes;
    }

    public final void k(List<? extends GeoFenceDetail> geoFenceDetailList) {
        if (r90.o() != null) {
            if (!(r90.o().getLat() == AudioStats.AUDIO_AMPLITUDE_NONE) && geoFenceDetailList != null && (!geoFenceDetailList.isEmpty())) {
                HCJMapUtils hCJMapUtilsCreateMapUtils = HCJMapEntry.getInstance().createMapUtils();
                for (GeoFenceDetail geoFenceDetail : geoFenceDetailList) {
                    geoFenceDetail.setDistance((long) hCJMapUtilsCreateMapUtils.calculateLineDistance(new HCJLatLng(r90.o().getLat(), r90.o().getLng()), new HCJLatLng(geoFenceDetail.getLat(), geoFenceDetail.getLng())));
                }
                geoFenceDetailList = CollectionsKt.sortedWith(geoFenceDetailList, new a());
            }
        }
        if (CollectionUtils.t(geoFenceDetailList)) {
            MutableLiveData<GeoFenceDetail> mutableLiveData = this.mGeoFenceDetail;
            Intrinsics.checkNotNull(geoFenceDetailList);
            mutableLiveData.setValue(geoFenceDetailList.get(0));
        }
        this.mFenceListData.setValue((List<GeoFenceDetail>) geoFenceDetailList);
    }

    public final void l() {
        n76.e(this, this.sunshineModel.h(ai9.e().getSchoolCode())).p5(new b());
    }

    public final void m(@NotNull MutableLiveData<List<GeoFenceDetail>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.mFenceListData = mutableLiveData;
    }

    public final void n(@NotNull MediatorLiveData<String> mediatorLiveData) {
        Intrinsics.checkNotNullParameter(mediatorLiveData, "<set-?>");
        this.mGeoFenceOpenTimes = mediatorLiveData;
    }
}
