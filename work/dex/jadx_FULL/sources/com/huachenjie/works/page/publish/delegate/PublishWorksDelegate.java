package com.huachenjie.works.page.publish.delegate;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.blankj.utilcode.util.Utils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.bean.RichSubjectBean;
import com.huachenjie.base.bean.RichUserBean;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.aliyun.video_upload.VideoUploadCallback;
import com.huachenjie.common.aliyun.video_upload.VideoUploadHelper;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.huachenjie.works.bean.publish.PubWorksAttachmentImgInfo;
import com.huachenjie.works.bean.publish.PubWorksAttachmentInfo;
import com.huachenjie.works.bean.publish.PubWorksAttachmentVideoInfo;
import com.huachenjie.works.database.PublicWorkDatabase;
import com.huachenjie.works.database.PublicWorkDraft;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.pf6;
import com.zj.adlib.pu3;
import com.zj.adlib.sw0;
import com.zj.adlib.u66;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bI\u0010JJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007JL\u0010\u0015\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0012j\b\u0012\u0004\u0012\u00020\u0010`\u0013J#\u0010\u0019\u001a\u0004\u0018\u00010\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J/\u0010!\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J5\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010\u000b2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\u00102\b\u0010$\u001a\u0004\u0018\u00010\u0010H\u0082@ø\u0001\u0000¢\u0006\u0004\b&\u0010'J\u001a\u0010)\u001a\u0004\u0018\u00010%2\u0006\u0010 \u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u001bH\u0002J\"\u0010+\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u001bH\u0002J\u001b\u0010,\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\u00108\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010/R\u0014\u00104\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u00103R\u0014\u00105\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u00103R\u0014\u00107\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u00103R\u0014\u00109\u001a\u00020\u001b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u00103R$\u0010>\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b;\u00103\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00103R\u0016\u0010B\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010AR#\u0010H\u001a\n D*\u0004\u0018\u00010C0C8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010E\u001a\u0004\bF\u0010G\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"Lcom/huachenjie/works/page/publish/delegate/PublishWorksDelegate;", "", "Landroid/content/BroadcastReceiver;", "receiver", "", "k", "n", "", y6b.g, "Lcom/huachenjie/works/database/PublicWorkDraft;", "workDraft", "", "Lcom/huachenjie/base/bean/RichSubjectBean;", "topicList", "Lcom/huachenjie/base/bean/RichUserBean;", "userList", "", "requestId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "goodsList", "i", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "picList", "Lcom/huachenjie/works/bean/publish/PubWorksAttachmentInfo;", "p", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "progress", "m", "mediaData", "mediaPath", "coverPath", "q", "(Lcom/huachenjie/works/bean/publish/PubWorkMediaData;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "videoPath", "selCoverPath", "Lcom/huachenjie/works/bean/publish/PubWorksAttachmentImgInfo;", j.b, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "baseProgress", "r", "coverUrl", "j", t.d, "(Lcom/huachenjie/works/database/PublicWorkDraft;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Ljava/lang/String;", "RECEIVER_WORK", "b", "WORKS_PROGRESS", "I", "FAIL_PROGRESS", "COMPLETE_PROGRESS", "c", "START_PROGRESS", "d", "SUCCESS_PROGRESS", "<set-?>", "e", y6b.f, "()I", "currentWorksProgress", "f", "PUBLISH_RESULT_CHANNEL_FAIL", "Z", "currentTaskFinish", "Landroid/app/Application;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "getContext", "()Landroid/app/Application;", "context", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPublishWorksDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorksDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorksDelegate\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,407:1\n1549#2:408\n1620#2,3:409\n*S KotlinDebug\n*F\n+ 1 PublishWorksDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorksDelegate\n*L\n191#1:408\n191#1:409,3\n*E\n"})
public final class PublishWorksDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final int FAIL_PROGRESS = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_WORK = "com.huachenjie.shandong_school.receiver.works.progress";

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public static volatile boolean currentTaskFinish = false;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final int COMPLETE_PROGRESS = -2;

    /* JADX INFO: renamed from: b, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String WORKS_PROGRESS = "progress";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final int START_PROGRESS = 0;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public static final int SUCCESS_PROGRESS = 100;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final int PUBLISH_RESULT_CHANNEL_FAIL = 920201101;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NotNull
    public static final PublishWorksDelegate f14925a = new PublishWorksDelegate();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public static volatile int currentWorksProgress = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final Lazy context = LazyKt.lazy(new Function0<Application>() { // from class: com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$context$2
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Application m948invoke() {
            return Utils.a();
        }
    });

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"com/huachenjie/works/page/publish/delegate/PublishWorksDelegate$a", "Lcom/huachenjie/common/aliyun/video_upload/VideoUploadCallback;", "", "videoId", "", "a", "code", "message", "onUploadFailed", "", "uploadedSize", "totalSize", "onUploadProgress", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements VideoUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f37297a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f14930a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<String> f14931a;

        public a(Ref.ObjectRef<String> objectRef, CountDownLatch countDownLatch, int i) {
            this.f14931a = objectRef;
            this.f14930a = countDownLatch;
            this.f37297a = i;
        }

        @Override // com.huachenjie.common.aliyun.video_upload.VideoUploadCallback
        public void a(@Nullable String videoId) {
            if (videoId != null) {
                this.f14931a.element = videoId;
            }
            this.f14930a.countDown();
        }

        @Override // com.huachenjie.common.aliyun.video_upload.VideoUploadCallback
        public void onUploadFailed(@Nullable String code, @Nullable String message) {
            fv5.b(message);
            this.f14930a.countDown();
        }

        @Override // com.huachenjie.common.aliyun.video_upload.VideoUploadCallback
        public void onUploadProgress(long uploadedSize, long totalSize) {
            int i = this.f37297a;
            PublishWorksDelegate.f14925a.m(((int) (((uploadedSize * 1.0f) / totalSize) * (90 - i))) + i);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"com/huachenjie/works/page/publish/delegate/PublishWorksDelegate$b", "Lcom/huachenjie/common/aliyun/file_upload/MultipleUploadCallback;", "", "Lcom/zj/adlib/pf6;", "fileInfoList", "", "c", "", "position", "", "currentSize", "totalSize", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPublishWorksDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishWorksDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorksDelegate$uploadMultiPic$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,407:1\n1#2:408\n1864#3,3:409\n*S KotlinDebug\n*F\n+ 1 PublishWorksDelegate.kt\ncom/huachenjie/works/page/publish/delegate/PublishWorksDelegate$uploadMultiPic$3\n*L\n202#1:409,3\n*E\n"})
    public static final class b implements MultipleUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<PubWorkMediaData> f37298a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f14932a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<PubWorksAttachmentInfo> f14933a;

        public b(CountDownLatch countDownLatch, Ref.ObjectRef<PubWorksAttachmentInfo> objectRef, List<PubWorkMediaData> list) {
            this.f14932a = countDownLatch;
            this.f14933a = objectRef;
            this.f37298a = list;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
        public void a(int position, long currentSize, long totalSize) {
            float size = 0.9f / this.f37298a.size();
            PublishWorksDelegate.f14925a.m((int) (((position * size) + (((currentSize * 1.0f) / totalSize) * size)) * 100));
        }

        @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
        public void c(@Nullable List<pf6> fileInfoList) {
            pf6 pf6Var;
            Object next;
            if (fileInfoList != null) {
                Iterator<T> it = fileInfoList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!(!((pf6) next).f()));
                pf6Var = (pf6) next;
            } else {
                pf6Var = null;
            }
            if (pf6Var != null) {
                this.f14932a.countDown();
                return;
            }
            this.f14933a.element = new PubWorksAttachmentInfo(null, null, 3, null);
            if (fileInfoList != null) {
                Ref.ObjectRef<PubWorksAttachmentInfo> objectRef = this.f14933a;
                List<PubWorkMediaData> list = this.f37298a;
                int i = 0;
                for (Object obj : fileInfoList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Object obj2 = objectRef.element;
                    Intrinsics.checkNotNull(obj2);
                    List<PubWorksAttachmentImgInfo> imageList = ((PubWorksAttachmentInfo) obj2).getImageList();
                    PubWorksAttachmentImgInfo pubWorksAttachmentImgInfo = new PubWorksAttachmentImgInfo(null, false, 0, 7, null);
                    String strE = ((pf6) obj).e();
                    if (strE == null) {
                        strE = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(strE, "ossFileInfo.fileUrl ?: \"\"");
                    }
                    pubWorksAttachmentImgInfo.setPath(strE);
                    PubWorkMediaData pubWorkMediaData = list.get(i);
                    pubWorksAttachmentImgInfo.setName(com.huachenjie.works.utils.a.INSTANCE.a(pubWorksAttachmentImgInfo.getPath()));
                    pubWorksAttachmentImgInfo.setWidth(pubWorkMediaData.getMediaWidth());
                    pubWorksAttachmentImgInfo.setHeight(pubWorkMediaData.getMediaHeight());
                    pubWorksAttachmentImgInfo.setCover(i == 0);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(pubWorkMediaData.getPicPath(), options);
                    pubWorksAttachmentImgInfo.setWidth(options.outWidth);
                    pubWorksAttachmentImgInfo.setHeight(options.outHeight);
                    imageList.add(pubWorksAttachmentImgInfo);
                    i = i2;
                }
            }
            this.f14932a.countDown();
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016¨\u0006\u000e"}, d2 = {"com/huachenjie/works/page/publish/delegate/PublishWorksDelegate$c", "Lcom/huachenjie/common/aliyun/file_upload/UploadCallback;", "", "fileUrl", "", "onSuccess", "", "code", "message", "onFailed", "", "currentSize", "totalSize", "onProgress", "works_release"}, k = 1, mv = {1, 8, 0})
    public static final class c implements UploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f37299a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f14934a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f14935a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<PubWorksAttachmentImgInfo> f14936a;

        public c(Ref.ObjectRef<PubWorksAttachmentImgInfo> objectRef, String str, CountDownLatch countDownLatch, int i) {
            this.f14936a = objectRef;
            this.f14934a = str;
            this.f14935a = countDownLatch;
            this.f37299a = i;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onFailed(int code, @Nullable String message) {
            fv5.b(message);
            this.f14935a.countDown();
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onProgress(long currentSize, long totalSize) {
            PublishWorksDelegate.f14925a.m((int) (this.f37299a + (((currentSize * 1.0f) / totalSize) * 10)));
        }

        @Override // com.huachenjie.common.aliyun.file_upload.UploadCallback
        public void onSuccess(@Nullable String fileUrl) {
            this.f14936a.element = new PubWorksAttachmentImgInfo(null, false, 0, 7, null);
            Object obj = this.f14936a.element;
            Intrinsics.checkNotNull(obj);
            PubWorksAttachmentImgInfo pubWorksAttachmentImgInfo = (PubWorksAttachmentImgInfo) obj;
            if (fileUrl == null) {
                fileUrl = "";
            }
            pubWorksAttachmentImgInfo.setPath(fileUrl);
            Object obj2 = this.f14936a.element;
            Intrinsics.checkNotNull(obj2);
            ((PubWorksAttachmentImgInfo) obj2).setCover(true);
            Object obj3 = this.f14936a.element;
            Intrinsics.checkNotNull(obj3);
            com.huachenjie.works.utils.a.Companion companion = com.huachenjie.works.utils.a.INSTANCE;
            Object obj4 = this.f14936a.element;
            Intrinsics.checkNotNull(obj4);
            ((PubWorksAttachmentImgInfo) obj3).setName(companion.a(((PubWorksAttachmentImgInfo) obj4).getPath()));
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.f14934a, options);
            Object obj5 = this.f14936a.element;
            Intrinsics.checkNotNull(obj5);
            ((PubWorksAttachmentImgInfo) obj5).setWidth(options.outWidth);
            Object obj6 = this.f14936a.element;
            Intrinsics.checkNotNull(obj6);
            ((PubWorksAttachmentImgInfo) obj6).setHeight(options.outHeight);
            this.f14935a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Application getContext() {
        return (Application) context.getValue();
    }

    public final int g() {
        return currentWorksProgress;
    }

    public final boolean h() {
        int i = currentWorksProgress;
        return i >= 0 && i < 100;
    }

    public final void i(@NotNull final PublicWorkDraft workDraft, @NotNull List<RichSubjectBean> topicList, @NotNull List<RichUserBean> userList, @Nullable String requestId, @NotNull ArrayList<String> goodsList) {
        Intrinsics.checkNotNullParameter(workDraft, "workDraft");
        Intrinsics.checkNotNullParameter(topicList, "topicList");
        Intrinsics.checkNotNullParameter(userList, "userList");
        Intrinsics.checkNotNullParameter(goodsList, "goodsList");
        m(0);
        v41.e(pu3.a, new com.huachenjie.common.reconfig.net.exception.a(new com.huachenjie.common.reconfig.net.exception.c(true, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$publishWork$1

            /* JADX INFO: renamed from: com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$publishWork$1$1, reason: invalid class name */
            @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
            @DebugMetadata(c = "com.huachenjie.works.page.publish.delegate.PublishWorksDelegate$publishWork$1$1", f = "PublishWorksDelegate.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ResultException $it;
                final /* synthetic */ PublicWorkDraft $workDraft;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ResultException resultException, PublicWorkDraft publicWorkDraft, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$it = resultException;
                    this.$workDraft = publicWorkDraft;
                }

                @NotNull
                public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                    return new AnonymousClass1(this.$it, this.$workDraft, continuation);
                }

                @Nullable
                public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        if (this.$it.getCode() == 920201101) {
                            this.$workDraft.setChannel(null);
                        }
                        PublishWorksDelegate publishWorksDelegate = PublishWorksDelegate.f14925a;
                        PublicWorkDraft publicWorkDraft = this.$workDraft;
                        this.label = 1;
                        if (publishWorksDelegate.l(publicWorkDraft, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }
            }

            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                v41.e(pu3.a, jo2.c(), (CoroutineStart) null, new AnonymousClass1(resultException, workDraft, null), 2, (Object) null);
                return Boolean.FALSE;
            }
        })), (CoroutineStart) null, new PublishWorksDelegate$publishWork$2(workDraft, userList, topicList, requestId, goodsList, null), 2, (Object) null);
    }

    public final String j(String videoPath, String coverUrl, int baseProgress) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        VideoUploadHelper.INSTANCE.a().l(videoPath, coverUrl, new a(objectRef, countDownLatch, baseProgress));
        countDownLatch.await();
        return (String) objectRef.element;
    }

    public final void k(@NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(receiver, new IntentFilter(RECEIVER_WORK));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object l(PublicWorkDraft publicWorkDraft, Continuation<? super Unit> continuation) {
        PublishWorksDelegate$saveToDraft$1 publishWorksDelegate$saveToDraft$1;
        if (continuation instanceof PublishWorksDelegate$saveToDraft$1) {
            publishWorksDelegate$saveToDraft$1 = (PublishWorksDelegate$saveToDraft$1) continuation;
            int i = publishWorksDelegate$saveToDraft$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                publishWorksDelegate$saveToDraft$1.label = i - Integer.MIN_VALUE;
            } else {
                publishWorksDelegate$saveToDraft$1 = new PublishWorksDelegate$saveToDraft$1(this, continuation);
            }
        } else {
            publishWorksDelegate$saveToDraft$1 = new PublishWorksDelegate$saveToDraft$1(this, continuation);
        }
        Object obj = publishWorksDelegate$saveToDraft$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = publishWorksDelegate$saveToDraft$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            m(-1);
            if (publicWorkDraft.getIsNewWork()) {
                publicWorkDraft.setId(PublicWorkDatabase.INSTANCE.getPublicWorkDao().insertWork(publicWorkDraft));
                publicWorkDraft.setNewWork(false);
            } else {
                PublicWorkDatabase.INSTANCE.getPublicWorkDao().updateWork(publicWorkDraft);
            }
            publishWorksDelegate$saveToDraft$1.label = 1;
            if (DelayKt.b(2000L, publishWorksDelegate$saveToDraft$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        fv5.a(R.string.works_publish_work_fail);
        return Unit.INSTANCE;
    }

    public final void m(int progress) {
        if (progress == 0) {
            currentTaskFinish = false;
        }
        if (currentTaskFinish) {
            return;
        }
        if (progress == -2 || progress == -1) {
            currentTaskFinish = true;
        }
        currentWorksProgress = progress;
        Intent intent = new Intent(RECEIVER_WORK);
        intent.putExtra("progress", progress);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    public final void n(@NotNull BroadcastReceiver receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
    }

    public final Object o(String str, String str2, String str3, Continuation<? super List<PubWorksAttachmentImgInfo>> continuation) throws InterruptedException, IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(str);
        Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(0L);
        mediaMetadataRetriever.release();
        String str4 = str2 + File.separator + System.currentTimeMillis() + "-cover.webp";
        sw0.c(frameAtTime, str4, "webp", 75);
        PubWorksAttachmentImgInfo pubWorksAttachmentImgInfoR = r(str4, 0);
        if (pubWorksAttachmentImgInfoR == null) {
            return null;
        }
        pubWorksAttachmentImgInfoR.setCoverType(1);
        if (str3 == null) {
            return CollectionsKt.arrayListOf(new PubWorksAttachmentImgInfo[]{pubWorksAttachmentImgInfoR});
        }
        PubWorksAttachmentImgInfo pubWorksAttachmentImgInfoR2 = r(str3, 10);
        if (pubWorksAttachmentImgInfoR2 == null) {
            return null;
        }
        pubWorksAttachmentImgInfoR2.setCoverType(2);
        return CollectionsKt.arrayListOf(new PubWorksAttachmentImgInfo[]{pubWorksAttachmentImgInfoR, pubWorksAttachmentImgInfoR2});
    }

    public final Object p(List<PubWorkMediaData> list, Continuation<? super PubWorksAttachmentInfo> continuation) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Application context2 = getContext();
        UploadFileType uploadFileType = UploadFileType.UPLOAD_WORKS_PHOTO;
        List<PubWorkMediaData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            String picPath = ((PubWorkMediaData) it.next()).getPicPath();
            if (picPath == null) {
                picPath = "";
            }
            arrayList.add(picPath);
        }
        u66.e(context2, uploadFileType, arrayList, new b(countDownLatch, objectRef, list));
        countDownLatch.await();
        return objectRef.element;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object q(PubWorkMediaData pubWorkMediaData, String str, String str2, Continuation<? super PubWorksAttachmentInfo> continuation) throws InterruptedException, IOException {
        PublishWorksDelegate$uploadVideo$1 publishWorksDelegate$uploadVideo$1;
        String videoPath;
        PublishWorksDelegate publishWorksDelegate;
        PubWorksAttachmentImgInfo pubWorksAttachmentImgInfo;
        if (continuation instanceof PublishWorksDelegate$uploadVideo$1) {
            publishWorksDelegate$uploadVideo$1 = (PublishWorksDelegate$uploadVideo$1) continuation;
            int i = publishWorksDelegate$uploadVideo$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                publishWorksDelegate$uploadVideo$1.label = i - Integer.MIN_VALUE;
            } else {
                publishWorksDelegate$uploadVideo$1 = new PublishWorksDelegate$uploadVideo$1(this, continuation);
            }
        } else {
            publishWorksDelegate$uploadVideo$1 = new PublishWorksDelegate$uploadVideo$1(this, continuation);
        }
        Object objO = publishWorksDelegate$uploadVideo$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = publishWorksDelegate$uploadVideo$1.label;
        boolean z = true;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objO);
            videoPath = pubWorkMediaData.getVideoPath();
            if (videoPath == null) {
                videoPath = "";
            }
            publishWorksDelegate$uploadVideo$1.L$0 = this;
            publishWorksDelegate$uploadVideo$1.L$1 = str2;
            publishWorksDelegate$uploadVideo$1.L$2 = videoPath;
            publishWorksDelegate$uploadVideo$1.label = 1;
            objO = o(videoPath, str, str2, publishWorksDelegate$uploadVideo$1);
            if (objO == coroutine_suspended) {
                return coroutine_suspended;
            }
            publishWorksDelegate = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            videoPath = (String) publishWorksDelegate$uploadVideo$1.L$2;
            str2 = (String) publishWorksDelegate$uploadVideo$1.L$1;
            publishWorksDelegate = (PublishWorksDelegate) publishWorksDelegate$uploadVideo$1.L$0;
            ResultKt.throwOnFailure(objO);
        }
        List list = (List) objO;
        if (list == null || (pubWorksAttachmentImgInfo = (PubWorksAttachmentImgInfo) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        String strJ = publishWorksDelegate.j(videoPath, pubWorksAttachmentImgInfo.getPath(), str2 == null ? 10 : 20);
        if (strJ != null && strJ.length() != 0) {
            z = false;
        }
        if (z) {
            return null;
        }
        PubWorksAttachmentInfo pubWorksAttachmentInfo = new PubWorksAttachmentInfo(null, null, 3, null);
        String name = new File(videoPath).getName();
        if (name.length() > 32) {
            Intrinsics.checkNotNullExpressionValue(name, o.f);
            name = name.substring(name.length() - 32, name.length());
            Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Intrinsics.checkNotNullExpressionValue(name, "File(videoPath).name.let…      }\n                }");
        pubWorksAttachmentInfo.setVideo(new PubWorksAttachmentVideoInfo(name, strJ, pubWorksAttachmentImgInfo.getWidth(), pubWorksAttachmentImgInfo.getHeight()));
        pubWorksAttachmentInfo.getImageList().addAll(list);
        return pubWorksAttachmentInfo;
    }

    public final PubWorksAttachmentImgInfo r(String coverPath, int baseProgress) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        u66.d(getContext(), UploadFileType.UPLOAD_WORKS_VIDEO, coverPath, new c(objectRef, coverPath, countDownLatch, baseProgress));
        countDownLatch.await();
        return (PubWorksAttachmentImgInfo) objectRef.element;
    }
}
