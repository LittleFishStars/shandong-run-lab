package com.huachenjie.run.page.run_index;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjq.permissions.Permission;
import com.huachenjie.base.util.CustomerServiceUtil;
import com.huachenjie.common.base.SideTextInterface;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.SchoolRule;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.bean.StudentDoneRule;
import com.huachenjie.common.bean.SunshineRunDetail;
import com.huachenjie.common.constants.Environment;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.permission.RequiredSettingComponent;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.RunPlanBean;
import com.huachenjie.run.databinding.RunActivityIndexBinding;
import com.huachenjie.run.databinding.RunLayoutIndexHeaderBinding;
import com.huachenjie.run.dialog.AlipayBindTipDialog;
import com.huachenjie.run.dialog.FreePunchDialog;
import com.huachenjie.run.dialog.NfcPermissionTipDialog;
import com.huachenjie.run.dialog.RunIndexPickerDialog;
import com.huachenjie.run.page.activities_run.ActivityRunListActivity;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.ai_deduction.AiDeductionDetailActivity;
import com.huachenjie.run.page.outside_attend_deduction.OutsideAttendDeductionDetailActivity;
import com.huachenjie.run.page.rule.RuleV3Activity;
import com.huachenjie.run.page.run_index.RunIndexActivity;
import com.huachenjie.run.page.run_index.adapter.DeductionType;
import com.huachenjie.run.page.run_index.adapter.RunIndexDeductionAdapter;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.run.page.run_reward.RunRewardActivity;
import com.huachenjie.run.page.venue_deduction.VenueDeductionDetailActivity;
import com.huachenjie.run.page.wearable_deduction.WearableDeductionDetailActivity;
import com.huachenjie.run.utils.StartRunUtils;
import com.igexin.push.g.o;
import com.zj.adlib.DeductionTip;
import com.zj.adlib.ai9;
import com.zj.adlib.ew;
import com.zj.adlib.fe9;
import com.zj.adlib.fv5;
import com.zj.adlib.hp4;
import com.zj.adlib.lk0;
import com.zj.adlib.ll7;
import com.zj.adlib.nl8;
import com.zj.adlib.qx6;
import com.zj.adlib.r90;
import com.zj.adlib.su9;
import com.zj.adlib.ud7;
import com.zj.adlib.vo6;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import com.zj.adlib.yy5;
import com.zj.adlib.z62;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(extras = 1, path = RoutePathConstants.Run.j)
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001N\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001EB\u0007¢\u0006\u0004\bj\u0010kJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u001e\u0010\u001f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001cH\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\"\u001a\u00020!H\u0002J*\u0010'\u001a\u00020\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001c2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00050$H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020!H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002J\b\u0010,\u001a\u00020!H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020.H\u0016J\u0014\u00102\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020100H\u0016J\u0012\u00105\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u000103H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0014J\b\u0010:\u001a\u00020\u0005H\u0014J\u0012\u0010=\u001a\u00020\u00052\b\u0010<\u001a\u0004\u0018\u00010;H\u0016J\n\u0010>\u001a\u0004\u0018\u00010;H\u0016J\b\u0010?\u001a\u00020!H\u0016J\n\u0010@\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010A\u001a\u00020.H\u0016J\u000e\u0010B\u001a\u00020\u00052\u0006\u0010(\u001a\u00020!R\u0018\u0010D\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010CR\u0016\u0010G\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010I\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u0016\u0010K\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010FR\u0016\u0010M\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010FR\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010OR\u001b\u0010U\u001a\u00020Q8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010R\u001a\u0004\bS\u0010TR)\u0010Z\u001a\u0010\u0012\f\u0012\n W*\u0004\u0018\u00010\u00000\u00000V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bH\u0010R\u001a\u0004\bX\u0010YR\u001b\u0010_\u001a\u00020[8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010R\u001a\u0004\b]\u0010^R#\u0010d\u001a\n W*\u0004\u0018\u00010`0`8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\ba\u0010R\u001a\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010R\u001a\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/huachenjie/run/page/run_index/RunIndexActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivityIndexBinding;", "Lcom/huachenjie/run/page/run_index/RunIndexVM;", "Lcom/huachenjie/common/base/SideTextInterface;", "", "E0", "M0", "N0", "O0", "L0", "w0", "T0", "J0", "", "Lcom/huachenjie/common/bean/SemesterBean;", "semesterData", "X0", "Lcom/huachenjie/common/bean/SunshineRunDetail;", "detail", "d1", "Y0", "b1", "c1", "Z0", "Lcom/huachenjie/common/bean/SportRecord;", "item", "P0", "", "runRecordCode", "semesterCode", "R0", "Q0", "", "x0", "bottomActionText", "Lkotlin/Function1;", "Lcom/huachenjie/run/bean/RunPlanBean;", "onSelected", "U0", ReadyActivity.t, "W0", "a1", "K0", "I0", "H0", "", "getLayoutResID", "", "", "V", "Landroid/os/Bundle;", "savedInstanceState", "b", "initView", "initData", "W", "onResume", "onDestroy", "Landroid/widget/TextView;", "view", "q", "p", "s", "H", "C", "D0", "Landroid/widget/TextView;", "sideTextView", "a", "Z", "pendingShowSemesterPicker", "c", "hasBootstrappedAfterSemester", y6b.f, "pendingRefreshRunIndex", y6b.g, "pendingRefreshInspiration", "com/huachenjie/run/page/run_index/RunIndexActivity$refreshRunIndexReceiver$1", "Lcom/huachenjie/run/page/run_index/RunIndexActivity$refreshRunIndexReceiver$1;", "refreshRunIndexReceiver", "Lcom/huachenjie/run/utils/StartRunUtils;", "Lkotlin/Lazy;", "C0", "()Lcom/huachenjie/run/utils/StartRunUtils;", "startRunUtils", "Lcom/huachenjie/common/permission/RequiredSettingComponent;", "kotlin.jvm.PlatformType", "B0", "()Lcom/huachenjie/common/permission/RequiredSettingComponent;", "requiredSettingComponent", "Lcom/huachenjie/run/page/run_index/adapter/RunIndexDeductionAdapter;", "d", "y0", "()Lcom/huachenjie/run/page/run_index/adapter/RunIndexDeductionAdapter;", "deductionAdapter", "Lcom/huachenjie/run/databinding/RunLayoutIndexHeaderBinding;", "e", "z0", "()Lcom/huachenjie/run/databinding/RunLayoutIndexHeaderBinding;", "headerBinding", "Lcom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter;", "f", "A0", "()Lcom/huachenjie/run/page/run_index/adapter/RunIndexRecordAdapter;", "recordAdapter", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nRunIndexActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RunIndexActivity.kt\ncom/huachenjie/run/page/run_index/RunIndexActivity\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,620:1\n766#2:621\n857#2,2:622\n350#2,7:624\n1549#2:631\n1620#2,3:632\n350#2,7:635\n1549#2:642\n1620#2,3:643\n*S KotlinDebug\n*F\n+ 1 RunIndexActivity.kt\ncom/huachenjie/run/page/run_index/RunIndexActivity\n*L\n308#1:621\n308#1:622,2\n311#1:624,7\n315#1:631\n315#1:632,3\n450#1:635,7\n455#1:642\n455#1:643,3\n*E\n"})
public final class RunIndexActivity extends BaseMVVMActivity<RunActivityIndexBinding, RunIndexVM> implements SideTextInterface {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean pendingShowSemesterPicker;

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    public boolean hasBootstrappedAfterSemester;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public boolean pendingRefreshRunIndex;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public boolean pendingRefreshInspiration;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    @Nullable
    public TextView sideTextView;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RunIndexActivity$refreshRunIndexReceiver$1 refreshRunIndexReceiver = new BroadcastReceiver() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$refreshRunIndexReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@Nullable Context context, @Nullable Intent intent) {
            this.f35924a.pendingRefreshRunIndex = true;
            boolean z = false;
            if (intent != null && intent.getBooleanExtra(ud7.EXTRA_REFRESH_INSPIRATION, false)) {
                z = true;
            }
            if (z) {
                this.f35924a.pendingRefreshInspiration = true;
            }
        }
    };

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy startRunUtils = LazyKt.lazy(new Function0<StartRunUtils>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$startRunUtils$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final StartRunUtils m682invoke() {
            RunIndexActivity runIndexActivity = this.this$0;
            return new StartRunUtils(runIndexActivity, RunIndexActivity.e0(runIndexActivity));
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy requiredSettingComponent = LazyKt.lazy(new Function0<RequiredSettingComponent<RunIndexActivity>>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$requiredSettingComponent$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RequiredSettingComponent<RunIndexActivity> m681invoke() {
            RequiredSettingComponent<RunIndexActivity> requiredSettingComponent = new RequiredSettingComponent<>(this.this$0);
            this.this$0.getLifecycle().addObserver(requiredSettingComponent);
            return requiredSettingComponent;
        }
    });

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy deductionAdapter = LazyKt.lazy(new Function0<RunIndexDeductionAdapter>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$deductionAdapter$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final RunIndexDeductionAdapter m678invoke() {
            return new RunIndexDeductionAdapter();
        }
    });

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final Lazy headerBinding = LazyKt.lazy(new RunIndexActivity$headerBinding$2(this));

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final Lazy recordAdapter = LazyKt.lazy(new RunIndexActivity$recordAdapter$2(this));

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/run/page/run_index/RunIndexActivity$a;", "", "Landroid/view/View;", "v", "", "j", "i", y6b.g, "k", y6b.f, "view", "e", "f", "c", "a", "b", "d", "<init>", "(Lcom/huachenjie/run/page/run_index/RunIndexActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunIndexActivity.this.startActivity(new Intent(RunIndexActivity.this, (Class<?>) ActivityRunListActivity.class));
        }

        public final void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AlipayBindTipDialog.Companion aVar = AlipayBindTipDialog.INSTANCE;
            FragmentManager supportFragmentManager = RunIndexActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            aVar.a(supportFragmentManager);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            RunIndexActivity.V0(RunIndexActivity.this, null, null, 3, null);
        }

        public final void d(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            CustomerServiceUtil.f32958a.g(RunIndexActivity.this);
        }

        public final void e(@NotNull View view) {
            Integer value;
            Intrinsics.checkNotNullParameter(view, "view");
            Integer value2 = RunIndexActivity.e0(RunIndexActivity.this).l0().getValue();
            if ((value2 != null && value2.intValue() == 1) || ((value = RunIndexActivity.e0(RunIndexActivity.this).l0().getValue()) != null && value.intValue() == 3)) {
                fv5.b("您的信誉过低，无法使用免卡球");
                return;
            }
            FreePunchDialog.Companion aVar = FreePunchDialog.INSTANCE;
            FragmentManager supportFragmentManager = RunIndexActivity.this.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            Integer value3 = RunIndexActivity.e0(RunIndexActivity.this).G().getValue();
            if (value3 == null) {
                value3 = 0;
            }
            aVar.b(supportFragmentManager, value3.intValue());
        }

        public final void f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (!Intrinsics.areEqual(RunIndexActivity.e0(RunIndexActivity.this).e0().getValue(), Boolean.TRUE)) {
                ARouter.getInstance().build(zj7.a.HOME).withString(yj7.a.HOME_TAB_NAME, fe9.b.FLASH_COINS).navigation();
                return;
            }
            su9.v(view.getContext(), Environment.c + "/#/medal");
        }

        public final void g(@Nullable View v) {
            SemesterBean value;
            String semesterCode;
            SunshineRunDetail value2 = RunIndexActivity.e0(RunIndexActivity.this).i0().getValue();
            if (value2 == null || (value = RunIndexActivity.e0(RunIndexActivity.this).W().getValue()) == null || (semesterCode = value.getSemesterCode()) == null) {
                return;
            }
            StudentDoneRule studentDoneRuleInfo = value2.getStudentDoneRuleInfo();
            Integer num = studentDoneRuleInfo != null ? studentDoneRuleInfo.awardDistance : null;
            int iIntValue = num == null ? 0 : num.intValue();
            StudentDoneRule studentDoneRuleInfo2 = value2.getStudentDoneRuleInfo();
            Integer num2 = studentDoneRuleInfo2 != null ? studentDoneRuleInfo2.awardTimes : null;
            int iIntValue2 = num2 == null ? 0 : num2.intValue();
            String strF = ll7.f43096a.f(Integer.valueOf(iIntValue), false, false, 1);
            RunRewardActivity.Companion aVar = RunRewardActivity.INSTANCE;
            RunIndexActivity runIndexActivity = RunIndexActivity.this;
            Intrinsics.checkNotNull(strF);
            String strValueOf = String.valueOf(iIntValue2);
            RunPlanBean value3 = RunIndexActivity.e0(RunIndexActivity.this).D().getValue();
            aVar.a(runIndexActivity, strF, strValueOf, semesterCode, value3 != null ? value3.getRunPlanCode() : null);
        }

        public final void h(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ARouter.getInstance().build(RoutePathConstants.Run.c).navigation();
        }

        public final void i(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            if (RunIndexActivity.this.I0()) {
                SunshineRunDetail value = RunIndexActivity.e0(RunIndexActivity.this).i0().getValue();
                SchoolRule schoolDemandRule = value != null ? value.getSchoolDemandRule() : null;
                if (schoolDemandRule == null) {
                    return;
                }
                ARouter.getInstance().build(RoutePathConstants.Run.m).withParcelable(RuleV3Activity.x, schoolDemandRule).navigation();
            }
        }

        public final void j(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            RunIndexActivity.this.D0(false);
        }

        public final void k(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            ARouter.getInstance().build(RoutePathConstants.Run.q).withString("title", "手机设置").withString("url", Environment.b + v.getContext().getString(R.string.run_phone_setting_url)).navigation();
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35922a;

        public b(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35922a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35922a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35922a.invoke(obj);
        }
    }

    public static final void F0(RunIndexActivity runIndexActivity, View view) {
        Intrinsics.checkNotNullParameter(runIndexActivity, "this$0");
        List<SemesterBean> value = runIndexActivity.getMViewModel().X().getValue();
        List<SemesterBean> list = value;
        if (!(list == null || list.isEmpty())) {
            runIndexActivity.X0(value);
        } else {
            runIndexActivity.pendingShowSemesterPicker = true;
            runIndexActivity.getMViewModel().w0();
        }
    }

    public static final void G0(RunIndexActivity runIndexActivity, View view) {
        Intrinsics.checkNotNullParameter(runIndexActivity, "this$0");
        runIndexActivity.finish();
    }

    public static /* synthetic */ void S0(RunIndexActivity runIndexActivity, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        runIndexActivity.R0(str, str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void V0(RunIndexActivity runIndexActivity, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            function1 = new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$showChoosePlan$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((RunPlanBean) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull RunPlanBean runPlanBean) {
                    Intrinsics.checkNotNullParameter(runPlanBean, o.f);
                }
            };
        }
        runIndexActivity.U0(str, function1);
    }

    public static final /* synthetic */ RunIndexVM e0(RunIndexActivity runIndexActivity) {
        return runIndexActivity.getMViewModel();
    }

    public final RunIndexRecordAdapter A0() {
        return (RunIndexRecordAdapter) this.recordAdapter.getValue();
    }

    public final RequiredSettingComponent<RunIndexActivity> B0() {
        return (RequiredSettingComponent) this.requiredSettingComponent.getValue();
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    public int C() {
        return zn1.a(com.huachenjie.common.R.color.color_8997A4);
    }

    public final StartRunUtils C0() {
        return (StartRunUtils) this.startRunUtils.getValue();
    }

    public final void D0(boolean useCreditSword) {
        if (I0() && H0()) {
            if (x0()) {
                W0(useCreditSword);
            } else {
                a1(useCreditSword);
            }
        }
    }

    public final void E0() {
        MutableLiveData<BindingTitleBean> mutableLiveDataJ0 = getMViewModel().j0();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        Integer value = getMViewModel().e().b().getValue();
        Intrinsics.checkNotNull(value);
        bindingTitleBean.setStatusBarHeight(value.intValue());
        int i = R.color.color_191F20;
        bindingTitleBean.setTitleTextColor(zn1.a(i));
        bindingTitleBean.setBackground(-5903366);
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(Integer.valueOf(zn1.a(i)));
        bindingTitleBean.setShowRightIcon(true);
        bindingTitleBean.setRightIconResId(R.mipmap.run_ic_sun_run_home_filter);
        bindingTitleBean.setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.dm7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunIndexActivity.F0(this.f41228a, view);
            }
        });
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.em7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunIndexActivity.G0(this.f41470a, view);
            }
        });
        mutableLiveDataJ0.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.base.SideTextInterface
    @Nullable
    public String H() {
        return null;
    }

    public final boolean H0() {
        if (!vo6.a(this)) {
            B0().d(1);
            return false;
        }
        if (vo6.c(this, Permission.POST_NOTIFICATIONS)) {
            return true;
        }
        B0().d(2);
        return false;
    }

    public final boolean I0() {
        RunPlanBean value = getMViewModel().D().getValue();
        if (value != null && value.getPlanStatus() != 1) {
            fv5.a(R.string.run_out_of_semester_prompt);
            return false;
        }
        if (value == null) {
            SunshineRunDetail value2 = getMViewModel().i0().getValue();
            if ((value2 != null ? value2.getSchoolDemandRule() : null) == null || !value2.isValidStatus()) {
                fv5.a(R.string.run_out_of_semester_prompt);
                return false;
            }
        }
        return true;
    }

    public final void J0() {
        AdPlatformSwitch adPlatformSwitchE = r90.e("rslb");
        boolean z = false;
        if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
            z = true;
        }
        if (z) {
            ew.f().g(hp4.e, this, getLifecycle(), getMBinding().f35472a, null);
        }
    }

    public final boolean K0() {
        RunPlanBean value = getMViewModel().D().getValue();
        return (value != null ? value.getTouchCheckType() : 0) != 0;
    }

    public final void L0() {
        getMViewModel().D().observe(this, new b(new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$observeCurrentRunPlan$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunPlanBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RunPlanBean runPlanBean) {
                if (RunIndexActivity.e0(this.this$0).W().getValue() == null) {
                    return;
                }
                if (this.this$0.pendingRefreshRunIndex) {
                    this.this$0.pendingRefreshRunIndex = false;
                }
                this.this$0.T0();
                if (this.this$0.pendingRefreshInspiration) {
                    this.this$0.pendingRefreshInspiration = false;
                    RunIndexActivity.e0(this.this$0).z0();
                }
            }
        }));
    }

    public final void M0() {
        getMViewModel().i0().observe(this, new b(new Function1<SunshineRunDetail, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$observeDetailData$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SunshineRunDetail) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SunshineRunDetail sunshineRunDetail) {
                this.this$0.d1(sunshineRunDetail);
            }
        }));
    }

    public final void N0() {
        getMViewModel().W().observe(this, new b(new Function1<SemesterBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$observeSemesterChange$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemesterBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(SemesterBean semesterBean) {
                if (semesterBean == null) {
                    return;
                }
                MutableLiveData<BindingTitleBean> mutableLiveDataJ0 = RunIndexActivity.e0(this.this$0).j0();
                BindingTitleBean value = RunIndexActivity.e0(this.this$0).j0().getValue();
                if (value != null) {
                    value.setTitleName(semesterBean.getName());
                } else {
                    value = null;
                }
                mutableLiveDataJ0.setValue(value);
                RunIndexActivity.e0(this.this$0).v0();
                this.this$0.w0();
            }
        }));
    }

    public final void O0() {
        getMViewModel().X().observe(this, new b(new Function1<List<? extends SemesterBean>, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$observeSemesterListChange$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<SemesterBean>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(List<SemesterBean> list) {
                if (this.this$0.pendingShowSemesterPicker) {
                    List<SemesterBean> list2 = list;
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    this.this$0.pendingShowSemesterPicker = false;
                    RunIndexActivity runIndexActivity = this.this$0;
                    Intrinsics.checkNotNullExpressionValue(list, GoodsSpecificationPreviewActivity.z);
                    runIndexActivity.X0(list);
                }
            }
        }));
    }

    public final void P0(SportRecord item) {
        if (!item.getVision()) {
            S0(this, item.getRunRecordCode(), null, 2, null);
        } else {
            if (item.getSunRunRecordStatus() != 3) {
                return;
            }
            if (item.getArchiveState() == 1) {
                fv5.b(getString(R.string.appeal_failed_by_score_archiving));
            } else {
                Q0(item.getRunRecordCode());
            }
        }
    }

    public final void Q0(String runRecordCode) {
        Postcard postcardWithString = ARouter.getInstance().build(RoutePathConstants.Run.h).withString("runRecordCode", runRecordCode);
        SemesterBean value = getMViewModel().W().getValue();
        postcardWithString.withString("semesterCode", value != null ? value.getSemesterCode() : null).navigation();
    }

    public final void R0(String runRecordCode, String semesterCode) {
        String semesterCode2;
        Postcard postcardWithString = ARouter.getInstance().build(RoutePathConstants.Run.b).withString("runRecordCode", runRecordCode);
        SemesterBean value = getMViewModel().W().getValue();
        if (value != null && (semesterCode2 = value.getSemesterCode()) != null) {
            semesterCode = semesterCode2;
        } else if (semesterCode == null) {
            semesterCode = "";
        }
        postcardWithString.withString("semesterCode", semesterCode).navigation();
    }

    public final void T0() {
        if (getMViewModel().W().getValue() == null) {
            return;
        }
        RunIndexVM.u0(getMViewModel(), 1, false, null, 6, null);
        getMViewModel().y0();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00b5  */
    public final void U0(String bottomActionText, final Function1<? super RunPlanBean, Unit> onSelected) {
        boolean z;
        final List<RunPlanBean> value = getMViewModel().T().getValue();
        if (value == null || value.isEmpty()) {
            return;
        }
        RunPlanBean value2 = getMViewModel().D().getValue();
        final String runPlanCode = value2 != null ? value2.getRunPlanCode() : null;
        Iterator<RunPlanBean> it = value.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getRunPlanCode(), runPlanCode)) {
                break;
            } else {
                i++;
            }
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        String strI = ai9.i();
        RunIndexPickerDialog.Companion companion = RunIndexPickerDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        List<RunPlanBean> list = value;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((RunPlanBean) it2.next()).getRunPlanName());
        }
        boolean zN0 = getMViewModel().n0();
        if (getMViewModel().n0()) {
            if (strI == null || strI.length() == 0) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        companion.c(supportFragmentManager, "选择跑步计划", arrayList, iCoerceAtLeast, zN0, z, bottomActionText, new Function2<Integer, Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$showChoosePlan$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, boolean z2) {
                RunPlanBean runPlanBean = (RunPlanBean) CollectionsKt.getOrNull(value, i2);
                if (runPlanBean == null) {
                    return;
                }
                if (RunIndexActivity.e0(this).n0()) {
                    ai9.x(z2 ? runPlanBean.getRunPlanCode() : "");
                }
                if (!TextUtils.equals(runPlanBean.getRunPlanCode(), runPlanCode)) {
                    RunIndexActivity.e0(this).D().setValue(runPlanBean);
                }
                onSelected.invoke(runPlanBean);
            }
        });
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        M0();
        N0();
        O0();
        L0();
    }

    public final void W0(final boolean useCreditSword) {
        U0("开始跑步", new Function1<RunPlanBean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$showChoosePlanBeforeRun$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunPlanBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull RunPlanBean runPlanBean) {
                Intrinsics.checkNotNullParameter(runPlanBean, o.f);
                this.this$0.a1(useCreditSword);
            }
        });
    }

    public final void X0(List<SemesterBean> semesterData) {
        final ArrayList arrayList = new ArrayList();
        Iterator<T> it = semesterData.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((SemesterBean) next).getStatus() != 0) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        SemesterBean value = getMViewModel().W().getValue();
        String semesterCode = value != null ? value.getSemesterCode() : null;
        Iterator it2 = arrayList.iterator();
        int i = 0;
        while (true) {
            if (!it2.hasNext()) {
                i = -1;
                break;
            } else if (Intrinsics.areEqual(((SemesterBean) it2.next()).getSemesterCode(), semesterCode)) {
                break;
            } else {
                i++;
            }
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(i, 0);
        RunIndexPickerDialog.Companion companion = RunIndexPickerDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            arrayList2.add(((SemesterBean) it3.next()).getName());
        }
        companion.c(supportFragmentManager, "选择学期", arrayList2, iCoerceAtLeast, true, ai9.d() != null, (64 & 64) != 0 ? null : null, new Function2<Integer, Boolean, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$showChooseSemester$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Boolean) obj2).booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2, boolean z) {
                SemesterBean semesterBean = (SemesterBean) CollectionsKt.getOrNull(arrayList, i2);
                if (semesterBean == null) {
                    return;
                }
                ai9.r(z ? semesterBean : null);
                RunIndexActivity.e0(this).W().setValue(semesterBean);
            }
        });
    }

    public final void Y0() {
        String runPlanCode;
        SunshineRunDetail value = getMViewModel().i0().getValue();
        if (value == null || (runPlanCode = value.getRunPlanCode()) == null) {
            return;
        }
        AiDeductionDetailActivity.Companion aVar = AiDeductionDetailActivity.INSTANCE;
        String strC = z62.f46193a.c(Long.valueOf(value.getDeductionDistance()), 2);
        String strValueOf = String.valueOf(value.getDeductionTimes());
        String aiMoringTimes = value.getAiMoringTimes();
        if (aiMoringTimes == null) {
            aiMoringTimes = "";
        }
        aVar.startActivity(this, strC, strValueOf, aiMoringTimes, runPlanCode);
    }

    public final void Z0() {
        SemesterBean value;
        String semesterCode;
        String runPlanCode;
        SunshineRunDetail value2 = getMViewModel().i0().getValue();
        if (value2 == null || (value = getMViewModel().W().getValue()) == null || (semesterCode = value.getSemesterCode()) == null || (runPlanCode = value2.getRunPlanCode()) == null) {
            return;
        }
        OutsideAttendDeductionDetailActivity.INSTANCE.startActivity(this, z62.f46193a.c(Long.valueOf(value2.getOutsideAttendDeductionDistance()), 2), String.valueOf(value2.getOutsideAttendDeductionTimes()), semesterCode, runPlanCode);
    }

    public final void a1(final boolean useCreditSword) {
        if (Intrinsics.areEqual(getMViewModel().Y().getValue(), Boolean.TRUE)) {
            AlipayBindTipDialog.Companion aVar = AlipayBindTipDialog.INSTANCE;
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
            aVar.a(supportFragmentManager);
            return;
        }
        if (!K0() || !yy5.a(this)) {
            getMViewModel().t0(1, true, new Function1<SunshineRunDetail, Unit>() { // from class: com.huachenjie.run.page.run_index.RunIndexActivity$startRun$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SunshineRunDetail) obj);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                public final void invoke(@NotNull SunshineRunDetail sunshineRunDetail) {
                    Intrinsics.checkNotNullParameter(sunshineRunDetail, "detail");
                    ReadyActivity.a aVar2 = ReadyActivity.f12370a;
                    RunIndexActivity runIndexActivity = this.this$0;
                    aVar2.a(runIndexActivity, useCreditSword, RunIndexActivity.e0(runIndexActivity).D().getValue(), sunshineRunDetail);
                }
            });
        } else {
            if (getSupportFragmentManager().findFragmentByTag(Reflection.getOrCreateKotlinClass(NfcPermissionTipDialog.class).getSimpleName()) != null) {
                return;
            }
            NfcPermissionTipDialog.Companion aVar2 = NfcPermissionTipDialog.INSTANCE;
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "supportFragmentManager");
            aVar2.a(supportFragmentManager2);
        }
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void b(@Nullable Bundle savedInstanceState) {
        qx6.d(this, savedInstanceState);
    }

    public final void b1() {
        String runPlanCode;
        SunshineRunDetail value = getMViewModel().i0().getValue();
        if (value == null || (runPlanCode = value.getRunPlanCode()) == null) {
            return;
        }
        VenueDeductionDetailActivity.INSTANCE.startActivity(this, z62.f46193a.c(Long.valueOf(value.getStadiumDeductionDistance()), 2), String.valueOf(value.getStadiumDeductionTimes()), runPlanCode);
    }

    public final void c1() {
        SunshineRunDetail value = getMViewModel().i0().getValue();
        String runPlanCode = value != null ? value.getRunPlanCode() : null;
        if (runPlanCode == null) {
            return;
        }
        WearableDeductionDetailActivity.INSTANCE.startActivity(this, runPlanCode);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void d1(SunshineRunDetail detail) {
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        if (detail != null && detail.showAiDeductionTip()) {
            DeductionType deductionType = DeductionType.AI;
            String aiDeductionInfo = detail.getAiDeductionInfo();
            if (aiDeductionInfo == null) {
                aiDeductionInfo = "";
            }
            listCreateListBuilder.add(new DeductionTip(deductionType, aiDeductionInfo));
        }
        if (detail != null && detail.showStadiumDeductionTip()) {
            DeductionType deductionType2 = DeductionType.VENUE;
            String stadiumDeductionInfo = detail.getStadiumDeductionInfo();
            if (stadiumDeductionInfo == null) {
                stadiumDeductionInfo = "";
            }
            listCreateListBuilder.add(new DeductionTip(deductionType2, stadiumDeductionInfo));
        }
        if (detail != null && detail.showWearableDeductionTip()) {
            DeductionType deductionType3 = DeductionType.WEARABLE;
            String wearableDeductionInfo = detail.getWearableDeductionInfo();
            if (wearableDeductionInfo == null) {
                wearableDeductionInfo = "";
            }
            listCreateListBuilder.add(new DeductionTip(deductionType3, wearableDeductionInfo));
        }
        if (detail != null && detail.showOutsideAttendDeductionTip()) {
            DeductionType deductionType4 = DeductionType.OUTSIDE_ATTEND;
            String outsideAttendDeductionInfo = detail.getOutsideAttendDeductionInfo();
            listCreateListBuilder.add(new DeductionTip(deductionType4, outsideAttendDeductionInfo != null ? outsideAttendDeductionInfo : ""));
        }
        List listBuild = CollectionsKt.build(listCreateListBuilder);
        y0().setList(listBuild);
        RecyclerView recyclerView = z0().f12062a;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "headerBinding.rvDeduction");
        recyclerView.setVisibility(listBuild.isEmpty() ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.horizontalBias = listBuild.size() == 1 ? 0.5f : 0.0f;
        recyclerView.setLayoutParams(layoutParams2);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_index;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        C0();
        getMViewModel().U().setValue(A0());
        getMViewModel().w0();
        J0();
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        E0();
        B0();
        ud7.a(this, this.refreshRunIndexReceiver);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        ud7.i(this, this.refreshRunIndexReceiver);
        nl8.e(this).r();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        getMViewModel().x0();
        if (getMViewModel().W().getValue() == null) {
            return;
        }
        if (!getMViewModel().getHasLoadPlanList()) {
            getMViewModel().v0();
            return;
        }
        if (this.pendingRefreshRunIndex) {
            this.pendingRefreshRunIndex = false;
            T0();
        }
        if (this.pendingRefreshInspiration) {
            this.pendingRefreshInspiration = false;
            getMViewModel().z0();
        }
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

    public final void w0() {
        if (this.hasBootstrappedAfterSemester) {
            return;
        }
        this.hasBootstrappedAfterSemester = true;
        C0().O(1);
        getMViewModel().r0();
        getMViewModel().z0();
        getMViewModel().C();
    }

    public final boolean x0() {
        List<RunPlanBean> value = getMViewModel().T().getValue();
        int size = value != null ? value.size() : 0;
        if (getMViewModel().n0()) {
            if (size <= 1) {
                return false;
            }
            String strI = ai9.i();
            if (!(strI == null || strI.length() == 0)) {
                return false;
            }
        } else if (size <= 1) {
            return false;
        }
        return true;
    }

    public final RunIndexDeductionAdapter y0() {
        return (RunIndexDeductionAdapter) this.deductionAdapter.getValue();
    }

    public final RunLayoutIndexHeaderBinding z0() {
        return (RunLayoutIndexHeaderBinding) this.headerBinding.getValue();
    }
}
