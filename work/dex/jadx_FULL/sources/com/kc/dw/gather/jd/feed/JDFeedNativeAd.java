package com.kc.dw.gather.jd.feed;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class JDFeedNativeAd extends MsCustomRecyclerFeedAd {
    private final JADMaterialData ad;
    private final JADNative jadNative;

    public JDFeedNativeAd(JADNative jADNative, JADMaterialData jADMaterialData) {
        this.jadNative = jADNative;
        this.ad = jADMaterialData;
        if (jADMaterialData != null) {
            try {
                setTitle(jADMaterialData.getTitle());
                setDesc(jADMaterialData.getDescription());
                setFrom(jADMaterialData.getResource());
                List imageUrls = jADMaterialData.getImageUrls();
                if (imageUrls != null && !imageUrls.isEmpty()) {
                    this.imgUrls = new String[imageUrls.size()];
                    Iterator it = imageUrls.iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        this.imgUrls[i] = (String) it.next();
                        i++;
                    }
                }
                setWidth(jADMaterialData.getImageWidth());
                setHeight(jADMaterialData.getImageHeight());
                setAdPatternType(getAdPatternType(jADMaterialData));
                setInteractionType(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getAdPatternType(JADMaterialData jADMaterialData) {
        return (jADMaterialData.getImageUrls() == null || 1 >= jADMaterialData.getImageUrls().size()) ? 12 : 13;
    }

    @Override // com.kc.dw.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        this.jadNative.registerNativeView((Activity) context, viewGroup, list, (List) null, new JADNativeInteractionListener(this) { // from class: com.kc.dw.gather.jd.feed.JDFeedNativeAd.1
            public final JDFeedNativeAd this$0;

            {
                this.this$0 = this;
            }

            public void onClick(View view) {
                this.this$0.callAdClicked();
            }

            public void onClose(View view) {
                this.this$0.callAdClosed();
            }

            public void onExposure() {
                this.this$0.callAdExposure();
            }
        });
    }
}
