package com.huachenjie.social_contact.page.suit;

import android.annotation.SuppressLint;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.huachenjie.social_contact.bean.SuitDataBean;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014R$\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0012j\b\u0012\u0004\u0012\u00020\n`\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/huachenjie/social_contact/page/suit/UserWearSuitPageAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "", "d", "", "Lcom/huachenjie/social_contact/bean/SuitDataBean;", "data", "", "e", "", "a", "[Ljava/lang/String;", "mTitleArray", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mTitles", "b", "mList", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class UserWearSuitPageAdapter extends FragmentStateAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public final ArrayList<String> mTitles;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final String[] mTitleArray;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public final ArrayList<SuitDataBean> mList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserWearSuitPageAdapter(@NotNull Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.mTitleArray = new String[]{"套装", "发型", "表情", "服装", "鞋"};
        this.mTitles = new ArrayList<>();
        this.mList = new ArrayList<>();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NotNull
    public Fragment createFragment(int position) {
        SuitDataBean suitDataBean = this.mList.get(position);
        Intrinsics.checkNotNullExpressionValue(suitDataBean, "mList[position]");
        SuitDataBean suitDataBean2 = suitDataBean;
        return UserWearSuitListFragment.INSTANCE.a(suitDataBean2.getType(), suitDataBean2.getSuitList());
    }

    @NotNull
    public final String d(int position) {
        String str = this.mTitles.get(position);
        Intrinsics.checkNotNullExpressionValue(str, "mTitles[position]");
        return str;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public final void e(@NotNull List<SuitDataBean> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mTitles.clear();
        for (SuitDataBean suitDataBean : data) {
            int type = suitDataBean.getType();
            boolean z = false;
            if (type >= 0 && type < 5) {
                z = true;
            }
            if (z) {
                this.mTitles.add(this.mTitleArray[suitDataBean.getType()]);
            } else {
                this.mTitles.add("神秘套装");
            }
        }
        this.mList.clear();
        this.mList.addAll(data);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mTitles.size();
    }
}
