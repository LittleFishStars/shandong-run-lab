package com.byazt.oj;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.camera.video.AudioStats;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 20})
public class c extends uj {
    public c(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        float fRh = this.tt.rh() / 100.0f;
        float fMy = this.tt.my() / 100.0f;
        if ("reverse".equals(this.tt.m()) && this.tt.yp() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            fMy = fRh;
            fRh = fMy;
        }
        this.ve.setAlpha(fRh);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "alpha", fRh, fMy).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        return arrayList;
    }
}
