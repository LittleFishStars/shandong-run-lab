package com.kc.openset.oaid.impl;

import android.content.Context;
import android.os.IBinder;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class QikuImpl implements IOAID {
    private static final String TAG = OSETSDKProtected.getString2(SecExceptionCode.SEC_ERROR_GENERIC_AVMP_NO_DATA_FILE);
    private final Context context;
    private boolean mUseQikuId = true;

    @Keep
    public class a implements OAIDService.RemoteCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final QikuImpl f39773a;

        static {
            OSETSDKProtected.interface11(4492);
        }

        public a(QikuImpl qikuImpl) {
            this.f39773a = qikuImpl;
        }

        @Override // com.kc.openset.oaid.impl.OAIDService.RemoteCaller
        public native String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4493);
    }

    public QikuImpl(Context context) {
        this.context = context;
    }

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
