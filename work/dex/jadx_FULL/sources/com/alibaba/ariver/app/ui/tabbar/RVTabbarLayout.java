package com.alibaba.ariver.app.ui.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVTabbarLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<RVTabBarItem> f23838a;
    private Listener b;

    public interface Listener {
        void onTabItemClicked(int i, View view);
    }

    public RVTabbarLayout(Context context) {
        super(context);
        this.f23838a = new ArrayList();
        a();
    }

    private void a() {
        setOrientation(0);
    }

    private void b() {
        List<RVTabBarItem> list = this.f23838a;
        if (list == null) {
            return;
        }
        Iterator<RVTabBarItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().getRootView().setSelected(false);
        }
    }

    public void addTab(int i, RVTabBarItem rVTabBarItem) {
        if (this.f23838a == null) {
            return;
        }
        final View rootView = rVTabBarItem.getRootView();
        rootView.setTag(rVTabBarItem);
        rootView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.app.ui.tabbar.RVTabbarLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iIndexOf = RVTabbarLayout.this.f23838a.indexOf((RVTabBarItem) view.getTag());
                if (RVTabbarLayout.this.b != null) {
                    RVTabbarLayout.this.b.onTabItemClicked(iIndexOf, rootView);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        layoutParams.gravity = 17;
        rootView.setLayoutParams(layoutParams);
        rootView.setClickable(true);
        rootView.setFocusable(true);
        if (i >= 0) {
            this.f23838a.add(i, rVTabBarItem);
            addView(rootView, i);
        } else {
            this.f23838a.add(rVTabBarItem);
            addView(rootView);
        }
    }

    public RVTabBarItem getTabBarItemAt(int i) {
        return this.f23838a.get(i);
    }

    public int getTabSize() {
        List<RVTabBarItem> list = this.f23838a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f23838a.clear();
    }

    public void removeTab(int i) {
        this.f23838a.remove(i);
        removeViewAt(i);
    }

    public void selectTab(int i) {
        List<RVTabBarItem> list = this.f23838a;
        if (list == null) {
            return;
        }
        if (i >= list.size()) {
            i = 0;
        }
        RVTabBarItem rVTabBarItem = this.f23838a.get(i);
        b();
        rVTabBarItem.getRootView().setSelected(true);
    }

    public void setTabListener(Listener listener) {
        this.b = listener;
    }

    public RVTabbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23838a = new ArrayList();
        a();
    }

    public RVTabbarLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23838a = new ArrayList();
        a();
    }

    public void addTab(RVTabBarItem rVTabBarItem) {
        addTab(-1, rVTabBarItem);
    }
}
