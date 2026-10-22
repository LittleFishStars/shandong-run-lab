package com.byazt.oq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.ga.i;
import com.byazt.ga.uj;
import com.byazt.ga.ve;
import com.byazt.yj.da;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.zj.adlib.v39;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2278})
public class DynamicLottieView extends LottieAnimationView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28899a;
    public Map<String, Bitmap> c;
    public int n;
    public int sp;
    public String tt;
    public boolean uj;
    public boolean ve;
    public Map<String, String> x;

    public DynamicLottieView(Context context) {
        super(context);
        this.c = new HashMap();
    }

    private void da() {
        setImageAssetDelegate(new uj() { // from class: com.byazt.oq.DynamicLottieView.3
            @Override // com.byazt.ga.uj
            public Bitmap c(final i iVar) {
                if (iVar == null) {
                    return null;
                }
                final String strYp = iVar.yp();
                String strU = iVar.u();
                if (TextUtils.isEmpty(strYp) || !TextUtils.isEmpty(strU)) {
                    if (!TextUtils.isEmpty(strU) && TextUtils.isEmpty(strYp)) {
                        strYp = strU;
                    } else if (TextUtils.isEmpty(strU) || TextUtils.isEmpty(strYp)) {
                        strYp = "";
                    } else {
                        strYp = strYp + strU;
                    }
                }
                if (TextUtils.isEmpty(strYp)) {
                    return null;
                }
                Bitmap bitmap = DynamicLottieView.this.c == null ? null : (Bitmap) DynamicLottieView.this.c.get(strYp);
                if (bitmap != null) {
                    return bitmap;
                }
                com.byazt.mf.c.c().n().from(strYp).converter(new da() { // from class: com.byazt.oq.DynamicLottieView.3.2
                    @Override // com.byazt.yj.da
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, iVar.c(), iVar.tt(), false);
                        if (DynamicLottieView.this.c != null) {
                            DynamicLottieView.this.c.put(strYp, bitmapCreateScaledBitmap);
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }).to(new gr<Bitmap>() { // from class: com.byazt.oq.DynamicLottieView.3.1
                    @Override // com.byazt.yj.gr
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.yj.gr
                    public void onSuccess(m<Bitmap> mVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(mVar.getResult(), iVar.c(), iVar.tt(), false);
                        if (DynamicLottieView.this.c != null) {
                            DynamicLottieView.this.c.put(strYp, bitmapCreateScaledBitmap);
                        }
                        DynamicLottieView.this.c(iVar.t(), bitmapCreateScaledBitmap);
                    }
                });
                if (DynamicLottieView.this.c == null) {
                    return null;
                }
                return (Bitmap) DynamicLottieView.this.c.get(strYp);
            }
        });
        setAnimationFromUrl(this.tt);
        c();
    }

    private void i() {
        setImageAssetDelegate(new uj() { // from class: com.byazt.oq.DynamicLottieView.1
            @Override // com.byazt.ga.uj
            public Bitmap c(final i iVar) {
                final String strU = iVar.u();
                strU.hashCode();
                switch (strU) {
                    case "{appIcon}":
                        if (DynamicLottieView.this.x != null) {
                            strU = (String) DynamicLottieView.this.x.get(RemoteMessageConst.Notification.ICON);
                            break;
                        }
                        break;
                    case "{adImage}":
                    case "{slot}":
                        if (DynamicLottieView.this.x != null) {
                            strU = (String) DynamicLottieView.this.x.get("imageUrl");
                            break;
                        }
                        break;
                }
                Bitmap bitmap = (Bitmap) DynamicLottieView.this.c.get(strU);
                if (bitmap != null) {
                    return bitmap;
                }
                com.byazt.mf.c.c().n().from(strU).type(2).converter(new da() { // from class: com.byazt.oq.DynamicLottieView.1.2
                    @Override // com.byazt.yj.da
                    public Bitmap coverterTo(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, iVar.c(), iVar.tt(), false);
                        DynamicLottieView.this.c.put(strU, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                }).to(new gr<Bitmap>() { // from class: com.byazt.oq.DynamicLottieView.1.1
                    @Override // com.byazt.yj.gr
                    public void onFailed(int i, String str, Throwable th) {
                    }

                    @Override // com.byazt.yj.gr
                    public void onSuccess(m<Bitmap> mVar) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(mVar.getResult(), iVar.c(), iVar.tt(), false);
                        DynamicLottieView.this.c.put(strU, bitmapCreateScaledBitmap);
                        DynamicLottieView.this.c(iVar.t(), bitmapCreateScaledBitmap);
                    }
                });
                return (Bitmap) DynamicLottieView.this.c.get(strU);
            }
        });
        setAnimationFromUrl("https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/static/lotties/" + this.tt + ".json");
        if (this.x != null) {
            gt gtVar = new gt(this);
            String str = this.x.get("app_name");
            String str2 = this.x.get("description");
            String str3 = this.x.get("title");
            if (this.n > 0 && str.length() > this.n) {
                str = str.substring(0, this.n - 1) + v39.CHARACTER_ELLIPSIZE;
            } else if (this.n <= 0) {
                str = "";
            }
            if (this.f28899a > 0 && str3.length() > this.f28899a) {
                str3 = str3.substring(0, this.f28899a - 1) + v39.CHARACTER_ELLIPSIZE;
            } else if (this.n <= 0) {
                str3 = "";
            }
            if (this.sp > 0 && str2.length() > this.sp) {
                str2 = str2.substring(0, this.sp - 1) + v39.CHARACTER_ELLIPSIZE;
            } else if (this.n <= 0) {
                str2 = "";
            }
            gtVar.tt("{appName}", str);
            gtVar.tt("{adTitle}", str3);
            gtVar.tt("{adDesc}", str2);
            setTextDelegate(gtVar);
            setFontAssetDelegate(new ve() { // from class: com.byazt.oq.DynamicLottieView.2
                @Override // com.byazt.ga.ve
                public Typeface c(String str4) {
                    return Typeface.MONOSPACE;
                }

                @Override // com.byazt.ga.ve
                public String tt(String str4) {
                    return null;
                }
            });
        }
        c();
    }

    @Override // com.byazt.ga.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        x();
    }

    @Override // com.byazt.ga.LottieAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        a();
    }

    public void setAnimationsLoop(boolean z) {
        this.ve = z;
    }

    public void setData(Map<String, String> map) {
        this.x = map;
    }

    public void setImageLottieTosPath(String str) {
        this.tt = str;
    }

    public void setLottieAdDescMaxLength(int i) {
        this.sp = i;
    }

    public void setLottieAdTitleMaxLength(int i) {
        this.f28899a = i;
    }

    public void setLottieAppNameMaxLength(int i) {
        this.n = i;
    }

    public void setOnlyLoadNetImage(boolean z) {
        this.uj = z;
    }

    public void x() {
        if (TextUtils.isEmpty(this.tt)) {
            return;
        }
        setProgress(0.0f);
        c(this.ve);
        if (this.uj) {
            da();
        } else {
            i();
        }
    }
}
