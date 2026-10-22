package cn.hzjizhun.admin.http;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface RequestCallback {
    void onFail(Throwable th);

    void onSuccess(String str);
}
