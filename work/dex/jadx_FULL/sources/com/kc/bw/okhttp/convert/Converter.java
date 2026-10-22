package com.kc.bw.okhttp.convert;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface Converter<T> {
    T convertResponse(Response response);
}
