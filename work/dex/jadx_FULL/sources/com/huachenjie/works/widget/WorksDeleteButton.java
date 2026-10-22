package com.huachenjie.works.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.huachenjie.base.bean.MoreOptBean;
import com.huachenjie.base.widget.MoreOptDialog;
import com.huachenjie.works.R;
import com.huachenjie.works.bean.WorkDetailBean;
import com.huachenjie.works.widget.WorksDeleteButton;
import com.noober.background.view.BLImageView;
import com.zj.adlib.gv1;
import com.zj.adlib.ys8;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/huachenjie/works/widget/WorksDeleteButton;", "Lcom/noober/background/view/BLImageView;", "Lcom/huachenjie/works/bean/WorkDetailBean;", "a", "Lcom/huachenjie/works/bean/WorkDetailBean;", "getDetailBean", "()Lcom/huachenjie/works/bean/WorkDetailBean;", "setDetailBean", "(Lcom/huachenjie/works/bean/WorkDetailBean;)V", "detailBean", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "works_release"}, k = 1, mv = {1, 8, 0})
public final class WorksDeleteButton extends BLImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public WorkDetailBean detailBean;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WorksDeleteButton(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WorksDeleteButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ WorksDeleteButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(WorksDeleteButton worksDeleteButton, View view) {
        Activity activity;
        Intrinsics.checkNotNullParameter(worksDeleteButton, "this$0");
        if (worksDeleteButton.detailBean == null || (activity = gv1.getActivity((View) worksDeleteButton)) == null) {
            return;
        }
        MoreOptDialog.Companion companion = MoreOptDialog.INSTANCE;
        String strE = ys8.e(R.string.works_detail_menu_del_works);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.works_detail_menu_del_works)");
        String strE2 = ys8.e(R.string.works_detail_menu_permission);
        Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.works_detail_menu_permission)");
        MoreOptDialog moreOptDialogA = companion.a(CollectionsKt.arrayListOf(new MoreOptBean[]{new MoreOptBean(strE, R.drawable.works_ic_detail_del_works, 0, 4, null), new MoreOptBean(strE2, R.drawable.works_ic_detail_persmission, 0, 4, null)}), new WorksDeleteButton$1$1$1(activity, worksDeleteButton));
        FragmentManager supportFragmentManager = ((FragmentActivity) activity).getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity as FragmentActi…y).supportFragmentManager");
        moreOptDialogA.show(supportFragmentManager, MoreOptDialog.class.getSimpleName());
    }

    @Nullable
    public final WorkDetailBean getDetailBean() {
        return this.detailBean;
    }

    public final void setDetailBean(@Nullable WorkDetailBean workDetailBean) {
        this.detailBean = workDetailBean;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public WorksDeleteButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.f0a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WorksDeleteButton.d(this.f41563a, view);
            }
        });
    }
}
