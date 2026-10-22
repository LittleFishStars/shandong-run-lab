package com.huachenjie.run.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.base.BaseViewHolder;
import com.huachenjie.common.bean.DailySunshineRecord;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.widget.SunshineRecordView;
import com.huachenjie.run.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class FreeRecordViewHolder extends BaseViewHolder<DailySunshineRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f35431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecordClickListener f11393a;
    public TextView e;

    public interface RecordClickListener {
        void a(SportRecord sportRecord);
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            SportRecord sportRecord = (SportRecord) v.getTag();
            if (sportRecord == null || TextUtils.isEmpty(sportRecord.getRunRecordCode()) || FreeRecordViewHolder.this.f11393a == null) {
                return;
            }
            FreeRecordViewHolder.this.f11393a.a(sportRecord);
        }
    }

    public FreeRecordViewHolder(View itemView) {
        super(itemView);
        this.e = (TextView) findViewById(R.id.tv_date);
        this.f35431a = (LinearLayout) findViewById(R.id.ll_record_list);
        int iB = SizeUtils.b(35.0f);
        this.e.setPadding(iB, 0, iB, 0);
        this.f35431a.setPadding(iB, 0, iB, 0);
    }

    @Override // com.huachenjie.common.base.BaseViewHolder
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(Context context, DailySunshineRecord data) {
        this.e.setText(data.getMonthDate());
        this.f35431a.removeAllViews();
        for (SportRecord sportRecord : data.getList()) {
            SunshineRecordView sunshineRecordView = new SunshineRecordView(context);
            sunshineRecordView.bindData(sportRecord);
            sunshineRecordView.setTag(sportRecord);
            sunshineRecordView.setOnClickListener(new a());
            this.f35431a.addView(sunshineRecordView);
        }
    }

    public void k(RecordClickListener listener) {
        this.f11393a = listener;
    }
}
