package cj.mobile.content.news;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import cj.mobile.CJNativeExpress;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJNativeExpressListener;
import java.io.IOException;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class NewsTypeFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22167a;
    public String b;
    public String c;
    public cj.mobile.m.b d;
    public RecyclerView e;
    public ImageView f;
    public NewsRecycerAdapter g;
    public int h;
    public List<cj.mobile.m.a> i;
    public int j;
    public LoadingDialog k;
    public int l;
    public CJNativeExpress m;
    public int n;
    public Handler o;

    public class a implements cj.mobile.m.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeFragment f22168a;

        public a(NewsTypeFragment newsTypeFragment) {
        }

        @Override // cj.mobile.m.b
        public void a() {
        }

        @Override // cj.mobile.m.b
        public void a(cj.mobile.m.a aVar) {
        }

        @Override // cj.mobile.m.b
        public void a(int i) {
        }
    }

    public class b extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeFragment f22169a;

        public b(NewsTypeFragment newsTypeFragment) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeFragment f22170a;

        public c(NewsTypeFragment newsTypeFragment) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class d implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeFragment f22171a;

        public d(NewsTypeFragment newsTypeFragment) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeFragment f22172a;

        public e(NewsTypeFragment newsTypeFragment, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public class f implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NewsTypeFragment f22173a;

        public f(NewsTypeFragment newsTypeFragment) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void loadSuccess(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClick(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onClose(View view) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJNativeExpressListener
        public void onShow(View view) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
    }

    public NewsTypeFragment a(Activity activity, String str, String str2, cj.mobile.m.b bVar) {
    }

    public void a(View view) {
    }

    public final void a(RecyclerView recyclerView) {
    }

    public void a(int i) {
    }

    public final void a(JSONArray jSONArray) {
    }

    public final boolean a(String str) {
    }

    public final void a() {
    }
}
