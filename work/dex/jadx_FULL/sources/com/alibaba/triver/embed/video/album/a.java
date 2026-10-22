package com.alibaba.triver.embed.video.album;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.triver.embed.video.R;
import com.zj.adlib.u15;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<VideoInfo> f24831a;
    private Context b;

    /* JADX INFO: renamed from: com.alibaba.triver.embed.video.album.a$a, reason: collision with other inner class name */
    public static class C0162a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ImageView f24832a;
        TextView b;
    }

    public a(Context context, List<VideoInfo> list) {
        this.b = context;
        this.f24831a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f24831a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f24831a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0162a c0162a;
        Object objValueOf;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.triver_gridview_item, (ViewGroup) null);
            c0162a = new C0162a();
            c0162a.f24832a = (ImageView) view.findViewById(R.id.trv_img);
            c0162a.b = (TextView) view.findViewById(R.id.trv_text);
            view.setTag(c0162a);
        } else {
            c0162a = (C0162a) view.getTag();
        }
        try {
            c0162a.f24832a.setImageBitmap(this.f24831a.get(i).frame);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            long minutes = timeUnit.toMinutes(Long.parseLong(this.f24831a.get(i).duration + "") / 1000);
            long seconds = timeUnit.toSeconds(Long.parseLong(this.f24831a.get(i).duration + "") / 1000) - TimeUnit.MINUTES.toSeconds(minutes);
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%2d", Long.valueOf(minutes)));
            sb.append(u15.f19942b);
            if (seconds < 10) {
                objValueOf = "0" + seconds;
            } else {
                objValueOf = Long.valueOf(seconds);
            }
            sb.append(objValueOf);
            c0162a.b.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return view;
    }
}
