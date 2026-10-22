package com.kc.openset.oaid.impl;

import android.content.Context;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class f implements IOAID {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39786a;

    @Keep
    public class a implements OAIDService.RemoteCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f f39787a;

        static {
            OSETSDKProtected.interface11(4508);
        }

        public a(f fVar) {
            this.f39787a = fVar;
        }

        @Override // com.kc.openset.oaid.impl.OAIDService.RemoteCaller
        public native String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4509);
    }

    public f(Context context) {
        this.f39786a = context;
    }

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
