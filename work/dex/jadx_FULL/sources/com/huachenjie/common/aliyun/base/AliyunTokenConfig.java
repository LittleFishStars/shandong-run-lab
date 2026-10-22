package com.huachenjie.common.aliyun.base;

import android.os.Looper;
import com.huachenjie.common.aliyun.file_upload.TokenCallback;
import com.huachenjie.common.bean.OssTokenInfo;
import com.zj.adlib.d60;
import com.zj.adlib.gq1;
import com.zj.adlib.i4a;
import com.zj.adlib.p59;
import com.zj.adlib.s72;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AliyunTokenConfig {

    public class a implements TokenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AliyunTokenCallback f33625a;

        public a(final AliyunTokenCallback val$callback) {
            this.f33625a = val$callback;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.TokenCallback
        public void onFailed() {
            AliyunTokenCallback aliyunTokenCallback = this.f33625a;
            if (aliyunTokenCallback != null) {
                aliyunTokenCallback.onFailed(404, "token 信息获取失败");
            }
        }

        @Override // com.huachenjie.common.aliyun.file_upload.TokenCallback
        public void onSuccess() {
            AliyunTokenCallback aliyunTokenCallback = this.f33625a;
            if (aliyunTokenCallback != null) {
                aliyunTokenCallback.a(AliyunTokenConfig.this.e());
            }
        }
    }

    public class b extends BizSubscriber<OssTokenInfo> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ TokenCallback f8474a;

        public b(final TokenCallback val$callback) {
            this.f8474a = val$callback;
        }

        public void onFailed(int code, String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            i4a.a("requestOssToken Failed");
            TokenCallback tokenCallback = this.f8474a;
            if (tokenCallback != null) {
                tokenCallback.onFailed();
            }
        }

        public void onCCSuccess(OssTokenInfo data) {
            i4a.a("requestOssToken Success");
            if (data == null) {
                TokenCallback tokenCallback = this.f8474a;
                if (tokenCallback != null) {
                    tokenCallback.onFailed();
                    return;
                }
                return;
            }
            AliyunTokenConfig.this.i(data);
            TokenCallback tokenCallback2 = this.f8474a;
            if (tokenCallback2 != null) {
                tokenCallback2.onSuccess();
            }
        }
    }

    public boolean b() {
        i4a.a("checkExpiration");
        if (e() == null || e().getExpiration() == 0) {
            i4a.a("tokenInfo == null");
            return false;
        }
        try {
            long expiration = e().getExpiration();
            if (expiration > System.currentTimeMillis()) {
                i4a.a(s72.c(expiration, "yyyy-MM-dd HH:mm:ss"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void c(AliyunTokenCallback callback) {
        i4a.a("checkToken");
        d(new a(callback));
    }

    public final void d(final TokenCallback callback) {
        i4a.a("checkUploadToken");
        if (b()) {
            i4a.a("Token Expiration");
            if (callback != null) {
                callback.onSuccess();
                return;
            }
            return;
        }
        i4a.a("Token is out");
        if (Looper.myLooper() == Looper.getMainLooper()) {
            i4a.a("in main thread");
            p59.a().submit(new Runnable() { // from class: com.zj.adlib.j40
                @Override // java.lang.Runnable
                public final void run() {
                    this.f42503a.g(callback);
                }
            });
        } else {
            i4a.a("in io thread");
            g(callback);
        }
    }

    public abstract OssTokenInfo e();

    public abstract String f();

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void g(TokenCallback callback) {
        i4a.a("requestOssToken");
        new gq1().A(f()).I6(Schedulers.io()).G3(d60.c()).p5(new b(callback));
    }

    public abstract void i(OssTokenInfo tokenInfo);
}
