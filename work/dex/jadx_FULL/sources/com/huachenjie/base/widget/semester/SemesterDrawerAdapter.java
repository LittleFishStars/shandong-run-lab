package com.huachenjie.base.widget.semester;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.huachenjie.base.R;
import com.huachenjie.base.widget.semester.SemesterDrawerAdapter;
import com.huachenjie.common.bean.SemesterBean;
import com.huachenjie.run.map.RouteOverlay;
import com.noober.background.drawable.DrawableCreator;
import com.zj.adlib.cr2;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0015R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/huachenjie/base/widget/semester/SemesterDrawerAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/common/bean/SemesterBean;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "holder", "item", "", "convert", "", "f", "Ljava/lang/String;", y6b.g, "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "semesterCode", "a", "Lcom/huachenjie/common/bean/SemesterBean;", y6b.f, "()Lcom/huachenjie/common/bean/SemesterBean;", "i", "(Lcom/huachenjie/common/bean/SemesterBean;)V", "mSemesterBean", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class SemesterDrawerAdapter extends BaseQuickAdapter<SemesterBean, BaseViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public SemesterBean mSemesterBean;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @NotNull
    public String semesterCode;

    public SemesterDrawerAdapter() {
        super(R.layout.item_drawer_semester, null, 2, null);
        this.semesterCode = "";
    }

    public static final void f(SemesterDrawerAdapter semesterDrawerAdapter, SemesterBean semesterBean, View view) {
        Intrinsics.checkNotNullParameter(semesterDrawerAdapter, "this$0");
        Intrinsics.checkNotNullParameter(semesterBean, "$item");
        semesterDrawerAdapter.semesterCode = semesterBean.getSemesterCode();
        semesterDrawerAdapter.mSemesterBean = semesterBean;
        semesterDrawerAdapter.notifyDataSetChanged();
    }

    @Nullable
    /* JADX INFO: renamed from: g, reason: from getter */
    public final SemesterBean getMSemesterBean() {
        return this.mSemesterBean;
    }

    @NotNull
    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getSemesterCode() {
        return this.semesterCode;
    }

    public final void i(@Nullable SemesterBean semesterBean) {
        this.mSemesterBean = semesterBean;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semesterCode = str;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @SuppressLint({"NotifyDataSetChanged"})
    public void convert(@NotNull BaseViewHolder holder, @NotNull final SemesterBean item) {
        boolean zAreEqual;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        TextView textView = (TextView) holder.getView(R.id.tvBL);
        textView.setText(item.getName());
        if (TextUtils.isEmpty(this.semesterCode)) {
            zAreEqual = true;
            if (item.getStatus() != 1) {
                zAreEqual = false;
            }
        } else {
            zAreEqual = Intrinsics.areEqual(this.semesterCode, item.getSemesterCode());
        }
        DrawableCreator.Builder builder = new DrawableCreator.Builder();
        if (zAreEqual) {
            builder.setSolidColor(Color.parseColor(RouteOverlay.f12338c));
        } else if (item.getStatus() == 0) {
            builder.setStrokeColor(Color.parseColor("#CCCCCC"));
            builder.setStrokeWidth(cr2.c(textView.getContext(), 1.0f));
        } else {
            builder.setStrokeColor(Color.parseColor("#666666"));
            builder.setStrokeWidth(cr2.c(textView.getContext(), 1.0f));
        }
        builder.setCornersRadius(cr2.c(textView.getContext(), 18.0f));
        textView.setBackground(builder.build());
        if (zAreEqual) {
            textView.setTextColor(Color.parseColor("#FFFFFF"));
        } else if (item.getStatus() == 0) {
            textView.setTextColor(Color.parseColor("#CCCCCC"));
        } else {
            textView.setTextColor(Color.parseColor("#666666"));
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.d58
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SemesterDrawerAdapter.f(this.f41110a, item, view);
            }
        });
    }
}
