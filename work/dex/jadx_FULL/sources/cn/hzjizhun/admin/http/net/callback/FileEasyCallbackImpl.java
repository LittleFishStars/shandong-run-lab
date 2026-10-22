package cn.hzjizhun.admin.http.net.callback;

import cn.hzjizhun.admin.http.net.EasyHttpUtil;
import cn.hzjizhun.admin.http.net.core.EasyCall;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class FileEasyCallbackImpl extends BaseEasyCallbackImpl {
    private String mPath;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FileEasyCallbackImpl.this.onSuccessful(new File(FileEasyCallbackImpl.this.mPath));
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ EasyCall f304a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Throwable f305a;

        public b(EasyCall easyCall, Throwable th) {
            this.f304a = easyCall;
            this.f305a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileEasyCallbackImpl.this.onFailure(this.f304a, this.f305a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int K;
        public final /* synthetic */ int L;
        public final /* synthetic */ int M;

        public c(int i, int i2, int i3) {
            this.K = i;
            this.L = i2;
            this.M = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileEasyCallbackImpl.this.onProgressUpdated(this.K, this.L, this.M);
        }
    }

    public FileEasyCallbackImpl(String str, String str2) {
        this.mPath = str + str2;
    }

    public abstract void onProgressUpdated(int i, int i2, int i3);

    @Override // cn.hzjizhun.admin.http.net.callback.BaseEasyCallbackImpl, cn.hzjizhun.admin.http.net.callback.IBaseEasyCallback
    public void onResponse(EasyCall easyCall, HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                try {
                    fileOutputStream = new FileOutputStream(new File(this.mPath));
                    try {
                        int contentLength = httpURLConnection.getContentLength();
                        byte[] bArr = new byte[2048];
                        int i = 0;
                        while (true) {
                            int i2 = inputStream.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            checkIsCancelled();
                            fileOutputStream.write(bArr, 0, i2);
                            i += i2;
                            EasyHttpUtil.postToMain(new c(i, contentLength, (i * 100) / contentLength));
                        }
                        inputStream.close();
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        EasyHttpUtil.postToMain(new a());
                        closeable = inputStream;
                    } catch (Throwable th) {
                        th = th;
                        closeable = fileOutputStream;
                        try {
                            th.printStackTrace();
                            EasyHttpUtil.postToMain(new b(easyCall, th));
                            return;
                        } finally {
                            EasyHttpUtil.quietClose(closeable);
                            EasyHttpUtil.quietClose(inputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } else {
                fileOutputStream = null;
            }
            EasyHttpUtil.quietClose(fileOutputStream);
            EasyHttpUtil.quietClose(closeable);
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public abstract void onSuccessful(File file);
}
