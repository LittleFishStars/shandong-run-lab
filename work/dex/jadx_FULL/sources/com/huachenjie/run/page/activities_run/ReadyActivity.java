package com.huachenjie.run.page.activities_run;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import com.amap.api.fence.GeoFence;
import com.amap.api.maps.AMap;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.Marker;
import com.gyf.immersionbar.e;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.base.widget.AvatarView;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.DanmuBean;
import com.huachenjie.run.bean.NearRunStd;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.databinding.RunRunActivityReadyBinding;
import com.huachenjie.run.dialog.NfcCheckInTipDialog;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.activities_run.dialog.DanmuDialog;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.huachenjie.run.page.activities_run.dialog.ReadySceneTipDialog;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.run.utils.StartRunUtils;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.bo;
import com.noober.background.view.BLView;
import com.zj.adlib.ai9;
import com.zj.adlib.cr2;
import com.zj.adlib.ew;
import com.zj.adlib.fo6;
import com.zj.adlib.fv5;
import com.zj.adlib.hp4;
import com.zj.adlib.jj8;
import com.zj.adlib.kl7;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;
import com.zj.adlib.p59;
import com.zj.adlib.r90;
import com.zj.adlib.y52;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.HCJMapView;
import huachenjie.sdk.map.adapter.map.adapter.HCJMapAdapter;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.adapter.map.model.CaocaoBitmapDescriptor;
import huachenjie.sdk.map.adapter.map.model.CaocaoBitmapDescriptorFactory;
import huachenjie.sdk.map.adapter.map.model.CaocaoMarker;
import huachenjie.sdk.map.adapter.map.model.CaocaoMarkerOptions;
import huachenjie.sdk.map.amap.AMarker;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 M2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0002rMB\u0007¢\u0006\u0004\bp\u0010qJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J \u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J:\u0010\u001f\u001a4\u0012\u000e\b\u0001\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u0012\u000e\b\u0001\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d\u0018\u0001 \u001e*\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001c0\u001cH\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\u0018\u0010&\u001a\u00020\u00052\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002J\u0018\u0010)\u001a\u00020\u00052\u0006\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\nH\u0002J\u0012\u0010,\u001a\u0004\u0018\u00010+2\u0006\u0010*\u001a\u00020\u000fH\u0002J\b\u0010-\u001a\u00020\u0005H\u0002J\b\u0010.\u001a\u00020\nH\u0016J\u0014\u00100\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001d0/H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\u0012\u00104\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\u000e\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u000209J\b\u0010<\u001a\u00020\u0005H\u0014J\b\u0010=\u001a\u00020\u0005H\u0014J\b\u0010>\u001a\u00020\u0005H\u0014R\u001b\u0010B\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010?\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\u0004\u0018\u00010C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010?\u001a\u0004\bE\u0010FR\u001d\u0010L\u001a\u0004\u0018\u00010H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010?\u001a\u0004\bJ\u0010KR\u0016\u0010O\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010?\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020U8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bV\u0010?\u001a\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010[R\u0018\u0010_\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010^R\u0016\u0010`\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010NR<\u0010g\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d0b0aj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d0b`e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010fR<\u0010h\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d0b0aj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020d0b`e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010fR \u0010j\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010kR\u0016\u0010o\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010n¨\u0006s"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ReadyActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunRunActivityReadyBinding;", "Lcom/huachenjie/run/page/activities_run/ReadyVM;", "Lhuachenjie/sdk/map/adapter/map/callback/CaocaoOnMapLoadedListener;", "", "G0", "P0", "Lcom/huachenjie/run/bean/DanmuBean;", "item", "", "index", "s0", "z0", "N0", "Landroid/view/View;", "mapView", "source", "Landroid/view/MotionEvent;", "event", "x0", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "latLng", "J0", "", "checkedIn", "u0", "t0", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoBitmapDescriptor;", "", "kotlin.jvm.PlatformType", "K0", "w0", "F0", "v0", "", "Lcom/huachenjie/run/bean/NearRunStd$RunUserList;", "users", "y0", RichTextUtils.USER_SCHEME, "seq", bo.g, "view", "Landroid/graphics/Bitmap;", "Q0", "I0", "getLayoutResID", "", "V", "S", "Landroid/os/Bundle;", "savedInstanceState", "b", "W", "initView", "initData", "onMapLoaded", "", "text", "M0", "onResume", "onPause", "onDestroy", "Lkotlin/Lazy;", "E0", "()Z", ReadyActivity.t, "Lcom/huachenjie/run/bean/RunPlanBean;", "c", "A0", "()Lcom/huachenjie/run/bean/RunPlanBean;", ReadyActivity.x, "Lcom/huachenjie/common/bean/SunshineRunDetail;", "d", "D0", "()Lcom/huachenjie/common/bean/SunshineRunDetail;", ReadyActivity.y, "a", "Z", "isGrantedLocationBeforeCreated", "Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialog;", "e", "B0", "()Lcom/huachenjie/run/page/activities_run/dialog/DanmuDialog;", "danmuDialog", "Lcom/huachenjie/run/utils/StartRunUtils;", "f", "C0", "()Lcom/huachenjie/run/utils/StartRunUtils;", "startRunUtils", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "Lhuachenjie/sdk/map/adapter/map/adapter/HCJMapAdapter;", "mMapAdapter", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "mMapFragment", "mapInit", "Ljava/util/ArrayList;", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoMarker;", "Lhuachenjie/sdk/map/amap/AMarker;", "Lcom/amap/api/maps/model/Marker;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "avatarMarkers", "nfcCheckInMarkers", "Lhuachenjie/sdk/map/adapter/map/model/CaocaoBitmapDescriptor;", "nfcMarkerIcon", "Lhuachenjie/sdk/map/lib_base/HCJLatLng;", "pendingCenterLatLng", "K", "I", "avatarDrawSeq", "<init>", "()V", "ClickProxy", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nReadyActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ReadyActivity.kt\ncom/huachenjie/run/page/activities_run/ReadyActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,543:1\n1#2:544\n1855#3,2:545\n766#3:547\n857#3,2:548\n1855#3,2:550\n1855#3,2:552\n1855#3,2:554\n766#3:556\n857#3,2:557\n1855#3,2:559\n*S KotlinDebug\n*F\n+ 1 ReadyActivity.kt\ncom/huachenjie/run/page/activities_run/ReadyActivity\n*L\n284#1:545,2\n340#1:547\n340#1:548,2\n347#1:550,2\n375#1:552,2\n392#1:554,2\n402#1:556\n402#1:557,2\n403#1:559,2\n*E\n"})
public final class ReadyActivity extends BaseMVVMActivity<RunRunActivityReadyBinding, ReadyVM> implements CaocaoOnMapLoadedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f35781a = 18.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final a f12370a = new a(null);
    public static final float b = 36.0f;

    @NotNull
    public static final String t = "useCreditSword";

    @NotNull
    public static final String x = "currentRunPlan";

    @NotNull
    public static final String y = "sunshineRunDetail";

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int avatarDrawSeq;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMapFragment mMapFragment;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJMapAdapter mMapAdapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CaocaoBitmapDescriptor<?, ?> nfcMarkerIcon;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public HCJLatLng pendingCenterLatLng;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean isGrantedLocationBeforeCreated;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean mapInit;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy useCreditSword = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$useCreditSword$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m642invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(ReadyActivity.t, false));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy currentRunPlan = LazyKt.lazy(new Function0<RunPlanBean>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$currentRunPlan$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RunPlanBean m638invoke() {
            return (RunPlanBean) this.this$0.getIntent().getParcelableExtra(ReadyActivity.x);
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy sunshineRunDetail = LazyKt.lazy(new Function0<SunshineRunDetail>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$sunshineRunDetail$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SunshineRunDetail m641invoke() {
            return (SunshineRunDetail) this.this$0.getIntent().getParcelableExtra(ReadyActivity.y);
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy danmuDialog = LazyKt.lazy(new Function0<DanmuDialog>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$danmuDialog$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final DanmuDialog m639invoke() {
            return new DanmuDialog();
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy startRunUtils = LazyKt.lazy(new Function0<StartRunUtils>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$startRunUtils$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StartRunUtils m640invoke() {
            ReadyActivity readyActivity = this.this$0;
            return new StartRunUtils(readyActivity, ReadyActivity.k0(readyActivity));
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ArrayList<CaocaoMarker<AMarker, Marker>> avatarMarkers = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final ArrayList<CaocaoMarker<AMarker, Marker>> nfcCheckInMarkers = new ArrayList<>();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000b"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ReadyActivity$ClickProxy;", "", "Landroid/view/View;", "v", "", "d", "a", "b", "c", "<init>", "(Lcom/huachenjie/run/page/activities_run/ReadyActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class ClickProxy {
        public ClickProxy() {
        }

        public final void a(@Nullable View v) {
            if (Intrinsics.areEqual(ReadyActivity.k0(ReadyActivity.this).F().getValue(), Boolean.TRUE)) {
                return;
            }
            NfcCheckInTipDialog.Companion companion = NfcCheckInTipDialog.INSTANCE;
            FragmentManager supportFragmentManager = ReadyActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            companion.a(supportFragmentManager);
        }

        public final void b(@Nullable View v) {
            MoreDistanceDialog.Companion companion = MoreDistanceDialog.INSTANCE;
            int I = ReadyActivity.k0(ReadyActivity.this).I();
            Integer value = ReadyActivity.k0(ReadyActivity.this).z().getValue();
            RunPlanBean value2 = ReadyActivity.k0(ReadyActivity.this).q().getValue();
            String runPlanCode = value2 != null ? value2.getRunPlanCode() : null;
            final ReadyActivity readyActivity = ReadyActivity.this;
            MoreDistanceDialog moreDistanceDialogG = companion.g(I, value, runPlanCode, new Function1<Integer, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$ClickProxy$clickSelectDistance$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Integer) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@Nullable Integer num) {
                    ReadyActivity.k0(readyActivity).m(num);
                }
            });
            FragmentManager supportFragmentManager = ReadyActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            moreDistanceDialogG.show(supportFragmentManager, MoreDistanceDialog.class.getSimpleName());
        }

        public final void c(@Nullable View v) {
            int iIntValue;
            int i;
            SunshineRunDetail value = ReadyActivity.k0(ReadyActivity.this).C().getValue();
            if (value == null) {
                return;
            }
            Integer value2 = ReadyActivity.k0(ReadyActivity.this).z().getValue();
            if (value2 == null) {
                iIntValue = 0;
                i = 0;
            } else {
                iIntValue = value2.intValue();
                i = 1;
            }
            StartRunUtils startRunUtilsC0 = ReadyActivity.this.C0();
            int iE = (int) kl7.f42851a.e(null, value);
            int i2 = iIntValue * 1000;
            List<GeoFenceDetail> value3 = ReadyActivity.k0(ReadyActivity.this).s().getValue();
            RunPlanBean value4 = ReadyActivity.k0(ReadyActivity.this).q().getValue();
            startRunUtilsC0.l0(1, i, iE, i2, null, value, value3, value4 != null ? value4.getRunPlanCode() : null, ReadyActivity.this.E0());
        }

        public final void d(@Nullable View v) {
            if (ReadyActivity.this.B0().isAdded()) {
                return;
            }
            DanmuDialog danmuDialogB0 = ReadyActivity.this.B0();
            final ReadyActivity readyActivity = ReadyActivity.this;
            danmuDialogB0.setOnSend(new Function1<String, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$ClickProxy$sendDanmu$1
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull String str) {
                    Intrinsics.checkNotNullParameter(str, "text");
                    readyActivity.M0(str);
                }
            });
            ReadyActivity.this.B0().showNow(ReadyActivity.this.getSupportFragmentManager(), "DANMU_DIALOG");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u000f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/huachenjie/run/page/activities_run/ReadyActivity$a;", "", "Landroid/content/Context;", "context", "", ReadyActivity.t, "Lcom/huachenjie/run/bean/RunPlanBean;", ReadyActivity.x, "Lcom/huachenjie/common/bean/SunshineRunDetail;", ReadyActivity.y, "", "a", "", "AVATAR_SIZE_DP", "F", "", "KEY_CURRENT_RUN_PLAN", "Ljava/lang/String;", "KEY_SUNSHINE_RUN_DETAIL", "KEY_USE_CREDIT_SWORD", "MAP_ZOOM", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, boolean useCreditSword, @Nullable RunPlanBean currentRunPlan, @NotNull SunshineRunDetail sunshineRunDetail) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(sunshineRunDetail, ReadyActivity.y);
            Intent intent = new Intent(context, (Class<?>) ReadyActivity.class);
            intent.putExtra(ReadyActivity.t, useCreditSword);
            intent.putExtra(ReadyActivity.x, currentRunPlan);
            intent.putExtra(ReadyActivity.y, sunshineRunDetail);
            context.startActivity(intent);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35783a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35783a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35783a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35783a.invoke(obj);
        }
    }

    public static final void H0(ReadyActivity readyActivity, View view) {
        Intrinsics.checkNotNullParameter(readyActivity, "this$0");
        readyActivity.finish();
    }

    public static final void L0(ReadyActivity readyActivity, float f) {
        Intrinsics.checkNotNullParameter(readyActivity, "this$0");
        HCJMapFragment hCJMapFragment = readyActivity.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.showMyLocationMarker(f);
        }
    }

    public static final boolean O0(ReadyActivity readyActivity, View view, View view2, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(readyActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, "$mapTouchView");
        Intrinsics.checkNotNullExpressionValue(view2, "source");
        Intrinsics.checkNotNullExpressionValue(motionEvent, "event");
        readyActivity.x0(view, view2, motionEvent);
        return true;
    }

    public static final /* synthetic */ ReadyVM k0(ReadyActivity readyActivity) {
        return readyActivity.getMViewModel();
    }

    public static final void q0(AvatarView avatarView, final NearRunStd.RunUserList runUserList, final ReadyActivity readyActivity, final int i, final View view) {
        Intrinsics.checkNotNullParameter(runUserList, "$user");
        Intrinsics.checkNotNullParameter(readyActivity, "this$0");
        try {
            String headImg = runUserList.getHeadImg();
            String str = "";
            if (headImg == null) {
                headImg = "";
            }
            String avatarFrameImgUrl = runUserList.getAvatarFrameImgUrl();
            if (avatarFrameImgUrl != null) {
                str = avatarFrameImgUrl;
            }
            avatarView.loadImageSync(headImg, str);
            readyActivity.runOnUiThread(new Runnable() { // from class: com.zj.adlib.jb7
                @Override // java.lang.Runnable
                public final void run() {
                    ReadyActivity.r0(this.f17353a, i, view, runUserList);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void r0(ReadyActivity readyActivity, int i, View view, NearRunStd.RunUserList runUserList) {
        CaocaoMarker<AMarker, Marker> caocaoMarkerAddMarker;
        HCJMap map;
        CaocaoMarkerOptions caocaoMarkerOptionsCreateMarkerOption;
        CaocaoMarkerOptions caocaoMarkerOptionsPosition;
        CaocaoMarkerOptions caocaoMarkerOptionsIcon;
        CaocaoBitmapDescriptorFactory caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption;
        Intrinsics.checkNotNullParameter(readyActivity, "this$0");
        Intrinsics.checkNotNullParameter(runUserList, "$user");
        if (readyActivity.isFinishing() || readyActivity.isDestroyed() || !readyActivity.mapInit || i != readyActivity.avatarDrawSeq) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, "container");
        Bitmap bitmapQ0 = readyActivity.Q0(view);
        if (bitmapQ0 == null) {
            return;
        }
        HCJMapAdapter hCJMapAdapter = readyActivity.mMapAdapter;
        CaocaoBitmapDescriptor caocaoBitmapDescriptorFromBitmap = (hCJMapAdapter == null || (caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption = hCJMapAdapter.createBitmapDescriptorFactoryOption()) == null) ? null : caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption.fromBitmap(bitmapQ0);
        if (caocaoBitmapDescriptorFromBitmap == null) {
            return;
        }
        HCJMapFragment hCJMapFragment = readyActivity.mMapFragment;
        if (hCJMapFragment == null || (map = hCJMapFragment.getMap()) == null) {
            caocaoMarkerAddMarker = null;
        } else {
            HCJMapAdapter hCJMapAdapter2 = readyActivity.mMapAdapter;
            caocaoMarkerAddMarker = map.addMarker((hCJMapAdapter2 == null || (caocaoMarkerOptionsCreateMarkerOption = hCJMapAdapter2.createMarkerOption()) == null || (caocaoMarkerOptionsPosition = caocaoMarkerOptionsCreateMarkerOption.position(new HCJLatLng(runUserList.getLat(), runUserList.getLng()))) == null || (caocaoMarkerOptionsIcon = caocaoMarkerOptionsPosition.icon(caocaoBitmapDescriptorFromBitmap)) == null) ? null : caocaoMarkerOptionsIcon.anchor(0.5f, 0.5f));
        }
        CaocaoMarker<AMarker, Marker> caocaoMarker = caocaoMarkerAddMarker instanceof CaocaoMarker ? caocaoMarkerAddMarker : null;
        if (caocaoMarker != null && i == readyActivity.avatarDrawSeq) {
            readyActivity.avatarMarkers.add(caocaoMarker);
        } else if (caocaoMarker != null) {
            caocaoMarker.remove();
        }
    }

    public final RunPlanBean A0() {
        return (RunPlanBean) this.currentRunPlan.getValue();
    }

    public final DanmuDialog B0() {
        return (DanmuDialog) this.danmuDialog.getValue();
    }

    public final StartRunUtils C0() {
        return (StartRunUtils) this.startRunUtils.getValue();
    }

    public final SunshineRunDetail D0() {
        return (SunshineRunDetail) this.sunshineRunDetail.getValue();
    }

    public final boolean E0() {
        return ((Boolean) this.useCreditSword.getValue()).booleanValue();
    }

    public final void F0() {
        HCJMapFragment hCJMapFragmentCreateMapFragment;
        HCJMapAdapter hCJMapEntry = HCJMapEntry.getInstance();
        this.mMapAdapter = hCJMapEntry;
        if (hCJMapEntry == null || (hCJMapFragmentCreateMapFragment = hCJMapEntry.createMapFragment()) == null) {
            hCJMapFragmentCreateMapFragment = null;
        } else {
            hCJMapFragmentCreateMapFragment.addOnMapLoadedListener(this);
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_map_container, hCJMapFragmentCreateMapFragment).commit();
            hCJMapFragmentCreateMapFragment.setMyLocationMarkerRes(R.drawable.run_ic_my_location);
            hCJMapFragmentCreateMapFragment.setMyLocationEnable(Boolean.TRUE);
        }
        this.mMapFragment = hCJMapFragmentCreateMapFragment;
    }

    public final void G0() {
        BindingTitleBean backClick = new BindingTitleBean().setTitleName(getString(R.string.run_ready_title)).setBackground(zn1.a(R.color.transparent)).setBackIconResId(R.drawable.ic_back_white).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.lb7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadyActivity.H0(this.f43031a, view);
            }
        });
        Integer value = getMViewModel().e().b().getValue();
        if (value != null) {
            backClick.setStatusBarHeight(value.intValue());
        }
        getMViewModel().D().setValue(backClick);
    }

    public final void I0() {
        AdPlatformSwitch adPlatformSwitchE = r90.e("rslb");
        boolean z = false;
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            z = true;
        }
        if (z) {
            ew.f().g(hp4.f, this, getLifecycle(), getMBinding().f35735a, null);
        }
    }

    public final void J0(HCJLatLng latLng) {
        HCJMapFragment hCJMapFragment;
        if (latLng.lat == AudioStats.AUDIO_AMPLITUDE_NONE) {
            if (latLng.lng == AudioStats.AUDIO_AMPLITUDE_NONE) {
                return;
            }
        }
        this.pendingCenterLatLng = latLng;
        if (!this.mapInit || (hCJMapFragment = this.mMapFragment) == null || hCJMapFragment == null) {
            return;
        }
        hCJMapFragment.animateTo(new HCJLatLng(latLng.lat, latLng.lng), 18.0f);
    }

    public final CaocaoBitmapDescriptor<?, ?> K0() {
        CaocaoBitmapDescriptorFactory caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption;
        CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptorFromView;
        CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptor = this.nfcMarkerIcon;
        if (caocaoBitmapDescriptor != null) {
            return caocaoBitmapDescriptor;
        }
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.run_layout_map_nfc_checkin_marker, (ViewGroup) null, false);
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
        HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
        if (hCJMapAdapter == null || (caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption = hCJMapAdapter.createBitmapDescriptorFactoryOption()) == null || (caocaoBitmapDescriptorFromView = caocaoBitmapDescriptorFactoryCreateBitmapDescriptorFactoryOption.fromView(viewInflate)) == null) {
            return null;
        }
        this.nfcMarkerIcon = caocaoBitmapDescriptorFromView;
        return caocaoBitmapDescriptorFromView;
    }

    public final void M0(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        getMViewModel().R(text);
        s0(new DanmuBean(text, null, true, false, 10, null), 0);
        fv5.b(getString(R.string.run_ready_danmu_send_success));
    }

    public final void N0() {
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        HCJMapView mapView = hCJMapFragment != null ? hCJMapFragment.getMapView() : null;
        final View view = mapView instanceof View ? (View) mapView : null;
        if (view == null) {
            HCJMapFragment hCJMapFragment2 = this.mMapFragment;
            View view2 = hCJMapFragment2 != null ? hCJMapFragment2.getView() : null;
            if (view2 == null) {
                view = getMBinding().b;
                Intrinsics.checkNotNullExpressionValue(view, "mBinding.flMapContainer");
            } else {
                view = view2;
            }
        }
        for (BLView bLView : CollectionsKt.listOf(new BLView[]{getMBinding().f12277b, getMBinding().f12274a})) {
            bLView.setClickable(false);
            bLView.setFocusable(false);
            bLView.setOnTouchListener(new View.OnTouchListener() { // from class: com.zj.adlib.ib7
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view3, MotionEvent motionEvent) {
                    return ReadyActivity.O0(this.f17178a, view, view3, motionEvent);
                }
            });
        }
    }

    public final void P0() {
        BrandPromotionConfigBean brandPromotionConfigBeanC = ai9.c();
        if (brandPromotionConfigBeanC == null || StringsKt.isBlank(brandPromotionConfigBeanC.getBrandName()) || StringsKt.isBlank(brandPromotionConfigBeanC.getBarrageText())) {
            return;
        }
        s0(new DanmuBean(brandPromotionConfigBeanC.getBarrageText(), brandPromotionConfigBeanC.getBrandName(), false, true, 4, null), -1);
    }

    public final Bitmap Q0(View view) {
        if (view.getWidth() <= 0 || view.getHeight() <= 0) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseActivity
    public void S() {
        e.p3(this).G2(com.huachenjie.common.R.color.transparent).T2(false).k3().G1(false).a1();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new ClickProxy())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().w().observe(this, new b(new Function1<NearRunStd, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((NearRunStd) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable NearRunStd nearRunStd) {
                this.this$0.y0(nearRunStd != null ? nearRunStd.getRunUserList() : null);
            }
        }));
        getMViewModel().p().observe(this, new b(new Function1<HCJLatLng, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HCJLatLng) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable HCJLatLng hCJLatLng) {
                if (hCJLatLng != null) {
                    if (hCJLatLng.lat == AudioStats.AUDIO_AMPLITUDE_NONE) {
                        return;
                    }
                    this.this$0.J0(hCJLatLng);
                }
            }
        }));
        getMViewModel().v().observe(this, new b(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$3
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable GeoFenceDetail geoFenceDetail) {
                this.this$0.t0();
            }
        }));
        getMViewModel().B().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$4
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                this.this$0.t0();
            }
        }));
        getMViewModel().F().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$5
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                this.this$0.u0(Intrinsics.areEqual(bool, Boolean.TRUE));
            }
        }));
        getMViewModel().x().observe(this, new b(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$6
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                boolean zAreEqual = Intrinsics.areEqual(bool, Boolean.TRUE);
                ViewGroup.LayoutParams layoutParams = this.this$0.getMBinding().f12267a.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = jj8.a(zAreEqual ? 26.0f : 12.0f);
                marginLayoutParams.bottomMargin = jj8.a(zAreEqual ? 16.0f : 0.0f);
                this.this$0.getMBinding().f12267a.setLayoutParams(marginLayoutParams);
                this.this$0.getMBinding().f12267a.setTextSize(2, zAreEqual ? 36.0f : 80.0f);
            }
        }));
        getMViewModel().r().observe(this, new b(new Function1<List<? extends DanmuBean>, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity$initDataObserve$7
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<DanmuBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable List<DanmuBean> list) {
                if (list != null) {
                    ReadyActivity readyActivity = this.this$0;
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        readyActivity.s0((DanmuBean) it.next(), -1);
                    }
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void b(@Nullable Bundle savedInstanceState) {
        getMViewModel().q().setValue(A0());
        SunshineRunDetail sunshineRunDetailD0 = D0();
        if (sunshineRunDetailD0 != null) {
            getMViewModel().n(sunshineRunDetailD0);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_run_activity_ready;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        SchoolRule schoolDemandRule;
        this.isGrantedLocationBeforeCreated = fo6.f41719a.a(this, "android.permission.ACCESS_FINE_LOCATION");
        getMViewModel().N(ai9.e().getSchoolCode());
        getMViewModel().G();
        ReadySceneTipDialog.Companion companion = ReadySceneTipDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        RunPlanBean runPlanBeanA0 = A0();
        int runScene = runPlanBeanA0 != null ? runPlanBeanA0.getRunScene() : 0;
        ll7 ll7Var = ll7.f43096a;
        SunshineRunDetail sunshineRunDetailD0 = D0();
        String strH = ll7Var.h(Long.valueOf((sunshineRunDetailD0 == null || (schoolDemandRule = sunshineRunDetailD0.getSchoolDemandRule()) == null) ? 0L : schoolDemandRule.getSingleMinDistance()), false, true);
        if (strH == null) {
            strH = "0.0";
        }
        companion.e(supportFragmentManager, runScene, strH);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        C0().g0(new Function1<HCJAddressInfo, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity.initView.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((HCJAddressInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull HCJAddressInfo hCJAddressInfo) {
                Intrinsics.checkNotNullParameter(hCJAddressInfo, o.f);
                if (ReadyActivity.this.isGrantedLocationBeforeCreated) {
                    return;
                }
                ReadyActivity.k0(ReadyActivity.this).J();
            }
        });
        C0().i0(new Function1<GeoFenceDetail, Unit>() { // from class: com.huachenjie.run.page.activities_run.ReadyActivity.initView.2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((GeoFenceDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull GeoFenceDetail geoFenceDetail) {
                Intrinsics.checkNotNullParameter(geoFenceDetail, GeoFence.BUNDLE_KEY_FENCE);
                ReadyActivity.k0(ReadyActivity.this).T(geoFenceDetail);
            }
        });
        G0();
        getMBinding().f12271a.prepare();
        P0();
        F0();
        I0();
        u0(Intrinsics.areEqual(getMViewModel().F().getValue(), Boolean.TRUE));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        this.avatarDrawSeq++;
        v0();
        w0();
        this.nfcMarkerIcon = null;
        getMBinding().f12271a.release();
        super.onDestroy();
    }

    public void onMapLoaded() {
        List<NearRunStd.RunUserList> runUserList;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        if (hCJMapFragment != null) {
            hCJMapFragment.setOnOritationChangeListener(new HCJMapFragment.OrientationChangeListener() { // from class: com.zj.adlib.hb7
                public final void onOrientationChange(float f) {
                    ReadyActivity.L0(this.f42092a, f);
                }
            });
        }
        this.mapInit = true;
        z0();
        N0();
        HCJLatLng value = this.pendingCenterLatLng;
        if (value == null) {
            value = getMViewModel().p().getValue();
        }
        if (value != null) {
            J0(value);
        }
        t0();
        NearRunStd value2 = getMViewModel().w().getValue();
        if (value2 == null || (runUserList = value2.getRunUserList()) == null) {
            return;
        }
        y0(runUserList);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        getMBinding().f12271a.forceSleep();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMBinding().f12271a.forceWake();
        getMViewModel().M();
    }

    public final void p0(final NearRunStd.RunUserList user, final int seq) {
        int iC = cr2.c(this, 36.0f);
        final View viewInflate = getLayoutInflater().inflate(R.layout.run_item_ready_avatar, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(iC, iC));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(iC, 1073741824), View.MeasureSpec.makeMeasureSpec(iC, 1073741824));
        viewInflate.layout(0, 0, iC, iC);
        final AvatarView avatarView = (AvatarView) viewInflate.findViewById(R.id.avatar_view);
        p59.b().submit(new Runnable() { // from class: com.zj.adlib.kb7
            @Override // java.lang.Runnable
            public final void run() {
                ReadyActivity.q0(avatarView, user, this, seq, viewInflate);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    public final void s0(DanmuBean item, int index) {
        String nickName;
        String brandName;
        int iC = cr2.c(this, 12.0f);
        int iC2 = cr2.c(this, 6.0f);
        BrandPromotionConfigBean brandPromotionConfigBeanC = ai9.c();
        String barrageText = brandPromotionConfigBeanC != null ? brandPromotionConfigBeanC.getBarrageText() : null;
        if (barrageText == null) {
            barrageText = "";
        }
        boolean z = item.isBrand() || ((StringsKt.isBlank(barrageText) ^ true) && Intrinsics.areEqual(item.getContent(), barrageText));
        if (z) {
            if (brandPromotionConfigBeanC == null || (brandName = brandPromotionConfigBeanC.getBrandName()) == null) {
                nickName = item.getNickName();
            } else {
                nickName = StringsKt.isBlank(brandName) ^ true ? brandName : null;
                if (nickName == null) {
                    nickName = item.getNickName();
                }
            }
        } else if (item.getSelf()) {
            nickName = getString(R.string.run_ready_danmu_me);
            Intrinsics.checkNotNullExpressionValue(nickName, "getString(R.string.run_ready_danmu_me)");
        } else {
            nickName = item.getNickName();
        }
        int i = z ? RunIndexRecordAdapter.N : -12991242;
        y52 y52Var = new y52();
        y52Var.w(cr2.c(this, 25.0f));
        y52Var.v(1);
        y52Var.y(50);
        y52Var.f20784a = cr2.c(this, 10.0f);
        y52Var.f20789a = nickName + getString(R.string.run_ready_danmu_colon);
        float f = (float) iC;
        y52Var.f45959a = f;
        y52Var.h = i;
        y52Var.f20793b = item.getContent();
        y52Var.b = f;
        y52Var.i = -13877680;
        y52Var.f20787a = ContextCompat.getDrawable(this, R.drawable.run_shape_danmu_bg);
        y52Var.m = iC;
        y52Var.n = iC;
        y52Var.k = iC2;
        y52Var.l = iC2;
        getMBinding().f12271a.add(index, y52Var);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    public final void t0() {
        GeoFenceDetail value;
        List<HCJLatLng> listEmptyList;
        CaocaoBitmapDescriptor<?, ?> caocaoBitmapDescriptorK0;
        CaocaoMarker<AMarker, Marker> caocaoMarkerAddMarker;
        HCJMap map;
        CaocaoMarkerOptions caocaoMarkerOptionsCreateMarkerOption;
        CaocaoMarkerOptions caocaoMarkerOptionsPosition;
        CaocaoMarkerOptions caocaoMarkerOptionsIcon;
        w0();
        if (this.mapInit) {
            HCJMapFragment hCJMapFragment = this.mMapFragment;
            if ((hCJMapFragment != null ? hCJMapFragment.getMap() : null) == null || this.mMapAdapter == null || !Intrinsics.areEqual(getMViewModel().B().getValue(), Boolean.TRUE) || (value = getMViewModel().v().getValue()) == null) {
                return;
            }
            List<HCJLatLng> aliTapPointList = value.getAliTapPointList();
            if (aliTapPointList != null) {
                listEmptyList = new ArrayList();
                for (Object obj : aliTapPointList) {
                    HCJLatLng hCJLatLng = (HCJLatLng) obj;
                    boolean z = false;
                    if (hCJLatLng != null) {
                        if (!(hCJLatLng.lat == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                            z = true;
                        } else if (!(hCJLatLng.lng == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                            z = true;
                        }
                    }
                    if (z) {
                        listEmptyList.add(obj);
                    }
                }
            } else {
                listEmptyList = null;
            }
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (listEmptyList.isEmpty() || (caocaoBitmapDescriptorK0 = K0()) == null) {
                return;
            }
            for (HCJLatLng hCJLatLng2 : listEmptyList) {
                HCJMapFragment hCJMapFragment2 = this.mMapFragment;
                if (hCJMapFragment2 == null || (map = hCJMapFragment2.getMap()) == null) {
                    caocaoMarkerAddMarker = null;
                } else {
                    HCJMapAdapter hCJMapAdapter = this.mMapAdapter;
                    caocaoMarkerAddMarker = map.addMarker((hCJMapAdapter == null || (caocaoMarkerOptionsCreateMarkerOption = hCJMapAdapter.createMarkerOption()) == null || (caocaoMarkerOptionsPosition = caocaoMarkerOptionsCreateMarkerOption.position(new HCJLatLng(hCJLatLng2.lat, hCJLatLng2.lng))) == null || (caocaoMarkerOptionsIcon = caocaoMarkerOptionsPosition.icon(caocaoBitmapDescriptorK0)) == null) ? null : caocaoMarkerOptionsIcon.anchor(0.5f, 1.0f));
                }
                if (!(caocaoMarkerAddMarker instanceof CaocaoMarker)) {
                    caocaoMarkerAddMarker = null;
                }
                if (caocaoMarkerAddMarker != null) {
                    this.nfcCheckInMarkers.add(caocaoMarkerAddMarker);
                }
            }
        }
    }

    public final void u0(boolean checkedIn) {
        getMBinding().f12275b.setCompoundDrawablesWithIntrinsicBounds(0, checkedIn ? R.drawable.run_ic_ready_checkin_done : R.drawable.run_ic_ready_checkin_undo, 0, 0);
        getMBinding().f12275b.setText(checkedIn ? R.string.run_ready_nfc_checked_in : R.string.run_ready_nfc_unchecked);
    }

    public final void v0() {
        Iterator<T> it = this.avatarMarkers.iterator();
        while (it.hasNext()) {
            ((CaocaoMarker) it.next()).remove();
        }
        this.avatarMarkers.clear();
    }

    public final void w0() {
        Iterator<T> it = this.nfcCheckInMarkers.iterator();
        while (it.hasNext()) {
            ((CaocaoMarker) it.next()).remove();
        }
        this.nfcCheckInMarkers.clear();
    }

    public final void x0(View mapView, View source, MotionEvent event) {
        MotionEvent motionEventObtain = MotionEvent.obtain(event);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        source.getLocationOnScreen(iArr);
        mapView.getLocationOnScreen(iArr2);
        motionEventObtain.offsetLocation(iArr[0] - iArr2[0], iArr[1] - iArr2[1]);
        mapView.dispatchTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final void y0(List<? extends NearRunStd.RunUserList> users) {
        if (this.mapInit) {
            HCJMapFragment hCJMapFragment = this.mMapFragment;
            if ((hCJMapFragment != null ? hCJMapFragment.getMap() : null) == null || this.mMapAdapter == null) {
                return;
            }
            int i = this.avatarDrawSeq + 1;
            this.avatarDrawSeq = i;
            v0();
            if (users == null) {
                users = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : users) {
                NearRunStd.RunUserList runUserList = (NearRunStd.RunUserList) obj;
                boolean z = false;
                if (!(runUserList.getLat() == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                    if (!(runUserList.getLng() == AudioStats.AUDIO_AMPLITUDE_NONE)) {
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                p0((NearRunStd.RunUserList) it.next(), i);
            }
        }
    }

    public final void z0() {
        UiSettings uiSettings;
        HCJMap map;
        HCJMapFragment hCJMapFragment = this.mMapFragment;
        Object real = (hCJMapFragment == null || (map = hCJMapFragment.getMap()) == null) ? null : map.getReal();
        AMap aMap = real instanceof AMap ? (AMap) real : null;
        if (aMap == null || (uiSettings = aMap.getUiSettings()) == null) {
            return;
        }
        uiSettings.setAllGesturesEnabled(true);
        uiSettings.setRotateGesturesEnabled(false);
        uiSettings.setTiltGesturesEnabled(false);
    }
}
