package com.kc.openset.third.custom.tobid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.kc.openset.ad.base.bridge.utils.ImgLoadUtilsBridge;
import com.kc.openset.ad.native_view.OSETNativeViewAd;
import com.kc.openset.bean.QDImages;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.windmill.sdk.custom.WMCustomNativeAdapter;
import com.windmill.sdk.natives.WMImage;
import com.windmill.sdk.natives.WMNativeAdContainer;
import com.windmill.sdk.natives.WMNativeAdData;
import com.windmill.sdk.natives.WMNativeAdRender;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class OSETToBidUnifiedAdData extends WMNativeAdData {
    private Activity activity;
    private final WMCustomNativeAdapter adAdapter;
    private Bitmap logoBitmap;
    private final OSETNativeViewAd mOsetNativeViewAd;
    private final OSETQDNativeViewAd mQDNativeViewAd;
    private WMNativeAdData.NativeAdInteractionListener nativeAdListener;

    public OSETToBidUnifiedAdData(Activity activity, OSETNativeViewAd oSETNativeViewAd, WMCustomNativeAdapter wMCustomNativeAdapter) {
        this.activity = activity;
        this.mOsetNativeViewAd = oSETNativeViewAd;
        OSETQDNativeViewAd qDNativeViewAd = oSETNativeViewAd.getQDNativeViewAd();
        this.mQDNativeViewAd = qDNativeViewAd;
        this.adAdapter = wMCustomNativeAdapter;
        if (qDNativeViewAd != null) {
            new Thread(new Runnable() { // from class: com.kc.openset.third.custom.tobid.OSETToBidUnifiedAdData.1
                @Override // java.lang.Runnable
                public void run() {
                    OSETToBidUnifiedAdData oSETToBidUnifiedAdData = OSETToBidUnifiedAdData.this;
                    oSETToBidUnifiedAdData.logoBitmap = oSETToBidUnifiedAdData.downloadBitmap(oSETToBidUnifiedAdData.mQDNativeViewAd.getAdSourceImg());
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x006f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:? A[SYNTHETIC] */
    public Bitmap downloadBitmap(String str) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        HttpURLConnection httpURLConnection2;
        Bitmap bitmapDecodeStream;
        InputStream inputStream2 = null;
        bitmap = null;
        Bitmap bitmap = null;
        InputStream inputStream3 = null;
        inputStream2 = null;
        try {
            try {
                if (!str.startsWith("http://") && !str.startsWith("https://")) {
                    return null;
                }
                httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(5000);
                    httpURLConnection2.setReadTimeout(5000);
                    httpURLConnection2.setDoInput(true);
                    httpURLConnection2.connect();
                    if (httpURLConnection2.getResponseCode() == 200) {
                        InputStream inputStream4 = httpURLConnection2.getInputStream();
                        try {
                            bitmapDecodeStream = BitmapFactory.decodeStream(inputStream4);
                            inputStream3 = inputStream4;
                        } catch (IOException e) {
                            httpURLConnection = httpURLConnection2;
                            e = e;
                            inputStream = inputStream4;
                            e.printStackTrace();
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection2 = httpURLConnection;
                            }
                            return bitmap;
                        } catch (Throwable th) {
                            httpURLConnection = httpURLConnection2;
                            th = th;
                            inputStream2 = inputStream4;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                throw th;
                            }
                            httpURLConnection.disconnect();
                            throw th;
                        }
                    } else {
                        bitmapDecodeStream = null;
                    }
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    bitmap = bitmapDecodeStream;
                } catch (IOException e5) {
                    inputStream = null;
                    httpURLConnection = httpURLConnection2;
                    e = e5;
                } catch (Throwable th2) {
                    httpURLConnection = httpURLConnection2;
                    th = th2;
                }
                httpURLConnection2.disconnect();
                return bitmap;
            } catch (IOException e6) {
                e = e6;
                httpURLConnection = null;
                inputStream = null;
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
            }
            e.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
                httpURLConnection2 = httpURLConnection;
                httpURLConnection2.disconnect();
            }
            return bitmap;
        } catch (Throwable th4) {
            th = th4;
            inputStream2 = inputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (httpURLConnection != null) {
                throw th;
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }

    public void bindImageViews(Context context, List<ImageView> list, int i) {
        List<QDImages> adImageUrls;
        try {
            OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
            if (oSETQDNativeViewAd != null && !oSETQDNativeViewAd.isVideoMaterial() && (adImageUrls = this.mQDNativeViewAd.getAdImageUrls()) != null && adImageUrls.size() != 0 && list != null && list.size() != 0) {
                QDImages qDImages = adImageUrls.get(0);
                ImageView imageView = list.get(0);
                if (qDImages != null && imageView != null) {
                    ImgLoadUtilsBridge.loadImage(context, qDImages.getUrl(), imageView);
                    if (this.mQDNativeViewAd.enableRotate()) {
                        View rotateView = this.mQDNativeViewAd.getRotateView(context);
                        ViewParent parent = imageView.getParent();
                        if (rotateView == null || parent == null) {
                            return;
                        }
                        ((ViewGroup) parent).addView(rotateView);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public void bindMediaView(final Context context, final ViewGroup viewGroup) {
        if (this.mQDNativeViewAd != null) {
            viewGroup.post(new Runnable() { // from class: com.kc.openset.third.custom.tobid.OSETToBidUnifiedAdData.4
                @Override // java.lang.Runnable
                public void run() {
                    View rotateView;
                    View videoView = OSETToBidUnifiedAdData.this.mQDNativeViewAd.getVideoView(context);
                    if (videoView != null) {
                        viewGroup.removeAllViews();
                        viewGroup.addView(videoView);
                    }
                    if (!OSETToBidUnifiedAdData.this.mQDNativeViewAd.enableRotate() || (rotateView = OSETToBidUnifiedAdData.this.mQDNativeViewAd.getRotateView(context)) == null) {
                        return;
                    }
                    viewGroup.addView(rotateView);
                }
            });
        }
    }

    public void bindViewForInteraction(Context context, View view, List<View> list, List<View> list2, View view2) {
        try {
            if (this.mQDNativeViewAd != null) {
                if (this.activity == null) {
                    this.activity = (Activity) context;
                }
                this.mQDNativeViewAd.registerViewForInteraction(this.activity, (ViewGroup) view, (list2 == null || list2.size() <= 0) ? null : list2.get(0), view2, list, new OSETQDNativeViewAd.OnQDAdInteractionListener() { // from class: com.kc.openset.third.custom.tobid.OSETToBidUnifiedAdData.3
                    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd.OnQDAdInteractionListener
                    public void onAdClicked(OSETQDNativeViewAd oSETQDNativeViewAd) {
                        if (OSETToBidUnifiedAdData.this.nativeAdListener != null && OSETToBidUnifiedAdData.this.adAdapter != null) {
                            OSETToBidUnifiedAdData.this.nativeAdListener.onADClicked(OSETToBidUnifiedAdData.this.adAdapter.getAdInFo(OSETToBidUnifiedAdData.this));
                        }
                        if (OSETToBidUnifiedAdData.this.adAdapter != null) {
                            OSETToBidUnifiedAdData.this.adAdapter.callNativeAdClick(OSETToBidUnifiedAdData.this);
                        }
                    }

                    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd.OnQDAdInteractionListener
                    public void onAdClosed(OSETQDNativeViewAd oSETQDNativeViewAd) {
                    }

                    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd.OnQDAdInteractionListener
                    public void onAdDetailViewClosed(OSETQDNativeViewAd oSETQDNativeViewAd) {
                    }

                    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd.OnQDAdInteractionListener
                    public void onAdShow(OSETQDNativeViewAd oSETQDNativeViewAd) {
                        if (OSETToBidUnifiedAdData.this.nativeAdListener != null && OSETToBidUnifiedAdData.this.adAdapter != null) {
                            OSETToBidUnifiedAdData.this.nativeAdListener.onADExposed(OSETToBidUnifiedAdData.this.adAdapter.getAdInFo(OSETToBidUnifiedAdData.this));
                        }
                        if (OSETToBidUnifiedAdData.this.adAdapter != null) {
                            OSETToBidUnifiedAdData.this.adAdapter.callNativeAdShow(OSETToBidUnifiedAdData.this);
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public void connectAdToView(Activity activity, WMNativeAdContainer wMNativeAdContainer, WMNativeAdRender wMNativeAdRender) {
        this.activity = activity;
        if (wMNativeAdRender != null) {
            try {
                View viewCreateView = wMNativeAdRender.createView(activity, getAdPatternType());
                wMNativeAdRender.renderAdView(viewCreateView, this);
                if (wMNativeAdContainer != null) {
                    wMNativeAdContainer.removeAllViews();
                    wMNativeAdContainer.addView(viewCreateView, new ViewGroup.LayoutParams(-1, -2));
                }
            } catch (Exception unused) {
            }
        }
    }

    public void destroy() {
        OSETNativeViewAd oSETNativeViewAd = this.mOsetNativeViewAd;
        if (oSETNativeViewAd != null) {
            oSETNativeViewAd.destroy();
        }
        Bitmap bitmap = this.logoBitmap;
        if (bitmap != null) {
            bitmap.recycle();
            this.logoBitmap = null;
        }
    }

    public Bitmap getAdLogo() {
        Activity activity;
        if (this.logoBitmap == null && (activity = this.activity) != null) {
            this.logoBitmap = DrawableUtils.toBitmap(activity.getResources().getDrawable(R.drawable.qidian_logo));
        }
        return this.logoBitmap;
    }

    public int getAdPatternType() {
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        if (oSETQDNativeViewAd != null) {
            return oSETQDNativeViewAd.isVideoMaterial() ? 4 : 2;
        }
        return 0;
    }

    public String getCTAText() {
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        return oSETQDNativeViewAd != null ? oSETQDNativeViewAd.getAdActionText() : "";
    }

    public String getDesc() {
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        return oSETQDNativeViewAd != null ? oSETQDNativeViewAd.getAdContent() : "";
    }

    public View getExpressAdView() {
        return null;
    }

    public String getIconUrl() {
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        return oSETQDNativeViewAd != null ? oSETQDNativeViewAd.getAdIcon() : "";
    }

    public List<WMImage> getImageList() {
        List<QDImages> adImageUrls;
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        if (oSETQDNativeViewAd == null || (adImageUrls = oSETQDNativeViewAd.getAdImageUrls()) == null || adImageUrls.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (final QDImages qDImages : adImageUrls) {
            if (qDImages != null) {
                arrayList.add(new WMImage() { // from class: com.kc.openset.third.custom.tobid.OSETToBidUnifiedAdData.2
                    public int getHeight() {
                        return qDImages.getHeight();
                    }

                    public String getImageUrl() {
                        return qDImages.getUrl();
                    }

                    public int getWidth() {
                        return qDImages.getWidth();
                    }

                    public boolean isValid() {
                        return true;
                    }
                });
            }
        }
        return arrayList;
    }

    public List<String> getImageUrlList() {
        List<QDImages> adImageUrls;
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        if (oSETQDNativeViewAd == null || (adImageUrls = oSETQDNativeViewAd.getAdImageUrls()) == null || adImageUrls.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<QDImages> it = adImageUrls.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getUrl());
        }
        return arrayList;
    }

    public int getInteractionType() {
        return 0;
    }

    public OSETNativeViewAd getNativeExpressAd() {
        return this.mOsetNativeViewAd;
    }

    public int getNetworkId() {
        WMCustomNativeAdapter wMCustomNativeAdapter = this.adAdapter;
        if (wMCustomNativeAdapter != null) {
            return wMCustomNativeAdapter.getChannelId();
        }
        return 0;
    }

    public String getTitle() {
        OSETQDNativeViewAd oSETQDNativeViewAd = this.mQDNativeViewAd;
        return oSETQDNativeViewAd != null ? oSETQDNativeViewAd.getAdTitle() : "";
    }

    public boolean isExpressAd() {
        return false;
    }

    public boolean isNativeDrawAd() {
        return false;
    }

    public void render() {
    }

    public void setDislikeInteractionCallback(Activity activity, WMNativeAdData.DislikeInteractionCallback dislikeInteractionCallback) {
        this.activity = activity;
    }

    public void setDownloadListener(WMNativeAdData.AppDownloadListener appDownloadListener) {
    }

    public void setInteractionListener(WMNativeAdData.NativeAdInteractionListener nativeAdInteractionListener) {
        if (nativeAdInteractionListener != null) {
            this.nativeAdListener = nativeAdInteractionListener;
        }
    }

    public void setMediaListener(WMNativeAdData.NativeADMediaListener nativeADMediaListener) {
    }
}
