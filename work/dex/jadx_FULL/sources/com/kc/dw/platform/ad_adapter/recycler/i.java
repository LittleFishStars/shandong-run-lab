package com.kc.dw.platform.ad_adapter.recycler;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.utils.Consts;
import com.google.gson.Gson;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.recycler.ExpressMediaListener;
import com.kc.dw.core.ad.recycler.FeedInteractionListener;
import com.kc.dw.core.ad.recycler.NativeAdMediaListener;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.domain.LayoutBean;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.router.log.bean.CodeMsg;
import com.kc.dw.core.router.log.bean.LoadResState;
import com.kc.dw.core.router.log.bean.TypeMsg;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.d0;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.h0;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.z;
import com.kc.dw.core.view.DownloadView;
import com.kc.dw.core.view.PositionView;
import com.kc.dw.core.view.RoundImageView;
import com.kc.dw.core.view.ShakeImageView;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.platform.ad_adapter.splash.ShakeUtil;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i extends MsCustomRecyclerExpressAd {
    public static int G = 250;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.ad.nativ.d f39495a;
    public com.kc.dw.platform.ad_adapter.recycler.e b;
    public RelativeLayout c;
    public ViewGroup d;
    public int e;
    public ExpressMediaListener h;
    public int i;
    public boolean j;
    public boolean k;
    public int l;
    public float m;
    public float n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public FrameLayout s;
    public long t;
    public boolean u;
    public FrameLayout v;
    public int w;
    public int x;
    public boolean y;
    public int f = 0;
    public boolean g = false;
    public volatile boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public ViewTreeObserver.OnScrollChangedListener C = new g(this);
    public int D = 0;
    public boolean E = true;
    public ViewTreeObserver.OnScrollChangedListener F = new j(this);

    @Keep
    public class a implements NativeAdMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f39496a;

        public a(i iVar) {
            this.f39496a = iVar;
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoCompleted() {
            ExpressMediaListener expressMediaListener = this.f39496a.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoCompleted();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoError() {
            ExpressMediaListener expressMediaListener = this.f39496a.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoError(-1, "视频加载出错");
            }
            this.f39496a.a(-1, "视频加载出错");
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoLoaded() {
            LogUtil.d("i", "onVideoLoaded");
            ExpressMediaListener expressMediaListener = this.f39496a.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoLoaded();
            }
            this.f39496a.d();
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoPause() {
            ExpressMediaListener expressMediaListener = this.f39496a.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoPause();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoResume() {
            ExpressMediaListener expressMediaListener = this.f39496a.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoResume();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.NativeAdMediaListener
        public void onVideoStart() {
            ExpressMediaListener expressMediaListener = this.f39496a.h;
            if (expressMediaListener != null) {
                expressMediaListener.onVideoStart();
            }
        }
    }

    @Keep
    public class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RoundImageView f39497a;
        public final Context b;
        public final float c;
        public final ImageView d;
        public final i e;

        public b(i iVar, RoundImageView roundImageView, Context context, float f, ImageView imageView) {
            this.e = iVar;
            this.f39497a = roundImageView;
            this.b = context;
            this.c = f;
            this.d = imageView;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            this.e.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            int iDip2px;
            int i;
            try {
                if (!httpResponse.isSuccessful()) {
                    this.e.a(httpResponse.getErrorCode(), httpResponse.getErrorDescription());
                    return;
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    this.e.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
                    return;
                }
                if (responseBody.length >= h0.a()) {
                    this.e.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
                    return;
                }
                com.kc.dw.core.service.logrecord.a.a(5, "s4", this.e.b, new LoadResState().setSuccess(1, i.c(this.e) ? 2 : 1, 0));
                if (i.a(this.e, responseBody)) {
                    RoundImageView roundImageView = this.f39497a;
                    if (roundImageView != null) {
                        roundImageView.setBytes(responseBody);
                        int gifWidth = this.f39497a.getGifWidth();
                        int gifHeight = this.f39497a.getGifHeight();
                        iDip2px = this.e.b.getAdLoader() instanceof RecyclerMixCommonAdLoader ? (int) DimensionUtils.dip2px(this.b, ((RecyclerMixCommonAdLoader) this.e.b.getAdLoader()).getAdSlot().getFixedHeight()) : 0;
                        LogUtil.i("i", "fixedHeight=" + iDip2px);
                        int i2 = (int) (this.c * 75.0f);
                        if (iDip2px > 0) {
                            i = (gifWidth * iDip2px) / gifHeight;
                        } else {
                            i = (gifWidth * i2) / gifHeight;
                            iDip2px = i2;
                        }
                        ViewGroup.LayoutParams layoutParams = this.f39497a.getLayoutParams();
                        layoutParams.width = i;
                        layoutParams.height = iDip2px;
                        this.f39497a.setLayoutParams(layoutParams);
                        this.f39497a.startAnimation();
                        this.e.f39495a.a().D = System.currentTimeMillis();
                    }
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray == null) {
                        this.e.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
                        return;
                    }
                    this.e.f39495a.a().D = System.currentTimeMillis();
                    iDip2px = this.e.b.getAdLoader() instanceof RecyclerMixCommonAdLoader ? (int) DimensionUtils.dip2px(this.b, ((RecyclerMixCommonAdLoader) this.e.b.getAdLoader()).getAdSlot().getFixedHeight()) : 0;
                    LogUtil.i("i", "fixedHeight=" + iDip2px);
                    int i3 = (int) (this.c * 75.0f);
                    if (iDip2px <= 0) {
                        int width = (bitmapDecodeByteArray.getWidth() * i3) / bitmapDecodeByteArray.getHeight();
                        iDip2px = i3;
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.f39497a.getLayoutParams();
                    layoutParams2.height = iDip2px;
                    this.f39497a.setLayoutParams(layoutParams2);
                    this.f39497a.setImageBitmap(bitmapDecodeByteArray);
                    Bitmap bitmapA = d0.a(bitmapDecodeByteArray, 25);
                    if (bitmapA != null) {
                        this.d.setLayoutParams(layoutParams2);
                        this.d.setImageBitmap(bitmapA);
                    }
                }
                i iVar = this.e;
                if (iVar.g) {
                    return;
                }
                iVar.g = true;
                i.d(this.e);
            } catch (Throwable th) {
                th.printStackTrace();
                this.e.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
            }
        }
    }

    @Keep
    public class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RoundImageView f39498a;
        public final i b;

        public c(i iVar, RoundImageView roundImageView) {
            this.b = iVar;
            this.f39498a = roundImageView;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
        }

        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            try {
                if (!httpResponse.isSuccessful()) {
                    this.b.a(httpResponse.getErrorCode(), httpResponse.getErrorDescription());
                    return;
                }
                try {
                    byte[] responseBody = httpResponse.getResponseBody();
                    if (responseBody == null || responseBody.length <= 0) {
                        this.b.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
                        return;
                    }
                    if (responseBody.length >= h0.a()) {
                        this.b.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
                        return;
                    }
                    if (i.a(this.b, responseBody)) {
                        RoundImageView roundImageView = this.f39498a;
                        if (roundImageView != null) {
                            roundImageView.setBytes(responseBody);
                            this.f39498a.startAnimation();
                            this.f39498a.getGifHeight();
                        }
                    } else {
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray == null) {
                            this.b.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
                            return;
                        } else {
                            bitmapDecodeByteArray.getHeight();
                            this.f39498a.setImageBitmap(bitmapDecodeByteArray);
                        }
                    }
                    i iVar = this.b;
                    if (iVar.g) {
                        return;
                    }
                    iVar.g = true;
                    com.kc.dw.core.service.logrecord.a.a(5, "s4", this.b.b, new LoadResState().setSuccess(1, i.c(this.b) ? 2 : 1, 0));
                    i.d(this.b);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                this.b.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
            }
        }
    }

    @Keep
    public class d implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RoundImageView f39499a;
        public final int b;
        public final ImageView c;
        public final ImageView d;
        public final TextView e;
        public final TextView f;
        public final ViewGroup g;
        public final boolean h;
        public final i i;

        public d(i iVar, RoundImageView roundImageView, int i, Context context, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, ViewGroup viewGroup, boolean z) {
            this.i = iVar;
            this.f39499a = roundImageView;
            this.b = i;
            this.c = imageView;
            this.d = imageView2;
            this.e = textView;
            this.f = textView2;
            this.g = viewGroup;
            this.h = z;
        }

        @Override // com.kc.dw.core.utils.x
        public void onFailure(IOException iOException) {
            this.i.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.kc.dw.core.utils.x
        public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
            String str;
            try {
                if (!httpResponse.isSuccessful()) {
                    this.i.a(httpResponse.getErrorCode(), httpResponse.getErrorDescription());
                    return;
                }
                byte[] responseBody = httpResponse.getResponseBody();
                if (responseBody == null || responseBody.length <= 0) {
                    this.i.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
                    return;
                }
                if (responseBody.length >= h0.a()) {
                    this.i.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
                    return;
                }
                com.kc.dw.core.service.logrecord.a.a(5, "s4", this.i.b, new LoadResState().setSuccess(1, i.c(this.i) ? 2 : 1, 0));
                LogUtil.d("i", "showUpDownStyle");
                if (i.a(this.i, responseBody)) {
                    RoundImageView roundImageView = this.f39499a;
                    if (roundImageView != null) {
                        roundImageView.setBytes(responseBody);
                        int gifHeight = (this.b * this.f39499a.getGifHeight()) / this.f39499a.getGifWidth();
                        Integer accept_ad_height = ((RecyclerMixCommonAdLoader) this.i.b.getAdLoader()).getAccept_ad_height();
                        if (accept_ad_height != null && accept_ad_height.intValue() > 0) {
                            gifHeight = accept_ad_height.intValue();
                        }
                        try {
                            if ((this.b * 1.0f) / gifHeight < 1.77d && accept_ad_height != null && accept_ad_height.intValue() == -1) {
                                gifHeight = (int) Math.round(((double) this.b) / 1.77d);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        ViewGroup.LayoutParams layoutParams = this.f39499a.getLayoutParams();
                        layoutParams.width = -1;
                        layoutParams.height = gifHeight;
                        this.f39499a.setLayoutParams(layoutParams);
                        this.f39499a.startAnimation();
                    }
                } else {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray == null) {
                        this.i.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载失败");
                        return;
                    }
                    int height = (this.b * bitmapDecodeByteArray.getHeight()) / bitmapDecodeByteArray.getWidth();
                    Integer accept_ad_height2 = ((RecyclerMixCommonAdLoader) this.i.b.getAdLoader()).getAccept_ad_height();
                    if (accept_ad_height2 != null && accept_ad_height2.intValue() > 0) {
                        height = accept_ad_height2.intValue();
                    }
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f39499a.getLayoutParams();
                    try {
                        if ((this.b * 1.0f) / height < 1.77d && accept_ad_height2 != null && accept_ad_height2.intValue() == -1) {
                            height = (int) Math.round(((double) this.b) / 1.77d);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    layoutParams2.width = -1;
                    layoutParams2.height = height;
                    layoutParams2.addRule(14);
                    this.f39499a.setLayoutParams(layoutParams2);
                    this.f39499a.setImageBitmap(bitmapDecodeByteArray);
                    Bitmap bitmapA = d0.a(bitmapDecodeByteArray, 25);
                    if (bitmapA != null) {
                        this.c.setLayoutParams(layoutParams2);
                        this.c.setImageBitmap(bitmapA);
                    }
                }
                this.i.f39495a.a().D = System.currentTimeMillis();
                if ((this.i.f39495a.a().getAct_type() & 4) == 4 || (this.i.f39495a.a().getAct_type() & 64) == 64) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    TextView textView = this.f;
                    if (textView != null) {
                        textView.setText("摇一摇");
                    }
                    str = "摇动或点击";
                } else if (com.kc.dw.core.utils.h.e(this.i.f39495a.a().getAct_type())) {
                    this.d.setVisibility(0);
                    this.e.setVisibility(0);
                    TextView textView2 = this.f;
                    if (textView2 != null) {
                        textView2.setText("扭一扭");
                    }
                    str = "扭动或点击";
                } else {
                    ViewGroup viewGroup = this.g;
                    if (viewGroup != null && !this.h) {
                        viewGroup.setVisibility(0);
                        this.d.setImageResource(R.drawable.ssd_ic_right);
                        this.d.setVisibility(0);
                        this.e.setVisibility(0);
                    }
                    str = "点击";
                }
                this.e.setText(str + (this.i.f39495a.a().getInteractionType() == 1 ? "立即下载" : "查看详情"));
                i iVar = this.i;
                if (iVar.g) {
                    return;
                }
                iVar.g = true;
                i.d(this.i);
            } catch (Throwable th) {
                th.printStackTrace();
                this.i.a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
            }
        }
    }

    @Keep
    public class e extends com.kc.dw.core.safe.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f39500a;
        public final i b;

        public e(i iVar, View view) {
            this.b = iVar;
            this.f39500a = view;
        }

        @Override // com.kc.dw.core.safe.m
        public void safeOnClick(View view) {
            this.b.callAdClosed();
            View view2 = this.f39500a;
            if (view2 != null && view2.getParent() != null && (this.f39500a.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f39500a.getParent()).removeView(this.f39500a);
            }
            ShakeUtil.getInstance().a(this.b.i);
        }
    }

    @Keep
    public class f implements z.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f39501a;
        public final i b;

        public f(i iVar, Activity activity) {
            this.b = iVar;
            this.f39501a = activity;
        }

        @Override // com.kc.dw.core.utils.z.k
        public void fail() {
            if (!TextUtils.isEmpty(this.b.f39495a.a().getVideo_cover())) {
                com.kc.dw.ad.nativ.d dVar = this.b.f39495a;
                if (dVar instanceof com.kc.dw.ad.nativ.g) {
                    com.kc.dw.ad.nativ.g gVar = (com.kc.dw.ad.nativ.g) dVar;
                    gVar.f39131a = 1;
                    gVar.c = new String[]{dVar.a().getVideo_cover()};
                    if (this.b.a(this.f39501a)) {
                        this.b.a(9000001, "广告渲染异常");
                        return;
                    }
                    return;
                }
            }
            this.b.a(com.kc.dw.core.exception.b.c.intValue(), "素材加载错误");
        }

        @Override // com.kc.dw.core.utils.z.k
        public void success() {
            if (this.b.a(this.f39501a)) {
                this.b.a(9000001, "广告渲染异常");
            }
        }
    }

    @Keep
    public class g implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f39502a;

        public g(i iVar) {
            this.f39502a = iVar;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x003e A[Catch: Exception -> 0x004a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004a, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0012, B:8:0x0025, B:10:0x002b, B:12:0x002e, B:14:0x0032, B:15:0x003e), top: B:21:0x0000 }] */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                FrameLayout frameLayout = this.f39502a.v;
                if (frameLayout != null) {
                    int[] iArr = new int[2];
                    frameLayout.getLocationOnScreen(iArr);
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int width = this.f39502a.v.getWidth();
                    int height = this.f39502a.v.getHeight();
                    if (width + i > 0) {
                        i iVar = this.f39502a;
                        if (i >= iVar.w || height + i2 <= 0 || i2 >= iVar.x) {
                            ShakeUtil.getInstance().a(this.f39502a.i, false);
                        } else {
                            ShakeUtil.getInstance().a(this.f39502a.i, true);
                        }
                    } else {
                        ShakeUtil.getInstance().a(this.f39502a.i, false);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public class h implements TouchAdContainer.OnWindownEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f39503a;

        public h(i iVar) {
            this.f39503a = iVar;
        }

        @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
        public void onAttachedToWindow() {
            ShakeUtil.getInstance().a(this.f39503a.i, true);
            try {
                this.f39503a.v.getViewTreeObserver().removeOnScrollChangedListener(this.f39503a.C);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
        public void onDetachedFromWindow() {
            ShakeUtil.getInstance().a(this.f39503a.i, false);
        }

        @Override // com.kc.dw.core.view.TouchAdContainer.OnWindownEventListener
        public void onWindowFocusChanged(boolean z) {
            ShakeUtil shakeUtil;
            int i;
            boolean z2;
            if (z) {
                shakeUtil = ShakeUtil.getInstance();
                i = this.f39503a.i;
                z2 = true;
            } else {
                shakeUtil = ShakeUtil.getInstance();
                i = this.f39503a.i;
                z2 = false;
            }
            shakeUtil.a(i, z2);
        }
    }

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.recycler.i$i, reason: collision with other inner class name */
    @Keep
    public class ViewTreeObserverOnPreDrawListenerC1071i implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TouchAdContainer f39504a;
        public final Rect b;
        public final i c;

        public ViewTreeObserverOnPreDrawListenerC1071i(i iVar, TouchAdContainer touchAdContainer, Rect rect) {
            this.c = iVar;
            this.f39504a = touchAdContainer;
            this.b = rect;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!this.f39504a.getGlobalVisibleRect(this.b)) {
                return true;
            }
            if (((long) this.b.height()) * ((long) this.b.width()) >= ((long) this.f39504a.getHeight()) * ((long) this.f39504a.getWidth()) * 0.3d) {
                this.c.u = true;
                this.c.f39495a.a().setMonitorUrl(g0.a(this.c.f39495a.a().getMonitorUrl(), this.f39504a, (View) null));
                i iVar = this.c;
                if (iVar.j && iVar.f39495a.getAdPatternType() == 2) {
                    i.a(this.c);
                    i.b(this.c);
                } else {
                    i.d(this.c);
                }
                this.f39504a.getViewTreeObserver().removeOnPreDrawListener(this);
            }
            return true;
        }
    }

    @Keep
    public class j implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f39505a;

        public j(i iVar) {
            this.f39505a = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                if (s1.a(((RecyclerMixCommonAdLoader) this.f39505a.b.getAdLoader()).getPosId(), this.f39505a.f39495a.a().getAdp(), this.f39505a.f39495a.a().getAdg())) {
                    int[] iArr = new int[2];
                    this.f39505a.s.getLocationOnScreen(iArr);
                    int i = iArr[1];
                    if (i > 0) {
                        i iVar = this.f39505a;
                        if (iVar.l == 0 && iVar.m > 0.0f && iVar.n > 0.0f) {
                            iVar.l = i;
                            iVar.D = i;
                        }
                    }
                    i iVar2 = this.f39505a;
                    if (iVar2.E) {
                        iVar2.D = i;
                        iVar2.E = false;
                        return;
                    }
                    int iAbs = Math.abs(i - iVar2.D);
                    if (iAbs > 5) {
                        i iVar3 = this.f39505a;
                        iVar3.r += iAbs;
                        iVar3.D = i;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Keep
    public class k implements RecylcerAdInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f39506a;
        public final List b;
        public final i c;

        public k(i iVar, Context context, List list) {
            this.c = iVar;
            this.f39506a = context;
            this.b = list;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public void onAdClicked() {
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public void onAdClosed() {
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener, com.kc.dw.core.loader.InteractionListener
        public void onAdExposure() {
            this.c.j = true;
            i iVar = this.c;
            if (iVar.u) {
                i.a(iVar);
                i.b(this.c);
            }
            i iVar2 = this.c;
            Context context = this.f39506a;
            List<View> list = this.b;
            iVar2.getClass();
            try {
                com.kc.dw.ad.nativ.d dVar = iVar2.f39495a;
                dVar.a(context, iVar2.c, list, new com.kc.dw.platform.ad_adapter.recycler.f(dVar, new o(iVar2)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.core.ad.recycler.RecylcerAdInteractionListener
        public void onAdRenderFailed() {
        }
    }

    public i(com.kc.dw.platform.ad_adapter.recycler.e eVar, com.kc.dw.ad.nativ.d dVar) {
        this.b = eVar;
        this.f39495a = dVar;
        if (this.i == 0) {
            this.i = ShakeUtil.getInstance().b();
        }
        try {
            AdType adType = AdType.FEED_MIX;
            adType.value();
            com.kc.dw.core.utils.h.a();
            this.f39495a.a().setAct_type(com.kc.dw.core.utils.h.a(this.f39495a.a().getAct_type(), adType.value()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (dVar.a().getPower_index() > 0) {
            G = dVar.a().getPower_index() * 5;
        }
    }

    public static void a(i iVar) {
        iVar.getClass();
        try {
            if (iVar.y) {
                return;
            }
            iVar.y = true;
            iVar.callAdExposure();
            try {
                iVar.b.f.onADExposure();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            iVar.f39495a.a().B = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(i iVar, TouchAdContainer touchAdContainer, float f2, float f3, long j2, float f4, float f5, int i) {
        iVar.getClass();
        try {
            if (iVar.q || !iVar.f39495a.a().B) {
                return;
            }
            iVar.q = true;
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.kc.dw.core.utils.r.a().b(((RecyclerMixCommonAdLoader) iVar.b.getAdLoader()).getPosId() + "_adp", jCurrentTimeMillis);
            com.kc.dw.core.utils.r.a().b("adg_time", jCurrentTimeMillis);
            iVar.f39495a.a().setClkActType(512);
            iVar.f39495a.a().setClkPower(i);
            com.kc.dw.platform.ad_adapter.recycler.b.a(iVar.f39495a, f2, f3, j2, f4, f5);
            iVar.c();
            com.kc.dw.core.utils.f.a((com.kc.dw.platform.ad_adapter.c) iVar.f39495a, false);
            try {
                iVar.s.getViewTreeObserver().removeOnScrollChangedListener(iVar.F);
            } catch (Exception unused) {
            }
            try {
                touchAdContainer.removeView(iVar.s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static boolean a(i iVar, byte[] bArr) {
        iVar.getClass();
        try {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 0, bArr2, 0, 4);
            return new BigInteger(1, bArr2).toString(16).startsWith("47494638");
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(i iVar) {
        if (com.kc.dw.core.utils.h.c(iVar.f39495a.a().getAct_type()) && iVar.f39495a.getAdPatternType() == 2) {
            int iB = com.kc.dw.core.utils.h.b(iVar.f39495a.a().getAct_type());
            iVar.e();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ShakeUtil.getInstance().a(iVar.f39495a.a().getPosId(), iVar.f39495a.a().getLoadedTime(), iVar.f39495a.a().getDclk());
            ShakeUtil.getInstance().a(iVar.f39495a.a().getPower_index2(), iVar.f39495a.a().getPower_index(), iB, iVar.f39495a.a().getPower_delay(), iVar.f39495a.a().getPower_count(), iVar.i, iVar.f39495a.a().getEcpm(), new p(iVar, jCurrentTimeMillis));
            ShakeUtil.getInstance().a(true);
        }
    }

    public static boolean c(i iVar) {
        iVar.getClass();
        try {
            return !TextUtils.isEmpty(iVar.f39495a.getImgUrls()[0]) && iVar.f39495a.getImgUrls()[0].equals(iVar.f39495a.a().getVideo_cover());
        } catch (Exception unused) {
            return false;
        }
    }

    public static void d(i iVar) {
        if (iVar.g) {
            iVar.d();
        }
        if (!iVar.j && iVar.g && iVar.u) {
            iVar.j = true;
            if (iVar.getAdView() != null) {
                for (int i = 0; i < iVar.f39495a.a().getClickUrl().length; i++) {
                    try {
                        int width = iVar.getAdView().getWidth();
                        int height = iVar.getAdView().getHeight();
                        if (width > 0 && height > 0) {
                            iVar.f39495a.a().getClickUrl()[i] = g0.a(iVar.f39495a.a().getClickUrl()[i], width, height);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            if (iVar.b.f != null && iVar.f39495a.getAdPatternType() != 2) {
                com.kc.dw.ad.nativ.i iVarA = iVar.f39495a.a();
                String[] monitorUrl = iVar.f39495a.a().getMonitorUrl();
                StringBuilder sb = new StringBuilder();
                sb.append(iVar.f39495a.a().C);
                sb.append(Consts.DOT);
                iVar.f39495a.a().getClass();
                sb.append(0L);
                sb.append(Consts.DOT);
                sb.append(iVar.f39495a.a().D);
                iVarA.setMonitorUrl(g0.b(monitorUrl, sb.toString()));
                iVar.b.f.onADExposure();
                iVar.callAdExposure();
                iVar.f39495a.a().B = true;
            }
            if (!com.kc.dw.core.utils.h.c(iVar.f39495a.a().getAct_type()) || iVar.f39495a.getAdPatternType() == 2) {
                return;
            }
            int iB = com.kc.dw.core.utils.h.b(iVar.f39495a.a().getAct_type());
            iVar.e();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ShakeUtil.getInstance().a(iVar.f39495a.a().getPosId(), iVar.f39495a.a().getLoadedTime(), iVar.f39495a.a().getDclk());
            ShakeUtil.getInstance().a(iVar.f39495a.a().getPower_index2(), iVar.f39495a.a().getPower_index(), iB, iVar.f39495a.a().getPower_delay(), iVar.f39495a.a().getPower_count(), iVar.i, iVar.f39495a.a().getEcpm(), new m(iVar, jCurrentTimeMillis));
            ShakeUtil.getInstance().a(true);
        }
    }

    public GradientDrawable a(List<Integer> list, int i, String str) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(-1);
            if (i > 0) {
                gradientDrawable.setStroke(i, Color.parseColor(str));
            }
            if (list != null && list.size() == 4) {
                gradientDrawable.setCornerRadii(new float[]{list.get(0).intValue(), list.get(0).intValue(), list.get(1).intValue(), list.get(1).intValue(), list.get(2).intValue(), list.get(2).intValue(), list.get(3).intValue(), list.get(3).intValue()});
            }
            return gradientDrawable;
        } catch (Exception unused) {
            return new GradientDrawable();
        }
    }

    public final void a(int i, String str) {
        try {
            callRenderError(i, str);
            SdkHandler.getInstance().runOnUiThread(new com.kc.dw.core.utils.q(this.f39495a.a().getErrorUrl(), i, str));
            g0.b(this.f39495a.a().getMonitorUrl());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        String str;
        TextView textView;
        TextView textView2;
        boolean zE = p0.e();
        this.A = true;
        int i5 = zE ? R.layout.ssd_item_pre_render_smallimage : R.layout.ssd_item_pre_render_smallimage_v2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f2 = displayMetrics.density;
        if (styleBean != null && styleBean.getType() == 401) {
            i5 = zE ? R.layout.ssd_item_pre_render_smallimage_left : R.layout.ssd_item_pre_render_smallimage_left_v2;
        }
        View viewInflate = View.inflate(context, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_rootView);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_imageview);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_videoContainer);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_small_iamge_imagebg);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_title);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_content);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_fromtext);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_shake_text);
        TextView textView7 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_close);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_smallimage_shake_image);
        TextView textView8 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        textView3.setText(this.f39495a.a().title);
        textView4.setText(this.f39495a.a().c);
        textView5.setText(this.f39495a.a().e);
        if (com.kc.dw.core.utils.h.d(this.f39495a.a().getAct_type())) {
            imageView3.setVisibility(0);
            if (textView8 != null) {
                str = "摇一摇";
                textView8.setText(str);
            }
        } else if (com.kc.dw.core.utils.h.e(this.f39495a.a().getAct_type())) {
            imageView3.setVisibility(0);
            if (textView8 != null) {
                str = "扭一扭";
                textView8.setText(str);
            }
        } else if (!zE) {
            imageView3.setImageResource(R.drawable.ssd_ic_right);
            imageView3.setVisibility(0);
        }
        String str2 = this.f39495a.a().getInteractionType() == 1 ? "立即下载" : "查看详情";
        if (textView6 != null) {
            textView6.setText(str2);
        }
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this.b);
        if (this.f39495a.getAdPatternType() == 2) {
            roundImageView.setVisibility(4);
            relativeLayout2.setVisibility(0);
            try {
                NormalMediaView normalMediaView = (NormalMediaView) this.f39495a.getMediaView();
                if (normalMediaView != null) {
                    normalMediaView.setDisplayMode(1);
                    normalMediaView.setContainerWidth(displayMetrics.density * 100.0f);
                    normalMediaView.setContainerHeight(displayMetrics.density * 75.0f);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            com.kc.dw.ad.nativ.d dVar = this.f39495a;
            this.b.getContext();
            dVar.a(relativeLayout2, new com.kc.dw.platform.ad_adapter.recycler.d((com.kc.dw.ad.nativ.i) this.b.f39477a, new a(this)), new com.kc.dw.core.service.logrecord.util.a(this.b, false));
            String str3 = this.f39495a.getImgUrls()[0];
            try {
                if (TextUtils.isEmpty(str3)) {
                    textView = textView5;
                    textView2 = textView4;
                } else {
                    ExecutorService executorService = f0.f39362a;
                    textView = textView5;
                    textView2 = textView4;
                    try {
                        f0.b.f39363a.a(new com.kc.dw.platform.ad_adapter.recycler.g(this, str3, context, imageView, styleBean, relativeLayout2));
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                textView = textView5;
                textView2 = textView4;
            }
        } else {
            textView = textView5;
            textView2 = textView4;
            relativeLayout2.setVisibility(8);
            roundImageView.setVisibility(0);
            c0.a(this.f39495a.getImgUrls()[0], new b(this, roundImageView, context, f2, imageView));
        }
        a(imageView2);
        a(textView7, viewInflate);
        if (zE && styleBean != null && (styleBean.getType() == 301 || styleBean.getType() == 401)) {
            a(styleBean, this.c, textView3, textView2, roundImageView, textView7, imageView2, textView, null);
        }
        if (zE) {
            return;
        }
        try {
            if (((com.kc.dw.ad.nativ.i) this.b.f39477a).getInteractionType() == 1) {
                return;
            }
            RelativeLayout relativeLayout3 = (RelativeLayout) this.c.findViewById(R.id.ms_item_pre_render_smallimage_app_logo_name);
            ViewGroup viewGroup = (ViewGroup) this.c.findViewById(R.id.ms_item_pre_render_smallimage_logo_layout);
            if (relativeLayout3 != null && viewGroup != null) {
                ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(15);
                relativeLayout3.addView(viewGroup, layoutParams);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void a(Context context, List<View> list) {
        if (this.f39495a.getAdPatternType() != 2) {
            try {
                com.kc.dw.ad.nativ.d dVar = this.f39495a;
                dVar.a(context, this.c, list, new com.kc.dw.platform.ad_adapter.recycler.f(dVar, new o(this)));
                return;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        com.kc.dw.ad.nativ.d dVar2 = this.f39495a;
        if (dVar2 instanceof com.kc.dw.ad.nativ.g) {
            com.kc.dw.ad.nativ.g gVar = (com.kc.dw.ad.nativ.g) dVar2;
            k kVar = new k(this, context, list);
            if (gVar.g.getVideoView() instanceof NormalMediaView) {
                ((NormalMediaView) gVar.g.getVideoView()).setOnExposureListener(kVar);
            }
        }
    }

    public final void a(ImageView imageView) {
        if (!TextUtils.isEmpty(this.f39495a.a().getFromLogo())) {
            new com.kc.dw.core.bquery.d(imageView).a(this.f39495a.a().getFromLogo());
        }
        imageView.setVisibility(com.kc.dw.base.a.adConfig().showLogo() ? 0 : 8);
    }

    public final void a(TextView textView, View view) {
        textView.setOnClickListener(new e(this, view));
    }

    public final void a(LayoutBean.StyleBean styleBean, RelativeLayout relativeLayout, TextView textView, TextView textView2, RoundImageView roundImageView, TextView textView3, ImageView imageView, TextView textView4, TextView textView5) {
        LayoutBean.StyleBean.BorderBean border;
        try {
            float f2 = this.b.getContext().getResources().getDisplayMetrics().density;
            if (styleBean.getContainer() != null && relativeLayout != null) {
                List<Integer> padding = styleBean.getContainer().getPadding();
                if (padding != null && padding.size() >= 4) {
                    relativeLayout.setPadding((int) (padding.get(3).intValue() * f2), (int) (padding.get(0).intValue() * f2), (int) (padding.get(1).intValue() * f2), (int) (padding.get(2).intValue() * f2));
                }
                LayoutBean.StyleBean.BorderBean border2 = styleBean.getContainer().getBorder();
                if (border2 != null && border2.getClip() && border2.getRadius() != null && border2.getRadius().size() >= 4) {
                    relativeLayout.setBackground(a(border2.getRadius(), 0, ""));
                }
            }
            if (styleBean.getTitle() != null && textView != null) {
                if (styleBean.getTitle().getMargin() != null && styleBean.getTitle().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
                    marginLayoutParams.topMargin = (int) (styleBean.getTitle().getMargin().get(0).intValue() * f2);
                    marginLayoutParams.rightMargin = (int) (styleBean.getTitle().getMargin().get(1).intValue() * f2);
                    marginLayoutParams.bottomMargin = (int) (styleBean.getTitle().getMargin().get(2).intValue() * f2);
                    marginLayoutParams.leftMargin = (int) (styleBean.getTitle().getMargin().get(3).intValue() * f2);
                    textView.setLayoutParams(marginLayoutParams);
                }
                if (styleBean.getTitle().getPadding() != null && styleBean.getTitle().getPadding().size() >= 4) {
                    textView.setPadding((int) (styleBean.getTitle().getPadding().get(3).intValue() * f2), (int) (styleBean.getTitle().getPadding().get(0).intValue() * f2), (int) (styleBean.getTitle().getPadding().get(1).intValue() * f2), (int) (styleBean.getTitle().getPadding().get(2).intValue() * f2));
                }
                if (styleBean.getTitle().getText() != null) {
                    if (!TextUtils.isEmpty(styleBean.getTitle().getText().getColor())) {
                        textView.setTextColor(Color.parseColor("#" + styleBean.getTitle().getText().getColor()));
                    }
                    if (styleBean.getTitle().getText().getSize() > 0) {
                        textView.setTextSize(styleBean.getTitle().getText().getSize());
                    }
                    if (styleBean.getTitle().getText().getLines() == 0) {
                        textView.setMaxLines(20);
                    } else {
                        textView.setMaxLines(styleBean.getTitle().getText().getLines());
                    }
                }
            }
            if (styleBean.getContent() != null && textView2 != null) {
                if (styleBean.getContent().getMargin() != null && styleBean.getContent().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) (styleBean.getContent().getMargin().get(0).intValue() * f2);
                    marginLayoutParams2.rightMargin = (int) (styleBean.getContent().getMargin().get(1).intValue() * f2);
                    marginLayoutParams2.bottomMargin = (int) (styleBean.getContent().getMargin().get(2).intValue() * f2);
                    marginLayoutParams2.leftMargin = (int) (styleBean.getContent().getMargin().get(3).intValue() * f2);
                    textView2.setLayoutParams(marginLayoutParams2);
                }
                if (styleBean.getContent().getPadding() != null && styleBean.getContent().getPadding().size() >= 4) {
                    textView2.setPadding((int) (styleBean.getContent().getPadding().get(3).intValue() * f2), (int) (styleBean.getContent().getPadding().get(0).intValue() * f2), (int) (styleBean.getContent().getPadding().get(1).intValue() * f2), (int) (styleBean.getContent().getPadding().get(2).intValue() * f2));
                }
                if (styleBean.getContent().getText() != null) {
                    if (!TextUtils.isEmpty(styleBean.getContent().getText().getColor())) {
                        textView2.setTextColor(Color.parseColor("#" + styleBean.getContent().getText().getColor()));
                    }
                    if (styleBean.getContent().getText().getSize() > 0) {
                        textView2.setTextSize(styleBean.getContent().getText().getSize());
                    }
                    if (styleBean.getContent().getText().getLines() == 0) {
                        textView.setMaxLines(20);
                    } else {
                        textView.setMaxLines(styleBean.getContent().getText().getLines());
                    }
                }
            }
            if (styleBean.getCreative() != null && roundImageView != null) {
                LayoutBean.StyleBean.BorderBean border3 = styleBean.getCreative().getBorder();
                if (border3 != null && border3.getClip() && border3.getRadius() != null && border3.getRadius().size() >= 4) {
                    roundImageView.setCornerTopLeftRadius((int) (border3.getRadius().get(0).intValue() * f2));
                    roundImageView.setCornerTopRightRadius((int) (border3.getRadius().get(1).intValue() * f2));
                    roundImageView.setCornerBottomRightRadius((int) (border3.getRadius().get(2).intValue() * f2));
                    roundImageView.setCornerBottomLeftRadius((int) (border3.getRadius().get(3).intValue() * f2));
                }
                if (styleBean.getCreative().getMargin() != null && styleBean.getCreative().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) roundImageView.getLayoutParams();
                    marginLayoutParams3.topMargin = (int) (styleBean.getCreative().getMargin().get(0).intValue() * f2);
                    marginLayoutParams3.rightMargin = (int) (styleBean.getCreative().getMargin().get(1).intValue() * f2);
                    marginLayoutParams3.bottomMargin = (int) (styleBean.getCreative().getMargin().get(2).intValue() * f2);
                    marginLayoutParams3.leftMargin = (int) (styleBean.getCreative().getMargin().get(3).intValue() * f2);
                    roundImageView.setLayoutParams(marginLayoutParams3);
                }
            }
            if (styleBean.getDislike() != null) {
                if (styleBean.getDislike().isHide()) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                }
                if (styleBean.getDislike().getText() != null) {
                    LayoutBean.StyleBean.TextBean text = styleBean.getDislike().getText();
                    if (text.getSize() > 0) {
                        textView3.setTextSize(text.getSize());
                    }
                    if (!TextUtils.isEmpty(text.getColor())) {
                        textView3.setTextColor(Color.parseColor("#" + text.getColor()));
                    }
                    if (text.getLines() > 0) {
                        textView3.setMaxLines(text.getLines());
                    }
                }
                if (styleBean.getDislike().getMargin() != null && styleBean.getDislike().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) textView3.getLayoutParams();
                    marginLayoutParams4.topMargin = (int) (styleBean.getDislike().getMargin().get(0).intValue() * f2);
                    marginLayoutParams4.rightMargin = (int) (styleBean.getDislike().getMargin().get(1).intValue() * f2);
                    marginLayoutParams4.bottomMargin = (int) (styleBean.getDislike().getMargin().get(2).intValue() * f2);
                    marginLayoutParams4.leftMargin = (int) (styleBean.getDislike().getMargin().get(3).intValue() * f2);
                    textView3.setLayoutParams(marginLayoutParams4);
                }
                List<Integer> padding2 = styleBean.getDislike().getPadding();
                if (padding2 != null && padding2.size() >= 4) {
                    textView3.setPadding((int) (padding2.get(3).intValue() * f2), (int) (padding2.get(0).intValue() * f2), (int) (padding2.get(1).intValue() * f2), (int) (padding2.get(2).intValue() * f2));
                }
                LayoutBean.StyleBean.BorderBean border4 = styleBean.getDislike().getBorder();
                if (border4 != null) {
                    textView3.setBackground(a(border4.getRadius(), styleBean.getDislike().getBorder().getSize(), "#" + styleBean.getDislike().getBorder().getColor()));
                }
            }
            if (styleBean.getLogo() != null) {
                if (styleBean.getLogo().isHide()) {
                    imageView.setVisibility(8);
                } else if (com.kc.dw.base.a.adConfig().showLogo()) {
                    imageView.setVisibility(0);
                }
                if (styleBean.getLogo().getMargin() != null && styleBean.getLogo().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                    marginLayoutParams5.topMargin = (int) (styleBean.getLogo().getMargin().get(0).intValue() * f2);
                    marginLayoutParams5.rightMargin = (int) (styleBean.getLogo().getMargin().get(1).intValue() * f2);
                    marginLayoutParams5.bottomMargin = (int) (styleBean.getLogo().getMargin().get(2).intValue() * f2);
                    marginLayoutParams5.leftMargin = (int) (styleBean.getLogo().getMargin().get(3).intValue() * f2);
                    imageView.setLayoutParams(marginLayoutParams5);
                }
            }
            if (styleBean.getSource() != null && textView4 != null) {
                if (styleBean.getSource().isHide()) {
                    textView4.setVisibility(8);
                } else {
                    textView4.setVisibility(0);
                }
                if (styleBean.getSource().getMargin() != null && styleBean.getSource().getMargin().size() >= 4) {
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
                    marginLayoutParams6.topMargin = (int) (styleBean.getSource().getMargin().get(0).intValue() * f2);
                    marginLayoutParams6.rightMargin = (int) (styleBean.getSource().getMargin().get(1).intValue() * f2);
                    marginLayoutParams6.bottomMargin = (int) (styleBean.getSource().getMargin().get(2).intValue() * f2);
                    marginLayoutParams6.leftMargin = (int) (styleBean.getSource().getMargin().get(3).intValue() * f2);
                    textView4.setLayoutParams(marginLayoutParams6);
                }
                List<Integer> padding3 = styleBean.getSource().getPadding();
                if (padding3 != null && padding3.size() >= 4) {
                    textView4.setPadding((int) (padding3.get(3).intValue() * f2), (int) (padding3.get(0).intValue() * f2), (int) (padding3.get(1).intValue() * f2), (int) (padding3.get(2).intValue() * f2));
                }
                if (styleBean.getSource().getText() != null) {
                    LayoutBean.StyleBean.TextBean text2 = styleBean.getSource().getText();
                    if (text2.getSize() > 0) {
                        textView4.setTextSize(text2.getSize());
                    }
                    if (!TextUtils.isEmpty(text2.getColor())) {
                        textView4.setTextColor(Color.parseColor("#" + text2.getColor()));
                    }
                }
            }
            if (styleBean.getButton() == null || textView5 == null) {
                return;
            }
            if (styleBean.getButton().getMargin() != null && styleBean.getButton().getMargin().size() >= 4) {
                ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) textView5.getLayoutParams();
                marginLayoutParams7.topMargin = (int) (styleBean.getButton().getMargin().get(0).intValue() * f2);
                marginLayoutParams7.rightMargin = (int) (styleBean.getButton().getMargin().get(1).intValue() * f2);
                marginLayoutParams7.bottomMargin = (int) (styleBean.getButton().getMargin().get(2).intValue() * f2);
                marginLayoutParams7.leftMargin = (int) (styleBean.getButton().getMargin().get(3).intValue() * f2);
                textView5.setLayoutParams(marginLayoutParams7);
            }
            List<Integer> padding4 = styleBean.getButton().getPadding();
            if (padding4 != null && padding4.size() >= 4) {
                textView5.setPadding((int) (padding4.get(3).intValue() * f2), (int) (padding4.get(0).intValue() * f2), (int) (padding4.get(1).intValue() * f2), (int) (padding4.get(2).intValue() * f2));
            }
            if (styleBean.getButton().getText() != null) {
                LayoutBean.StyleBean.TextBean text3 = styleBean.getButton().getText();
                if (text3.getSize() > 0) {
                    textView5.setTextSize(text3.getSize());
                }
                if (!TextUtils.isEmpty(text3.getColor())) {
                    textView5.setTextColor(Color.parseColor("#" + text3.getColor()));
                }
            }
            if (styleBean.getButton().getBorder() == null || (border = styleBean.getButton().getBorder()) == null || border.getRadius() == null || border.getRadius().size() < 4) {
                return;
            }
            textView5.setBackground(a(border.getRadius(), styleBean.getButton().getBorder().getSize(), "#" + styleBean.getButton().getBorder().getColor()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean a(Activity activity) {
        Rect rect = new Rect();
        boolean z = true;
        if (activity != null && !this.k && Build.VERSION.SDK_INT >= 29) {
            this.k = true;
            activity.registerActivityLifecycleCallbacks(new n(this));
        }
        boolean z2 = this.c != null;
        View adView = getAdView();
        if (adView == null) {
            return true;
        }
        if (adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
            ((ViewGroup) adView.getParent()).removeView(adView);
        }
        int height = -1;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        TouchAdContainer touchAdContainer = new TouchAdContainer(activity);
        touchAdContainer.setTouchPositionListener(new TouchPositionListener(this.f39495a));
        touchAdContainer.setOnWindownEventListener(new com.kc.dw.core.service.logrecord.util.b(this.b));
        touchAdContainer.addView(adView, layoutParams);
        PositionView positionView = new PositionView(activity);
        positionView.setTag(Integer.valueOf(this.i));
        positionView.setOnWindownEventListener(new h(this));
        for (int i = 0; i < touchAdContainer.getChildCount(); i++) {
            try {
                View childAt = touchAdContainer.getChildAt(i);
                if (childAt instanceof PositionView) {
                    touchAdContainer.removeView(childAt);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        touchAdContainer.addView(positionView, 1, 1);
        touchAdContainer.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC1071i(this, touchAdContainer, rect));
        if (activity != null) {
            try {
                try {
                    if ((this.f39495a.a().getAct_type() & 512) == 512) {
                        int childCount = touchAdContainer.getChildCount();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= childCount) {
                                z = false;
                                break;
                            }
                            if (touchAdContainer.getChildAt(i2) == this.s) {
                                break;
                            }
                            i2++;
                        }
                        if (!z) {
                            this.s = new FrameLayout(activity);
                            this.s.setLayoutParams(new FrameLayout.LayoutParams(touchAdContainer.getWidth() <= 0 ? -1 : touchAdContainer.getWidth(), touchAdContainer.getHeight() <= 0 ? -1 : touchAdContainer.getHeight()));
                            touchAdContainer.addView(this.s);
                        }
                        this.s.setOnTouchListener(new com.kc.dw.platform.ad_adapter.recycler.k(this));
                        touchAdContainer.post(new l(this, touchAdContainer));
                        touchAdContainer.getViewTreeObserver().addOnScrollChangedListener(this.F);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (activity != null) {
            try {
                DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
                this.w = displayMetrics.widthPixels;
                this.x = displayMetrics.heightPixels;
                try {
                    if (com.kc.dw.core.utils.h.c(this.f39495a.a().getAct_type())) {
                        if (this.v == null) {
                            this.v = new FrameLayout(activity);
                            int width = touchAdContainer.getWidth() <= 0 ? -1 : touchAdContainer.getWidth();
                            if (touchAdContainer.getHeight() > 0) {
                                height = touchAdContainer.getHeight();
                            }
                            this.v.setLayoutParams(new FrameLayout.LayoutParams(width, height));
                            touchAdContainer.addView(this.v);
                        }
                        this.v.getViewTreeObserver().addOnScrollChangedListener(this.C);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        this.f39495a.setInteractionListener(getExpressAdInteractionListener());
        this.d = touchAdContainer;
        setAdView(touchAdContainer);
        if (z2) {
            this.B = false;
            d();
        }
        return false;
    }

    public final void b(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        String str;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z;
        int i9;
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int i10;
        int i11;
        int i12;
        Context context2 = context;
        boolean z2 = true;
        this.A = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        if (this.f39495a.getImgUrls() == null || this.f39495a.getImgUrls().length <= 0) {
            return;
        }
        boolean zE = p0.e();
        View viewInflate = View.inflate(context2, zE ? R.layout.ssd_item_pre_render_three_img : R.layout.ssd_item_pre_render_three_img_v2, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_container);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_close);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_fromtext);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_type);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_three_shake_image);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        boolean z3 = false;
        if ((this.f39495a.a().getAct_type() & 4) == 4 || (this.f39495a.a().getAct_type() & 64) == 64) {
            imageView2.setVisibility(0);
            if (textView5 != null) {
                textView5.setText("摇一摇");
            }
            str = "摇动或点击";
        } else if (com.kc.dw.core.utils.h.e(this.f39495a.a().getAct_type())) {
            imageView2.setVisibility(0);
            if (textView5 != null) {
                textView5.setText("扭一扭");
            }
            str = "扭动或点击";
        } else {
            if (!zE) {
                imageView2.setImageResource(R.drawable.ssd_ic_right);
                imageView2.setVisibility(0);
            }
            str = "点击";
        }
        textView4.setText(str + (this.f39495a.getInteractionType() == 1 ? "立即下载" : "查看详情"));
        textView.setText(this.f39495a.getTitle());
        textView3.setText(this.f39495a.a().e);
        a(imageView);
        a(textView2, viewInflate);
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this.b);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_item_pre_render_three_img_containerll);
        int i13 = 0;
        int i14 = 0;
        while (i13 < this.f39495a.getImgUrls().length) {
            String str2 = this.f39495a.getImgUrls()[i13];
            if (TextUtils.isEmpty(str2)) {
                textView3 = textView3;
                textView4 = textView4;
                z = z3;
            } else {
                RoundImageView roundImageView = new RoundImageView(context2);
                roundImageView.setAdjustViewBounds(z2);
                roundImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                roundImageView.setCornerRadius(2);
                int iIntValue4 = 6;
                if (!zE || styleBean == null || styleBean.getCreatives() == null) {
                    i5 = 6;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                } else {
                    if (i13 != 0 || styleBean.getCreatives().getChilds().getLeft().getMargin().size() < 4) {
                        i9 = 1;
                        iIntValue = 0;
                        iIntValue2 = 0;
                        iIntValue3 = 0;
                    } else {
                        LayoutBean.StyleBean.CreativeBean5.ChildsBean.ChildBean left = styleBean.getCreatives().getChilds().getLeft();
                        iIntValue4 = left.getMargin().get(3).intValue();
                        iIntValue = left.getMargin().get(0).intValue();
                        int iIntValue5 = left.getMargin().get(1).intValue();
                        int iIntValue6 = left.getMargin().get(2).intValue();
                        LayoutBean.StyleBean.BorderBean border = styleBean.getCreatives().getChilds().getLeft().getBorder();
                        if (border == null || !border.getClip() || border.getRadius() == null) {
                            iIntValue3 = iIntValue5;
                            iIntValue2 = iIntValue6;
                        } else {
                            iIntValue3 = iIntValue5;
                            iIntValue2 = iIntValue6;
                            if (border.getRadius().size() >= 4) {
                                roundImageView.setCornerTopLeftRadius((int) (border.getRadius().get(0).intValue() * f2));
                                roundImageView.setCornerTopRightRadius((int) (border.getRadius().get(1).intValue() * f2));
                                roundImageView.setCornerBottomRightRadius((int) (border.getRadius().get(2).intValue() * f2));
                                roundImageView.setCornerBottomLeftRadius((int) (border.getRadius().get(3).intValue() * f2));
                            }
                        }
                        i9 = 1;
                    }
                    if (i13 == i9 && styleBean.getCreatives().getChilds().getCenter().getMargin().size() >= 4) {
                        LayoutBean.StyleBean.CreativeBean5.ChildsBean.ChildBean center = styleBean.getCreatives().getChilds().getCenter();
                        iIntValue4 = center.getMargin().get(3).intValue();
                        iIntValue = center.getMargin().get(0).intValue();
                        iIntValue3 = center.getMargin().get(1).intValue();
                        iIntValue2 = center.getMargin().get(2).intValue();
                        LayoutBean.StyleBean.BorderBean border2 = styleBean.getCreatives().getChilds().getCenter().getBorder();
                        if (border2 != null && border2.getClip() && border2.getRadius() != null && border2.getRadius().size() >= 4) {
                            roundImageView.setCornerTopLeftRadius((int) (border2.getRadius().get(0).intValue() * f2));
                            roundImageView.setCornerTopRightRadius((int) (border2.getRadius().get(1).intValue() * f2));
                            roundImageView.setCornerBottomRightRadius((int) (border2.getRadius().get(2).intValue() * f2));
                            roundImageView.setCornerBottomLeftRadius((int) (border2.getRadius().get(3).intValue() * f2));
                        }
                    }
                    if (i13 != 2 || styleBean.getCreatives().getChilds().getRight().getMargin().size() < 4) {
                        i10 = iIntValue3;
                    } else {
                        LayoutBean.StyleBean.CreativeBean5.ChildsBean.ChildBean right = styleBean.getCreatives().getChilds().getRight();
                        iIntValue4 = right.getMargin().get(3).intValue();
                        iIntValue = right.getMargin().get(0).intValue();
                        int iIntValue7 = right.getMargin().get(1).intValue();
                        int iIntValue8 = right.getMargin().get(2).intValue();
                        LayoutBean.StyleBean.BorderBean border3 = styleBean.getCreatives().getChilds().getRight().getBorder();
                        if (border3 == null || !border3.getClip() || border3.getRadius() == null) {
                            i11 = iIntValue8;
                            i12 = iIntValue7;
                        } else {
                            i11 = iIntValue8;
                            i12 = iIntValue7;
                            if (border3.getRadius().size() >= 4) {
                                roundImageView.setCornerTopLeftRadius((int) (border3.getRadius().get(0).intValue() * f2));
                                roundImageView.setCornerTopRightRadius((int) (border3.getRadius().get(1).intValue() * f2));
                                roundImageView.setCornerBottomRightRadius((int) (border3.getRadius().get(2).intValue() * f2));
                                roundImageView.setCornerBottomLeftRadius((int) (border3.getRadius().get(3).intValue() * f2));
                            }
                        }
                        i10 = i12;
                        iIntValue2 = i11;
                    }
                    i6 = i10;
                    i5 = iIntValue4;
                    i8 = iIntValue;
                    i7 = iIntValue2;
                }
                z = false;
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
                if (i14 > 0) {
                    layoutParams.setMargins((int) (i5 * f2), (int) (i8 * f2), (int) (i6 * f2), (int) (i7 * f2));
                }
                linearLayout.addView(roundImageView, layoutParams);
                c0.a(str2, new c(this, roundImageView));
                i14++;
            }
            i13++;
            context2 = context;
            textView4 = textView4;
            textView3 = textView3;
            z3 = z;
            imageView = imageView;
            textView2 = textView2;
            textView = textView;
            z2 = true;
        }
        TextView textView6 = textView;
        TextView textView7 = textView2;
        ImageView imageView3 = imageView;
        TextView textView8 = textView3;
        TextView textView9 = textView4;
        if (zE && styleBean != null && styleBean.getType() == 501) {
            a(styleBean, this.c, textView6, null, null, textView7, imageView3, textView8, textView9);
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, FeedInteractionListener feedInteractionListener) {
    }

    public final void c() {
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.l = 0;
        this.r = 0;
        this.E = true;
        this.D = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        boolean zE = p0.e();
        int i5 = zE ? R.layout.ssd_item_pre_render_large_image : R.layout.ssd_item_pre_render_large_image_v2;
        if (styleBean != null) {
            int type = styleBean.getType();
            if (type == 201) {
                i5 = zE ? R.layout.ssd_item_pre_render_large_image_top : R.layout.ssd_item_pre_render_large_image_top_v2;
            } else if (type == 601 && !zE) {
                i5 = R.layout.ssd_item_pre_render_large_image_top_v2_601;
            }
        }
        View viewInflate = View.inflate(context, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_rootview);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_content);
        RoundImageView roundImageView = (RoundImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imageview);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imagebg);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_fromtext);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_close);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_layout);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_image);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_shake_text);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        StringBuilder sbA = com.kc.dw.activity.a.a("clkType=");
        sbA.append(this.f39495a.a().getAct_type());
        LogUtil.d("i", sbA.toString());
        if (TextUtils.isEmpty(this.f39495a.a().title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f39495a.a().title);
        }
        if (TextUtils.isEmpty(this.f39495a.a().c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f39495a.a().c);
        }
        if (this.f39495a.a().e == null) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.f39495a.a().e);
        }
        com.kc.dw.core.service.logrecord.a.a(5, "e4", this.b);
        if (this.f39495a.getImgUrls() == null || this.f39495a.getImgUrls().length <= 0 || TextUtils.isEmpty(this.f39495a.getImgUrls()[0])) {
            a(com.kc.dw.core.exception.b.c.intValue(), "图片加载错误");
        } else {
            StringBuilder sbA2 = com.kc.dw.activity.a.a(" 容器宽度：");
            sbA2.append(((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_width());
            LogUtil.i("i", sbA2.toString());
            c0.a(this.f39495a.getImgUrls()[0], new d(this, roundImageView, (context.getResources().getDisplayMetrics().widthPixels - i) - i3, context, imageView, imageView3, textView5, textView6, viewGroup, zE));
        }
        a(imageView2);
        a(textView4, viewInflate);
        if (!zE || styleBean == null) {
            return;
        }
        if (styleBean.getType() == 101 || styleBean.getType() == 201) {
            a(styleBean, this.c, textView, textView2, roundImageView, textView4, imageView2, textView3, null);
        }
    }

    public final void d() {
        if (this.B) {
            return;
        }
        this.B = true;
        callRenderSuccess();
    }

    public final void d(Context context, LayoutBean.StyleBean styleBean, int i, int i2, int i3, int i4) {
        String str;
        boolean zE = p0.e();
        int i5 = zE ? R.layout.ssd_item_pre_render_large_image : R.layout.ssd_item_pre_render_large_image_v2;
        if (styleBean != null) {
            int type = styleBean.getType();
            if (type == 201) {
                i5 = zE ? R.layout.ssd_item_pre_render_large_image_top : R.layout.ssd_item_pre_render_large_image_top_v2;
            } else if (type == 601 && !zE) {
                i5 = R.layout.ssd_item_pre_render_large_image_top_v2_601;
            }
        }
        View viewInflate = View.inflate(context, i5, null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_rootview);
        this.c = relativeLayout;
        relativeLayout.setPadding(i, i2, i3, i4);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_videocontainer);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imagebg);
        TextView textView = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_content);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_imageview);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_fromtext);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_close);
        if (TextUtils.isEmpty(this.f39495a.a().title)) {
            textView.setVisibility(8);
        } else {
            textView.setText(this.f39495a.a().title);
        }
        if (TextUtils.isEmpty(this.f39495a.a().c)) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.f39495a.a().c);
        }
        if (TextUtils.isEmpty(this.f39495a.a().e)) {
            textView3.setVisibility(8);
        } else {
            textView3.setText(this.f39495a.a().e);
        }
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_layout);
        ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.ms_item_pre_render_large_shake_image);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.ms_item_pre_render_large_iamge_shake_text);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.ms_shake_text);
        StringBuilder sbA = com.kc.dw.activity.a.a("clkType=");
        sbA.append(this.f39495a.a().getAct_type());
        LogUtil.d("i", sbA.toString());
        if (com.kc.dw.core.utils.h.d(this.f39495a.a().getAct_type())) {
            imageView4.setVisibility(0);
            textView5.setVisibility(0);
            if (textView6 != null) {
                textView6.setText("摇一摇");
            }
            str = "摇动或点击";
        } else if (com.kc.dw.core.utils.h.e(this.f39495a.a().getAct_type())) {
            imageView4.setVisibility(0);
            textView5.setVisibility(0);
            if (textView6 != null) {
                textView6.setText("扭一扭");
            }
            str = "扭动或点击";
        } else {
            if (viewGroup != null && !zE) {
                viewGroup.setVisibility(0);
                imageView4.setImageResource(R.drawable.ssd_ic_right);
                imageView4.setVisibility(0);
                textView5.setVisibility(0);
            }
            str = "点击";
        }
        textView5.setText(str + (this.f39495a.a().getInteractionType() == 1 ? "立即下载" : "查看详情"));
        imageView2.setVisibility(8);
        a(imageView3);
        a(textView4, viewInflate);
        try {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            int i6 = this.e;
            if (i6 > 0) {
                layoutParams.width = (int) (i6 * displayMetrics.density);
            }
            int i7 = this.f;
            if (i7 > 0) {
                layoutParams.height = (int) (i7 * displayMetrics.density);
            }
            imageView.setLayoutParams(layoutParams);
            relativeLayout2.setVisibility(8);
            com.kc.dw.ad.nativ.d dVar = this.f39495a;
            this.b.getContext();
            dVar.a(relativeLayout2, new com.kc.dw.platform.ad_adapter.recycler.d((com.kc.dw.ad.nativ.i) this.b.f39477a, new com.kc.dw.platform.ad_adapter.recycler.h(this, relativeLayout2)), new com.kc.dw.core.service.logrecord.util.a(this.b, true));
            String str2 = this.f39495a.a().g;
            try {
                if (!TextUtils.isEmpty(str2)) {
                    ExecutorService executorService = f0.f39362a;
                    f0.b.f39363a.a(new com.kc.dw.platform.ad_adapter.recycler.g(this, str2, context, imageView, styleBean, relativeLayout2));
                    if (!zE && (this.f39495a.getMediaView() instanceof NormalMediaView)) {
                        ((NormalMediaView) this.f39495a.getMediaView()).setRadius(6);
                    }
                } else if (!zE) {
                    ((NormalMediaView) this.f39495a.getMediaView()).setRadius(6);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        if (!zE || styleBean == null) {
            return;
        }
        if ((styleBean.getType() == 101 || styleBean.getType() == 201) && styleBean.getCreative() != null) {
            a(styleBean, this.c, textView, textView2, null, textView4, imageView3, textView3, null);
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void destroy() {
        ShakeUtil.getInstance().a(this.i);
        com.kc.dw.ad.nativ.d dVar = this.f39495a;
        if (dVar != null && dVar.getMediaView() != null) {
            ((NormalMediaView) this.f39495a.getMediaView()).c();
        }
        try {
            FrameLayout frameLayout = this.v;
            if (frameLayout != null) {
                frameLayout.getViewTreeObserver().removeOnScrollChangedListener(this.C);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void e() {
        try {
            if (this.c == null) {
                LogUtil.e("i", "adView is null");
                return;
            }
            if (this.A && !p0.e()) {
                LogUtil.dev("i", "no show shake float view");
                return;
            }
            RelativeLayout relativeLayout = (RelativeLayout) this.c.findViewById(R.id.ms_shakeRoot);
            ShakeImageView shakeImageView = (ShakeImageView) this.c.findViewById(R.id.ms_shake_img);
            if (relativeLayout != null && shakeImageView != null) {
                Context context = this.c.getContext();
                if (this.z) {
                    return;
                }
                this.z = true;
                this.c.post(new com.kc.dw.platform.ad_adapter.recycler.j(this, context, relativeLayout, shakeImageView));
                return;
            }
            if (relativeLayout == null) {
                LogUtil.d("i", "startShakeRoot is null");
            }
            if (shakeImageView == null) {
                LogUtil.d("i", "startShakeImage is null");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        return this.f39495a.getAdPatternType();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0234 A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x010f A[Catch: all -> 0x027f, TRY_LEAVE, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0126  */
    /* JADX WARN: Code duplicated, block: B:47:0x012e A[Catch: Exception -> 0x0144, all -> 0x027f, TryCatch #2 {Exception -> 0x0144, blocks: (B:45:0x0128, B:47:0x012e, B:49:0x013a), top: B:121:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x013a A[Catch: Exception -> 0x0144, all -> 0x027f, TRY_LEAVE, TryCatch #2 {Exception -> 0x0144, blocks: (B:45:0x0128, B:47:0x012e, B:49:0x013a), top: B:121:0x0128 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x014c  */
    /* JADX WARN: Code duplicated, block: B:74:0x019e  */
    /* JADX WARN: Code duplicated, block: B:77:0x01cb A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01e7 A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01f4 A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0209 A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0216 A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0223 A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x022b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x022d A[Catch: all -> 0x027f, TryCatch #4 {all -> 0x027f, blocks: (B:3:0x0007, B:5:0x000b, B:7:0x0038, B:9:0x004a, B:10:0x0061, B:12:0x006f, B:14:0x0081, B:15:0x0098, B:23:0x00aa, B:39:0x010f, B:42:0x0120, B:45:0x0128, B:47:0x012e, B:49:0x013a, B:60:0x0151, B:62:0x0157, B:63:0x015f, B:64:0x0162, B:68:0x0178, B:70:0x017f, B:75:0x01a3, B:77:0x01cb, B:99:0x0230, B:101:0x0234, B:103:0x023d, B:109:0x025b, B:105:0x024a, B:107:0x024e, B:111:0x0261, B:89:0x01e7, B:90:0x01f4, B:91:0x0201, B:93:0x0209, B:94:0x0216, B:95:0x0223, B:98:0x022d, B:67:0x0174, B:56:0x0148, B:26:0x00d1, B:27:0x00e0, B:29:0x00e6, B:30:0x00ea, B:33:0x00f8, B:36:0x0109), top: B:125:0x0007, inners: #0, #3 }] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public View getAdView() {
        LayoutBean layoutBean;
        LayoutBean.StyleBean styleBean;
        List<LayoutBean.StyleBean> style;
        int i;
        LayoutBean.StyleBean styleBean2;
        int[] iArrUserPreRenderPaddings;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int adPatternType;
        int i7;
        int i8;
        int type;
        try {
            if (this.c == null) {
                com.kc.dw.core.service.logrecord.a.a(5, "e5", this.b, new TypeMsg().setData(1));
                Context context = this.b.getContext();
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_width() != null && ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_width().intValue() > 0) {
                    this.e = (int) (((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_width().intValue() / displayMetrics.density);
                }
                if (((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_height() != null && ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_height().intValue() > 0) {
                    this.f = (int) (((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAccept_ad_height().intValue() / displayMetrics.density);
                }
                int i9 = this.f39495a.a().x;
                int i10 = (i9 < 1 || i9 > 6) ? 1 : i9;
                try {
                    File file = new File(context.getExternalCacheDir().getAbsolutePath() + "/ms_cache", "ms_temp.json");
                    try {
                        if (file.exists()) {
                            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                stringBuffer.append(line);
                            }
                            bufferedReader.close();
                            if (!stringBuffer.toString().isEmpty()) {
                                layoutBean = (LayoutBean) new Gson().fromJson(stringBuffer.toString(), LayoutBean.class);
                                if (layoutBean == null) {
                                    layoutBean = (LayoutBean) new Gson().fromJson("{\n    \"dpi\": 160,\n    \"style\": [\n        {\n            \"id\": 1,\n            \"type\": 101,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    10,\n                    0,\n                    10\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    10,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 14,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    2\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    1,\n                    0,\n                    0,\n                    4\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 12,\n                    \"color\": \"808080\"\n                }\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    4,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    13,\n                    13,\n                    13,\n                    13\n                ]}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 2,\n            \"type\": 201,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    5,\n                    0,\n                    0,\n                    10\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 14,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    3,\n                    0,\n                    0,\n                    10\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"margin\": [\n                    10,\n                    10,\n                    0,\n                    10\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    4\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 12,\n                    \"color\": \"808080\"\n                }\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    12,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    8,\n                    8,\n                    8,\n                    8\n                ]}\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    10,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    1,\n                    3,\n                    1,\n                    3\n                ],\n                \"border\": {\n                    \"size\": 0,\n                    \"color\": \"808080\"\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 11}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 3,\n            \"type\": 301,\n            \"container\": {\n                \"padding\": [\n                    16,\n                    16,\n                    16,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    15\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    15\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"width\": 138,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            }\n            ,\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 4,\n            \"type\": 401,\n            \"container\": {\n                \"padding\": [\n                    16,\n                    16,\n                    16,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"width\": 138,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            }, \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    20,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"000000\"\n                }\n            }\n        },\n        {\n            \"id\": 5,\n            \"type\": 501,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    16,\n                    0,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    9,\n                    0,\n                    12,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    15,\n                    0,\n                    0,\n                    6\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    14,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    2,\n                    4,\n                    2,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 0,\n                    \"color\": \"808080\"\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            },\n            \"creatives\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"childs\": {\n                    \"left\": {\n                        \"margin\": [\n                            0,\n                            2,\n                            0,\n                            0\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    },\n                    \"center\": {\n                        \"margin\": [\n                            0,\n                            0,\n                            0,\n                            0\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    },\n                    \"right\": {\n                        \"margin\": [\n                            0,\n                            0,\n                            0,\n                            2\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    }\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    10\n                ]\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    12,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    15,\n                    15,\n                    15,\n                    15\n                ]}\n            },\n            \"button\": {\n                \"margin\": [\n                    8,\n                    0,\n                    8,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    9,\n                    4,\n                    9\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 13,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        }\n    ]\n}", LayoutBean.class);
                                }
                                if (layoutBean != null) {
                                    try {
                                        style = layoutBean.getStyle();
                                        if (style != null) {
                                            styleBean = null;
                                            for (i = 0; i < style.size(); i++) {
                                                try {
                                                    if (i10 == style.get(i).getId()) {
                                                        styleBean = style.get(i);
                                                    }
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    e.printStackTrace();
                                                }
                                            }
                                        } else {
                                            styleBean = null;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        styleBean = null;
                                    }
                                } else {
                                    styleBean = null;
                                }
                                if (i10 == 6 && !p0.e()) {
                                    styleBean = new LayoutBean.StyleBean();
                                    styleBean.setType(601);
                                }
                                styleBean2 = styleBean;
                                float f2 = displayMetrics.density;
                                iArrUserPreRenderPaddings = ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAdSlot().userPreRenderPaddings();
                                i2 = (int) (16.0f * f2);
                                if (iArrUserPreRenderPaddings == null && iArrUserPreRenderPaddings.length == 4) {
                                    int i11 = (int) (iArrUserPreRenderPaddings[0] * f2);
                                    int i12 = (int) (iArrUserPreRenderPaddings[1] * f2);
                                    int i13 = (int) (iArrUserPreRenderPaddings[2] * f2);
                                    i6 = (int) (iArrUserPreRenderPaddings[3] * f2);
                                    i3 = i11;
                                    i5 = i13;
                                    i4 = i12;
                                } else {
                                    i3 = i2;
                                    i4 = i3;
                                    i5 = i4;
                                    i6 = i5;
                                }
                                LogUtil.d("i", "AdPatternType = " + this.f39495a.getAdPatternType());
                                this.f39495a.a().C = System.currentTimeMillis();
                                if (styleBean2 != null) {
                                    type = styleBean2.getType();
                                    if (type != 101 && type != 201) {
                                        if (type != 301 || type == 401) {
                                            a(context, styleBean2, i3, i4, i5, i6);
                                        } else if (type == 501) {
                                            b(context, styleBean2, i3, i4, i5, i6);
                                        } else if (type != 601) {
                                        }
                                    }
                                    if (this.f39495a.getAdPatternType() == 2) {
                                        d(context, styleBean2, i3, i4, i5, i6);
                                    } else {
                                        c(context, styleBean2, i3, i4, i5, i6);
                                    }
                                } else {
                                    adPatternType = this.f39495a.getAdPatternType();
                                    if (adPatternType == 1) {
                                        c(context, styleBean2, i3, i4, i5, i6);
                                    } else if (adPatternType != 2) {
                                        switch (adPatternType) {
                                            case 11:
                                                a(context, styleBean2, i3, i4, i5, i6);
                                                break;
                                            case 12:
                                                c(context, styleBean2, i3, i4, i5, i6);
                                                break;
                                            case 13:
                                                b(context, styleBean2, i3, i4, i5, i6);
                                                break;
                                        }
                                    } else {
                                        d(context, styleBean2, i3, i4, i5, i6);
                                    }
                                }
                                if (this.c != null) {
                                    i7 = this.e;
                                    if ((i7 <= 0 && i7 * displayMetrics.density < ((double) displayMetrics.widthPixels) * 0.3d) || ((i8 = this.f) > 0 && i8 * displayMetrics.density < ((double) displayMetrics.widthPixels) * 0.3d)) {
                                        LogUtil.e("i", "container size is too small");
                                        return null;
                                    }
                                    new DownloadView().handleFeedDownloadView(this.c, this.f39495a.a(), styleBean2);
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(this.c);
                                    a(context, arrayList);
                                }
                            }
                        }
                        iArrUserPreRenderPaddings = ((RecyclerMixCommonAdLoader) this.b.getAdLoader()).getAdSlot().userPreRenderPaddings();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        iArrUserPreRenderPaddings = null;
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                layoutBean = null;
                if (layoutBean == null) {
                    layoutBean = (LayoutBean) new Gson().fromJson("{\n    \"dpi\": 160,\n    \"style\": [\n        {\n            \"id\": 1,\n            \"type\": 101,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    10,\n                    0,\n                    10\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    10,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 14,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    2\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    1,\n                    0,\n                    0,\n                    4\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 12,\n                    \"color\": \"808080\"\n                }\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    4,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    13,\n                    13,\n                    13,\n                    13\n                ]}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 2,\n            \"type\": 201,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    5,\n                    0,\n                    0,\n                    10\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 14,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    3,\n                    0,\n                    0,\n                    10\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"margin\": [\n                    10,\n                    10,\n                    0,\n                    10\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    4\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 12,\n                    \"color\": \"808080\"\n                }\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    12,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    8,\n                    8,\n                    8,\n                    8\n                ]}\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    10,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    1,\n                    3,\n                    1,\n                    3\n                ],\n                \"border\": {\n                    \"size\": 0,\n                    \"color\": \"808080\"\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 11}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 3,\n            \"type\": 301,\n            \"container\": {\n                \"padding\": [\n                    16,\n                    16,\n                    16,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    15\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    15\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"width\": 138,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    2,\n                    2,\n                    2,\n                    2\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            }\n            ,\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        },\n        {\n            \"id\": 4,\n            \"type\": 401,\n            \"container\": {\n                \"padding\": [\n                    16,\n                    16,\n                    16,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"creative\": {\n                \"width\": 138,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ]\n            }, \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    20,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            },\n            \"button\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    4,\n                    4,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 12,\n                    \"weight\": 400,\n                    \"color\": \"000000\"\n                }\n            }\n        },\n        {\n            \"id\": 5,\n            \"type\": 501,\n            \"container\": {\n                \"padding\": [\n                    0,\n                    16,\n                    0,\n                    16\n                ],\n                \"border\": {\n                    \"radius\": [\n                        0,\n                        0,\n                        0,\n                        0\n                    ],\n                    \"clip\": false\n                }\n            },\n            \"title\": {\n                \"margin\": [\n                    9,\n                    0,\n                    12,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 15,\n                    \"color\": \"000000\",\n                    \"lines\": 1\n                }\n            },\n            \"content\": {\n                \"margin\": [\n                    0,\n                    0,\n                    10,\n                    0\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"family\": \"monospace\",\n                    \"size\": 12,\n                    \"color\": \"808080\",\n                    \"lines\": 1\n                }\n            },\n            \"source\": {\n                \"hide\": false,\n                \"margin\": [\n                    15,\n                    0,\n                    0,\n                    6\n                ],\n                \"padding\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"text\": {\n                    \"size\": 13,\n                    \"color\": \"808080\"\n                }\n            },\n            \"dislike\": {\n                \"hide\": false,\n                \"margin\": [\n                    14,\n                    0,\n                    0,\n                    0\n                ],\n                \"padding\": [\n                    2,\n                    4,\n                    2,\n                    4\n                ],\n                \"border\": {\n                    \"size\": 0,\n                    \"color\": \"808080\"\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\"size\": 10}\n            },\n            \"creatives\": {\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    0\n                ],\n                \"childs\": {\n                    \"left\": {\n                        \"margin\": [\n                            0,\n                            2,\n                            0,\n                            0\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    },\n                    \"center\": {\n                        \"margin\": [\n                            0,\n                            0,\n                            0,\n                            0\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    },\n                    \"right\": {\n                        \"margin\": [\n                            0,\n                            0,\n                            0,\n                            2\n                        ],\n                        \"border\": {\n                            \"radius\": [\n                                0,\n                                0,\n                                0,\n                                0\n                            ],\n                            \"clip\": false\n                        }\n                    }\n                }\n            },\n            \"logo\": {\n                \"hide\": false,\n                \"margin\": [\n                    0,\n                    0,\n                    0,\n                    10\n                ]\n            },\n            \"icon\": {\n                \"width\": 18,\n                \"margin\": [\n                    12,\n                    0,\n                    0,\n                    0\n                ],\n                \"border\": {\"radius\": [\n                    15,\n                    15,\n                    15,\n                    15\n                ]}\n            },\n            \"button\": {\n                \"margin\": [\n                    8,\n                    0,\n                    8,\n                    0\n                ],\n                \"padding\": [\n                    4,\n                    9,\n                    4,\n                    9\n                ],\n                \"border\": {\n                    \"size\": 1,\n                    \"color\": \"1A73E8\",\n                    \"radius\": [\n                        2,\n                        2,\n                        2,\n                        2\n                    ]\n                },\n                \"background\": {\"color\": null},\n                \"text\": {\n                    \"size\": 13,\n                    \"weight\": 400,\n                    \"color\": \"1A73E8\"\n                }\n            }\n        }\n    ]\n}", LayoutBean.class);
                }
                if (layoutBean != null) {
                    style = layoutBean.getStyle();
                    if (style != null) {
                        styleBean = null;
                        while (i < style.size()) {
                            if (i10 == style.get(i).getId()) {
                                styleBean = style.get(i);
                            }
                        }
                    } else {
                        styleBean = null;
                    }
                } else {
                    styleBean = null;
                }
                if (i10 == 6) {
                    styleBean = new LayoutBean.StyleBean();
                    styleBean.setType(601);
                }
                styleBean2 = styleBean;
                float f3 = displayMetrics.density;
                i2 = (int) (16.0f * f3);
                if (iArrUserPreRenderPaddings == null) {
                    i3 = i2;
                    i4 = i3;
                    i5 = i4;
                    i6 = i5;
                } else {
                    i3 = i2;
                    i4 = i3;
                    i5 = i4;
                    i6 = i5;
                }
                LogUtil.d("i", "AdPatternType = " + this.f39495a.getAdPatternType());
                this.f39495a.a().C = System.currentTimeMillis();
                if (styleBean2 != null) {
                    type = styleBean2.getType();
                    if (type != 101) {
                        if (type != 301) {
                            a(context, styleBean2, i3, i4, i5, i6);
                        } else {
                            a(context, styleBean2, i3, i4, i5, i6);
                        }
                    }
                    if (this.f39495a.getAdPatternType() == 2) {
                        d(context, styleBean2, i3, i4, i5, i6);
                    } else {
                        c(context, styleBean2, i3, i4, i5, i6);
                    }
                } else {
                    adPatternType = this.f39495a.getAdPatternType();
                    if (adPatternType == 1) {
                        c(context, styleBean2, i3, i4, i5, i6);
                    } else if (adPatternType != 2) {
                        switch (adPatternType) {
                            case 11:
                                a(context, styleBean2, i3, i4, i5, i6);
                                break;
                            case 12:
                                c(context, styleBean2, i3, i4, i5, i6);
                                break;
                            case 13:
                                b(context, styleBean2, i3, i4, i5, i6);
                                break;
                        }
                    } else {
                        d(context, styleBean2, i3, i4, i5, i6);
                    }
                }
                if (this.c != null) {
                    i7 = this.e;
                    if (i7 <= 0) {
                        new DownloadView().handleFeedDownloadView(this.c, this.f39495a.a(), styleBean2);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(this.c);
                        a(context, arrayList2);
                    } else {
                        new DownloadView().handleFeedDownloadView(this.c, this.f39495a.a(), styleBean2);
                        ArrayList arrayList3 = new ArrayList();
                        arrayList3.add(this.c);
                        a(context, arrayList3);
                    }
                    LogUtil.e("i", "container size is too small");
                    return null;
                }
            }
        } catch (Throwable th) {
            a(com.kc.dw.core.exception.b.c.intValue(), "渲染失败");
            com.kc.dw.core.service.logrecord.a.a(5, "f5", this.b, new CodeMsg().setData(9, th.toString()));
            th.printStackTrace();
        }
        return this.c;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public List<SsdAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getContent() {
        return null;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        ResultBean resultBean = new ResultBean();
        try {
            resultBean.setCid(((com.kc.dw.ad.nativ.i) this.b.f39477a).getCid());
            resultBean.setCat(((com.kc.dw.ad.nativ.i) this.b.f39477a).getCat());
            resultBean.setAderId(((com.kc.dw.ad.nativ.i) this.b.f39477a).getAder_id());
            resultBean.setFromId(((com.kc.dw.ad.nativ.i) this.b.f39477a).getFromId());
            resultBean.setDrawing(((com.kc.dw.ad.nativ.i) this.b.f39477a).getDrawing());
            resultBean.setPid(((com.kc.dw.ad.nativ.i) this.b.f39477a).getPosId());
            resultBean.setReqId(((com.kc.dw.ad.nativ.i) this.b.f39477a).getReq_id());
            resultBean.setPrice(((com.kc.dw.ad.nativ.i) this.b.f39477a).getEcpm());
            resultBean.setEcpm(((com.kc.dw.ad.nativ.i) this.b.f39477a).getEcpm() + "");
            resultBean.setS_ext(((com.kc.dw.ad.nativ.i) this.b.f39477a).getS_ext());
            resultBean.setS_code(((com.kc.dw.ad.nativ.i) this.b.f39477a).getS_code());
            resultBean.setAdInfo(com.kc.dw.core.utils.a.a((BaseAdSlot) this.b.f39477a));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        resultBean.setSdkName("SSD");
        return resultBean;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return this.f39495a.a().y * 1000;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getExpressView() {
        return this.d;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return this.f39495a.a().b;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        return com.kc.dw.core.utils.a.a(this.f39495a.a().getAder_id()) ? this.f39495a.a().getImageUrls() : new String[0];
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return this.f39495a.getInteractionType();
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public FeedInteractionListener getNativeAdInteractionListener() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "SSD";
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return null;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        return this.f39495a.a().f39132a;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        try {
            int expire_timestamp = ((com.kc.dw.ad.nativ.i) this.b.f39477a).getExpire_timestamp();
            return SystemClock.uptimeMillis() - ((com.kc.dw.ad.nativ.i) this.b.f39477a).getLoadedTime() < (expire_timestamp <= 0 ? 1740000L : (long) (expire_timestamp * 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void mute() {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerExpressAd, com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void render(Activity activity) {
        try {
            s1.b(this.f39495a.a().getEventUrl());
            if (this.f39495a.getImgUrls() != null && this.f39495a.getImgUrls().length != 0) {
                if (this.f39495a.getAdPatternType() == 2) {
                    z.a(this.f39495a.getImgUrls()[0], new f(this, activity));
                    return;
                } else {
                    if (a(activity)) {
                        a(9000001, "广告渲染异常");
                        return;
                    }
                    return;
                }
            }
            a(com.kc.dw.core.exception.b.c.intValue(), "素材加载错误");
        } catch (Throwable th) {
            callRenderError(9000001, "reader error");
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void replay() {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        com.kc.dw.core.s2s.a.a(this.b.getContext(), ((com.kc.dw.ad.nativ.i) this.b.f39477a).getLossUrl(), map);
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        com.kc.dw.core.s2s.a.b(this.b.getContext(), ((com.kc.dw.ad.nativ.i) this.b.f39477a).getWinUrl(), map);
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
        this.h = expressMediaListener;
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void startVideo() {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.kc.dw.core.ad.recycler.FeedAd, com.kc.dw.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }
}
