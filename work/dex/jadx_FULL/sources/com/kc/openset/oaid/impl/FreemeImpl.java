package com.kc.openset.oaid.impl;

import android.content.Context;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FreemeImpl implements IOAID {
    private static final String TAG = OSETSDKProtected.getString2(1882);
    private final Context context;

    @Keep
    public class a implements OAIDService.RemoteCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final FreemeImpl f39770a;

        static {
            OSETSDKProtected.interface11(4485);
        }

        public a(FreemeImpl freemeImpl) {
            this.f39770a = freemeImpl;
        }

        @Override // com.kc.openset.oaid.impl.OAIDService.RemoteCaller
        public native String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4486);
    }

    public FreemeImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
