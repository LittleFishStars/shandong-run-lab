package android.taobao.windvane.jsbridge;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public interface WVAsyncAuthCheck {

    public interface AsyncAuthCheckCallBack {
        void callBackFail(String str, WVCallMethodContext wVCallMethodContext);

        void callBackSuccess(String str, WVCallMethodContext wVCallMethodContext);
    }

    boolean AsyncapiAuthCheck(String str, WVCallMethodContext wVCallMethodContext, AsyncAuthCheckCallBack asyncAuthCheckCallBack);
}
