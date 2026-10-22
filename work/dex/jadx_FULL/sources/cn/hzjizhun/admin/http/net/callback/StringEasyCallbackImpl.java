package cn.hzjizhun.admin.http.net.callback;

import cn.hzjizhun.admin.http.net.EasyHttpUtil;
import cn.hzjizhun.admin.http.net.core.EasyCall;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class StringEasyCallbackImpl extends BaseEasyCallbackImpl {

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringEasyCallbackImpl.this.onCompleted();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StringEasyCallbackImpl.this.onCompleted();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ EasyCall f306a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Throwable f307a;

        public c(EasyCall easyCall, Throwable th) {
            this.f306a = easyCall;
            this.f307a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringEasyCallbackImpl.this.onFailure(this.f306a, this.f307a);
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ String f;

        public d(String str) {
            this.f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringEasyCallbackImpl.this.onSuccessful(this.f);
        }
    }

    public abstract void onCompleted();

    @Override // cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
    public void onFailure(EasyCall easyCall, Throwable th) {
        safeCall(new a());
    }

    @Override // cn.hzjizhun.admin.http.net.callback.BaseEasyCallbackImpl, cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
    public void onResponse(EasyCall easyCall, HttpURLConnection httpURLConnection) {
        Throwable th;
        InputStream inputStream;
        super.onResponse(easyCall, httpURLConnection);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                            safeCall(new d(new String(byteArrayOutputStream2.toByteArray())));
                            EasyHttpUtil.quietClose(inputStream);
                            EasyHttpUtil.quietClose(byteArrayOutputStream2);
                            safeCall(new b());
                            return;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        safeCall(new c(easyCall, th));
                    } finally {
                        EasyHttpUtil.quietClose(inputStream);
                        EasyHttpUtil.quietClose(byteArrayOutputStream);
                        safeCall(new b());
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    public abstract void onSuccessful(String str);
}
