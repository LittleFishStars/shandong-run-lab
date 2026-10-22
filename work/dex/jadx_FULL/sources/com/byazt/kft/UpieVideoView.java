package com.byazt.kft;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.ga.i;
import com.byazt.ga.rl;
import com.byazt.ga.uj;
import com.byazt.jr.SSRenderTextureView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 1366})
public class UpieVideoView extends FrameLayout implements com.byazt.jr.tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f28726a;
    public final com.byazt.jr.tt c;
    public final Handler n;
    public com.byazt.jr.tt.c sp;
    public final LottieAnimationView tt;
    public final Map<String, Integer> uj;
    public final Map<String, Bitmap> ve;

    public UpieVideoView(final Context context, final com.byazt.cph.c cVar) {
        super(context);
        this.ve = new HashMap();
        this.uj = new HashMap();
        this.n = new Handler(Looper.getMainLooper());
        this.f28726a = new Runnable() { // from class: com.byazt.kft.UpieVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (UpieVideoView.this.tt != null && UpieVideoView.this.tt.n()) {
                    UpieVideoView.this.tt.invalidate();
                }
                UpieVideoView.this.n.postDelayed(UpieVideoView.this.f28726a, 40L);
            }
        };
        SSRenderTextureView sSRenderTextureView = new SSRenderTextureView(context);
        this.c = sSRenderTextureView;
        addView(sSRenderTextureView.getView());
        sSRenderTextureView.getView().setTranslationX(2.1474836E9f);
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        this.tt = lottieAnimationView;
        lottieAnimationView.setImageAssetDelegate(new uj() { // from class: com.byazt.kft.UpieVideoView.1
            /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
            
                if (r1.startsWith("http") != false) goto L17;
             */
            @Override // com.byazt.ga.uj
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public Bitmap c(i iVar) {
                if (iVar != null) {
                    String strU = iVar.u();
                    if (!TextUtils.isEmpty(strU)) {
                        if (strU.startsWith("${") && strU.endsWith("}")) {
                            com.byazt.cph.c cVar2 = cVar;
                            if (cVar2 != null) {
                                strU = com.byazt.qk.c.c(strU, cVar2.sp());
                                if (!TextUtils.isEmpty(strU)) {
                                }
                            }
                            return null;
                        }
                        Bitmap bitmap = (Bitmap) UpieVideoView.this.ve.get(strU);
                        if (bitmap != null) {
                            return bitmap;
                        }
                        UpieVideoView.this.c(context, strU, iVar.c(), iVar.tt());
                    }
                }
                return null;
            }
        });
        lottieAnimationView.setTextDelegate(new gt(lottieAnimationView) { // from class: com.byazt.kft.UpieVideoView.2
            @Override // com.byazt.ga.gt
            public String c(String str) {
                com.byazt.cph.c cVar2 = cVar;
                return com.byazt.qk.c.c(str, cVar2 != null ? cVar2.sp() : null);
            }
        });
        lottieAnimationView.setViewDelegate(new rl() { // from class: com.byazt.kft.UpieVideoView.3
            @Override // com.byazt.ga.rl
            public View c(String str, Map<String, Object> map) {
                if ("videoview:".equals(str)) {
                    return UpieVideoView.this.c.getView();
                }
                return null;
            }
        });
        lottieAnimationView.setRepeatMode(1);
        lottieAnimationView.setRepeatCount(-1);
        lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        lottieAnimationView.setClickable(false);
        lottieAnimationView.c(new Animator.AnimatorListener() { // from class: com.byazt.kft.UpieVideoView.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (UpieVideoView.this.tt != null) {
                    UpieVideoView.this.tt.tt(this);
                }
                UpieVideoView.this.uj();
            }
        });
        lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.kft.UpieVideoView.5
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (UpieVideoView.this.tt == view) {
                    UpieVideoView.this.ve();
                }
            }
        });
        addView(lottieAnimationView, new FrameLayout.LayoutParams(-1, -2));
    }

    public SurfaceHolder getHolder() {
        return null;
    }

    public LottieAnimationView getLottieAnimationView() {
        return this.tt;
    }

    @Override // com.byazt.jr.tt
    public View getView() {
        return this;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        LottieAnimationView lottieAnimationView = this.tt;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(com.byazt.jr.tt.c cVar) {
        this.sp = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        ve();
        if (this.tt != null) {
            this.n.postDelayed(this.f28726a, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        this.n.removeCallbacksAndMessages(null);
    }

    public void tt() {
        com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.UpieVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.ve();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final Context context, final String str, final int i, final int i2) {
        Integer num = this.uj.get(str);
        if (num == null || num.intValue() != 1) {
            this.uj.put(str, 1);
            this.tt.c(str, new com.byazt.rs.i() { // from class: com.byazt.kft.UpieVideoView.7
                @Override // com.byazt.rs.i
                public void c(Bitmap bitmap) {
                    UpieVideoView.this.c(bitmap, str, i, i2);
                }

                @Override // com.byazt.rs.i
                public void c() {
                    com.byazt.cph.tt.c().c(context, str, new com.byazt.cph.tt.c<Bitmap>() { // from class: com.byazt.kft.UpieVideoView.7.1
                        @Override // com.byazt.cph.tt.c
                        public void c(Bitmap bitmap) {
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            UpieVideoView.this.c(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.cph.tt.c
                        public void c(int i3, String str2) {
                            UpieVideoView.this.uj.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            }
            this.ve.put(str, bitmap);
        }
    }

    @Override // com.byazt.jr.tt
    public void c(com.byazt.jr.c cVar) {
        com.byazt.jr.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(cVar);
        }
    }

    @Override // com.byazt.jr.tt
    public void c(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public void c() {
        com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.kft.UpieVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                UpieVideoView.this.uj();
            }
        });
    }
}
