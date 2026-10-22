package com.kc.aw;

import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _la {
    public static _la _e;
    public final ConcurrentHashMap _a = new ConcurrentHashMap();
    public final ConcurrentHashMap _b = new ConcurrentHashMap();
    public final ConcurrentHashMap _c = new ConcurrentHashMap();
    public final ConcurrentHashMap _d = new ConcurrentHashMap();

    public static _la _a() {
        if (_e == null) {
            synchronized (_la.class) {
                try {
                    if (_e == null) {
                        _e = new _la();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return _e;
    }

    public final void _a(long j, long j2, String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoProgressUpdate(j, j2);
        }
    }

    public final void _a(String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdShow();
        }
    }

    public final void _a(String str, int i, String str2) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoError(i, str2);
        }
    }

    public final void _a(String str, long j, long j2, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadActive(j, j2, str2);
        }
    }

    public final void _a(String str, AdErrorImpl adErrorImpl) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onRenderError(adErrorImpl);
        }
    }

    public final void _a(String str, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadFailed(str2);
        }
    }

    public final void _b(String str) {
        synchronized (this._a) {
            this._a.remove(str);
        }
        synchronized (this._b) {
            this._b.remove(str);
        }
        synchronized (this._c) {
            this._c.remove(str);
        }
        synchronized (this._d) {
            this._d.remove(str);
        }
    }

    public final void _b(String str, long j, long j2, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadPaused(j, j2, str2);
        }
    }

    public final void _b(String str, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadFinished(str2);
        }
    }

    public final void _c(String str) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onDownloadCancel();
        }
    }

    public final void _c(String str, String str2) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onInstalled(str2);
        }
    }

    public final void _d(String str) {
        List list = (List) this._d.get(str);
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgAppDownloadListener) it.next()).onIdle();
        }
    }

    public final void _e(String str) {
        List list;
        if (str == null || (list = (List) this._c.get(str)) == null || list.isEmpty()) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoStart();
        }
    }
}
