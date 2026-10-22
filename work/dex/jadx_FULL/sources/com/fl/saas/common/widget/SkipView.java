package com.fl.saas.common.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.util.Function;
import com.fl.saas.common.util.ViewHelper;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.s2s.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SkipView extends FrameLayout {
    private Runnable cancelFun;
    private CircularCountDownView circle_skip;
    private Runnable finishFun;
    private CountDownTimer mTimer;
    private int remainingCount;
    private boolean showCountDown;
    private Function<Integer, String> tickFun;
    private int totalCount;
    private CountDownTextView tv_skip;
    private int type;
    private View v_skip;
    private int value;

    public SkipView(@NonNull Context context) {
        super(context);
        this.totalCount = 5;
    }

    public SkipView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SkipView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.totalCount = 5;
        createView();
    }

    public static /* synthetic */ int access$006(SkipView skipView) {
        int i = skipView.remainingCount - 1;
        skipView.remainingCount = i;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$3(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onClick$4(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowCountDown$0(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowCountDown$1(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setShowCountDown$2(View view) {
        Runnable runnable = this.cancelFun;
        if (runnable != null) {
            runnable.run();
        }
    }

    private void lodTimer() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        int i = this.totalCount;
        if (i <= 0) {
            return;
        }
        this.remainingCount = i * 20;
        this.mTimer = new CountDownTimer(1000 * ((long) this.totalCount), 50L) { // from class: com.fl.saas.common.widget.SkipView.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (SkipView.this.finishFun != null) {
                    SkipView.this.finishFun.run();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                if (SkipView.access$006(SkipView.this) < 0) {
                    if (SkipView.this.finishFun != null) {
                        SkipView.this.finishFun.run();
                        SkipView.this.mTimer.cancel();
                        return;
                    }
                    return;
                }
                if (SkipView.this.circle_skip != null) {
                    SkipView.this.circle_skip.setProgress((int) ((((long) (SkipView.this.totalCount * 1000)) - j) / (((double) SkipView.this.totalCount) * 10.0d)));
                }
            }
        };
    }

    public void cancel() {
        if (this.showCountDown) {
            CountDownTextView countDownTextView = this.tv_skip;
            if (countDownTextView != null) {
                countDownTextView.cancel();
                return;
            }
            return;
        }
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public void createView() {
        View viewInflate = ViewHelper.inflate(getContext(), R.layout.yd_saas_view_spread_skipview);
        this.tv_skip = (CountDownTextView) viewInflate.findViewById(R.id.tv_skip);
        this.circle_skip = (CircularCountDownView) viewInflate.findViewById(R.id.circle_skip);
        this.v_skip = viewInflate.findViewById(R.id.v_skip);
        addView(viewInflate, ViewHelper.getWrapParent());
    }

    public void onClick() {
        View view;
        View.OnClickListener onClickListener;
        if (this.showCountDown) {
            if (this.type == 0) {
                return;
            }
            this.type = 0;
            this.v_skip.setVisibility(8);
            view = this.tv_skip;
            onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.tj8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f44936a.lambda$onClick$3(view2);
                }
            };
        } else {
            if (this.type == 0) {
                return;
            }
            this.type = 0;
            this.v_skip.setVisibility(8);
            view = this.circle_skip;
            onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.vj8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f45369a.lambda$onClick$4(view2);
                }
            };
        }
        view.setOnClickListener(onClickListener);
    }

    public SkipView setCancel(Runnable runnable) {
        this.cancelFun = runnable;
        return this;
    }

    public void setCount(int i) {
        this.totalCount = i;
    }

    public SkipView setFinish(Runnable runnable) {
        this.finishFun = runnable;
        return this;
    }

    public SkipView setOnTick(Function<Integer, String> function) {
        this.tickFun = function;
        return this;
    }

    public void setShowCountDown(boolean z) {
        View view;
        View.OnClickListener onClickListener;
        this.showCountDown = z;
        if (z) {
            this.tv_skip.setVisibility(0);
            this.circle_skip.setVisibility(8);
            this.tv_skip.setOnTick(this.tickFun).setFinish(this.finishFun);
            if (this.type == 0) {
                view = this.tv_skip;
                onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.xj8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f45833a.lambda$setShowCountDown$0(view2);
                    }
                };
                view.setOnClickListener(onClickListener);
            }
        } else {
            this.tv_skip.setVisibility(8);
            this.circle_skip.setVisibility(0);
            if (this.type == 0) {
                view = this.circle_skip;
                onClickListener = new View.OnClickListener() { // from class: com.zj.adlib.zj8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        this.f46278a.lambda$setShowCountDown$1(view2);
                    }
                };
                view.setOnClickListener(onClickListener);
            }
        }
        this.v_skip.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.bk8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f40767a.lambda$setShowCountDown$2(view2);
            }
        });
    }

    public void setValue(int i, int i2) {
        this.type = i;
        this.value = i2;
        if (i == 0 || i2 <= 0) {
            return;
        }
        this.v_skip.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.v_skip.getLayoutParams();
        int iDip2px = DeviceUtil.dip2px((i2 * 40) / 100.0f);
        layoutParams.width = iDip2px;
        layoutParams.height = iDip2px;
        this.v_skip.setLayoutParams(layoutParams);
    }

    public void start() {
        if (this.showCountDown) {
            CountDownTextView countDownTextView = this.tv_skip;
            if (countDownTextView != null) {
                countDownTextView.start();
                return;
            }
            return;
        }
        lodTimer();
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }
}
