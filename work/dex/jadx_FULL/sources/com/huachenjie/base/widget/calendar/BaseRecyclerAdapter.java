package com.huachenjie.base.widget.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter {
    Context mContext;
    LayoutInflater mInflater;
    private List<T> mItems = new ArrayList();
    private OnClickListener onClickListener = new OnClickListener() { // from class: com.huachenjie.base.widget.calendar.BaseRecyclerAdapter.1
        @Override // com.huachenjie.base.widget.calendar.BaseRecyclerAdapter.OnClickListener
        public void onClick(int position, long itemId) {
            if (BaseRecyclerAdapter.this.onItemClickListener != null) {
                BaseRecyclerAdapter.this.onItemClickListener.onItemClick(position, itemId);
            }
        }
    };
    private OnItemClickListener onItemClickListener;

    public static abstract class OnClickListener implements View.OnClickListener {
        public abstract void onClick(int position, long itemId);

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            onClick(viewHolder.getAdapterPosition(), viewHolder.getItemId());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, long itemId);
    }

    public BaseRecyclerAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    public void addAll(List<T> items) {
        if (items == null || items.size() <= 0) {
            return;
        }
        this.mItems.addAll(items);
        notifyItemRangeInserted(this.mItems.size(), items.size());
    }

    public final void addItem(T item) {
        if (item != null) {
            this.mItems.add(item);
            notifyItemChanged(this.mItems.size());
        }
    }

    public final T getItem(int position) {
        if (position < 0 || position >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mItems.size();
    }

    public final List<T> getItems() {
        return this.mItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder(holder, this.mItems.get(position), position);
    }

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, T item, int position);

    public abstract RecyclerView.ViewHolder onCreateDefaultViewHolder(ViewGroup parent, int type);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolderOnCreateDefaultViewHolder = onCreateDefaultViewHolder(parent, viewType);
        if (viewHolderOnCreateDefaultViewHolder != null) {
            viewHolderOnCreateDefaultViewHolder.itemView.setTag(viewHolderOnCreateDefaultViewHolder);
            viewHolderOnCreateDefaultViewHolder.itemView.setOnClickListener(this.onClickListener);
        }
        return viewHolderOnCreateDefaultViewHolder;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
