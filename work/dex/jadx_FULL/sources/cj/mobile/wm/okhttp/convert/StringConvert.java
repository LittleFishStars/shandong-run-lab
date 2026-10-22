package cj.mobile.wm.okhttp.convert;

import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StringConvert implements Converter<String> {
    @Override // cj.mobile.wm.okhttp.convert.Converter
    public String convertResponse(Response response) {
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody == null) {
            return null;
        }
        return responseBodyBody.string();
    }
}
