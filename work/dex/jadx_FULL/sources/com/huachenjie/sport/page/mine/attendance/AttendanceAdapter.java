package com.huachenjie.sport.page.mine.attendance;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.util.PicturePreviewUtil;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.AttendanceRecordBean;
import com.huachenjie.sport.bean.SignTimeSegment;
import com.huachenjie.sport.databinding.ItemAttendanceBinding;
import com.kuaishou.weapon.p0.t;
import com.zj.adlib.c49;
import com.zj.adlib.y6b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0002R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018¨\u0006\u001e"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/AttendanceRecordBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemAttendanceBinding;", "holder", "item", "", "convert", "k", "i", "", "Lcom/huachenjie/sport/bean/SignTimeSegment;", "signInList", "signOutList", t.d, "Landroid/view/View;", "f", y6b.f, "signList", "", y6b.g, "j", "a", "Landroid/view/View;", "errorView", "b", "headerView", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class AttendanceAdapter extends BaseQuickAdapter<AttendanceRecordBean, BaseDataBindingHolder<ItemAttendanceBinding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public View errorView;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @Nullable
    public View headerView;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\b"}, d2 = {"Lcom/huachenjie/sport/page/mine/attendance/AttendanceAdapter$a;", "", "Landroid/view/View;", "v", "", "a", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
    public static final class a {
        public final void a(@Nullable View v) {
            if (v == null || v.getTag() == null || !(v.getTag() instanceof String)) {
                return;
            }
            Object tag = v.getTag();
            String str = tag instanceof String ? (String) tag : null;
            if (str == null) {
                str = "";
            }
            PicturePreviewUtil.i(v, str);
        }
    }

    public AttendanceAdapter() {
        super(R.layout.item_attendance, null, 2, null);
    }

    public final View f() {
        if (this.errorView == null) {
            this.errorView = LayoutInflater.from(getContext()).inflate(R.layout.layout_empty_attendance, (ViewGroup) null);
        }
        return this.errorView;
    }

    public final View g() {
        if (this.headerView == null) {
            this.headerView = LayoutInflater.from(getContext()).inflate(R.layout.layout_attendance_header, (ViewGroup) null);
        }
        return this.headerView;
    }

    public final String h(List<SignTimeSegment> signList) {
        if (signList == null || signList.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (SignTimeSegment signTimeSegment : signList) {
            stringBuffer.append(signTimeSegment.getStartTime());
            stringBuffer.append(c49.f40900a);
            stringBuffer.append(signTimeSegment.getEndTime());
            stringBuffer.append(" ");
        }
        stringBuffer.substring(0, stringBuffer.length() - 1);
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "{\n            val sb = S…  sb.toString()\n        }");
        return string;
    }

    public final void i() {
        if (hasEmptyView()) {
            removeEmptyView();
        }
    }

    public final void j() {
        if (hasHeaderLayout()) {
            removeAllHeaderView();
        }
    }

    public final void k() {
        if (!hasEmptyView()) {
            View viewF = f();
            Intrinsics.checkNotNull(viewF);
            setEmptyView(viewF);
        }
        j();
    }

    public final void l(@Nullable List<SignTimeSegment> signInList, @Nullable List<SignTimeSegment> signOutList) {
        j();
        View viewG = g();
        if (viewG != null) {
            TextView textView = (TextView) viewG.findViewById(R.id.tvSingInList);
            if (textView != null) {
                Intrinsics.checkNotNullExpressionValue(textView, "findViewById<TextView>(R.id.tvSingInList)");
                textView.setText(h(signInList));
            }
            String strH = h(signOutList);
            if (TextUtils.isEmpty(strH)) {
                TextView textView2 = (TextView) viewG.findViewById(R.id.tvSingOut);
                if (textView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView2, "findViewById<TextView>(R.id.tvSingOut)");
                    textView2.setVisibility(8);
                }
                TextView textView3 = (TextView) viewG.findViewById(R.id.tvSingOutList);
                if (textView3 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView3, "findViewById<TextView>(R.id.tvSingOutList)");
                    textView3.setVisibility(8);
                }
            } else {
                TextView textView4 = (TextView) viewG.findViewById(R.id.tvSingOut);
                if (textView4 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView4, "findViewById<TextView>(R.id.tvSingOut)");
                    textView4.setVisibility(0);
                }
                TextView textView5 = (TextView) viewG.findViewById(R.id.tvSingOutList);
                if (textView5 != null) {
                    Intrinsics.checkNotNullExpressionValue(textView5, "findViewById<TextView>(R.id.tvSingOutList)");
                    textView5.setVisibility(0);
                    textView5.setText(strH);
                }
            }
            BaseQuickAdapter.setHeaderView$default(this, viewG, 0, 0, 6, null);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull BaseDataBindingHolder<ItemAttendanceBinding> holder, @NotNull AttendanceRecordBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemAttendanceBinding itemAttendanceBinding = (ItemAttendanceBinding) holder.getDataBinding();
        if (itemAttendanceBinding != null) {
            itemAttendanceBinding.m(item);
            itemAttendanceBinding.l(new a());
            itemAttendanceBinding.executePendingBindings();
        }
    }
}
