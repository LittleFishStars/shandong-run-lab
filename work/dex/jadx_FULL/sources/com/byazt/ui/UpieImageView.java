package com.byazt.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.ga.i;
import com.byazt.ga.uj;
import com.byazt.jzl.tt;
import com.byazt.jzl.ve;
import com.byazt.nr.m;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2, 1375})
public class UpieImageView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Bitmap> f29087a;
    public final Context c;
    public c da;
    public int i;
    public Bitmap n;
    public long sl;
    public final Map<String, Integer> sp;
    public ImageView tt;
    public String uj;
    public volatile LottieAnimationView ve;
    public int x;

    public UpieImageView(Context context, com.byazt.cph.c cVar, tt ttVar, c cVar2) {
        super(context);
        this.f29087a = new HashMap();
        this.sp = new HashMap();
        this.x = 0;
        this.i = 0;
        this.c = context;
        this.da = cVar2;
        c(cVar, ttVar, cVar2);
    }

    public static /* synthetic */ int ve(UpieImageView upieImageView) {
        int i = upieImageView.i;
        upieImageView.i = i + 1;
        return i;
    }

    public static /* synthetic */ int x(UpieImageView upieImageView) {
        int i = upieImageView.x;
        upieImageView.x = i + 1;
        return i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.ve == null || this.uj == null) {
            return;
        }
        this.ve.c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.ve != null) {
            this.ve.a();
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            if (this.ve != null) {
                this.ve.setScaleType(scaleType);
                return;
            }
            ImageView imageView = this.tt;
            if (imageView != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final String str) {
        if (TextUtils.isEmpty(str)) {
            new ve(60008, 10002, "广告主图url为空");
        } else {
            com.byazt.cph.tt.c().tt(str, new com.byazt.cph.tt.c<Bitmap>() { // from class: com.byazt.ui.UpieImageView.4
                @Override // com.byazt.cph.tt.c
                public void c(Bitmap bitmap) {
                    UpieImageView.this.n = bitmap;
                    final Bitmap bitmapC = com.byazt.or.tt.c(UpieImageView.this.c, UpieImageView.this.n, 25);
                    com.byazt.qk.tt.tt(new Runnable() { // from class: com.byazt.ui.UpieImageView.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpieImageView.this.ve != null) {
                                UpieImageView.this.ve.invalidate();
                            }
                            UpieImageView.this.tt.setImageBitmap(UpieImageView.this.n);
                            UpieImageView.this.tt.setScaleType(ImageView.ScaleType.FIT_CENTER);
                            if (bitmapC != null) {
                                UpieImageView.this.tt.setBackground(new BitmapDrawable(bitmapC));
                            }
                        }
                    });
                }

                @Override // com.byazt.cph.tt.c
                public void c(int i, String str2) {
                    UpieImageView.x(UpieImageView.this);
                    if (UpieImageView.this.x <= 3) {
                        UpieImageView.this.tt(str);
                    } else {
                        new ve(60008, 10003, "广告主图url加载失败");
                    }
                }
            });
        }
    }

    public synchronized void c(final com.byazt.cph.c cVar, tt ttVar, c cVar2) {
        if (cVar == null) {
            return;
        }
        if (this.ve != null) {
            return;
        }
        this.da = cVar2;
        final String strVe = cVar.ve();
        String strC = cVar.c();
        if (!TextUtils.isEmpty(strC)) {
            this.ve = new LottieAnimationView(this.c);
            this.ve.setVideoStats(ttVar);
            this.ve.setRepeatCount(-1);
            this.ve.setRepeatMode(1);
            this.ve.setClickable(false);
            this.ve.setImageAssetDelegate(new uj() { // from class: com.byazt.ui.UpieImageView.1
                @Override // com.byazt.ga.uj
                public Bitmap c(i iVar) {
                    if (iVar != null) {
                        String strU = iVar.u();
                        if (!TextUtils.isEmpty(strU)) {
                            if (strU.startsWith("${") && strU.endsWith("}")) {
                                strU = com.byazt.qk.c.c(strU, cVar.sp());
                                if (TextUtils.isEmpty(strU)) {
                                    return null;
                                }
                                if (TextUtils.equals(strVe, strU)) {
                                    Bitmap bitmap = UpieImageView.this.n;
                                    if (bitmap != null && (bitmap.getWidth() != iVar.c() || bitmap.getHeight() != iVar.tt())) {
                                        UpieImageView.this.n = Bitmap.createScaledBitmap(bitmap, iVar.c(), iVar.tt(), false);
                                    }
                                    return UpieImageView.this.n;
                                }
                            }
                            Bitmap bitmap2 = (Bitmap) UpieImageView.this.f29087a.get(strU);
                            if (bitmap2 != null) {
                                return bitmap2;
                            }
                            UpieImageView.this.c(strU, iVar.c(), iVar.tt());
                        }
                    }
                    return null;
                }
            });
            this.ve.setTextDelegate(new gt(this.ve) { // from class: com.byazt.ui.UpieImageView.2
                @Override // com.byazt.ga.gt
                public String c(String str) {
                    return com.byazt.qk.c.c(str, cVar.sp());
                }
            });
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(this.c);
        this.tt = imageView;
        addView(imageView, layoutParams);
        if (this.ve != null) {
            addView(this.ve, layoutParams);
        }
        this.sl = SystemClock.elapsedRealtime();
        c(strC);
        tt(strVe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            c(10000, "lottieJsonUrl为空");
        } else {
            com.byazt.qk.tt.ve(new Runnable() { // from class: com.byazt.ui.UpieImageView.3
                @Override // java.lang.Runnable
                public void run() {
                    String strC = com.byazt.cph.tt.c().c(str);
                    if (TextUtils.isEmpty(strC)) {
                        com.byazt.cph.tt.c().c(str, new com.byazt.cph.tt.c<String>() { // from class: com.byazt.ui.UpieImageView.3.1
                            @Override // com.byazt.cph.tt.c
                            public void c(String str2) {
                                m.c("UpieImageView", "--==-- lottie jsonStr ok");
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                UpieImageView.this.c(str2, str);
                            }

                            @Override // com.byazt.cph.tt.c
                            public void c(int i, String str2) {
                                m.c("UpieImageView", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    UpieImageView.this.c(i, str2);
                                    return;
                                }
                                UpieImageView.ve(UpieImageView.this);
                                if (UpieImageView.this.i > 3) {
                                    UpieImageView.this.c(i, str2);
                                } else {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    UpieImageView.this.c(str);
                                }
                            }
                        });
                    } else {
                        UpieImageView.this.c(strC, str);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final int i, final int i2) {
        Integer num = this.sp.get(str);
        if (num == null || num.intValue() != 1) {
            this.sp.put(str, 1);
            this.ve.c(str, new com.byazt.rs.i() { // from class: com.byazt.ui.UpieImageView.5
                @Override // com.byazt.rs.i
                public void c(Bitmap bitmap) {
                    UpieImageView.this.c(bitmap, str, i, i2);
                }

                @Override // com.byazt.rs.i
                public void c() {
                    com.byazt.cph.tt.c().c(UpieImageView.this.c, str, new com.byazt.cph.tt.c<Bitmap>() { // from class: com.byazt.ui.UpieImageView.5.1
                        @Override // com.byazt.cph.tt.c
                        public void c(Bitmap bitmap) {
                            AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                            UpieImageView.this.c(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.cph.tt.c
                        public void c(int i3, String str2) {
                            UpieImageView.this.sp.put(str, 2);
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
            this.f29087a.put(str, bitmap);
            com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.ui.UpieImageView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (UpieImageView.this.ve != null) {
                        UpieImageView.this.ve.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        c cVar = this.da;
        if (cVar != null) {
            cVar.c(i, str);
        }
        com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.ui.UpieImageView.7
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.ve != null) {
                    UpieImageView upieImageView = UpieImageView.this;
                    upieImageView.removeView(upieImageView.ve);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        if (this.da != null) {
            HashMap map = new HashMap();
            map.put("duration", Long.valueOf(j - this.sl));
            this.da.c(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str, final String str2) {
        this.uj = str;
        com.byazt.qk.tt.c(new Runnable() { // from class: com.byazt.ui.UpieImageView.8
            @Override // java.lang.Runnable
            public void run() {
                if (UpieImageView.this.ve != null) {
                    UpieImageView.this.ve.c(str, str2);
                    UpieImageView.this.ve.c(new Animator.AnimatorListener() { // from class: com.byazt.ui.UpieImageView.8.1
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
                            UpieImageView.this.ve.tt(this);
                            UpieImageView.this.c(SystemClock.elapsedRealtime());
                        }
                    });
                    UpieImageView.this.ve.c();
                }
            }
        });
    }
}
