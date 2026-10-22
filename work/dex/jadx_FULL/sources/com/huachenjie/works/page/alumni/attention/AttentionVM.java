package com.huachenjie.works.page.alumni.attention;

import android.text.TextPaint;
import androidx.p002lifecycle.MutableLiveData;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.WorkDetailBean;
import com.igexin.push.g.o;
import com.zj.adlib.fx7;
import com.zj.adlib.jj8;
import com.zj.adlib.v39;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\b\u001a\u00020\u0002H\u0002R%\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\t8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\t8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001e\u0010\u000fR%\u0010#\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010 0 0\t8\u0006¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u000fR%\u0010&\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010 0 0\t8\u0006¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000fR\u001b\u0010*\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010.\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010'\u001a\u0004\b,\u0010-¨\u00061"}, d2 = {"Lcom/huachenjie/works/page/alumni/attention/AttentionVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "y", "w", "Lcom/huachenjie/works/bean/WorkDetailBean;", "workDetailBean", "u", "x", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "a", "Landroidx/lifecycle/MutableLiveData;", "v", "()Landroidx/lifecycle/MutableLiveData;", "isRefreshing", "Lcom/huachenjie/works/page/alumni/attention/AttentionWorksAdapter;", "b", j.b, "adapter", "", "K", "I", "pageNum", "", "f", "Ljava/lang/String;", "refreshTime", "c", "p", "publishProgress", "", "d", "s", "thumbProgress", "e", "t", "thumbTextProgress", "Lkotlin/Lazy;", "q", "()I", "textContentWidth", "Landroid/text/TextPaint;", "r", "()Landroid/text/TextPaint;", "textPaint", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class AttentionVM extends BaseViewModel {

    /* JADX INFO: renamed from: c, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy textContentWidth;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Float> thumbProgress;

    /* JADX INFO: renamed from: d, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy textPaint;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Float> thumbTextProgress;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String refreshTime;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>(Boolean.TRUE);

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<AttentionWorksAdapter> adapter = new MutableLiveData<>();

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int pageNum = 1;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Integer> publishProgress = new MutableLiveData<>(0);

    public AttentionVM() {
        Float fValueOf = Float.valueOf(0.0f);
        this.thumbProgress = new MutableLiveData<>(fValueOf);
        this.thumbTextProgress = new MutableLiveData<>(fValueOf);
        this.textContentWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionVM$textContentWidth$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m841invoke() {
                return Integer.valueOf(fx7.e() - jj8.a(32.0f));
            }
        });
        this.textPaint = LazyKt.lazy(new Function0<TextPaint>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionVM$textPaint$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextPaint m842invoke() {
                TextPaint textPaint = new TextPaint();
                textPaint.setTextSize(jj8.f(14.0f));
                return textPaint;
            }
        });
    }

    @NotNull
    public final MutableLiveData<AttentionWorksAdapter> o() {
        return this.adapter;
    }

    @NotNull
    public final MutableLiveData<Integer> p() {
        return this.publishProgress;
    }

    public final int q() {
        return ((Number) this.textContentWidth.getValue()).intValue();
    }

    public final TextPaint r() {
        return (TextPaint) this.textPaint.getValue();
    }

    @NotNull
    public final MutableLiveData<Float> s() {
        return this.thumbProgress;
    }

    @NotNull
    public final MutableLiveData<Float> t() {
        return this.thumbTextProgress;
    }

    public final void u(@NotNull WorkDetailBean workDetailBean) {
        Intrinsics.checkNotNullParameter(workDetailBean, "workDetailBean");
        String content = workDetailBean.getContent();
        if (content != null) {
            workDetailBean.setTextContent(RichTextUtils.j(RichTextUtils.f32968a, content, 0, 2, null));
            CharSequence textContent = workDetailBean.getTextContent();
            Intrinsics.checkNotNull(textContent);
            workDetailBean.setShowLookMore(Boolean.valueOf(v39.f(textContent, r(), q()).getLineCount() > 2));
        }
        AttentionWorksAdapter value = this.adapter.getValue();
        if (value != null) {
            value.addData(0, workDetailBean);
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.isRefreshing;
    }

    public final void w() {
        this.pageNum++;
        x();
    }

    public final void x() {
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.alumni.attention.AttentionVM$queryPageList$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                BaseLoadMoreModule loadMoreModule;
                Intrinsics.checkNotNullParameter(resultException, o.f);
                if (this.this$0.pageNum == 1) {
                    this.this$0.v().setValue(Boolean.FALSE);
                    AttentionWorksAdapter value = this.this$0.o().getValue();
                    if (value != null) {
                        value.setList(null);
                    }
                    AttentionWorksAdapter value2 = this.this$0.o().getValue();
                    if (value2 != null) {
                        value2.u();
                    }
                } else {
                    this.this$0.pageNum--;
                }
                AttentionWorksAdapter value3 = this.this$0.o().getValue();
                if (value3 != null && (loadMoreModule = value3.getLoadMoreModule()) != null) {
                    BaseLoadMoreModule.loadMoreEnd$default(loadMoreModule, false, 1, null);
                }
                return Boolean.FALSE;
            }
        }, null, new AttentionVM$queryPageList$2(this, null), 11, null);
    }

    public final void y() {
        this.isRefreshing.setValue(Boolean.TRUE);
        this.pageNum = 1;
        this.refreshTime = null;
        x();
    }
}
