package com.acse.ottn;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class u<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements t1<T, VH> {
    public b3 b;
    public VH c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<T> f23267a = new ArrayList();
    public int d = 2;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23268a;

        public a(int i) {
            this.f23268a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u.this.b.a(u.this.f23267a.get(this.f23268a), this.f23268a);
        }
    }

    public u(List<T> list) {
        a(list);
    }

    public int b(int i) {
        return z.a(this.d == 2, i, a());
    }

    public void c(int i) {
        this.d = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return a() > 1 ? a() + this.d : a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(@NonNull VH vh, int i) {
        this.c = vh;
        int iB = b(i);
        a(vh, this.f23267a.get(iB), iB, a());
        if (this.b != null) {
            vh.itemView.setOnClickListener(new a(iB));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return a(viewGroup, i);
    }

    public void a(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f23267a = list;
    }

    public VH b() {
        return this.c;
    }

    public T a(int i) {
        return this.f23267a.get(i);
    }

    public int a() {
        List<T> list = this.f23267a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(b3 b3Var) {
        this.b = b3Var;
    }
}
