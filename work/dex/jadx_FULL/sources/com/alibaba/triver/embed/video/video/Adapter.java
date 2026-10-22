package com.alibaba.triver.embed.video.video;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.triver.embed.video.R;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class Adapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f24878a;
    private List<d> b;
    private String d;
    private int c = -1;
    private float e = 0.0f;

    public class a extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f24879a;

        public a(View view) {
            super(view);
            this.f24879a = (ImageView) view.findViewById(R.id.trv_img);
        }
    }

    public Adapter(Context context, List<d> list) {
        this.f24878a = context;
        this.b = list;
    }

    public float a() {
        return this.e;
    }

    public List<d> b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<d> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void a(float f) {
        this.e = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.f24878a).inflate(R.layout.triver_item_per_image, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        if (this.c > 0) {
            ViewGroup.LayoutParams layoutParams = aVar.f24879a.getLayoutParams();
            layoutParams.width = this.c;
            aVar.f24879a.setLayoutParams(layoutParams);
        }
        System.out.println("---------->dataList.size: " + this.b.size());
        aVar.f24879a.setImageURI(Uri.parse(this.d + this.b.get(i).b()));
    }

    public void a(List<d> list) {
        this.b = list;
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(int i) {
        this.c = i;
    }
}
