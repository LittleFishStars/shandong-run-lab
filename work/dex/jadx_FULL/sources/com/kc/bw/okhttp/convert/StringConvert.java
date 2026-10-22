package com.kc.bw.okhttp.convert;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class StringConvert implements Converter<String> {
    @Override // com.kc.bw.okhttp.convert.Converter
    public String convertResponse(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            return null;
        }
        return responseBodyBody.string();
    }
}
