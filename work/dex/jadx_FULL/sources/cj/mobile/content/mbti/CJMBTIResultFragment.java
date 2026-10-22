package cj.mobile.content.mbti;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cj.mobile.CJNativeExpress;
import cj.mobile.listener.CJNativeExpressListener;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJMBTIResultFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22145a;
    public Activity b;
    public String c;
    public String d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public LinearLayout i;
    public FrameLayout j;
    public cj.mobile.l.b k;
    public CJNativeExpress l;
    public Handler m;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIResultFragment f22146a;

        public a(CJMBTIResultFragment cJMBTIResultFragment) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }
    }

    public class b implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIResultFragment f22147a;

        public b(CJMBTIResultFragment cJMBTIResultFragment) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIResultFragment f22148a;

        public c(CJMBTIResultFragment cJMBTIResultFragment, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public class d implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIResultFragment f22149a;

        public d(CJMBTIResultFragment cJMBTIResultFragment) {
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

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
    }

    public void b() {
    }

    public CJMBTIResultFragment a(Activity activity, String str, String str2) {
    }

    public void a(View view) {
    }

    public final void a() {
    }

    public final void a(String str) {
    }
}
