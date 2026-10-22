package com.kwad.components.core.video;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.PhotoInfo;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DetailVideoView extends KSFrameLayout implements View.OnClickListener {
    public com.kwad.components.core.page.widget.b amY;
    private b amZ;
    private SurfaceTexture ana;
    private TextView anb;
    public Surface anc;
    private a and;
    private PhotoInfo.VideoInfo ane;
    private boolean anf;
    private final RectF ang;
    private int anh;
    private int ani;
    private long anj;

    @NonNull
    private final d ank;
    private Matrix mMatrix;

    public interface a {
        void onClickRootView();

        void onClickVideoView();
    }

    public DetailVideoView(Context context) {
        super(context);
        this.anf = false;
        this.ang = new RectF();
        this.anh = 0;
        this.ani = 0;
        this.anj = 0L;
        this.ank = new d();
        B(context);
    }

    private void B(Context context) {
        this.mMatrix = new Matrix();
        this.amY = new com.kwad.components.core.page.widget.b(context);
        addView(this.amY, 0, new FrameLayout.LayoutParams(-1, -1, 17));
        xu();
    }

    private void xu() {
        com.kwad.components.core.page.widget.b bVar;
        if (this.anf && (bVar = this.amY) != null) {
            bVar.setOpaque(false);
        }
        this.amY.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.kwad.components.core.video.DetailVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (DetailVideoView.this.ana == surfaceTexture) {
                    return;
                }
                DetailVideoView.this.ana = surfaceTexture;
                DetailVideoView.this.xv();
                DetailVideoView.this.anc = new Surface(surfaceTexture);
                if (DetailVideoView.this.amZ != null) {
                    DetailVideoView.this.amZ.setSurface(DetailVideoView.this.anc);
                }
                try {
                    if (DetailVideoView.this.amZ == null || DetailVideoView.this.amZ.isPlaying()) {
                        return;
                    }
                    DetailVideoView.this.amZ.seekTo(DetailVideoView.this.anj);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                try {
                    if (DetailVideoView.this.amZ == null) {
                        return false;
                    }
                    DetailVideoView detailVideoView = DetailVideoView.this;
                    detailVideoView.anj = detailVideoView.amZ.getCurrentPosition();
                    return false;
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return false;
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        Surface surface = this.anc;
        if (surface != null) {
            try {
                surface.release();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
            }
            this.anc = null;
        }
    }

    public final void adaptVideoSize(int i, int i2) {
        c cVar;
        if (this.amY == null) {
            com.kwad.sdk.core.d.c.w("DetailVideoView", "adaptVideoSize mTextureView is null");
            return;
        }
        this.ani = i2;
        this.anh = i;
        if (this.ank.xw()) {
            int iXx = this.ank.xx();
            if (iXx != 1) {
                cVar = iXx != 2 ? null : new VideoAdapters.b();
            } else {
                cVar = new VideoAdapters.c();
            }
            if (cVar != null) {
                com.kwad.components.core.page.widget.b bVar = this.amY;
                cVar.a(bVar, (View) bVar.getParent(), i, i2);
                return;
            }
            return;
        }
        if (this.ank.xC()) {
            com.kwad.sdk.c.a.a.K(this.amY);
            return;
        }
        if (this.ank.xy()) {
            com.kwad.sdk.c.a.a.e(this.amY, i, i2);
            return;
        }
        if (this.ank.xA()) {
            com.kwad.sdk.c.a.a.f(this.amY, i, i2);
            return;
        }
        if (this.ank.xz()) {
            com.kwad.sdk.c.a.a.d(this.amY, i, i2);
            return;
        }
        if (this.ank.xB()) {
            a(this.amY, i, i2);
            return;
        }
        View view = (View) this.amY.getParent();
        if (view == null) {
            return;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        PhotoInfo.VideoInfo videoInfo = this.ane;
        if (videoInfo == null || !com.kwad.sdk.core.response.helper.h.a(this.mMatrix, width, height, videoInfo)) {
            ViewGroup.LayoutParams layoutParams = this.amY.getLayoutParams();
            layoutParams.width = width;
            layoutParams.height = (int) ((i2 / (i * 1.0f)) * width);
            this.mMatrix.reset();
            this.amY.setTransform(this.mMatrix);
            this.amY.setLayoutParams(layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.amY.getLayoutParams();
            layoutParams2.width = -1;
            layoutParams2.height = -1;
            this.amY.setTransform(this.mMatrix);
            this.amY.setLayoutParams(layoutParams2);
        }
        this.ang.set(this.amY.getLeft(), this.amY.getTop(), this.amY.getRight(), this.amY.getBottom());
    }

    public final void ca(int i) {
        if (com.kwad.components.core.a.pe.booleanValue()) {
            if (this.anb == null) {
                if (getContext() == null) {
                    return;
                } else {
                    this.anb = new TextView(getContext());
                }
            }
            removeView(this.anb);
            this.anb.setText(String.valueOf(i));
            this.anb.setTextColor(-65536);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 53;
            addView(this.anb, getChildCount(), layoutParams);
        }
    }

    @Deprecated
    public final void fixWidth(boolean z) {
        this.ank.bh(z);
    }

    public final void g(boolean z, int i) {
        this.ank.setAd(true);
        this.ank.cb(i);
    }

    public int getTextureViewGravity() {
        com.kwad.components.core.page.widget.b bVar = this.amY;
        if (bVar == null) {
            return 17;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            return ((FrameLayout.LayoutParams) layoutParams).gravity;
        }
        return 17;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.amY) {
            a aVar = this.and;
            if (aVar != null) {
                aVar.onClickVideoView();
                return;
            }
            return;
        }
        a aVar2 = this.and;
        if (aVar2 != null) {
            aVar2.onClickRootView();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xv();
        SurfaceTexture surfaceTexture = this.ana;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.ana = null;
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        int i6 = this.anh;
        if (i6 <= 0 || (i5 = this.ani) <= 0) {
            return;
        }
        adaptVideoSize(i6, i5);
    }

    @Deprecated
    public void setAd(boolean z) {
        this.ank.setAd(z);
    }

    public void setClickListener(a aVar) {
        this.and = aVar;
        setOnClickListener(this);
    }

    @Deprecated
    public void setFillXY(boolean z) {
        this.ank.setFillXY(z);
    }

    @Deprecated
    public void setForce(boolean z) {
        this.ank.setForce(z);
    }

    public void setHorizontalVideo(boolean z) {
        this.ank.setHorizontalVideo(z);
    }

    public void setIsAlphaVideoView(boolean z) {
        com.kwad.components.core.page.widget.b bVar;
        this.anf = z;
        if (!z || (bVar = this.amY) == null) {
            return;
        }
        bVar.setOpaque(false);
    }

    public void setMediaPlayer(b bVar) {
        this.amZ = bVar;
        Surface surface = this.anc;
        if (surface == null || bVar == null) {
            return;
        }
        bVar.setSurface(surface);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public void setRadius(float f) {
        com.kwad.components.core.widget.h.f(this, f);
    }

    public void setVideoInfo(PhotoInfo.VideoInfo videoInfo) {
        this.ane = videoInfo;
    }

    public final void updateTextureViewGravity(int i) {
        com.kwad.components.core.page.widget.b bVar = this.amY;
        if (bVar == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = bVar.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            this.amY.requestLayout();
        }
    }

    private void a(View view, long j, long j2) {
        View view2;
        if (view == null || j == 0 || j2 == 0 || (view2 = (View) view.getParent()) == null) {
            return;
        }
        int width = view2.getWidth();
        int height = view2.getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        view.getLayoutParams();
        float f = j / j2;
        float f2 = height * f;
        float f3 = width;
        if (f2 > f3) {
            height = (int) (f3 / f);
        } else {
            width = (int) f2;
        }
        if (width == 0 || height == 0) {
            height = -1;
            width = -1;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.amY.setLayoutParams(layoutParams);
    }

    public DetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anf = false;
        this.ang = new RectF();
        this.anh = 0;
        this.ani = 0;
        this.anj = 0L;
        this.ank = new d();
        B(context);
    }

    public final ValueAnimator a(AdTemplate adTemplate, int i, final ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        float height = getHeight();
        final float width = height / getWidth();
        final boolean Z = com.kwad.sdk.core.response.helper.a.Z(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt((int) height, i);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.core.video.DetailVideoView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (Z) {
                    int i2 = (int) (iIntValue / width);
                    ViewGroup.LayoutParams layoutParams2 = layoutParams;
                    if (layoutParams2 != null) {
                        layoutParams2.height = iIntValue;
                        layoutParams2.width = i2;
                        DetailVideoView.this.setLayoutParams(layoutParams2);
                    }
                    DetailVideoView.this.adaptVideoSize(i2, iIntValue);
                } else {
                    ViewGroup.LayoutParams layoutParams3 = layoutParams;
                    if (layoutParams3 != null) {
                        layoutParams3.height = iIntValue;
                        layoutParams3.width = -1;
                        DetailVideoView.this.setLayoutParams(layoutParams3);
                    }
                }
                ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = animatorUpdateListener;
                if (animatorUpdateListener2 != null) {
                    animatorUpdateListener2.onAnimationUpdate(valueAnimator);
                }
            }
        });
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        valueAnimatorOfInt.setDuration(500L);
        valueAnimatorOfInt.setInterpolator(interpolatorCreate);
        return valueAnimatorOfInt;
    }
}
