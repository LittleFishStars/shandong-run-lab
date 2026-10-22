package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.Cue;
import com.zj.adlib.dv8;
import com.zj.adlib.gv8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class CanvasSubtitleOutput extends View implements SubtitleView.Output {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f31055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CaptionStyleCompat f4725a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<dv8> f4726a;
    public float b;
    public List<Cue> c;

    public CanvasSubtitleOutput(Context context) {
        this(context, null);
    }

    public static Cue a(Cue cue) {
        Cue.b bVarB = cue.b().w(-3.4028235E38f).x(Integer.MIN_VALUE).B(null);
        if (cue.K == 0) {
            bVarB.t(1.0f - cue.f4519a, 0);
        } else {
            bVarB.t((-cue.f4519a) - 1.0f, 1);
        }
        int i = cue.L;
        if (i == 0) {
            bVarB.u(2);
        } else if (i == 2) {
            bVarB.u(0);
        }
        return bVarB.a();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        List<Cue> list = this.c;
        if (list.isEmpty()) {
            return;
        }
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int paddingBottom = height - getPaddingBottom();
        if (paddingBottom <= paddingTop || width <= paddingLeft) {
            return;
        }
        int i = paddingBottom - paddingTop;
        float fH = gv8.h(this.K, this.f31055a, height, i);
        if (fH <= 0.0f) {
            return;
        }
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            Cue cueA = list.get(i2);
            if (cueA.P != Integer.MIN_VALUE) {
                cueA = a(cueA);
            }
            Cue cue = cueA;
            int i3 = paddingBottom;
            this.f4726a.get(i2).b(cue, this.f4725a, fH, gv8.h(cue.O, cue.e, height, i), this.b, canvas, paddingLeft, paddingTop, width, i3);
            i2++;
            size = size;
            i = i;
            paddingBottom = i3;
            width = width;
        }
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.Output
    public void update(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2) {
        this.c = list;
        this.f4725a = captionStyleCompat;
        this.f31055a = f;
        this.K = i;
        this.b = f2;
        while (this.f4726a.size() < list.size()) {
            this.f4726a.add(new dv8(getContext()));
        }
        invalidate();
    }

    public CanvasSubtitleOutput(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4726a = new ArrayList();
        this.c = Collections.emptyList();
        this.K = 0;
        this.f31055a = 0.0533f;
        this.f4725a = CaptionStyleCompat.f31056a;
        this.b = 0.08f;
    }
}
