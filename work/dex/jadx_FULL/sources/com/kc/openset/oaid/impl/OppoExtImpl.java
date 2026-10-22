package com.kc.openset.oaid.impl;

import android.content.Context;
import android.os.IBinder;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OppoExtImpl extends j {
    private static final String ACTION = OSETSDKProtected.getString2(1896);
    private static final String CLASS_NAME = OSETSDKProtected.getString2(1898);
    private static final String PACKAGE_NAME = OSETSDKProtected.getString2(1897);
    private static final String TAG = OSETSDKProtected.getString2(SecExceptionCode.SEC_ERROR_GENERIC_AVMP_INVALID_ARGS);
    private final Context context;

    @Keep
    public class a implements OAIDService.RemoteCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OppoExtImpl f39772a;

        static {
            OSETSDKProtected.interface11(4490);
        }

        public a(OppoExtImpl oppoExtImpl) {
            this.f39772a = oppoExtImpl;
        }

        @Override // com.kc.openset.oaid.impl.OAIDService.RemoteCaller
        public native String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4491);
    }

    public OppoExtImpl(Context context) {
        super(context);
        this.context = context;
    }

    @Override // com.kc.openset.oaid.impl.j, com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.impl.j
    public native String getSerId(IBinder iBinder, String str, String str2);

    @Override // com.kc.openset.oaid.impl.j, com.kc.openset.oaid.IOAID
    public native boolean supported();
}
