package com.huachenjie.sport.page.mine.appeallist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.BaseRecyclerAdapter;
import com.huachenjie.common.bean.DailySunshineRecord;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AppealRecordAdapter extends BaseRecyclerAdapter<DailySunshineRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppealRecordViewHolder.RecordClickListener f36576a;

    public AppealRecordAdapter(Context context) {
        super(context);
    }

    @Override // com.huachenjie.common.base.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        if (viewHolder instanceof AppealRecordViewHolder) {
            AppealRecordViewHolder appealRecordViewHolder = (AppealRecordViewHolder) viewHolder;
            appealRecordViewHolder.a(this.d, i(getRealPosition(i)));
            appealRecordViewHolder.l(this.f36576a);
        }
    }

    @Override // com.huachenjie.common.base.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return -2147483645 == i ? new AppealRecordViewHolder(LayoutInflater.from(this.d).inflate(R.layout.item_sunshine_run_record, viewGroup, false)) : super.onCreateViewHolder(viewGroup, i);
    }

    public void y(AppealRecordViewHolder.RecordClickListener recordClickListener) {
        this.f36576a = recordClickListener;
    }
}
