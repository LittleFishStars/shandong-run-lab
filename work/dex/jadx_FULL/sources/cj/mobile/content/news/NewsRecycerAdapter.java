package cj.mobile.content.news;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class NewsRecycerAdapter extends RecyclerView.Adapter<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<cj.mobile.m.a> f22159a;
    public Context b;
    public cj.mobile.m.b c;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f22160a;
        public final /* synthetic */ NewsRecycerAdapter b;

        public a(NewsRecycerAdapter newsRecycerAdapter, c cVar) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22161a;
        public final /* synthetic */ NewsRecycerAdapter b;

        public b(NewsRecycerAdapter newsRecycerAdapter, int i) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public FrameLayout f22162a;
        public FrameLayout b;

        public c(@NonNull NewsRecycerAdapter newsRecycerAdapter, View view) {
        }
    }

    public NewsRecycerAdapter(Context context, List<cj.mobile.m.a> list, cj.mobile.m.b bVar) {
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

    public final View a(int i) {
    }
}
