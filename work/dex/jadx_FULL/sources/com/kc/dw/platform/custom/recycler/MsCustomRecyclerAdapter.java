package com.kc.dw.platform.custom.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.recycler.FeedAd;
import com.kc.dw.core.ad.recycler.RecyclerAdEventAdapterListener;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomRecyclerAdapter extends BasePlatformLoader<RecyclerMixCommonAdLoader, RecyclerAdEventAdapterListener> {
    private static final String TAG = "MsCustomRecyclerAdapter";

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements CustomInitLoader.InitCallback {
        public final MsCustomRecyclerAdapter this$0;

        public AnonymousClass1(MsCustomRecyclerAdapter msCustomRecyclerAdapter) {
            this.this$0 = msCustomRecyclerAdapter;
        }

        @Override // com.kc.dw.platform.custom.CustomInitLoader.InitCallback
        public void fail() {
            try {
                if (this.this$0.getConCurrentListener() != null) {
                    this.this$0.getConCurrentListener().onLoadedError(200001, "ADN init error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.platform.custom.CustomInitLoader.InitCallback
        public void succ() {
            SdkHandler.runOnMainThread(new Runnable(this) { // from class: com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter.1.1
                public final AnonymousClass1 this$1;

                {
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SsdAdSlot changeAdSlot;
                    try {
                        CustomInfo customInfo = new CustomInfo();
                        if (this.this$1.this$0.getSdkAdInfo() != null && !"SSD".equals(this.this$1.this$0.getSdkAdInfo().getSdk())) {
                            if (!this.this$1.this$0.getIsChangeAdapter()) {
                                a.a(5, "e2", this.this$1.this$0);
                                z.a(com.kc.dw.base.a.getContext(), g0.a(this.this$1.this$0.getSdkAdInfo().getReq()), new j());
                            }
                            customInfo.setApp_id(this.this$1.this$0.getSdkAdInfo().getApp_id());
                            customInfo.setApp_key(this.this$1.this$0.getSdkAdInfo().getApp_key());
                            customInfo.setReqId(this.this$1.this$0.getSdkAdInfo().getReq_id());
                            customInfo.setPid(this.this$1.this$0.getSdkAdInfo().getPid());
                            if (this.this$1.this$0.getSdkAdInfo().getDrawing() == 1) {
                                customInfo.setExpress(false);
                            } else {
                                customInfo.setExpress(true);
                            }
                        }
                        try {
                            changeAdSlot = this.this$1.this$0.getAdLoader().getAdSlot();
                        } catch (Exception e) {
                            e.printStackTrace();
                            changeAdSlot = null;
                        }
                        if (changeAdSlot == null) {
                            changeAdSlot = this.this$1.this$0.getChangeAdSlot();
                        }
                        MsCustomRecyclerAdapter msCustomRecyclerAdapter = this.this$1.this$0;
                        msCustomRecyclerAdapter.loadCustomAd(msCustomRecyclerAdapter.getContext(), changeAdSlot, customInfo);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public void callLoadedError(int i, String str) {
        try {
            if (getChangeListener() != null) {
                getChangeListener().onLoadedError(i, str);
            } else if (getConCurrentListener() != null) {
                getConCurrentListener().onLoadedError(i, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callLoadedSuccess(List<? extends FeedAd> list) {
        if (list != null) {
            try {
                for (FeedAd feedAd : list) {
                    if (TextUtils.isEmpty(feedAd.getPlatform())) {
                        feedAd.setPlatform(getPlatform());
                    }
                    if (feedAd.getPlatformLoader() == null) {
                        feedAd.setPlatformLoader(this);
                    }
                }
                if (getChangeListener() != null) {
                    getChangeListener().onLoadedSuccess(list);
                } else if (getConCurrentListener() != null) {
                    getConCurrentListener().onLoadedSuccess(list);
                    getConCurrentListener().onRenderSuccess(list);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public String getPlatform() {
        CustomInitLoader initLoader;
        try {
            return (getSdkAdInfo() == null || TextUtils.isEmpty(getSdkAdInfo().getInitCls()) || (initLoader = CustomFactory.getInitLoader(getSdkAdInfo().getInitCls())) == null) ? "SSD" : initLoader.getPlatform();
        } catch (Exception e) {
            e.printStackTrace();
            return "SSD";
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        initADN(new AnonymousClass1(this));
    }

    public abstract void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo);

    public void setEcpm(int i) {
        if (getSdkAdInfo() != null) {
            getSdkAdInfo().setEcpm(String.valueOf(i));
        }
    }
}
