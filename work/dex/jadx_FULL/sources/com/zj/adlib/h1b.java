package com.zj.adlib;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapActivity;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class h1b extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f42029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OfflineMapManager f16911a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<OfflineMapCity> f16912a = new ArrayList();

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfflineMapCity f42030a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f16913a;

        public a(b bVar, OfflineMapCity offlineMapCity) {
            this.f16913a = bVar;
            this.f42030a = offlineMapCity;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f16913a.f42031a.setVisibility(8);
            this.f16913a.c.setVisibility(0);
            this.f16913a.c.setText(com.ipd.dsp.internal.b1.b.a.m);
            try {
                h1b.this.f16911a.downloadByCityName(this.f42030a.getCity());
            } catch (AMapException e) {
                e.printStackTrace();
            }
        }
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f42031a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f16915a;
        public TextView b;
        public TextView c;

        public b() {
        }
    }

    public h1b(OfflineMapManager offlineMapManager, OfflineMapActivity offlineMapActivity) {
        this.f16911a = offlineMapManager;
        this.f42029a = offlineMapActivity;
    }

    public final void b(List<OfflineMapCity> list) {
        this.f16912a = list;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f16912a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return this.f16912a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00ed A[Catch: Exception -> 0x00fa, TRY_LEAVE, TryCatch #0 {Exception -> 0x00fa, blocks: (B:2:0x0000, B:4:0x000a, B:6:0x004e, B:19:0x00aa, B:21:0x00ae, B:22:0x00b9, B:23:0x00c6, B:24:0x00d3, B:25:0x00e0, B:26:0x00ed, B:5:0x0048), top: B:31:0x0000 }] */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        try {
            OfflineMapCity offlineMapCity = this.f16912a.get(i);
            if (view == null) {
                bVar = new b();
                view = q1b.d(this.f42029a, 2130903042);
                bVar.f16915a = (TextView) view.findViewById(2131165195);
                bVar.b = (TextView) view.findViewById(2131165199);
                bVar.c = (TextView) view.findViewById(2131165197);
                bVar.f42031a = (ImageView) view.findViewById(2131165198);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.f42031a.setOnClickListener(new a(bVar, offlineMapCity));
            bVar.c.setVisibility(0);
            bVar.f16915a.setText(offlineMapCity.getCity());
            double size = ((double) ((int) (((offlineMapCity.getSize() / 1024.0d) / 1024.0d) * 100.0d))) / 100.0d;
            bVar.b.setText(String.valueOf(size) + " M");
            int state = offlineMapCity.getState();
            if (state == -1) {
                bVar.f42031a.setVisibility(8);
                bVar.c.setText("下载失败");
            } else if (state == 0 || state == 1) {
                bVar.f42031a.setVisibility(8);
                bVar.c.setText(com.ipd.dsp.internal.b1.b.a.m);
            } else if (state == 2) {
                bVar.f42031a.setVisibility(8);
                bVar.c.setText("等待下载");
            } else if (state == 3) {
                bVar.f42031a.setVisibility(8);
                bVar.c.setText("暂停中");
            } else if (state == 4) {
                bVar.f42031a.setVisibility(8);
                bVar.c.setText("已下载");
            } else if (state != 6) {
                switch (state) {
                    case 101:
                    case 102:
                    case 103:
                        bVar.f42031a.setVisibility(8);
                        bVar.c.setText("下载失败");
                        break;
                    default:
                        break;
                }
            } else {
                bVar.f42031a.setVisibility(0);
                bVar.c.setVisibility(8);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
