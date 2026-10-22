package com.huachenjie.sport.page.mine.appeallist;

import android.content.Intent;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.gyf.immersionbar.e;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.sport.R;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Route(extras = 1, path = RoutePathConstants.Sport.m)
public class AppealListActivity extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f36569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TabLayout f13712a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AppealListFragmentAdapter f13713a;
    public List<String> c;

    @Override // com.huachenjie.common.base.BaseActivity
    public int U() {
        return R.drawable.ic_back;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int V() {
        return zn1.a(R.color.color_2C3E50);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public CharSequence X() {
        return ((BaseActivity) this).c.getString(R.string.score_appeal);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int a0() {
        return R.color.color_2C3E50;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int b0() {
        return R.color.white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.activity_appeal_list;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void h0() {
        e.p3(this).d3(((BaseActivity) this).f8486a).T2(true).u1(R.color.transparent).G1(true).a1();
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f13713a = new AppealListFragmentAdapter(getSupportFragmentManager());
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(((BaseActivity) this).c.getString(R.string.processed));
        this.c.add(((BaseActivity) this).c.getString(R.string.appealing));
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        this.f13712a = (TabLayout) S(R.id.tab_appeal_list);
        this.f36569a = (ViewPager) S(R.id.viewpager_appeal_list);
        this.f13713a.c(this.c);
        this.f36569a.setAdapter(this.f13713a);
        this.f13712a.setupWithViewPager(this.f36569a);
        this.f13712a.setSelectedTabIndicatorColor(ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null));
    }
}
