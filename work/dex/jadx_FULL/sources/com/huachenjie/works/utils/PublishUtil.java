package com.huachenjie.works.utils;

import android.content.Context;
import android.view.View;
import com.huachenjie.common.reconfig.mvvm.BaseViewModel;
import com.huachenjie.common.reconfig.net.BaseViewModelExtKt;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.utils.PublishUtil;
import com.zj.adlib.ai9;
import com.zj.adlib.e0a;
import com.zj.adlib.ft1;
import com.zj.adlib.su9;
import com.zj.adlib.yj7;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014JV\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eJN\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¨\u0006\u0015"}, d2 = {"Lcom/huachenjie/works/utils/PublishUtil;", "", "Landroid/content/Context;", "context", "", "attachmentType", "Ljava/util/ArrayList;", "Lcom/huachenjie/works/bean/RecommendWorksBean;", "Lkotlin/collections/ArrayList;", yj7.g.WORKS_PUBLISH_CATEGORY_LIST, "", yj7.g.WORKS_PUBLISH_CATEGORY_NO, "Lcom/huachenjie/common/reconfig/mvvm/BaseViewModel;", "viewModel", "Lkotlin/Function0;", "", "onSuccess", "b", "e", "<init>", "()V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class PublishUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final PublishUtil f37344a = new PublishUtil();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(PublishUtil publishUtil, Context context, int i, ArrayList arrayList, String str, BaseViewModel baseViewModel, Function0 function0, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            function0 = null;
        }
        publishUtil.b(context, i, arrayList, str, baseViewModel, function0);
    }

    public static final void d(Context context, View view) {
        Intrinsics.checkNotNullParameter(context, "$context");
        su9.e(context);
    }

    public final void b(@NotNull final Context context, int attachmentType, @Nullable ArrayList<RecommendWorksBean> categoryList, @Nullable String categoryNo, @NotNull BaseViewModel viewModel, @Nullable Function0<Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (attachmentType != 2 || e0a.d().getVipOpenFlag() || ai9.e().getHasMonthCardRight()) {
            e(attachmentType, categoryList, categoryNo, viewModel, onSuccess);
        } else {
            ft1.g(context).Q("该功能仅对VIP用户开放，请先开通黑金护照").F("我再想想").N("前往开通").J(new View.OnClickListener() { // from class: com.zj.adlib.x37
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PublishUtil.d(context, view);
                }
            }).Y();
        }
    }

    public final void e(int attachmentType, ArrayList<RecommendWorksBean> categoryList, String categoryNo, BaseViewModel viewModel, Function0<Unit> onSuccess) {
        BaseViewModelExtKt.b(viewModel, true, false, null, null, new PublishUtil$validPublish$1(attachmentType, categoryList, categoryNo, viewModel, onSuccess, null), 14, null);
    }
}
