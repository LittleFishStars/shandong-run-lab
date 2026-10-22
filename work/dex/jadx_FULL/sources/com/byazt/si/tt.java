package com.byazt.si;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.cd.x;
import com.byazt.ga.i;
import com.byazt.ga.uj;
import com.byazt.sa.n;
import com.byazt.xj.ve;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 608, 13})
public class tt extends ve<UgenLottieView> {

    @Deprecated
    public boolean az;
    public String c;
    public String cf;
    public boolean ij;
    public int is;
    public boolean jt;
    public final Map<String, Integer> kz;
    public ImageView.ScaleType mq;
    public float nl;
    public ImageView.ScaleType vi;
    public HashMap<String, Bitmap> vp;
    public float w;
    public String yo;

    /* JADX INFO: renamed from: com.byazt.si.tt$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 608, 28})
    public class AnonymousClass1 implements uj {
        public AnonymousClass1() {
        }

        @Override // com.byazt.ga.uj
        public Bitmap c(final i iVar) {
            final String strC;
            if (iVar == null) {
                return null;
            }
            String strYp = iVar.yp();
            String strU = iVar.u();
            if (!TextUtils.isEmpty(strYp) && TextUtils.isEmpty(strU)) {
                strC = com.byazt.wj.tt.c(strYp, tt.this.uj);
            } else if (!TextUtils.isEmpty(strU) && TextUtils.isEmpty(strYp)) {
                strC = com.byazt.wj.tt.c(strU, tt.this.uj);
            } else if (TextUtils.isEmpty(strU) || TextUtils.isEmpty(strYp)) {
                strC = null;
            } else {
                strC = com.byazt.wj.tt.c(strYp, tt.this.uj) + com.byazt.wj.tt.c(strU, tt.this.uj);
            }
            if (TextUtils.isEmpty(strC)) {
                return null;
            }
            Bitmap bitmap = tt.this.vp.get(strC);
            if (bitmap != null) {
                return bitmap;
            }
            Integer num = tt.this.kz.get(strC);
            if (num == null || num.intValue() == 2) {
                tt.this.kz.put(strC, 1);
            } else if (num.intValue() == 1) {
                return null;
            }
            ((UgenLottieView) tt.this.n).c(strC, new com.byazt.rs.i() { // from class: com.byazt.si.tt.1.1
                @Override // com.byazt.rs.i
                public void c(Bitmap bitmap2) {
                    tt.this.c(iVar, strC, bitmap2);
                }

                @Override // com.byazt.rs.i
                public void c() {
                    n.c().tt().c(tt.this.i, strC, new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.si.tt.1.1.1
                        @Override // com.byazt.sa.c.InterfaceC0516c
                        public void c(Bitmap bitmap2) {
                            C05211 c05211 = C05211.this;
                            tt.this.c(iVar, strC, bitmap2);
                        }
                    });
                }
            });
            return tt.this.vp.get(strC);
        }
    }

    public tt(Context context) {
        super(context);
        this.cf = "images";
        this.nl = 1.0f;
        this.kz = new ConcurrentHashMap();
        this.vi = ImageView.ScaleType.FIT_CENTER;
        this.mq = ImageView.ScaleType.FIT_XY;
        this.vp = new HashMap<>();
    }

    private String sl(String str) {
        if (TextUtils.isEmpty(str) || !str.contains("local")) {
            return "";
        }
        if (str.contains("shake_phone")) {
            return "lottie_json/shake_phone.json";
        }
        return str.contains("swipe_right") ? "lottie_json/swipe_right.json" : "";
    }

    private ImageView.ScaleType t(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    private ImageView.ScaleType u(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
            case "none":
                return ImageView.ScaleType.CENTER;
            case "fit":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    public void b() {
        if (this.c.startsWith("local")) {
            ((UgenLottieView) this.n).setAnimation(sl(this.c));
            ((UgenLottieView) this.n).setImageAssetsFolder(this.cf);
            return;
        }
        String str = this.yo;
        if (str == null) {
            ((UgenLottieView) this.n).setAnimationFromUrl(this.c);
        } else if (TextUtils.equals("", str)) {
            ((UgenLottieView) this.n).tt(this.c, (String) null);
        } else {
            ((UgenLottieView) this.n).tt(this.c, this.yo);
        }
    }

    public void q() {
        T t = this.n;
        if (t != 0) {
            ((UgenLottieView) t).c();
        }
    }

    public void x() {
        b();
        ((UgenLottieView) this.n).c();
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public UgenLottieView c() {
        UgenLottieView ugenLottieView = new UgenLottieView(this.tt);
        ugenLottieView.c(this);
        return ugenLottieView;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((UgenLottieView) this.n).setProgress(this.w);
        if (this.nl <= 0.0f) {
            this.nl = 1.0f;
        }
        ((UgenLottieView) this.n).setSpeed(this.nl);
        ((UgenLottieView) this.n).setAutoPlay(this.jt);
        ((UgenLottieView) this.n).setImageAssetDelegate(new AnonymousClass1());
        if (h()) {
            ((UgenLottieView) this.n).setScaleType(this.mq);
        } else {
            ((UgenLottieView) this.n).setScaleType(this.vi);
        }
        if (h()) {
            ((UgenLottieView) this.n).setRepeatCount(this.is);
        } else {
            ((UgenLottieView) this.n).c(this.az);
        }
        x();
    }

    public void c(final i iVar, String str, Bitmap bitmap) {
        if (bitmap != null) {
            final Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, iVar.c(), iVar.tt(), false);
            this.vp.put(str, bitmapCreateScaledBitmap);
            this.kz.remove(str);
            x.c(new Runnable() { // from class: com.byazt.si.tt.2
                @Override // java.lang.Runnable
                public void run() {
                    ((UgenLottieView) tt.this.n).c(iVar.t(), bitmapCreateScaledBitmap);
                }
            });
            return;
        }
        this.kz.put(str, 2);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
                this.mq = u(str2);
                break;
            case "scaleType":
                this.vi = t(str2);
                break;
            case "progress":
                this.w = com.byazt.cd.ve.c(str2, 0.0f);
                break;
            case "imagePath":
                this.cf = str2;
                break;
            case "autoReverse":
                this.ij = com.byazt.cd.ve.c(str2, false);
                break;
            case "md5":
                this.yo = str2;
                break;
            case "src":
                this.c = str2;
                break;
            case "loop":
                if (h()) {
                    this.is = com.byazt.cd.ve.c(str2, 0);
                    break;
                } else {
                    this.az = com.byazt.cd.ve.c(str2, false);
                    break;
                }
                break;
            case "speed":
                this.nl = com.byazt.cd.ve.c(str2, 1.0f);
                break;
            case "autoPlay":
                this.jt = com.byazt.cd.ve.c(str2, false);
                break;
            case "autoplay":
                this.jt = com.byazt.cd.ve.c(str2, true);
                break;
        }
    }

    public void c(AnimatorListenerAdapter animatorListenerAdapter) {
        ((UgenLottieView) this.n).c(animatorListenerAdapter);
    }
}
