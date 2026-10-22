package cj.mobile.wm.okhttp.callback;

import cj.mobile.wm.okhttp.convert.StringConvert;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class StringCallback extends AbsCallback<String> {
    public StringConvert convert = new StringConvert();

    @Override // cj.mobile.wm.okhttp.convert.Converter
    public String convertResponse(Response response) {
        String strConvertResponse = this.convert.convertResponse(response);
        response.close();
        return strConvertResponse;
    }
}
