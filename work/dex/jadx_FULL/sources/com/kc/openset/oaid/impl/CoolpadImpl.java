package com.kc.openset.oaid.impl;

import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class CoolpadImpl implements IOAID {
    private static final String TAG = OSETSDKProtected.getString2(1873);
    private final Context context;

    @Keep
    public class a implements OAIDService.RemoteCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CoolpadImpl f39769a;

        static {
            OSETSDKProtected.interface11(4482);
        }

        public a(CoolpadImpl coolpadImpl) {
            this.f39769a = coolpadImpl;
        }

        @Override // com.kc.openset.oaid.impl.OAIDService.RemoteCaller
        public native String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4483);
    }

    public CoolpadImpl(Context context) {
        this.context = context instanceof Application ? context : context.getApplicationContext();
    }

    public static native /* synthetic */ Context access$000(CoolpadImpl coolpadImpl);

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
