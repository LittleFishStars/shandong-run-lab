package com.huachenjie.sport.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.huachenjie.sport.R;
import com.huachenjie.sport.page.mine.huodong.HuodongSignStatus;
import com.huachenjie.sport.widget.HuodongSignButton;
import com.zj.adlib.c25;
import com.zj.adlib.w79;
import com.zj.adlib.zn1;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001)B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"B\u001b\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#¢\u0006\u0004\b!\u0010%B#\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b!\u0010(J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\u0006H\u0014J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001cR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001e¨\u0006*"}, d2 = {"Lcom/huachenjie/sport/widget/HuodongSignButton;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/huachenjie/sport/page/mine/huodong/HuodongSignStatus;", "status", "", "time", "", "setStatus", "(Lcom/huachenjie/sport/page/mine/huodong/HuodongSignStatus;Ljava/lang/Long;)V", "onDetachedFromWindow", "Lcom/huachenjie/sport/widget/HuodongSignButton$CountDownCompleteListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setCountDownListener", "f", "startTime", "Landroid/widget/TextView;", "tvSignTip", "c", "a", "Landroid/widget/TextView;", "tvSign", "b", "Landroidx/appcompat/widget/LinearLayoutCompat;", "llSign", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "ivSighSuccess", "Lio/reactivex/disposables/Disposable;", "Lio/reactivex/disposables/Disposable;", "countdownDisposable", "Lcom/huachenjie/sport/widget/HuodongSignButton$CountDownCompleteListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CountDownCompleteListener", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class HuodongSignButton extends LinearLayoutCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public ImageView ivSighSuccess;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public TextView tvSign;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public LinearLayoutCompat llSign;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public CountDownCompleteListener listener;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Disposable countdownDisposable;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public TextView tvSignTip;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/huachenjie/sport/widget/HuodongSignButton$CountDownCompleteListener;", "", "onComplete", "", "sport_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface CountDownCompleteListener {
        void onComplete();
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36747a;

        static {
            int[] iArr = new int[HuodongSignStatus.values().length];
            try {
                iArr[HuodongSignStatus.sign_start.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HuodongSignStatus.sign_not_start.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HuodongSignStatus.sign_count_full.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HuodongSignStatus.sign_success.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HuodongSignStatus.sign_grade_discrepancy.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HuodongSignStatus.sign_faculty_discrepancy.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HuodongSignStatus.sign_finish.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f36747a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HuodongSignButton(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static final void d(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public static final void e(HuodongSignButton huodongSignButton) {
        Intrinsics.checkNotNullParameter(huodongSignButton, "this$0");
        c25.p("complete");
        huodongSignButton.setStatus(HuodongSignStatus.sign_finish, null);
        CountDownCompleteListener countDownCompleteListener = huodongSignButton.listener;
        if (countDownCompleteListener != null) {
            countDownCompleteListener.onComplete();
        }
    }

    public final void c(final long startTime, final TextView tvSignTip) {
        Observable observableObserveOn = Observable.intervalRange(0L, (startTime / ((long) 1000)) + 1, 0L, 1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.huachenjie.sport.widget.HuodongSignButton$countdown$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Long l) {
                tvSignTip.setText("剩余" + w79.f45538a.a(startTime - (l.longValue() * ((long) 1000))) + "截止");
            }
        };
        this.countdownDisposable = observableObserveOn.doOnNext(new Consumer() { // from class: com.zj.adlib.l34
            public final void accept(Object obj) {
                HuodongSignButton.d(function1, obj);
            }
        }).doOnComplete(new Action() { // from class: com.zj.adlib.m34
            public final void run() {
                HuodongSignButton.e(this.f43209a);
            }
        }).subscribe();
    }

    public final void f() {
        View viewInflate = View.inflate(getContext(), R.layout.widget_huodong_sign_button, this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat");
        this.tvSign = (TextView) findViewById(R.id.tv_sign);
        this.tvSignTip = (TextView) findViewById(R.id.tv_sign_tip);
        this.llSign = (LinearLayoutCompat) findViewById(R.id.ll_sign);
        this.ivSighSuccess = (ImageView) findViewById(R.id.iv_ic_sign_success);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Disposable disposable = this.countdownDisposable;
        if (disposable != null) {
            Intrinsics.checkNotNull(disposable);
            if (!disposable.isDisposed()) {
                Disposable disposable2 = this.countdownDisposable;
                Intrinsics.checkNotNull(disposable2);
                disposable2.dispose();
                this.countdownDisposable = null;
            }
        }
        this.listener = null;
        super.onDetachedFromWindow();
    }

    public final void setCountDownListener(@NotNull CountDownCompleteListener listener) {
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        this.listener = listener;
    }

    public final void setStatus(@Nullable HuodongSignStatus status, @Nullable Long time) {
        TextView textView = this.tvSign;
        if (textView != null) {
            textView.setText(status != null ? status.getContent() : null);
        }
        ImageView imageView = this.ivSighSuccess;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        Disposable disposable = this.countdownDisposable;
        if (disposable != null) {
            Intrinsics.checkNotNull(disposable);
            if (!disposable.isDisposed()) {
                Disposable disposable2 = this.countdownDisposable;
                Intrinsics.checkNotNull(disposable2);
                disposable2.dispose();
                this.countdownDisposable = null;
            }
        }
        switch (status == null ? -1 : a.f36747a[status.ordinal()]) {
            case 1:
                LinearLayoutCompat linearLayoutCompat = this.llSign;
                if (linearLayoutCompat != null) {
                    Drawable background = linearLayoutCompat.getBackground();
                    Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background).setColor(zn1.a(R.color.color_main_v2));
                }
                TextView textView2 = this.tvSignTip;
                if (textView2 != null) {
                    if (time == null || time.longValue() <= 0) {
                        textView2.setVisibility(4);
                    } else if (time.longValue() > 259200000) {
                        textView2.setVisibility(4);
                    } else if (time.longValue() < 86400000) {
                        textView2.setVisibility(0);
                        textView2.setText("剩余" + w79.f45538a.a(time.longValue()) + "截止");
                        c(time.longValue(), textView2);
                    } else {
                        textView2.setVisibility(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append("剩余");
                        long j = 60;
                        sb.append((((time.longValue() / ((long) 1000)) / j) / j) / ((long) 24));
                        sb.append("天截止");
                        textView2.setText(sb.toString());
                    }
                }
                break;
            case 2:
                LinearLayoutCompat linearLayoutCompat2 = this.llSign;
                if (linearLayoutCompat2 != null) {
                    Drawable background2 = linearLayoutCompat2.getBackground();
                    Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background2).setColor(zn1.a(R.color.color_8997A4));
                }
                TextView textView3 = this.tvSignTip;
                if (textView3 != null) {
                    textView3.setVisibility(4);
                    break;
                }
                break;
            case 3:
                LinearLayoutCompat linearLayoutCompat3 = this.llSign;
                if (linearLayoutCompat3 != null) {
                    Drawable background3 = linearLayoutCompat3.getBackground();
                    Intrinsics.checkNotNull(background3, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background3).setColor(zn1.a(R.color.color_8997A4));
                }
                TextView textView4 = this.tvSignTip;
                if (textView4 != null) {
                    textView4.setVisibility(4);
                    break;
                }
                break;
            case 4:
                ImageView imageView2 = this.ivSighSuccess;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                LinearLayoutCompat linearLayoutCompat4 = this.llSign;
                if (linearLayoutCompat4 != null) {
                    Drawable background4 = linearLayoutCompat4.getBackground();
                    Intrinsics.checkNotNull(background4, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background4).setColor(zn1.a(R.color.color_00C97C));
                    ViewGroup.LayoutParams layoutParams = linearLayoutCompat4.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                    LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) layoutParams;
                    ((LinearLayout.LayoutParams) layoutParams2).gravity = GravityCompat.END;
                    linearLayoutCompat4.setLayoutParams(layoutParams2);
                }
                TextView textView5 = this.tvSignTip;
                if (textView5 != null) {
                    textView5.setVisibility(0);
                    textView5.setText("*如需要撤回报名，请联系老师");
                    ViewGroup.LayoutParams layoutParams3 = textView5.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.appcompat.widget.LinearLayoutCompat.LayoutParams");
                    LinearLayoutCompat.LayoutParams layoutParams4 = (LinearLayoutCompat.LayoutParams) layoutParams3;
                    ((LinearLayout.LayoutParams) layoutParams4).gravity = GravityCompat.END;
                    textView5.setLayoutParams(layoutParams4);
                }
                break;
            case 5:
                LinearLayoutCompat linearLayoutCompat5 = this.llSign;
                if (linearLayoutCompat5 != null) {
                    Drawable background5 = linearLayoutCompat5.getBackground();
                    Intrinsics.checkNotNull(background5, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background5).setColor(zn1.a(R.color.color_8997A4));
                }
                TextView textView6 = this.tvSignTip;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                    textView6.setText("不可报名");
                }
                break;
            case 6:
                LinearLayoutCompat linearLayoutCompat6 = this.llSign;
                if (linearLayoutCompat6 != null) {
                    Drawable background6 = linearLayoutCompat6.getBackground();
                    Intrinsics.checkNotNull(background6, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background6).setColor(zn1.a(R.color.color_8997A4));
                }
                TextView textView7 = this.tvSignTip;
                if (textView7 != null) {
                    textView7.setVisibility(0);
                    textView7.setText("不可报名");
                }
                break;
            case 7:
                LinearLayoutCompat linearLayoutCompat7 = this.llSign;
                if (linearLayoutCompat7 != null) {
                    Drawable background7 = linearLayoutCompat7.getBackground();
                    Intrinsics.checkNotNull(background7, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                    ((GradientDrawable) background7).setColor(zn1.a(R.color.color_8997A4));
                }
                TextView textView8 = this.tvSignTip;
                if (textView8 != null) {
                    textView8.setVisibility(4);
                    break;
                }
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HuodongSignButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HuodongSignButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        f();
    }
}
