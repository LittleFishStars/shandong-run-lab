package com.alibaba.ariver.app.ui.tabbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.app.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RVTabBarItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f23836a;
    private TextView b;
    private TextView c;
    private RVTabDotView d;

    public RVTabBarItem(Context context) {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.ariver_tabbar_item, (ViewGroup) null);
        this.f23836a = relativeLayout;
        this.b = (TextView) relativeLayout.findViewById(R.id.ariver_tabbar_item_text);
        this.c = (TextView) this.f23836a.findViewById(R.id.ariver_tabbar_item_badge);
        this.d = (RVTabDotView) this.f23836a.findViewById(R.id.ariver_tabbar_item_dot_view);
    }

    public TextView getBadgeAreaView() {
        return this.c;
    }

    public TextView getIconAreaView() {
        return this.b;
    }

    public View getRootView() {
        return this.f23836a;
    }

    public RVTabDotView getSmallDotView() {
        return this.d;
    }

    public String getTag() {
        return (String) this.f23836a.getTag();
    }

    public void setTag(String str) {
        this.f23836a.setTag(str);
    }
}
