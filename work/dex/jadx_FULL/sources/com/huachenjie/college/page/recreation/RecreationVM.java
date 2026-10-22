package com.huachenjie.college.page.recreation;

import android.text.TextUtils;
import androidx.p002lifecycle.MutableLiveData;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.huachenjie.college.bean.CollegeTownBean;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.video.VideoPlayerActivity;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/college/page/recreation/RecreationVM;", "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "", t.d, "Lkotlin/Function1;", "", RenderCallContext.TYPE_CALLBACK, "m", "Landroidx/lifecycle/MutableLiveData;", "Lcom/huachenjie/college/bean/CollegeTownBean;", "a", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "collegeTownData", "f", "Ljava/lang/String;", VideoPlayerActivity.t, "<init>", "()V", "college_release"}, k = 1, mv = {1, 8, 0})
public final class RecreationVM extends BaseViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final MutableLiveData<CollegeTownBean> collegeTownData = new MutableLiveData<>();

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @Nullable
    public String videoUrl;

    @NotNull
    public final MutableLiveData<CollegeTownBean> k() {
        return this.collegeTownData;
    }

    public final void l() {
        BaseViewModelExtKt.b(this, false, false, null, null, new RecreationVM$queryCollegeTown$1(this, null), 15, null);
    }

    public final void m(@NotNull Function1<? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, RenderCallContext.TYPE_CALLBACK);
        if (TextUtils.isEmpty(this.videoUrl)) {
            BaseViewModelExtKt.b(this, true, false, null, null, new RecreationVM$queryVideoUrl$1(this, callback, null), 14, null);
            return;
        }
        String str = this.videoUrl;
        Intrinsics.checkNotNull(str);
        callback.invoke(str);
    }
}
