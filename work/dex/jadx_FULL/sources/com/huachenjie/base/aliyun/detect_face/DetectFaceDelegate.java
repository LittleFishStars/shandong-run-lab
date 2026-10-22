package com.huachenjie.base.aliyun.detect_face;

import android.app.Application;
import android.content.ContentResolver;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.base.bean.RunFaceCheckExtendBean;
import com.huachenjie.base.bean.RunFaceDetectStatus;
import com.huachenjie.base.bean.UserFaceBean;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.coroutine.CoroutineExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.common.reconfig.net.exception.c;
import com.igexin.push.g.o;
import com.zj.adlib.TrackingInfo;
import com.zj.adlib.b85;
import com.zj.adlib.i4a;
import com.zj.adlib.il2;
import com.zj.adlib.jo2;
import com.zj.adlib.pu3;
import com.zj.adlib.v41;
import com.zj.adlib.vw3;
import com.zj.adlib.y6b;
import java.io.File;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bC\u0010DJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J^\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\nJ\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u001c\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010 \u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u001a\u0010'\u001a\u0004\u0018\u00010\u00022\u0006\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0002H\u0002R#\u0010.\u001a\n )*\u0004\u0018\u00010(0(8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010/R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00100R\u0018\u00102\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00100R\u0018\u00107\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00103R\u0018\u00109\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00100R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00100R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00100R\u0018\u0010?\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u00100R\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u00100R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00100¨\u0006E"}, d2 = {"Lcom/huachenjie/base/aliyun/detect_face/DetectFaceDelegate;", "", "", "filePath", "Lcom/huachenjie/common/aliyun/file_upload/UploadFileType;", "uploadType", "Lcom/huachenjie/base/bean/UserFaceBean;", "userFaceBean", "", "y", "", UserTrackConstant.IS_SUCCESS, "", "sim", "Lcom/zj/adlib/xa9;", "trackingInfo", "", "maxWidth", "maxHeight", "runRecordCode", il2.DETECT_FACE_CHECK_INDEX, "Lcom/huachenjie/base/bean/RunFaceDetectStatus;", "detectStatus", "needEncodedFileName", "x", "p", "Landroid/content/ContentResolver;", "contentResolver", "q", "fileUrl", "r", "success", "v", "text", "w", "u", "t", "data", "publicKeyStr", "s", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", "getContext", "()Landroid/app/Application;", "context", "I", "Ljava/lang/String;", "b", "compareFaceUrl", "Ljava/lang/Float;", "confidenceResult", "c", "detectLabel", "detectRate", "d", "faceRequestId", "e", "bodyRequestId", "f", "faceCheckErrorCode", y6b.f, "bodyCheckErrorCode", y6b.g, "progressStr", "i", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nDetectFaceDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DetectFaceDelegate.kt\ncom/huachenjie/base/aliyun/detect_face/DetectFaceDelegate\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,368:1\n1#2:369\n*E\n"})
public final class DetectFaceDelegate {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public Float confidenceResult;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String runRecordCode;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public Float detectRate;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String compareFaceUrl;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @Nullable
    public String detectLabel;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public String faceRequestId;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @Nullable
    public String bodyRequestId;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String faceCheckErrorCode;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @Nullable
    public String bodyCheckErrorCode;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy context = LazyKt.lazy(new Function0<Application>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$context$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Application m199invoke() {
            return Utils.a();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public int faceCheckIndex = -1;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public String progressStr = "";

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    @NotNull
    public String filePath = "";

    /* JADX INFO: Access modifiers changed from: private */
    public final Application getContext() {
        return (Application) this.context.getValue();
    }

    public static /* synthetic */ void z(DetectFaceDelegate detectFaceDelegate, String str, UploadFileType uploadFileType, UserFaceBean userFaceBean, int i, Object obj) {
        if ((i & 4) != 0) {
            userFaceBean = null;
        }
        detectFaceDelegate.y(str, uploadFileType, userFaceBean);
    }

    public final void p(String filePath, UserFaceBean userFaceBean) {
        v41.e(pu3.a, new com.huachenjie.common.reconfig.net.exception.a(new c(true, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$compareFace$1

            /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$compareFace$1$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$compareFace$1$1", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DetectFaceDelegate this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DetectFaceDelegate detectFaceDelegate, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = detectFaceDelegate;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.v(false);
                    return Unit.INSTANCE;
                }
            }

            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                v41.e(pu3.a, jo2.c(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
                return Boolean.FALSE;
            }
        })), (CoroutineStart) null, new DetectFaceDelegate$compareFace$2(this, userFaceBean, filePath, null), 2, (Object) null);
    }

    public final void q(String filePath, UserFaceBean userFaceBean, ContentResolver contentResolver) {
        v41.e(pu3.a, new com.huachenjie.common.reconfig.net.exception.a(new c(true, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$detectLivingFace$1

            /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$detectLivingFace$1$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$detectLivingFace$1$1", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DetectFaceDelegate this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DetectFaceDelegate detectFaceDelegate, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = detectFaceDelegate;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.v(false);
                    return Unit.INSTANCE;
                }
            }

            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                v41.e(pu3.a, jo2.c(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
                return Boolean.FALSE;
            }
        })), (CoroutineStart) null, new DetectFaceDelegate$detectLivingFace$2(this, contentResolver, filePath, userFaceBean, null), 2, (Object) null);
    }

    public final String r(String fileUrl, UploadFileType uploadType) {
        String str = uploadType.getValue() + File.separator;
        int iLastIndexOf$default = StringsKt.lastIndexOf$default(fileUrl, str, 0, false, 6, (Object) null);
        if (iLastIndexOf$default == -1) {
            return fileUrl;
        }
        boolean z = false;
        String strSubstring = fileUrl.substring(0, str.length() + iLastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        String strSubstring2 = fileUrl.substring(iLastIndexOf$default + str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
        String strE = FileUtils.E(strSubstring2);
        if (strE != null) {
            Intrinsics.checkNotNullExpressionValue(strE, o.f);
            if (strE.length() > 0) {
                z = true;
            }
        }
        if (!z) {
            strE = null;
        }
        if (strE == null) {
            strE = "jpg";
        }
        String strS = FileUtils.S(strSubstring2);
        Intrinsics.checkNotNullExpressionValue(strS, "fileName");
        String strS2 = s(strS, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArYF8+9rLS/PFEj5IbxolxYma1npFwFy8plTHyj1T+QNQ37H/qKwgD8p2gnUu9MFPaz4UXaGkdL6zmdgdBqV4FYH5BqBC2L2f4Cl0VtAgLuMfGEaphac+Mis6E8abV8fUhjuW6Wc1Y4y/1xQeG0euIEmt+ey9srjgZ4B7bdPHOzmXp9eE7TbgrHU3OhbuWrika3XxEj5y56HclQMUk9gSLP1fGxEL5pdP5RbDc2OKp0cAwy5ItQd0i2lrHBdCfnIZQYyD4naWeb1MrcrjmWCAiB9oA9+jV/TRlBPUpO7fs+bNFVFCsn6Sw53zT6aWPbbJYRt7Vezp3oSFI1Pt4T9BNwIDAQAB");
        if (TextUtils.isEmpty(strS2)) {
            return fileUrl;
        }
        return strSubstring + strS2 + '.' + strE;
    }

    public final String s(String data, String publicKeyStr) {
        if (data.length() == 0) {
            return null;
        }
        if (publicKeyStr.length() == 0) {
            return null;
        }
        try {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(StringsKt.trim(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(publicKeyStr, "-----BEGIN PUBLIC KEY-----", "", false, 4, (Object) null), "-----END PUBLIC KEY-----", "", false, 4, (Object) null), "\n", "", false, 4, (Object) null), b85.b, "", false, 4, (Object) null)).toString(), 0)));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            byte[] bytes = data.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(cipher.doFinal(bytes), 2);
        } catch (Exception e) {
            i4a.c("RSA加密失败: " + e.getMessage());
            return null;
        }
    }

    public final void t(RunFaceDetectStatus detectStatus) {
        RunFaceCheckExtendBean runFaceCheckExtendBean = new RunFaceCheckExtendBean(vw3.u(detectStatus), this.filePath, this.compareFaceUrl);
        il2 il2Var = il2.f42385a;
        Application context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = this.runRecordCode;
        if (str == null) {
            str = "";
        }
        il2Var.a(context, str, runFaceCheckExtendBean, this.faceCheckIndex);
    }

    public final void u(String text) {
        this.progressStr += text;
        RunFaceCheckExtendBean runFaceCheckExtendBean = new RunFaceCheckExtendBean(this.progressStr, this.filePath, this.compareFaceUrl);
        il2 il2Var = il2.f42385a;
        Application context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        String str = this.runRecordCode;
        if (str == null) {
            str = "";
        }
        il2Var.a(context, str, runFaceCheckExtendBean, this.faceCheckIndex);
    }

    public final void v(boolean success) {
        DetectResultBean detectResultBean = new DetectResultBean(success, this.runRecordCode, this.compareFaceUrl, this.confidenceResult, this.detectLabel, this.detectRate, this.faceRequestId, this.bodyRequestId, this.faceCheckErrorCode, this.bodyCheckErrorCode, this.faceCheckIndex);
        il2 il2Var = il2.f42385a;
        Application context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        il2Var.b(context, detectResultBean);
    }

    public final void w(String text) {
        il2 il2Var = il2.f42385a;
        Application context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        il2Var.c(context, text);
    }

    public final void x(boolean isSuccess, float sim, @NotNull TrackingInfo trackingInfo, @NotNull String filePath, int maxWidth, int maxHeight, @NotNull UploadFileType uploadType, @NotNull String runRecordCode, int faceCheckIndex, @NotNull RunFaceDetectStatus detectStatus, boolean needEncodedFileName) {
        Intrinsics.checkNotNullParameter(trackingInfo, "trackingInfo");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(uploadType, "uploadType");
        Intrinsics.checkNotNullParameter(runRecordCode, "runRecordCode");
        Intrinsics.checkNotNullParameter(detectStatus, "detectStatus");
        this.faceCheckIndex = faceCheckIndex;
        this.runRecordCode = runRecordCode;
        this.filePath = filePath;
        this.confidenceResult = Float.valueOf(sim);
        this.detectRate = Float.valueOf(isSuccess ? 1.0f : 0.0f);
        CoroutineExtKt.c(CoroutineExtKt.a(this), false, new DetectFaceDelegate$startAnalyzer$1(this, detectStatus, null), null, new DetectFaceDelegate$startAnalyzer$2(this, uploadType, filePath, trackingInfo, maxWidth, maxHeight, detectStatus, isSuccess, null), 5, null);
    }

    public final void y(@NotNull String filePath, @NotNull UploadFileType uploadType, @Nullable UserFaceBean userFaceBean) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(uploadType, "uploadType");
        this.faceCheckIndex = userFaceBean != null ? userFaceBean.getFaceCheckIndex() : -1;
        this.runRecordCode = userFaceBean != null ? userFaceBean.getRunRecordCode() : null;
        this.filePath = filePath;
        v41.e(pu3.a, new com.huachenjie.common.reconfig.net.exception.a(new c(true, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startTask$1

            /* JADX INFO: renamed from: com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startTask$1$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.huachenjie.base.aliyun.detect_face.DetectFaceDelegate$startTask$1$1", f = "DetectFaceDelegate.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ DetectFaceDelegate this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DetectFaceDelegate detectFaceDelegate, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = detectFaceDelegate;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.v(false);
                    return Unit.INSTANCE;
                }
            }

            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                v41.e(pu3.a, jo2.c(), (CoroutineStart) null, new AnonymousClass1(this.this$0, null), 2, (Object) null);
                return Boolean.FALSE;
            }
        })), (CoroutineStart) null, new DetectFaceDelegate$startTask$2(this, uploadType, filePath, userFaceBean, null), 2, (Object) null);
    }
}
