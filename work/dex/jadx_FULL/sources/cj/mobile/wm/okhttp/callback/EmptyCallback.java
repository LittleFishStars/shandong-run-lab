package cj.mobile.wm.okhttp.callback;

import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EmptyCallback extends AbsCallback<Object> {
    @Override // cj.mobile.wm.okhttp.convert.Converter
    public Object convertResponse(Response response) {
        return null;
    }

    @Override // cj.mobile.wm.okhttp.callback.Callback
    public void onSuccess(cj.mobile.wm.okhttp.model.Response<Object> response) {
    }
}
