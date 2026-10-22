package cn.hzjizhun.admin.http.net.callback;

import cn.hzjizhun.admin.http.net.core.EasyCall;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface IBaseEasyCallback {
    void onCancel();

    void onFailure(EasyCall easyCall, Throwable th);

    void onResponse(EasyCall easyCall, HttpURLConnection httpURLConnection);
}
