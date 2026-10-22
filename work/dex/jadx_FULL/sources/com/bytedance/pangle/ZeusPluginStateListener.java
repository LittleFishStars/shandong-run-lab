package com.bytedance.pangle;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.byazt.uk.sl;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public abstract class ZeusPluginStateListener {
    public static final int EVENT_DOWNLOAD_FAILED = 4;
    public static final int EVENT_DOWNLOAD_PROGRESS = 2;
    public static final int EVENT_DOWNLOAD_START = 1;
    public static final int EVENT_DOWNLOAD_SUCCESS = 3;
    public static final int EVENT_INSTALL_DEX_START = 11;
    public static final int EVENT_INSTALL_DEX_SUCCESS = 12;
    public static final int EVENT_INSTALL_FAILED = 7;
    public static final int EVENT_INSTALL_START = 5;
    public static final int EVENT_INSTALL_SUCCESS = 6;
    public static final int EVENT_LOAD_DEX_START = 13;
    public static final int EVENT_LOAD_DEX_SUCCESS = 14;
    public static final int EVENT_LOAD_FAILED = 10;
    public static final int EVENT_LOAD_START = 8;
    public static final int EVENT_LOAD_SUCCESS = 9;
    public static final int EVENT_REQUEST_FINISH = 0;
    public static final Handler mHandler = new Handler(Looper.getMainLooper());

    public static void postStateChange(@Nullable final String str, final int i, final Object... objArr) {
        mHandler.post(new Runnable() { // from class: com.bytedance.pangle.ZeusPluginStateListener.1
            @Override // java.lang.Runnable
            public void run() {
                List<ZeusPluginStateListener> listVe = sl.c().ve();
                if (listVe == null || listVe.size() <= 0) {
                    return;
                }
                Iterator<ZeusPluginStateListener> it = listVe.iterator();
                while (it.hasNext()) {
                    it.next().onPluginStateChange(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i, objArr);
                }
            }
        });
        List<ZeusPluginStateListener> listVe = sl.c().ve();
        if (listVe == null || listVe.size() <= 0) {
            return;
        }
        Iterator<ZeusPluginStateListener> it = listVe.iterator();
        while (it.hasNext()) {
            it.next().onStateChangeOnCurThread(TextUtils.isEmpty(str) ? "UNKNOWN" : str, i, objArr);
        }
    }

    @Deprecated
    public void onPluginStateChange(String str, int i, Object... objArr) {
    }

    public void onStateChangeOnCurThread(String str, int i, Object... objArr) {
    }
}
