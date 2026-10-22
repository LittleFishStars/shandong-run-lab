package com.huachenjie.works.adapter.publish;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.SizeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import com.huachenjie.works.R;
import com.zj.adlib.y6b;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u00020\u00072\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tH\u0016J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fR#\u0010\u0015\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u001a\u001a\n \u0010*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001b¨\u0006!"}, d2 = {"Lcom/huachenjie/works/adapter/publish/BasePubWorkMenuAdapter;", "T", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "VH", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Landroid/widget/EditText;", "editText", "", "f", "", GoodsSpecificationPreviewActivity.z, "setList", "", "isSearchEmpty", "i", "Landroid/view/View;", "kotlin.jvm.PlatformType", "a", "Lkotlin/Lazy;", y6b.f, "()Landroid/view/View;", "emptyView", "Landroid/widget/TextView;", "b", y6b.g, "()Landroid/widget/TextView;", "tvEmpty", "Landroid/widget/EditText;", "searchEt", "", "layoutId", "<init>", "(I)V", "works_release"}, k = 1, mv = {1, 8, 0})
public abstract class BasePubWorkMenuAdapter<T, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public EditText searchEt;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Lazy emptyView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final Lazy tvEmpty;

    /* JADX WARN: Illegal instructions before constructor call */
    public BasePubWorkMenuAdapter(int i) {
        List list = null;
        super(i, list, 2, list);
        this.emptyView = LazyKt.lazy(new Function0<View>(this) { // from class: com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter$emptyView$2
            final /* synthetic */ BasePubWorkMenuAdapter<T, VH> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final View m804invoke() {
                View viewInflate = LayoutInflater.from(this.this$0.getContext()).inflate(R.layout.layout_empty_work, (ViewGroup) null);
                viewInflate.setPadding(0, SizeUtils.b(100.0f), 0, 0);
                return viewInflate;
            }
        });
        this.tvEmpty = LazyKt.lazy(new Function0<TextView>(this) { // from class: com.huachenjie.works.adapter.publish.BasePubWorkMenuAdapter$tvEmpty$2
            final /* synthetic */ BasePubWorkMenuAdapter<T, VH> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final TextView m805invoke() {
                return (TextView) this.this$0.g().findViewById(R.id.tv_empty);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View g() {
        return (View) this.emptyView.getValue();
    }

    public final void f(@NotNull EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        this.searchEt = editText;
    }

    public final TextView h() {
        return (TextView) this.tvEmpty.getValue();
    }

    public final void i(boolean isSearchEmpty) {
        if (g().getParent() == null) {
            View viewG = g();
            Intrinsics.checkNotNullExpressionValue(viewG, "emptyView");
            setEmptyView(viewG);
        }
        h().setText(isSearchEmpty ? R.string.works_publish_work_menu_empty : R.string.works_works_empty);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setList(@Nullable Collection<? extends T> list) {
        super.setList(list);
        if (getRecyclerViewOrNull() == null) {
            return;
        }
        if (!(list == null || list.isEmpty())) {
            removeEmptyView();
            return;
        }
        EditText editText = this.searchEt;
        Editable text = editText != null ? editText.getText() : null;
        i(!(text == null || text.length() == 0));
    }
}
