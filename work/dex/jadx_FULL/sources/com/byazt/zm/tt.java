package com.byazt.zm;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.byazt.me.da;
import com.byazt.rm.a;
import com.byazt.rm.i;
import com.byazt.rm.n;
import com.byazt.rm.sp;
import com.byazt.rm.uj;
import com.byazt.rm.x;
import com.byazt.yf.z;
import com.byazt.yl.ve;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 482, 13})
public class tt extends ve {
    public n da;
    public com.byazt.dhf.c i;
    public x m;
    public com.byazt.rm.ve nu;
    public a rh;
    public z sl;
    public com.byazt.rm.tt t;
    public sp u;
    public com.byazt.ylx.c x;
    public i yp;
    public uj z;

    @Override // com.byazt.yl.ve
    public void bidLoseNotify(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            Object obj = map.get("bidding_lose_reason_NUM");
            if (obj instanceof Integer) {
                ((Integer) obj).intValue();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.yl.ve
    public void bidWinNotify(Map<String, Object> map) {
        if (this.x != null) {
            getCpm();
        }
        if (this.sl != null) {
            getCpm();
        }
    }

    @Override // com.byazt.yl.ve
    public void cancelDownload() {
    }

    @Override // com.byazt.yl.ve
    public void dislikeClick(String str, Map<String, Object> map) {
        super.dislikeClick(str, map);
    }

    @Override // com.byazt.yl.ve
    @Nullable
    public View getAdView() {
        com.byazt.ylx.c cVar = this.x;
        if (cVar != null && (cVar instanceof com.byazt.vz.c)) {
            return ((com.byazt.vz.c) cVar).c();
        }
        sp spVar = this.u;
        if (spVar != null) {
            return spVar.c();
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.dhf.c getDislikeCallback() {
        return this.i;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.nc.sp getDislikeDialog(Activity activity) {
        n nVar = this.da;
        return nVar != null ? nVar.c(activity) : super.getDislikeDialog(activity);
    }

    @Override // com.byazt.yl.ve
    public int getDownloadStatus() {
        a aVar = this.rh;
        if (aVar != null) {
            return aVar.c();
        }
        return -1;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.zh.tt getGMAdAppDownloadListener() {
        return this.ve;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.fy.c getGMDrawAdListener() {
        return this.f29207a;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.me.tt getGMNativeAdListener() {
        return this.c;
    }

    @Override // com.byazt.yl.ve
    @Nullable
    public com.byazt.me.n getGMNativeCustomVideoReporter() {
        com.byazt.rm.ve veVar = this.nu;
        if (veVar != null) {
            return veVar.tt();
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public com.byazt.me.x getGMVideoListener() {
        return this.tt;
    }

    public com.byazt.zq.a getTTAdapterCallback() {
        return this.sp;
    }

    @Override // com.byazt.yl.ve
    @Nullable
    public String getVideoUrl() {
        com.byazt.rm.ve veVar = this.nu;
        if (veVar != null) {
            return veVar.c();
        }
        return null;
    }

    @Override // com.byazt.yl.ve
    public View getVideoView() {
        com.byazt.rm.ve veVar = this.nu;
        return veVar != null ? veVar.ve() : super.getVideoView();
    }

    @Override // com.byazt.yl.ve
    public boolean hasDestroyed() {
        return false;
    }

    @Override // com.byazt.yl.ve
    public boolean hasDislike() {
        try {
            uj ujVar = this.z;
            if (ujVar != null) {
                return ujVar.c();
            }
        } catch (Exception unused) {
        }
        return super.hasDislike();
    }

    @Override // com.byazt.yl.ve
    public final Integer isReadyStatus() {
        x xVar = this.m;
        if (xVar != null) {
            return xVar.c();
        }
        com.byazt.ylx.c cVar = this.x;
        return cVar != null ? cVar.ve() : super.isReadyStatus();
    }

    public final void nativeDislikeClick(String str) {
        com.byazt.ylx.c cVar = this.x;
        if (cVar != null) {
            cVar.c(this, str);
        }
    }

    @Override // com.byazt.yl.ve
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.byazt.yl.ve
    public void onPause() {
        super.onPause();
    }

    @Override // com.byazt.yl.ve
    public void onResume() {
        super.onResume();
    }

    @Override // com.byazt.yl.ve
    public void pauseAppDownload() {
    }

    @Override // com.byazt.yl.ve
    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, da daVar, List<View> list4) {
    }

    @Override // com.byazt.yl.ve
    public void render() {
    }

    @Override // com.byazt.yl.ve
    public void resumeAppDownload() {
    }

    public void setCustomNativeConvert(com.byazt.rm.tt ttVar) {
        this.t = ttVar;
    }

    public void setCustomNativeCustomizeVideoConvert(com.byazt.rm.ve veVar) {
        this.nu = veVar;
    }

    public void setCustomNativeDownloadStatusControllerConvert(a aVar) {
        this.rh = aVar;
    }

    public void setCustomNativeExpressConvert(sp spVar) {
        this.u = spVar;
    }

    public void setCustomNativeLifecycleConvert(i iVar) {
        this.yp = iVar;
    }

    @Override // com.byazt.yl.ve
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
        this.i = cVar;
    }

    public void setDislikeDialogCallBack(n nVar) {
        this.da = nVar;
    }

    public void setGMCustomBaseAdapter(com.byazt.ylx.c cVar) {
        this.x = cVar;
    }

    public void setGmReceiveBidResultCallback(z zVar) {
        this.sl = zVar;
    }

    public void setIGMCustomNativeDislikeConvert(uj ujVar) {
        this.z = ujVar;
    }

    public void setIGMCustomNativeIsReadyStatusConvert(x xVar) {
        this.m = xVar;
    }

    @Override // com.byazt.yl.ve
    public void showAd(Activity activity, Object obj, String str) {
        com.byazt.ylx.c cVar = this.x;
        if (cVar == null || !(cVar instanceof com.byazt.ylx.tt)) {
            return;
        }
        ((com.byazt.ylx.tt) cVar).c(activity);
    }

    @Override // com.byazt.yl.ve
    public void showSplashAd(ViewGroup viewGroup) {
        com.byazt.ylx.c cVar = this.x;
        if (cVar == null || !(cVar instanceof com.byazt.xi.c)) {
            return;
        }
        ((com.byazt.xi.c) cVar).c(viewGroup);
    }

    @Override // com.byazt.yl.ve
    public void unregisterView() {
    }
}
