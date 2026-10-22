package cj.mobile.content.news;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJNewsActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22150a;
    public RecyclerView b;
    public TextView c;
    public TextView d;
    public NewsTypeAdapter e;
    public ArrayList<NewsTypeFragment> f;
    public List<String> g;
    public List<String> h;
    public String i;
    public String j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public boolean o;
    public Map<String, String> p;
    public Handler q;
    public cj.mobile.m.b r;

    public class a implements cj.mobile.m.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNewsActivity f22151a;

        public a(CJNewsActivity cJNewsActivity) {
        }

        @Override // cj.mobile.m.c
        public void a(int i) {
        }
    }

    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNewsActivity f22152a;

        public b(CJNewsActivity cJNewsActivity, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public void back(View view) {
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    public final void a() {
    }

    public final void b() {
    }

    public class c implements cj.mobile.m.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJNewsActivity f22153a;

        public c(CJNewsActivity cJNewsActivity) {
        }

        @Override // cj.mobile.m.b
        public void a(int i) {
        }

        @Override // cj.mobile.m.b
        public void a(cj.mobile.m.a aVar) {
        }

        @Override // cj.mobile.m.b
        public void a() {
        }
    }

    public void a(int i) {
    }
}
