package com.alibaba.triver.basic.picker.library.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ScrollPickerAdapter<T> extends RecyclerView.Adapter<d> implements com.alibaba.triver.basic.picker.library.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<T> f24730a;
    private Context b;
    private a c;
    private b d;
    private int e;
    private int f;
    private com.alibaba.triver.basic.picker.library.b g;
    private int h;
    private int i;
    private int j;

    public interface a {
        void a(View view);
    }

    public interface b {
        void a(View view);
    }

    public static class c<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ScrollPickerAdapter f24732a;

        public c(Context context) {
            this.f24732a = new ScrollPickerAdapter(context);
        }

        public c<T> a(int i) {
            this.f24732a.e = i;
            return this;
        }

        public c<T> b(int i) {
            this.f24732a.f = i;
            return this;
        }

        private void b(List list) {
            int i = this.f24732a.f;
            int i2 = this.f24732a.e;
            for (int i3 = 0; i3 < this.f24732a.e; i3++) {
                list.add(0, null);
            }
            for (int i4 = 0; i4 < (i - i2) - 1; i4++) {
                list.add(null);
            }
        }

        public c<T> a(List<T> list) {
            this.f24732a.f24730a.clear();
            this.f24732a.f24730a.addAll(list);
            return this;
        }

        public c<T> a(a aVar) {
            this.f24732a.c = aVar;
            return this;
        }

        public c<T> a(com.alibaba.triver.basic.picker.library.b bVar) {
            this.f24732a.g = bVar;
            return this;
        }

        public c<T> a(String str) {
            this.f24732a.h = Color.parseColor(str);
            return this;
        }

        public c<T> a(b bVar) {
            this.f24732a.d = bVar;
            return this;
        }

        public ScrollPickerAdapter a() {
            b(this.f24732a.f24730a);
            this.f24732a.notifyDataSetChanged();
            return this.f24732a;
        }
    }

    public static class d extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View f24733a;

        private d(@NonNull View view) {
            super(view);
            this.f24733a = view;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f24730a.size();
    }

    private ScrollPickerAdapter(Context context) {
        this.f = 3;
        this.i = 0;
        this.j = 0;
        this.b = context;
        this.f24730a = new ArrayList();
    }

    @Override // com.alibaba.triver.basic.picker.library.a
    public int b() {
        return this.f;
    }

    @Override // com.alibaba.triver.basic.picker.library.a
    public int c() {
        return this.h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (this.g == null) {
            this.g = new com.alibaba.triver.basic.picker.library.a.a();
        }
        return new d(LayoutInflater.from(this.b).inflate(this.g.a(), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull d dVar, int i) {
        this.g.a(dVar.f24733a, this.f24730a.get(i));
    }

    @Override // com.alibaba.triver.basic.picker.library.a
    public int a() {
        return this.e;
    }

    @Override // com.alibaba.triver.basic.picker.library.a
    public void a(View view, boolean z) {
        b bVar;
        this.g.a(view, z);
        a(view);
        if (z && (bVar = this.d) != null) {
            bVar.a(view);
        }
        view.setOnClickListener(z ? new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.library.adapter.ScrollPickerAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (ScrollPickerAdapter.this.c != null) {
                    ScrollPickerAdapter.this.c.a(view2);
                }
            }
        } : null);
    }

    private void a(View view) {
        int height = view.getHeight();
        if (height > this.i) {
            this.i = height;
        }
        int width = view.getWidth();
        if (width > this.j) {
            this.j = width;
        }
        view.setMinimumHeight(this.i);
        view.setMinimumWidth(this.j);
    }
}
