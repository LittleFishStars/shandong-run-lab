package androidx.constraintlayout.motion.widget;

import android.graphics.Canvas;
import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface MotionHelperInterface extends Animatable, MotionLayout.TransitionListener {
    boolean isDecorator();

    boolean isUseOnHide();

    boolean isUsedOnShow();

    void onFinishedMotionScene(MotionLayout motionLayout);

    void onPostDraw(Canvas canvas);

    void onPreDraw(Canvas canvas);

    void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> controllerMap);
}
