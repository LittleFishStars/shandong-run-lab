package com.byazt.ga;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RawRes;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE})
public class LottieAnimationView extends ImageView {
    public static final String c = "LottieAnimationView";
    public static final da<Throwable> tt = new da<Throwable>() { // from class: com.byazt.ga.LottieAnimationView.1
        @Override // com.byazt.ga.da
        public void c(Throwable th) {
            if (com.byazt.kk.da.c(th)) {
                com.byazt.kk.a.c("Unable to load composition.", th);
            } else {
                com.byazt.kk.a.c("Unable to parse composition:", th);
            }
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28549a;
    public JSONArray aw;
    public final Runnable bm;
    public int bx;
    public List<com.byazt.zk.t> cu;
    public final Runnable d;
    public boolean da;
    public com.byazt.zk.a eo;
    public com.byazt.qm.tt gr;
    public com.byazt.zk.ve gt;
    public final com.byazt.qm.c gu;
    public volatile int h;
    public int hd;

    @RawRes
    public int i;
    public int ic;
    public c l;
    public tt lr;
    public a m;
    public long md;
    public com.byazt.jzl.tt my;
    public da<Throwable> n;
    public int nb;
    public final Handler nu;
    public com.byazt.zk.t or;
    public Handler p;
    public int pf;
    public int qp;
    public final RectF qy;
    public final Handler rh;
    public final RectF rl;
    public boolean sl;
    public final x sp;
    public String sv;
    public boolean t;
    public final Set<uj> u;
    public final da<Throwable> uj;
    public final da<a> ve;
    public String x;
    public final Set<Object> yp;
    public int yv;
    public u<a> z;
    public List<com.byazt.zk.a> zb;
    public volatile boolean zm;

    /* JADX INFO: renamed from: com.byazt.ga.LottieAnimationView$8, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 256, AVMDLDataLoader.KeyIsIsDownloadSource})
    public static /* synthetic */ class AnonymousClass8 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            c = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[ImageView.ScaleType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface c {
        void c(Map<String, Object> map);

        void tt(Map<String, Object> map);
    }

    public interface tt {
        void c(String str, JSONArray jSONArray);
    }

    public enum uj {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    @com.byazt.zqa.c(c = {0, 1, 256, 1658})
    public static class ve extends View.BaseSavedState {
        public static final Parcelable.Creator<ve> CREATOR = new Parcelable.Creator<ve>() { // from class: com.byazt.ga.LottieAnimationView.ve.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ve createFromParcel(Parcel parcel) {
                return new ve(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ve[] newArray(int i) {
                return new ve[i];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f28551a;
        public String c;
        public String n;
        public int sp;
        public int tt;
        public boolean uj;
        public float ve;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.c);
            parcel.writeFloat(this.ve);
            parcel.writeInt(this.uj ? 1 : 0);
            parcel.writeString(this.n);
            parcel.writeInt(this.f28551a);
            parcel.writeInt(this.sp);
        }

        public ve(Parcelable parcelable) {
            super(parcelable);
        }

        private ve(Parcel parcel) {
            super(parcel);
            this.c = parcel.readString();
            this.ve = parcel.readFloat();
            this.uj = parcel.readInt() == 1;
            this.n = parcel.readString();
            this.f28551a = parcel.readInt();
            this.sp = parcel.readInt();
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.ve = new da<a>() { // from class: com.byazt.ga.LottieAnimationView.9
            @Override // com.byazt.ga.da
            public void c(a aVar) {
                a.tt ttVarT = aVar.t();
                com.byazt.rs.uj ujVar = ttVarT != null ? ttVarT.x : null;
                if (ujVar == null || com.byazt.rs.a.c().ve()) {
                    LottieAnimationView.this.setComposition(aVar);
                } else {
                    LottieAnimationView.this.c(aVar, ujVar);
                }
            }
        };
        this.uj = new da<Throwable>() { // from class: com.byazt.ga.LottieAnimationView.11
            @Override // com.byazt.ga.da
            public void c(Throwable th) {
                LottieAnimationView.this.c(th);
            }
        };
        this.f28549a = 0;
        this.sp = new x(this);
        this.da = false;
        this.sl = false;
        this.t = true;
        this.u = new HashSet();
        this.yp = new HashSet();
        this.nu = new Handler(Looper.getMainLooper());
        this.rh = new Handler(Looper.getMainLooper());
        this.rl = new RectF();
        this.qy = new RectF();
        this.gu = new com.byazt.qm.c() { // from class: com.byazt.ga.LottieAnimationView.12
            @Override // com.byazt.qm.c
            public void c() {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.c(lottieAnimationView.gt);
            }
        };
        this.zm = false;
        this.yv = 0;
        this.md = 0L;
        this.h = 0;
        this.d = new Runnable() { // from class: com.byazt.ga.LottieAnimationView.6
            @Override // java.lang.Runnable
            public void run() {
                LottieAnimationView.this.z();
                if (LottieAnimationView.this.h == 0) {
                    return;
                }
                if (LottieAnimationView.this.isShown()) {
                    if (LottieAnimationView.this.h == 1) {
                        LottieAnimationView.this.h = 2;
                        LottieAnimationView.this.nu();
                        return;
                    }
                    return;
                }
                if (LottieAnimationView.this.h == 2) {
                    LottieAnimationView.this.h = 1;
                    LottieAnimationView.this.rh();
                }
            }
        };
        this.bm = new Runnable() { // from class: com.byazt.ga.LottieAnimationView.7
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.nr.m.c("TMe", "--==--- timer callback, timer: " + LottieAnimationView.this.qp + ", " + LottieAnimationView.this.nb);
                if (LottieAnimationView.this.qp > LottieAnimationView.this.nb) {
                    LottieAnimationView.rl(LottieAnimationView.this);
                    LottieAnimationView.this.my();
                    LottieAnimationView.this.invalidate();
                    LottieAnimationView.this.nu();
                    return;
                }
                LottieAnimationView.this.h = 0;
                LottieAnimationView.this.m();
                if (LottieAnimationView.this.pf < 0 || LottieAnimationView.this.bx < 0) {
                    com.byazt.nr.m.c("TMe", "--==--- timer end, frame invalid: " + LottieAnimationView.this.pf + "," + LottieAnimationView.this.bx);
                } else {
                    com.byazt.nr.m.c("TMe", "--==--- timer end, play anim, startframe: " + LottieAnimationView.this.pf);
                    LottieAnimationView.this.tt();
                    LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                    lottieAnimationView.setFrame(lottieAnimationView.pf);
                    LottieAnimationView.this.c(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ga.LottieAnimationView.7.1
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            if (LottieAnimationView.this.getFrame() < LottieAnimationView.this.bx - 1 || LottieAnimationView.this.getFrame() >= LottieAnimationView.this.bx + 2) {
                                return;
                            }
                            com.byazt.nr.m.c("TMe", "--==--- timer end, play anim, endframe: " + LottieAnimationView.this.bx);
                            LottieAnimationView.this.tt(this);
                            LottieAnimationView.this.sp();
                        }
                    });
                }
                if ((!TextUtils.isEmpty(LottieAnimationView.this.sv) || (LottieAnimationView.this.aw != null && LottieAnimationView.this.aw.length() > 0)) && LottieAnimationView.this.lr != null) {
                    LottieAnimationView.this.lr.c(LottieAnimationView.this.sv, LottieAnimationView.this.aw);
                }
            }
        };
        x();
    }

    private a.c getArea() {
        a aVarP;
        x xVar = this.sp;
        if (xVar == null || (aVarP = xVar.p()) == null) {
            return null;
        }
        return aVarP.da();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.tt getGlobalConfig() {
        a aVarP;
        x xVar = this.sp;
        if (xVar == null || (aVarP = xVar.p()) == null) {
            return null;
        }
        return aVarP.t();
    }

    private a.ve getGlobalEvent() {
        a aVarP;
        x xVar = this.sp;
        if (xVar == null || (aVarP = xVar.p()) == null) {
            return null;
        }
        return aVarP.sl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPlayDelayedELExpressTimeS() {
        a aVarP;
        x xVar = this.sp;
        if (xVar == null || (aVarP = xVar.p()) == null) {
            return null;
        }
        return aVarP.i();
    }

    public static /* synthetic */ int rl(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.qp;
        lottieAnimationView.qp = i - 1;
        return i;
    }

    private void setCompositionTask(u<a> uVar) {
        this.u.add(uj.SET_ANIMATION);
        gt();
        u();
        this.z = uVar.c(this.ve).ve(this.uj);
    }

    public static /* synthetic */ int uj(LottieAnimationView lottieAnimationView) {
        int i = lottieAnimationView.yv;
        lottieAnimationView.yv = i + 1;
        return i;
    }

    public boolean getClipToCompositionBounds() {
        return this.sp.uj();
    }

    public a getComposition() {
        return this.m;
    }

    public long getDuration() {
        a aVar = this.m;
        if (aVar != null) {
            return (long) aVar.n();
        }
        return 0L;
    }

    public int getFrame() {
        return this.sp.gt();
    }

    public String getImageAssetsFolder() {
        return this.sp.n();
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.sp.a();
    }

    public float getMaxFrame() {
        return this.sp.m();
    }

    public float getMinFrame() {
        return this.sp.z();
    }

    public rh getPerformanceTracker() {
        return this.sp.i();
    }

    public float getProgress() {
        return this.sp.d();
    }

    public my getRenderMode() {
        return this.sp.sp();
    }

    public int getRepeatCount() {
        return this.sp.qy();
    }

    public int getRepeatMode() {
        return this.sp.rl();
    }

    public float getSpeed() {
        return this.sp.nu();
    }

    public com.byazt.jzl.tt getVideoStats() {
        return this.my;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        Drawable drawable = getDrawable();
        if ((drawable instanceof x) && ((x) drawable).sp() == my.SOFTWARE) {
            this.sp.invalidateSelf();
        }
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        x xVar = this.sp;
        if (drawable2 == xVar) {
            super.invalidateDrawable(xVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isInEditMode() || !this.sl) {
            return;
        }
        this.sp.t();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        rh();
        m();
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        uj();
        ve();
        a();
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof ve)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ve veVar = (ve) parcelable;
        super.onRestoreInstanceState(veVar.getSuperState());
        this.x = veVar.c;
        Set<uj> set = this.u;
        uj ujVar = uj.SET_ANIMATION;
        if (!set.contains(ujVar) && !TextUtils.isEmpty(this.x)) {
            setAnimation(this.x);
        }
        this.i = veVar.tt;
        if (!this.u.contains(ujVar) && (i = this.i) != 0) {
            setAnimation(i);
        }
        if (!this.u.contains(uj.SET_PROGRESS)) {
            c(veVar.ve, false);
        }
        if (!this.u.contains(uj.PLAY_OPTION) && veVar.uj) {
            c();
        }
        if (!this.u.contains(uj.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(veVar.n);
        }
        if (!this.u.contains(uj.SET_REPEAT_MODE)) {
            setRepeatMode(veVar.f28551a);
        }
        if (this.u.contains(uj.SET_REPEAT_COUNT)) {
            return;
        }
        setRepeatCount(veVar.sp);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ve veVar = new ve(super.onSaveInstanceState());
        veVar.c = this.x;
        veVar.tt = this.i;
        veVar.ve = this.sp.d();
        veVar.uj = this.sp.gr();
        veVar.n = this.sp.n();
        veVar.f28551a = this.sp.rl();
        veVar.sp = this.sp.qy();
        return veVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (r4 <= (r5 + r0.x)) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        i iVarC;
        int i;
        String str;
        JSONArray jSONArray;
        String str2;
        if (motionEvent.getAction() == 0) {
            a.c area = getArea();
            if (area != null) {
                if (area.n == -1.0f) {
                    c(area);
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = area.n;
                if (x >= f && x <= f + area.sp) {
                    float f2 = area.f28553a;
                    if (y >= f2) {
                    }
                }
                com.byazt.nr.m.c("TMe", "--==--:width: " + getWidth() + ", height: " + getHeight());
                StringBuilder sb = new StringBuilder("--==--:");
                sb.append(area);
                com.byazt.nr.m.c("TMe", sb.toString());
                com.byazt.nr.m.c("TMe", "--==--:pintx: " + x + ", pointY: " + y);
                return false;
            }
            com.byazt.zk.ve veVarC = c(motionEvent);
            if (veVarC == null || (veVarC instanceof com.byazt.zk.uj)) {
                if (getGlobalConfig() == null || getGlobalConfig().c != 1) {
                    return super.onTouchEvent(motionEvent);
                }
                return false;
            }
            String strSl = veVarC.sl();
            if (strSl != null && strSl.startsWith("CSJNTP")) {
                return false;
            }
            this.gt = veVarC;
        }
        com.byazt.zk.ve veVar = this.gt;
        if (veVar == null || (iVarC = c(veVar.sp())) == null || !c(iVarC)) {
            return super.onTouchEvent(motionEvent);
        }
        if (this.gr != null) {
            com.byazt.zk.ve veVar2 = this.gt;
            String strSl2 = veVar2.sl();
            a.ve globalEvent = getGlobalEvent();
            if (globalEvent != null) {
                String str3 = globalEvent.c;
                JSONArray jSONArray2 = globalEvent.ve;
                int i2 = globalEvent.uj;
                str2 = globalEvent.n;
                i = i2;
                jSONArray = jSONArray2;
                str = str3;
            } else {
                i = 10;
                str = null;
                jSONArray = null;
                str2 = null;
            }
            x xVar = this.sp;
            if (xVar == null || !xVar.x()) {
                veVar2.c(this.qy, veVar2.a(), true);
                tt(this.rl, this.qy);
            } else {
                veVar2.c(this.rl, veVar2.a(), true);
                RectF rectFEo = this.sp.eo();
                if (rectFEo != null) {
                    c(this.rl, rectFEo);
                }
            }
            this.gr.c(motionEvent, strSl2, iVarC, str, jSONArray, i, str2, this.gu, c(motionEvent, this.rl));
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.gt = null;
        }
        return true;
    }

    public void setAnimation(@RawRes int i) {
        this.i = i;
        this.x = null;
        setCompositionTask(c(i));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        c(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        if (!this.zm) {
            throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromUrl");
        }
        setCompositionTask(this.t ? sp.c(getContext(), str) : sp.c(getContext(), str, (String) null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.sp.n(z);
    }

    public void setAutoPlay(boolean z) {
        this.sl = z;
    }

    public void setCacheComposition(boolean z) {
        this.t = z;
    }

    public void setClipToCompositionBounds(boolean z) {
        this.sp.c(z);
    }

    public void setComposition(a aVar) {
        boolean z = n.c;
        this.sp.setCallback(this);
        this.m = aVar;
        this.da = true;
        boolean zC = this.sp.c(aVar, getContext().getApplicationContext());
        this.da = false;
        if (getDrawable() != this.sp || zC) {
            if (!zC) {
                rl();
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator<Object> it = this.yp.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public void setDefaultFontFileExtension(String str) {
        this.sp.sp(str);
    }

    public void setEventMonitorProxy(com.byazt.qm.tt ttVar) {
        this.gr = ttVar;
    }

    public void setFailureListener(da<Throwable> daVar) {
        this.n = daVar;
    }

    public void setFallbackResource(int i) {
        this.f28549a = i;
    }

    public void setFontAssetDelegate(com.byazt.ga.ve veVar) {
        this.sp.c(veVar);
    }

    public void setFontMap(Map<String, Typeface> map) {
        this.sp.c(map);
    }

    public void setFrame(int i) {
        this.sp.ve(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.sp.sp(z);
    }

    public void setImageAssetDelegate(com.byazt.ga.uj ujVar) {
        this.zm = true;
        this.sp.c(ujVar);
    }

    public void setImageAssetsFolder(String str) {
        this.sp.c(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        u();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        u();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        u();
        super.setImageResource(i);
    }

    public void setLottieAnimListener(c cVar) {
        this.l = cVar;
    }

    public void setLottieClicklistener(tt ttVar) {
        this.lr = ttVar;
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.sp.tt(z);
    }

    public void setMaxFrame(int i) {
        this.sp.tt(i);
    }

    public void setMaxProgress(float f) {
        this.sp.tt(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.sp.uj(str);
    }

    public void setMinFrame(int i) {
        this.sp.c(i);
    }

    public void setMinProgress(float f) {
        this.sp.c(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        this.sp.uj(z);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.sp.ve(z);
    }

    public void setProgress(float f) {
        c(f, true);
    }

    public void setRenderMode(my myVar) {
        this.sp.c(myVar);
    }

    public void setRepeatCount(int i) {
        this.u.add(uj.SET_REPEAT_COUNT);
        this.sp.n(i);
    }

    public void setRepeatMode(int i) {
        this.u.add(uj.SET_REPEAT_MODE);
        this.sp.uj(i);
    }

    public void setSafeMode(boolean z) {
        this.sp.a(z);
    }

    public void setSpeed(float f) {
        this.sp.ve(f);
    }

    public void setTextDelegate(gt gtVar) {
        this.sp.c(gtVar);
    }

    public void setUseCompositionFrameRate(boolean z) {
        this.sp.x(z);
    }

    public void setVideoStats(com.byazt.jzl.tt ttVar) {
        this.my = ttVar;
    }

    public void setViewDelegate(rl rlVar) {
        this.sp.c(rlVar);
    }

    @Override // android.view.View
    public void unscheduleDrawable(Drawable drawable) {
        x xVar;
        if (!this.da && drawable == (xVar = this.sp) && xVar.gu()) {
            sp();
        } else if (!this.da && (drawable instanceof x)) {
            x xVar2 = (x) drawable;
            if (xVar2.gu()) {
                xVar2.h();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    private void da() {
        c(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ga.LottieAnimationView.14
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Map<String, Object> map;
                int i;
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < 0.98f) {
                    return;
                }
                LottieAnimationView.uj(LottieAnimationView.this);
                a.tt globalConfig = LottieAnimationView.this.getGlobalConfig();
                if (globalConfig != null && (i = globalConfig.uj) > 0 && i > LottieAnimationView.this.yv) {
                    LottieAnimationView.this.yp();
                    LottieAnimationView.this.c();
                    LottieAnimationView.this.setProgress(0.0f);
                    return;
                }
                LottieAnimationView.this.tt(this);
                if (LottieAnimationView.this.l != null) {
                    if (globalConfig == null || (map = globalConfig.ve) == null) {
                        map = null;
                    }
                    LottieAnimationView.this.l.tt(map);
                }
            }
        });
    }

    private void gt() {
        this.m = null;
        this.sp.sl();
    }

    private void i() {
        c(new Animator.AnimatorListener() { // from class: com.byazt.ga.LottieAnimationView.13
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
                LottieAnimationView.this.tt(this);
                LottieAnimationView.this.yp();
                LottieAnimationView.this.sl();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.rh.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void my() {
        String[] strArrSplit;
        String[] strArrSplit2;
        List<com.byazt.zk.a> list = this.zb;
        if (list == null || list.size() != 3) {
            com.byazt.zk.a aVar = this.eo;
            if (aVar != null) {
                if (this.ic == 1) {
                    aVar.c(tt(this.qp));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.qp);
                    aVar.c(sb.toString());
                }
            }
        } else {
            String strTt = tt(this.qp);
            if (!TextUtils.isEmpty(strTt) && (strArrSplit2 = strTt.split(u15.f19942b)) != null && strArrSplit2.length == 3) {
                for (int i = 0; i < 3; i++) {
                    com.byazt.zk.a aVar2 = this.zb.get(i);
                    if (aVar2 != null) {
                        aVar2.c(strArrSplit2[i]);
                    }
                }
            }
        }
        List<com.byazt.zk.t> list2 = this.cu;
        if (list2 == null || list2.size() != 3) {
            com.byazt.zk.t tVar = this.or;
            if (tVar != null) {
                if (this.ic == 1) {
                    tVar.c(tt(this.qp));
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.qp);
                tVar.c(sb2.toString());
                return;
            }
            return;
        }
        String strTt2 = tt(this.qp);
        if (TextUtils.isEmpty(strTt2) || (strArrSplit = strTt2.split(u15.f19942b)) == null || strArrSplit.length != 3) {
            return;
        }
        for (int i2 = 0; i2 < 3; i2++) {
            com.byazt.zk.t tVar2 = this.cu.get(i2);
            if (tVar2 != null) {
                tVar2.c(strArrSplit[i2]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        rh();
        this.nu.postDelayed(this.bm, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        this.nu.removeCallbacksAndMessages(null);
    }

    private void rl() {
        boolean zN = n();
        setImageDrawable(null);
        setImageDrawable(this.sp);
        if (zN) {
            this.sp.yp();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sl() {
        final a.tt globalConfig = getGlobalConfig();
        if (globalConfig == null || globalConfig.n <= 0) {
            return;
        }
        if (TextUtils.isEmpty(globalConfig.f28554a) && globalConfig.sp == null) {
            return;
        }
        int maxFrame = globalConfig.n;
        if (maxFrame > getMaxFrame()) {
            maxFrame = (int) getMaxFrame();
        }
        final float maxFrame2 = maxFrame / getMaxFrame();
        c(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ga.LottieAnimationView.15
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Object animatedValue = valueAnimator.getAnimatedValue();
                if (!(animatedValue instanceof Float) || ((Float) animatedValue).floatValue() < maxFrame2) {
                    return;
                }
                LottieAnimationView.this.tt(this);
                if (LottieAnimationView.this.lr != null) {
                    tt ttVar = LottieAnimationView.this.lr;
                    a.tt ttVar2 = globalConfig;
                    ttVar.c(ttVar2.f28554a, ttVar2.sp);
                }
            }
        });
    }

    private void t() {
        c(new Animator.AnimatorListener() { // from class: com.byazt.ga.LottieAnimationView.16
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
                gt gtVarZm;
                final long jElapsedRealtime = SystemClock.elapsedRealtime() - LottieAnimationView.this.md;
                LottieAnimationView.this.tt(this);
                String playDelayedELExpressTimeS = LottieAnimationView.this.getPlayDelayedELExpressTimeS();
                if (!TextUtils.isEmpty(playDelayedELExpressTimeS) && (gtVarZm = LottieAnimationView.this.sp.zm()) != null) {
                    try {
                        int i = Integer.parseInt(gtVarZm.c(playDelayedELExpressTimeS)) * 1000;
                        if (LottieAnimationView.this.md > 0) {
                            long jElapsedRealtime2 = (LottieAnimationView.this.md + ((long) i)) - SystemClock.elapsedRealtime();
                            com.byazt.nr.m.c("TMe", "--==-- lottie delayed time: ".concat(String.valueOf(jElapsedRealtime2)));
                            if (jElapsedRealtime2 > 0) {
                                LottieAnimationView.this.sp();
                                LottieAnimationView.this.setVisibility(8);
                                if (LottieAnimationView.this.p == null) {
                                    LottieAnimationView.this.p = new Handler(Looper.getMainLooper());
                                }
                                LottieAnimationView.this.p.removeCallbacksAndMessages(null);
                                LottieAnimationView.this.p.postDelayed(new Runnable() { // from class: com.byazt.ga.LottieAnimationView.16.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        com.byazt.nr.m.c("TMe", "--==-- lottie real start play");
                                        LottieAnimationView.this.setVisibility(0);
                                        LottieAnimationView.this.c();
                                        LottieAnimationView.this.c(jElapsedRealtime);
                                    }
                                }, jElapsedRealtime2);
                                return;
                            }
                        }
                    } catch (NumberFormatException e) {
                        com.byazt.nr.m.c(e);
                    }
                }
                LottieAnimationView.this.c(jElapsedRealtime);
            }
        });
    }

    private void tt(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = this.sp.getBounds().width();
        float fHeight = this.sp.getBounds().height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass8.c[getScaleType().ordinal()];
        if (i == 1) {
            c(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            tt(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            ve(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            uj(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF, rectF2);
    }

    private void u() {
        u<a> uVar = this.z;
        if (uVar != null) {
            uVar.tt(this.ve);
            this.z.uj(this.uj);
        }
    }

    private void uj(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 >= f || f4 >= f2) {
            if (f3 / f4 >= f / f2) {
                float f5 = f / f3;
                matrix.preScale(f5, f5);
                matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
                return;
            } else {
                float f6 = f2 / f4;
                matrix.preScale(f6, f6);
                matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
                return;
            }
        }
        if (f3 / f4 >= f / f2) {
            float f7 = f / f3;
            matrix.preScale(f7, f7);
            matrix.postTranslate(0.0f, (f2 - (f4 * f7)) / 2.0f);
        } else {
            float f8 = f2 / f4;
            matrix.preScale(f8, f8);
            matrix.postTranslate((f - (f3 * f8)) / 2.0f, 0.0f);
        }
    }

    private void ve(Matrix matrix, float f, float f2, float f3, float f4) {
        matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
    }

    private void x() {
        setSaveEnabled(false);
        this.t = true;
        setFallbackResource(0);
        setImageAssetsFolder("");
        c(0.0f, false);
        c(false, getContext().getApplicationContext());
        setIgnoreDisabledSystemAnimations(false);
        this.sp.c(Boolean.valueOf(com.byazt.kk.da.c(getContext()) != 0.0f));
        i();
        da();
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yp() {
        x xVar;
        int i;
        int i2;
        int i3;
        if (this.m == null || (xVar = this.sp) == null) {
            return;
        }
        gt gtVarZm = xVar.zm();
        final a.uj ujVarX = this.m.x();
        if (ujVarX == null || gtVarZm == null) {
            return;
        }
        final int i4 = ujVarX.c;
        if (i4 < 0) {
            com.byazt.nr.m.c("TMe", "--==--- timer fail, ke is invalid: " + i4);
            return;
        }
        int[] iArr = ujVarX.n;
        final int i5 = -1;
        if (iArr == null || iArr.length < 2) {
            i = -1;
            i2 = -1;
        } else {
            i2 = iArr[0];
            i = iArr[1];
        }
        String strC = gtVarZm.c(ujVarX.ve);
        String strC2 = gtVarZm.c(ujVarX.uj);
        try {
            i3 = Integer.parseInt(strC);
            try {
                i5 = Integer.parseInt(strC2);
            } catch (NumberFormatException e) {
                e = e;
                com.byazt.nr.m.c(e);
            }
        } catch (NumberFormatException e2) {
            e = e2;
            i3 = -1;
        }
        com.byazt.nr.m.c("TMe", "--==--- prepare timer, startS: " + i3 + ", lenS: " + i5);
        if (ujVarX.sl == 2 && ujVarX.t != null) {
            this.zb = new ArrayList(3);
            this.cu = new ArrayList(3);
            for (String str : ujVarX.t) {
                if (!TextUtils.isEmpty(str)) {
                    com.byazt.nr.m.c("TMe", "--==--- timers, id:" + ujVarX.tt);
                    com.byazt.zk.a aVarUj = uj(str);
                    if (aVarUj != null) {
                        this.zb.add(aVarUj);
                    }
                    com.byazt.zk.t tVarVe = ve(str);
                    if (tVarVe != null) {
                        this.cu.add(tVarVe);
                    }
                }
            }
            if (this.zb.size() != 3 && this.cu.size() != 3) {
                com.byazt.nr.m.c("TMe", "--==--- timer layers size != 3, is " + this.zb.size() + ", timer is invalid");
                com.byazt.nr.m.c("TMe", "--==--- textTimer layers size != 3, is " + this.cu.size() + ", timer is invalid");
                return;
            }
        }
        if (!TextUtils.isEmpty(ujVarX.tt)) {
            com.byazt.nr.m.c("TMe", "--==--- timer, id:" + ujVarX.tt);
            this.eo = uj(ujVarX.tt);
            this.or = ve(ujVarX.tt);
        }
        if (this.zb == null && this.eo == null && this.cu == null && this.or == null) {
            com.byazt.nr.m.c("TMe", "--==--- timer fail, id is invalid: " + ujVarX.tt);
            return;
        }
        com.byazt.nr.m.c("TMe", "--==--- timer success, timer tp: " + ujVarX.sl);
        this.ic = ujVarX.sl;
        this.sv = ujVarX.f28555a;
        this.aw = ujVarX.sp;
        this.hd = ujVarX.u;
        this.qp = i3;
        this.nb = i3 - i5;
        this.pf = i2;
        this.bx = i;
        my();
        final int i6 = i3;
        c(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ga.LottieAnimationView.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                JSONArray jSONArray;
                if (LottieAnimationView.this.getFrame() < i4 - 1 || LottieAnimationView.this.getFrame() >= i4 + 2) {
                    return;
                }
                com.byazt.nr.m.c("TMe", "--==--- enter timer point, frame: " + LottieAnimationView.this.getFrame());
                LottieAnimationView.this.tt(this);
                if (i6 < 0 || i5 < 0) {
                    com.byazt.nr.m.c("TMe", "--==--- enter timer callback, NOT start timer");
                } else {
                    com.byazt.nr.m.c("TMe", "--==--- enter timer callback, start timer");
                    LottieAnimationView.this.h = 2;
                    if (ujVarX.da == 1) {
                        LottieAnimationView.this.z();
                    }
                    LottieAnimationView.this.nu();
                    if ((!TextUtils.isEmpty(ujVarX.x) || ((jSONArray = ujVarX.i) != null && jSONArray.length() > 0)) && LottieAnimationView.this.lr != null) {
                        tt ttVar = LottieAnimationView.this.lr;
                        a.uj ujVar = ujVarX;
                        ttVar.c(ujVar.x, ujVar.i);
                    }
                }
                if (LottieAnimationView.this.hd != 1) {
                    LottieAnimationView.this.sp();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        m();
        this.rh.postDelayed(this.d, 500L);
    }

    @MainThread
    public void a() {
        this.u.add(uj.PLAY_OPTION);
        this.sp.md();
    }

    public boolean n() {
        return this.sp.gu();
    }

    public void setMaxFrame(String str) {
        this.sp.ve(str);
    }

    public void setMinFrame(String str) {
        this.sp.tt(str);
    }

    @MainThread
    public void sp() {
        this.sl = false;
        this.sp.h();
    }

    private com.byazt.zk.t ve(String str) {
        com.byazt.zk.uj ujVarVe;
        x xVar = this.sp;
        if (xVar == null || (ujVarVe = xVar.ve()) == null) {
            return null;
        }
        return c(ujVarVe, str);
    }

    public void setAnimation(String str) {
        this.x = str;
        this.i = 0;
        setCompositionTask(tt(str));
    }

    public void ve() {
        this.sp.rh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final a aVar, com.byazt.rs.uj ujVar) {
        com.byazt.rs.a.c().c(ujVar, new com.byazt.rs.sp() { // from class: com.byazt.ga.LottieAnimationView.10
            @Override // com.byazt.rs.sp
            public void c(com.byazt.rs.uj ujVar2) {
                LottieAnimationView.this.setComposition(aVar);
            }

            @Override // com.byazt.rs.sp
            public void c(com.byazt.rs.uj ujVar2, int i, String str) {
                LottieAnimationView.this.c(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        c(new Exception("Lottie zip download failed, errorCode: " + i + ", errorDesc: " + str));
    }

    private com.byazt.zk.a uj(String str) {
        com.byazt.zk.uj ujVarVe;
        x xVar = this.sp;
        if (xVar == null || (ujVarVe = xVar.ve()) == null) {
            return null;
        }
        return tt(ujVarVe, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Throwable th) {
        int i = this.f28549a;
        if (i != 0) {
            setImageResource(i);
        }
        da<Throwable> daVar = this.n;
        if (daVar == null) {
            daVar = tt;
        }
        daVar.c(th);
    }

    private void tt(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 < f && f4 < f2) {
            matrix.postTranslate((f - f3) / 2.0f, (f2 - f4) / 2.0f);
            return;
        }
        if (f3 / f4 >= f / f2) {
            float f5 = f / f3;
            matrix.preScale(f5, f5);
            matrix.postTranslate(0.0f, (f2 - (f4 * f5)) / 2.0f);
        } else {
            float f6 = f2 / f4;
            matrix.preScale(f6, f6);
            matrix.postTranslate((f - (f3 * f6)) / 2.0f, 0.0f);
        }
    }

    public void uj() {
        this.sp.my();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        Map<String, Object> map;
        a.tt globalConfig = getGlobalConfig();
        if (this.l != null) {
            HashMap map2 = new HashMap();
            map2.put("duration", Long.valueOf(j));
            if (globalConfig != null && (map = globalConfig.tt) != null && !map.isEmpty()) {
                map2.putAll(globalConfig.tt);
            }
            this.l.c(map2);
        }
    }

    private u<a> tt(final String str) {
        if (isInEditMode()) {
            return new u<>(new Callable<t<a>>() { // from class: com.byazt.ga.LottieAnimationView.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public t<a> call() throws Exception {
                    return LottieAnimationView.this.t ? sp.ve(LottieAnimationView.this.getContext(), str) : sp.ve(LottieAnimationView.this.getContext(), str, null);
                }
            }, true);
        }
        return this.t ? sp.tt(getContext(), str) : sp.tt(getContext(), str, (String) null);
    }

    private i c(String str) {
        x xVar;
        a aVarP;
        Map<String, i> mapNu;
        if (TextUtils.isEmpty(str) || (xVar = this.sp) == null || (aVarP = xVar.p()) == null || (mapNu = aVarP.nu()) == null) {
            return null;
        }
        return mapNu.get(str);
    }

    public void tt(String str, String str2) {
        if (this.zm) {
            setCompositionTask(sp.c(getContext(), str, str2));
            return;
        }
        throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromUrl");
    }

    private com.byazt.zk.a tt(com.byazt.zk.uj ujVar, String str) {
        for (com.byazt.zk.ve veVar : ujVar.yp()) {
            if (veVar instanceof com.byazt.zk.uj) {
                com.byazt.zk.a aVarTt = tt((com.byazt.zk.uj) veVar, str);
                if (aVarTt != null) {
                    return aVarTt;
                }
            } else if (TextUtils.equals(str, veVar.sl()) && (veVar instanceof com.byazt.zk.a)) {
                return (com.byazt.zk.a) veVar;
            }
        }
        return null;
    }

    private void c(int[][] iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        try {
            int[] iArr2 = iArr[0];
            int i = iArr2[0];
            final int i2 = iArr2[1];
            if (i < 0 || i2 < 0) {
                return;
            }
            com.byazt.nr.m.c("TMe", "--==--- inel enter, play anim, startframe: " + i);
            rh();
            c();
            setFrame(i);
            c(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ga.LottieAnimationView.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    if (LottieAnimationView.this.getFrame() < i2 - 1 || LottieAnimationView.this.getFrame() >= i2 + 2) {
                        return;
                    }
                    com.byazt.nr.m.c("TMe", "--==--- inel enter, play anim end, endframe: " + i2 + ", realFrame: " + LottieAnimationView.this.getFrame());
                    LottieAnimationView.this.tt(this);
                    LottieAnimationView.this.sp();
                }
            });
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    private String tt(int i) {
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 / 60;
        int i5 = i3 % 60;
        StringBuilder sb = new StringBuilder();
        if (i2 < 10) {
            sb.append("0");
        }
        sb.append(i2);
        sb.append(u15.f19942b);
        if (i4 < 10) {
            sb.append("0");
        }
        sb.append(i4);
        sb.append(u15.f19942b);
        if (i5 < 10) {
            sb.append("0");
        }
        sb.append(i5);
        return sb.toString();
    }

    private void c(a.c cVar) {
        cVar.n = com.byazt.kk.da.c("x", cVar.c, getWidth());
        cVar.f28553a = com.byazt.kk.da.c("y", cVar.tt, getHeight());
        cVar.sp = com.byazt.kk.da.c((String) null, cVar.ve, getWidth());
        cVar.x = com.byazt.kk.da.c((String) null, cVar.uj, getHeight());
    }

    private boolean c(i iVar) {
        if (iVar != null) {
            if (!TextUtils.isEmpty(iVar.sp())) {
                return true;
            }
            if (iVar.i() != null && iVar.i().length() > 0) {
                return true;
            }
            if ((iVar.x() != null && iVar.x().length > 0) || !TextUtils.isEmpty(iVar.m())) {
                return true;
            }
        }
        a.ve globalEvent = getGlobalEvent();
        if (globalEvent == null) {
            return false;
        }
        if (!TextUtils.isEmpty(globalEvent.c)) {
            return true;
        }
        JSONArray jSONArray = globalEvent.ve;
        if (jSONArray != null && jSONArray.length() > 0) {
            return true;
        }
        int[][] iArr = globalEvent.tt;
        return (iArr != null && iArr.length > 0) || !TextUtils.isEmpty(globalEvent.n);
    }

    @MainThread
    public void tt() {
        this.u.add(uj.PLAY_OPTION);
        this.sp.yp();
    }

    public void tt(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.sp.tt(animatorUpdateListener);
    }

    public void tt(Animator.AnimatorListener animatorListener) {
        this.sp.tt(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.zk.ve veVar) {
        int[][] iArr;
        int[][] iArrX;
        if (veVar == null) {
            return;
        }
        String strSl = veVar.sl();
        if (strSl != null && strSl.startsWith("CSJCLOSE")) {
            rh();
        }
        i iVarC = c(veVar.sp());
        if (iVarC != null && (iArrX = iVarC.x()) != null) {
            c(iArrX);
        } else {
            if (getGlobalEvent() == null || (iArr = getGlobalEvent().tt) == null) {
                return;
            }
            c(iArr);
        }
    }

    private com.byazt.zk.ve c(MotionEvent motionEvent) {
        com.byazt.zk.uj ujVarVe;
        x xVar = this.sp;
        if (xVar == null || (ujVarVe = xVar.ve()) == null) {
            return null;
        }
        return c(ujVarVe, motionEvent);
    }

    private com.byazt.zk.ve c(com.byazt.zk.uj ujVar, MotionEvent motionEvent) {
        com.byazt.zk.ve veVarC;
        for (com.byazt.zk.ve veVar : ujVar.yp()) {
            if (veVar instanceof com.byazt.zk.uj) {
                if (veVar.da() && veVar.x() > 0.0f) {
                    RectF rectF = new RectF();
                    veVar.c(rectF, veVar.a(), true);
                    if (rectF.width() >= 3.0f && rectF.height() >= 3.0f && (veVarC = c((com.byazt.zk.uj) veVar, motionEvent)) != null) {
                        return veVarC;
                    }
                }
            } else if (veVar.da() && veVar.x() > 0.0f) {
                RectF rectF2 = new RectF();
                x xVar = this.sp;
                if (xVar != null && xVar.x()) {
                    veVar.c(rectF2, veVar.a(), true);
                    RectF rectFEo = this.sp.eo();
                    if (rectFEo != null) {
                        c(rectF2, rectFEo);
                    }
                } else {
                    RectF rectF3 = new RectF();
                    veVar.c(rectF3, veVar.a(), true);
                    tt(rectF2, rectF3);
                }
                if (c(motionEvent, rectF2)) {
                    return veVar;
                }
            }
        }
        return null;
    }

    private boolean c(MotionEvent motionEvent, RectF rectF) {
        if (motionEvent != null && rectF != null) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (x >= rectF.left && x <= rectF.right && y >= rectF.top && y <= rectF.bottom) {
                return true;
            }
        }
        return false;
    }

    private void c(RectF rectF, RectF rectF2) {
        float width = getWidth();
        float height = getHeight();
        float fWidth = rectF2.width();
        float fHeight = rectF2.height();
        if (width == 0.0f || height == 0.0f || fWidth == 0.0f || fHeight == 0.0f) {
            return;
        }
        Matrix matrix = new Matrix();
        int i = AnonymousClass8.c[getScaleType().ordinal()];
        if (i == 1) {
            c(matrix, width, height, fWidth, fHeight);
        } else if (i == 2) {
            tt(matrix, width, height, fWidth, fHeight);
        } else if (i == 3) {
            ve(matrix, width, height, fWidth, fHeight);
        } else if (i == 4) {
            uj(matrix, width, height, fWidth, fHeight);
        }
        matrix.mapRect(rectF);
    }

    private void c(Matrix matrix, float f, float f2, float f3, float f4) {
        if (f3 / f4 >= f / f2) {
            float f5 = f2 / f4;
            matrix.preScale(f5, f5);
            matrix.postTranslate(-(((f3 * f5) - f) / 2.0f), 0.0f);
        } else {
            float f6 = f / f3;
            matrix.preScale(f6, f6);
            matrix.postTranslate(0.0f, -(((f4 * f6) - f2) / 2.0f));
        }
    }

    public void c(boolean z, Context context) {
        this.sp.c(z, context);
    }

    private u<a> c(@RawRes final int i) {
        if (isInEditMode()) {
            return new u<>(new Callable<t<a>>() { // from class: com.byazt.ga.LottieAnimationView.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public t<a> call() throws Exception {
                    return LottieAnimationView.this.t ? sp.tt(LottieAnimationView.this.getContext(), i) : sp.tt(LottieAnimationView.this.getContext(), i, (String) null);
                }
            }, true);
        }
        return this.t ? sp.c(getContext(), i) : sp.c(getContext(), i, (String) null);
    }

    public void c(String str, String str2) {
        if (this.zm) {
            c(new ByteArrayInputStream(str.getBytes()), str2);
            return;
        }
        throw new IllegalStateException("必须先设置setImageAssetDelegate，再setAnimationFromJson");
    }

    public void c(InputStream inputStream, String str) {
        setCompositionTask(sp.c(inputStream, str));
    }

    private com.byazt.zk.t c(com.byazt.zk.uj ujVar, String str) {
        for (com.byazt.zk.ve veVar : ujVar.yp()) {
            if (veVar instanceof com.byazt.zk.uj) {
                com.byazt.zk.t tVarC = c((com.byazt.zk.uj) veVar, str);
                if (tVarC != null) {
                    return tVarC;
                }
            } else if (TextUtils.equals(str, veVar.sl()) && (veVar instanceof com.byazt.zk.t)) {
                return (com.byazt.zk.t) veVar;
            }
        }
        return null;
    }

    @MainThread
    public void c() {
        if (this.md == 0) {
            this.md = SystemClock.elapsedRealtime();
        }
        this.u.add(uj.PLAY_OPTION);
        this.sp.t();
    }

    public void c(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.sp.c(animatorUpdateListener);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.sp.c(animatorListener);
    }

    @Deprecated
    public void c(boolean z) {
        this.sp.n(z ? -1 : 0);
    }

    public Bitmap c(String str, Bitmap bitmap) {
        return this.sp.c(str, bitmap);
    }

    private void c(float f, boolean z) {
        if (z) {
            this.u.add(uj.SET_PROGRESS);
        }
        this.sp.uj(f);
    }

    public void c(String str, com.byazt.rs.i iVar) {
        if (this.m != null) {
            com.byazt.rs.c.c().c(this.m.t(), str, iVar);
        } else if (iVar != null) {
            iVar.c();
        }
    }
}
