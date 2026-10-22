package cn.hzjizhun.admin.http.net.callback;

import android.os.Handler;
import android.os.Looper;
import cn.hzjizhun.admin.http.net.EasyHttpUtil;
import cn.hzjizhun.admin.http.net.core.EasyCall;
import cn.hzjizhun.admin.http.net.error.EasyHTTPException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class BaseEasyCallbackImpl implements IBaseEasyCallback {
    private static final String TAG = "BaseEasyCallbackImpl";
    protected Handler mHandler = new Handler(Looper.getMainLooper());
    private volatile boolean isCancelled = false;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ EasyCall f303a;
        public final /* synthetic */ String f;

        public a(EasyCall easyCall, String str) {
            this.f303a = easyCall;
            this.f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseEasyCallbackImpl.this.onFailure(this.f303a, new Throwable(this.f));
        }
    }

    private String getErrorMessage(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        if (inputStream != null) {
            try {
                byte[] bArr = new byte[2048];
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            String string = byteArrayOutputStream.toString("UTF-8");
                            EasyHttpUtil.quietClose(inputStream);
                            EasyHttpUtil.quietClose(byteArrayOutputStream);
                            return string;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
                byteArrayOutputStream = null;
            }
        } else {
            byteArrayOutputStream = null;
        }
        EasyHttpUtil.quietClose(inputStream);
        EasyHttpUtil.quietClose(byteArrayOutputStream);
        return "";
    }

    public void checkIsCancelled() throws EasyHTTPException {
        if (this.isCancelled) {
            throw new EasyHTTPException("Cancelled Task", "1004");
        }
    }

    @Override // cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
    public void onCancel() {
        this.isCancelled = true;
    }

    @Override // cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
    public void onResponse(EasyCall easyCall, HttpURLConnection httpURLConnection) {
        try {
            if (httpURLConnection.getResponseCode() >= 300) {
                safeCall(new a(easyCall, getErrorMessage(httpURLConnection.getErrorStream())));
            }
        } catch (IOException e) {
            e.printStackTrace();
            onFailure(easyCall, new IOException(e));
        }
    }

    public void safeCall(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }
}
