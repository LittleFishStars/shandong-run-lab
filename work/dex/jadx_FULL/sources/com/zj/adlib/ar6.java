package com.zj.adlib;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.contrarywind.view.WheelView;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ar6 {
    public static final int D = -16417281;
    public static final int E = -657931;
    public static final int F = -16777216;
    public static final int G = -1;
    public static final int H = 1;
    public static final int I = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f15346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View.OnClickListener f15348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f15349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomListener f15350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnOptionsSelectChangeListener f15351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnOptionsSelectListener f15352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTimeSelectChangeListener f15353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnTimeSelectListener f15354a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Calendar f15357a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f15360b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Calendar f15361b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f15363c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Calendar f15364c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f15366d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f15368e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f15370f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f15372g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f15373g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f15374h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f15376i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f15378j;
    public int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f15380k;
    public int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f15381l;
    public int m;
    public int n;
    public int o;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15358a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f15362b = false;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f15365c = false;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f15367d = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f15359a = {true, true, true, false, false, false};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f15369e = false;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f15371f = false;
    public int p = 17;
    public int q = D;
    public int r = D;
    public int s = -16777216;
    public int t = -1;
    public int u = E;
    public int v = 17;
    public int w = 18;
    public int x = 18;
    public int y = -5723992;
    public int z = -14013910;
    public int A = -2763307;
    public int B = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40593a = 1.6f;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f15375h = true;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f15377i = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f15347a = Typeface.MONOSPACE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WheelView.DividerType f15355a = WheelView.DividerType.FILL;
    public int C = 9;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f15379j = false;

    public ar6(int i) {
        if (i == 1) {
            this.o = R.layout.pickerview_options;
        } else {
            this.o = R.layout.pickerview_time;
        }
    }
}
