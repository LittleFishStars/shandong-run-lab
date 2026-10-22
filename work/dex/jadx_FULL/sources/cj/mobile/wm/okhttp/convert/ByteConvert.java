package cj.mobile.wm.okhttp.convert;

import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ByteConvert implements Converter<byte[]> {
    @Override // cj.mobile.wm.okhttp.convert.Converter
    public byte[] convertResponse(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            return null;
        }
        return responseBodyBody.bytes();
    }
}
