package com.zj.adlib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f1b extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41572a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f16427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OfflineMapManager f16428a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<OfflineMapProvince> f16429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f16430a;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i1b f16431a;

        public a() {
        }
    }

    public f1b(List<OfflineMapProvince> list, OfflineMapManager offlineMapManager, Context context) {
        this.f16429a = list;
        this.f16428a = offlineMapManager;
        this.f16427a = context;
        this.f16430a = new boolean[list.size()];
    }

    public final void a() {
        this.f41572a = -1;
        notifyDataSetChanged();
    }

    public final boolean b(int i) {
        return (i == 0 || i == getGroupCount() - 1) ? false : true;
    }

    public final void c() {
        this.f41572a = 0;
        notifyDataSetChanged();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return null;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            i1b i1bVar = new i1b(this.f16427a, this.f16428a);
            i1bVar.b(1);
            View viewA = i1bVar.a();
            aVar.f16431a = i1bVar;
            viewA.setTag(aVar);
            view = viewA;
        }
        aVar.f16431a.d(this.f16429a.get(i).getCityList().get(i2));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return b(i) ? this.f16429a.get(i).getCityList().size() : this.f16429a.get(i).getCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.f16429a.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        int i = this.f41572a;
        return i == -1 ? this.f16429a.size() : i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) q1b.d(this.f16427a, 2130903043);
        }
        TextView textView = (TextView) view.findViewById(2131165201);
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        textView.setText(this.f16429a.get(i).getProvinceName());
        if (this.f16430a[i]) {
            imageView.setImageDrawable(q1b.b().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(q1b.b().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.f16430a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.f16430a[i] = true;
    }
}
