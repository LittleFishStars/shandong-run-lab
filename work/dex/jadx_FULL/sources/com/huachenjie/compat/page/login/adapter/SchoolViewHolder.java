package com.huachenjie.compat.page.login.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.BaseRequestOptions;
import com.huachenjie.common.base.BaseViewHolder;
import com.huachenjie.common.bean.SchoolInfo;
import com.huachenjie.compat.R;
import com.zj.adlib.ju3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class SchoolViewHolder extends BaseViewHolder<SchoolInfo> {
    public final TextView e;
    public final ImageView f;

    public SchoolViewHolder(View view) {
        super(view);
        this.e = (TextView) findViewById(R.id.tv_school_name);
        this.f = (ImageView) findViewById(R.id.img_school_badge);
    }

    @Override // com.huachenjie.common.base.BaseViewHolder
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public void a(Context context, SchoolInfo schoolInfo) {
        Glide.with(context).load(TextUtils.isEmpty(schoolInfo.getSchoolLogo()) ? "" : schoolInfo.getSchoolLogo()).apply((BaseRequestOptions<?>) ju3.e).into(this.f);
        this.e.setText(TextUtils.isEmpty(schoolInfo.getSchoolName()) ? "" : schoolInfo.getSchoolName());
    }
}
