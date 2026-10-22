package com.alibaba.triver.open.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.alibaba.alibctriver.R;
import com.alibaba.triver.kit.api.widget.Action;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f25095a;

    @Override // com.alibaba.triver.kit.api.widget.Action
    public View getView(Context context) {
        if (this.f25095a == null) {
            this.f25095a = View.inflate(context, R.layout.triver_loading_view, null);
            this.f25095a.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            this.f25095a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.open.widget.f.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
        return this.f25095a;
    }
}
