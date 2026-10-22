package com.kc.bw.okhttp.callback;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class EmptyCallback extends AbsCallback<Object> {
    @Override // com.kc.bw.okhttp.convert.Converter
    public Object convertResponse(Response response) {
        return null;
    }

    @Override // com.kc.bw.okhttp.callback.Callback
    public void onSuccess(com.kc.bw.okhttp.model.Response<Object> response) {
    }
}
