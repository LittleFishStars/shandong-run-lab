package com.androidquery;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.androidquery.AbstractAQuery;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.Transformer;
import com.androidquery.util.Constants;
import com.zj.adlib.b30;
import com.zj.adlib.gq;
import com.zj.adlib.l74;
import com.zj.adlib.ou9;
import com.zj.adlib.vp1;
import com.zj.adlib.xv0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class AbstractAQuery<T extends AbstractAQuery<T>> implements Constants {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WeakHashMap<Dialog, Void> f26161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?>[] f1148a = {View.class};
    public static Class<?>[] b;
    public static Class<?>[] c;
    public static final Class<?>[] d;
    public static Class<?>[] e;
    public static final Class<?>[] f;
    public static Class<?>[] g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f1149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AccountHandle f1152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Transformer f1153a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer f1154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f1155a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Constructor<T> f1156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HttpHost f1157a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f1158b;

    static {
        Class<?> cls = Integer.TYPE;
        b = new Class[]{AdapterView.class, View.class, cls, Long.TYPE};
        c = new Class[]{AbsListView.class, cls};
        d = new Class[]{CharSequence.class, cls, cls, cls};
        e = new Class[]{cls, cls};
        f = new Class[]{cls};
        g = new Class[]{cls, Paint.class};
        f26161a = new WeakHashMap<>();
    }

    public AbstractAQuery(Activity activity) {
        this.f1149a = activity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T A(String str, File file, b30<File> b30Var) {
        ((b30) b30Var.G0(str)).E0(File.class).A0(file);
        return (T) c(b30Var);
    }

    public T A0(String str, boolean z, boolean z2) {
        return (T) B0(str, z, z2, 0, 0);
    }

    public T A1(Object obj, String str) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).addTextChangedListener(new vp1().c(obj, str, true, d));
        }
        return (T) g1();
    }

    public T B(String str, File file, Object obj, String str2) {
        b30<File> b30Var = new b30<>();
        b30Var.I0(obj, str2);
        return (T) A(str, file, b30Var);
    }

    public T B0(String str, boolean z, boolean z2, int i, int i2) {
        return (T) C0(str, z, z2, i, i2, null, 0);
    }

    public T B1(int i) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(i);
        }
        return (T) g1();
    }

    public T C(boolean z) {
        View view = this.f1158b;
        if (view != null) {
            view.setEnabled(z);
        }
        return (T) g1();
    }

    public T C0(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3) {
        return (T) D0(str, z, z2, i, i2, bitmap, i3, 0.0f);
    }

    public T C1(float f2) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(f2);
        }
        return (T) g1();
    }

    public T D(int i, boolean z) {
        View view = this.f1158b;
        if (view instanceof ExpandableListView) {
            ExpandableListView expandableListView = (ExpandableListView) view;
            if (z) {
                expandableListView.expandGroup(i);
            } else {
                expandableListView.collapseGroup(i);
            }
        }
        return (T) g1();
    }

    public T D0(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f2) {
        return (T) image(str, z, z2, i, i2, bitmap, i3, f2, 0, null);
    }

    public T D1(Transformer transformer) {
        this.f1153a = transformer;
        return (T) g1();
    }

    public T E(boolean z) {
        ExpandableListView expandableListView;
        ExpandableListAdapter expandableListAdapter;
        View view = this.f1158b;
        if ((view instanceof ExpandableListView) && (expandableListAdapter = (expandableListView = (ExpandableListView) view).getExpandableListAdapter()) != null) {
            int groupCount = expandableListAdapter.getGroupCount();
            for (int i = 0; i < groupCount; i++) {
                if (z) {
                    expandableListView.expandGroup(i);
                } else {
                    expandableListView.collapseGroup(i);
                }
            }
        }
        return (T) g1();
    }

    public T E0(String str, boolean z, boolean z2, int i, int i2, xv0 xv0Var) {
        xv0Var.J1(i).a1(i2).G0(str).b0(z).z(z2);
        return (T) v0(xv0Var);
    }

    public T E1(boolean z) {
        View view = this.f1158b;
        if (view != null) {
            gq.c0(view, z);
        }
        return (T) g1();
    }

    public T F(int i) {
        return (T) create(G(i));
    }

    public View F0(View view, int i, ViewGroup viewGroup) {
        Integer num;
        if (view != null && (num = (Integer) view.getTag(Constants.w)) != null && num.intValue() == i) {
            return view;
        }
        Activity activity = this.f1149a;
        View viewInflate = (activity != null ? activity.getLayoutInflater() : (LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(i, viewGroup, false);
        viewInflate.setTag(Constants.w, Integer.valueOf(i));
        return viewInflate;
    }

    public T F1(Typeface typeface) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).setTypeface(typeface);
        }
        return (T) g1();
    }

    public final View G(int i) {
        View view = this.f1151a;
        if (view != null) {
            return view.findViewById(i);
        }
        Activity activity = this.f1149a;
        if (activity != null) {
            return activity.findViewById(i);
        }
        return null;
    }

    public T G0(String str) {
        File fileK = K(str);
        if (fileK != null) {
            fileK.delete();
        }
        return (T) g1();
    }

    public T G1(int i) {
        View view = this.f1158b;
        if (view != null && view.getVisibility() != i) {
            this.f1158b.setVisibility(i);
        }
        return (T) g1();
    }

    public final View H(String str) {
        View childAt;
        View view = this.f1151a;
        if (view != null) {
            return view.findViewWithTag(str);
        }
        Activity activity = this.f1149a;
        if (activity == null || (childAt = ((ViewGroup) activity.findViewById(R.id.content)).getChildAt(0)) == null) {
            return null;
        }
        return childAt.findViewWithTag(str);
    }

    public T H0() {
        return (T) G1(4);
    }

    public T H1() {
        return (T) G1(0);
    }

    public final View I(int... iArr) {
        View viewG = G(iArr[0]);
        for (int i = 1; i < iArr.length && viewG != null; i++) {
            viewG = viewG.findViewById(iArr[i]);
        }
        return viewG;
    }

    public Object I0(String str, Class<?>[] clsArr, Object... objArr) {
        Object obj = this.f1158b;
        if (obj == null) {
            obj = this.f1149a;
        }
        return gq.B(obj, str, false, false, clsArr, objArr);
    }

    public T I1(String str) {
        return (T) J1(str, true, false, -16777216);
    }

    public Button J() {
        return (Button) this.f1158b;
    }

    public boolean J0() {
        View view = this.f1158b;
        if (view instanceof CompoundButton) {
            return ((CompoundButton) view).isChecked();
        }
        return false;
    }

    public T J1(String str, boolean z, boolean z2, int i) {
        if (this.f1158b instanceof WebView) {
            h1(1, null);
            new ou9((WebView) this.f1158b, str, this.f1155a, z, z2, i).h();
            this.f1155a = null;
        }
        return (T) g1();
    }

    public File K(String str) {
        File fileT = gq.t(gq.q(getContext(), 1), str);
        return fileT == null ? gq.t(gq.q(getContext(), 0), str) : fileT;
    }

    public boolean K0() {
        return this.f1158b != null;
    }

    public T K1(int i) {
        r1(true, i, true);
        return (T) g1();
    }

    public Bitmap L(int i) {
        return xv0.i1(getContext(), i);
    }

    public T L0(AdapterView.OnItemClickListener onItemClickListener) {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            ((AdapterView) view).setOnItemClickListener(onItemClickListener);
        }
        return (T) g1();
    }

    public T L1(int i, boolean z) {
        r1(true, i, z);
        return (T) g1();
    }

    public Bitmap M(String str) {
        return N(str, 0);
    }

    public T M0(Object obj, String str) {
        return (T) L0(new vp1().c(obj, str, true, b));
    }

    public Bitmap N(String str, int i) {
        File fileK;
        Bitmap bitmapJ1 = xv0.j1(str, i);
        return (bitmapJ1 != null || (fileK = K(str)) == null) ? bitmapJ1 : xv0.k1(fileK.getAbsolutePath(), null, i, true, 0);
    }

    public T N0(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            ((AdapterView) view).setOnItemSelectedListener(onItemSelectedListener);
        }
        return (T) g1();
    }

    public CheckBox O() {
        return (CheckBox) this.f1158b;
    }

    public T O0(Object obj, String str) {
        return (T) N0(new vp1().c(obj, str, true, b));
    }

    public final Constructor<T> P() {
        if (this.f1156a == null) {
            try {
                this.f1156a = (Constructor<T>) getClass().getConstructor(View.class);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.f1156a;
    }

    public T P0() {
        View view = this.f1158b;
        if (view != null) {
            view.performLongClick();
        }
        return (T) g1();
    }

    public EditText Q() {
        return (EditText) this.f1158b;
    }

    public T Q0(View.OnLongClickListener onLongClickListener) {
        View view = this.f1158b;
        if (view != null) {
            view.setOnLongClickListener(onLongClickListener);
        }
        return (T) g1();
    }

    public Editable R() {
        View view = this.f1158b;
        if (view instanceof EditText) {
            return ((EditText) view).getEditableText();
        }
        return null;
    }

    public T R0(Object obj, String str) {
        return (T) Q0(new vp1().c(obj, str, true, f1148a));
    }

    public ExpandableListView S() {
        return (ExpandableListView) this.f1158b;
    }

    public File S0(String str, String str2) {
        File fileZ;
        File file = null;
        try {
            File fileK = K(str);
            if (fileK == null || (fileZ = gq.z()) == null) {
                return null;
            }
            File file2 = new File(fileZ, str2);
            try {
                file2.createNewFile();
                FileInputStream fileInputStream = new FileInputStream(fileK);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                FileChannel channel = fileInputStream.getChannel();
                FileChannel channel2 = fileOutputStream.getChannel();
                try {
                    channel.transferTo(0L, channel.size(), channel2);
                    return file2;
                } finally {
                    gq.f(fileInputStream);
                    gq.f(fileOutputStream);
                    gq.f(channel);
                    gq.f(channel2);
                }
            } catch (Exception e2) {
                e = e2;
                file = file2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        gq.k(e);
        return file;
    }

    public Gallery T() {
        return (Gallery) this.f1158b;
    }

    public T T0(float f2, float f3, float f4, float f5) {
        View view = this.f1158b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                Context context = getContext();
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(gq.n(context, f2), gq.n(context, f3), gq.n(context, f4), gq.n(context, f5));
                this.f1158b.setLayoutParams(layoutParams);
            }
        }
        return (T) g1();
    }

    public GridView U() {
        return (GridView) this.f1158b;
    }

    public T U0(int i, int i2) {
        Activity activity = this.f1149a;
        if (activity != null) {
            gq.B(activity, "overridePendingTransition", false, false, e, Integer.valueOf(i), Integer.valueOf(i2));
        }
        return (T) g1();
    }

    public ImageView V() {
        return (ImageView) this.f1158b;
    }

    public T V0(int i) {
        View view = this.f1158b;
        while (view != null) {
            if (view.getId() != i) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            }
            return (T) create(view);
        }
        view = null;
        return (T) create(view);
    }

    public ListView W() {
        return (ListView) this.f1158b;
    }

    public T W0(int i) {
        this.f1154a = Integer.valueOf(i);
        return (T) g1();
    }

    public ProgressBar X() {
        return (ProgressBar) this.f1158b;
    }

    public T X0(int i) {
        this.f1155a = G(i);
        return (T) g1();
    }

    public RatingBar Y() {
        return (RatingBar) this.f1158b;
    }

    public T Y0(Dialog dialog) {
        this.f1155a = dialog;
        return (T) g1();
    }

    public SeekBar Z() {
        return (SeekBar) this.f1158b;
    }

    public T Z0(Object obj) {
        this.f1155a = obj;
        return (T) g1();
    }

    public T a(Adapter adapter) {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            ((AdapterView) view).setAdapter(adapter);
        }
        return (T) g1();
    }

    public Object a0() {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            return ((AdapterView) view).getSelectedItem();
        }
        return null;
    }

    public T a1(String str, int i) {
        this.f1157a = new HttpHost(str, i);
        return (T) g1();
    }

    public T b(ExpandableListAdapter expandableListAdapter) {
        View view = this.f1158b;
        if (view instanceof ExpandableListView) {
            ((ExpandableListView) view).setAdapter(expandableListAdapter);
        }
        return (T) g1();
    }

    public int b0() {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            return ((AdapterView) view).getSelectedItemPosition();
        }
        return -1;
    }

    public <K> T b1(String str, String str2, HttpEntity httpEntity, Class<K> cls, b30<K> b30Var) {
        b30Var.G0(str).E0(cls).c0(3).Q("Content-Type", str2).h0(Constants.f1202m, httpEntity);
        return (T) c(b30Var);
    }

    public <K> T c(b30<K> b30Var) {
        return (T) invoke(b30Var);
    }

    public Spinner c0() {
        return (Spinner) this.f1158b;
    }

    public T c1(float f2) {
        View view = this.f1158b;
        if (view instanceof RatingBar) {
            ((RatingBar) view).setRating(f2);
        }
        return (T) g1();
    }

    public T create(View view) {
        Exception e2;
        T tNewInstance;
        try {
            tNewInstance = P().newInstance(view);
            try {
                tNewInstance.f1149a = this.f1149a;
            } catch (Exception e3) {
                e2 = e3;
                e2.printStackTrace();
            }
        } catch (Exception e4) {
            e2 = e4;
            tNewInstance = null;
        }
        return tNewInstance;
    }

    public <K> T d(String str, Class<K> cls, long j, b30<K> b30Var) {
        b30Var.E0(cls).G0(str).z(true).v(j);
        return (T) c(b30Var);
    }

    public Object d0() {
        View view = this.f1158b;
        if (view != null) {
            return view.getTag();
        }
        return null;
    }

    public T d1(View view) {
        this.f1151a = view;
        this.f1158b = view;
        reset();
        this.f1150a = null;
        return (T) g1();
    }

    public <K> T delete(String str, Class<K> cls, b30<K> b30Var) {
        b30Var.G0(str).E0(cls).c0(2);
        return (T) c(b30Var);
    }

    public <K> T e(String str, Class<K> cls, long j, Object obj, String str2) {
        b30<K> b30Var = new b30<>();
        b30Var.E0(cls).I0(obj, str2).z(true).v(j);
        return (T) f(str, cls, b30Var);
    }

    public Object e0(int i) {
        View view = this.f1158b;
        if (view != null) {
            return view.getTag(i);
        }
        return null;
    }

    public T e1(AbsListView.OnScrollListener onScrollListener) {
        if (this.f1158b instanceof AbsListView) {
            j1().forward(onScrollListener);
        }
        return (T) g1();
    }

    public <K> T f(String str, Class<K> cls, b30<K> b30Var) {
        b30Var.E0(cls).G0(str);
        return (T) c(b30Var);
    }

    public CharSequence f0() {
        View view = this.f1158b;
        if (view instanceof TextView) {
            return ((TextView) view).getText();
        }
        return null;
    }

    public T f1(Object obj, String str) {
        if (this.f1158b instanceof AbsListView) {
            j1().c(obj, str, true, c);
        }
        return (T) g1();
    }

    public <K> T g(String str, Class<K> cls, Object obj, String str2) {
        b30<K> b30Var = new b30<>();
        b30Var.E0(cls).I0(obj, str2);
        return (T) f(str, cls, b30Var);
    }

    public TextView g0() {
        return (TextView) this.f1158b;
    }

    public final T g1() {
        return this;
    }

    public Context getContext() {
        Activity activity = this.f1149a;
        if (activity != null) {
            return activity;
        }
        View view = this.f1151a;
        return view != null ? view.getContext() : this.f1150a;
    }

    public <K> T h(String str, Map<String, ?> map, Class<K> cls, b30<K> b30Var) {
        b30Var.E0(cls).G0(str).i0(map);
        return (T) c(b30Var);
    }

    public View h0() {
        return this.f1158b;
    }

    public T h1(int i, Paint paint) {
        View view = this.f1158b;
        if (view != null) {
            gq.B(view, "setLayerType", false, false, g, Integer.valueOf(i), paint);
        }
        return (T) g1();
    }

    public <K> T i(String str, Map<String, ?> map, Class<K> cls, Object obj, String str2) {
        b30<K> b30Var = new b30<>();
        b30Var.E0(cls).I0(obj, str2);
        return (T) h(str, map, cls, b30Var);
    }

    public WebView i0() {
        return (WebView) this.f1158b;
    }

    public T i1(int i) {
        View view = this.f1158b;
        if (view instanceof AbsListView) {
            gq.B(view, "setOverScrollMode", false, false, f, Integer.valueOf(i));
        }
        return (T) g1();
    }

    public T image(String str, boolean z, boolean z2, int i, int i2, Bitmap bitmap, int i3, float f2, int i4, String str2) {
        if (this.f1158b instanceof ImageView) {
            xv0.R0(this.f1149a, getContext(), (ImageView) this.f1158b, str, z, z2, i, i2, bitmap, i3, f2, Float.MAX_VALUE, this.f1155a, this.f1152a, this.f1154a.intValue(), i4, this.f1157a, str2);
            reset();
        }
        return (T) g1();
    }

    public <K> T invoke(AbstractAjaxCallback<?, K> abstractAjaxCallback) {
        AccountHandle accountHandle = this.f1152a;
        if (accountHandle != null) {
            abstractAjaxCallback.h(accountHandle);
        }
        Object obj = this.f1155a;
        if (obj != null) {
            abstractAjaxCallback.o0(obj);
        }
        Transformer transformer = this.f1153a;
        if (transformer != null) {
            abstractAjaxCallback.D0(transformer);
        }
        Integer num = this.f1154a;
        if (num != null) {
            abstractAjaxCallback.l0(num.intValue());
        }
        HttpHost httpHost = this.f1157a;
        if (httpHost != null) {
            abstractAjaxCallback.p0(httpHost.getHostName(), this.f1157a.getPort());
        }
        Activity activity = this.f1149a;
        if (activity != null) {
            abstractAjaxCallback.e(activity);
        } else {
            abstractAjaxCallback.f(getContext());
        }
        reset();
        return (T) g1();
    }

    public T j() {
        AbstractAjaxCallback.m();
        return (T) g1();
    }

    public T j0() {
        return (T) G1(8);
    }

    public final vp1 j1() {
        AbsListView absListView = (AbsListView) this.f1158b;
        vp1 vp1Var = (vp1) absListView.getTag(Constants.v);
        if (vp1Var != null) {
            return vp1Var;
        }
        vp1 vp1Var2 = new vp1();
        absListView.setOnScrollListener(vp1Var2);
        absListView.setTag(Constants.v, vp1Var2);
        gq.i("set scroll listenr");
        return vp1Var2;
    }

    public T k(int i) {
        return (T) l(i, null);
    }

    public T k0() {
        Activity activity = this.f1149a;
        if (activity != null) {
            activity.getWindow().setFlags(16777216, 16777216);
        }
        return (T) g1();
    }

    public T k1(int i) {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            ((AdapterView) view).setSelection(i);
        }
        return (T) g1();
    }

    public T l(int i, Animation.AnimationListener animationListener) {
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        animationLoadAnimation.setAnimationListener(animationListener);
        return (T) m(animationLoadAnimation);
    }

    public T l0(int i) {
        r1(false, i, true);
        return (T) g1();
    }

    public boolean l1(int i, int i2, boolean z, View view, ViewGroup viewGroup, String str) {
        return vp1.j(i, i2, view, viewGroup, str);
    }

    public T m(Animation animation) {
        View view = this.f1158b;
        if (view != null && animation != null) {
            view.startAnimation(animation);
        }
        return (T) g1();
    }

    public T m0(int i, boolean z) {
        r1(false, i, z);
        return (T) g1();
    }

    public boolean m1(int i, View view, ViewGroup viewGroup, String str) {
        if (viewGroup instanceof ExpandableListView) {
            throw new IllegalArgumentException("Please use the other shouldDelay methods for expandable list.");
        }
        return vp1.k(i, view, viewGroup, str);
    }

    public T n(AccountHandle accountHandle) {
        this.f1152a = accountHandle;
        return (T) g1();
    }

    public T n0(int i) {
        return (T) o0(G(i));
    }

    public boolean n1(int i, boolean z, View view, ViewGroup viewGroup, String str) {
        return vp1.j(i, -1, view, viewGroup, str);
    }

    public T o(int i) {
        View view = this.f1158b;
        if (view != null) {
            if (i != 0) {
                view.setBackgroundResource(i);
            } else {
                view.setBackgroundDrawable(null);
            }
        }
        return (T) g1();
    }

    public T o0(View view) {
        this.f1158b = view;
        reset();
        return (T) g1();
    }

    @Deprecated
    public boolean o1(View view, ViewGroup viewGroup, String str, float f2) {
        return vp1.l(view, viewGroup, str, f2, true);
    }

    public T p(int i) {
        View view = this.f1158b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
        return (T) g1();
    }

    public T p0(String str) {
        return (T) o0(H(str));
    }

    @Deprecated
    public boolean p1(View view, ViewGroup viewGroup, String str, float f2, boolean z) {
        return vp1.l(view, viewGroup, str, f2, z);
    }

    public T q(String str, long j) {
        return (T) e(str, byte[].class, j, null, null);
    }

    public T q0(int... iArr) {
        return (T) o0(I(iArr));
    }

    public T q1(Dialog dialog) {
        if (dialog != null) {
            try {
                dialog.show();
                f26161a.put(dialog, null);
            } catch (Exception unused) {
            }
        }
        return (T) g1();
    }

    public T r(boolean z) {
        View view = this.f1158b;
        if (view instanceof CompoundButton) {
            ((CompoundButton) view).setChecked(z);
        }
        return (T) g1();
    }

    public T r0(int i) {
        View view = this.f1158b;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            imageView.setTag(Constants.u, null);
            if (i == 0) {
                imageView.setImageBitmap(null);
            } else {
                imageView.setImageResource(i);
            }
        }
        return (T) g1();
    }

    public final void r1(boolean z, int i, boolean z2) {
        View view = this.f1158b;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Context context = getContext();
            if (i > 0 && z2) {
                i = gq.n(context, i);
            }
            if (z) {
                layoutParams.width = i;
            } else {
                layoutParams.height = i;
            }
            this.f1158b.setLayoutParams(layoutParams);
        }
    }

    public void reset() {
        this.f1152a = null;
        this.f1155a = null;
        this.f1153a = null;
        this.f1154a = 0;
        this.f1157a = null;
    }

    public T s() {
        View view = this.f1158b;
        if (view != null) {
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                imageView.setImageBitmap(null);
                imageView.setTag(Constants.u, null);
            } else if (view instanceof WebView) {
                WebView webView = (WebView) view;
                webView.stopLoading();
                webView.clearView();
                webView.setTag(Constants.u, null);
            } else if (view instanceof TextView) {
                ((TextView) view).setText("");
            }
        }
        return (T) g1();
    }

    public T s0(Bitmap bitmap) {
        View view = this.f1158b;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            imageView.setTag(Constants.u, null);
            imageView.setImageBitmap(bitmap);
        }
        return (T) g1();
    }

    public <K> T s1(b30<K> b30Var) {
        c(b30Var);
        b30Var.j();
        return (T) g1();
    }

    public T t() {
        View view = this.f1158b;
        if (view != null) {
            view.performClick();
        }
        return (T) g1();
    }

    public T t0(Bitmap bitmap, float f2) {
        xv0 xv0Var = new xv0();
        xv0Var.w1(f2).S0(bitmap);
        return (T) v0(xv0Var);
    }

    public T t1(int i, Object obj) {
        View view = this.f1158b;
        if (view != null) {
            view.setTag(i, obj);
        }
        return (T) g1();
    }

    public T u(boolean z) {
        View view = this.f1158b;
        if (view != null) {
            view.setClickable(z);
        }
        return (T) g1();
    }

    public T u0(Drawable drawable) {
        View view = this.f1158b;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            imageView.setTag(Constants.u, null);
            imageView.setImageDrawable(drawable);
        }
        return (T) g1();
    }

    public T u1(Object obj) {
        View view = this.f1158b;
        if (view != null) {
            view.setTag(obj);
        }
        return (T) g1();
    }

    public T v(View.OnClickListener onClickListener) {
        View view = this.f1158b;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        return (T) g1();
    }

    public T v0(xv0 xv0Var) {
        View view = this.f1158b;
        if (view instanceof ImageView) {
            xv0Var.p1((ImageView) view);
            invoke(xv0Var);
        }
        return (T) g1();
    }

    public T v1(int i) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).setText(i);
        }
        return (T) g1();
    }

    public T w(Object obj, String str) {
        return (T) v(new vp1().c(obj, str, true, f1148a));
    }

    public T w0(File file, int i) {
        return (T) x0(file, true, i, null);
    }

    public T w1(int i, Object... objArr) {
        Context context = getContext();
        if (context != null) {
            y1(context.getString(i, objArr));
        }
        return (T) g1();
    }

    public T x() {
        View view = this.f1158b;
        if (view instanceof AdapterView) {
            Adapter adapter = ((AdapterView) view).getAdapter();
            if (adapter instanceof BaseAdapter) {
                ((BaseAdapter) adapter).notifyDataSetChanged();
            }
        }
        return (T) g1();
    }

    public T x0(File file, boolean z, int i, xv0 xv0Var) {
        if (xv0Var == null) {
            xv0Var = new xv0();
        }
        xv0 xv0Var2 = xv0Var;
        xv0Var2.b1(file);
        return (T) E0(file != null ? file.getAbsolutePath() : null, z, true, i, 0, xv0Var2);
    }

    public T x1(Spanned spanned) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).setText(spanned);
        }
        return (T) g1();
    }

    public T y() {
        Iterator<Dialog> it = f26161a.keySet().iterator();
        while (it.hasNext()) {
            try {
                it.next().dismiss();
            } catch (Exception unused) {
            }
            it.remove();
        }
        return (T) g1();
    }

    public T y0(String str) {
        return (T) B0(str, true, true, 0, 0);
    }

    public T y1(CharSequence charSequence) {
        View view = this.f1158b;
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        return (T) g1();
    }

    public T z(Dialog dialog) {
        if (dialog != null) {
            try {
                f26161a.remove(dialog);
                dialog.dismiss();
            } catch (Exception unused) {
            }
        }
        return (T) g1();
    }

    public T z0(String str, l74 l74Var) {
        return (T) image(str, l74Var, null);
    }

    public T z1(CharSequence charSequence, boolean z) {
        return (z && (charSequence == null || charSequence.length() == 0)) ? (T) j0() : (T) y1(charSequence);
    }

    public AbstractAQuery(View view) {
        this.f1151a = view;
        this.f1158b = view;
    }

    public <K> T delete(String str, Class<K> cls, Object obj, String str2) {
        b30<K> b30Var = new b30<>();
        b30Var.I0(obj, str2);
        return (T) delete(str, cls, b30Var);
    }

    public T image(String str, l74 l74Var, String str2) {
        if (this.f1158b instanceof ImageView) {
            xv0.Q0(this.f1149a, getContext(), (ImageView) this.f1158b, str, this.f1155a, this.f1152a, l74Var, this.f1157a, str2);
            reset();
        }
        return (T) g1();
    }

    public AbstractAQuery(Activity activity, View view) {
        this.f1151a = view;
        this.f1158b = view;
        this.f1149a = activity;
    }

    public AbstractAQuery(Context context) {
        this.f1150a = context;
    }
}
