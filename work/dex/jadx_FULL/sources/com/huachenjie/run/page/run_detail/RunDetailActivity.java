package com.huachenjie.run.page.run_detail;

import android.content.Intent;
import android.graphics.Outline;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.p002lifecycle.Observer;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.triver.basic.api.RequestPermission;
import com.amap.api.maps.AMap;
import com.amap.api.maps.UiSettings;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.huachenjie.base.dialog.inspiration.InspirationDialog;
import com.huachenjie.common.base.SideTextInterface;
import com.huachenjie.common.bean.PaceInfo;
import com.huachenjie.common.bean.RunRecordStatusLog;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.DialogUtil;
import com.huachenjie.common.widget.KilometerPaceView;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunDetailEntity;
import com.huachenjie.run.bean.RunDetailFaceCheckInfoBean;
import com.huachenjie.run.bean.RunDetailFaceClockBean;
import com.huachenjie.run.databinding.RunActivityDetailBinding;
import com.huachenjie.run.databinding.RunLayoutRunRecordStatusBinding;
import com.huachenjie.run.dialog.RunValidDialog;
import com.huachenjie.run.page.run_detail.RunDetailActivity;
import com.huachenjie.run.page.run_detail.adapter.RunDetailFaceImgAdapter;
import com.huachenjie.run.page.run_detail.adapter.RunDetailFaceMachineAdapter;
import com.huachenjie.run.page.run_detail.adapter.RunRecordStatusAdapter;
import com.huachenjie.run.page.run_detail.chart.StepLineChartComponent;
import com.huachenjie.run.page.run_detail.route.RunDetailRouteActivity;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.zj.adlib.RunRecordFaceThumb;
import com.zj.adlib.bm7;
import com.zj.adlib.ft1;
import com.zj.adlib.fv5;
import com.zj.adlib.jj8;
import com.zj.adlib.lk0;
import com.zj.adlib.y6b;
import com.zj.adlib.ys8;
import com.zj.adlib.zn1;
import huachenjie.sdk.map.adapter.map.HCJMap;
import huachenjie.sdk.map.adapter.map.HCJMapFragment;
import huachenjie.sdk.map.adapter.map.callback.CaocaoOnMapLoadedListener;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.util.ArrayList;
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
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.b)
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 [2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0002[CB\u0007¢\u0006\u0004\b~\u0010\u007fJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0002J \u0010\"\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001aH\u0002J\u0018\u0010%\u001a\u00020\u00062\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001aH\u0002J \u0010*\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u001aH\u0002J\b\u0010,\u001a\u00020+H\u0002J0\u00104\u001a\u00020\u00062\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020\t2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u0002002\u0006\u00103\u001a\u00020\tH\u0002J\u0010\u00105\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u00106\u001a\u00020\u0006H\u0002J\u0016\u00109\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000607H\u0002J\u0016\u0010:\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000607H\u0002J\b\u0010;\u001a\u00020\u0006H\u0002J\b\u0010<\u001a\u00020\u0006H\u0002J\b\u0010=\u001a\u00020\tH\u0016J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020?0>H\u0016J\u0012\u0010C\u001a\u00020\u00062\b\u0010B\u001a\u0004\u0018\u00010AH\u0016J\b\u0010D\u001a\u00020\u0006H\u0016J\b\u0010E\u001a\u00020\u0006H\u0016J\b\u0010F\u001a\u00020\u0006H\u0016J\"\u0010K\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\t2\u0006\u0010H\u001a\u00020\t2\b\u0010J\u001a\u0004\u0018\u00010IH\u0014J\b\u0010L\u001a\u00020\u0006H\u0014J\u0012\u0010O\u001a\u00020\u00062\b\u0010N\u001a\u0004\u0018\u00010MH\u0016J\n\u0010P\u001a\u0004\u0018\u00010MH\u0016J\b\u0010Q\u001a\u00020&H\u0016J\b\u0010R\u001a\u000200H\u0016J\b\u0010S\u001a\u00020\tH\u0016R\u001d\u0010W\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010T\u001a\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010]\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010a\u001a\u00020&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b^\u0010T\u001a\u0004\b_\u0010`R\u001b\u0010\u0011\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010T\u001a\u0004\bc\u0010dR#\u0010j\u001a\n f*\u0004\u0018\u00010e0e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bg\u0010T\u001a\u0004\bh\u0010iR\u001b\u0010o\u001a\u00020k8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bl\u0010T\u001a\u0004\bm\u0010nR\u0018\u0010r\u001a\u0004\u0018\u00010p8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010qR\u001c\u0010u\u001a\b\u0012\u0004\u0012\u00020s0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010tR\u0016\u0010v\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010\\R\u0018\u0010x\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010wR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010yR\u0018\u0010{\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010zR\u0016\u0010}\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010\\¨\u0006\u0080\u0001"}, d2 = {"Lcom/huachenjie/run/page/run_detail/RunDetailActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityDetailBinding;", "Lcom/huachenjie/run/page/run_detail/RunDetailVM;", "Lhuachenjie/sdk/map/adapter/map/callback/CaocaoOnMapLoadedListener;", "Lcom/huachenjie/common/base/SideTextInterface;", "", "P0", "Y0", "", "scrollY", "b1", "Lcom/huachenjie/run/bean/RunDetailEntity;", "runDetailEntity", "V0", "y0", "w0", "inspirationValue", "A0", "runDetail", "Q0", "Lcom/zj/adlib/bm7;", "overlay", "c1", "detail", "S0", "", "Lcom/zj/adlib/lm7;", "u0", "W0", "", SchoolActivitySuccessActivity.x, "Lcom/huachenjie/common/bean/PaceInfo;", "paceInfoList", "R0", "", "stepList", "U0", "", "showRunFace", "Lcom/huachenjie/run/bean/RunDetailFaceCheckInfoBean;", "faceCheckInfoList", "M0", "", "t0", "Landroid/text/SpannableStringBuilder;", "builder", "paragraphStart", "", "paragraph", "target", "highlightColor", "L0", "N0", "B0", "Lkotlin/Function0;", "onReady", "C0", "J0", "X0", "v0", "getLayoutResID", "", "", "V", "Landroid/os/Bundle;", "savedInstanceState", "b", "W", "initView", "onMapLoaded", RequestPermission.REQUEST_CODE, "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "onDestroy", "Landroid/widget/TextView;", "view", "q", "p", "s", "H", "C", "Lkotlin/Lazy;", "H0", "()Ljava/lang/String;", "runRecordCode", "t", "Ljava/lang/String;", "semesterCode", "a", "Z", RunDetailActivity.z, "c", "I0", "()Z", RunDetailActivity.A, "d", "E0", "()I", "Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "kotlin.jvm.PlatformType", "e", "F0", "()Lhuachenjie/sdk/map/adapter/map/HCJMapFragment;", "mMapFragment", "Lcom/huachenjie/run/page/run_detail/chart/StepLineChartComponent;", "f", "G0", "()Lcom/huachenjie/run/page/run_detail/chart/StepLineChartComponent;", "mStepChartComponent", "Lcom/huachenjie/run/page/run_detail/adapter/RunRecordStatusAdapter;", "Lcom/huachenjie/run/page/run_detail/adapter/RunRecordStatusAdapter;", "statusLogAdapter", "Lcom/huachenjie/common/bean/RunRecordStatusLog;", "Ljava/util/List;", "statusLogRecords", "statusLogExpanded", "Lcom/zj/adlib/bm7;", "routeOverlay", "Lcom/huachenjie/run/bean/RunDetailEntity;", "Landroid/widget/TextView;", "sideTextView", y6b.f, "titleBarWhite", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunDetailActivity.kt\ncom/huachenjie/run/page/run_detail/RunDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,574:1\n1#2:575\n1855#3,2:576\n1864#3,3:578\n1855#3,2:581\n*S KotlinDebug\n*F\n+ 1 RunDetailActivity.kt\ncom/huachenjie/run/page/run_detail/RunDetailActivity\n*L\n302#1:576,2\n325#1:578,3\n345#1:581,2\n*E\n"})
public final class RunDetailActivity extends BaseMVVMActivity<RunActivityDetailBinding, RunDetailVM> implements CaocaoOnMapLoadedListener, SideTextInterface {

    @NotNull
    public static final String A = "showExceedDialog";

    @NotNull
    public static final String B = "inspirationValue";
    public static final int K = 2001;

    @NotNull
    public static final String x = "runRecordCode";

    @NotNull
    public static final String y = "semesterCode";

    @NotNull
    public static final String z = "showSucceedDialog";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RunDetailEntity runDetail;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public RunRecordStatusAdapter statusLogAdapter;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public bm7 routeOverlay;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean showSucceedDialog;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean statusLogExpanded;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean titleBarWhite;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public TextView sideTextView;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    @Nullable
    public String semesterCode;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy runRecordCode = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$runRecordCode$2
        {
            super(0);
        }

        @Nullable
        public final String invoke() {
            return this.this$0.getIntent().getStringExtra("runRecordCode");
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy showExceedDialog = LazyKt.lazy(new Function0<Boolean>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$showExceedDialog$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m677invoke() {
            return Boolean.valueOf(this.this$0.getIntent().getBooleanExtra(RunDetailActivity.A, false));
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy inspirationValue = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$inspirationValue$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m673invoke() {
            return Integer.valueOf(this.this$0.getIntent().getIntExtra("inspirationValue", 0));
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy mMapFragment = LazyKt.lazy(new Function0<HCJMapFragment>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$mMapFragment$2
        {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final HCJMapFragment m674invoke() {
            Fragment fragmentCreateMapFragment = HCJMapEntry.getInstance().createMapFragment();
            RunDetailActivity runDetailActivity = this.this$0;
            fragmentCreateMapFragment.addOnMapLoadedListener(runDetailActivity);
            fragmentCreateMapFragment.setMyLocationEnable(Boolean.FALSE);
            runDetailActivity.getSupportFragmentManager().beginTransaction().replace(R.id.fl_map_container, fragmentCreateMapFragment).commit();
            return fragmentCreateMapFragment;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy mStepChartComponent = LazyKt.lazy(new Function0<StepLineChartComponent>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$mStepChartComponent$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StepLineChartComponent m675invoke() {
            StepLineChartComponent stepLineChartComponent = new StepLineChartComponent(this.this$0.getMBinding().f11453a.getRoot());
            this.this$0.getLifecycle().addObserver(stepLineChartComponent);
            return stepLineChartComponent;
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<? extends RunRecordStatusLog> statusLogRecords = CollectionsKt.emptyList();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/page/run_detail/RunDetailActivity$a;", "", "Landroid/view/View;", "view", "", "back", "c", "a", "b", "d", "e", "<init>", "(Lcom/huachenjie/run/page/run_detail/RunDetailActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunDetailEntity runDetailEntity = RunDetailActivity.this.runDetail;
            boolean z = false;
            if (runDetailEntity != null && runDetailEntity.getArchiveState() == 1) {
                z = true;
            }
            if (z) {
                fv5.b(RunDetailActivity.this.getString(R.string.appeal_failed_by_score_archiving));
            } else {
                ARouter.getInstance().build(RoutePathConstants.Run.h).withString("runRecordCode", RunDetailActivity.this.H0()).withString("semesterCode", RunDetailActivity.this.semesterCode).navigation(RunDetailActivity.this, 2001);
            }
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunDetailEntity runDetailEntity = RunDetailActivity.this.runDetail;
            if (runDetailEntity == null) {
                return;
            }
            RunDetailRouteActivity.INSTANCE.a(RunDetailActivity.this, runDetailEntity);
        }

        public final void back(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunDetailActivity.this.finish();
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunDetailActivity.this.B0();
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunDetailActivity.m0(RunDetailActivity.this).q();
        }

        public final void e(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            ft1.g(RunDetailActivity.this).X(RunDetailActivity.this.getString(R.string.run_face_check_rule_title)).Q(RunDetailActivity.this.t0()).F("").N(RunDetailActivity.this.getString(R.string.run_ready_scene_tip_know)).T(false).Y();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class c implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35911a;

        public c(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35911a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35911a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35911a.invoke(obj);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/huachenjie/run/page/run_detail/RunDetailActivity$d", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), jj8.a(10.0f));
        }
    }

    public static final void D0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$onReady");
        function0.invoke();
    }

    public static final void K0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$onReady");
        function0.invoke();
    }

    public static final void O0(RunDetailFaceMachineAdapter runDetailFaceMachineAdapter, RunDetailActivity runDetailActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(runDetailFaceMachineAdapter, "$adapter");
        Intrinsics.checkNotNullParameter(runDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() != R.id.tv_warn_reason) {
            return;
        }
        RunDetailFaceClockBean item = runDetailFaceMachineAdapter.getItem(i);
        if (item.isWarn()) {
            ft1.B(runDetailActivity, "异常原因", item.getWarnMsg(), ys8.e(R.string.i_know));
        }
    }

    public static final void T0(RunDetailActivity runDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(runDetailActivity, "this$0");
        runDetailActivity.statusLogExpanded = !runDetailActivity.statusLogExpanded;
        runDetailActivity.W0();
    }

    public static final void Z0(RunDetailActivity runDetailActivity, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(runDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(nestedScrollView, "<anonymous parameter 0>");
        runDetailActivity.b1(i2);
    }

    public static final void a1(RunDetailActivity runDetailActivity, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Intrinsics.checkNotNullParameter(runDetailActivity, "this$0");
        runDetailActivity.b1(runDetailActivity.getMBinding().f11445a.getScrollY());
    }

    public static final /* synthetic */ RunDetailVM m0(RunDetailActivity runDetailActivity) {
        return runDetailActivity.getMViewModel();
    }

    public static final void x0() {
    }

    public static final void z0(RunDetailActivity runDetailActivity) {
        Intrinsics.checkNotNullParameter(runDetailActivity, "this$0");
        runDetailActivity.B0();
    }

    public final void A0(int inspirationValue) {
        if (inspirationValue == 0) {
            return;
        }
        InspirationDialog.INSTANCE.a("完成单次自由跑任务", inspirationValue).show(getSupportFragmentManager(), InspirationDialog.class.getSimpleName());
    }

    public final void B0() {
        if (isFinishing() || isDestroyed() || F0().getMap() == null) {
            return;
        }
        getMLoadingDialog().show();
        C0(new Function0<Unit>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$createScreenShot$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m671invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m671invoke() {
                final RunDetailActivity runDetailActivity = this.this$0;
                runDetailActivity.J0(new Function0<Unit>() { // from class: com.huachenjie.run.page.run_detail.RunDetailActivity$createScreenShot$1.1
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m672invoke();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m672invoke() {
                        runDetailActivity.v0();
                    }
                });
            }
        });
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public int C() {
        return zn1.a(com.huachenjie.common.R.color.color_8997A4);
    }

    public final void C0(final Function0<Unit> onReady) {
        if (this.statusLogRecords.size() <= 1 || this.statusLogExpanded) {
            onReady.invoke();
            return;
        }
        this.statusLogExpanded = true;
        W0();
        getMBinding().f11444a.post(new Runnable() { // from class: com.zj.adlib.nl7
            @Override // java.lang.Runnable
            public final void run() {
                RunDetailActivity.D0(onReady);
            }
        });
    }

    public final int E0() {
        return ((Number) this.inspirationValue.getValue()).intValue();
    }

    public final HCJMapFragment F0() {
        return (HCJMapFragment) this.mMapFragment.getValue();
    }

    public final StepLineChartComponent G0() {
        return (StepLineChartComponent) this.mStepChartComponent.getValue();
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @NotNull
    public String H() {
        String strC = ys8.c("%s %s", H0(), "8.7.7");
        Intrinsics.checkNotNullExpressionValue(strC, "format(\"%s %s\", runRecor…dConfig.APP_VERSION_NAME)");
        return strC;
    }

    public final String H0() {
        return (String) this.runRecordCode.getValue();
    }

    public final boolean I0() {
        return ((Boolean) this.showExceedDialog.getValue()).booleanValue();
    }

    public final void J0(final Function0<Unit> onReady) {
        LinearLayout linearLayout = getMBinding().f11457b;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.llListEnd");
        if (linearLayout.getVisibility() != 0) {
            onReady.invoke();
        } else {
            linearLayout.setVisibility(4);
            getMBinding().f11444a.post(new Runnable() { // from class: com.zj.adlib.pl7
                @Override // java.lang.Runnable
                public final void run() {
                    RunDetailActivity.K0(onReady);
                }
            });
        }
    }

    public final void L0(SpannableStringBuilder builder, int paragraphStart, String paragraph, String target, int highlightColor) {
        if (target.length() == 0) {
            return;
        }
        int iIndexOf$default = StringsKt.indexOf$default(paragraph, target, 0, false, 6, (Object) null);
        while (iIndexOf$default >= 0) {
            int i = paragraphStart + iIndexOf$default;
            int length = target.length() + i;
            builder.setSpan(new ForegroundColorSpan(highlightColor), i, length, 33);
            builder.setSpan(new StyleSpan(1), i, length, 33);
            iIndexOf$default = StringsKt.indexOf$default(paragraph, target, iIndexOf$default + target.length(), false, 4, (Object) null);
        }
    }

    public final void M0(boolean showRunFace, List<? extends RunDetailFaceCheckInfoBean> faceCheckInfoList) {
        if (showRunFace) {
            RunDetailFaceImgAdapter runDetailFaceImgAdapter = new RunDetailFaceImgAdapter();
            getMBinding().f11448a.f12128a.setAdapter(runDetailFaceImgAdapter);
            if (faceCheckInfoList != null) {
                for (RunDetailFaceCheckInfoBean runDetailFaceCheckInfoBean : faceCheckInfoList) {
                    runDetailFaceCheckInfoBean.setImgName(getString(R.string.run_detail_face_user_index, Integer.valueOf(runDetailFaceCheckInfoBean.getCheckIndex())));
                }
            }
            runDetailFaceImgAdapter.setList(faceCheckInfoList);
        }
    }

    public final void N0(RunDetailEntity runDetailEntity) {
        if (runDetailEntity.getRunScene() != 30) {
            return;
        }
        final RunDetailFaceMachineAdapter runDetailFaceMachineAdapter = new RunDetailFaceMachineAdapter();
        getMBinding().f11449a.f35688a.setAdapter(runDetailFaceMachineAdapter);
        runDetailFaceMachineAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.zj.adlib.ql7
            @Override // com.chad.library.adapter.base.listener.OnItemChildClickListener
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RunDetailActivity.O0(runDetailFaceMachineAdapter, this, baseQuickAdapter, view, i);
            }
        });
        runDetailFaceMachineAdapter.setList(runDetailEntity.getFaceClockList());
    }

    public final void P0() {
        G0();
        F0();
    }

    public final void Q0(RunDetailEntity runDetail) {
        if (runDetail.getPois() == null) {
            return;
        }
        bm7 bm7Var = new bm7(this, F0().getMap());
        this.routeOverlay = bm7Var;
        bm7Var.v0(runDetail);
        c1(bm7Var);
    }

    public final void R0(long distance, List<? extends PaceInfo> paceInfoList) {
        getMBinding().f11447a.f35680a.removeAllViews();
        if (paceInfoList != null) {
            int i = 0;
            for (Object obj : paceInfoList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PaceInfo paceInfo = (PaceInfo) obj;
                paceInfo.setLessThanKilo(distance - (((long) i) * 1000) < 1000);
                LinearLayout linearLayout = getMBinding().f11447a.f35680a;
                KilometerPaceView kilometerPaceView = new KilometerPaceView(this);
                kilometerPaceView.bindData(paceInfo);
                linearLayout.addView(kilometerPaceView);
                i = i2;
            }
        }
    }

    public final void S0(RunDetailEntity detail) {
        List<RunRecordStatusLog> statusLogRecords = detail.getStatusLogRecords();
        List<RunRecordStatusLog> list = statusLogRecords;
        if (list == null || list.isEmpty()) {
            this.statusLogRecords = CollectionsKt.emptyList();
            this.statusLogAdapter = null;
            return;
        }
        RunLayoutRunRecordStatusBinding runLayoutRunRecordStatusBinding = getMBinding().f11450a;
        Intrinsics.checkNotNullExpressionValue(runLayoutRunRecordStatusBinding, "mBinding.layoutStatusLog");
        Intrinsics.checkNotNullExpressionValue(statusLogRecords, "records");
        this.statusLogRecords = statusLogRecords;
        this.statusLogExpanded = false;
        RunRecordStatusAdapter runRecordStatusAdapter = new RunRecordStatusAdapter(detail.getAppealStatus(), detail.getFaceCheck(), u0(detail));
        this.statusLogAdapter = runRecordStatusAdapter;
        runLayoutRunRecordStatusBinding.f12150a.setAdapter(runRecordStatusAdapter);
        runLayoutRunRecordStatusBinding.f12152a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ml7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunDetailActivity.T0(this.f43329a, view);
            }
        });
        W0();
    }

    public final void U0(List<Float> stepList) {
        G0().q(stepList);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    public final void V0(RunDetailEntity runDetailEntity) {
        if (runDetailEntity == null) {
            return;
        }
        String str = this.semesterCode;
        if (str == null || str.length() == 0) {
            this.semesterCode = runDetailEntity.getSemesterCode();
        }
        this.runDetail = runDetailEntity;
        Q0(runDetailEntity);
        S0(runDetailEntity);
        R0(runDetailEntity.getValidDistance(), runDetailEntity.getPaceInfoList());
        U0(runDetailEntity.getStepList());
        M0(runDetailEntity.isRunFaceFlag(), runDetailEntity.getFaceCheckInfoList());
        N0(runDetailEntity);
        int sportType = runDetailEntity.getSportType();
        if (sportType == 1) {
            w0(runDetailEntity);
            y0(runDetailEntity);
        } else {
            if (sportType != 2) {
                return;
            }
            y0(runDetailEntity);
            w0(runDetailEntity);
            A0(E0());
        }
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().l().observe(this, new c(new RunDetailActivity$initDataObserve$1(this)));
    }

    public final void W0() {
        RunRecordStatusAdapter runRecordStatusAdapter = this.statusLogAdapter;
        if (runRecordStatusAdapter == null) {
            return;
        }
        List<? extends RunRecordStatusLog> listListOf = this.statusLogRecords;
        if (!this.statusLogExpanded) {
            listListOf = CollectionsKt.listOf(CollectionsKt.first(listListOf));
        }
        runRecordStatusAdapter.setList(listListOf);
        RunLayoutRunRecordStatusBinding runLayoutRunRecordStatusBinding = getMBinding().f11450a;
        Intrinsics.checkNotNullExpressionValue(runLayoutRunRecordStatusBinding, "mBinding.layoutStatusLog");
        runLayoutRunRecordStatusBinding.f12149a.setText(this.statusLogExpanded ? "收起" : "查看更多记录");
        runLayoutRunRecordStatusBinding.f35694a.setRotation(this.statusLogExpanded ? 180.0f : 0.0f);
    }

    public final void X0() {
        getMBinding().f11457b.setVisibility(0);
    }

    public final void Y0() {
        d dVar = new d();
        getMBinding().f11443a.setOutlineProvider(dVar);
        getMBinding().f11456b.setOutlineProvider(dVar);
        getMBinding().f11445a.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.zj.adlib.sl7
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                RunDetailActivity.Z0(this.f44714a, nestedScrollView, i, i2, i3, i4);
            }
        });
        getMBinding().f11444a.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.zj.adlib.tl7
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                RunDetailActivity.a1(this.f44948a, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void b(@Nullable Bundle savedInstanceState) {
        super.b(savedInstanceState);
        String stringExtra = getIntent().getStringExtra("semesterCode");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.semesterCode = stringExtra;
        this.showSucceedDialog = getIntent().getBooleanExtra(z, false);
    }

    public final void b1(int scrollY) {
        int top = getMBinding().f11452a.getRoot().getTop();
        if (top <= 0) {
            return;
        }
        boolean z2 = scrollY >= top - getMBinding().b.getBottom();
        if (z2 == this.titleBarWhite) {
            return;
        }
        this.titleBarWhite = z2;
        float fA = z2 ? 0.0f : jj8.a(4.0f);
        getMBinding().f11443a.setElevation(fA);
        getMBinding().f11456b.setElevation(fA);
        FrameLayout frameLayout = getMBinding().b;
        frameLayout.setBackgroundColor(z2 ? -1 : 0);
        frameLayout.setElevation(z2 ? jj8.a(4.0f) : 0.0f);
    }

    public final void c1(bm7 overlay) {
        overlay.M(jj8.a(48.0f), jj8.a(48.0f), jj8.a(120.0f), jj8.a(140.0f));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_detail;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        P0();
        Y0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (-1 == resultCode && requestCode == 2001) {
            getMViewModel().p(H0(), this.semesterCode);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        bm7 bm7Var = this.routeOverlay;
        if (bm7Var != null) {
            bm7Var.h0();
        }
        F0().clear(false);
    }

    public void onMapLoaded() {
        UiSettings uiSettings;
        HCJMap map = F0().getMap();
        Object real = map != null ? map.getReal() : null;
        AMap aMap = real instanceof AMap ? (AMap) real : null;
        if (aMap != null && (uiSettings = aMap.getUiSettings()) != null) {
            uiSettings.setAllGesturesEnabled(false);
        }
        getMViewModel().p(H0(), this.semesterCode);
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @Nullable
    /* JADX INFO: renamed from: p, reason: from getter */
    public TextView getSideTextView() {
        return this.sideTextView;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public void q(@Nullable TextView view) {
        this.sideTextView = view;
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return true;
    }

    public final CharSequence t0() {
        List<RunDetailFaceCheckInfoBean> faceCheckInfoList;
        int color = ContextCompat.getColor(this, R.color.run_color_ff9118);
        RunDetailEntity runDetailEntity = this.runDetail;
        int size = (runDetailEntity == null || (faceCheckInfoList = runDetailEntity.getFaceCheckInfoList()) == null) ? 0 : faceCheckInfoList.size();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.run_face_check_rule_p1));
        spannableStringBuilder.append("\n\n");
        String strValueOf = String.valueOf(size);
        String strValueOf2 = String.valueOf(size);
        String string = getString(R.string.run_face_check_rule_p2, Integer.valueOf(size), Integer.valueOf(size));
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.run_f…, checkTimes, checkTimes)");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) string);
        L0(spannableStringBuilder, length, string, strValueOf, color);
        if (!Intrinsics.areEqual(strValueOf2, strValueOf)) {
            L0(spannableStringBuilder, length, string, strValueOf2, color);
        }
        spannableStringBuilder.append("\n\n");
        spannableStringBuilder.append((CharSequence) getString(R.string.run_face_check_rule_p3_prefix));
        String string2 = getString(R.string.run_face_check_rule_p3_warn);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.run_face_check_rule_p3_warn)");
        int length2 = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) string2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), length2, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), length2, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0060  */
    /* JADX WARN: Code duplicated, block: B:24:0x0064  */
    public final List<RunRecordFaceThumb> u0(RunDetailEntity detail) {
        boolean z2;
        if (!detail.isRunFaceFlag()) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String userFaceImg = detail.getUserFaceImg();
        String string = getString(R.string.run_detail_face_user);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.run_detail_face_user)");
        arrayList.add(new RunRecordFaceThumb(string, userFaceImg));
        List<RunDetailFaceCheckInfoBean> faceCheckInfoList = detail.getFaceCheckInfoList();
        if (faceCheckInfoList != null) {
            for (RunDetailFaceCheckInfoBean runDetailFaceCheckInfoBean : faceCheckInfoList) {
                String runFaceImg = runDetailFaceCheckInfoBean.getRunFaceImg();
                if (runFaceImg != null) {
                    Intrinsics.checkNotNullExpressionValue(runFaceImg, "runFaceImg");
                    if (!runDetailFaceCheckInfoBean.isRunFaceUpload()) {
                        z2 = false;
                    } else if (runFaceImg.length() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        runFaceImg = null;
                    }
                } else {
                    runFaceImg = null;
                }
                String string2 = getString(R.string.run_detail_face_user_index, Integer.valueOf(runDetailFaceCheckInfoBean.getCheckIndex()));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.run_d…r_index, info.checkIndex)");
                arrayList.add(new RunRecordFaceThumb(string2, runFaceImg));
            }
        }
        return arrayList;
    }

    public final void v0() {
        Object real = F0().getMap().getReal();
        Intrinsics.checkNotNull(real, "null cannot be cast to non-null type com.amap.api.maps.AMap");
        ((AMap) real).getMapScreenShot(new RunDetailActivity$captureMapScreenShot$1(this));
    }

    public final void w0(RunDetailEntity runDetailEntity) {
        if (I0()) {
            boolean z2 = runDetailEntity.getDistance() >= 50000;
            boolean z3 = runDetailEntity.getDuration() > 28800;
            if (z2 || z3) {
                String string = getString(runDetailEntity.getDistance() > 50000 ? R.string.run_distance_too_long_prompt : R.string.run_duration_too_long_prompt);
                Intrinsics.checkNotNullExpressionValue(string, "getString(\n            i…t\n            }\n        )");
                DialogUtil.J(this, getString(R.string.run_exceed_max_limit_dialog_title), string, getString(R.string.i_know), true, true, new DialogUtil.SingleClickListener() { // from class: com.zj.adlib.rl7
                    @Override // com.huachenjie.common.util.DialogUtil.SingleClickListener
                    public final void onClicked() {
                        RunDetailActivity.x0();
                    }
                });
            }
        }
    }

    public final void y0(RunDetailEntity runDetailEntity) {
        if (this.showSucceedDialog) {
            this.showSucceedDialog = false;
            if (runDetailEntity.getSportType() != 2) {
                return;
            }
            RunValidDialog runValidDialogNewInstance = RunValidDialog.newInstance(0L, 0L);
            runValidDialogNewInstance.setValidRunListener(new RunValidDialog.ValidRunListener() { // from class: com.zj.adlib.ol7
                @Override // com.huachenjie.run.dialog.RunValidDialog.ValidRunListener
                public final void onShare() {
                    RunDetailActivity.z0(this.f43775a);
                }
            });
            runValidDialogNewInstance.show(getSupportFragmentManager(), RunValidDialog.class.getName());
        }
    }
}
