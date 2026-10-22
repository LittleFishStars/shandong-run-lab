package com.huachenjie.compat.page.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.huachenjie.common.base.BaseRecyclerAdapter;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.compat.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class SchoolAdapter extends BaseRecyclerAdapter<SchoolInfo> {
    public SchoolAdapter(Context context) {
        super(context);
    }

    @Override // com.huachenjie.common.base.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        if (viewHolder instanceof SchoolViewHolder) {
            ((SchoolViewHolder) viewHolder).a(this.d, i(getRealPosition(i)));
        }
    }

    @Override // com.huachenjie.common.base.BaseRecyclerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return -2147483645 == i ? new SchoolViewHolder(LayoutInflater.from(this.d).inflate(R.layout.item_school, viewGroup, false)) : super.onCreateViewHolder(viewGroup, i);
    }
}
