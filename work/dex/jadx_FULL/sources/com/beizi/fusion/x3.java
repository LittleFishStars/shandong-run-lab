package com.beizi.fusion;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.beizi.ad.internal.download.BeiZiWebView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x3 extends BaseExpandableListAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f28019a;
    private List b;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f28020a;
        BeiZiWebView b;

        public a() {
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f28021a;
        ImageView b;
        View c;

        public b() {
        }
    }

    public x3(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.f28019a = context;
        arrayList.clear();
        this.b.addAll(list);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((x7) this.b.get(i)).a();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f28019a).inflate(R.layout.beizi_download_dialog_expand_child_item, (ViewGroup) null);
        a aVar = new a();
        aVar.f28020a = (TextView) viewInflate.findViewById(R.id.beizi_addeci_content_tv);
        aVar.b = (BeiZiWebView) viewInflate.findViewById(R.id.beizi_addeci_content_wb);
        viewInflate.setTag(aVar);
        if ("text".equals(((x7) this.b.get(i)).b())) {
            aVar.f28020a.setVisibility(0);
            aVar.b.setVisibility(8);
            aVar.f28020a.setText(((x7) this.b.get(i)).a());
            return viewInflate;
        }
        if ("h5".equals(((x7) this.b.get(i)).b())) {
            aVar.f28020a.setVisibility(8);
            aVar.b.setVisibility(0);
            aVar.b.loadUrl(((x7) this.b.get(i)).a(), d9.a());
        }
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.b.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(this.f28019a).inflate(R.layout.beizi_download_dialog_expand_parent_item, (ViewGroup) null);
            bVar = new b();
            bVar.f28021a = (TextView) view.findViewById(R.id.beizi_addep_title_tv);
            bVar.b = (ImageView) view.findViewById(R.id.beizi_addep_fold_iv);
            bVar.c = view.findViewById(R.id.beizi_addep_item_divider_view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.f28021a.setText(((x7) this.b.get(i)).c());
        if (z) {
            bVar.f28021a.setTextColor(Color.parseColor("#FF8E15"));
            bVar.b.setBackgroundResource(R.mipmap.beizi_icon_arrow_unfold);
        } else {
            bVar.f28021a.setTextColor(Color.parseColor("#333333"));
            bVar.b.setBackgroundResource(R.mipmap.beizi_icon_arrow_fold);
        }
        if (i == 0) {
            bVar.c.setVisibility(8);
            return view;
        }
        bVar.c.setVisibility(0);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
