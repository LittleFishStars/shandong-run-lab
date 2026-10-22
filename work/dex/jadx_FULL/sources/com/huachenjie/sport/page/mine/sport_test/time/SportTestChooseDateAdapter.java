package com.huachenjie.sport.page.mine.sport_test.time;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.sport.R;
import com.huachenjie.sport.bean.FitnessTestPeriod;
import com.huachenjie.sport.databinding.ItemSportTestChooseDateBinding;
import com.huachenjie.sport.page.mine.sport_test.time.SportTestChooseDateAdapter;
import com.zj.adlib.y6b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0014R*\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R?\u0010\u001c\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/huachenjie/sport/page/mine/sport_test/time/SportTestChooseDateAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/huachenjie/sport/bean/FitnessTestPeriod;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/sport/databinding/ItemSportTestChooseDateBinding;", "holder", "item", "", "convert", "", "value", "K", "I", y6b.f, "()I", "i", "(I)V", "checkedIndex", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "position", "a", "Lkotlin/jvm/functions/Function1;", y6b.g, "()Lkotlin/jvm/functions/Function1;", "j", "(Lkotlin/jvm/functions/Function1;)V", "selectCallback", "<init>", "()V", "sport_release"}, k = 1, mv = {1, 8, 0})
public final class SportTestChooseDateAdapter extends BaseQuickAdapter<FitnessTestPeriod, BaseDataBindingHolder<ItemSportTestChooseDateBinding>> {

    /* JADX INFO: renamed from: K, reason: from kotlin metadata */
    public int checkedIndex;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    public Function1<? super Integer, Unit> selectCallback;

    public SportTestChooseDateAdapter() {
        super(R.layout.item_sport_test_choose_date, null, 2, null);
    }

    public static final void f(SportTestChooseDateAdapter sportTestChooseDateAdapter, BaseDataBindingHolder baseDataBindingHolder, View view) {
        Intrinsics.checkNotNullParameter(sportTestChooseDateAdapter, "this$0");
        Intrinsics.checkNotNullParameter(baseDataBindingHolder, "$holder");
        sportTestChooseDateAdapter.i(baseDataBindingHolder.getLayoutPosition());
        sportTestChooseDateAdapter.notifyDataSetChanged();
        Function1<? super Integer, Unit> function1 = sportTestChooseDateAdapter.selectCallback;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(baseDataBindingHolder.getLayoutPosition()));
        }
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final int getCheckedIndex() {
        return this.checkedIndex;
    }

    @Nullable
    public final Function1<Integer, Unit> h() {
        return this.selectCallback;
    }

    public final void i(int i) {
        this.checkedIndex = i;
        notifyDataSetChanged();
    }

    public final void j(@Nullable Function1<? super Integer, Unit> function1) {
        this.selectCallback = function1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NotNull final BaseDataBindingHolder<ItemSportTestChooseDateBinding> holder, @NotNull FitnessTestPeriod item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemSportTestChooseDateBinding itemSportTestChooseDateBinding = (ItemSportTestChooseDateBinding) holder.getDataBinding();
        if (itemSportTestChooseDateBinding != null) {
            itemSportTestChooseDateBinding.m(Boolean.valueOf(holder.getLayoutPosition() == this.checkedIndex));
            itemSportTestChooseDateBinding.l(item.getNaturalDay() + '\n' + item.getWeekDay());
            itemSportTestChooseDateBinding.f36528a.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.jn8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SportTestChooseDateAdapter.f(this.f17439a, holder, view);
                }
            });
            itemSportTestChooseDateBinding.executePendingBindings();
        }
    }
}
