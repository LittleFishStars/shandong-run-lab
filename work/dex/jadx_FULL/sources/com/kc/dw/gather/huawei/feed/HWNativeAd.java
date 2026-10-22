package com.kc.dw.gather.huawei.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeView;
import com.kc.dw.core.ad.recycler.RecyclerAdUtils;
import com.kc.dw.core.view.TouchAdContainer;
import com.kc.dw.core.view.TouchPositionListener;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWNativeAd extends MsCustomRecyclerFeedAd {
    private final NativeAd nativeAd;

    public HWNativeAd(NativeAd nativeAd) {
        this.nativeAd = nativeAd;
        if (nativeAd == null) {
            return;
        }
        setAdPatternType(getPatternType());
        setTitle(nativeAd.getTitle());
        setDesc(nativeAd.getDescription());
        setActionText(nativeAd.getCallToAction());
        try {
            setIconUrl(nativeAd.getIcon().getUri().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List images = nativeAd.getImages();
            if (images != null && images.size() > 0) {
                String[] strArr = new String[images.size()];
                for (int i = 0; i < images.size(); i++) {
                    strArr[i] = ((Image) images.get(i)).getUri().toString();
                }
                setImgUrls(strArr);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        setMediaView(getMedia());
    }

    private View getMedia() {
        MediaView mediaView = new MediaView(this.mediaView.getContext());
        mediaView.setMediaContent(this.nativeAd.getMediaContent());
        if (getAdPatternType() == 2) {
            getAdView().setNativeAd(this.nativeAd);
        }
        return mediaView;
    }

    private int getPatternType() {
        int creativeType = this.nativeAd.getCreativeType();
        if (creativeType == 2 || creativeType == 3) {
            return 12;
        }
        if (creativeType != 6 && creativeType != 106) {
            if (creativeType == 108 || creativeType == 8) {
                return 13;
            }
            if (creativeType != 9) {
                return (creativeType == 102 || creativeType == 103) ? 12 : 11;
            }
        }
        return 2;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        View[] info = RecyclerAdUtils.getInfo(viewGroup, getClass(), NativeView.class);
        View nativeView = (NativeView) info[1];
        if (nativeView == null) {
            View view = info[0];
            nativeView = new NativeView(view.getContext());
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                int iIndexOfChild = viewGroup2.indexOfChild(view);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                viewGroup2.removeView(view);
                TouchAdContainer touchAdContainer = new TouchAdContainer(view.getContext());
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                touchAdContainer.addView(view, layoutParams2);
                nativeView.setId(view.getId());
                nativeView.addView(touchAdContainer, layoutParams2);
                viewGroup2.addView(nativeView, iIndexOfChild, layoutParams);
            }
        }
        if (getAdPatternType() != 2) {
            nativeView.setNativeAd(this.nativeAd);
        }
    }
}
