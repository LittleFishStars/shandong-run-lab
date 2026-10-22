package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.huachenjie.common.aliyun.base.AliyunTokenCallback;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.bean.OssTokenInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class u66 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f45072a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MultipleUploadCallback f19971a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UploadFileType f19972a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f19973a;
        public final /* synthetic */ List c;

        /* JADX INFO: renamed from: com.zj.adlib.u66$a$a, reason: collision with other inner class name */
        public class C1333a implements MultipleUploadCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Handler f45073a;

            public C1333a(final Handler val$handler) {
                this.f45073a = val$handler;
            }

            @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
            public void a(final int position, final long currentSize, final long totalSize) {
                final MultipleUploadCallback multipleUploadCallback = a.this.f19971a;
                if (multipleUploadCallback != null) {
                    this.f45073a.post(new Runnable() { // from class: com.zj.adlib.r66
                        @Override // java.lang.Runnable
                        public final void run() {
                            multipleUploadCallback.a(position, currentSize, totalSize);
                        }
                    });
                }
            }

            @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
            public void b(final int position, final String filePath) {
                final MultipleUploadCallback multipleUploadCallback = a.this.f19971a;
                if (multipleUploadCallback != null) {
                    this.f45073a.post(new Runnable() { // from class: com.zj.adlib.q66
                        @Override // java.lang.Runnable
                        public final void run() {
                            multipleUploadCallback.b(position, filePath);
                        }
                    });
                }
            }

            @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
            public void c(final List<pf6> fileInfoList) {
                final MultipleUploadCallback multipleUploadCallback = a.this.f19971a;
                if (multipleUploadCallback != null) {
                    this.f45073a.post(new Runnable() { // from class: com.zj.adlib.t66
                        @Override // java.lang.Runnable
                        public final void run() {
                            multipleUploadCallback.c(fileInfoList);
                        }
                    });
                }
            }

            @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
            public void d(final int position, final pf6 fileInfo) {
                if (!TextUtils.equals(fileInfo.c(), (CharSequence) a.this.f19973a.get(position))) {
                    try {
                        new File(fileInfo.c()).delete();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                final MultipleUploadCallback multipleUploadCallback = a.this.f19971a;
                if (multipleUploadCallback != null) {
                    this.f45073a.post(new Runnable() { // from class: com.zj.adlib.s66
                        @Override // java.lang.Runnable
                        public final void run() {
                            multipleUploadCallback.d(position, fileInfo);
                        }
                    });
                }
            }
        }

        public a(final Context val$context, final UploadFileType val$uploadType, final List val$filePathList, final List val$fileInfoList, final MultipleUploadCallback val$callBack) {
            this.f45072a = val$context;
            this.f19972a = val$uploadType;
            this.f19973a = val$filePathList;
            this.c = val$fileInfoList;
            this.f19971a = val$callBack;
        }

        @Override // java.lang.Runnable
        public void run() {
            u66.c(0, this.f45072a, this.f19972a, this.f19973a, this.c, new C1333a(new Handler(Looper.getMainLooper())));
        }
    }

    public class b implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f45074a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Context f19975a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ MultipleUploadCallback f19976a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UploadFileType f19977a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ pf6 f19978a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f19979a;
        public final /* synthetic */ List b;

        public b(final pf6 val$fileInfo, final MultipleUploadCallback val$callBack, final int val$position, final List val$fileInfoList, final Context val$context, final UploadFileType val$uploadType, final List val$filePathList) {
            this.f19978a = val$fileInfo;
            this.f19976a = val$callBack;
            this.f45074a = val$position;
            this.f19979a = val$fileInfoList;
            this.f19975a = val$context;
            this.f19977a = val$uploadType;
            this.b = val$filePathList;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, String message) {
            this.f19978a.k(false);
            MultipleUploadCallback multipleUploadCallback = this.f19976a;
            if (multipleUploadCallback != null) {
                multipleUploadCallback.d(this.f45074a, this.f19978a);
            }
            this.f19979a.add(this.f19978a);
            u66.c(this.f45074a + 1, this.f19975a, this.f19977a, this.b, this.f19979a, this.f19976a);
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onProgress(long currentSize, long totalSize) {
            MultipleUploadCallback multipleUploadCallback = this.f19976a;
            if (multipleUploadCallback != null) {
                multipleUploadCallback.a(this.f45074a, currentSize, totalSize);
            }
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(String fileUrl) {
            this.f19978a.l(fileUrl);
            this.f19978a.k(true);
            MultipleUploadCallback multipleUploadCallback = this.f19976a;
            if (multipleUploadCallback != null) {
                multipleUploadCallback.d(this.f45074a, this.f19978a);
            }
            this.f19979a.add(this.f19978a);
            u66.c(this.f45074a + 1, this.f19975a, this.f19977a, this.b, this.f19979a, this.f19976a);
        }
    }

    public class c implements AliyunTokenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f45075a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UploadCallback f19980a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ UploadFileType f19981a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f19982a;

        public c(final Context val$context, final UploadFileType val$uploadType, final String val$filePath, final UploadCallback val$callBack) {
            this.f45075a = val$context;
            this.f19981a = val$uploadType;
            this.f19982a = val$filePath;
            this.f19980a = val$callBack;
        }

        @Override // com.huachenjie.common.aliyun.base.AliyunTokenCallback
        public void a(OssTokenInfo tokenInfo) {
            n66.g(this.f45075a, this.f19981a, this.f19982a, this.f19980a);
        }

        @Override // com.huachenjie.common.aliyun.base.AliyunTokenCallback
        public void onFailed(int code, String message) {
            UploadCallback uploadCallback = this.f19980a;
            if (uploadCallback != null) {
                uploadCallback.onFailed(404, "token 信息获取失败");
            }
        }
    }

    public static pf6 b(String filePath) {
        pf6 pf6Var = new pf6();
        pf6Var.i(filePath);
        try {
            pf6Var.j(BinaryUtil.calculateMd5Str(filePath));
        } catch (Exception e) {
            pf6Var.g(404);
            pf6Var.h("" + e.getMessage());
        }
        return pf6Var;
    }

    public static void c(int position, Context context, UploadFileType uploadType, List<String> filePathList, List<pf6> fileInfoList, MultipleUploadCallback callBack) {
        i4a.a(com.alibaba.ariver.permission.b.n);
        if (filePathList == null || filePathList.size() == 0) {
            i4a.a("filePathList is empty");
            if (callBack != null) {
                callBack.c(null);
                return;
            }
            return;
        }
        if (position < filePathList.size()) {
            i4a.a("uploadFile child:" + position);
            String str = filePathList.get(position);
            pf6 pf6VarB = b(str);
            if (callBack != null) {
                callBack.b(position, str);
            }
            d(context, uploadType, str, new b(pf6VarB, callBack, position, fileInfoList, context, uploadType, filePathList));
            return;
        }
        i4a.a("position:" + position);
        i4a.a("filePathList:" + filePathList.size());
        i4a.a("position out size of fileList");
        if (callBack != null) {
            callBack.c(fileInfoList);
        }
    }

    public static void d(Context context, UploadFileType uploadType, String filePath, UploadCallback callBack) {
        i4a.a("uploadFile checkUploadToken");
        k66.k().c(new c(context, uploadType, filePath, callBack));
    }

    public static void e(Context context, UploadFileType uploadType, List<String> filePathList, MultipleUploadCallback callBack) {
        ArrayList arrayList = new ArrayList();
        if (filePathList != null && filePathList.size() != 0) {
            p59.a().submit(new a(context, uploadType, filePathList, arrayList, callBack));
            return;
        }
        if (callBack != null) {
            callBack.c(arrayList);
        }
        i4a.a("filePathList is empty");
    }
}
