package com.huachenjie.compat.page.settings;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import androidx.coroutines.ViewDataBinding;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.bean.NotifySubConfig;
import com.huachenjie.compat.R;
import com.zj.adlib.wk0;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0019\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/huachenjie/compat/page/settings/PushSettingAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Landroidx/databinding/ViewDataBinding;", "holder", "item", "", "convert", "", "a", "Lkotlin/Lazy;", y6b.g, "()F", "SIZE_DP20", "", "b", y6b.f, "()I", "SIZE_DP16", "c", "f", "SIZE_DP14", "d", "i", "SIZE_DP22", "<init>", "()V", "compat_release"}, k = 1, mv = {1, 8, 0})
public final class PushSettingAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseDataBindingHolder<ViewDataBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP20;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP16;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP14;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @NotNull
    public final Lazy SIZE_DP22;

    /* JADX WARN: Illegal instructions before constructor call */
    public PushSettingAdapter() {
        List list = null;
        super(list, 1, list);
        this.SIZE_DP20 = LazyKt.lazy(new Function0<Float>() { // from class: com.huachenjie.compat.page.settings.PushSettingAdapter$SIZE_DP20$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m391invoke() {
                return Float.valueOf(SizeUtils.b(20.0f) * 1.0f);
            }
        });
        this.SIZE_DP16 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.compat.page.settings.PushSettingAdapter$SIZE_DP16$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m390invoke() {
                return Integer.valueOf(SizeUtils.b(16.0f));
            }
        });
        this.SIZE_DP14 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.compat.page.settings.PushSettingAdapter$SIZE_DP14$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m389invoke() {
                return Integer.valueOf(SizeUtils.b(14.0f));
            }
        });
        this.SIZE_DP22 = LazyKt.lazy(new Function0<Integer>() { // from class: com.huachenjie.compat.page.settings.PushSettingAdapter$SIZE_DP22$2
            @NotNull
            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m392invoke() {
                return Integer.valueOf(SizeUtils.b(22.0f));
            }
        });
        addItemType(1, R.layout.compat_item_push_setting_title);
        addItemType(2, R.layout.compat_item_push_setting_content);
    }

    public final int f() {
        return ((Number) this.SIZE_DP14.getValue()).intValue();
    }

    public final int g() {
        return ((Number) this.SIZE_DP16.getValue()).intValue();
    }

    public final float h() {
        return ((Number) this.SIZE_DP20.getValue()).floatValue();
    }

    public final int i() {
        return ((Number) this.SIZE_DP22.getValue()).intValue();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ViewDataBinding> holder, @NotNull MultiItemEntity item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        if (dataBinding != null) {
            if (item instanceof NotifySubConfig) {
                Drawable background = holder.itemView.getBackground();
                Intrinsics.checkNotNull(background, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                if (((NotifySubConfig) item).isGroupLastItem()) {
                    holder.itemView.setPadding(g(), f(), g(), i());
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, h(), h(), h(), h()});
                } else {
                    holder.itemView.setPadding(g(), f(), g(), f());
                    gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                }
            }
            dataBinding.setVariable(wk0.g, item);
            dataBinding.executePendingBindings();
        }
    }
}
