package com.huachenjie.works.widget;

import android.view.View;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.huachenjie.works.bean.InterestTag;
import com.huachenjie.works.page.alumni.find_alumni.SettingInterestTagsAdapter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/huachenjie/works/page/alumni/find_alumni/SettingInterestTagsAdapter;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class FindAlumniPicker$adapter$2 extends Lambda implements Function0<SettingInterestTagsAdapter> {
    final /* synthetic */ FindAlumniPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FindAlumniPicker$adapter$2(FindAlumniPicker findAlumniPicker) {
        super(0);
        this.this$0 = findAlumniPicker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void invoke$lambda$1$lambda$0(SettingInterestTagsAdapter settingInterestTagsAdapter, FindAlumniPicker findAlumniPicker, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(settingInterestTagsAdapter, "$this_apply");
        Intrinsics.checkNotNullParameter(findAlumniPicker, "this$0");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 1>");
        if (((InterestTag) settingInterestTagsAdapter.getItem(i)).getIsHeader()) {
            return;
        }
        if (findAlumniPicker.g()) {
            findAlumniPicker.e(i);
        } else {
            findAlumniPicker.d(i);
        }
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final SettingInterestTagsAdapter m986invoke() {
        final SettingInterestTagsAdapter settingInterestTagsAdapter = new SettingInterestTagsAdapter();
        final FindAlumniPicker findAlumniPicker = this.this$0;
        settingInterestTagsAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.huachenjie.works.widget.a
            @Override // com.chad.library.adapter.base.listener.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FindAlumniPicker$adapter$2.invoke$lambda$1$lambda$0(settingInterestTagsAdapter, findAlumniPicker, baseQuickAdapter, view, i);
            }
        });
        return settingInterestTagsAdapter;
    }
}
