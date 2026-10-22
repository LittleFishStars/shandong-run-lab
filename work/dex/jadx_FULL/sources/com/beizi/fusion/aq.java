package com.beizi.fusion;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class aq implements hf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hf.b f27020a = new hf.b();

    @Override // com.beizi.fusion.hf
    public void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f27020a.o();
            this.f27020a.b(motionEvent.getX(), motionEvent.getY());
            this.f27020a.a(motionEvent.getRawX(), motionEvent.getRawY());
        } else {
            if (action != 1) {
                return;
            }
            this.f27020a.p();
            this.f27020a.d(motionEvent.getX(), motionEvent.getY());
            this.f27020a.c(motionEvent.getRawX(), motionEvent.getRawY());
        }
    }

    @Override // com.beizi.fusion.hf
    public void a(View view, int i) {
        if (i == dd.a.LANDING_PAGE_INTERACTIVE_TRIGGER.getEventCode() || i == dd.a.INVOKE_INTERACTIVE_TRIGGER.getEventCode()) {
            this.f27020a.o();
            int[] iArrA = f7.a(view);
            this.f27020a.b(iArrA[0], iArrA[1]);
            this.f27020a.a(iArrA[0], iArrA[1]);
            this.f27020a.d(iArrA[0], iArrA[1]);
            this.f27020a.c(iArrA[0], iArrA[1]);
            this.f27020a.p();
        }
    }

    @Override // com.beizi.fusion.hf
    public void a(View view) {
        this.f27020a.a(view);
    }

    @Override // com.beizi.fusion.hf
    public void a(View view, View view2, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f27020a.o();
            float[] fArrA = a(view, view2, new float[]{motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY()});
            if (fArrA == null || fArrA.length != 4) {
                return;
            }
            this.f27020a.b(fArrA[0], fArrA[1]);
            this.f27020a.a(fArrA[2], fArrA[3]);
            return;
        }
        if (action != 1) {
            return;
        }
        this.f27020a.p();
        float[] fArrA2 = a(view, view2, new float[]{motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY()});
        if (fArrA2 == null || fArrA2.length != 4) {
            return;
        }
        this.f27020a.b(fArrA2[0], fArrA2[1]);
        this.f27020a.a(fArrA2[2], fArrA2[3]);
    }

    private float[] a(View view, View view2, float[] fArr) {
        if (view == null || view2 == null || fArr == null || fArr.length != 4) {
            return fArr;
        }
        view.getLocationOnScreen(new int[2]);
        int width = view.getWidth();
        int height = view.getHeight();
        float f = (int) ((((double) fArr[0]) * 100.0d) / ((double) width));
        float f2 = (int) ((((double) fArr[1]) * 100.0d) / ((double) height));
        int width2 = view2.getWidth();
        int height2 = view2.getHeight();
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        float f3 = (width2 * f) / 100.0f;
        float f4 = (height2 * f2) / 100.0f;
        return new float[]{f3, f4, iArr[0] + f3, iArr[1] + f4};
    }

    @Override // com.beizi.fusion.hf
    public hf.b a() {
        return this.f27020a;
    }
}
