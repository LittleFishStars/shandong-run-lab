package com.huachenjie.run.page;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.huachenjie.common.base.BaseFragment;
import com.huachenjie.run.ICountDown;
import com.huachenjie.run.R;
import com.huachenjie.run.page.appeal.a;
import com.zj.adlib.cr2;
import com.zj.adlib.fx7;
import com.zj.adlib.jl7;
import com.zj.adlib.nl8;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0007¢\u0006\u0004\b5\u00106J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0014\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0014J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0005H\u0015R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010\u001fR\u0018\u0010+\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010\u001fR\u0018\u0010,\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001fR\u0018\u0010-\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010\u001fR\u0018\u0010.\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010\u001fR\u0014\u0010/\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00101\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00102R\u0018\u00104\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00102¨\u00069"}, d2 = {"Lcom/huachenjie/run/page/RunCountDownFragment;", "Lcom/huachenjie/common/base/BaseFragment;", "Lcom/huachenjie/run/page/appeal/a;", "Landroid/view/View;", "view", "", "flyInAnimator", "aheadPlayHotVoices", "showHotBodyTips", "do1stGirlAnim", "do2ndGirlAnim", "do3thGirlXMove", "Lcom/huachenjie/run/ICountDown;", RenderCallContext.TYPE_CALLBACK, "setCountDownCallback", "Landroid/widget/TextView;", "tvGo", "doGoYTransMove", "girlView", "doMoveYGirl3", "doGoScaleToDisappear", "onDestroyView", "onDestroy", "", "getContentViewRes", "initField", "Landroid/os/Bundle;", "arguments", "handleArguments", "initView", "mTvCountTime", "Landroid/widget/TextView;", "Landroid/animation/Animator;", "animator", "Landroid/animation/Animator;", "countDownCallback", "Lcom/huachenjie/run/ICountDown;", "Landroid/os/Handler;", "mHandler", "Landroid/os/Handler;", "backGroundColorRes", "I", "tvTopTips1", "tvTopTips2", "tvTopTips3", "tvHotBodyTips", "tvPage4thGO", "screenWidth", "Lcom/airbnb/lottie/LottieAnimationView;", "mJsGirl1", "Lcom/airbnb/lottie/LottieAnimationView;", "mJsGirl2", "mJsGirl3", "<init>", "()V", "Companion", "a", "run_release"}, k = 1, mv = {1, 8, 0})
public final class RunCountDownFragment extends BaseFragment<a> {
    private static final long COUNT_NUM_TIME = 1500;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String KEY_BACKGROUND_COLOR = "background_coloro";

    @NotNull
    private static final String TAG = "RunCountDownFragment";

    @Nullable
    private Animator animator;
    private int backGroundColorRes;

    @Nullable
    private ICountDown countDownCallback;

    @Nullable
    private Handler mHandler;

    @Nullable
    private LottieAnimationView mJsGirl1;

    @Nullable
    private LottieAnimationView mJsGirl2;

    @Nullable
    private LottieAnimationView mJsGirl3;

    @Nullable
    private TextView mTvCountTime;
    private final int screenWidth = fx7.j();

    @Nullable
    private TextView tvHotBodyTips;

    @Nullable
    private TextView tvPage4thGO;

    @Nullable
    private TextView tvTopTips1;

    @Nullable
    private TextView tvTopTips2;

    @Nullable
    private TextView tvTopTips3;

    /* JADX INFO: renamed from: com.huachenjie.run.page.RunCountDownFragment$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/run/page/RunCountDownFragment$a;", "", "Lcom/huachenjie/run/ICountDown;", "countDownCallback", "Lcom/huachenjie/run/page/RunCountDownFragment;", "a", "", "color", "b", "", "COUNT_NUM_TIME", "J", "", "KEY_BACKGROUND_COLOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RunCountDownFragment a(@NotNull ICountDown countDownCallback) {
            Intrinsics.checkNotNullParameter(countDownCallback, "countDownCallback");
            RunCountDownFragment runCountDownFragment = new RunCountDownFragment();
            runCountDownFragment.setCountDownCallback(countDownCallback);
            return runCountDownFragment;
        }

        @JvmStatic
        @NotNull
        public final RunCountDownFragment b(@NotNull ICountDown countDownCallback, @ColorRes int color) {
            Intrinsics.checkNotNullParameter(countDownCallback, "countDownCallback");
            RunCountDownFragment runCountDownFragment = new RunCountDownFragment();
            runCountDownFragment.setCountDownCallback(countDownCallback);
            Bundle bundle = new Bundle();
            bundle.putInt(RunCountDownFragment.KEY_BACKGROUND_COLOR, color);
            runCountDownFragment.setArguments(bundle);
            return runCountDownFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/run/page/RunCountDownFragment$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", com.ipd.dsp.internal.l.a.l, "", "onAnimationEnd", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, com.ipd.dsp.internal.l.a.l);
            Handler handler = RunCountDownFragment.this.mHandler;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, 100L);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/huachenjie/run/page/RunCountDownFragment$c", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            int i = msg.what;
            if (i == 8009) {
                ICountDown iCountDown = RunCountDownFragment.this.countDownCallback;
                if (iCountDown != null) {
                    iCountDown.i(RunCountDownFragment.this);
                }
                return;
            }
            if (i == 80031) {
                nl8.e(((BaseFragment) RunCountDownFragment.this)._mActivity).q(R.raw.run_run_count_down_ready);
                return;
            }
            switch (i) {
                case 8000:
                    RunCountDownFragment.this.aheadPlayHotVoices();
                    RunCountDownFragment.this.showHotBodyTips();
                    break;
                case 8001:
                    RunCountDownFragment.this.do1stGirlAnim();
                    break;
                case 8002:
                    RunCountDownFragment.this.do2ndGirlAnim();
                    break;
                case 8003:
                    RunCountDownFragment.this.do3thGirlXMove();
                    break;
                case AVMDLDataLoader.KeyIsLiveGetCurrentBitRate /* 8004 */:
                    TextView textView = RunCountDownFragment.this.mTvCountTime;
                    if (textView != null) {
                        textView.setVisibility(4);
                    }
                    TextView textView2 = RunCountDownFragment.this.tvTopTips1;
                    if (textView2 != null) {
                        textView2.setVisibility(4);
                    }
                    nl8.e(((BaseFragment) RunCountDownFragment.this)._mActivity).q(R.raw.run_run_count_down_go);
                    RunCountDownFragment runCountDownFragment = RunCountDownFragment.this;
                    runCountDownFragment.doGoYTransMove(runCountDownFragment.tvPage4thGO);
                    RunCountDownFragment runCountDownFragment2 = RunCountDownFragment.this;
                    runCountDownFragment2.doMoveYGirl3(runCountDownFragment2.mJsGirl3);
                    RunCountDownFragment runCountDownFragment3 = RunCountDownFragment.this;
                    runCountDownFragment3.doGoScaleToDisappear(runCountDownFragment3.tvPage4thGO);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void aheadPlayHotVoices() {
        nl8.e(this._mActivity).q(R.raw.run_run_count_down_pre_4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void do1stGirlAnim() {
        nl8.e(this._mActivity).q(R.raw.run_run_count_down_interval, R.raw.run_run_count_down_num_3);
        TextView textView = this.mTvCountTime;
        if (textView != null) {
            textView.setText("3");
        }
        View viewF = f(R.id.ivGirl01);
        Intrinsics.checkNotNull(viewF, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView = (LottieAnimationView) viewF;
        this.mJsGirl1 = lottieAnimationView;
        Intrinsics.checkNotNull(lottieAnimationView);
        flyInAnimator(lottieAnimationView);
        View view = this.tvTopTips3;
        Intrinsics.checkNotNull(view);
        flyInAnimator(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void do2ndGirlAnim() {
        nl8.e(this._mActivity).q(R.raw.run_run_count_down_interval, R.raw.run_run_count_down_num_2);
        LottieAnimationView lottieAnimationView = this.mJsGirl1;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        TextView textView = this.tvTopTips3;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mTvCountTime;
        if (textView2 != null) {
            textView2.setText("2");
        }
        View viewF = f(R.id.ivGirl02);
        Intrinsics.checkNotNull(viewF, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) viewF;
        this.mJsGirl2 = lottieAnimationView2;
        Intrinsics.checkNotNull(lottieAnimationView2);
        flyInAnimator(lottieAnimationView2);
        View view = this.tvTopTips2;
        Intrinsics.checkNotNull(view);
        flyInAnimator(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void do3thGirlXMove() {
        nl8.e(this._mActivity).q(R.raw.run_run_count_down_interval);
        LottieAnimationView lottieAnimationView = this.mJsGirl2;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        TextView textView = this.tvTopTips2;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.mTvCountTime;
        if (textView2 != null) {
            textView2.setText("1");
        }
        View viewF = f(R.id.ivGirl03);
        Intrinsics.checkNotNull(viewF, "null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) viewF;
        this.mJsGirl3 = lottieAnimationView2;
        Intrinsics.checkNotNull(lottieAnimationView2);
        flyInAnimator(lottieAnimationView2);
        View view = this.tvTopTips1;
        Intrinsics.checkNotNull(view);
        flyInAnimator(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doGoScaleToDisappear(TextView tvGo) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) View.SCALE_X, 1.5f, 3.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) View.SCALE_Y, 1.5f, 3.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) View.ALPHA, 1.0f, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        animatorSet.setDuration(300L);
        animatorSet.setStartDelay(600L);
        animatorSet.setInterpolator(jl7.f17430a.a());
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doGoYTransMove(TextView tvGo) {
        TextView textView = this.tvHotBodyTips;
        if (textView != null) {
            textView.setVisibility(8);
        }
        TextView textView2 = this.tvPage4thGO;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        Property property = View.Y;
        int iC = fx7.c();
        Intrinsics.checkNotNull(tvGo);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) property, (iC - tvGo.getHeight()) / 2.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) View.ALPHA, 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) View.SCALE_X, 1.0f, 1.5f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(tvGo, (Property<TextView, Float>) View.SCALE_Y, 1.0f, 1.5f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4);
        animatorSet.setDuration(300L);
        animatorSet.setInterpolator(jl7.f17430a.a());
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doMoveYGirl3(View girlView) {
        Property property = View.Y;
        int iC = fx7.c();
        Intrinsics.checkNotNull(girlView);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(girlView, (Property<View, Float>) property, iC - girlView.getHeight());
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(jl7.f17430a.a());
        objectAnimatorOfFloat.start();
    }

    private final void flyInAnimator(View view) {
        view.setVisibility(0);
        float width = view.getWidth();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.X, -width, (this.screenWidth - width) / 2.0f);
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.setInterpolator(jl7.f17430a.a());
        objectAnimatorOfFloat.start();
    }

    @JvmStatic
    @NotNull
    public static final RunCountDownFragment newInstance(@NotNull ICountDown iCountDown, @ColorRes int i) {
        return INSTANCE.b(iCountDown, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCountDownCallback(ICountDown callback) {
        this.countDownCallback = callback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showHotBodyTips() {
        TextView textView = this.tvHotBodyTips;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public int getContentViewRes() {
        return R.layout.run_fragment_run_count_down;
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void handleArguments(@NotNull Bundle arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.backGroundColorRes = arguments.getInt(KEY_BACKGROUND_COLOR);
    }

    @Override // com.huachenjie.common.base.BaseFragment
    public void initField() {
        this.mHandler = new c(Looper.getMainLooper());
    }

    @Override // com.huachenjie.common.base.BaseFragment
    @SuppressLint({"ObjectAnimatorBinding"})
    public void initView() {
        View viewF = f(R.id.tv_count_time);
        Intrinsics.checkNotNull(viewF, "null cannot be cast to non-null type android.widget.TextView");
        this.mTvCountTime = (TextView) viewF;
        View viewF2 = f(R.id.tvTopTips3);
        Intrinsics.checkNotNull(viewF2, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTopTips3 = (TextView) viewF2;
        View viewF3 = f(R.id.tvTopTips2);
        Intrinsics.checkNotNull(viewF3, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTopTips2 = (TextView) viewF3;
        View viewF4 = f(R.id.tvTopTips1);
        Intrinsics.checkNotNull(viewF4, "null cannot be cast to non-null type android.widget.TextView");
        this.tvTopTips1 = (TextView) viewF4;
        View viewF5 = f(R.id.tvHotBodyTips);
        Intrinsics.checkNotNull(viewF5, "null cannot be cast to non-null type android.widget.TextView");
        this.tvHotBodyTips = (TextView) viewF5;
        View viewF6 = f(R.id.tvPage4thGO);
        Intrinsics.checkNotNull(viewF6, "null cannot be cast to non-null type android.widget.TextView");
        this.tvPage4thGO = (TextView) viewF6;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mTvCountTime, "translationY", 0.0f, cr2.c(requireContext(), 100.0f));
        this.animator = objectAnimatorOfFloat;
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setDuration(1500L);
        }
        Animator animator = this.animator;
        if (animator != null) {
            animator.setInterpolator(new LinearInterpolator());
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.sendEmptyMessage(8000);
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(8001, 1500L);
        }
        Handler handler3 = this.mHandler;
        if (handler3 != null) {
            handler3.sendEmptyMessageDelayed(8002, 3500L);
        }
        Handler handler4 = this.mHandler;
        if (handler4 != null) {
            handler4.sendEmptyMessageDelayed(8003, 5500L);
        }
        Handler handler5 = this.mHandler;
        if (handler5 != null) {
            handler5.sendEmptyMessageDelayed(80031, 6300L);
        }
        Handler handler6 = this.mHandler;
        if (handler6 != null) {
            handler6.sendEmptyMessageDelayed(AVMDLDataLoader.KeyIsLiveGetCurrentBitRate, 7500L);
        }
    }

    @Override // com.huachenjie.common.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        nl8.e(this._mActivity).v(true);
        this.countDownCallback = null;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Animator animator = this.animator;
        if (animator != null) {
            Intrinsics.checkNotNull(animator);
            if (animator.isRunning()) {
                Animator animator2 = this.animator;
                Intrinsics.checkNotNull(animator2);
                animator2.cancel();
            }
        }
    }
}
