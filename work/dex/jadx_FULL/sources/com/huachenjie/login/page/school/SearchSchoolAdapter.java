package com.huachenjie.login.page.school;

import android.view.View;
import android.widget.FrameLayout;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.base.adapter.BaseRefreshAdapter;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.login.R;
import com.huachenjie.login.databinding.LoginItemSearchSchoolBinding;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u00020\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0011"}, d2 = {"Lcom/huachenjie/login/page/school/SearchSchoolAdapter;", "Lcom/huachenjie/base/adapter/BaseRefreshAdapter;", "Lcom/huachenjie/common/bean/SchoolInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/huachenjie/login/databinding/LoginItemSearchSchoolBinding;", "Lcom/chad/library/adapter/base/module/LoadMoreModule;", "holder", "item", "", "convert", "", "f", "", "showInputHintImg", "s", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class SearchSchoolAdapter extends BaseRefreshAdapter<SchoolInfo, BaseDataBindingHolder<LoginItemSearchSchoolBinding>> implements LoadMoreModule {
    public SearchSchoolAdapter() {
        super(R.layout.login_item_search_school);
    }

    @Override // com.huachenjie.base.adapter.BaseRefreshAdapter
    public int f() {
        return R.layout.login_view_empty_search_school;
    }

    public final void s(boolean showInputHintImg) {
        super.p();
        FrameLayout emptyLayout = getEmptyLayout();
        if (emptyLayout != null) {
            View viewFindViewById = emptyLayout.findViewById(R.id.iv_input_hint);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(showInputHintImg ? 0 : 8);
            }
            View viewFindViewById2 = emptyLayout.findViewById(R.id.ll_empty);
            if (viewFindViewById2 == null) {
                return;
            }
            viewFindViewById2.setVisibility(showInputHintImg ? 8 : 0);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@Nullable BaseDataBindingHolder<LoginItemSearchSchoolBinding> holder, @Nullable SchoolInfo item) {
        LoginItemSearchSchoolBinding loginItemSearchSchoolBinding;
        if (holder == null || (loginItemSearchSchoolBinding = (LoginItemSearchSchoolBinding) holder.getDataBinding()) == null) {
            return;
        }
        loginItemSearchSchoolBinding.k(item);
        loginItemSearchSchoolBinding.executePendingBindings();
    }
}
