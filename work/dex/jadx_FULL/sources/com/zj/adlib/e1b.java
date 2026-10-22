package com.zj.adlib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e1b extends BaseExpandableListAdapter implements ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f41322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OfflineMapManager f16173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i1b f16174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k1b f16175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f16177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<OfflineMapProvince> f16176a = new ArrayList();
    public List<OfflineMapProvince> b = new ArrayList();

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfflineMapCity f41323a;

        public a(OfflineMapCity offlineMapCity) {
            this.f41323a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            e1b.this.f16175a.j(this.f41323a);
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i1b f16179a;

        public b() {
        }
    }

    public e1b(Context context, k1b k1bVar, OfflineMapManager offlineMapManager, List<OfflineMapProvince> list) {
        this.f41322a = context;
        this.f16175a = k1bVar;
        this.f16173a = offlineMapManager;
        if (list != null && list.size() > 0) {
            this.f16176a.clear();
            this.f16176a.addAll(list);
            for (OfflineMapProvince offlineMapProvince : this.f16176a) {
                if (offlineMapProvince != null && offlineMapProvince.getDownloadedCityList().size() > 0) {
                    this.b.add(offlineMapProvince);
                }
            }
        }
        this.f16177a = new boolean[this.b.size()];
    }

    public final void b() {
        for (OfflineMapProvince offlineMapProvince : this.f16176a) {
            if (offlineMapProvince.getDownloadedCityList().size() > 0 && !this.b.contains(offlineMapProvince)) {
                this.b.add(offlineMapProvince);
            }
        }
        this.f16177a = new boolean[this.b.size()];
        notifyDataSetChanged();
    }

    public final void c() {
        try {
            for (int size = this.b.size(); size > 0; size--) {
                OfflineMapProvince offlineMapProvince = this.b.get(size - 1);
                if (offlineMapProvince.getDownloadedCityList().size() == 0) {
                    this.b.remove(offlineMapProvince);
                }
            }
            this.f16177a = new boolean[this.b.size()];
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getChild(int i, int i2) {
        return this.b.get(i).getDownloadedCityList().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view != null) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b();
            i1b i1bVar = new i1b(this.f41322a, this.f16173a);
            this.f16174a = i1bVar;
            i1bVar.b(2);
            view = this.f16174a.a();
            bVar.f16179a = this.f16174a;
            view.setTag(bVar);
        }
        OfflineMapProvince offlineMapProvince = this.b.get(i);
        if (i2 < offlineMapProvince.getDownloadedCityList().size()) {
            OfflineMapCity offlineMapCity = offlineMapProvince.getDownloadedCityList().get(i2);
            bVar.f16179a.d(offlineMapCity);
            view.setOnClickListener(new a(offlineMapCity));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getChildrenCount(int i) {
        return this.b.get(i).getDownloadedCityList().size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final Object getGroup(int i) {
        return this.b.get(i).getProvinceName();
    }

    @Override // android.widget.ExpandableListAdapter
    public final int getGroupCount() {
        return this.b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public final long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public final View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = (RelativeLayout) q1b.d(this.f41322a, 2130903043);
        }
        TextView textView = (TextView) view.findViewById(2131165201);
        ImageView imageView = (ImageView) view.findViewById(2131165202);
        textView.setText(this.b.get(i).getProvinceName());
        if (this.f16177a[i]) {
            imageView.setImageDrawable(q1b.b().getDrawable(2130837509));
        } else {
            imageView.setImageDrawable(q1b.b().getDrawable(2130837510));
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public final boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public final void onGroupCollapse(int i) {
        this.f16177a[i] = false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public final void onGroupExpand(int i) {
        this.f16177a[i] = true;
    }
}
