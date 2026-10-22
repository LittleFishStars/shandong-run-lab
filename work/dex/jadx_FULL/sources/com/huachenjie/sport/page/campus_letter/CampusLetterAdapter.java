package com.huachenjie.sport.page.campus_letter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.CampusLetterBean;
import com.huachenjie.sport.databinding.ItemCampusLetterBinding;
import com.huachenjie.sport.page.campus_letter.CampusLetterAdapter;
import com.noober.background.view.BLTextView;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0014J\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/huachenjie/sport/page/campus_letter/CampusLetterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/CampusLetterBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemCampusLetterBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "i", y6b.g, "Landroid/view/View;", y6b.f, "a", "Landroid/view/View;", "mEmptyView", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nCampusLetterAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CampusLetterAdapter.kt\ncom/huachenjie/sport/page/campus_letter/CampusLetterAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,70:1\n1#2:71\n*E\n"})
public final class CampusLetterAdapter extends BaseQuickAdapter<CampusLetterBean, BaseDataBindingHolder<ItemCampusLetterBinding>> implements LoadMoreModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View mEmptyView;

    public CampusLetterAdapter() {
        super(R.layout.item_campus_letter, null, 2, null);
    }

    public static final void f(TextView textView, CampusLetterBean campusLetterBean, ItemCampusLetterBinding itemCampusLetterBinding, CampusLetterAdapter campusLetterAdapter) {
        Intrinsics.checkNotNullParameter(textView, "$textView");
        Intrinsics.checkNotNullParameter(campusLetterBean, "$item");
        Intrinsics.checkNotNullParameter(itemCampusLetterBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(campusLetterAdapter, "this$0");
        float fMeasureText = textView.getPaint().measureText(textView.getText().toString());
        if (!campusLetterBean.showPassStatus() || fMeasureText >= textView.getWidth()) {
            BLTextView bLTextView = itemCampusLetterBinding.f13557a;
            ViewGroup.LayoutParams layoutParams = bLTextView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(cr2.c(campusLetterAdapter.getContext(), 8.0f));
            bLTextView.setLayoutParams(layoutParams2);
            return;
        }
        BLTextView bLTextView2 = itemCampusLetterBinding.f13557a;
        ViewGroup.LayoutParams layoutParams3 = bLTextView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
        layoutParams4.setMarginStart((int) ((fMeasureText - textView.getWidth()) + cr2.c(campusLetterAdapter.getContext(), 8.0f)));
        bLTextView2.setLayoutParams(layoutParams4);
    }

    public final View g() {
        if (this.mEmptyView == null) {
            this.mEmptyView = LayoutInflater.from(getContext()).inflate(R.layout.layout_campus_letter_empty, (ViewGroup) null);
        }
        return this.mEmptyView;
    }

    public final void h() {
        removeEmptyView();
    }

    public final void i() {
        View viewG;
        if (hasEmptyView() || (viewG = g()) == null) {
            return;
        }
        setEmptyView(viewG);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemCampusLetterBinding> holder, @NotNull final CampusLetterBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final ItemCampusLetterBinding itemCampusLetterBinding = (ItemCampusLetterBinding) holder.getDataBinding();
        if (itemCampusLetterBinding != null) {
            final TextView textView = itemCampusLetterBinding.f13558b;
            textView.post(new Runnable() { // from class: com.zj.adlib.jd1
                @Override // java.lang.Runnable
                public final void run() {
                    CampusLetterAdapter.f(textView, item, itemCampusLetterBinding, this);
                }
            });
            itemCampusLetterBinding.k(item);
            itemCampusLetterBinding.executePendingBindings();
        }
    }
}
