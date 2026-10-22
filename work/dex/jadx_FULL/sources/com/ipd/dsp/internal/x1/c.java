package com.ipd.dsp.internal.x1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends FrameLayout implements b {
    public final a f;

    public c(@NonNull Context context) {
        super(context);
        this.f = new a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f.a(getWidth(), getHeight());
            this.f.a(motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY());
        } else if (action == 1) {
            this.f.b(motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.ipd.dsp.internal.x1.b
    public Map<String, Object> getTouchCoordsMap() {
        return this.f.a();
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new a();
    }

    public c(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new a();
    }
}
