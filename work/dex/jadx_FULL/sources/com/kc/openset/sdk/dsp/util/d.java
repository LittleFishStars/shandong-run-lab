package com.kc.openset.sdk.dsp.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.sdk.apiad.InteractType;
import com.kc.openset.sdk.apiad.tools.APIAdClickCallback;
import com.kc.openset.sdk.apiad.tools.OSETClicksData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class d {

    @Keep
    public class a implements APIAdClickCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETClicksData f39928a;
        final com.kc.openset.sdk.apiad.tools.c b;
        final String c;

        static {
            OSETSDKProtected.interface11(4901);
        }

        public a(OSETClicksData oSETClicksData, com.kc.openset.sdk.apiad.tools.c cVar, String str) {
            this.f39928a = oSETClicksData;
            this.b = cVar;
            this.c = str;
        }

        @Override // com.kc.openset.sdk.apiad.tools.APIAdClickCallback
        public native void onClick(InteractType interactType, boolean z);

        @Override // com.kc.openset.sdk.apiad.tools.APIAdClickCallback
        public native void onDeeplinkViewTime(long j);
    }

    static {
        OSETSDKProtected.interface11(4902);
    }

    public static native /* synthetic */ void a(com.kc.openset.sdk.adv.report.b bVar, com.kc.openset.sdk.apiad.tools.c cVar);

    public static native void a(com.kc.openset.sdk.apiad.tools.c cVar, OSETClicksData oSETClicksData, String str);

    private static native void b(com.kc.openset.sdk.adv.report.b bVar, com.kc.openset.sdk.apiad.tools.c cVar);
}
