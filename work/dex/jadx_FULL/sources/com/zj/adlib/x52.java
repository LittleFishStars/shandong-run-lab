package com.zj.adlib;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.huachenjie.base.view.danmuku.control.dispatcher.IDanMuDispatcher;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class x52 implements IDanMuDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f45746a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Random f20606a = new Random();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextPaint f20605a = ql6.a();

    public x52(Context context) {
        this.f45746a = context;
    }

    @Override // com.huachenjie.base.view.danmuku.control.dispatcher.IDanMuDispatcher
    public synchronized void a(y52 danMuView, t52[] danMuChannels) {
        if (!danMuView.p() && danMuChannels != null) {
            int iD = d(danMuChannels);
            danMuView.s(iD);
            t52 t52Var = danMuChannels[iD];
            if (t52Var == null) {
            } else {
                b(danMuView, t52Var);
            }
        }
    }

    public final void b(y52 danMuView, t52 danMuChannel) {
        int height;
        int width;
        int height2;
        if (danMuView.q()) {
            return;
        }
        int i = 0;
        if (TextUtils.isEmpty(danMuView.f20789a)) {
            height = 0;
            width = 0;
        } else {
            this.f20605a.setTextSize(danMuView.f45959a);
            CharSequence charSequence = danMuView.f20789a;
            TextPaint textPaint = this.f20605a;
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            width = staticLayout.getWidth();
            height = staticLayout.getHeight();
        }
        if (TextUtils.isEmpty(danMuView.f20793b)) {
            height2 = 0;
        } else {
            this.f20605a.setTextSize(danMuView.b);
            CharSequence charSequence2 = danMuView.f20793b;
            TextPaint textPaint2 = this.f20605a;
            StaticLayout staticLayout2 = new StaticLayout(charSequence2, textPaint2, (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            int width2 = staticLayout2.getWidth();
            height2 = staticLayout2.getHeight();
            i = width2;
        }
        danMuView.C((int) (danMuView.m() + danMuView.f20784a + danMuView.f20795c + danMuView.g + danMuView.f20799e + danMuView.j + width + i + danMuView.m + danMuView.n));
        float fMax = Math.max(height, height2) + danMuView.k + danMuView.l;
        if (danMuView.f20786a == null || danMuView.f20797d <= fMax) {
            danMuView.w((int) (danMuView.n() + fMax));
        } else {
            danMuView.w((int) (danMuView.n() + danMuView.f20797d));
        }
        if (danMuView.g() == 1) {
            danMuView.A(danMuChannel.f19708a);
        } else if (danMuView.g() == 2) {
            danMuView.A(-danMuView.l());
        }
        danMuView.x(true);
        danMuView.B(danMuChannel.c);
        danMuView.t(true);
    }

    public void c() {
        this.f45746a = null;
    }

    public final int d(t52[] danMuChannels) {
        return this.f20606a.nextInt(danMuChannels.length);
    }
}
