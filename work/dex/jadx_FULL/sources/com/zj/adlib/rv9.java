package com.zj.adlib;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rv9<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f44545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnOptionsSelectChangeListener f19429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OnItemSelectedListener f19430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WheelView f19431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<T> f19432a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19433a = true;
    public OnItemSelectedListener b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public WheelView f19434b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<List<T>> f19435b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f19436b;
    public WheelView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public List<List<List<T>>> f19437c;

    public class a implements OnItemSelectedListener {
        public a() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            int currentItem;
            if (rv9.this.f19435b == null) {
                if (rv9.this.f19429a != null) {
                    rv9.this.f19429a.a(rv9.this.f19431a.getCurrentItem(), 0, 0);
                    return;
                }
                return;
            }
            if (rv9.this.f19436b) {
                currentItem = 0;
            } else {
                currentItem = rv9.this.f19434b.getCurrentItem();
                if (currentItem >= ((List) rv9.this.f19435b.get(i)).size() - 1) {
                    currentItem = ((List) rv9.this.f19435b.get(i)).size() - 1;
                }
            }
            rv9.this.f19434b.setAdapter(new hb0((List) rv9.this.f19435b.get(i)));
            rv9.this.f19434b.setCurrentItem(currentItem);
            if (rv9.this.f19437c != null) {
                rv9.this.b.a(currentItem);
            } else if (rv9.this.f19429a != null) {
                rv9.this.f19429a.a(i, currentItem, 0);
            }
        }
    }

    public class b implements OnItemSelectedListener {
        public b() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            int size = 0;
            if (rv9.this.f19437c == null) {
                if (rv9.this.f19429a != null) {
                    rv9.this.f19429a.a(rv9.this.f19431a.getCurrentItem(), i, 0);
                    return;
                }
                return;
            }
            int currentItem = rv9.this.f19431a.getCurrentItem();
            if (currentItem >= rv9.this.f19437c.size() - 1) {
                currentItem = rv9.this.f19437c.size() - 1;
            }
            if (i >= ((List) rv9.this.f19435b.get(currentItem)).size() - 1) {
                i = ((List) rv9.this.f19435b.get(currentItem)).size() - 1;
            }
            if (!rv9.this.f19436b) {
                size = rv9.this.c.getCurrentItem() >= ((List) ((List) rv9.this.f19437c.get(currentItem)).get(i)).size() + (-1) ? ((List) ((List) rv9.this.f19437c.get(currentItem)).get(i)).size() - 1 : rv9.this.c.getCurrentItem();
            }
            rv9.this.c.setAdapter(new hb0((List) ((List) rv9.this.f19437c.get(rv9.this.f19431a.getCurrentItem())).get(i)));
            rv9.this.c.setCurrentItem(size);
            if (rv9.this.f19429a != null) {
                rv9.this.f19429a.a(rv9.this.f19431a.getCurrentItem(), i, size);
            }
        }
    }

    public class c implements OnItemSelectedListener {
        public c() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            rv9.this.f19429a.a(rv9.this.f19431a.getCurrentItem(), rv9.this.f19434b.getCurrentItem(), i);
        }
    }

    public class d implements OnItemSelectedListener {
        public d() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            rv9.this.f19429a.a(i, rv9.this.f19434b.getCurrentItem(), rv9.this.c.getCurrentItem());
        }
    }

    public class e implements OnItemSelectedListener {
        public e() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            rv9.this.f19429a.a(rv9.this.f19431a.getCurrentItem(), i, rv9.this.c.getCurrentItem());
        }
    }

    public class f implements OnItemSelectedListener {
        public f() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            rv9.this.f19429a.a(rv9.this.f19431a.getCurrentItem(), rv9.this.f19434b.getCurrentItem(), i);
        }
    }

    public rv9(View view, boolean z) {
        this.f19436b = z;
        this.f44545a = view;
        this.f19431a = (WheelView) view.findViewById(R.id.options1);
        this.f19434b = (WheelView) view.findViewById(R.id.options2);
        this.c = (WheelView) view.findViewById(R.id.options3);
    }

    public void A(int i) {
        this.f19431a.setTextColorOut(i);
        this.f19434b.setTextColorOut(i);
        this.c.setTextColorOut(i);
    }

    public void B(int i) {
        float f2 = i;
        this.f19431a.setTextSize(f2);
        this.f19434b.setTextSize(f2);
        this.c.setTextSize(f2);
    }

    public void C(int i, int i2, int i3) {
        this.f19431a.setTextXOffset(i);
        this.f19434b.setTextXOffset(i2);
        this.c.setTextXOffset(i3);
    }

    public void D(Typeface typeface) {
        this.f19431a.setTypeface(typeface);
        this.f19434b.setTypeface(typeface);
        this.c.setTypeface(typeface);
    }

    public void E(View view) {
        this.f44545a = view;
    }

    public int[] i() {
        int[] iArr = new int[3];
        iArr[0] = this.f19431a.getCurrentItem();
        List<List<T>> list = this.f19435b;
        if (list == null || list.size() <= 0) {
            iArr[1] = this.f19434b.getCurrentItem();
        } else {
            iArr[1] = this.f19434b.getCurrentItem() > this.f19435b.get(iArr[0]).size() - 1 ? 0 : this.f19434b.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f19437c;
        if (list2 == null || list2.size() <= 0) {
            iArr[2] = this.c.getCurrentItem();
        } else {
            iArr[2] = this.c.getCurrentItem() <= this.f19437c.get(iArr[0]).get(iArr[1]).size() - 1 ? this.c.getCurrentItem() : 0;
        }
        return iArr;
    }

    public View j() {
        return this.f44545a;
    }

    public void k(boolean z) {
        this.f19431a.isCenterLabel(z);
        this.f19434b.isCenterLabel(z);
        this.c.isCenterLabel(z);
    }

    public final void l(int i, int i2, int i3) {
        if (this.f19432a != null) {
            this.f19431a.setCurrentItem(i);
        }
        List<List<T>> list = this.f19435b;
        if (list != null) {
            this.f19434b.setAdapter(new hb0(list.get(i)));
            this.f19434b.setCurrentItem(i2);
        }
        List<List<List<T>>> list2 = this.f19437c;
        if (list2 != null) {
            this.c.setAdapter(new hb0(list2.get(i).get(i2)));
            this.c.setCurrentItem(i3);
        }
    }

    public void m(boolean z) {
        this.f19431a.setAlphaGradient(z);
        this.f19434b.setAlphaGradient(z);
        this.c.setAlphaGradient(z);
    }

    public void n(int i, int i2, int i3) {
        if (this.f19433a) {
            l(i, i2, i3);
            return;
        }
        this.f19431a.setCurrentItem(i);
        this.f19434b.setCurrentItem(i2);
        this.c.setCurrentItem(i3);
    }

    public void o(boolean z) {
        this.f19431a.setCyclic(z);
        this.f19434b.setCyclic(z);
        this.c.setCyclic(z);
    }

    public void p(boolean z, boolean z2, boolean z3) {
        this.f19431a.setCyclic(z);
        this.f19434b.setCyclic(z2);
        this.c.setCyclic(z3);
    }

    public void q(int i) {
        this.f19431a.setDividerColor(i);
        this.f19434b.setDividerColor(i);
        this.c.setDividerColor(i);
    }

    public void r(WheelView.DividerType dividerType) {
        this.f19431a.setDividerType(dividerType);
        this.f19434b.setDividerType(dividerType);
        this.c.setDividerType(dividerType);
    }

    public void s(int i) {
        this.f19431a.setItemsVisibleCount(i);
        this.f19434b.setItemsVisibleCount(i);
        this.c.setItemsVisibleCount(i);
    }

    public void setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.f19429a = onOptionsSelectChangeListener;
    }

    public void t(String str, String str2, String str3) {
        if (str != null) {
            this.f19431a.setLabel(str);
        }
        if (str2 != null) {
            this.f19434b.setLabel(str2);
        }
        if (str3 != null) {
            this.c.setLabel(str3);
        }
    }

    public final void u() {
    }

    public void v(float f2) {
        this.f19431a.setLineSpacingMultiplier(f2);
        this.f19434b.setLineSpacingMultiplier(f2);
        this.c.setLineSpacingMultiplier(f2);
    }

    public void w(boolean z) {
        this.f19433a = z;
    }

    public void x(List<T> list, List<T> list2, List<T> list3) {
        this.f19431a.setAdapter(new hb0(list));
        this.f19431a.setCurrentItem(0);
        if (list2 != null) {
            this.f19434b.setAdapter(new hb0(list2));
        }
        WheelView wheelView = this.f19434b;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list3 != null) {
            this.c.setAdapter(new hb0(list3));
        }
        WheelView wheelView2 = this.c;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f19431a.setIsOptions(true);
        this.f19434b.setIsOptions(true);
        this.c.setIsOptions(true);
        if (this.f19429a != null) {
            this.f19431a.setOnItemSelectedListener(new d());
        }
        if (list2 == null) {
            this.f19434b.setVisibility(8);
        } else {
            this.f19434b.setVisibility(0);
            if (this.f19429a != null) {
                this.f19434b.setOnItemSelectedListener(new e());
            }
        }
        if (list3 == null) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        if (this.f19429a != null) {
            this.c.setOnItemSelectedListener(new f());
        }
    }

    public void y(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.f19432a = list;
        this.f19435b = list2;
        this.f19437c = list3;
        this.f19431a.setAdapter(new hb0(list));
        this.f19431a.setCurrentItem(0);
        List<List<T>> list4 = this.f19435b;
        if (list4 != null) {
            this.f19434b.setAdapter(new hb0(list4.get(0)));
        }
        WheelView wheelView = this.f19434b;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        List<List<List<T>>> list5 = this.f19437c;
        if (list5 != null) {
            this.c.setAdapter(new hb0(list5.get(0).get(0)));
        }
        WheelView wheelView2 = this.c;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f19431a.setIsOptions(true);
        this.f19434b.setIsOptions(true);
        this.c.setIsOptions(true);
        if (this.f19435b == null) {
            this.f19434b.setVisibility(8);
        } else {
            this.f19434b.setVisibility(0);
        }
        if (this.f19437c == null) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
        }
        this.f19430a = new a();
        this.b = new b();
        if (list != null && this.f19433a) {
            this.f19431a.setOnItemSelectedListener(this.f19430a);
        }
        if (list2 != null && this.f19433a) {
            this.f19434b.setOnItemSelectedListener(this.b);
        }
        if (list3 == null || !this.f19433a || this.f19429a == null) {
            return;
        }
        this.c.setOnItemSelectedListener(new c());
    }

    public void z(int i) {
        this.f19431a.setTextColorCenter(i);
        this.f19434b.setTextColorCenter(i);
        this.c.setTextColorCenter(i);
    }
}
