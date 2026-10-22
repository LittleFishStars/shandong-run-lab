package com.kc.dw.platform.ad_adapter.recycler;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.domain.LayoutBean;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.d0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Hashtable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class g extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39491a;
    public final Context b;
    public final ImageView c;
    public final LayoutBean.StyleBean d;
    public final RelativeLayout e;
    public final i f;

    @Keep
    public class a extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f39492a;
        public final g b;

        public a(g gVar, Bitmap bitmap) {
            this.b = gVar;
            this.f39492a = bitmap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            if (this.f39492a != null) {
                Integer accept_ad_width = ((RecyclerMixCommonAdLoader) this.b.f.b.getAdLoader()).getAccept_ad_width();
                Integer accept_ad_height = ((RecyclerMixCommonAdLoader) this.b.f.b.getAdLoader()).getAccept_ad_height();
                Bitmap.Config config = this.f39492a.getConfig();
                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                Bitmap bitmapCopy = config == config2 ? this.f39492a : this.f39492a.copy(config2, true);
                if (bitmapCopy != null) {
                    this.b.b.getApplicationContext();
                    Bitmap bitmapA = d0.a(bitmapCopy, 25);
                    if (bitmapA != null) {
                        int width = this.f39492a.getWidth();
                        int height = this.f39492a.getHeight();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.c.getLayoutParams();
                        if (accept_ad_width != null && accept_ad_width.intValue() > 0) {
                            accept_ad_width.intValue();
                        }
                        if (accept_ad_height != null && accept_ad_height.intValue() > 0) {
                            height = accept_ad_height.intValue();
                        }
                        LayoutBean.StyleBean styleBean = this.b.d;
                        if (styleBean != null && (styleBean.getType() == 201 || this.b.d.getType() == 101 || this.b.d.getType() == 601)) {
                            if ((width * 1.0f) / height >= 1.77d || accept_ad_height == null || accept_ad_height.intValue() != -1) {
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.b.e.getLayoutParams();
                                layoutParams2.width = -1;
                                layoutParams2.height = -2;
                                this.b.e.setLayoutParams(layoutParams2);
                            } else {
                                height = (int) Math.round(((double) this.b.b.getResources().getDisplayMetrics().widthPixels) / 1.77d);
                                int iRound = (int) Math.round(((double) height) * 1.77d);
                                layoutParams.width = -1;
                                layoutParams.height = height;
                                layoutParams.addRule(14);
                                this.b.c.setLayoutParams(layoutParams);
                                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.b.e.getLayoutParams();
                                layoutParams3.width = -1;
                                layoutParams3.height = height;
                                this.b.e.setLayoutParams(layoutParams3);
                                ((NormalMediaView) this.b.f.f39495a.getMediaView()).setContainerWidth(iRound);
                                ((NormalMediaView) this.b.f.f39495a.getMediaView()).setContainerHeight(height);
                                ((NormalMediaView) this.b.f.f39495a.getMediaView()).R = true;
                            }
                        }
                        LayoutBean.StyleBean styleBean2 = this.b.d;
                        if (styleBean2 != null && ((styleBean2.getType() == 301 || this.b.d.getType() == 401) && (width * 1.0f) / height < 1.77d && accept_ad_height != null && accept_ad_height.intValue() == -1)) {
                            ((NormalMediaView) this.b.f.f39495a.getMediaView()).R = true;
                        }
                        this.b.c.setImageBitmap(bitmapA);
                    }
                }
            }
            this.b.e.setVisibility(0);
        }
    }

    public g(i iVar, String str, Context context, ImageView imageView, LayoutBean.StyleBean styleBean, RelativeLayout relativeLayout) {
        this.f = iVar;
        this.f39491a = str;
        this.b = context;
        this.c = imageView;
        this.d = styleBean;
        this.e = relativeLayout;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        Bitmap frameAtTime;
        try {
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.f39491a, new Hashtable());
                frameAtTime = mediaMetadataRetriever.getFrameAtTime();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                frameAtTime = null;
            }
            SdkHandler.getInstance().runOnUiThread(new a(this, frameAtTime));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
