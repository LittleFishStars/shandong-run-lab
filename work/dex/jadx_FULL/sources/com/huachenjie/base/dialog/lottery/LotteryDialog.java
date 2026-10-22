package com.huachenjie.base.dialog.lottery;

import android.content.Context;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.p002lifecycle.Observer;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.huachenjie.base.R;
import com.huachenjie.base.bean.reward.RewardInfoBean;
import com.huachenjie.base.databinding.DialogLotteryBinding;
import com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment;
import com.huachenjie.home.page.reward_detail.RewardDetailActivity;
import com.zj.adlib.fb4;
import com.zj.adlib.fv5;
import com.zj.adlib.i4a;
import com.zj.adlib.sk0;
import com.zj.adlib.ze1;
import com.zj.adlib.zj7;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 -2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002./B\u0007¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\u0017R\u001b\u0010\u001f\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\"\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0015\u001a\u0004\b!\u0010\u0017R\u001b\u0010%\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0015\u001a\u0004\b$\u0010\u001eR\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/huachenjie/base/dialog/lottery/LotteryDialog;", "Lcom/huachenjie/common/reconfig/mvvm/BaseMVVMDialogFragment;", "Lcom/huachenjie/base/databinding/DialogLotteryBinding;", "Lcom/huachenjie/base/dialog/lottery/LotteryVM;", "Lcom/bumptech/glide/integration/webp/decoder/WebpDrawable;", "drawable", "", "resetWebpDrawable", "checkRewardInfo", "", "getWidth", "getHeight", "getLayoutResID", "", "", "getVariables", "initData", "initView", "initDataObserve", "", "title$delegate", "Lkotlin/Lazy;", "getTitle", "()Ljava/lang/String;", "title", "lotteryNo$delegate", "getLotteryNo", LotteryDialog.LOTTERY_NO, "inspiration$delegate", "getInspiration", "()I", LotteryDialog.INSPIRATION, "awardNo$delegate", "getAwardNo", LotteryDialog.AWARD_NO, "source$delegate", "getSource", "source", "requestState", "I", "", "showTime", "J", "<init>", "()V", "Companion", "a", "b", "base_release"}, k = 1, mv = {1, 8, 0})
public final class LotteryDialog extends BaseMVVMDialogFragment<DialogLotteryBinding, LotteryVM> {

    @NotNull
    private static final String AWARD_NO = "awardNo";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int IDLE = 0;

    @NotNull
    private static final String INSPIRATION = "inspiration";

    @NotNull
    private static final String LOTTERY_NO = "lotteryNo";

    @NotNull
    private static final String SOURCE = "source";
    public static final int SOURCE_EXCHANGE = 2;
    public static final int SOURCE_HOME_DRAW = 1;

    @NotNull
    private static final String TITLE = "title";
    private int requestState;
    private long showTime;

    /* JADX INFO: renamed from: title$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy title = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog$title$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("title")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: lotteryNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy lotteryNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog$lotteryNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("lotteryNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: inspiration$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inspiration = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog$inspiration$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m216invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("inspiration") : 0);
        }
    });

    /* JADX INFO: renamed from: awardNo$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy awardNo = LazyKt.lazy(new Function0<String>() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog$awardNo$2
        {
            super(0);
        }

        @NotNull
        public final String invoke() {
            String string;
            Bundle arguments = this.this$0.getArguments();
            return (arguments == null || (string = arguments.getString("awardNo")) == null) ? "" : string;
        }
    });

    /* JADX INFO: renamed from: source$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy source = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog$source$2
        {
            super(0);
        }

        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m218invoke() {
            Bundle arguments = this.this$0.getArguments();
            return Integer.valueOf(arguments != null ? arguments.getInt("source") : 1);
        }
    });

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/base/dialog/lottery/LotteryDialog$a;", "", "Landroid/view/View;", "view", "", "a", "<init>", "(Lcom/huachenjie/base/dialog/lottery/LotteryDialog;)V", "base_release"}, k = 1, mv = {1, 8, 0})
    public final class a {
        public a() {
        }

        public final void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            LotteryDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.huachenjie.base.dialog.lottery.LotteryDialog$b, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/base/dialog/lottery/LotteryDialog$b;", "", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "title", LotteryDialog.LOTTERY_NO, "", LotteryDialog.INSPIRATION, LotteryDialog.AWARD_NO, "source", "", "a", "AWARD_NO", "Ljava/lang/String;", RVScheduleType.IDLE, "I", "INSPIRATION", "LOTTERY_NO", "SOURCE", "SOURCE_EXCHANGE", "SOURCE_HOME_DRAW", "TITLE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, FragmentManager fragmentManager, String str, String str2, int i, String str3, int i2, int i3, Object obj) {
            if ((i3 & 32) != 0) {
                i2 = 1;
            }
            companion.a(fragmentManager, str, str2, i, str3, i2);
        }

        public final void a(@NotNull FragmentManager fragmentManager, @NotNull String title, @NotNull String lotteryNo, int inspiration, @NotNull String awardNo, int source) {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(lotteryNo, LotteryDialog.LOTTERY_NO);
            Intrinsics.checkNotNullParameter(awardNo, LotteryDialog.AWARD_NO);
            LotteryDialog lotteryDialog = new LotteryDialog();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString(LotteryDialog.LOTTERY_NO, lotteryNo);
            bundle.putInt(LotteryDialog.INSPIRATION, inspiration);
            bundle.putString(LotteryDialog.AWARD_NO, awardNo);
            bundle.putInt("source", source);
            lotteryDialog.setArguments(bundle);
            lotteryDialog.show(fragmentManager, "LotteryDialog");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/base/dialog/lottery/LotteryDialog$c", "Landroid/graphics/drawable/Animatable2$AnimationCallback;", "Landroid/graphics/drawable/Drawable;", "drawable", "", "onAnimationEnd", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends Animatable2.AnimationCallback {
        public c() {
        }

        @Override // android.graphics.drawable.Animatable2.AnimationCallback
        public void onAnimationEnd(@Nullable Drawable drawable) {
            LotteryDialog.this.requestState++;
            if (LotteryDialog.this.requestState >= 2) {
                LotteryDialog.this.checkRewardInfo();
            }
        }
    }

    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\u000b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J>\u0010\u000f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"com/huachenjie/base/dialog/lottery/LotteryDialog$d", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "Lcom/bumptech/glide/load/engine/GlideException;", "e", "", ze1.k, "Lcom/bumptech/glide/request/target/Target;", "target", "", "isFirstResource", "onLoadFailed", "resource", "Lcom/bumptech/glide/load/DataSource;", "dataSource", "a", "base_release"}, k = 1, mv = {1, 8, 0})
    public static final class d implements RequestListener<Drawable> {
        public d() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(@Nullable Drawable resource, @Nullable Object model, @Nullable Target<Drawable> target, @Nullable DataSource dataSource, boolean isFirstResource) {
            if (resource == null) {
                return false;
            }
            LotteryDialog lotteryDialog = LotteryDialog.this;
            if (!(resource instanceof WebpDrawable)) {
                return false;
            }
            lotteryDialog.resetWebpDrawable((WebpDrawable) resource);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @Nullable Target<Drawable> target, boolean isFirstResource) {
            return false;
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class e implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f32890a;

        public e(Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "function");
            this.f32890a = function1;
        }

        public final boolean equals(@Nullable Object obj) {
            if ((obj instanceof Observer) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
            }
            return false;
        }

        @NotNull
        public final Function<?> getFunctionDelegate() {
            return this.f32890a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.p002lifecycle.Observer
        public final /* synthetic */ void onChanged(Object obj) {
            this.f32890a.invoke(obj);
        }
    }

    public static final /* synthetic */ LotteryVM access$getMViewModel(LotteryDialog lotteryDialog) {
        return lotteryDialog.getMViewModel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0067  */
    public final void checkRewardInfo() {
        ImageView imageView;
        boolean z;
        i4a.c("showTime:" + (System.currentTimeMillis() - this.showTime) + "ms");
        DialogLotteryBinding mBinding = getMBinding();
        if (mBinding == null || (imageView = mBinding.f32825a) == null) {
            return;
        }
        Glide.with(this).clear(imageView);
        RewardInfoBean value = getMViewModel().k().getValue();
        if (value == null) {
            dismissAllowingStateLoss();
            return;
        }
        Integer value2 = getMViewModel().j().getValue();
        if (value2 != null) {
            z = value2.intValue() == 1;
        }
        if (z) {
            Object objNavigation = ARouter.getInstance().build(zj7.e.REWARD_INFO_DIALOG).navigation();
            Bundle bundle = new Bundle();
            String title = getTitle();
            Intrinsics.checkNotNullExpressionValue(title, "title");
            value.setDialogTitle(title);
            bundle.putParcelable(RewardDetailActivity.t, value);
            Intrinsics.checkNotNull(objNavigation, "null cannot be cast to non-null type androidx.fragment.app.DialogFragment");
            DialogFragment dialogFragment = (DialogFragment) objNavigation;
            dialogFragment.setArguments(bundle);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                dialogFragment.show(activity.getSupportFragmentManager(), "RewardInfoDialog");
            }
        } else {
            fv5.b(value.getErrorTip());
        }
        dismissAllowingStateLoss();
    }

    private final String getAwardNo() {
        return (String) this.awardNo.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInspiration() {
        return ((Number) this.inspiration.getValue()).intValue();
    }

    private final String getLotteryNo() {
        return (String) this.lotteryNo.getValue();
    }

    private final int getSource() {
        return ((Number) this.source.getValue()).intValue();
    }

    private final String getTitle() {
        return (String) this.title.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetWebpDrawable(WebpDrawable drawable) {
        drawable.stop();
        drawable.setLoopCount(1);
        drawable.registerAnimationCallback(new Animatable2Compat.AnimationCallback() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog.resetWebpDrawable.1
            @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
            public void onAnimationEnd(@NotNull Drawable drawable2) {
                Intrinsics.checkNotNullParameter(drawable2, "drawable");
                LotteryDialog.this.requestState++;
                if (LotteryDialog.this.requestState >= 2) {
                    LotteryDialog.this.checkRewardInfo();
                }
            }
        });
        drawable.startFromFirstFrame();
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getHeight() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public int getLayoutResID() {
        return R.layout.dialog_lottery;
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    @NotNull
    public Map<Integer, Object> getVariables() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(sk0.p0), getMViewModel()), TuplesKt.to(Integer.valueOf(sk0.k), new a())});
    }

    @Override // com.huachenjie.common.reconfig.baseView.BaseDialogFragment
    public int getWidth() {
        return -1;
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initData() {
        getMViewModel().l().setValue(getTitle());
        LotteryVM mViewModel = getMViewModel();
        String lotteryNo = getLotteryNo();
        Intrinsics.checkNotNullExpressionValue(lotteryNo, LOTTERY_NO);
        int inspiration = getInspiration();
        String awardNo = getAwardNo();
        Intrinsics.checkNotNullExpressionValue(awardNo, AWARD_NO);
        mViewModel.i(lotteryNo, inspiration, awardNo, getSource());
        this.showTime = System.currentTimeMillis();
    }

    @Override // com.huachenjie.common.reconfig.mvvm.BaseMVVMDialogFragment
    public void initDataObserve() {
        getMViewModel().k().observe(this, new e(new Function1<RewardInfoBean, Unit>() { // from class: com.huachenjie.base.dialog.lottery.LotteryDialog.initDataObserve.1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RewardInfoBean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable RewardInfoBean rewardInfoBean) {
                Context context;
                LotteryDialog.this.requestState++;
                if (LotteryDialog.this.requestState >= 2) {
                    LotteryDialog.this.checkRewardInfo();
                }
                Integer value = LotteryDialog.access$getMViewModel(LotteryDialog.this).j().getValue();
                if (value == null || value.intValue() != 1 || (context = LotteryDialog.this.getContext()) == null) {
                    return;
                }
                fb4.f41638a.a(context, LotteryDialog.this.getInspiration() * (-1));
            }
        }));
    }

    @Override // com.huachenjie.common.reconfig.baseView.IBaseView
    public void initView() {
        ImageView imageView;
        DialogLotteryBinding mBinding = getMBinding();
        if (mBinding == null || (imageView = mBinding.f32825a) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 29) {
            Glide.with(this).load(Integer.valueOf(R.drawable.ic_home_lottery)).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new FitCenter())).addListener(new d()).into(imageView);
            return;
        }
        Drawable drawable = imageView.getDrawable();
        if (drawable != null && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            animatedImageDrawable.start();
            animatedImageDrawable.setRepeatCount(0);
            animatedImageDrawable.registerAnimationCallback(new c());
        }
    }
}
