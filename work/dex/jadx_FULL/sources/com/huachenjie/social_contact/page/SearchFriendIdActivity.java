package com.huachenjie.social_contact.page;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.data_binding.BaseVM;
import com.huachenjie.common.base.data_binding.BaseVmActivity;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.social_contact.R;
import com.huachenjie.social_contact.databinding.ActivitySearchFriendIdBinding;
import com.huachenjie.social_contact.vm.SearchFriendIdVM;
import com.zj.adlib.i62;
import com.zj.adlib.nk0;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(path = RoutePathConstants.SocialContact.c)
public class SearchFriendIdActivity extends BaseVmActivity<SearchFriendIdVM> {

    public class a {
        public a() {
        }

        public void a(View view) {
            ((SearchFriendIdVM) ((BaseVmActivity) SearchFriendIdActivity.this).f8507a).i();
        }

        public void b(View view) {
            ((SearchFriendIdVM) ((BaseVmActivity) SearchFriendIdActivity.this).f8507a).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean k0(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return true;
        }
        ((SearchFriendIdVM) ((BaseVmActivity) this).f8507a).i();
        KeyboardUtils.k(textView);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        finish();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void e0() {
        e.p3(this).M2(0).T2(true).k3().G1(true).a1();
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public i62 getDataBindingConfig() {
        return new i62(Integer.valueOf(R.layout.activity_search_friend_id), Integer.valueOf(nk0.p0), ((BaseVmActivity) this).f8507a).a(Integer.valueOf(nk0.k), new a());
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void init(@Nullable Bundle bundle) {
        j0();
        ((ActivitySearchFriendIdBinding) getBinding()).f36106a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.zj.adlib.yx7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.f46136a.k0(textView, i, keyEvent);
            }
        });
    }

    @Override // com.huachenjie.common.base.data_binding.BaseVmActivity
    public void initViewModel() {
    }

    public final void j0() {
        ((SearchFriendIdVM) ((BaseVmActivity) this).f8507a).i.setValue(new BindingTitleBean().setStatusBarHeight(((BaseVM) ((SearchFriendIdVM) ((BaseVmActivity) this).f8507a)).f33644a.getValue().intValue()).setBackIconResId(R.mipmap.ic_message_back).setBackClick(new View.OnClickListener() { // from class: com.zj.adlib.xx7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f45913a.l0(view);
            }
        }).setTitleName("搜索ID").setTitleTextColor(zn1.a(R.color.color_2C3E50)));
    }
}
