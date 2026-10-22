package com.huachenjie.base.view.danmuku.model.painter;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.zj.adlib.ql6;
import com.zj.adlib.t52;
import com.zj.adlib.y52;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class a extends IDanMuPainter {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f7305a;
    public boolean b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static TextPaint f7304a = ql6.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static RectF f32979a = new RectF();

    @Override // com.huachenjie.base.view.danmuku.model.painter.IDanMuPainter
    public void a(Canvas canvas, y52 danMuView, t52 danMuChannel) {
        if (((int) danMuView.k()) == 0) {
            danMuView.t(false);
        }
        f(danMuView, danMuChannel);
        if (this.b) {
            return;
        }
        if (danMuView.j() == 50 && this.f7305a) {
            return;
        }
        draw(canvas, danMuView, danMuChannel);
    }

    @Override // com.huachenjie.base.view.danmuku.model.painter.IDanMuPainter
    public void b(boolean hideAll) {
        this.b = hideAll;
    }

    @Override // com.huachenjie.base.view.danmuku.model.painter.IDanMuPainter
    public void c(boolean hide) {
        this.f7305a = hide;
    }

    @Override // com.huachenjie.base.view.danmuku.model.painter.IDanMuPainter
    public void d() {
    }

    public void draw(Canvas canvas, y52 danMuView, t52 danMuChannel) {
        if (danMuView.f20787a != null) {
            drawTextBackground(danMuView, canvas, danMuChannel);
        }
        if (danMuView.f20786a != null) {
            drawAvatar(danMuView, canvas, danMuChannel);
        }
        if (danMuView.f20790a) {
            drawAvatarStrokes(danMuView, canvas, danMuChannel);
        }
        if (danMuView.f20792b != null) {
            drawLevel(danMuView, canvas, danMuChannel);
        }
        int iDrawLevelText = !TextUtils.isEmpty(danMuView.f20789a) ? drawLevelText(danMuView, canvas, danMuChannel) : 0;
        if (TextUtils.isEmpty(danMuView.f20793b)) {
            return;
        }
        drawText(danMuView, canvas, danMuChannel, iDrawLevelText);
    }

    public void drawAvatar(y52 danMuView, Canvas canvas, t52 danMuChannel) {
        float fN = (((int) danMuView.n()) + (danMuChannel.f19710b / 2)) - (danMuView.f20797d / 2);
        float fM = danMuView.m() + danMuView.f20784a;
        f32979a.set((int) fM, fN, (int) (fM + danMuView.f20795c), danMuView.f20797d + fN);
        canvas.drawBitmap(danMuView.f20786a, (Rect) null, f32979a, f7304a);
    }

    public void drawAvatarStrokes(y52 danMuView, Canvas canvas, t52 danMuChannel) {
        float fM = danMuView.m() + danMuView.f20784a + (danMuView.f20795c / 2);
        float fN = danMuView.n() + (danMuChannel.f19710b / 2);
        f7304a.setColor(-1);
        f7304a.setStyle(Paint.Style.STROKE);
        canvas.drawCircle((int) fM, (int) fN, danMuView.f20797d / 2, f7304a);
    }

    public void drawLevel(y52 danMuView, Canvas canvas, t52 danMuChannel) {
        float fN = (((int) danMuView.n()) + (danMuChannel.f19710b / 2)) - (danMuView.f / 2);
        float fM = danMuView.m() + danMuView.f20784a + danMuView.f20795c + danMuView.m + danMuView.g;
        f32979a.set((int) fM, fN, (int) (fM + danMuView.f20799e), danMuView.f + fN);
        canvas.drawBitmap(danMuView.f20792b, (Rect) null, f32979a, f7304a);
    }

    public int drawLevelText(y52 danMuView, Canvas canvas, t52 danMuChannel) {
        if (TextUtils.isEmpty(danMuView.f20789a)) {
            return 0;
        }
        f7304a.setTextSize(danMuView.f45959a);
        f7304a.setColor(danMuView.h);
        f7304a.setStyle(Paint.Style.FILL);
        CharSequence charSequence = danMuView.f20789a;
        TextPaint textPaint = f7304a;
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        float fM = danMuView.m() + danMuView.f20784a + danMuView.f20795c + danMuView.m + danMuView.g + danMuView.f20799e;
        float fN = (((int) danMuView.n()) + (danMuChannel.f19710b / 2)) - (staticLayout.getHeight() / 2);
        canvas.save();
        canvas.translate((int) fM, fN);
        staticLayout.draw(canvas);
        canvas.restore();
        return staticLayout.getWidth();
    }

    public void drawText(y52 danMuView, Canvas canvas, t52 danMuChannel, int levelTextWidth) {
        if (TextUtils.isEmpty(danMuView.f20793b)) {
            return;
        }
        f7304a.setTextSize(danMuView.b);
        f7304a.setColor(danMuView.i);
        f7304a.setStyle(Paint.Style.FILL);
        CharSequence charSequence = danMuView.f20793b;
        TextPaint textPaint = f7304a;
        StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        float fM = danMuView.m() + danMuView.f20784a + danMuView.f20795c + danMuView.m + danMuView.g + danMuView.f20799e + levelTextWidth + danMuView.j;
        float fN = (((int) danMuView.n()) + (danMuChannel.f19710b / 2)) - (staticLayout.getHeight() / 2);
        canvas.save();
        canvas.translate((int) fM, fN);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    public void drawTextBackground(y52 danMuView, Canvas canvas, t52 danMuChannel) {
        int height;
        int width;
        int width2;
        int height2 = 0;
        if (TextUtils.isEmpty(danMuView.f20793b)) {
            height = 0;
            width = 0;
        } else {
            f7304a.setTextSize(danMuView.b);
            CharSequence charSequence = danMuView.f20793b;
            TextPaint textPaint = f7304a;
            StaticLayout staticLayout = new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            width = staticLayout.getWidth();
            height = staticLayout.getHeight();
        }
        if (TextUtils.isEmpty(danMuView.f20789a)) {
            width2 = 0;
        } else {
            f7304a.setTextSize(danMuView.f45959a);
            CharSequence charSequence2 = danMuView.f20789a;
            TextPaint textPaint2 = f7304a;
            StaticLayout staticLayout2 = new StaticLayout(charSequence2, textPaint2, (int) Math.ceil(Layout.getDesiredWidth(charSequence2, textPaint2)), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            width2 = staticLayout2.getWidth();
            height2 = staticLayout2.getHeight();
        }
        int iMax = Math.max(height, height2) + danMuView.k + danMuView.l;
        float fN = danMuView.n() + ((danMuChannel.f19710b - iMax) / 2);
        float fM = danMuView.m() + danMuView.f20784a + danMuView.f20795c;
        danMuView.f20787a.setBounds(new Rect((int) fM, (int) fN, (int) (fM + danMuView.m + danMuView.g + danMuView.f20799e + danMuView.j + width2 + width + danMuView.n), (int) (fN + iMax)));
        danMuView.f20787a.draw(canvas);
    }

    @Override // com.huachenjie.base.view.danmuku.model.painter.IDanMuPainter
    public void e(int alpha) {
    }

    public final void f(y52 danMuView, t52 danMuChannel) {
        if (danMuView.r()) {
            layout(danMuView, danMuChannel);
        }
    }

    public void layout(y52 danMuView, t52 danMuChannel) {
    }
}
