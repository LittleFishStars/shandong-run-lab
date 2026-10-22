package com.kc.bw.okhttp.callback;

import com.kc.bw.okhttp.convert.ByteConvert;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class ByteCallback extends AbsCallback<byte[]> {
    public ByteConvert convert = new ByteConvert();

    @Override // com.kc.bw.okhttp.convert.Converter
    public byte[] convertResponse(Response response) {
        byte[] bArrConvertResponse = this.convert.convertResponse(response);
        response.close();
        return bArrConvertResponse;
    }
}
