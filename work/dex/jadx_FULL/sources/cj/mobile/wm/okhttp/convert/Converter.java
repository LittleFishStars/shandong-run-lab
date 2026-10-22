package cj.mobile.wm.okhttp.convert;

import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface Converter<T> {
    T convertResponse(Response response);
}
