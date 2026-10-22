package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class n66 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f43459a = 50000;

    public class a implements OSSProgressCallback<PutObjectRequest> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UploadCallback f43460a;

        public a(final UploadCallback val$callback) {
            this.f43460a = val$callback;
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
            UploadCallback uploadCallback = this.f43460a;
            if (uploadCallback != null) {
                uploadCallback.onProgress(currentSize, totalSize);
            }
        }
    }

    public class b implements OSSCompletedCallback<PutObjectRequest, PutObjectResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Handler f43461a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UploadCallback f18362a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f18363a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(final Handler val$handler, final UploadCallback val$callback, final String val$domain, final String val$directory, final String val$finalFileName) {
            this.f43461a = val$handler;
            this.f18362a = val$callback;
            this.f18363a = val$domain;
            this.b = val$directory;
            this.c = val$finalFileName;
        }

        public static /* synthetic */ void c(UploadCallback uploadCallback, ServiceException serviceException) {
            if (uploadCallback != null) {
                uploadCallback.onFailed(404, serviceException != null ? serviceException.getRawMessage() : "");
            }
        }

        public static /* synthetic */ void d(UploadCallback uploadCallback, String str, String str2, String str3) {
            if (uploadCallback != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                String str4 = File.separator;
                sb.append(str4);
                sb.append(str2);
                sb.append(str4);
                sb.append(str3);
                uploadCallback.onSuccess(sb.toString());
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onFailure(PutObjectRequest request, ClientException clientException, final ServiceException serviceException) {
            this.f43461a.removeCallbacksAndMessages(null);
            Handler handler = new Handler(Looper.getMainLooper());
            final UploadCallback uploadCallback = this.f18362a;
            handler.post(new Runnable() { // from class: com.zj.adlib.p66
                @Override // java.lang.Runnable
                public final void run() {
                    n66.b.c(uploadCallback, serviceException);
                }
            });
            if (clientException != null) {
                clientException.printStackTrace();
            }
            if (serviceException != null) {
                i4a.a(serviceException.getErrorCode());
                i4a.a(serviceException.getRequestId());
                i4a.a(serviceException.getHostId());
                i4a.a(serviceException.getRawMessage());
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PutObjectRequest request, PutObjectResult result) {
            this.f43461a.removeCallbacksAndMessages(null);
            Handler handler = new Handler(Looper.getMainLooper());
            final UploadCallback uploadCallback = this.f18362a;
            final String str = this.f18363a;
            final String str2 = this.b;
            final String str3 = this.c;
            handler.post(new Runnable() { // from class: com.zj.adlib.o66
                @Override // java.lang.Runnable
                public final void run() {
                    n66.b.d(uploadCallback, str, str2, str3);
                }
            });
            i4a.a("UploadSuccess");
            i4a.a(result.getETag());
            i4a.a(result.getRequestId());
            StringBuilder sb = new StringBuilder();
            sb.append(this.f18363a);
            String str4 = File.separator;
            sb.append(str4);
            sb.append(this.b);
            sb.append(str4);
            sb.append(this.c);
            i4a.a(sb.toString());
        }
    }

    public static void c(Handler handler, final OSSAsyncTask task, UploadCallback callback) {
        handler.postDelayed(new Runnable() { // from class: com.zj.adlib.l66
            @Override // java.lang.Runnable
            public final void run() {
                n66.e(task);
            }
        }, 50000L);
    }

    public static String d(String filePath) {
        String name = new File(filePath).getName();
        int iLastIndexOf = name.lastIndexOf("?");
        if (iLastIndexOf > 0) {
            name = name.substring(0, iLastIndexOf);
        }
        int iLastIndexOf2 = name.lastIndexOf(Consts.DOT);
        return (iLastIndexOf2 == -1 || name.length() <= iLastIndexOf2) ? "" : name.substring(iLastIndexOf2);
    }

    public static /* synthetic */ void e(OSSAsyncTask oSSAsyncTask) {
        if (oSSAsyncTask != null) {
            oSSAsyncTask.cancel();
        }
    }

    public static /* synthetic */ void f(OSSClient oSSClient, PutObjectRequest putObjectRequest, OSSCompletedCallback oSSCompletedCallback, Handler handler, UploadCallback uploadCallback) {
        c(handler, oSSClient.asyncPutObject(putObjectRequest, oSSCompletedCallback), uploadCallback);
    }

    public static void g(Context context, UploadFileType uploadType, String uploadFilePath, final UploadCallback callback) {
        String str;
        i4a.a(com.alibaba.ariver.permission.b.n);
        File file = new File(uploadFilePath);
        if (!file.exists()) {
            i4a.a("文件不存在");
            if (callback != null) {
                callback.onFailed(404, "文件不存在");
                return;
            }
            return;
        }
        String name = file.getName();
        i4a.a(name);
        String strD = d(name);
        i4a.a(strD);
        try {
            str = BinaryUtil.calculateMd5Str(uploadFilePath) + strD;
        } catch (Exception unused) {
            str = System.currentTimeMillis() + strD;
        }
        String str2 = str;
        i4a.a(str2);
        String domain = k66.k().e().getDomain();
        i4a.a(domain);
        String strJ = k66.k().j(uploadType);
        i4a.a(strJ);
        final OSSClient oSSClient = new OSSClient(context, k66.f17594a, new OSSStsTokenCredentialProvider(k66.k().e().getAccessKeyId(), k66.k().e().getAccessKeySecret(), k66.k().e().getSecurityToken()));
        final PutObjectRequest putObjectRequest = new PutObjectRequest(k66.b, strJ + File.separator + str2, uploadFilePath);
        putObjectRequest.setProgressCallback(new a(callback));
        final Handler handler = new Handler(Looper.getMainLooper());
        final b bVar = new b(handler, callback, domain, strJ, str2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            i4a.a("OSSUpload in main thread");
            p59.a().submit(new Runnable() { // from class: com.zj.adlib.m66
                @Override // java.lang.Runnable
                public final void run() {
                    n66.f(oSSClient, putObjectRequest, bVar, handler, callback);
                }
            });
        } else {
            c(handler, oSSClient.asyncPutObject(putObjectRequest, bVar), callback);
            i4a.a("OSSUpload in io thread");
        }
    }
}
