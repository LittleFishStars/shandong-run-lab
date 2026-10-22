package com.hailiang.advlib.core;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import java.net.URL;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Keep
public interface IURLAdapter {
    URL obtainURL(String str) throws IOException;

    boolean v4();
}
