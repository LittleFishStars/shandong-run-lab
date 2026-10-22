package com.huachenjie.common.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.R;
import com.huachenjie.common.dialog.LocationCountDownDialog;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u001f\u001a\u00020\nH\u0002J\b\u0010 \u001a\u00020\nH\u0002J\u0012\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\nH\u0016J\u000e\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/huachenjie/common/dialog/LocationCountDownDialog;", "Landroid/app/Dialog;", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "tips", "", "totalSecs", "", RenderCallContext.TYPE_CALLBACK, "Lkotlin/Function0;", "", "(Landroid/app/Activity;Ljava/lang/String;ILkotlin/jvm/functions/Function0;)V", "countDownEndCallback", "getCountDownEndCallback", "()Lkotlin/jvm/functions/Function0;", "setCountDownEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "ivClose", "Landroid/widget/ImageView;", "lottieLocation", "Lcom/airbnb/lottie/LottieAnimationView;", "mHandler", "Landroid/os/Handler;", "mLeftTime", "mRunTask", "Ljava/lang/Runnable;", "timer", "Ljava/util/Timer;", "tvLeftTime", "Landroid/widget/TextView;", "tvTips", "countDown", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "show", "initSec", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LocationCountDownDialog extends Dialog {

    @NotNull
    private final Activity activity;

    @Nullable
    private final Function0<Unit> callback;

    @Nullable
    private Function0<Unit> countDownEndCallback;

    @Nullable
    private ImageView ivClose;

    @Nullable
    private LottieAnimationView lottieLocation;

    @NotNull
    private Handler mHandler;
    private int mLeftTime;

    @NotNull
    private Runnable mRunTask;

    @Nullable
    private Timer timer;

    @Nullable
    private final String tips;
    private final int totalSecs;

    @Nullable
    private TextView tvLeftTime;

    @Nullable
    private TextView tvTips;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"com/huachenjie/common/dialog/LocationCountDownDialog$a", "Ljava/util/TimerTask;", "", "run", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LocationCountDownDialog.this.mHandler.post(LocationCountDownDialog.this.mRunTask);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationCountDownDialog(@NotNull Activity activity, @Nullable String str, int i, @Nullable Function0<Unit> function0) {
        super(activity, R.style.base_dialog_theme);
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        this.activity = activity;
        this.tips = str;
        this.totalSecs = i;
        this.callback = function0;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mLeftTime = i <= 0 ? 0 : i;
        this.mRunTask = new Runnable() { // from class: com.zj.adlib.b05
            @Override // java.lang.Runnable
            public final void run() {
                LocationCountDownDialog.mRunTask$lambda$0(this.f40647a);
            }
        };
    }

    private final void countDown() {
        Timer timer = this.timer;
        if (timer != null) {
            if (timer != null) {
                timer.cancel();
            }
            this.timer = null;
            this.timer = new Timer();
        } else {
            this.timer = new Timer();
        }
        try {
            Timer timer2 = this.timer;
            if (timer2 != null) {
                timer2.scheduleAtFixedRate(new a(), 1000L, 1000L);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void initView() {
        this.tvLeftTime = (TextView) findViewById(R.id.tvLeftTime);
        this.tvTips = (TextView) findViewById(R.id.tvMessage);
        this.ivClose = (ImageView) findViewById(R.id.ivClose);
        this.lottieLocation = (LottieAnimationView) findViewById(R.id.lottieLocation);
        TextView textView = this.tvTips;
        if (textView != null) {
            textView.setText(this.tips);
        }
        TextView textView2 = this.tvLeftTime;
        if (textView2 != null) {
            textView2.setText(String.valueOf(this.totalSecs));
        }
        ImageView imageView = this.ivClose;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.a05
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LocationCountDownDialog.initView$lambda$1(this.f40425a, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(LocationCountDownDialog locationCountDownDialog, View view) {
        Intrinsics.checkNotNullParameter(locationCountDownDialog, "this$0");
        Function0<Unit> function0 = locationCountDownDialog.callback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mRunTask$lambda$0(LocationCountDownDialog locationCountDownDialog) {
        Intrinsics.checkNotNullParameter(locationCountDownDialog, "this$0");
        if (!locationCountDownDialog.isShowing() || locationCountDownDialog.activity.isDestroyed() || locationCountDownDialog.activity.isFinishing()) {
            return;
        }
        if (locationCountDownDialog.mLeftTime <= 0) {
            Function0<Unit> function0 = locationCountDownDialog.countDownEndCallback;
            if (function0 != null) {
                function0.invoke();
            }
            locationCountDownDialog.dismiss();
        }
        int i = locationCountDownDialog.mLeftTime - 1;
        locationCountDownDialog.mLeftTime = i;
        TextView textView = locationCountDownDialog.tvLeftTime;
        if (textView == null) {
            return;
        }
        textView.setText(String.valueOf(i));
    }

    @Nullable
    public final Function0<Unit> getCountDownEndCallback() {
        return this.countDownEndCallback;
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_location_count_down);
        Window window = getWindow();
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        Intrinsics.checkNotNull(window);
        window.setDimAmount(0.5f);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
        initView();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mHandler.removeCallbacksAndMessages(null);
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        this.timer = null;
        LottieAnimationView lottieAnimationView = this.lottieLocation;
        if (lottieAnimationView != null) {
            lottieAnimationView.cancelAnimation();
        }
    }

    public final void setCountDownEndCallback(@Nullable Function0<Unit> function0) {
        this.countDownEndCallback = function0;
    }

    public final void show(int initSec) {
        super.show();
        this.mLeftTime = initSec;
        TextView textView = this.tvLeftTime;
        if (textView != null) {
            textView.setText(String.valueOf(initSec));
        }
        LottieAnimationView lottieAnimationView = this.lottieLocation;
        if (lottieAnimationView != null && !lottieAnimationView.isAnimating()) {
            lottieAnimationView.playAnimation();
        }
        countDown();
    }
}
