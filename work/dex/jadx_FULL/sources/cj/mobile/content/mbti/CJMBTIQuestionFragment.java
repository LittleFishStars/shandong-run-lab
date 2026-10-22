package cj.mobile.content.mbti;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cj.mobile.CJNativeExpress;
import cj.mobile.listener.CJNativeExpressListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJMBTIQuestionFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22141a;
    public TextView b;
    public RadioGroup c;
    public RadioButton d;
    public RadioButton e;
    public FrameLayout f;
    public Activity g;
    public cj.mobile.l.a h;
    public cj.mobile.l.c i;
    public String j;
    public int k;
    public CJNativeExpress l;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIQuestionFragment f22142a;

        public a(CJMBTIQuestionFragment cJMBTIQuestionFragment) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
        }
    }

    public class b implements CJNativeExpressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIQuestionFragment f22143a;

        public b(CJMBTIQuestionFragment cJMBTIQuestionFragment) {
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

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIQuestionFragment f22144a;

        public c(CJMBTIQuestionFragment cJMBTIQuestionFragment) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
    }

    public CJMBTIQuestionFragment a(Activity activity, String str, cj.mobile.l.a aVar, int i, cj.mobile.l.c cVar) {
    }

    public void a() {
    }

    public void a(View view) {
    }
}
