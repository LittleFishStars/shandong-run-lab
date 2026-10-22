package com.kc.dw.core.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.motion.widget.Key;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ShakeImageView extends AppCompatImageView {
    private static final String TAG = "ShakeImageView";
    private ObjectAnimator anim;

    public ShakeImageView(Context context) {
        super(context);
    }

    public ShakeImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    public void startAnimation() {
        if (this.anim == null) {
            setPadding(28, 28, 28, 28);
            setImageResource(R.drawable.ssd_shake);
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, Key.ROTATION, 0.0f, 45.0f, -30.0f, 0.0f);
            this.anim = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.anim.setRepeatCount(-1);
        }
        if (this.anim.isStarted()) {
            return;
        }
        this.anim.start();
    }

    public void stopAnimation() {
        ObjectAnimator objectAnimator = this.anim;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            return;
        }
        this.anim.cancel();
        this.anim = null;
    }
}
