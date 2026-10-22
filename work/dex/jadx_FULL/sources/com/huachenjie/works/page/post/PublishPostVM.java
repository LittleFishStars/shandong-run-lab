package com.huachenjie.works.page.post;

import android.content.Context;
import android.graphics.BitmapFactory;
import androidx.p002lifecycle.MutableLiveData;
import androidx.p002lifecycle.ViewModelKt;
import com.alibaba.android.arouter.utils.TextUtils;
import com.byazt.hv.TTDownloadField;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback;
import com.huachenjie.common.aliyun.file_upload.UploadFileType;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.PostCategoryBean;
import com.huachenjie.works.bean.PublishPostRequestBean;
import com.huachenjie.works.bean.PublishPostRequestImgBean;
import com.huachenjie.works.bean.publish.PubWorkMediaData;
import com.igexin.push.g.o;
import com.zj.adlib.fv5;
import com.zj.adlib.jo2;
import com.zj.adlib.pf6;
import com.zj.adlib.u66;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J1\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\nH\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R$\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R%\u0010\u0011\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\u00100\u00100\u001d8\u0006¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0006¢\u0006\f\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!R%\u0010+\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010\u00100\u00100\u001d8\u0006¢\u0006\f\n\u0004\b)\u0010\u001f\u001a\u0004\b*\u0010!R%\u0010.\u001a\u0010\u0012\f\u0012\n #*\u0004\u0018\u00010,0,0\u001d8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001f\u001a\u0004\b-\u0010!R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u001d8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001f\u001a\u0004\b0\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/huachenjie/works/page/post/PublishPostVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "u", "", "selTagCode", "v", "Lcom/huachenjie/works/page/post/PublishPostActivity;", TTDownloadField.TT_ACTIVITY, "t", "", "Lcom/huachenjie/works/bean/publish/PubWorkMediaData;", "picList", "Lcom/huachenjie/works/bean/PublishPostRequestImgBean;", "y", "(Lcom/huachenjie/works/page/post/PublishPostActivity;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "selTagIndex", "imageList", "w", "f", "Ljava/lang/String;", "requestId", y6b.f, "p", "()Ljava/lang/String;", "x", "(Ljava/lang/String;)V", "postType", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", j.b, "()Landroidx/lifecycle/MutableLiveData;", "content", "kotlin.jvm.PlatformType", "c", "s", "d", "r", "redPackNum", "e", "n", "anonymous", "Lcom/huachenjie/works/page/post/PublishPostAdapter;", "m", "adapter", "", "q", "publishResult", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nPublishPostVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishPostVM.kt\ncom/huachenjie/works/page/post/PublishPostVM\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n1549#2:172\n1620#2,3:173\n*S KotlinDebug\n*F\n+ 1 PublishPostVM.kt\ncom/huachenjie/works/page/post/PublishPostVM\n*L\n112#1:172\n112#1:173,3\n*E\n"})
public final class PublishPostVM extends BaseTitleViewModel {

    /* JADX INFO: renamed from: g, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String postType;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public String requestId = "";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> content = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> selTagIndex = new MutableLiveData<>(-1);

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> redPackNum = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> anonymous = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PublishPostAdapter> adapter = new MutableLiveData<>(new PublishPostAdapter());

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> publishResult = new MutableLiveData<>();

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J \u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"com/huachenjie/works/page/post/PublishPostVM$a", "Lcom/huachenjie/common/aliyun/file_upload/MultipleUploadCallback;", "", "Lcom/zj/adlib/pf6;", "fileInfoList", "", "c", "", "position", "", "currentSize", "totalSize", "a", "works_release"}, k = 1, mv = {1, 8, 0})
    @SourceDebugExtension({"SMAP\nPublishPostVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PublishPostVM.kt\ncom/huachenjie/works/page/post/PublishPostVM$uploadMultiPic$3\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n1#2:172\n1864#3,3:173\n*S KotlinDebug\n*F\n+ 1 PublishPostVM.kt\ncom/huachenjie/works/page/post/PublishPostVM$uploadMultiPic$3\n*L\n123#1:173,3\n*E\n"})
    public static final class a implements MultipleUploadCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<PubWorkMediaData> f37289a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownLatch f14914a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Ref.ObjectRef<List<PublishPostRequestImgBean>> f14915a;

        public a(CountDownLatch countDownLatch, Ref.ObjectRef<List<PublishPostRequestImgBean>> objectRef, List<PubWorkMediaData> list) {
            this.f14914a = countDownLatch;
            this.f14915a = objectRef;
            this.f37289a = list;
        }

        @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
        public void a(int position, long currentSize, long totalSize) {
        }

        @Override // com.huachenjie.common.aliyun.file_upload.MultipleUploadCallback
        public void c(@Nullable List<pf6> fileInfoList) {
            Object obj = null;
            if (fileInfoList != null) {
                for (Object obj2 : fileInfoList) {
                    if (!((pf6) obj2).f()) {
                        obj = obj2;
                        break;
                    }
                }
                obj = (pf6) obj;
            }
            if (obj != null) {
                this.f14914a.countDown();
                return;
            }
            this.f14915a.element = new ArrayList();
            if (fileInfoList != null) {
                List<PubWorkMediaData> list = this.f37289a;
                Ref.ObjectRef<List<PublishPostRequestImgBean>> objectRef = this.f14915a;
                int i = 0;
                for (Object obj3 : fileInfoList) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    PubWorkMediaData pubWorkMediaData = list.get(i);
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(pubWorkMediaData.getPicPath(), options);
                    Object obj4 = objectRef.element;
                    Intrinsics.checkNotNull(obj4);
                    List list2 = (List) obj4;
                    String strE = ((pf6) obj3).e();
                    if (strE == null) {
                        strE = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(strE, "ossFileInfo.fileUrl ?: \"\"");
                    }
                    list2.add(new PublishPostRequestImgBean(strE, options.outWidth, options.outHeight));
                    i = i2;
                }
            }
            this.f14914a.countDown();
        }
    }

    @NotNull
    public final MutableLiveData<PublishPostAdapter> m() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> n() {
        return this.anonymous;
    }

    @NotNull
    public final MutableLiveData<String> o() {
        return this.content;
    }

    @Nullable
    /* JADX INFO: renamed from: p, reason: from getter */
    public final String getPostType() {
        return this.postType;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.publishResult;
    }

    @NotNull
    public final MutableLiveData<String> r() {
        return this.redPackNum;
    }

    @NotNull
    public final MutableLiveData<Integer> s() {
        return this.selTagIndex;
    }

    public final void t(@NotNull PublishPostActivity activity) {
        List<PostCategoryBean> data;
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        if (TextUtils.isEmpty(this.content.getValue()) && activity.v0().isEmpty()) {
            fv5.a(R.string.works_publish_post_hint_content);
            return;
        }
        Integer value = this.selTagIndex.getValue();
        if (value == null) {
            value = -1;
        }
        int iIntValue = value.intValue();
        if (iIntValue >= 0) {
            PublishPostAdapter value2 = this.adapter.getValue();
            if (iIntValue < ((value2 == null || (data = value2.getData()) == null) ? 0 : data.size())) {
                g();
                v41.e(ViewModelKt.getViewModelScope(this), jo2.c(), (CoroutineStart) null, new PublishPostVM$publishPost$1(activity, this, iIntValue, null), 2, (Object) null);
                return;
            }
        }
        fv5.a(R.string.works_publish_post_hint_tag);
    }

    public final void u() {
        BaseViewModelExtKt.b(this, false, false, null, null, new PublishPostVM$queryPublishPostRequestId$1(this, null), 15, null);
    }

    public final void v(@Nullable String selTagCode) {
        BaseViewModelExtKt.b(this, true, false, null, null, new PublishPostVM$queryTagList$1(this, selTagCode, null), 14, null);
    }

    public final void w(int selTagIndex, List<PublishPostRequestImgBean> imageList) {
        PostCategoryBean item;
        String tagCode;
        String str = this.requestId;
        String value = this.content.getValue();
        String str2 = value == null ? "" : value;
        String str3 = this.postType;
        String str4 = str3 == null ? "" : str3;
        PublishPostAdapter value2 = this.adapter.getValue();
        String str5 = (value2 == null || (item = value2.getItem(selTagIndex)) == null || (tagCode = item.getTagCode()) == null) ? "" : tagCode;
        String value3 = this.redPackNum.getValue();
        Integer value4 = this.anonymous.getValue();
        if (value4 == null) {
            value4 = 0;
        }
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.post.PublishPostVM$realPublishPost$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.c();
                return Boolean.FALSE;
            }
        }, null, new PublishPostVM$realPublishPost$2(new PublishPostRequestBean(str, 0, str2, str4, str5, value3, value4.intValue(), imageList, 2, null), this, null), 11, null);
    }

    public final void x(@Nullable String str) {
        this.postType = str;
    }

    public final Object y(PublishPostActivity publishPostActivity, List<PubWorkMediaData> list, Continuation<? super List<PublishPostRequestImgBean>> continuation) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Context applicationContext = publishPostActivity.getApplicationContext();
        UploadFileType uploadFileType = UploadFileType.UPLOAD_LIVE_PHOTO;
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
        u66.e(applicationContext, uploadFileType, arrayList, new a(countDownLatch, objectRef, list));
        countDownLatch.await();
        return objectRef.element;
    }
}
