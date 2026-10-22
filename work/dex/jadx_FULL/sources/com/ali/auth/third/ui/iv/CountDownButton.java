package com.ali.auth.third.ui.iv;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.Button;
import com.ali.auth.third.ui.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CountDownButton extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f23528a;
    private boolean b;
    protected CountListener mCountListener;
    protected int mGetCodeTitleRes;
    protected int mTickTitleRes;

    public interface CountListener {
        void onTick(long j);
    }

    public class a extends CountDownTimer {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Context context;
            int i;
            CountDownButton countDownButton = CountDownButton.this;
            if (countDownButton.mGetCodeTitleRes != 0) {
                context = countDownButton.getContext();
                i = CountDownButton.this.mGetCodeTitleRes;
            } else {
                context = countDownButton.getContext();
                i = R.string.ali_auth_verification_reGetCode;
            }
            countDownButton.setText(context.getString(i));
            CountDownButton.this.setEnabled(true);
            CountDownButton.this.b = false;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            String string;
            long j2 = (j / 1000) + 1;
            CountDownButton countDownButton = CountDownButton.this;
            if (countDownButton.mTickTitleRes != 0) {
                string = countDownButton.getResources().getString(CountDownButton.this.mTickTitleRes, String.valueOf(j2));
            } else {
                string = String.valueOf(j2) + CountDownButton.this.getContext().getString(R.string.ali_auth_verification_reGetCode);
            }
            countDownButton.setText(string);
            CountDownButton.this.setEnabled(false);
            CountListener countListener = CountDownButton.this.mCountListener;
            if (countListener != null) {
                countListener.onTick(j);
            }
        }
    }

    public CountDownButton(Context context) {
        super(context);
        this.b = false;
    }

    public CountDownButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    public void cancelCountDown() {
        a aVar = this.f23528a;
        if (aVar != null) {
            aVar.cancel();
        }
        this.b = false;
    }

    public boolean isCountDowning() {
        return this.b;
    }

    public void setGetCodeTitle(int i) {
        this.mGetCodeTitleRes = i;
    }

    public void setTickListener(CountListener countListener) {
        this.mCountListener = countListener;
    }

    public void setTickTitleRes(int i) {
        this.mTickTitleRes = i;
    }

    public void startCountDown(long j, long j2) {
        a aVar = new a(j, j2);
        this.f23528a = aVar;
        aVar.start();
        this.b = true;
    }
}
