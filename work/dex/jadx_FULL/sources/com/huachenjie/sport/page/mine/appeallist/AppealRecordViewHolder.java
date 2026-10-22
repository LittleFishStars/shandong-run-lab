package com.huachenjie.sport.page.mine.appeallist;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huachenjie.common.base.BaseViewHolder;
import com.huachenjie.common.bean.DailySunshineRecord;
import com.huachenjie.common.bean.SportRecord;
import com.huachenjie.common.widget.SunshineRecordView;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class AppealRecordViewHolder extends BaseViewHolder<DailySunshineRecord> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f36577a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RecordClickListener f13719a;
    public final TextView e;

    public interface RecordClickListener {
        void a(SportRecord sportRecord);
    }

    public AppealRecordViewHolder(View view) {
        super(view);
        this.e = (TextView) findViewById(R.id.tv_date);
        this.f36577a = (LinearLayout) findViewById(R.id.ll_record_list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        RecordClickListener recordClickListener;
        SportRecord sportRecord = (SportRecord) view.getTag();
        if (sportRecord == null || TextUtils.isEmpty(sportRecord.getRunRecordCode()) || (recordClickListener = this.f13719a) == null) {
            return;
        }
        recordClickListener.a(sportRecord);
    }

    @Override // com.huachenjie.common.base.BaseViewHolder
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public void a(Context context, DailySunshineRecord dailySunshineRecord) {
        this.e.setText(dailySunshineRecord.getMonthDate());
        this.f36577a.removeAllViews();
        for (SportRecord sportRecord : dailySunshineRecord.getList()) {
            SunshineRecordView sunshineRecordView = new SunshineRecordView(context);
            sunshineRecordView.setShowAppealSucceedMark(true);
            sunshineRecordView.bindData(sportRecord);
            sunshineRecordView.setTag(sportRecord);
            sunshineRecordView.setOnClickListener(new View.OnClickListener() { // from class: com.zj.adlib.ka0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f42771a.k(view);
                }
            });
            this.f36577a.addView(sunshineRecordView);
        }
    }

    public void l(RecordClickListener recordClickListener) {
        this.f13719a = recordClickListener;
    }
}
