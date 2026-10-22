package cj.mobile.content.news;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class NewsTypeAdapter extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f22163a;
    public Context b;
    public int c;
    public cj.mobile.m.c d;
    public Handler e;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22164a;
        public final /* synthetic */ NewsTypeAdapter b;

        public a(NewsTypeAdapter newsTypeAdapter, int i) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeAdapter f22165a;

        public b(NewsTypeAdapter newsTypeAdapter) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TextView f22166a;

        public c(@NonNull NewsTypeAdapter newsTypeAdapter, View view) {
        }
    }

    public NewsTypeAdapter(Context context, List<String> list, cj.mobile.m.c cVar) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
    }

    public void a(@NonNull c cVar, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public c onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    }

    public void a(int i) {
    }

    public void a() {
    }
}
