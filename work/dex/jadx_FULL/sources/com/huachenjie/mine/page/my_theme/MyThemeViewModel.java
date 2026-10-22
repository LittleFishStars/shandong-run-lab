package com.huachenjie.mine.page.my_theme;

import androidx.p002lifecycle.MutableLiveData;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.common.reconfig.mvvm.BaseTitleViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.common.reconfig.net.exception.ResultException;
import com.huachenjie.mine.R;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/huachenjie/mine/page/my_theme/MyThemeViewModel;", "Lcom/huachenjie/common/reconfig/mvvm/BaseTitleViewModel;", "", "picUrl", "", t.d, "Lcom/bumptech/glide/request/RequestOptions;", "a", "Lcom/bumptech/glide/request/RequestOptions;", "j", "()Lcom/bumptech/glide/request/RequestOptions;", "bgOptions", "Landroidx/lifecycle/MutableLiveData;", "b", "Landroidx/lifecycle/MutableLiveData;", "k", "()Landroidx/lifecycle/MutableLiveData;", "showPic", "<init>", "()V", "mine_release"}, k = 1, mv = {1, 8, 0})
public final class MyThemeViewModel extends BaseTitleViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final RequestOptions bgOptions;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final MutableLiveData<String> showPic;

    public MyThemeViewModel() {
        RequestOptions requestOptions = new RequestOptions();
        int i = R.drawable.mine_bg_my_theme_custom;
        RequestOptions requestOptionsPlaceholder = requestOptions.error(i).placeholder(i);
        Intrinsics.checkNotNullExpressionValue(requestOptionsPlaceholder, "RequestOptions()\n       ….mine_bg_my_theme_custom)");
        this.bgOptions = requestOptionsPlaceholder;
        this.showPic = new MutableLiveData<>();
    }

    @NotNull
    /* JADX INFO: renamed from: j, reason: from getter */
    public final RequestOptions getBgOptions() {
        return this.bgOptions;
    }

    @NotNull
    public final MutableLiveData<String> k() {
        return this.showPic;
    }

    public final void l(@NotNull String picUrl) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        BaseViewModelExtKt.b(this, false, false, new Function1<ResultException, Boolean>() { // from class: com.huachenjie.mine.page.my_theme.MyThemeViewModel$updateCustomThemeImg$1
            {
                super(1);
            }

            @NotNull
            public final Boolean invoke(@NotNull ResultException resultException) {
                Intrinsics.checkNotNullParameter(resultException, o.f);
                this.this$0.c();
                return Boolean.FALSE;
            }
        }, null, new MyThemeViewModel$updateCustomThemeImg$2(picUrl, this, null), 10, null);
    }
}
