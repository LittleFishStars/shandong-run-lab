package com.huachenjie.works.page.campus_wall.detail;

import android.graphics.Color;
import android.text.SpannableString;
import androidx.p002lifecycle.MutableLiveData;
import com.blankj.utilcode.util.SizeUtils;
import com.google.android.exoplayer2.source.rtsp.j;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.works.bean.PostDetailBean;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.zz8;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\""}, d2 = {"Lcom/huachenjie/works/page/campus_wall/detail/PostDetailViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", "postNo", "", "m", "q", "tag", "content", "", "j", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/common/reconfig/net/exception/ResultException;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "errorResult", "", "b", t.d, "fromMine", "Lcom/huachenjie/works/bean/PostDetailBean;", "c", "n", "postDetailBean", "d", "p", "tagContent", "e", j.b, "shareResult", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PostDetailViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<ResultException> errorResult = new MutableLiveData<>();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> fromMine = new MutableLiveData<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<PostDetailBean> postDetailBean = new MutableLiveData<>();

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<CharSequence> tagContent = new MutableLiveData<>();

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<Boolean> shareResult = new MutableLiveData<>();

    public final CharSequence j(String tag, String content) {
        SpannableString spannableString = new SpannableString(tag + content);
        spannableString.setSpan(new zz8(Color.parseColor("#ff762f"), -1, SizeUtils.i(12.0f), SizeUtils.b(18.0f), SizeUtils.b(8.0f), SizeUtils.b(9.0f), SizeUtils.b(4.0f)), 0, tag.length(), 33);
        return spannableString;
    }

    @NotNull
    public final MutableLiveData<ResultException> k() {
        return this.errorResult;
    }

    @NotNull
    public final MutableLiveData<Boolean> l() {
        return this.fromMine;
    }

    public final void m(@NotNull String postNo) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.works.page.campus_wall.detail.PostDetailViewModel$getPostDetail$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.k().setValue(resultException);
                return Boolean.TRUE;
            }
        }, null, new PostDetailViewModel$getPostDetail$2(postNo, this, null), 11, null);
    }

    @NotNull
    public final MutableLiveData<PostDetailBean> n() {
        return this.postDetailBean;
    }

    @NotNull
    public final MutableLiveData<Boolean> o() {
        return this.shareResult;
    }

    @NotNull
    public final MutableLiveData<CharSequence> p() {
        return this.tagContent;
    }

    public final void q(@NotNull String postNo) {
        Intrinsics.checkNotNullParameter(postNo, "postNo");
        BaseViewModelExtKt.b(this, true, false, null, null, new PostDetailViewModel$validPost$1(postNo, this, null), 14, null);
    }
}
