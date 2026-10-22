package cn.hzjizhun.admin.custom_ad;

import android.content.Context;
import android.view.View;
import cn.hzjizhun.admin.JZUnifiedADContainer;
import cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader;
import cn.hzjizhun.admin.ad.bean.Cs;
import cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo;
import cn.hzjizhun.admin.ad.impl.JZUnifiedAD;
import cn.hzjizhun.admin.ad.listener.JZUnifiedADListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AdapterCustomUnifiedAdLoader extends AdapterCustomAdLoader<JZUnifiedAdInfo, JZUnifiedADListener, JZUnifiedAD> {
    private boolean isExpose = false;
    private CustomJZUnifiedAdInfo mAdInfo;

    public class AdClickListener implements View.OnClickListener {
        private AdClickListener() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AdapterCustomUnifiedAdLoader.this.adClickSource(Cs.MC);
        }
    }

    public void bindAdView(Context context, final JZUnifiedADContainer jZUnifiedADContainer, List<View> list, List<View> list2) {
        if (this.mIsReleased || this.mAdObject == null || jZUnifiedADContainer == null) {
            return;
        }
        if (list != null && list.size() > 0) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(new AdClickListener());
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            for (View view2 : list2) {
                if (view2 != null) {
                    view2.setOnClickListener(new AdClickListener());
                }
            }
        }
        jZUnifiedADContainer.postDelayed(new Runnable() { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomUnifiedAdLoader.2
            @Override // java.lang.Runnable
            public void run() {
                if ((jZUnifiedADContainer.getChangeCount() > 0 || jZUnifiedADContainer.isRectVisible()) && !AdapterCustomUnifiedAdLoader.this.isExpose) {
                    AdapterCustomUnifiedAdLoader.this.isExpose = true;
                    AdapterCustomUnifiedAdLoader.this.onAdExposeListener();
                }
            }
        }, 400L);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public void renderView() {
        super.renderView();
        CustomJZUnifiedAdInfo customJZUnifiedAdInfo = this.mAdInfo;
        if (customJZUnifiedAdInfo != null) {
            customJZUnifiedAdInfo.setAdObject(this.mAdObject);
        }
        T t = this.mAd;
        if (t == 0 || ((JZUnifiedAD) t).getAdListener() == null) {
            return;
        }
        ((JZUnifiedAD) this.mAd).getAdListener().onADLoaded((JZUnifiedAdInfo) getAdInfo());
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterCustomAdLoader
    public void skipH5Listener(String str) {
        super.skipH5Listener(str);
        T t = this.mAd;
        if (t == 0 || ((JZUnifiedAD) t).getAdListener() == null) {
            return;
        }
        ((JZUnifiedAD) this.mAd).getAdListener().onAdClick((JZUnifiedAdInfo) getAdInfo(), str);
    }

    @Override // cn.hzjizhun.admin.ad.adapter.AdapterAdLoaderImp
    public JZUnifiedAdInfo createAdInfo() {
        CustomJZUnifiedAdInfo customJZUnifiedAdInfo = new CustomJZUnifiedAdInfo(this.mPosInfo, this) { // from class: cn.hzjizhun.admin.custom_ad.AdapterCustomUnifiedAdLoader.1
            @Override // cn.hzjizhun.admin.ad.bean.JZUnifiedAdInfo
            public void bindJZAdToView(Context context, JZUnifiedADContainer jZUnifiedADContainer, List<View> list, List<View> list2) {
                AdapterCustomUnifiedAdLoader.this.bindAdView(context, jZUnifiedADContainer, list, null);
            }
        };
        this.mAdInfo = customJZUnifiedAdInfo;
        return customJZUnifiedAdInfo;
    }
}
