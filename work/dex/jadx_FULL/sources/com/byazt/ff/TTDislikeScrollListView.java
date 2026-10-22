package com.byazt.ff;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.byazt.nc.a;
import com.byazt.pr.tt;
import com.byazt.zqa.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@c(c = {0, 1, 142, 2450})
public class TTDislikeScrollListView extends ListView {
    public tt c;
    public AdapterView.OnItemClickListener tt;
    public AdapterView.OnItemClickListener ve;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.ve = new AdapterView.OnItemClickListener() { // from class: com.byazt.ff.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() == null || TTDislikeScrollListView.this.getAdapter().getItem(i) == null || !(TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof a)) {
                    throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
                }
                a aVar = (a) TTDislikeScrollListView.this.getAdapter().getItem(i);
                if (aVar.hasSecondOptions()) {
                    return;
                }
                if (TTDislikeScrollListView.this.tt != null) {
                    TTDislikeScrollListView.this.tt.onItemClick(adapterView, view, i, j);
                }
                if (TTDislikeScrollListView.this.c != null) {
                    TTDislikeScrollListView.this.c.c(aVar);
                }
            }
        };
        c();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public void setDislikeController(tt ttVar) {
        this.c = ttVar;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.tt = onItemClickListener;
    }

    private void c() {
        super.setOnItemClickListener(this.ve);
    }
}
