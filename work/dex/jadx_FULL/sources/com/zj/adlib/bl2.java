package com.zj.adlib;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.facebody20191230.Client;
import com.aliyun.facebody20191230.models.CompareFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.CompareFaceResponse;
import com.aliyun.facebody20191230.models.CompareFaceResponseBody;
import com.aliyun.facebody20191230.models.DetectLivingFaceAdvanceRequest;
import com.aliyun.facebody20191230.models.DetectLivingFaceResponse;
import com.aliyun.facebody20191230.models.DetectLivingFaceResponseBody;
import com.aliyun.tea.TeaException;
import com.aliyun.tea.TeaModel;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.huachenjie.common.aliyun.base.AliyunTokenCallback;
import com.huachenjie.common.aliyun.detect_face.CompareFaceCallback;
import com.huachenjie.common.aliyun.detect_face.LivingFaceCallback;
import com.huachenjie.common.bean.OssTokenInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class bl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile bl2 f40769a;

    public class a implements LivingFaceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LivingFaceCallback f40770a;

        public a(final LivingFaceCallback val$callback) {
            this.f40770a = val$callback;
        }

        public static /* synthetic */ void e(LivingFaceCallback livingFaceCallback, String str, String str2, String str3) {
            if (livingFaceCallback != null) {
                livingFaceCallback.a(str, str2, str3);
            }
        }

        public static /* synthetic */ void f(LivingFaceCallback livingFaceCallback, String str, String str2, float f) {
            if (livingFaceCallback != null) {
                livingFaceCallback.b(str, str2, f);
            }
        }

        @Override // com.huachenjie.common.aliyun.detect_face.LivingFaceCallback
        public void a(final String requestId, final String code, final String message) {
            bl2 bl2Var = bl2.this;
            final LivingFaceCallback livingFaceCallback = this.f40770a;
            bl2Var.d(new Runnable() { // from class: com.zj.adlib.zk2
                @Override // java.lang.Runnable
                public final void run() {
                    bl2.a.e(livingFaceCallback, requestId, code, message);
                }
            });
        }

        @Override // com.huachenjie.common.aliyun.detect_face.LivingFaceCallback
        public void b(final String requestId, final String label, final float rate) {
            bl2 bl2Var = bl2.this;
            final LivingFaceCallback livingFaceCallback = this.f40770a;
            bl2Var.d(new Runnable() { // from class: com.zj.adlib.al2
                @Override // java.lang.Runnable
                public final void run() {
                    bl2.a.f(livingFaceCallback, requestId, label, rate);
                }
            });
        }
    }

    public class b implements AliyunTokenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f40771a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Uri f15556a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ LivingFaceCallback f15557a;
        public final /* synthetic */ LivingFaceCallback b;

        public b(final ContentResolver val$contentResolver, final Uri val$uri, final LivingFaceCallback val$defaultCallback, final LivingFaceCallback val$callback) {
            this.f40771a = val$contentResolver;
            this.f15556a = val$uri;
            this.f15557a = val$defaultCallback;
            this.b = val$callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(ContentResolver contentResolver, Uri uri, LivingFaceCallback livingFaceCallback) {
            bl2.this.i(contentResolver, uri, livingFaceCallback);
        }

        @Override // com.huachenjie.common.aliyun.base.AliyunTokenCallback
        public void a(OssTokenInfo tokenInfo) {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                bl2.this.i(this.f40771a, this.f15556a, this.f15557a);
                return;
            }
            ExecutorService executorServiceA = p59.a();
            final ContentResolver contentResolver = this.f40771a;
            final Uri uri = this.f15556a;
            final LivingFaceCallback livingFaceCallback = this.f15557a;
            executorServiceA.submit(new Runnable() { // from class: com.zj.adlib.cl2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f15848a.c(contentResolver, uri, livingFaceCallback);
                }
            });
        }

        @Override // com.huachenjie.common.aliyun.base.AliyunTokenCallback
        public void onFailed(int code, String message) {
            LivingFaceCallback livingFaceCallback = this.b;
            if (livingFaceCallback != null) {
                livingFaceCallback.a("request token error", "request token error", "token 信息获取失败");
            }
        }
    }

    public class c implements CompareFaceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompareFaceCallback f40772a;

        public c(final CompareFaceCallback val$callback) {
            this.f40772a = val$callback;
        }

        public static /* synthetic */ void e(CompareFaceCallback compareFaceCallback, String str, String str2, String str3) {
            if (compareFaceCallback != null) {
                compareFaceCallback.a(str, str2, str3);
            }
        }

        public static /* synthetic */ void f(CompareFaceCallback compareFaceCallback, String str, float f) {
            if (compareFaceCallback != null) {
                compareFaceCallback.b(str, f);
            }
        }

        @Override // com.huachenjie.common.aliyun.detect_face.CompareFaceCallback
        public void a(final String requestId, final String code, final String message) {
            bl2 bl2Var = bl2.this;
            final CompareFaceCallback compareFaceCallback = this.f40772a;
            bl2Var.d(new Runnable() { // from class: com.zj.adlib.dl2
                @Override // java.lang.Runnable
                public final void run() {
                    bl2.c.e(compareFaceCallback, requestId, code, message);
                }
            });
        }

        @Override // com.huachenjie.common.aliyun.detect_face.CompareFaceCallback
        public void b(final String requestId, final float confidence) {
            bl2 bl2Var = bl2.this;
            final CompareFaceCallback compareFaceCallback = this.f40772a;
            bl2Var.d(new Runnable() { // from class: com.zj.adlib.el2
                @Override // java.lang.Runnable
                public final void run() {
                    bl2.c.f(compareFaceCallback, requestId, confidence);
                }
            });
        }
    }

    public class d implements AliyunTokenCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ContentResolver f40773a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Uri f15560a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CompareFaceCallback f15561a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f15563a;
        public final /* synthetic */ CompareFaceCallback b;

        public d(final String val$baseFaceUrl, final ContentResolver val$contentResolver, final Uri val$uri, final CompareFaceCallback val$defaultCallback, final CompareFaceCallback val$callback) {
            this.f15563a = val$baseFaceUrl;
            this.f40773a = val$contentResolver;
            this.f15560a = val$uri;
            this.f15561a = val$defaultCallback;
            this.b = val$callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str, ContentResolver contentResolver, Uri uri, CompareFaceCallback compareFaceCallback) throws Throwable {
            bl2.this.f(str, contentResolver, uri, compareFaceCallback);
        }

        @Override // com.huachenjie.common.aliyun.base.AliyunTokenCallback
        public void a(OssTokenInfo tokenInfo) throws Throwable {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                bl2.this.f(this.f15563a, this.f40773a, this.f15560a, this.f15561a);
                return;
            }
            ExecutorService executorServiceA = p59.a();
            final String str = this.f15563a;
            final ContentResolver contentResolver = this.f40773a;
            final Uri uri = this.f15560a;
            final CompareFaceCallback compareFaceCallback = this.f15561a;
            executorServiceA.submit(new Runnable() { // from class: com.zj.adlib.fl2
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f16563a.c(str, contentResolver, uri, compareFaceCallback);
                }
            });
        }

        @Override // com.huachenjie.common.aliyun.base.AliyunTokenCallback
        public void onFailed(int code, String message) {
            CompareFaceCallback compareFaceCallback = this.b;
            if (compareFaceCallback != null) {
                compareFaceCallback.a("request token error", "request token error", "token 信息获取失败");
            }
        }
    }

    public static Client g() throws Exception {
        OssTokenInfo ossTokenInfoE = ml2.j().e();
        Config securityToken = new Config().setAccessKeyId(ossTokenInfoE.getAccessKeyId()).setAccessKeySecret(ossTokenInfoE.getAccessKeySecret()).setSecurityToken(ossTokenInfoE.getSecurityToken());
        securityToken.endpoint = "facebody.cn-shanghai.aliyuncs.com";
        return new Client(securityToken);
    }

    public static bl2 k() {
        if (f40769a == null) {
            synchronized (bl2.class) {
                if (f40769a == null) {
                    f40769a = new bl2();
                }
            }
        }
        return f40769a;
    }

    public final void d(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public void e(String baseFaceUrl, ContentResolver contentResolver, Uri uri, CompareFaceCallback callback) {
        ml2.j().c(new d(baseFaceUrl, contentResolver, uri, new c(callback), callback));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.zj.adlib.bl2] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.ContentResolver] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final void f(String baseFaceUrl, ContentResolver contentResolver, Uri uri, CompareFaceCallback callback) throws Throwable {
        Closeable closeable;
        CompareFaceResponseBody.CompareFaceResponseBodyData compareFaceResponseBodyData;
        InputStream inputStream = null;
        try {
            try {
                Client clientG = g();
                InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                try {
                    InputStream inputStream2 = new URL(baseFaceUrl).openConnection().getInputStream();
                    CompareFaceResponse compareFaceResponseCompareFaceAdvance = clientG.compareFaceAdvance(new CompareFaceAdvanceRequest().setImageURLAObject(inputStreamOpenInputStream).setImageURLBObject(inputStream2), new RuntimeOptions());
                    i4a.a(Common.toJSONString(TeaModel.buildMap(compareFaceResponseCompareFaceAdvance)));
                    int iIntValue = compareFaceResponseCompareFaceAdvance.statusCode.intValue();
                    CompareFaceResponseBody compareFaceResponseBody = compareFaceResponseCompareFaceAdvance.body;
                    String str = compareFaceResponseBody != null ? compareFaceResponseBody.requestId : "";
                    if (iIntValue != 200) {
                        if (callback != null) {
                            callback.a(str, String.valueOf(iIntValue), "校验失败");
                        }
                        l(inputStreamOpenInputStream);
                        l(inputStream2);
                        return;
                    }
                    if (compareFaceResponseBody == null || (compareFaceResponseBodyData = compareFaceResponseBody.data) == null) {
                        if (callback != null) {
                            callback.b(str, 0.0f);
                        }
                    } else if (callback != null) {
                        callback.b(str, compareFaceResponseBodyData.confidence.floatValue());
                    }
                    l(inputStreamOpenInputStream);
                    l(inputStream2);
                } catch (TeaException e) {
                    e = e;
                    inputStream = inputStreamOpenInputStream;
                    closeable = null;
                    String strJ = j(e);
                    if (callback != null) {
                        callback.a(strJ, e.getCode(), e.getMessage());
                    }
                    l(inputStream);
                    l(closeable);
                } catch (Exception e2) {
                    e = e2;
                    inputStream = inputStreamOpenInputStream;
                    closeable = null;
                    if (callback != null) {
                        try {
                            String message = e.getMessage();
                            if (TextUtils.isEmpty(message)) {
                                message = "error message is empty";
                            }
                            if (message.length() > 500) {
                                message = message.substring(0, 500);
                            }
                            callback.a(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, message, e.getMessage());
                        } catch (Exception unused) {
                        }
                    }
                    l(inputStream);
                    l(closeable);
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    contentResolver = 0;
                    l(inputStream);
                    l(contentResolver);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (TeaException e3) {
            e = e3;
            closeable = null;
        } catch (Exception e4) {
            e = e4;
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            contentResolver = 0;
        }
    }

    public void h(ContentResolver contentResolver, Uri uri, LivingFaceCallback callback) {
        ml2.j().c(new b(contentResolver, uri, new a(callback), callback));
    }

    public final void i(ContentResolver contentResolver, Uri uri, LivingFaceCallback callback) {
        DetectLivingFaceResponseBody.DetectLivingFaceResponseBodyData detectLivingFaceResponseBodyData;
        InputStream inputStreamOpenInputStream = null;
        try {
            Client clientG = g();
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            DetectLivingFaceResponse detectLivingFaceResponseDetectLivingFaceAdvance = clientG.detectLivingFaceAdvance(new DetectLivingFaceAdvanceRequest().setTasks(Collections.singletonList(new DetectLivingFaceAdvanceRequest.DetectLivingFaceAdvanceRequestTasks().setImageURLObject(inputStreamOpenInputStream))), new RuntimeOptions());
            int iIntValue = detectLivingFaceResponseDetectLivingFaceAdvance.statusCode.intValue();
            i4a.a(Common.toJSONString(TeaModel.buildMap(detectLivingFaceResponseDetectLivingFaceAdvance)));
            DetectLivingFaceResponseBody detectLivingFaceResponseBody = detectLivingFaceResponseDetectLivingFaceAdvance.body;
            String str = detectLivingFaceResponseBody != null ? detectLivingFaceResponseBody.requestId : "";
            if (iIntValue != 200) {
                if (callback != null) {
                    callback.a(str, String.valueOf(iIntValue), "校验失败");
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
                return;
            }
            if (detectLivingFaceResponseBody != null && (detectLivingFaceResponseBodyData = detectLivingFaceResponseBody.data) != null && !ek9.a(detectLivingFaceResponseBodyData.elements).booleanValue() && !ek9.a(detectLivingFaceResponseDetectLivingFaceAdvance.body.data.elements.get(0).results).booleanValue() && detectLivingFaceResponseDetectLivingFaceAdvance.body.data.elements.get(0).results.get(0) != null) {
                DetectLivingFaceResponseBody.DetectLivingFaceResponseBodyDataElementsResults detectLivingFaceResponseBodyDataElementsResults = detectLivingFaceResponseDetectLivingFaceAdvance.body.data.elements.get(0).results.get(0);
                if (callback != null) {
                    callback.b(str, detectLivingFaceResponseBodyDataElementsResults.label, detectLivingFaceResponseBodyDataElementsResults.rate.floatValue());
                }
            } else if (callback != null) {
                callback.b(str, "liveness", 100.0f);
            }
        } catch (Exception e) {
            e.printStackTrace();
            i4a.a(e.getMessage());
            if (callback != null) {
                try {
                    String message = e.getMessage();
                    if (TextUtils.isEmpty(message)) {
                        message = "error message is empty";
                    }
                    if (message.length() > 500) {
                        message = message.substring(0, 500);
                    }
                    callback.a(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, message, e.getMessage());
                } catch (Exception unused2) {
                }
            }
        } catch (TeaException e2) {
            String strJ = j(e2);
            if (callback != null) {
                callback.a(strJ, e2.getCode(), e2.getMessage());
            }
        } finally {
            if (0 != 0) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused3) {
                }
            }
        }
    }

    public final String j(TeaException teaError) {
        if (teaError == null || teaError.getData() == null) {
            return "";
        }
        Map<String, Object> data = teaError.getData();
        Object obj = data.get(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID);
        if (obj != null) {
            return "" + obj;
        }
        Object obj2 = data.get("requestId");
        if (obj2 == null) {
            return "";
        }
        return "" + obj2;
    }

    public final void l(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
