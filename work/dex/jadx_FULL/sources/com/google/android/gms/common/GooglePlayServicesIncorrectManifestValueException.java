package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepName;
import com.zj.adlib.qv3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepName
public final class GooglePlayServicesIncorrectManifestValueException extends GooglePlayServicesManifestException {
    public GooglePlayServicesIncorrectManifestValueException(int i) {
        super(i, "The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + qv3.f44306a + " but found " + i + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
    }
}
