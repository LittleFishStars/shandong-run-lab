package com.zj.adlib;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.DownloadProgressView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.ipd.dsp.internal.b1.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class i1b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f42256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f17115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f17116a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f17117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DownloadProgressView f17118a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OfflineMapCity f17119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OfflineMapManager f17120a;
    public TextView b;
    public TextView c;
    public int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17121a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f17114a = new a();

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                i1b.this.c(message.arg1, message.arg2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public i1b(Context context, OfflineMapManager offlineMapManager) {
        this.f42256a = context;
        f();
        this.f17120a = offlineMapManager;
    }

    public final View a() {
        return this.f17115a;
    }

    public final void b(int i) {
        this.K = i;
    }

    public final void c(int i, int i2) throws Exception {
        if (this.K != 2 || i2 <= 3 || i2 >= 100) {
            this.f17118a.setVisibility(8);
        } else {
            this.f17118a.setVisibility(0);
            this.f17118a.setProgress(i2);
        }
        if (i == -1) {
            k();
            return;
        }
        if (i == 0) {
            if (this.K != 1) {
                o();
                return;
            }
            this.f17116a.setVisibility(8);
            this.c.setText(b.a.m);
            this.c.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        if (i == 1) {
            n();
            return;
        }
        if (i == 2) {
            j();
            return;
        }
        if (i == 3) {
            l();
            return;
        }
        if (i == 4) {
            m();
            return;
        }
        if (i == 6) {
            h();
        } else {
            if (i == 7) {
                i();
                return;
            }
            switch (i) {
                case 101:
                case 102:
                case 103:
                    k();
                    break;
            }
        }
    }

    public final void d(OfflineMapCity offlineMapCity) {
        if (offlineMapCity != null) {
            this.f17119a = offlineMapCity;
            this.f17117a.setText(offlineMapCity.getCity());
            double size = ((double) ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d;
            this.b.setText(String.valueOf(size) + " M");
            g(this.f17119a.getState(), this.f17119a.getcompleteCode());
        }
    }

    public final void f() {
        View viewD = q1b.d(this.f42256a, 2130903042);
        this.f17115a = viewD;
        this.f17118a = (DownloadProgressView) viewD.findViewById(2131165200);
        this.f17117a = (TextView) this.f17115a.findViewById(2131165195);
        this.b = (TextView) this.f17115a.findViewById(2131165199);
        this.f17116a = (ImageView) this.f17115a.findViewById(2131165198);
        this.c = (TextView) this.f17115a.findViewById(2131165197);
        this.f17116a.setOnClickListener(this);
    }

    public final void g(int i, int i2) {
        OfflineMapCity offlineMapCity = this.f17119a;
        if (offlineMapCity != null) {
            offlineMapCity.setState(i);
            this.f17119a.setCompleteCode(i2);
        }
        Message message = new Message();
        message.arg1 = i;
        message.arg2 = i2;
        this.f17114a.sendMessage(message);
    }

    public final void h() {
        this.c.setVisibility(8);
        this.f17116a.setVisibility(0);
        this.f17116a.setImageResource(2130837506);
    }

    public final void i() {
        this.c.setVisibility(0);
        this.f17116a.setVisibility(0);
        this.f17116a.setImageResource(2130837506);
        this.c.setText("已下载-有更新");
    }

    public final void j() {
        if (this.K == 1) {
            this.f17116a.setVisibility(8);
            this.c.setVisibility(0);
            this.c.setText("等待中");
            this.c.setTextColor(Color.parseColor("#4287ff"));
            return;
        }
        this.c.setVisibility(0);
        this.f17116a.setVisibility(8);
        this.c.setTextColor(Color.parseColor("#4287ff"));
        this.c.setText("等待中");
    }

    public final void k() {
        this.c.setVisibility(0);
        this.f17116a.setVisibility(8);
        this.c.setTextColor(-65536);
        this.c.setText("下载出现异常");
    }

    public final void l() {
        this.c.setVisibility(0);
        this.f17116a.setVisibility(8);
        this.c.setTextColor(-7829368);
        this.c.setText("暂停");
    }

    public final void m() {
        this.c.setVisibility(0);
        this.f17116a.setVisibility(8);
        this.c.setText("已下载");
        this.c.setTextColor(Color.parseColor("#898989"));
    }

    public final void n() {
        if (this.K == 1) {
            return;
        }
        this.c.setVisibility(0);
        this.f17116a.setVisibility(8);
        this.c.setText("解压中");
        this.c.setTextColor(Color.parseColor("#898989"));
    }

    public final void o() {
        if (this.f17119a == null) {
            return;
        }
        this.c.setVisibility(0);
        this.c.setText(b.a.m);
        this.f17116a.setVisibility(8);
        this.c.setTextColor(Color.parseColor("#4287ff"));
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!zwa.h0(this.f42256a)) {
                Toast.makeText(this.f42256a, "无网络连接", 0).show();
                return;
            }
            OfflineMapCity offlineMapCity = this.f17119a;
            if (offlineMapCity != null) {
                int state = offlineMapCity.getState();
                this.f17119a.getcompleteCode();
                if (state == 0) {
                    p();
                    l();
                } else {
                    if (state == 1 || state == 4) {
                        return;
                    }
                    if (q()) {
                        j();
                    } else {
                        k();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void p() {
        this.f17120a.pause();
        this.f17120a.restart();
    }

    public final synchronized boolean q() {
        try {
            this.f17120a.downloadByCityName(this.f17119a.getCity());
        } catch (AMapException e) {
            e.printStackTrace();
            Toast.makeText(this.f42256a, e.getErrorMessage(), 0).show();
            return false;
        }
        return true;
    }
}
