package com.huachenjie.run.page.sunshine_run.success;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.SizeUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.ad.interfaces.FDAdListener;
import com.huachenjie.base.dialog.inspiration.InspirationDialog;
import com.huachenjie.base.internal.AdCancelInterface;
import com.huachenjie.common.bean.AdPlatformSwitch;
import com.huachenjie.common.bean.AdPositionSwitch;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.bean.BrandPromotionConfigBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity;
import com.huachenjie.common.util.ActivityLifecycleManager;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.run.R;
import com.huachenjie.run.bean.FinishRunResult;
import com.huachenjie.run.bean.InspirationBean;
import com.huachenjie.run.bean.RunFinishBannerBean;
import com.huachenjie.run.bean.RunFinishBannerData;
import com.huachenjie.run.databinding.RunActivitySunshineRunSuccessBinding;
import com.huachenjie.run.page.activities_run.ReadyActivity;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.huachenjie.run.page.share.SunshineRunShareDialog;
import com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.kuaishou.weapon.p0.bo;
import com.zj.adlib.ai9;
import com.zj.adlib.cm7;
import com.zj.adlib.ew;
import com.zj.adlib.fx7;
import com.zj.adlib.hp4;
import com.zj.adlib.i90;
import com.zj.adlib.jj8;
import com.zj.adlib.kq5;
import com.zj.adlib.lk0;
import com.zj.adlib.nl8;
import com.zj.adlib.r90;
import com.zj.adlib.su9;
import com.zj.adlib.zj7;
import com.zj.adlib.zn1;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 62\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u00026%B\u0007¢\u0006\u0004\b9\u0010:J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0016\u0010\u0018\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u001d\u0010)\u001a\u0004\u0018\u00010$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010-R\u001b\u00101\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u0010-R\u001b\u00104\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u0010-R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMActivity;", "Lcom/huachenjie/run/databinding/RunActivitySunshineRunSuccessBinding;", "Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessVM;", "Lcom/huachenjie/base/internal/AdCancelInterface;", "", "l0", "", "brandName", "", "m0", "initTitleBar", "G0", bo.g, "B0", "n0", "E0", "Lcom/huachenjie/common/bean/AdPlatformSwitch;", "adConfig", "C0", "D0", "", "Lcom/huachenjie/run/bean/RunFinishBannerBean;", GoodsSpecificationPreviewActivity.z, "x0", "F0", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "o0", "", "getLayoutResID", "", "", "V", "initView", "W", "initData", "Lcom/huachenjie/run/bean/FinishRunResult;", "b", "Lkotlin/Lazy;", "v0", "()Lcom/huachenjie/run/bean/FinishRunResult;", SunshineRunSuccessActivity.t, "", "c", "t0", "()J", "activityCode", "d", "w0", SunshineRunSuccessActivity.y, "e", "u0", "durationSecond", "", "a", "Z", "moodQuestionAnimating", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nSunshineRunSuccessActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SunshineRunSuccessActivity.kt\ncom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,354:1\n1#2:355\n1855#3,2:356\n1855#3,2:358\n1855#3,2:360\n1855#3,2:362\n*S KotlinDebug\n*F\n+ 1 SunshineRunSuccessActivity.kt\ncom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity\n*L\n190#1:356,2\n211#1:358,2\n216#1:360,2\n201#1:362,2\n*E\n"})
public final class SunshineRunSuccessActivity extends BaseMVVMActivity<RunActivitySunshineRunSuccessBinding, SunshineRunSuccessVM> implements AdCancelInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f35964a = 220;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final b f12542a = new b(null);
    public static final long d = 280;
    public static final long e = 340;

    @NotNull
    public static final String t = "finishRunResult";

    @NotNull
    public static final String x = "activityCode";

    @NotNull
    public static final String y = "myPace";

    @NotNull
    public static final String z = "duration";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean moodQuestionAnimating;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy finishRunResult = LazyKt.lazy(new Function0<FinishRunResult>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity$finishRunResult$2
        {
            super(0);
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final FinishRunResult m718invoke() {
            return (FinishRunResult) this.this$0.getIntent().getParcelableExtra(SunshineRunSuccessActivity.t);
        }
    });

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy activityCode = LazyKt.lazy(new Function0<Long>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity$activityCode$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m716invoke() {
            return Long.valueOf(this.this$0.getIntent().getLongExtra("activityCode", 0L));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy myPace = LazyKt.lazy(new Function0<Long>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity$myPace$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m719invoke() {
            return Long.valueOf(this.this$0.getIntent().getLongExtra(SunshineRunSuccessActivity.y, 0L));
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy durationSecond = LazyKt.lazy(new Function0<Long>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity$durationSecond$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m717invoke() {
            return Long.valueOf(this.this$0.getIntent().getLongExtra("duration", 0L));
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\n"}, d2 = {"Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity$a;", "", "Landroid/view/View;", "view", "", "b", "c", "a", "<init>", "(Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity;)V", "run_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            SunshineRunSuccessActivity.this.F0();
        }

        public final void b(@NotNull View view) {
            String string;
            Integer intOrNull;
            List<RunFinishBannerBean> list;
            RunFinishBannerBean runFinishBannerBean;
            Intrinsics.checkNotNullParameter(view, "view");
            Object tag = view.getTag();
            if (tag == null || (string = tag.toString()) == null || (intOrNull = StringsKt.toIntOrNull(string)) == null) {
                return;
            }
            int iIntValue = intOrNull.intValue();
            RunFinishBannerData value = SunshineRunSuccessActivity.h0(SunshineRunSuccessActivity.this).k().getValue();
            if (value == null || (list = value.getList()) == null || (runFinishBannerBean = (RunFinishBannerBean) CollectionsKt.getOrNull(list, iIntValue)) == null) {
                return;
            }
            SunshineRunSuccessActivity.this.o0(runFinishBannerBean);
        }

        public final void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (SunshineRunSuccessActivity.this.moodQuestionAnimating || !Intrinsics.areEqual(SunshineRunSuccessActivity.h0(SunshineRunSuccessActivity.this).p().getValue(), Boolean.TRUE)) {
                return;
            }
            SunshineRunSuccessActivity.h0(SunshineRunSuccessActivity.this).B();
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity$b;", "", "", "INTENT_KEY_ACTIVITY_CODE", "Ljava/lang/String;", "INTENT_KEY_DURATION", "INTENT_KEY_FINISH_RUN_RESULT", "INTENT_KEY_MY_PACE", "", "MOOD_FADE_IN", "J", "MOOD_FADE_OUT", "MOOD_SELECT_HOLD", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity$c", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements ViewTreeObserver.OnGlobalLayoutListener {
        public c() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = SunshineRunSuccessActivity.g0(SunshineRunSuccessActivity.this).f35506a.getWidth();
            int height = SunshineRunSuccessActivity.g0(SunshineRunSuccessActivity.this).f35506a.getHeight();
            if (width == 0 || height == 0 || ((double) height) / ((double) width) < 1.0d) {
                return;
            }
            SunshineRunSuccessActivity.g0(SunshineRunSuccessActivity.this).f35506a.setVisibility(8);
            SunshineRunSuccessActivity.g0(SunshineRunSuccessActivity.this).f35506a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/run/page/sunshine_run/success/SunshineRunSuccessActivity$d", "Lcom/huachenjie/ad/interfaces/FDAdListener;", "", "d", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class d extends FDAdListener {
        public d() {
        }

        @Override // com.huachenjie.ad.interfaces.FDAdListener
        public void d() {
            kq5.b(SunshineRunSuccessActivity.this, "BagAdLoadedSuccessful", null);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f35968a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f35968a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f35968a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f35968a.invoke(obj);
        }
    }

    public static final void A0(SunshineRunSuccessActivity sunshineRunSuccessActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(sunshineRunSuccessActivity, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (sunshineRunSuccessActivity.moodQuestionAnimating) {
            return;
        }
        sunshineRunSuccessActivity.getMViewModel().A(i);
        if (sunshineRunSuccessActivity.getMViewModel().x()) {
            return;
        }
        sunshineRunSuccessActivity.p0();
    }

    public static final /* synthetic */ RunActivitySunshineRunSuccessBinding g0(SunshineRunSuccessActivity sunshineRunSuccessActivity) {
        return sunshineRunSuccessActivity.getMBinding();
    }

    public static final /* synthetic */ SunshineRunSuccessVM h0(SunshineRunSuccessActivity sunshineRunSuccessActivity) {
        return sunshineRunSuccessActivity.getMViewModel();
    }

    public static final void q0(final SunshineRunSuccessActivity sunshineRunSuccessActivity, final List list, final float f, final PathInterpolator pathInterpolator) {
        Intrinsics.checkNotNullParameter(sunshineRunSuccessActivity, "this$0");
        Intrinsics.checkNotNullParameter(list, "$targets");
        Intrinsics.checkNotNullParameter(pathInterpolator, "$ease");
        if (sunshineRunSuccessActivity.isFinishing() || sunshineRunSuccessActivity.isDestroyed()) {
            sunshineRunSuccessActivity.moodQuestionAnimating = false;
            return;
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((View) it.next()).animate().alpha(0.0f).translationY(-f).setDuration(280L).setInterpolator(pathInterpolator).withEndAction(new Runnable() { // from class: com.zj.adlib.ow8
                @Override // java.lang.Runnable
                public final void run() {
                    SunshineRunSuccessActivity.r0(intRef, list, sunshineRunSuccessActivity, f, pathInterpolator);
                }
            }).start();
        }
    }

    public static final void r0(Ref.IntRef intRef, final List list, final SunshineRunSuccessActivity sunshineRunSuccessActivity, float f, PathInterpolator pathInterpolator) {
        Intrinsics.checkNotNullParameter(intRef, "$fadedOut");
        Intrinsics.checkNotNullParameter(list, "$targets");
        Intrinsics.checkNotNullParameter(sunshineRunSuccessActivity, "this$0");
        Intrinsics.checkNotNullParameter(pathInterpolator, "$ease");
        int i = intRef.element + 1;
        intRef.element = i;
        if (i < list.size()) {
            return;
        }
        sunshineRunSuccessActivity.getMViewModel().u();
        List<View> list2 = list;
        for (View view : list2) {
            view.setTranslationY(f);
            view.setAlpha(0.0f);
        }
        final Ref.IntRef intRef2 = new Ref.IntRef();
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            ((View) it.next()).animate().alpha(1.0f).translationY(0.0f).setDuration(340L).setInterpolator(pathInterpolator).withEndAction(new Runnable() { // from class: com.zj.adlib.qw8
                @Override // java.lang.Runnable
                public final void run() {
                    SunshineRunSuccessActivity.s0(intRef2, list, sunshineRunSuccessActivity);
                }
            }).start();
        }
    }

    public static final void s0(Ref.IntRef intRef, List list, SunshineRunSuccessActivity sunshineRunSuccessActivity) {
        Intrinsics.checkNotNullParameter(intRef, "$fadedIn");
        Intrinsics.checkNotNullParameter(list, "$targets");
        Intrinsics.checkNotNullParameter(sunshineRunSuccessActivity, "this$0");
        int i = intRef.element + 1;
        intRef.element = i;
        if (i >= list.size()) {
            sunshineRunSuccessActivity.moodQuestionAnimating = false;
        }
    }

    public static final void y0(SunshineRunSuccessActivity sunshineRunSuccessActivity, View view) {
        Intrinsics.checkNotNullParameter(sunshineRunSuccessActivity, "this$0");
        sunshineRunSuccessActivity.F0();
    }

    public static final void z0(SunshineRunSuccessActivity sunshineRunSuccessActivity, View view) {
        Intrinsics.checkNotNullParameter(sunshineRunSuccessActivity, "this$0");
        sunshineRunSuccessActivity.G0();
    }

    public final void B0() {
        AdPositionSwitch adPositionSwitchD = r90.d("rst");
        AdPlatformSwitch adPlatformSwitchE = r90.e("sro");
        if (adPositionSwitchD != null) {
            E0();
        } else {
            if (adPlatformSwitchE != null && adPlatformSwitchE.getOpenFlag()) {
                C0(adPlatformSwitchE);
            }
        }
        AdPlatformSwitch adPlatformSwitchE2 = r90.e("rslb");
        if (adPlatformSwitchE2 != null && adPlatformSwitchE2.getOpenFlag()) {
            D0();
        }
    }

    public final void C0(AdPlatformSwitch adConfig) {
        getMBinding().f35506a.getViewTreeObserver().addOnGlobalLayoutListener(new c());
        int iJ = fx7.j();
        ew.p(this, adConfig, getLifecycle(), getMBinding().f35506a, iJ, (iJ * 9) / 16, null);
    }

    public final void D0() {
        ew.f().g(hp4.b, this, getLifecycle(), getMBinding().b, new d());
    }

    public final void E0() {
        i90.l(this, getLifecycle(), null);
    }

    public final void F0() {
        ActivityLifecycleManager.l().f(ReadyActivity.class);
        ARouter.getInstance().build(RoutePathConstants.Run.j).navigation();
        finish();
    }

    public final void G0() {
        Integer validDistance;
        SunshineRunShareDialog.Companion companion = SunshineRunShareDialog.INSTANCE;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FinishRunResult finishRunResultV0 = v0();
        int iIntValue = (finishRunResultV0 == null || (validDistance = finishRunResultV0.getValidDistance()) == null) ? 0 : validDistance.intValue();
        long jW0 = w0();
        long jU0 = u0();
        String value = getMViewModel().l().getValue();
        if (value == null) {
            value = "";
        }
        companion.a(supportFragmentManager, iIntValue, jW0, jU0, value);
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    @NotNull
    public Map<Integer, Object> V() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(lk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(lk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMActivity
    public void W() {
        getMViewModel().k().observe(this, new e(new Function1<RunFinishBannerData, Unit>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity$initDataObserve$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RunFinishBannerData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RunFinishBannerData runFinishBannerData) {
                if (!runFinishBannerData.getList().isEmpty()) {
                    this.this$0.x0(runFinishBannerData.getList());
                }
            }
        }));
        getMViewModel().q().observe(this, new e(new Function1<Boolean, Unit>() { // from class: com.huachenjie.run.page.sunshine_run.success.SunshineRunSuccessActivity$initDataObserve$2
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ToastUtils.W("闪金币领取成功~", new Object[0]);
                    this.this$0.F0();
                }
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.run_activity_sunshine_run_success;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        super.initData();
        getMViewModel().y();
        try {
            Result.Companion companion = Result.Companion;
            nl8.e(this).q(R.raw.run_achieve_goal);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        FinishRunResult finishRunResultV0 = v0();
        if (finishRunResultV0 != null) {
            getMViewModel().s().setValue(Long.valueOf(w0()));
            getMViewModel().t().setValue(finishRunResultV0);
            getMViewModel().C(finishRunResultV0.getValidDistance());
            getMViewModel().v(finishRunResultV0.getEmaAnswer());
        }
        getMViewModel().w().setValue(Boolean.valueOf(t0() > 0));
        B0();
        n0();
    }

    public final void initTitleBar() {
        MutableLiveData<BindingTitleBean> mutableLiveDataI = getMViewModel().i();
        BindingTitleBean bindingTitleBean = new BindingTitleBean();
        bindingTitleBean.setBackIconResId(R.drawable.ic_back_black);
        bindingTitleBean.setBackTintColor(-16777216);
        bindingTitleBean.setTitleTextColor(zn1.a(R.color.color_191F20));
        Integer value = getMViewModel().e().b().getValue();
        if (value == null) {
            value = 0;
        }
        Intrinsics.checkNotNullExpressionValue(value, "mViewModel.uiLiveData.statusBarHeight.value ?: 0");
        bindingTitleBean.setStatusBarHeight(value.intValue());
        bindingTitleBean.setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.lw8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SunshineRunSuccessActivity.y0(this.f43173a, view);
            }
        });
        bindingTitleBean.setShowRightIcon(true);
        bindingTitleBean.setRightIconResId(R.drawable.run_ic_succ_share_toolbar);
        bindingTitleBean.setRightIconClick(new View.OnClickListener() { // from class: com.zj.adlib.mw8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SunshineRunSuccessActivity.z0(this.f43401a, view);
            }
        });
        mutableLiveDataI.setValue(bindingTitleBean);
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        super.initView();
        initTitleBar();
        l0();
        getMViewModel().getMoodAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.zj.adlib.pw8
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                SunshineRunSuccessActivity.A0(this.f44074a, baseQuickAdapter, view, i);
            }
        });
    }

    public final void l0() {
        BrandPromotionConfigBean brandPromotionConfigBeanC = ai9.c();
        if (brandPromotionConfigBeanC == null) {
            return;
        }
        String brandName = brandPromotionConfigBeanC.getBrandName();
        if (!(!StringsKt.isBlank(brandName))) {
            brandName = null;
        }
        if (brandName == null) {
            return;
        }
        String finishIconUrl = brandPromotionConfigBeanC.getFinishIconUrl();
        String str = StringsKt.isBlank(finishIconUrl) ^ true ? finishIconUrl : null;
        if (str == null) {
            return;
        }
        getMBinding().e.setVisibility(8);
        getMBinding().f11638b.setVisibility(0);
        Glide.with(getMBinding().f11638b).load(str).into(getMBinding().f11638b);
        getMBinding().f11639b.setText(m0(brandName));
    }

    public final CharSequence m0(String brandName) {
        String str = brandName + "恭喜您";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(RunIndexRecordAdapter.P), 0, brandName.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(RunIndexRecordAdapter.K), brandName.length(), str.length(), 33);
        return spannableString;
    }

    public final void n0() {
        InspirationBean inspiration;
        FinishRunResult finishRunResultV0 = v0();
        if (finishRunResultV0 == null || (inspiration = finishRunResultV0.getInspiration()) == null || inspiration.getStatus() == 0) {
            return;
        }
        InspirationDialog.INSTANCE.a("完成单次阳光跑任务", inspiration.getValue()).show(getSupportFragmentManager(), Reflection.getOrCreateKotlinClass(InspirationDialog.class).getSimpleName());
    }

    public final void o0(RunFinishBannerBean bean) {
        cm7.a(this, bean.getBannerNo());
        int jumpType = bean.getJumpType();
        if (jumpType == 1) {
            ARouter.getInstance().build(zj7.g.GOOD_DETAIL).withString("goodsNo", bean.getJumpContent()).navigation();
        } else if (jumpType == 2) {
            ARouter.getInstance().build(zj7.g.MERCHANTS).withString("shopNo", bean.getJumpContent()).navigation();
        } else {
            if (jumpType != 3) {
                return;
            }
            su9.l(this, bean.getJumpContent());
        }
    }

    public final void p0() {
        if (this.moodQuestionAnimating) {
            return;
        }
        this.moodQuestionAnimating = true;
        TextView textView = getMBinding().h;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.tvMoodQuestion");
        RecyclerView recyclerView = getMBinding().f11634a;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "mBinding.rvMood");
        final List<View> listListOf = CollectionsKt.listOf(new View[]{textView, recyclerView});
        final float fB = SizeUtils.b(10.0f);
        final PathInterpolator pathInterpolator = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        for (View view : listListOf) {
            view.animate().cancel();
            view.setTranslationY(0.0f);
            view.setAlpha(1.0f);
        }
        getMBinding().f11634a.postDelayed(new Runnable() { // from class: com.zj.adlib.nw8
            @Override // java.lang.Runnable
            public final void run() {
                SunshineRunSuccessActivity.q0(this.f18528a, listListOf, fB, pathInterpolator);
            }
        }, 220L);
    }

    public final long t0() {
        return ((Number) this.activityCode.getValue()).longValue();
    }

    public final long u0() {
        return ((Number) this.durationSecond.getValue()).longValue();
    }

    public final FinishRunResult v0() {
        return (FinishRunResult) this.finishRunResult.getValue();
    }

    public final long w0() {
        return ((Number) this.myPace.getValue()).longValue();
    }

    public final void x0(List<RunFinishBannerBean> list) {
        LinearLayout linearLayout = getMBinding().f11630a;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.llSportsPointMall");
        int iJ = fx7.j() - jj8.a(56.0f);
        double d2 = ((double) (iJ / MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME)) * 80.0d;
        Iterator<T> it = list.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double aspectRatio = ((RunFinishBannerBean) it.next()).getAspectRatio();
        while (it.hasNext()) {
            aspectRatio = Math.min(aspectRatio, ((RunFinishBannerBean) it.next()).getAspectRatio());
        }
        double dCoerceAtMost = RangesKt.coerceAtMost(d2, ((double) iJ) / (aspectRatio * ((double) list.size())));
        linearLayout.getLayoutParams().height = (int) dCoerceAtMost;
    }
}
