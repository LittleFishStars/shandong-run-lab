package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.ipd.dsp.internal.b1.b;
import com.zj.adlib.q1b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class eq extends er implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private OfflineMapManager f25933a;
    private View b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private String h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            eq.this.dismiss();
        }
    }

    public eq(Context context, OfflineMapManager offlineMapManager) {
        super(context);
        this.f25933a = offlineMapManager;
    }

    @Override // com.amap.api.col.p0003l.er
    public final void a() {
        View viewD = q1b.d(getContext(), 2130903041);
        this.b = viewD;
        setContentView(viewD);
        this.b.setOnClickListener(new a());
        this.c = (TextView) this.b.findViewById(2131165191);
        TextView textView = (TextView) this.b.findViewById(2131165192);
        this.d = textView;
        textView.setText("暂停下载");
        this.e = (TextView) this.b.findViewById(2131165193);
        this.f = (TextView) this.b.findViewById(2131165194);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            int id = view.getId();
            if (id != 2131165192) {
                if (id != 2131165193) {
                    if (id == 2131165194) {
                        dismiss();
                        return;
                    }
                    return;
                } else {
                    if (TextUtils.isEmpty(this.h)) {
                        return;
                    }
                    this.f25933a.remove(this.h);
                    dismiss();
                    return;
                }
            }
            int i = this.g;
            if (i == 0) {
                this.d.setText(b.a.n);
                this.f25933a.pauseByName(this.h);
            } else if (i == 3 || i == -1 || i == 101 || i == 102 || i == 103) {
                this.d.setText("暂停下载");
                this.f25933a.downloadByCityName(this.h);
            }
            dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(int i, String str) {
        this.c.setText(str);
        if (i == 0) {
            this.d.setText("暂停下载");
            this.d.setVisibility(0);
            this.e.setText("取消下载");
        }
        if (i == 2) {
            this.d.setVisibility(8);
            this.e.setText("取消下载");
        } else if (i == -1 || i == 101 || i == 102 || i == 103) {
            this.d.setText(b.a.n);
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.d.setVisibility(0);
            this.d.setText(b.a.n);
            this.e.setText("取消下载");
        } else if (i == 4) {
            this.e.setText("删除");
            this.d.setVisibility(8);
        }
        this.g = i;
        this.h = str;
    }
}
