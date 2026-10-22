package cj.mobile.content.shortvideo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import cj.mobile.listener.CJShortVideoListener;
import cj.mobile.listener.CJVideoFlowListener;
import cj.mobile.q.f;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class ShortVideoFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f22180a;
    public VideoAdapter b;
    public f c;
    public List<cj.mobile.o.b> d;
    public int e;
    public String f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public String k;
    public int l;
    public CJShortVideoListener m;
    public cj.mobile.o.c n;
    public Handler o;

    public class a implements cj.mobile.o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortVideoFragment f22181a;

        public a(ShortVideoFragment shortVideoFragment) {
        }

        @Override // cj.mobile.o.a
        public void a(boolean z, View view) {
        }

        @Override // cj.mobile.o.a
        public void b(boolean z, View view) {
        }
    }

    public class c implements CJVideoFlowListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f22183a;
        public final /* synthetic */ ShortVideoFragment b;

        public c(ShortVideoFragment shortVideoFragment, int i) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onClick(View view) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onLoad(View view) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onShow(View view) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onVideoCompleted(View view) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onVideoPaused(View view) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onVideoResume(View view) {
        }

        @Override // cj.mobile.listener.CJVideoFlowListener
        public void onVideoStart(View view) {
        }
    }

    public class d implements cj.mobile.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortVideoFragment f22184a;

        public d(ShortVideoFragment shortVideoFragment) {
        }

        @Override // cj.mobile.o.c
        public void a(int i, boolean z) {
        }

        @Override // cj.mobile.o.c
        public void b(int i, boolean z) {
        }

        @Override // cj.mobile.o.c
        public void c(int i, boolean z) {
        }

        @Override // cj.mobile.o.c
        public void d(int i, boolean z) {
        }
    }

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortVideoFragment f22185a;

        public e(ShortVideoFragment shortVideoFragment, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public static /* synthetic */ int j(ShortVideoFragment shortVideoFragment) {
    }

    public ShortVideoFragment a(Activity activity) {
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
    }

    public class b implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShortVideoFragment f22182a;

        public b(ShortVideoFragment shortVideoFragment) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public ShortVideoFragment a(String str) {
        this.k = str;
        return this;
    }

    public ShortVideoFragment a(CJShortVideoListener cJShortVideoListener) {
        this.m = cJShortVideoListener;
        return this;
    }

    public final void a(View view) {
    }

    public final void a() {
    }

    public final void a(int i) {
    }
}
