package com.huachenjie.common.aliyun.video_upload;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.sdk.android.vod.upload.VODUploadCallback;
import com.alibaba.sdk.android.vod.upload.VODUploadClientImpl;
import com.alibaba.sdk.android.vod.upload.model.UploadFileInfo;
import com.alibaba.sdk.android.vod.upload.model.VodInfo;
import com.alibaba.sdk.android.vod.upload.model.VodUploadResult;
import com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig;
import com.alibaba.triver.embed.video.fullscreenvideo.TriverEmbedVideoView;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.blankj.utilcode.util.Utils;
import com.huachenjie.common.aliyun.video_upload.VideoUploadHelper;
import com.huachenjie.common.bean.VodTokenInfo;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.d60;
import com.zj.adlib.gq1;
import com.zj.adlib.i4a;
import com.zj.adlib.y6b;
import huachenjie.sdk.http.subscriber.BizSubscriber;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx.schedulers.Schedulers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J*\u0010\u0013\u001a\u00020\u00072\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001e¨\u0006$"}, d2 = {"Lcom/huachenjie/common/aliyun/video_upload/VideoUploadHelper;", "", "", "videoPath", "coverUrl", "Lcom/huachenjie/common/aliyun/video_upload/VideoUploadCallback;", RenderCallContext.TYPE_CALLBACK, "", t.d, y6b.g, "j", "f", "Lcom/huachenjie/common/bean/VodTokenInfo;", LoginConstants.TOKEN_INFO, y6b.f, "Lkotlin/Function1;", "onSuccess", "Lkotlin/Function0;", TriverEmbedVideoView.b, "i", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "mHandler", "Lcom/alibaba/sdk/android/vod/upload/VODUploadClientImpl;", "Lcom/alibaba/sdk/android/vod/upload/VODUploadClientImpl;", "mVideoUploadClient", "Lcom/huachenjie/common/aliyun/video_upload/VideoUploadCallback;", "mCallback", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "timeOutRunnable", "Landroid/app/Application;", "application", "<init>", "(Landroid/app/Application;)V", "common_release"}, k = 1, mv = {1, 8, 0})
public final class VideoUploadHelper {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final String f8475a = "VideoUploadHelper";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Handler mHandler;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final VODUploadClientImpl mVideoUploadClient;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public VideoUploadCallback mCallback;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Runnable timeOutRunnable;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final Lazy<VideoUploadHelper> f8476a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<VideoUploadHelper>() { // from class: com.huachenjie.common.aliyun.video_upload.VideoUploadHelper$Companion$instance$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final VideoUploadHelper m341invoke() {
            Application applicationA = Utils.a();
            Intrinsics.checkNotNullExpressionValue(applicationA, "getApp()");
            return new VideoUploadHelper(applicationA);
        }
    });

    /* JADX INFO: renamed from: com.huachenjie.common.aliyun.video_upload.VideoUploadHelper$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/huachenjie/common/aliyun/video_upload/VideoUploadHelper$a;", "", "Lcom/huachenjie/common/aliyun/video_upload/VideoUploadHelper;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/huachenjie/common/aliyun/video_upload/VideoUploadHelper;", "instance", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoUploadHelper a() {
            return (VideoUploadHelper) VideoUploadHelper.f8476a.getValue();
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0015"}, d2 = {"com/huachenjie/common/aliyun/video_upload/VideoUploadHelper$b", "Lcom/alibaba/sdk/android/vod/upload/VODUploadCallback;", "Lcom/alibaba/sdk/android/vod/upload/model/UploadFileInfo;", AliyunLogCommon.LogLevel.INFO, "Lcom/alibaba/sdk/android/vod/upload/model/VodUploadResult;", "result", "", "onUploadSucceed", "", "code", "message", "onUploadFailed", "", "uploadedSize", "totalSize", "onUploadProgress", "onUploadTokenExpired", "onUploadRetry", "onUploadRetryResume", "uploadFileInfo", "onUploadStarted", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class b extends VODUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VideoUploadCallback f33628a;

        public b(VideoUploadCallback videoUploadCallback) {
            this.f33628a = videoUploadCallback;
        }

        public static final void e(VideoUploadCallback videoUploadCallback, String str, String str2) {
            Intrinsics.checkNotNullParameter(videoUploadCallback, "$callback");
            videoUploadCallback.onUploadFailed(str, str2);
        }

        public static final void f(VideoUploadCallback videoUploadCallback, long j, long j2) {
            Intrinsics.checkNotNullParameter(videoUploadCallback, "$callback");
            videoUploadCallback.onUploadProgress(j, j2);
        }

        public static final void g(VideoUploadCallback videoUploadCallback, VodUploadResult vodUploadResult) {
            Intrinsics.checkNotNullParameter(videoUploadCallback, "$callback");
            videoUploadCallback.a(vodUploadResult != null ? vodUploadResult.getVideoid() : null);
        }

        public static final void h(VideoUploadCallback videoUploadCallback) {
            Intrinsics.checkNotNullParameter(videoUploadCallback, "$callback");
            videoUploadCallback.onUploadFailed("404", "上传失败");
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadFailed(@Nullable UploadFileInfo info, @Nullable final String code, @Nullable final String message) {
            i4a.b(VideoUploadHelper.f8475a, "onUploadFailed>>" + code + ">>" + message);
            VideoUploadHelper.this.mHandler.removeCallbacks(VideoUploadHelper.this.timeOutRunnable);
            Handler handler = VideoUploadHelper.this.mHandler;
            final VideoUploadCallback videoUploadCallback = this.f33628a;
            handler.post(new Runnable() { // from class: com.zj.adlib.jp9
                @Override // java.lang.Runnable
                public final void run() {
                    VideoUploadHelper.b.e(videoUploadCallback, code, message);
                }
            });
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadProgress(@Nullable UploadFileInfo info, final long uploadedSize, final long totalSize) {
            VideoUploadHelper.this.mHandler.removeCallbacks(VideoUploadHelper.this.timeOutRunnable);
            Handler handler = VideoUploadHelper.this.mHandler;
            final VideoUploadCallback videoUploadCallback = this.f33628a;
            handler.post(new Runnable() { // from class: com.zj.adlib.lp9
                @Override // java.lang.Runnable
                public final void run() {
                    VideoUploadHelper.b.f(videoUploadCallback, uploadedSize, totalSize);
                }
            });
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadRetry(@Nullable String code, @Nullable String message) {
            i4a.b(VideoUploadHelper.f8475a, "onUploadRetry>>" + code + ">>" + message);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadRetryResume() {
            i4a.b(VideoUploadHelper.f8475a, "onUploadRetryResume");
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadStarted(@Nullable UploadFileInfo uploadFileInfo) {
            i4a.b(VideoUploadHelper.f8475a, "onUploadStarted>>" + uploadFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadSucceed(@Nullable UploadFileInfo info, @Nullable final VodUploadResult result) {
            i4a.b(VideoUploadHelper.f8475a, "onUploadSucceed>>" + info + ">>" + result);
            VideoUploadHelper.this.mHandler.removeCallbacks(VideoUploadHelper.this.timeOutRunnable);
            Handler handler = VideoUploadHelper.this.mHandler;
            final VideoUploadCallback videoUploadCallback = this.f33628a;
            handler.post(new Runnable() { // from class: com.zj.adlib.kp9
                @Override // java.lang.Runnable
                public final void run() {
                    VideoUploadHelper.b.g(videoUploadCallback, result);
                }
            });
        }

        @Override // com.alibaba.sdk.android.vod.upload.VODUploadCallback
        public void onUploadTokenExpired() {
            i4a.b(VideoUploadHelper.f8475a, "onUploadTokenExpired");
            VideoUploadHelper.this.mHandler.removeCallbacks(VideoUploadHelper.this.timeOutRunnable);
            Handler handler = VideoUploadHelper.this.mHandler;
            final VideoUploadCallback videoUploadCallback = this.f33628a;
            handler.post(new Runnable() { // from class: com.zj.adlib.mp9
                @Override // java.lang.Runnable
                public final void run() {
                    VideoUploadHelper.b.h(videoUploadCallback);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u000b"}, d2 = {"com/huachenjie/common/aliyun/video_upload/VideoUploadHelper$c", "Lhuachenjie/sdk/http/subscriber/BizSubscriber;", "Lcom/huachenjie/common/bean/VodTokenInfo;", LoginConstants.TOKEN_INFO, "", "onCCSuccess", "", "code", "", "message", "onFailed", "common_release"}, k = 1, mv = {1, 8, 0})
    public static final class c extends BizSubscriber<VodTokenInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f33629a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Function1<VodTokenInfo, Unit> f8482a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Function0<Unit> function0, Function1<? super VodTokenInfo, Unit> function1) {
            super(false);
            this.f33629a = function0;
            this.f8482a = function1;
        }

        public void onFailed(int code, @Nullable String message) {
            super/*huachenjie.sdk.http.subscriber.BaseSubscriber*/.onFailed(code, message);
            this.f33629a.invoke();
        }

        public void onCCSuccess(@Nullable VodTokenInfo tokenInfo) {
            if (tokenInfo == null) {
                this.f33629a.invoke();
            } else {
                this.f8482a.invoke(tokenInfo);
            }
        }
    }

    public VideoUploadHelper(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.mHandler = new Handler(Looper.getMainLooper());
        VODUploadClientImpl vODUploadClientImpl = new VODUploadClientImpl(application);
        this.mVideoUploadClient = vODUploadClientImpl;
        vODUploadClientImpl.setVodHttpClientConfig(new VodHttpClientConfig.Builder().setMaxRetryCount(3).setSocketTimeout(60000).build());
        this.timeOutRunnable = new Runnable() { // from class: com.zj.adlib.ip9
            @Override // java.lang.Runnable
            public final void run() {
                VideoUploadHelper.k(this.f42416a);
            }
        };
    }

    public static final void k(VideoUploadHelper videoUploadHelper) {
        Intrinsics.checkNotNullParameter(videoUploadHelper, "this$0");
        videoUploadHelper.mVideoUploadClient.clearFiles();
        VideoUploadCallback videoUploadCallback = videoUploadHelper.mCallback;
        if (videoUploadCallback != null) {
            videoUploadCallback.onUploadFailed("404", "上传失败");
        }
    }

    public final void f() {
        this.mCallback = null;
        this.mVideoUploadClient.clearFiles();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public final void g(String videoPath, String coverUrl, VodTokenInfo tokenInfo, VideoUploadCallback callback) {
        this.mVideoUploadClient.clearFiles();
        VodInfo vodInfo = new VodInfo();
        vodInfo.setTitle(new File(videoPath).getName());
        vodInfo.setCoverUrl(coverUrl);
        this.mCallback = callback;
        this.mVideoUploadClient.addFile(videoPath, vodInfo);
        this.mVideoUploadClient.setTemplateGroupId(tokenInfo.getTemplateGroupId());
        this.mVideoUploadClient.init(tokenInfo.getAccessKeyId(), tokenInfo.getAccessKeySecret(), tokenInfo.getSecurityToken(), tokenInfo.getExpiration(), new b(callback));
        this.mVideoUploadClient.start();
        this.mHandler.postDelayed(this.timeOutRunnable, 181000L);
    }

    public final void h() {
        this.mVideoUploadClient.pause();
    }

    public final void i(Function1<? super VodTokenInfo, Unit> onSuccess, Function0<Unit> onError) {
        new gq1().B().u5(Schedulers.io()).G3(d60.c()).p5(new c(onError, onSuccess));
    }

    public final void j() {
        this.mVideoUploadClient.resume();
    }

    public final void l(@NotNull final String videoPath, @NotNull final String coverUrl, @NotNull final VideoUploadCallback callback) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        i(new Function1<VodTokenInfo, Unit>() { // from class: com.huachenjie.common.aliyun.video_upload.VideoUploadHelper$upload$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((VodTokenInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull VodTokenInfo vodTokenInfo) {
                Intrinsics.checkNotNullParameter(vodTokenInfo, o.f);
                this.this$0.g(videoPath, coverUrl, vodTokenInfo, callback);
            }
        }, new Function0<Unit>() { // from class: com.huachenjie.common.aliyun.video_upload.VideoUploadHelper$upload$2
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m342invoke();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m342invoke() {
                callback.onUploadFailed("404", "网络异常");
            }
        });
    }
}
