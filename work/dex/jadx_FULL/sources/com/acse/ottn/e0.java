package com.acse.ottn;

import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class e0<T> extends PagerAdapter implements ViewPager.OnPageChangeListener {
    public static final String e = "BaseViewPagerAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f22966a;
    public Context b;
    public t c;
    public b d;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22967a;

        public a(int i) {
            this.f22967a = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e0.this.c.f();
            if (e0.this.d != null) {
                e0.this.d.a(this.f22967a % e0.this.a(), e0.this.f22966a.get(this.f22967a % e0.this.a()));
            }
            e0.this.c.e();
        }
    }

    public interface b<T> {
        void a(int i, T t);
    }

    public e0(List<T> list) {
        new ArrayList();
        this.f22966a = list;
    }

    public abstract void a(TextView textView, int i, T t);

    public abstract void a(RoundRectImageView roundRectImageView, int i, T t);

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((ImageView) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        List<T> list = this.f22966a;
        return (list == null || list.size() == 0) ? 0 : Integer.MAX_VALUE;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        RoundRectImageView roundRectImageView = (RoundRectImageView) LayoutInflater.from(this.b).inflate(R.layout.imageview, viewGroup, false);
        a(roundRectImageView, i, this.f22966a.get(i % a()));
        viewGroup.addView(roundRectImageView);
        if (this.c.getSubTitle() != null) {
            if (i == 0) {
                a(this.c.getSubTitle(), i, this.f22966a.get(a() - 1));
            } else {
                a(this.c.getSubTitle(), i, this.f22966a.get((i - 1) % a()));
            }
        }
        roundRectImageView.setOnClickListener(new a(i));
        return roundRectImageView;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.c.a(i % a());
    }

    public void a(t tVar, e0 e0Var) {
        this.c = tVar;
        tVar.setAdapter(this);
        this.c.addOnPageChangeListener(this);
        List<T> list = this.f22966a;
        if (list == null || list.size() == 0) {
            return;
        }
        this.c.setCurrentItem(com.google.common.collect.c.d - (com.google.common.collect.c.d % a()));
        if (this.c.c()) {
            return;
        }
        this.c.g();
        this.c.b(a());
    }

    public void b(List<T> list) {
        if (this.f22966a == null) {
            this.f22966a = new ArrayList();
        }
        this.f22966a.clear();
        this.f22966a.addAll(list);
        notifyDataSetChanged();
        if (this.c.c()) {
            return;
        }
        this.c.g();
        this.c.b(a());
    }

    public e0(Context context) {
        this.f22966a = new ArrayList();
        this.b = context;
    }

    public e0(Context context, b bVar) {
        this.f22966a = new ArrayList();
        this.b = context;
        this.d = bVar;
    }

    public e0(Context context, List<T> list) {
        new ArrayList();
        this.b = context;
        this.f22966a = list;
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public void a(T t) {
        if (this.c.getAdapter() != null) {
            if (this.f22966a == null) {
                this.f22966a = new ArrayList();
            }
            int currentItem = this.c.getCurrentItem() % a();
            this.f22966a.add(t);
            this.c.f();
            h2.a(e, "当前显示第" + currentItem + WVNativeCallbackUtil.SEPERATER + this.c.getCurrentItem());
            this.c.a(a(), currentItem);
            this.c.e();
            return;
        }
        throw new RuntimeException("必须先设置Adapter");
    }

    public e0(Context context, List<T> list, b bVar) {
        new ArrayList();
        this.b = context;
        this.f22966a = list;
        this.d = bVar;
    }

    public void a(List<T> list) {
        if (this.f22966a == null) {
            this.f22966a = new ArrayList();
        }
        this.f22966a.addAll(list);
        notifyDataSetChanged();
        this.c.g();
        this.c.b(a());
    }

    public int a() {
        List<T> list = this.f22966a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
