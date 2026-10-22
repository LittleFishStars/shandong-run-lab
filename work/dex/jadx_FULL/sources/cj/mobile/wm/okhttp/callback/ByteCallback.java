package cj.mobile.wm.okhttp.callback;

import cj.mobile.wm.okhttp.convert.ByteConvert;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ByteCallback extends AbsCallback<byte[]> {
    public ByteConvert convert = new ByteConvert();

    @Override // cj.mobile.wm.okhttp.convert.Converter
    public byte[] convertResponse(Response response) {
        byte[] bArrConvertResponse = this.convert.convertResponse(response);
        response.close();
        return bArrConvertResponse;
    }
}
