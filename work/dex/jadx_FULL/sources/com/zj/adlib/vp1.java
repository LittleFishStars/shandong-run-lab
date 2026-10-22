package com.zj.adlib;

import android.app.Activity;
import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.androidquery.util.Constants;
import java.io.File;
import java.util.Comparator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class vp1 implements Comparator<File>, Runnable, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener, TextWatcher {
    public static final int N = 1;
    public static final int O = 2;
    public int K;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbsListView.OnScrollListener f45410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdapterView.OnItemSelectedListener f20264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f20265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f20266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class<?>[] f20267a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f20268a;
    public String f;
    public int L = 0;
    public boolean b = false;

    public static boolean j(int i, int i2, View view, ViewGroup viewGroup, String str) {
        if (str != null && !xv0.q1(str)) {
            AbsListView absListView = (AbsListView) viewGroup;
            if (((AbsListView.OnScrollListener) viewGroup.getTag(Constants.v)) == null) {
                vp1 vp1Var = new vp1();
                absListView.setOnScrollListener(vp1Var);
                viewGroup.setTag(Constants.v, vp1Var);
            }
            Integer num = (Integer) absListView.getTag(Constants.x);
            if (num != null && num.intValue() != 0 && num.intValue() != 1) {
                long packedPositionForChild = i2;
                if (viewGroup instanceof ExpandableListView) {
                    packedPositionForChild = ExpandableListView.getPackedPositionForChild(i, i2);
                }
                view.setTag(Constants.x, Long.valueOf(packedPositionForChild));
                return true;
            }
        }
        return false;
    }

    public static boolean k(int i, View view, ViewGroup viewGroup, String str) {
        return viewGroup instanceof Gallery ? m(i, view, viewGroup, str) : j(-2, i, view, viewGroup, str);
    }

    public static boolean l(View view, ViewGroup viewGroup, String str, float f, boolean z) {
        return k(-1, view, viewGroup, str);
    }

    public static boolean m(int i, View view, ViewGroup viewGroup, String str) {
        Integer num = 0;
        if (str == null || xv0.q1(str)) {
            return false;
        }
        Gallery gallery = (Gallery) viewGroup;
        Integer num2 = (Integer) gallery.getTag(Constants.x);
        if (num2 == null) {
            gallery.setTag(Constants.x, num);
            gallery.setCallbackDuringFling(false);
            new vp1().f(gallery);
        } else {
            num = num2;
        }
        int lastVisiblePosition = ((gallery.getLastVisiblePosition() - gallery.getFirstVisiblePosition()) / 2) + 1;
        int iIntValue = num.intValue() - lastVisiblePosition;
        int iIntValue2 = num.intValue() + lastVisiblePosition;
        if (iIntValue < 0) {
            iIntValue2 -= iIntValue;
            iIntValue = 0;
        }
        if (i < iIntValue || i > iIntValue2) {
            view.setTag(Constants.x, null);
            return true;
        }
        view.setTag(Constants.x, Integer.valueOf(i));
        return false;
    }

    public static void n(Object obj, String str, boolean z) {
        if (obj != null) {
            if (!(obj instanceof View)) {
                if (obj instanceof Dialog) {
                    Dialog dialog = (Dialog) obj;
                    hq hqVar = new hq(dialog.getContext());
                    if (z) {
                        hqVar.q1(dialog);
                        return;
                    } else {
                        hqVar.z(dialog);
                        return;
                    }
                }
                if (obj instanceof Activity) {
                    Activity activity = (Activity) obj;
                    activity.setProgressBarIndeterminateVisibility(z);
                    activity.setProgressBarVisibility(z);
                    if (z) {
                        activity.setProgress(0);
                        return;
                    }
                    return;
                }
                return;
            }
            View view = (View) obj;
            ProgressBar progressBar = obj instanceof ProgressBar ? (ProgressBar) obj : null;
            if (z) {
                view.setTag(Constants.u, str);
                view.setVisibility(0);
                if (progressBar != null) {
                    progressBar.setProgress(0);
                    progressBar.setMax(100);
                    return;
                }
                return;
            }
            Object tag = view.getTag(Constants.u);
            if (tag == null || tag.equals(str)) {
                view.setTag(Constants.u, null);
                if (progressBar == null || progressBar.isIndeterminate()) {
                    view.setVisibility(8);
                }
            }
        }
    }

    public final void a(AbsListView absListView, int i) {
        int count = absListView.getCount();
        int lastVisiblePosition = absListView.getLastVisiblePosition();
        if (i != 0 || count != lastVisiblePosition + 1) {
            this.M = -1;
        } else if (lastVisiblePosition != this.M) {
            this.M = lastVisiblePosition;
            e(absListView, Integer.valueOf(i));
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compare(File file, File file2) {
        long jLastModified = file.lastModified();
        long jLastModified2 = file2.lastModified();
        if (jLastModified2 > jLastModified) {
            return 1;
        }
        return jLastModified2 == jLastModified ? 0 : -1;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public vp1 c(Object obj, String str, boolean z, Class<?>[] clsArr) {
        this.f20265a = obj;
        this.f = str;
        this.f20266a = z;
        this.f20267a = clsArr;
        return this;
    }

    public int d() {
        return this.L;
    }

    public final Object e(Object... objArr) {
        String str = this.f;
        if (str != null) {
            Object[] objArr2 = this.f20268a;
            Object[] objArr3 = objArr2 != null ? objArr2 : objArr;
            Object obj = this.f20265a;
            return gq.B(obj == null ? this : obj, str, this.f20266a, true, this.f20267a, objArr3);
        }
        int i = this.K;
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            Object[] objArr4 = this.f20268a;
            gq.W((File) objArr4[0], (byte[]) objArr4[1]);
            return null;
        }
        if (i != 2) {
            return null;
        }
        Object[] objArr5 = this.f20268a;
        gq.b((File) objArr5[0], ((Long) objArr5[1]).longValue(), ((Long) this.f20268a[2]).longValue());
        return null;
    }

    public void f(Gallery gallery) {
        this.f20264a = gallery.getOnItemSelectedListener();
        this.b = true;
        gallery.setOnItemSelectedListener(this);
    }

    public void forward(AbsListView.OnScrollListener onScrollListener) {
        this.f45410a = onScrollListener;
    }

    public vp1 g(int i, Object... objArr) {
        this.K = i;
        this.f20268a = objArr;
        return this;
    }

    public final void h(ExpandableListView expandableListView, int i) {
        expandableListView.setTag(Constants.x, Integer.valueOf(i));
        if (i == 0) {
            int firstVisiblePosition = expandableListView.getFirstVisiblePosition();
            int lastVisiblePosition = expandableListView.getLastVisiblePosition() - firstVisiblePosition;
            ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
            for (int i2 = 0; i2 <= lastVisiblePosition; i2++) {
                long expandableListPosition = expandableListView.getExpandableListPosition(i2 + firstVisiblePosition);
                int packedPositionGroup = ExpandableListView.getPackedPositionGroup(expandableListPosition);
                int packedPositionChild = ExpandableListView.getPackedPositionChild(expandableListPosition);
                if (packedPositionGroup >= 0) {
                    View childAt = expandableListView.getChildAt(i2);
                    Long l = (Long) childAt.getTag(Constants.x);
                    if (l != null && l.longValue() == expandableListPosition) {
                        if (packedPositionChild == -1) {
                            expandableListAdapter.getGroupView(packedPositionGroup, expandableListView.isGroupExpanded(packedPositionGroup), childAt, expandableListView);
                        } else {
                            expandableListAdapter.getChildView(packedPositionGroup, packedPositionChild, packedPositionChild == expandableListAdapter.getChildrenCount(packedPositionGroup) - 1, childAt, expandableListView);
                        }
                        childAt.setTag(Constants.x, null);
                    }
                }
            }
        }
    }

    public final void i(AbsListView absListView, int i) {
        absListView.setTag(Constants.x, Integer.valueOf(i));
        if (i == 0) {
            int firstVisiblePosition = absListView.getFirstVisiblePosition();
            int lastVisiblePosition = absListView.getLastVisiblePosition() - firstVisiblePosition;
            ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
            for (int i2 = 0; i2 <= lastVisiblePosition; i2++) {
                long j = i2 + firstVisiblePosition;
                View childAt = absListView.getChildAt(i2);
                if (((Number) childAt.getTag(Constants.x)) != null) {
                    listAdapter.getView((int) j, childAt, absListView);
                    childAt.setTag(Constants.x, null);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e(view);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e(adapterView, view, Integer.valueOf(i), Long.valueOf(j));
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        e(adapterView, view, Integer.valueOf(i), Long.valueOf(j));
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f20264a;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(adapterView, view, i, j);
        }
        if (!this.b || ((Integer) adapterView.getTag(Constants.x)).intValue() == i) {
            return;
        }
        Adapter adapter = adapterView.getAdapter();
        adapterView.setTag(Constants.x, Integer.valueOf(i));
        int childCount = adapterView.getChildCount();
        int firstVisiblePosition = adapterView.getFirstVisiblePosition();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = adapterView.getChildAt(i2);
            int i3 = firstVisiblePosition + i2;
            Integer num = (Integer) childAt.getTag(Constants.x);
            if (num == null || num.intValue() != i3) {
                adapter.getView(i3, childAt, adapterView);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Object objE = e(view);
        if (objE instanceof Boolean) {
            return ((Boolean) objE).booleanValue();
        }
        return false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AdapterView.OnItemSelectedListener onItemSelectedListener = this.f20264a;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onNothingSelected(adapterView);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        a(absListView, this.L);
        AbsListView.OnScrollListener onScrollListener = this.f45410a;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        this.L = i;
        a(absListView, i);
        if (absListView instanceof ExpandableListView) {
            h((ExpandableListView) absListView, i);
        } else {
            i(absListView, i);
        }
        AbsListView.OnScrollListener onScrollListener = this.f45410a;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        e(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // java.lang.Runnable
    public void run() {
        e(new Object[0]);
    }
}
