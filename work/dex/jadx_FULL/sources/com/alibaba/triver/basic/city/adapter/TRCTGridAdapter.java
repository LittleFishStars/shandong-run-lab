package com.alibaba.triver.basic.city.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.city.b.c;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRCTGridAdapter extends RecyclerView.Adapter<GridViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24699a = 3;
    private Context b;
    private List<c> c;
    private a d;

    public static class GridViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FrameLayout f24701a;
        TextView b;

        public GridViewHolder(View view) {
            super(view);
            this.f24701a = (FrameLayout) view.findViewById(R.id.cp_grid_item_layout);
            this.b = (TextView) view.findViewById(R.id.cp_gird_item_name);
        }
    }

    public TRCTGridAdapter(Context context, List<c> list) {
        this.b = context;
        this.c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<c> list = this.c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public GridViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new GridViewHolder(LayoutInflater.from(this.b).inflate(R.layout.tr_cp_grid_item_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(GridViewHolder gridViewHolder, int i) {
        final int adapterPosition = gridViewHolder.getAdapterPosition();
        final c cVar = this.c.get(adapterPosition);
        if (cVar == null) {
            return;
        }
        int i2 = this.b.getResources().getDisplayMetrics().widthPixels;
        TypedValue typedValue = new TypedValue();
        this.b.getTheme().resolveAttribute(R.attr.trcpGridItemSpace, typedValue, true);
        int dimensionPixelSize = this.b.getResources().getDimensionPixelSize(typedValue.resourceId);
        int dimensionPixelSize2 = (((i2 - this.b.getResources().getDimensionPixelSize(R.dimen.tr_cp_default_padding)) - (dimensionPixelSize * 2)) - this.b.getResources().getDimensionPixelSize(R.dimen.tr_cp_index_bar_width)) / 3;
        ViewGroup.LayoutParams layoutParams = gridViewHolder.f24701a.getLayoutParams();
        layoutParams.width = dimensionPixelSize2;
        layoutParams.height = -2;
        gridViewHolder.f24701a.setLayoutParams(layoutParams);
        gridViewHolder.b.setText(cVar.b());
        gridViewHolder.f24701a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.city.adapter.TRCTGridAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TRCTGridAdapter.this.d != null) {
                    TRCTGridAdapter.this.d.dismiss(adapterPosition, cVar);
                }
            }
        });
    }

    public void a(a aVar) {
        this.d = aVar;
    }
}
