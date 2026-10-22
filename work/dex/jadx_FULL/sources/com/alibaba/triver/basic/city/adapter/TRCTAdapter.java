package com.alibaba.triver.basic.city.adapter;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.triver.basic.api.R;
import com.alibaba.triver.basic.city.adapter.decoration.TRCTGridItemDecoration;
import com.alibaba.triver.basic.city.b.c;
import com.alibaba.triver.basic.city.b.d;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TRCTAdapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24692a = 10;
    private static final int b = 11;
    private Context c;
    private List<com.alibaba.triver.basic.city.b.b> d;
    private List<c> e;
    private int f;
    private com.alibaba.triver.basic.city.adapter.a g;
    private LinearLayoutManager h;
    private boolean i;
    private boolean j;

    public static class DefaultViewHolder extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        TextView f24696a;

        public DefaultViewHolder(View view) {
            super(view);
            this.f24696a = (TextView) view.findViewById(R.id.cp_list_item_name);
        }
    }

    public static class HotViewHolder extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        RecyclerView f24697a;

        public HotViewHolder(View view) {
            super(view);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.cp_hot_list);
            this.f24697a = recyclerView;
            recyclerView.setHasFixedSize(true);
            this.f24697a.setLayoutManager(new GridLayoutManager(view.getContext(), 3, 1, false));
            this.f24697a.addItemDecoration(new TRCTGridItemDecoration(3, view.getContext().getResources().getDimensionPixelSize(R.dimen.tr_cp_grid_item_space)));
        }
    }

    public static class LocationViewHolder extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        FrameLayout f24698a;
        TextView b;

        public LocationViewHolder(View view) {
            super(view);
            this.f24698a = (FrameLayout) view.findViewById(R.id.cp_list_item_location_layout);
            this.b = (TextView) view.findViewById(R.id.cp_list_item_location);
        }
    }

    public static class a extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    public TRCTAdapter(Context context, List<com.alibaba.triver.basic.city.b.b> list, List<c> list2, int i) {
        this.d = list;
        this.c = context;
        this.e = list2;
        this.f = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.alibaba.triver.basic.city.b.b> list = this.d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (!TextUtils.isEmpty(this.d.get(i).a()) && this.d.get(i).a().length() > 2 && TextUtils.equals("定位", this.d.get(i).a().substring(0, 2))) {
            return 10;
        }
        if (TextUtils.isEmpty(this.d.get(i).a()) || this.d.get(i).a().length() <= 2 || !TextUtils.equals("热门", this.d.get(i).a().substring(0, 2))) {
            return super.getItemViewType(i);
        }
        return 11;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public void a(LinearLayoutManager linearLayoutManager) {
        this.h = linearLayoutManager;
    }

    public void a(List<com.alibaba.triver.basic.city.b.b> list) {
        this.d = list;
        notifyDataSetChanged();
    }

    public void a(d dVar, int i) {
        this.d.remove(0);
        this.d.add(0, dVar);
        this.i = this.f != i;
        this.f = i;
        a();
    }

    public void a() {
        if (this.i && this.h.findFirstVisibleItemPosition() == 0) {
            this.i = false;
            notifyItemChanged(0);
        }
    }

    public void a(String str) {
        LinearLayoutManager linearLayoutManager;
        List<com.alibaba.triver.basic.city.b.b> list = this.d;
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(str.substring(0, 1), this.d.get(i).a().substring(0, 1)) && (linearLayoutManager = this.h) != null) {
                linearLayoutManager.scrollToPositionWithOffset(i, 0);
                if (TextUtils.equals(str.substring(0, 1), "定")) {
                    new Handler().postDelayed(new Runnable() { // from class: com.alibaba.triver.basic.city.adapter.TRCTAdapter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (TRCTAdapter.this.i) {
                                TRCTAdapter.this.notifyItemChanged(0);
                            }
                        }
                    }, 1000L);
                    return;
                }
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 10) {
            return new LocationViewHolder(LayoutInflater.from(this.c).inflate(R.layout.tr_cp_list_item_location_layout, viewGroup, false));
        }
        if (i != 11) {
            return new DefaultViewHolder(LayoutInflater.from(this.c).inflate(R.layout.tr_cp_list_item_default_layout, viewGroup, false));
        }
        return new HotViewHolder(LayoutInflater.from(this.c).inflate(R.layout.tr_cp_list_item_hot_layout, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i) {
        com.alibaba.triver.basic.city.adapter.a aVar2;
        if (aVar instanceof DefaultViewHolder) {
            final int adapterPosition = aVar.getAdapterPosition();
            final com.alibaba.triver.basic.city.b.b bVar = this.d.get(adapterPosition);
            if (bVar == null) {
                return;
            }
            DefaultViewHolder defaultViewHolder = (DefaultViewHolder) aVar;
            defaultViewHolder.f24696a.setText(bVar.b());
            defaultViewHolder.f24696a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.city.adapter.TRCTAdapter.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TRCTAdapter.this.g != null) {
                        TRCTAdapter.this.g.dismiss(adapterPosition, bVar);
                    }
                }
            });
        }
        if (aVar instanceof LocationViewHolder) {
            final int adapterPosition2 = aVar.getAdapterPosition();
            final com.alibaba.triver.basic.city.b.b bVar2 = this.d.get(adapterPosition2);
            if (bVar2 == null) {
                return;
            }
            int i2 = this.c.getResources().getDisplayMetrics().widthPixels;
            this.c.getTheme().resolveAttribute(R.attr.trcpGridItemSpace, new TypedValue(), true);
            int dimensionPixelSize = (((i2 - this.c.getResources().getDimensionPixelSize(R.dimen.tr_cp_default_padding)) - (this.c.getResources().getDimensionPixelSize(R.dimen.tr_cp_grid_item_space) * 2)) - this.c.getResources().getDimensionPixelSize(R.dimen.tr_cp_index_bar_width)) / 3;
            LocationViewHolder locationViewHolder = (LocationViewHolder) aVar;
            ViewGroup.LayoutParams layoutParams = locationViewHolder.f24698a.getLayoutParams();
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = -2;
            locationViewHolder.f24698a.setLayoutParams(layoutParams);
            int i3 = this.f;
            if (i3 == 123) {
                locationViewHolder.b.setText(R.string.tr_cp_locating);
            } else if (i3 == 132) {
                locationViewHolder.b.setText(bVar2.b());
            } else if (i3 == 321) {
                locationViewHolder.b.setText(R.string.tr_cp_locate_failed);
            }
            locationViewHolder.f24698a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.city.adapter.TRCTAdapter.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (TRCTAdapter.this.f == 132) {
                        if (TRCTAdapter.this.g != null) {
                            TRCTAdapter.this.g.dismiss(adapterPosition2, bVar2);
                        }
                    } else if (TRCTAdapter.this.f == 321) {
                        TRCTAdapter.this.f = 123;
                        TRCTAdapter.this.notifyItemChanged(0);
                        if (TRCTAdapter.this.g != null) {
                            TRCTAdapter.this.g.locate();
                        }
                    }
                }
            });
            if (this.j && this.f == 123 && (aVar2 = this.g) != null) {
                aVar2.locate();
                this.j = false;
            }
        }
        if (aVar instanceof HotViewHolder) {
            if (this.d.get(aVar.getAdapterPosition()) == null) {
                return;
            }
            TRCTGridAdapter tRCTGridAdapter = new TRCTGridAdapter(this.c, this.e);
            tRCTGridAdapter.a(this.g);
            ((HotViewHolder) aVar).f24697a.setAdapter(tRCTGridAdapter);
        }
    }

    public void a(com.alibaba.triver.basic.city.adapter.a aVar) {
        this.g = aVar;
    }
}
