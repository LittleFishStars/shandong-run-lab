package com.huachenjie.run.page.geofence;

import androidx.camera.video.AudioStats;
import androidx.p002lifecycle.MediatorLiveData;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.bean.BaseListData;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.ClockMode;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.GeoFenceListV2Adapter;
import com.huachenjie.run.bean.VideoInfoData;
import com.zj.adlib.aw8;
import com.zj.adlib.n76;
import com.zj.adlib.r90;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u000fR.\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010 \"\u0004\b\n\u0010!¨\u0006%"}, d2 = {"Lcom/huachenjie/run/page/geofence/GeoFenceActivityVM;", "Lcom/huachenjie/common/base/data_binding/BaseVM;", "", "j", "Lcom/zj/adlib/aw8;", "a", "Lcom/zj/adlib/aw8;", "sunshineModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/bean/GeoFenceDetail;", "i", "Landroidx/lifecycle/MutableLiveData;", "mGeoFenceDetail", "Landroidx/lifecycle/MediatorLiveData;", "", "Landroidx/lifecycle/MediatorLiveData;", "contains", "Lcom/huachenjie/common/bean/ClockMode;", "b", "clockMode", "Lcom/huachenjie/run/adapter/GeoFenceListV2Adapter;", "adapter", "", "c", "distanceStr", "Lcom/huachenjie/common/bean/BindingTitleBean;", "d", "titleBean", "", "Lcom/huachenjie/run/bean/VideoInfoData;", "k", y6b.g, "()Landroidx/lifecycle/MutableLiveData;", "(Landroidx/lifecycle/MutableLiveData;)V", "videoListLiveD", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
public class GeoFenceActivityVM extends BaseVM {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public aw8 sunshineModel = new aw8();

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MutableLiveData<GeoFenceDetail> mGeoFenceDetail = new MutableLiveData<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<Boolean> contains = new MediatorLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<ClockMode> clockMode = new MediatorLiveData<>();

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MutableLiveData<GeoFenceListV2Adapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<String> distanceStr = new MediatorLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @JvmField
    @NotNull
    public MediatorLiveData<BindingTitleBean> titleBean = new MediatorLiveData<>();

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    @NotNull
    public MutableLiveData<List<VideoInfoData>> videoListLiveD = new MutableLiveData<>();

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35869a;

        public a(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35869a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35869a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35869a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0014J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¨\u0006\f"}, d2 = {"com/huachenjie/run/page/geofence/GeoFenceActivityVM$b", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/BaseListData;", "Lcom/huachenjie/run/bean/VideoInfoData;", "data", "", "onCCSuccess", "", "code", "", "message", "onFailed", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends BizSubscriber<BaseListData<VideoInfoData>> {
        public b() {
            super(true);
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            GeoFenceActivityVM.this.h().setValue(new ArrayList());
        }

        public void onCCSuccess(@Nullable BaseListData<VideoInfoData> data) {
            if (data != null) {
                MutableLiveData<List<VideoInfoData>> mutableLiveDataH = GeoFenceActivityVM.this.h();
                List<VideoInfoData> arrayList = data.list;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                mutableLiveDataH.setValue(arrayList);
            }
        }
    }

    public GeoFenceActivityVM() {
        this.clockMode.setValue(null);
        this.clockMode.addSource(this.mGeoFenceDetail, new a(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceActivityVM.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GeoFenceDetail geoFenceDetail) {
                Intrinsics.checkNotNullParameter(geoFenceDetail, "data");
                GeoFenceActivityVM.this.clockMode.setValue(ClockMode.id2Object(geoFenceDetail.getClockMode()));
            }
        }));
        this.contains.addSource(this.mGeoFenceDetail, new a(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.geofence.GeoFenceActivityVM.2
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
                GeoFenceActivityVM.this.contains.setValue(Boolean.valueOf(zContainsLocation));
                if (zContainsLocation) {
                    GeoFenceActivityVM.this.distanceStr.setValue("你在此区域");
                    return;
                }
                if (geoFenceDetail.getDistance() == 0) {
                    GeoFenceActivityVM.this.distanceStr.setValue("");
                    return;
                }
                GeoFenceActivityVM.this.distanceStr.setValue(BigDecimal.valueOf(geoFenceDetail.getDistance()).divide(BigDecimal.valueOf(1000L), 2, 4).toString() + ys8.e(R.string.kilometer));
            }
        }));
    }

    @NotNull
    public final MutableLiveData<List<VideoInfoData>> h() {
        return this.videoListLiveD;
    }

    public final void i(@NotNull MutableLiveData<List<VideoInfoData>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.videoListLiveD = mutableLiveData;
    }

    public final void j() {
        aw8 aw8Var = this.sunshineModel;
        n76.e(this, aw8Var != null ? aw8Var.f() : null).p5(new b());
    }
}
