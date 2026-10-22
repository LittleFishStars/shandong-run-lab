package com.kc.dw.platform.custom.ca.intertitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import com.kc.dw.activity.SsdInterstitialActivity;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.domain.HttpResponse;
import com.kc.dw.core.exception.b;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.c0;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.x;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class FeedChangeIntertitial implements IIntertitialChangeAd<MsCustomRecyclerFeedAd> {
    private static final String TAG = "FeedChangeIntertitial";
    private MsCustomRecyclerFeedAd ad;
    private SsdAdSlot adSlot;
    private int height;
    private final IntertitialChangeAdapter intertitialChangeAdapter;
    private int layoutType = 1;
    private int width;

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.ca.intertitial.FeedChangeIntertitial$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 extends j {
        public final FeedChangeIntertitial this$0;
        public final Activity val$context;

        public AnonymousClass2(FeedChangeIntertitial feedChangeIntertitial, Activity activity) {
            this.this$0 = feedChangeIntertitial;
            this.val$context = activity;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                mediaMetadataRetriever.setDataSource(this.this$0.ad.getImgUrls()[0], new HashMap());
                Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                if (frameAtTime == null || jCurrentTimeMillis2 - jCurrentTimeMillis >= 1000) {
                    this.this$0.jumpToActivity(this.val$context);
                } else {
                    SdkHandler.getInstance().runOnUiThread(new j(this, frameAtTime) { // from class: com.kc.dw.platform.custom.ca.intertitial.FeedChangeIntertitial.2.1
                        public final AnonymousClass2 this$1;
                        public final Bitmap val$videoBitmap;

                        {
                            this.this$1 = this;
                            this.val$videoBitmap = frameAtTime;
                        }

                        @Override // com.kc.dw.core.safe.j
                        public void safeRun() {
                            try {
                                this.this$1.this$0.height = this.val$videoBitmap.getHeight();
                                this.this$1.this$0.width = this.val$videoBitmap.getWidth();
                                if (this.this$1.this$0.height > this.this$1.this$0.width) {
                                    this.this$1.this$0.layoutType = 2;
                                }
                                AnonymousClass2 anonymousClass2 = this.this$1;
                                anonymousClass2.this$0.jumpToActivity(anonymousClass2.val$context);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                if (this.this$0.intertitialChangeAdapter != null) {
                    this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "插屏视频渲染失败");
                }
                th.printStackTrace();
            }
        }
    }

    public FeedChangeIntertitial(IntertitialChangeAdapter intertitialChangeAdapter) {
        this.intertitialChangeAdapter = intertitialChangeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToActivity(Context context) {
        SsdInterstitialActivity.setSdkAd(this);
        SsdInterstitialActivity.setAdWrapper(this.intertitialChangeAdapter);
        Intent intent = new Intent(context, (Class<?>) SsdInterstitialActivity.class);
        intent.putExtra("isVideoAutoPlay", this.intertitialChangeAdapter.getAdLoader().getIsVideoAutoPlay());
        intent.putExtra("isClickToClose", this.intertitialChangeAdapter.getAdLoader().getIsClickToClose());
        intent.putExtra("layout_type", this.layoutType);
        intent.putExtra("layout_width", this.width);
        intent.putExtra("layout_height", this.height);
        context.startActivity(intent);
    }

    private void loadImageType(Activity activity, String str) {
        c0.a(str, new x(this, activity) { // from class: com.kc.dw.platform.custom.ca.intertitial.FeedChangeIntertitial.3
            public final FeedChangeIntertitial this$0;
            public final Activity val$context;

            {
                this.this$0 = this;
                this.val$context = activity;
            }

            @Override // com.kc.dw.core.utils.x
            public void onFailure(IOException iOException) {
                if (this.this$0.intertitialChangeAdapter != null) {
                    this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "load image error");
                }
            }

            @Override // com.kc.dw.core.utils.x
            public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                try {
                    if (!httpResponse.isSuccessful()) {
                        if (this.this$0.intertitialChangeAdapter != null) {
                            this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "load image error");
                            return;
                        }
                        return;
                    }
                    try {
                        byte[] responseBody = httpResponse.getResponseBody();
                        if (responseBody == null || responseBody.length <= 0) {
                            if (this.this$0.intertitialChangeAdapter != null) {
                                this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "load image error");
                                return;
                            }
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        this.this$0.width = bitmapDecodeByteArray.getWidth();
                        this.this$0.height = bitmapDecodeByteArray.getHeight();
                        if (this.this$0.height > this.this$0.width) {
                            this.this$0.layoutType = 2;
                        }
                        SsdInterstitialActivity.setSdkAd(this.this$0.ad);
                        SsdInterstitialActivity.setAdWrapper(this.this$0.intertitialChangeAdapter);
                        Intent intent = new Intent(this.val$context, (Class<?>) SsdInterstitialActivity.class);
                        intent.putExtra("isVideoAutoPlay", this.this$0.intertitialChangeAdapter.getAdLoader().getIsVideoAutoPlay());
                        intent.putExtra("isClickToClose", this.this$0.intertitialChangeAdapter.getAdLoader().getIsClickToClose());
                        intent.putExtra("layout_type", this.this$0.layoutType);
                        intent.putExtra("layout_width", this.this$0.width);
                        intent.putExtra("layout_height", this.this$0.height);
                        this.val$context.startActivity(intent);
                    } catch (Throwable th) {
                        if (this.this$0.intertitialChangeAdapter != null) {
                            this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "load image error");
                        }
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    if (this.this$0.intertitialChangeAdapter != null) {
                        this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "load image error");
                    }
                    th2.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadVideoType(Activity activity) {
        ExecutorService executorService = f0.f39362a;
        f0.b.f39363a.a(new AnonymousClass2(this, activity));
    }

    private void showNativeAd(Activity activity) {
        if (activity != null) {
            SsdInterstitialActivity.setCustomAd(this.intertitialChangeAdapter);
            if (this.ad.getAdPatternType() != 2) {
                loadImageType(activity, this.ad.getImgUrls()[0]);
                return;
            }
            try {
                z.a(this.ad.getImgUrls()[0], new z.k(this, activity) { // from class: com.kc.dw.platform.custom.ca.intertitial.FeedChangeIntertitial.1
                    public final FeedChangeIntertitial this$0;
                    public final Activity val$context;

                    {
                        this.this$0 = this;
                        this.val$context = activity;
                    }

                    @Override // com.kc.dw.core.utils.z.k
                    public void fail() {
                        LogUtil.d(FeedChangeIntertitial.TAG, "videoLinkValid=false");
                        if (this.this$0.intertitialChangeAdapter != null) {
                            this.this$0.intertitialChangeAdapter.changeRenderError(b.c.intValue(), "插屏视频渲染失败");
                        }
                    }

                    @Override // com.kc.dw.core.utils.z.k
                    public void success() {
                        LogUtil.d(FeedChangeIntertitial.TAG, "videoLinkValid=true");
                        this.this$0.loadVideoType(this.val$context);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.platform.custom.ca.intertitial.IIntertitialChangeAd
    public void createIntertitialAd(Context context, MsCustomRecyclerFeedAd msCustomRecyclerFeedAd, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        this.ad = msCustomRecyclerFeedAd;
        this.adSlot = ssdAdSlot;
    }

    @Override // com.kc.dw.platform.custom.ca.intertitial.IIntertitialChangeAd
    public void showAd(Activity activity) {
        try {
            showNativeAd(activity);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
