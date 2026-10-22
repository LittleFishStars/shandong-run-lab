package com.kc.dw.core.ad.recycler;

import android.text.TextUtils;
import com.kc.dw.ad.nativ.i;
import com.kc.dw.base.a;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomVideo {
    private static final String TAG = "MsCustomVideo";
    private i adSlot;
    private boolean isStarted;

    public MsCustomVideo(i iVar) {
        this.adSlot = iVar;
    }

    public void reportVideoClose() {
        try {
            LogUtil.d(TAG, "send onVideoClose");
            String[] strArr = this.adSlot.u;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoComplete() {
        try {
            LogUtil.d(TAG, "send onVideoComplete");
            String[] strArr = this.adSlot.n;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoMute() {
        try {
            LogUtil.d(TAG, "send onVideoMute");
            String[] strArr = this.adSlot.q;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoOneHalf() {
        try {
            LogUtil.d(TAG, "send onVideoOneHalf");
            String[] strArr = this.adSlot.l;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoOneQuarter() {
        try {
            LogUtil.d(TAG, "send onVideoOneQuarter");
            String[] strArr = this.adSlot.k;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoPause() {
        try {
            LogUtil.d(TAG, "send onVideoPause");
            String[] strArr = this.adSlot.o;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoReplay() {
        try {
            LogUtil.d(TAG, "send onVideoReplay");
            String[] strArr = this.adSlot.s;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoResume() {
        try {
            LogUtil.d(TAG, "send onVideoResume");
            String[] strArr = this.adSlot.p;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoSkip() {
        try {
            LogUtil.d(TAG, "send onVideoSkip");
            String[] strArr = this.adSlot.t;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoStart() {
        try {
            LogUtil.d(TAG, "send onVideoStart");
            if (this.isStarted) {
                return;
            }
            String[] strArr = this.adSlot.j;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
            this.isStarted = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoThreeQuarter() {
        try {
            LogUtil.d(TAG, "send onVideoThreeQuarter");
            String[] strArr = this.adSlot.m;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reportVideoUnmute() {
        try {
            LogUtil.d(TAG, "send onVideoUnmute");
            String[] strArr = this.adSlot.r;
            if (strArr != null) {
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(a.getContext(), g0.a(str), new j());
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
