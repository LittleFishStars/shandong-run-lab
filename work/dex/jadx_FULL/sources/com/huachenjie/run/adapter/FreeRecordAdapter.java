package com.huachenjie.run.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.BaseRecyclerAdapter;
import com.huachenjie.common.bean.DailySunshineRecord;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class FreeRecordAdapter extends BaseRecyclerAdapter<DailySunshineRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FreeRecordViewHolder.RecordClickListener f35429a;

    public FreeRecordAdapter(Context context) {
        super(context);
    }

    @Override // com.huachenjie.common.base.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        if (viewHolder instanceof FreeRecordViewHolder) {
            FreeRecordViewHolder freeRecordViewHolder = (FreeRecordViewHolder) viewHolder;
            freeRecordViewHolder.a(this.d, i(getRealPosition(position)));
            freeRecordViewHolder.k(this.f35429a);
        }
    }

    @Override // com.huachenjie.common.base.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return -2147483645 == viewType ? new FreeRecordViewHolder(LayoutInflater.from(this.d).inflate(R.layout.item_sunshine_run_record, parent, false)) : super.onCreateViewHolder(parent, viewType);
    }

    public void y(FreeRecordViewHolder.RecordClickListener listener) {
        this.f35429a = listener;
    }
}
