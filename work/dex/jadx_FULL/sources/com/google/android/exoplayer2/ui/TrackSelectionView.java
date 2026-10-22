package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.p;
import com.google.android.exoplayer2.ui.TrackSelectionView;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.da9;
import com.zj.adlib.sa9;
import com.zj.adlib.sb0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TrackSelectionView extends LinearLayout {
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutInflater f31078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CheckedTextView f4957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackNameProvider f4958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public TrackSelectionListener f4959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f4960a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Comparator<c> f4961a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<p.a> f4962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<da9, sa9> f4963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CheckedTextView[][] f4965a;
    public final CheckedTextView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4966b;
    public boolean c;

    public interface TrackSelectionListener {
        void a(boolean z, Map<da9, sa9> map);
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TrackSelectionView.this.c(view);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31080a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final p.a f4967a;

        public c(p.a aVar, int i) {
            this.f4967a = aVar;
            this.f31080a = i;
        }

        public com.google.android.exoplayer2.d a() {
            return this.f4967a.c(this.f31080a);
        }
    }

    public TrackSelectionView(Context context) {
        this(context, null);
    }

    public static /* synthetic */ int b(Comparator comparator, c cVar, c cVar2) {
        return comparator.compare(cVar.a(), cVar2.a());
    }

    public static Map<da9, sa9> filterOverrides(Map<da9, sa9> map, List<p.a> list, boolean z) {
        HashMap map2 = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            sa9 sa9Var = map.get(list.get(i).b());
            if (sa9Var != null && (z || map2.isEmpty())) {
                map2.put(sa9Var.f19559a, sa9Var);
            }
        }
        return map2;
    }

    public final void c(View view) {
        if (view == this.f4957a) {
            e();
        } else if (view == this.b) {
            d();
        } else {
            f(view);
        }
        i();
        TrackSelectionListener trackSelectionListener = this.f4959a;
        if (trackSelectionListener != null) {
            trackSelectionListener.a(getIsDisabled(), getOverrides());
        }
    }

    public final void d() {
        this.c = false;
        this.f4963a.clear();
    }

    public final void e() {
        this.c = true;
        this.f4963a.clear();
    }

    public final void f(View view) {
        this.c = false;
        c cVar = (c) sb0.g(view.getTag());
        da9 da9VarB = cVar.f4967a.b();
        int i = cVar.f31080a;
        sa9 sa9Var = this.f4963a.get(da9VarB);
        if (sa9Var == null) {
            if (!this.f4966b && this.f4963a.size() > 0) {
                this.f4963a.clear();
            }
            this.f4963a.put(da9VarB, new sa9(da9VarB, ImmutableList.of(Integer.valueOf(i))));
            return;
        }
        ArrayList arrayList = new ArrayList(sa9Var.f19558a);
        boolean zIsChecked = ((CheckedTextView) view).isChecked();
        boolean zG = g(cVar.f4967a);
        boolean z = zG || h();
        if (zIsChecked && z) {
            arrayList.remove(Integer.valueOf(i));
            if (arrayList.isEmpty()) {
                this.f4963a.remove(da9VarB);
                return;
            } else {
                this.f4963a.put(da9VarB, new sa9(da9VarB, arrayList));
                return;
            }
        }
        if (zIsChecked) {
            return;
        }
        if (!zG) {
            this.f4963a.put(da9VarB, new sa9(da9VarB, ImmutableList.of(Integer.valueOf(i))));
        } else {
            arrayList.add(Integer.valueOf(i));
            this.f4963a.put(da9VarB, new sa9(da9VarB, arrayList));
        }
    }

    public final boolean g(p.a aVar) {
        return this.f4964a && aVar.e();
    }

    public boolean getIsDisabled() {
        return this.c;
    }

    public Map<da9, sa9> getOverrides() {
        return this.f4963a;
    }

    public final boolean h() {
        return this.f4966b && this.f4962a.size() > 1;
    }

    public final void i() {
        this.f4957a.setChecked(this.c);
        this.b.setChecked(!this.c && this.f4963a.size() == 0);
        for (int i = 0; i < this.f4965a.length; i++) {
            sa9 sa9Var = this.f4963a.get(this.f4962a.get(i).b());
            int i2 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f4965a[i];
                if (i2 < checkedTextViewArr.length) {
                    if (sa9Var != null) {
                        this.f4965a[i][i2].setChecked(sa9Var.f19558a.contains(Integer.valueOf(((c) sb0.g(checkedTextViewArr[i2].getTag())).f31080a)));
                    } else {
                        checkedTextViewArr[i2].setChecked(false);
                    }
                    i2++;
                }
            }
        }
    }

    public void init(List<p.a> list, boolean z, Map<da9, sa9> map, @Nullable final Comparator<com.google.android.exoplayer2.d> comparator, @Nullable TrackSelectionListener trackSelectionListener) {
        this.c = z;
        this.f4961a = comparator == null ? null : new Comparator() { // from class: com.zj.adlib.va9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return TrackSelectionView.b(comparator, (TrackSelectionView.c) obj, (TrackSelectionView.c) obj2);
            }
        };
        this.f4959a = trackSelectionListener;
        this.f4962a.clear();
        this.f4962a.addAll(list);
        this.f4963a.clear();
        this.f4963a.putAll(filterOverrides(map, list, this.f4966b));
        j();
    }

    public final void j() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        if (this.f4962a.isEmpty()) {
            this.f4957a.setEnabled(false);
            this.b.setEnabled(false);
            return;
        }
        this.f4957a.setEnabled(true);
        this.b.setEnabled(true);
        this.f4965a = new CheckedTextView[this.f4962a.size()][];
        boolean zH = h();
        for (int i = 0; i < this.f4962a.size(); i++) {
            p.a aVar = this.f4962a.get(i);
            boolean zG = g(aVar);
            CheckedTextView[][] checkedTextViewArr = this.f4965a;
            int i2 = aVar.K;
            checkedTextViewArr[i] = new CheckedTextView[i2];
            c[] cVarArr = new c[i2];
            for (int i3 = 0; i3 < aVar.K; i3++) {
                cVarArr[i3] = new c(aVar, i3);
            }
            Comparator<c> comparator = this.f4961a;
            if (comparator != null) {
                Arrays.sort(cVarArr, comparator);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                if (i4 == 0) {
                    addView(this.f31078a.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView = (CheckedTextView) this.f31078a.inflate((zG || zH) ? android.R.layout.simple_list_item_multiple_choice : android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView.setBackgroundResource(this.K);
                checkedTextView.setText(this.f4958a.a(cVarArr[i4].a()));
                checkedTextView.setTag(cVarArr[i4]);
                if (aVar.j(i4)) {
                    checkedTextView.setFocusable(true);
                    checkedTextView.setOnClickListener(this.f4960a);
                } else {
                    checkedTextView.setFocusable(false);
                    checkedTextView.setEnabled(false);
                }
                this.f4965a[i][i4] = checkedTextView;
                addView(checkedTextView);
            }
        }
        i();
    }

    public void setAllowAdaptiveSelections(boolean z) {
        if (this.f4964a != z) {
            this.f4964a = z;
            j();
        }
    }

    public void setAllowMultipleOverrides(boolean z) {
        if (this.f4966b != z) {
            this.f4966b = z;
            if (!z && this.f4963a.size() > 1) {
                Map<da9, sa9> mapFilterOverrides = filterOverrides(this.f4963a, this.f4962a, false);
                this.f4963a.clear();
                this.f4963a.putAll(mapFilterOverrides);
            }
            j();
        }
    }

    public void setShowDisableOption(boolean z) {
        this.f4957a.setVisibility(z ? 0 : 8);
    }

    public void setTrackNameProvider(TrackNameProvider trackNameProvider) {
        this.f4958a = (TrackNameProvider) sb0.g(trackNameProvider);
        j();
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TrackSelectionView(Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        this.K = resourceId;
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        this.f31078a = layoutInflaterFrom;
        b bVar = new b();
        this.f4960a = bVar;
        this.f4958a = new com.google.android.exoplayer2.ui.b(getResources());
        this.f4962a = new ArrayList();
        this.f4963a = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f4957a = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(bVar);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(layoutInflaterFrom.inflate(R.layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) layoutInflaterFrom.inflate(android.R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.b = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(bVar);
        addView(checkedTextView2);
    }
}
