package com.facebook.drawee.interfaces;

import android.graphics.drawable.Animatable;
import android.view.MotionEvent;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DraweeController {
    void a();

    @Nullable
    DraweeHierarchy c();

    Animatable d();

    void e(@Nullable DraweeHierarchy draweeHierarchy);

    void onDetach();

    boolean onTouchEvent(MotionEvent motionEvent);
}
