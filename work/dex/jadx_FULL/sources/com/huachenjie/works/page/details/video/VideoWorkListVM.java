package com.huachenjie.works.page.details.video;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.ExpandableText;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.jo2;
import com.zj.adlib.v39;
import com.zj.adlib.v41;
import com.zj.adlib.y6b;
import com.zj.adlib.yj7;
import huachenjie.sdk.http.PageEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bJ\u0010KJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\n\u001a\u00020\u0004J!\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001f\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R%\u0010\u0003\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010\u00020\u00020\u00118\u0006¢\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00118\u0006¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016R#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020.0\u00118\u0006¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R%\u00104\u001a\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010*0*0\u00118\u0006¢\u0006\f\n\u0004\b2\u0010\u0014\u001a\u0004\b3\u0010\u0016R\u001b\u00107\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u00105\u001a\u0004\b6\u0010\u001cR\u001b\u0010;\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00105\u001a\u0004\b9\u0010:R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00180\u00118\u0006¢\u0006\f\n\u0004\b \u0010\u0014\u001a\u0004\b<\u0010\u0016R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020*0\u00118\u0006¢\u0006\f\n\u0004\b>\u0010\u0014\u001a\u0004\b?\u0010\u0016R\u001d\u0010C\u001a\b\u0012\u0004\u0012\u00020*0\u00118\u0006¢\u0006\f\n\u0004\bA\u0010\u0014\u001a\u0004\bB\u0010\u0016R\"\u0010I\u001a\u00020*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, d2 = {"Lcom/huachenjie/works/page/details/video/VideoWorkListVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", yj7.g.WORKS_NO, "", "y", "Lcom/huachenjie/works/bean/WorkDetailBean;", BroadcastFloorDetailDialog.DETAIL_BEAN_KEY, "k", "(Lcom/huachenjie/works/bean/WorkDetailBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "A", "Lhuachenjie/sdk/http/PageEntity;", "data", "j", "(Lhuachenjie/sdk/http/PageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "B", t.d, "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/works/page/details/video/WorkVideoListAdapter;", "a", "Landroidx/lifecycle/MutableLiveData;", "m", "()Landroidx/lifecycle/MutableLiveData;", "adapter", "", "K", "I", "t", "()I", "D", "(I)V", "pageNum", "f", "Ljava/lang/String;", "u", "()Ljava/lang/String;", "E", "(Ljava/lang/String;)V", "refreshTime", "kotlin.jvm.PlatformType", "b", j.o, "", "c", j.b, "fromMine", "", "d", "x", "videoUrlList", "e", "n", yj7.g.WORKS_LOAD_MORE, "Lkotlin/Lazy;", "v", "textContentWidth", "Landroid/text/TextPaint;", "w", "()Landroid/text/TextPaint;", "textPaint", "p", "lastListSize", y6b.f, "q", "loadMoreComplete", y6b.g, "r", "loadMoreEnd", "Z", "s", "()Z", "C", "(Z)V", "loadingNext", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class VideoWorkListVM extends BaseViewModel {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    public boolean loadingNext;

    /* JADX INFO: renamed from: f, reason: collision with other field name and from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<WorkVideoListAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> worksNo = new MutableLiveData<>("");

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> fromMine = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<List<String>> videoUrlList = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> canLoadMore = new MutableLiveData<>(Boolean.FALSE);

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy textContentWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListVM$textContentWidth$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Integer m934invoke() {
            return Integer.valueOf(fx7.e() - jj8.a(96.0f));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy textPaint = LazyKt.lazy(new Function0<TextPaint>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListVM$textPaint$2
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TextPaint m935invoke() {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(jj8.f(15.0f));
            return textPaint;
        }
    });

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> lastListSize = new MutableLiveData<>(0);

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> loadMoreComplete = new MutableLiveData<>();

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> loadMoreEnd = new MutableLiveData<>();

    public final void A() {
        if (this.loadingNext) {
            return;
        }
        this.loadingNext = true;
        this.pageNum++;
        B();
    }

    public final void B() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.details.video.VideoWorkListVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.C(false);
                VideoWorkListVM videoWorkListVM = this.this$0;
                videoWorkListVM.D(videoWorkListVM.getPageNum() - 1);
                this.this$0.r().setValue(Boolean.TRUE);
                return Boolean.FALSE;
            }
        }, null, new VideoWorkListVM$queryPageList$2(this, null), 11, null);
    }

    public final void C(boolean z) {
        this.loadingNext = z;
    }

    public final void D(int i) {
        this.pageNum = i;
    }

    public final void E(@Nullable String str) {
        this.refreshTime = str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object j(@NotNull PageEntity<WorkDetailBean> pageEntity, @NotNull Continuation<? super Unit> continuation) {
        VideoWorkListVM$dealPageData$1 videoWorkListVM$dealPageData$1;
        VideoWorkListVM videoWorkListVM;
        PageEntity<WorkDetailBean> pageEntity2;
        List<String> list;
        List<T> data;
        if (continuation instanceof VideoWorkListVM$dealPageData$1) {
            videoWorkListVM$dealPageData$1 = (VideoWorkListVM$dealPageData$1) continuation;
            int i = videoWorkListVM$dealPageData$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                videoWorkListVM$dealPageData$1.label = i - Integer.MIN_VALUE;
            } else {
                videoWorkListVM$dealPageData$1 = new VideoWorkListVM$dealPageData$1(this, continuation);
            }
        } else {
            videoWorkListVM$dealPageData$1 = new VideoWorkListVM$dealPageData$1(this, continuation);
        }
        Object obj = videoWorkListVM$dealPageData$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = videoWorkListVM$dealPageData$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.refreshTime = pageEntity.getRefreshTime();
            ArrayList arrayList = new ArrayList();
            CoroutineDispatcher coroutineDispatcherC = jo2.c();
            VideoWorkListVM$dealPageData$2 videoWorkListVM$dealPageData$2 = new VideoWorkListVM$dealPageData$2(pageEntity, this, arrayList, null);
            videoWorkListVM$dealPageData$1.L$0 = this;
            videoWorkListVM$dealPageData$1.L$1 = pageEntity;
            videoWorkListVM$dealPageData$1.L$2 = arrayList;
            videoWorkListVM$dealPageData$1.label = 1;
            if (v41.h(coroutineDispatcherC, videoWorkListVM$dealPageData$2, videoWorkListVM$dealPageData$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            videoWorkListVM = this;
            pageEntity2 = pageEntity;
            list = arrayList;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            list = (List) videoWorkListVM$dealPageData$1.L$2;
            pageEntity2 = (PageEntity) videoWorkListVM$dealPageData$1.L$1;
            videoWorkListVM = (VideoWorkListVM) videoWorkListVM$dealPageData$1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        if (!list.isEmpty()) {
            videoWorkListVM.videoUrlList.setValue(list);
        }
        MutableLiveData<Integer> mutableLiveData = videoWorkListVM.lastListSize;
        WorkVideoListAdapter value = videoWorkListVM.adapter.getValue();
        mutableLiveData.setValue((value == null || (data = value.getData()) == 0) ? Boxing.boxInt(-1) : Boxing.boxInt(data.size()));
        if (videoWorkListVM.pageNum == 0) {
            WorkVideoListAdapter value2 = videoWorkListVM.adapter.getValue();
            if (value2 != null) {
                List list2 = pageEntity2.getList();
                Intrinsics.checkNotNullExpressionValue(list2, "data.list");
                value2.addData((Collection) list2);
            }
            if (Intrinsics.areEqual(videoWorkListVM.canLoadMore.getValue(), Boxing.boxBoolean(true))) {
                videoWorkListVM.A();
            }
        } else {
            List list3 = pageEntity2.getList();
            boolean z = false;
            if (list3 != null && (!list3.isEmpty())) {
                z = true;
            }
            if (z) {
                WorkVideoListAdapter value3 = videoWorkListVM.adapter.getValue();
                if (value3 != null) {
                    List list4 = pageEntity2.getList();
                    Intrinsics.checkNotNullExpressionValue(list4, "data.list");
                    value3.addData((Collection) list4);
                }
            } else {
                videoWorkListVM.pageNum--;
            }
        }
        if (pageEntity2.getHasNext()) {
            videoWorkListVM.loadMoreComplete.setValue(Boxing.boxBoolean(true));
        } else {
            videoWorkListVM.loadMoreEnd.setValue(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object k(@NotNull WorkDetailBean workDetailBean, @NotNull Continuation<? super Unit> continuation) {
        this.pageNum = 0;
        PageEntity<WorkDetailBean> pageEntity = new PageEntity<>();
        pageEntity.setList(CollectionsKt.listOf(workDetailBean));
        pageEntity.setHasNext(true);
        pageEntity.setRefreshTime((String) null);
        Object objJ = j(pageEntity, continuation);
        return objJ == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJ : Unit.INSTANCE;
    }

    public final void l(WorkDetailBean bean) {
        if (!TextUtils.isEmpty(bean.getTitle()) && !TextUtils.isEmpty(bean.getContent())) {
            bean.setTextContent(RichTextUtils.f32968a.i(bean.getTitle() + ' ' + bean.getContent(), Color.parseColor("#FFEADCFF")));
        } else if (!TextUtils.isEmpty(bean.getTitle())) {
            bean.setTextContent(RichTextUtils.f32968a.i(bean.getTitle(), Color.parseColor("#FFEADCFF")));
        } else if (TextUtils.isEmpty(bean.getContent())) {
            bean.setTextContent("");
        } else {
            bean.setTextContent(RichTextUtils.f32968a.i(bean.getContent(), Color.parseColor("#FFEADCFF")));
        }
        if (TextUtils.isEmpty(bean.getTextContent())) {
            bean.setCloseContent("");
            bean.setExpandContent("");
            return;
        }
        CharSequence textContent = bean.getTextContent();
        Intrinsics.checkNotNull(textContent);
        ExpandableText expandableTextD = v39.d(textContent, w(), v(), (504 & 8) != 0 ? 3 : 0, (504 & 16) != 0 ? 2147483646 : 0, (504 & 32) != 0 ? -1 : 0, (504 & 64) != 0, (504 & 128) != 0 ? null : null, (504 & 256) != 0 ? false : false);
        bean.setCloseContent(expandableTextD.e());
        bean.setExpandContent(expandableTextD.f());
    }

    @NotNull
    public final MutableLiveData<WorkVideoListAdapter> m() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Boolean> n() {
        return this.canLoadMore;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.fromMine;
    }

    @NotNull
    public final MutableLiveData<Integer> p() {
        return this.lastListSize;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.loadMoreComplete;
    }

    @NotNull
    public final MutableLiveData<Boolean> r() {
        return this.loadMoreEnd;
    }

    /* JADX INFO: renamed from: s, reason: from getter */
    public final boolean getLoadingNext() {
        return this.loadingNext;
    }

    /* JADX INFO: renamed from: t, reason: from getter */
    public final int getPageNum() {
        return this.pageNum;
    }

    @Nullable
    /* JADX INFO: renamed from: u, reason: from getter */
    public final String getRefreshTime() {
        return this.refreshTime;
    }

    public final int v() {
        return ((Number) this.textContentWidth.getValue()).intValue();
    }

    public final TextPaint w() {
        return (TextPaint) this.textPaint.getValue();
    }

    @NotNull
    public final MutableLiveData<List<String>> x() {
        return this.videoUrlList;
    }

    public final void y(@NotNull String worksNo) {
        Intrinsics.checkNotNullParameter(worksNo, yj7.g.WORKS_NO);
        BaseViewModelExtKt.b(this, false, false, null, null, new VideoWorkListVM$getWorksDetail$1(worksNo, this, null), 15, null);
    }

    @NotNull
    public final MutableLiveData<String> z() {
        return this.worksNo;
    }
}
