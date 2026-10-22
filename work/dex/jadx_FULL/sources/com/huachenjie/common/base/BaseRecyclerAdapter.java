package com.huachenjie.common.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter implements View.OnClickListener, View.OnLongClickListener {
    public static final int K = Integer.MIN_VALUE;
    public static final int L = -2147483647;
    public static final int M = -2147483645;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f33639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Fragment f8493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnHeaderVisibleListener f8494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnItemClickListener f8495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnItemLongClickListener f8496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f8497a = new Object();
    public LayoutInflater b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f8498b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RecyclerView f8499b;
    public Context d;
    public List<T> f;

    public interface OnHeaderVisibleListener {
        void a(RecyclerView.ViewHolder holder, boolean visible);
    }

    public interface OnItemClickListener {
        void a(View view, int position);
    }

    public interface OnItemLongClickListener {
        void a(View view, int position);
    }

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.LayoutManager f33640a;

        public a(final RecyclerView.LayoutManager val$layoutManager) {
            this.f33640a = val$layoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            if (BaseRecyclerAdapter.this.x(position) || -2147483647 == BaseRecyclerAdapter.this.getItemViewType(position) || Integer.MIN_VALUE == BaseRecyclerAdapter.this.getItemViewType(position)) {
                return ((GridLayoutManager) this.f33640a).getSpanCount();
            }
            return 1;
        }
    }

    public class b extends RecyclerView.ViewHolder {
        public b(View itemView) {
            super(itemView);
        }
    }

    public class c extends RecyclerView.ViewHolder {
        public c(View itemView) {
            super(itemView);
        }
    }

    public BaseRecyclerAdapter(Context context) {
        this.d = context;
        n();
    }

    public void a(int location, T object) {
        synchronized (this.f8497a) {
            this.f.add(location, object);
            notifyItemInserted(location + (m() ? 1 : 0));
        }
    }

    public boolean b(T object) {
        synchronized (this.f8497a) {
            int size = this.f.size();
            if (!this.f.add(object)) {
                return false;
            }
            notifyItemInserted(size + (m() ? 1 : 0));
            return true;
        }
    }

    public boolean c(int index, Collection<? extends T> collection) {
        synchronized (this.f8497a) {
            if (!this.f.addAll(index, collection)) {
                return false;
            }
            notifyItemRangeInserted(index + (m() ? 1 : 0), collection.size());
            return true;
        }
    }

    public boolean d(Collection<? extends T> collection) {
        if (collection == null) {
            return false;
        }
        synchronized (this.f8497a) {
            int size = this.f.size();
            if (!this.f.addAll(collection)) {
                return false;
            }
            if (size == 0) {
                notifyDataSetChanged();
            } else {
                notifyItemRangeInserted(size + (m() ? 1 : 0), collection.size());
            }
            return true;
        }
    }

    public void f() {
        synchronized (this.f8497a) {
            this.f.clear();
            notifyDataSetChanged();
        }
    }

    public int g() {
        List<T> list = this.f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public List<T> getData() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.size() + (m() ? 1 : 0) + (l() ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        if (position == 0 && this.f33639a != null) {
            return Integer.MIN_VALUE;
        }
        if (position != getItemCount() - 1 || this.f8498b == null) {
            return M;
        }
        return -2147483647;
    }

    public int getRealPosition(int position) {
        return this.f33639a == null ? position : position - 1;
    }

    public View h() {
        return this.f33639a;
    }

    public T i(int position) {
        if (this.f.size() > position) {
            return this.f.get(position);
        }
        return null;
    }

    public T j(RecyclerView.ViewHolder holder) {
        return this.f.get(k(holder));
    }

    public int k(RecyclerView.ViewHolder holder) {
        int layoutPosition = holder.getLayoutPosition();
        return this.f33639a == null ? layoutPosition : layoutPosition - 1;
    }

    public boolean l() {
        return this.f8498b != null;
    }

    public boolean m() {
        return this.f33639a != null;
    }

    public final void n() {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.b = LayoutInflater.from(this.d);
    }

    public boolean o(int position) {
        return this.f8498b != null && position == getItemCount() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        this.f8499b = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanSizeLookup(new a(layoutManager));
        }
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position) == Integer.MIN_VALUE || getItemViewType(position) == -2147483647) {
            return;
        }
        viewHolder.itemView.setOnClickListener(this);
        viewHolder.itemView.setOnLongClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f8495a != null) {
            this.f8495a.a(view, this.f8499b.getChildLayoutPosition(this.f8499b.findContainingItemView(view)) - (m() ? 1 : 0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == Integer.MIN_VALUE) {
            return new c(this.f33639a);
        }
        if (viewType != -2147483647) {
            return null;
        }
        return new b(this.f8498b);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (this.f8496a == null) {
            return true;
        }
        this.f8496a.a(view, this.f8499b.getChildLayoutPosition(this.f8499b.findContainingItemView(view)) - (m() ? 1 : 0));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        OnHeaderVisibleListener onHeaderVisibleListener;
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        int layoutPosition = holder.getLayoutPosition();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            if (x(layoutPosition) || -2147483647 == getItemViewType(layoutPosition) || Integer.MIN_VALUE == getItemViewType(layoutPosition)) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            } else {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(false);
            }
        }
        if (this.f33639a == null || k(holder) != 0 || (onHeaderVisibleListener = this.f8494a) == null) {
            return;
        }
        onHeaderVisibleListener.a(holder, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        OnHeaderVisibleListener onHeaderVisibleListener;
        super.onViewDetachedFromWindow(holder);
        if (this.f33639a == null || k(holder) != 0 || (onHeaderVisibleListener = this.f8494a) == null) {
            return;
        }
        onHeaderVisibleListener.a(holder, false);
    }

    public boolean p(int position) {
        return this.f33639a != null && position == 0;
    }

    public void q(int position, T newObject) {
        synchronized (this.f8497a) {
            if (this.f.size() <= position) {
                return;
            }
            this.f.remove(this.f.get(position));
            this.f.add(position, newObject);
            notifyItemChanged(position + (m() ? 1 : 0));
        }
    }

    public void r(int from, int to) {
        synchronized (this.f8497a) {
            T t = this.f.get(from);
            this.f.remove(t);
            this.f.add(to, t);
            int i = 1;
            int i2 = from + (m() ? 1 : 0);
            if (!m()) {
                i = 0;
            }
            notifyItemMoved(i2, to + i);
        }
    }

    public void remove(int position) {
        synchronized (this.f8497a) {
            if (this.f.size() <= position) {
                return;
            }
            this.f.remove(position);
            notifyItemRemoved(position + (m() ? 1 : 0));
        }
    }

    public void s(int position, T newObject, Object payload) {
        synchronized (this.f8497a) {
            if (this.f.size() <= position) {
                return;
            }
            this.f.remove(this.f.get(position));
            this.f.add(position, newObject);
            notifyItemChanged(position + (m() ? 1 : 0), payload);
        }
    }

    public void setOnHeaderVisibleListener(OnHeaderVisibleListener onHeaderVisibleListener) {
        this.f8494a = onHeaderVisibleListener;
    }

    public void setOnItemClickListener(OnItemClickListener mItemClickListener) {
        this.f8495a = mItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mItemLongClickListener) {
        this.f8496a = mItemLongClickListener;
    }

    public boolean t(Collection<? extends T> collection) {
        synchronized (this.f8497a) {
            this.f.clear();
            if (!this.f.addAll(collection)) {
                return false;
            }
            notifyDataSetChanged();
            return true;
        }
    }

    public void u() {
        if (this.f8498b != null) {
            this.f8498b = null;
            int iG = g();
            if (this.f33639a != null) {
                iG++;
            }
            notifyItemRemoved(iG);
            notifyItemRangeChanged(iG, 1);
        }
    }

    public void v(View mFooterView) {
        this.f8498b = mFooterView;
    }

    public void w(View mHeadView) {
        this.f33639a = mHeadView;
    }

    public boolean x(int position) {
        return false;
    }

    public BaseRecyclerAdapter(Fragment fragment) {
        this.f8493a = fragment;
        this.d = fragment.getContext();
        n();
    }

    public void remove(T object) {
        synchronized (this.f8497a) {
            int iIndexOf = this.f.indexOf(object);
            if (iIndexOf < 0) {
                return;
            }
            this.f.remove(iIndexOf);
            notifyItemRemoved(iIndexOf + (m() ? 1 : 0));
        }
    }

    public BaseRecyclerAdapter(Context context, List<T> datas) {
        this.d = context;
        this.f = datas;
        n();
    }

    public BaseRecyclerAdapter(Fragment fragment, List<T> datas) {
        this.f8493a = fragment;
        this.d = fragment.getContext();
        this.f = datas;
        n();
    }
}
