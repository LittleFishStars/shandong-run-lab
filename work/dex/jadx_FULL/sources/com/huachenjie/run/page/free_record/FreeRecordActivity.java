package com.huachenjie.run.page.free_record;

import android.content.Intent;
import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.huachenjie.common.base.BaseActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.run.R;
import com.huachenjie.run.adapter.FreeRecordFragmentAdapter;
import com.zj.adlib.zn1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Route(path = RoutePathConstants.Run.f)
public class FreeRecordActivity extends BaseActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager f35849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TabLayout f12439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FreeRecordFragmentAdapter f12440a;
    public List<String> c;

    @Override // com.huachenjie.common.base.BaseActivity
    public int U() {
        return R.drawable.ic_back_white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int V() {
        return zn1.a(R.color.white);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public CharSequence X() {
        return ((BaseActivity) this).c.getString(R.string.run_free_run_record);
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int Y() {
        return R.color.color_373b4e;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int a0() {
        return R.color.white;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int b0() {
        return R.color.color_373b4e;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public int getContentViewRes() {
        return R.layout.run_activity_free_run_record;
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void handleIntent(Intent intent) {
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initField() {
        this.f12440a = new FreeRecordFragmentAdapter(getSupportFragmentManager());
        ArrayList arrayList = new ArrayList();
        this.c = arrayList;
        arrayList.add(((BaseActivity) this).c.getString(R.string.week));
        this.c.add(((BaseActivity) this).c.getString(R.string.month));
        this.c.add(((BaseActivity) this).c.getString(R.string.all));
    }

    @Override // com.huachenjie.common.base.BaseActivity
    public void initView() {
        this.f12439a = (TabLayout) S(R.id.tab_record_list);
        this.f35849a = (ViewPager) S(R.id.viewpager_record_list);
        this.f12440a.c(this.c);
        this.f35849a.setAdapter(this.f12440a);
        this.f12439a.setupWithViewPager(this.f35849a);
        this.f12439a.setSelectedTabIndicatorColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
    }

    @Override // com.huachenjie.common.base.BaseActivity, com.huachenjie.common.base.SideTextInterface
    public boolean s() {
        return true;
    }
}
