package com.kc.dw.core.ad;

import android.content.Context;
import com.kc.dw.activity.SsdRewardVideoPlayerActivity;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.core.ad.IAdEventListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class b<T extends IAdEventListener> extends com.kc.dw.core.loader.a<T> {
    private static final String TAG = "BaseFullScreenVideoAdLoader";
    private boolean isMute;
    private ArrayList<String> mediaViewIdList = new ArrayList<>();

    public void addRewardMediaViewLocalId(String str) {
        this.mediaViewIdList.add(str);
    }

    public abstract com.kc.dw.core.loader.b createOwnAdDelegateInternal(i iVar);

    @Override // com.kc.dw.core.loader.a, com.kc.dw.core.loader.IAdLoader
    public void destroy() {
        SsdRewardVideoPlayerActivity.clearRewardMediaView();
        this.mediaViewIdList.clear();
    }

    public boolean getVideoIsMute() {
        return this.isMute;
    }

    @Override // com.kc.dw.core.loader.a
    public void init(Context context, SsdAdSlot ssdAdSlot, T t) {
        super.init(context, ssdAdSlot, t);
        this.isMute = ssdAdSlot != null ? ssdAdSlot.getIsMute() : true;
    }

    public void setVideoIsMute(boolean z) {
        this.isMute = z;
    }
}
