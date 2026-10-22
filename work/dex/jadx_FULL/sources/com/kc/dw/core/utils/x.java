package com.kc.dw.core.utils;

import com.kc.dw.core.domain.HttpResponse;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface x {
    void onFailure(IOException iOException);

    void onResponse(HttpResponse<byte[]> httpResponse) throws IOException;
}
