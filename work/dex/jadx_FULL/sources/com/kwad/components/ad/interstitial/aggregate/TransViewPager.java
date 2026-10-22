package com.kwad.components.ad.interstitial.aggregate;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.widget.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class TransViewPager extends f {
    private float lY;

    @SlideType
    private int lZ;
    private Map<Integer, com.kwad.components.ad.interstitial.h.c> map;

    public TransViewPager(@NonNull Context context) {
        this(context, null);
    }

    private void a(View view, View view2, float f) {
        if (this.lZ == 0 && f != 0.0f) {
            float f2 = this.lY;
            if (f2 != 0.0f) {
                if (f > f2) {
                    this.lZ = 1;
                } else {
                    this.lZ = 2;
                }
            }
        }
        if (this.lZ == 1 && view2 != null) {
            if (f > 0.5d || f <= 0.0f) {
                view2.setTranslationX((1.0f - f) * 240.0f);
            } else {
                view2.setTranslationX(240.0f * f);
            }
        }
        if (this.lZ == 2 && view != null) {
            if (f > 0.5d || f < 0.0f) {
                view.setTranslationX((1.0f - f) * (-240.0f));
            } else {
                view.setTranslationX((-240.0f) * f);
            }
        }
        this.lY = f;
        if (f == 0.0f) {
            this.lZ = 0;
        }
    }

    public final com.kwad.components.ad.interstitial.h.c U(int i) {
        return this.map.get(Integer.valueOf(i));
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        a(U(i), U(i + 1), f);
        super.onPageScrolled(i, f, i2);
    }

    public TransViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.map = new HashMap();
        this.lZ = 0;
    }

    public final void a(int i, com.kwad.components.ad.interstitial.h.c cVar) {
        this.map.put(Integer.valueOf(i), cVar);
    }
}
