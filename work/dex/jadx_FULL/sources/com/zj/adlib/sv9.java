package com.zj.adlib;

import android.view.View;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.listener.ISelectTimeCallback;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class sv9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DateFormat f44785a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final int j = 1900;
    public static final int k = 2100;
    public static final int l = 1;
    public static final int m = 12;
    public static final int n = 1;
    public static final int o = 31;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19653a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f19654a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ISelectTimeCallback f19655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WheelView f19656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f19658a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public WheelView f19659b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public WheelView f19660c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public WheelView f19661d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public WheelView f19662e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public WheelView f19663f;
    public int h;
    public int i;
    public int b = 1900;
    public int c = 2100;
    public int d = 1;
    public int e = 12;
    public int f = 1;
    public int g = 31;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19657a = false;

    public class a implements OnItemSelectedListener {
        public a() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            int iN;
            int i2 = i + sv9.this.b;
            sv9.this.f19659b.setAdapter(new hb0(ak1.i(i2)));
            if (ak1.m(i2) == 0 || sv9.this.f19659b.getCurrentItem() <= ak1.m(i2) - 1) {
                sv9.this.f19659b.setCurrentItem(sv9.this.f19659b.getCurrentItem());
            } else {
                sv9.this.f19659b.setCurrentItem(sv9.this.f19659b.getCurrentItem() + 1);
            }
            int currentItem = sv9.this.f19660c.getCurrentItem();
            if (ak1.m(i2) == 0 || sv9.this.f19659b.getCurrentItem() <= ak1.m(i2) - 1) {
                sv9.this.f19660c.setAdapter(new hb0(ak1.g(ak1.n(i2, sv9.this.f19659b.getCurrentItem() + 1))));
                iN = ak1.n(i2, sv9.this.f19659b.getCurrentItem() + 1);
            } else if (sv9.this.f19659b.getCurrentItem() == ak1.m(i2) + 1) {
                sv9.this.f19660c.setAdapter(new hb0(ak1.g(ak1.l(i2))));
                iN = ak1.l(i2);
            } else {
                sv9.this.f19660c.setAdapter(new hb0(ak1.g(ak1.n(i2, sv9.this.f19659b.getCurrentItem()))));
                iN = ak1.n(i2, sv9.this.f19659b.getCurrentItem());
            }
            int i3 = iN - 1;
            if (currentItem > i3) {
                sv9.this.f19660c.setCurrentItem(i3);
            }
            if (sv9.this.f19655a != null) {
                sv9.this.f19655a.a();
            }
        }
    }

    public class b implements OnItemSelectedListener {
        public b() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            int iN;
            int currentItem = sv9.this.f19656a.getCurrentItem() + sv9.this.b;
            int currentItem2 = sv9.this.f19660c.getCurrentItem();
            if (ak1.m(currentItem) == 0 || i <= ak1.m(currentItem) - 1) {
                int i2 = i + 1;
                sv9.this.f19660c.setAdapter(new hb0(ak1.g(ak1.n(currentItem, i2))));
                iN = ak1.n(currentItem, i2);
            } else if (sv9.this.f19659b.getCurrentItem() == ak1.m(currentItem) + 1) {
                sv9.this.f19660c.setAdapter(new hb0(ak1.g(ak1.l(currentItem))));
                iN = ak1.l(currentItem);
            } else {
                sv9.this.f19660c.setAdapter(new hb0(ak1.g(ak1.n(currentItem, i))));
                iN = ak1.n(currentItem, i);
            }
            int i3 = iN - 1;
            if (currentItem2 > i3) {
                sv9.this.f19660c.setCurrentItem(i3);
            }
            if (sv9.this.f19655a != null) {
                sv9.this.f19655a.a();
            }
        }
    }

    public class c implements OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f19664a;
        public final /* synthetic */ List b;

        public c(List list, List list2) {
            this.f19664a = list;
            this.b = list2;
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            int i2 = i + sv9.this.b;
            sv9.this.h = i2;
            int currentItem = sv9.this.f19659b.getCurrentItem();
            if (sv9.this.b == sv9.this.c) {
                sv9.this.f19659b.setAdapter(new p46(sv9.this.d, sv9.this.e));
                if (currentItem > sv9.this.f19659b.getAdapter().a() - 1) {
                    currentItem = sv9.this.f19659b.getAdapter().a() - 1;
                    sv9.this.f19659b.setCurrentItem(currentItem);
                }
                int i3 = currentItem + sv9.this.d;
                if (sv9.this.d == sv9.this.e) {
                    sv9 sv9Var = sv9.this;
                    sv9Var.J(i2, i3, sv9Var.f, sv9.this.g, this.f19664a, this.b);
                } else if (i3 == sv9.this.d) {
                    sv9 sv9Var2 = sv9.this;
                    sv9Var2.J(i2, i3, sv9Var2.f, 31, this.f19664a, this.b);
                } else if (i3 == sv9.this.e) {
                    sv9 sv9Var3 = sv9.this;
                    sv9Var3.J(i2, i3, 1, sv9Var3.g, this.f19664a, this.b);
                } else {
                    sv9.this.J(i2, i3, 1, 31, this.f19664a, this.b);
                }
            } else if (i2 == sv9.this.b) {
                sv9.this.f19659b.setAdapter(new p46(sv9.this.d, 12));
                if (currentItem > sv9.this.f19659b.getAdapter().a() - 1) {
                    currentItem = sv9.this.f19659b.getAdapter().a() - 1;
                    sv9.this.f19659b.setCurrentItem(currentItem);
                }
                int i4 = currentItem + sv9.this.d;
                if (i4 == sv9.this.d) {
                    sv9 sv9Var4 = sv9.this;
                    sv9Var4.J(i2, i4, sv9Var4.f, 31, this.f19664a, this.b);
                } else {
                    sv9.this.J(i2, i4, 1, 31, this.f19664a, this.b);
                }
            } else if (i2 == sv9.this.c) {
                sv9.this.f19659b.setAdapter(new p46(1, sv9.this.e));
                if (currentItem > sv9.this.f19659b.getAdapter().a() - 1) {
                    currentItem = sv9.this.f19659b.getAdapter().a() - 1;
                    sv9.this.f19659b.setCurrentItem(currentItem);
                }
                int i5 = 1 + currentItem;
                if (i5 == sv9.this.e) {
                    sv9 sv9Var5 = sv9.this;
                    sv9Var5.J(i2, i5, 1, sv9Var5.g, this.f19664a, this.b);
                } else {
                    sv9.this.J(i2, i5, 1, 31, this.f19664a, this.b);
                }
            } else {
                sv9.this.f19659b.setAdapter(new p46(1, 12));
                sv9 sv9Var6 = sv9.this;
                sv9Var6.J(i2, 1 + sv9Var6.f19659b.getCurrentItem(), 1, 31, this.f19664a, this.b);
            }
            if (sv9.this.f19655a != null) {
                sv9.this.f19655a.a();
            }
        }
    }

    public class d implements OnItemSelectedListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ List f19665a;
        public final /* synthetic */ List b;

        public d(List list, List list2) {
            this.f19665a = list;
            this.b = list2;
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            int i2 = i + 1;
            if (sv9.this.b == sv9.this.c) {
                int i3 = (i2 + sv9.this.d) - 1;
                if (sv9.this.d == sv9.this.e) {
                    sv9 sv9Var = sv9.this;
                    sv9Var.J(sv9Var.h, i3, sv9.this.f, sv9.this.g, this.f19665a, this.b);
                } else if (sv9.this.d == i3) {
                    sv9 sv9Var2 = sv9.this;
                    sv9Var2.J(sv9Var2.h, i3, sv9.this.f, 31, this.f19665a, this.b);
                } else if (sv9.this.e == i3) {
                    sv9 sv9Var3 = sv9.this;
                    sv9Var3.J(sv9Var3.h, i3, 1, sv9.this.g, this.f19665a, this.b);
                } else {
                    sv9 sv9Var4 = sv9.this;
                    sv9Var4.J(sv9Var4.h, i3, 1, 31, this.f19665a, this.b);
                }
            } else if (sv9.this.h == sv9.this.b) {
                int i4 = (i2 + sv9.this.d) - 1;
                if (i4 == sv9.this.d) {
                    sv9 sv9Var5 = sv9.this;
                    sv9Var5.J(sv9Var5.h, i4, sv9.this.f, 31, this.f19665a, this.b);
                } else {
                    sv9 sv9Var6 = sv9.this;
                    sv9Var6.J(sv9Var6.h, i4, 1, 31, this.f19665a, this.b);
                }
            } else if (sv9.this.h != sv9.this.c) {
                sv9 sv9Var7 = sv9.this;
                sv9Var7.J(sv9Var7.h, i2, 1, 31, this.f19665a, this.b);
            } else if (i2 == sv9.this.e) {
                sv9 sv9Var8 = sv9.this;
                sv9Var8.J(sv9Var8.h, sv9.this.f19659b.getCurrentItem() + 1, 1, sv9.this.g, this.f19665a, this.b);
            } else {
                sv9 sv9Var9 = sv9.this;
                sv9Var9.J(sv9Var9.h, sv9.this.f19659b.getCurrentItem() + 1, 1, 31, this.f19665a, this.b);
            }
            if (sv9.this.f19655a != null) {
                sv9.this.f19655a.a();
            }
        }
    }

    public class e implements OnItemSelectedListener {
        public e() {
        }

        @Override // com.contrarywind.listener.OnItemSelectedListener
        public void a(int i) {
            sv9.this.f19655a.a();
        }
    }

    public sv9(View view, boolean[] zArr, int i, int i2) {
        this.f19654a = view;
        this.f19658a = zArr;
        this.f19653a = i;
        this.i = i2;
    }

    public void A(int i) {
        this.c = i;
    }

    public void B(int i) {
        this.f19660c.setItemsVisibleCount(i);
        this.f19659b.setItemsVisibleCount(i);
        this.f19656a.setItemsVisibleCount(i);
        this.f19661d.setItemsVisibleCount(i);
        this.f19662e.setItemsVisibleCount(i);
        this.f19663f.setItemsVisibleCount(i);
    }

    public void C(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.f19657a) {
            return;
        }
        if (str != null) {
            this.f19656a.setLabel(str);
        } else {
            this.f19656a.setLabel(this.f19654a.getContext().getString(R.string.pickerview_year));
        }
        if (str2 != null) {
            this.f19659b.setLabel(str2);
        } else {
            this.f19659b.setLabel(this.f19654a.getContext().getString(R.string.pickerview_month));
        }
        if (str3 != null) {
            this.f19660c.setLabel(str3);
        } else {
            this.f19660c.setLabel(this.f19654a.getContext().getString(R.string.pickerview_day));
        }
        if (str4 != null) {
            this.f19661d.setLabel(str4);
        } else {
            this.f19661d.setLabel(this.f19654a.getContext().getString(R.string.pickerview_hours));
        }
        if (str5 != null) {
            this.f19662e.setLabel(str5);
        } else {
            this.f19662e.setLabel(this.f19654a.getContext().getString(R.string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f19663f.setLabel(str6);
        } else {
            this.f19663f.setLabel(this.f19654a.getContext().getString(R.string.pickerview_seconds));
        }
    }

    public void D(float f) {
        this.f19660c.setLineSpacingMultiplier(f);
        this.f19659b.setLineSpacingMultiplier(f);
        this.f19656a.setLineSpacingMultiplier(f);
        this.f19661d.setLineSpacingMultiplier(f);
        this.f19662e.setLineSpacingMultiplier(f);
        this.f19663f.setLineSpacingMultiplier(f);
    }

    public final void E(int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        WheelView wheelView = (WheelView) this.f19654a.findViewById(R.id.year);
        this.f19656a = wheelView;
        wheelView.setAdapter(new hb0(ak1.j(this.b, this.c)));
        this.f19656a.setLabel("");
        this.f19656a.setCurrentItem(i - this.b);
        this.f19656a.setGravity(this.f19653a);
        WheelView wheelView2 = (WheelView) this.f19654a.findViewById(R.id.month);
        this.f19659b = wheelView2;
        wheelView2.setAdapter(new hb0(ak1.i(i)));
        this.f19659b.setLabel("");
        int iM = ak1.m(i);
        if (iM == 0 || (i2 <= iM - 1 && !z)) {
            this.f19659b.setCurrentItem(i2);
        } else {
            this.f19659b.setCurrentItem(i2 + 1);
        }
        this.f19659b.setGravity(this.f19653a);
        this.f19660c = (WheelView) this.f19654a.findViewById(R.id.day);
        if (ak1.m(i) == 0) {
            this.f19660c.setAdapter(new hb0(ak1.g(ak1.n(i, i2))));
        } else {
            this.f19660c.setAdapter(new hb0(ak1.g(ak1.l(i))));
        }
        this.f19660c.setLabel("");
        this.f19660c.setCurrentItem(i3 - 1);
        this.f19660c.setGravity(this.f19653a);
        WheelView wheelView3 = (WheelView) this.f19654a.findViewById(R.id.hour);
        this.f19661d = wheelView3;
        wheelView3.setAdapter(new p46(0, 23));
        this.f19661d.setCurrentItem(i4);
        this.f19661d.setGravity(this.f19653a);
        WheelView wheelView4 = (WheelView) this.f19654a.findViewById(R.id.min);
        this.f19662e = wheelView4;
        wheelView4.setAdapter(new p46(0, 59));
        this.f19662e.setCurrentItem(i5);
        this.f19662e.setGravity(this.f19653a);
        WheelView wheelView5 = (WheelView) this.f19654a.findViewById(R.id.second);
        this.f19663f = wheelView5;
        wheelView5.setAdapter(new p46(0, 59));
        this.f19663f.setCurrentItem(i5);
        this.f19663f.setGravity(this.f19653a);
        this.f19656a.setOnItemSelectedListener(new a());
        this.f19659b.setOnItemSelectedListener(new b());
        v(this.f19660c);
        v(this.f19661d);
        v(this.f19662e);
        v(this.f19663f);
        boolean[] zArr = this.f19658a;
        if (zArr.length != 6) {
            throw new RuntimeException("type[] length is not 6");
        }
        this.f19656a.setVisibility(zArr[0] ? 0 : 8);
        this.f19659b.setVisibility(this.f19658a[1] ? 0 : 8);
        this.f19660c.setVisibility(this.f19658a[2] ? 0 : 8);
        this.f19661d.setVisibility(this.f19658a[3] ? 0 : 8);
        this.f19662e.setVisibility(this.f19658a[4] ? 0 : 8);
        this.f19663f.setVisibility(this.f19658a[5] ? 0 : 8);
        w();
    }

    public void F(boolean z) {
        this.f19657a = z;
    }

    public void G(int i, int i2, int i3) {
        H(i, i2, i3, 0, 0, 0);
    }

    public void H(int i, int i2, int i3, int i4, int i5, int i6) {
        if (!this.f19657a) {
            L(i, i2, i3, i4, i5, i6);
        } else {
            int[] iArrI = i55.i(i, i2 + 1, i3);
            E(iArrI[0], iArrI[1] - 1, iArrI[2], iArrI[3] == 1, i4, i5, i6);
        }
    }

    public void I(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i = calendar2.get(1);
            int i2 = calendar2.get(2) + 1;
            int i3 = calendar2.get(5);
            int i4 = this.b;
            if (i > i4) {
                this.c = i;
                this.e = i2;
                this.g = i3;
                return;
            } else {
                if (i == i4) {
                    int i5 = this.d;
                    if (i2 > i5) {
                        this.c = i;
                        this.e = i2;
                        this.g = i3;
                        return;
                    } else {
                        if (i2 != i5 || i3 <= this.f) {
                            return;
                        }
                        this.c = i;
                        this.e = i2;
                        this.g = i3;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.b = calendar.get(1);
            this.c = calendar2.get(1);
            this.d = calendar.get(2) + 1;
            this.e = calendar2.get(2) + 1;
            this.f = calendar.get(5);
            this.g = calendar2.get(5);
            return;
        }
        int i6 = calendar.get(1);
        int i7 = calendar.get(2) + 1;
        int i8 = calendar.get(5);
        int i9 = this.c;
        if (i6 < i9) {
            this.d = i7;
            this.f = i8;
            this.b = i6;
        } else if (i6 == i9) {
            int i10 = this.e;
            if (i7 < i10) {
                this.d = i7;
                this.f = i8;
                this.b = i6;
            } else {
                if (i7 != i10 || i8 >= this.g) {
                    return;
                }
                this.d = i7;
                this.f = i8;
                this.b = i6;
            }
        }
    }

    public final void J(int i, int i2, int i3, int i4, List<String> list, List<String> list2) {
        int currentItem = this.f19660c.getCurrentItem();
        if (list.contains(String.valueOf(i2))) {
            if (i4 > 31) {
                i4 = 31;
            }
            this.f19660c.setAdapter(new p46(i3, i4));
        } else if (list2.contains(String.valueOf(i2))) {
            if (i4 > 30) {
                i4 = 30;
            }
            this.f19660c.setAdapter(new p46(i3, i4));
        } else if ((i % 4 != 0 || i % 100 == 0) && i % 400 != 0) {
            if (i4 > 28) {
                i4 = 28;
            }
            this.f19660c.setAdapter(new p46(i3, i4));
        } else {
            if (i4 > 29) {
                i4 = 29;
            }
            this.f19660c.setAdapter(new p46(i3, i4));
        }
        if (currentItem > this.f19660c.getAdapter().a() - 1) {
            this.f19660c.setCurrentItem(this.f19660c.getAdapter().a() - 1);
        }
    }

    public void K(ISelectTimeCallback iSelectTimeCallback) {
        this.f19655a = iSelectTimeCallback;
    }

    public final void L(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        List listAsList = Arrays.asList("1", "3", "5", "7", PrepareException.ERROR_AUTH_FAIL, "10", "12");
        List listAsList2 = Arrays.asList("4", "6", "9", "11");
        this.h = i;
        WheelView wheelView = (WheelView) this.f19654a.findViewById(R.id.year);
        this.f19656a = wheelView;
        wheelView.setAdapter(new p46(this.b, this.c));
        this.f19656a.setCurrentItem(i - this.b);
        this.f19656a.setGravity(this.f19653a);
        WheelView wheelView2 = (WheelView) this.f19654a.findViewById(R.id.month);
        this.f19659b = wheelView2;
        int i9 = this.b;
        int i10 = this.c;
        if (i9 == i10) {
            wheelView2.setAdapter(new p46(this.d, this.e));
            this.f19659b.setCurrentItem((i2 + 1) - this.d);
        } else if (i == i9) {
            wheelView2.setAdapter(new p46(this.d, 12));
            this.f19659b.setCurrentItem((i2 + 1) - this.d);
        } else if (i == i10) {
            wheelView2.setAdapter(new p46(1, this.e));
            this.f19659b.setCurrentItem(i2);
        } else {
            wheelView2.setAdapter(new p46(1, 12));
            this.f19659b.setCurrentItem(i2);
        }
        this.f19659b.setGravity(this.f19653a);
        this.f19660c = (WheelView) this.f19654a.findViewById(R.id.day);
        boolean z = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
        int i11 = this.b;
        int i12 = this.c;
        if (i11 == i12 && this.d == this.e) {
            int i13 = i2 + 1;
            if (listAsList.contains(String.valueOf(i13))) {
                if (this.g > 31) {
                    this.g = 31;
                }
                this.f19660c.setAdapter(new p46(this.f, this.g));
            } else if (listAsList2.contains(String.valueOf(i13))) {
                if (this.g > 30) {
                    this.g = 30;
                }
                this.f19660c.setAdapter(new p46(this.f, this.g));
            } else if (z) {
                if (this.g > 29) {
                    this.g = 29;
                }
                this.f19660c.setAdapter(new p46(this.f, this.g));
            } else {
                if (this.g > 28) {
                    this.g = 28;
                }
                this.f19660c.setAdapter(new p46(this.f, this.g));
            }
            this.f19660c.setCurrentItem(i3 - this.f);
        } else if (i == i11 && (i8 = i2 + 1) == this.d) {
            if (listAsList.contains(String.valueOf(i8))) {
                this.f19660c.setAdapter(new p46(this.f, 31));
            } else if (listAsList2.contains(String.valueOf(i8))) {
                this.f19660c.setAdapter(new p46(this.f, 30));
            } else {
                this.f19660c.setAdapter(new p46(this.f, z ? 29 : 28));
            }
            this.f19660c.setCurrentItem(i3 - this.f);
        } else if (i == i12 && (i7 = i2 + 1) == this.e) {
            if (listAsList.contains(String.valueOf(i7))) {
                if (this.g > 31) {
                    this.g = 31;
                }
                this.f19660c.setAdapter(new p46(1, this.g));
            } else if (listAsList2.contains(String.valueOf(i7))) {
                if (this.g > 30) {
                    this.g = 30;
                }
                this.f19660c.setAdapter(new p46(1, this.g));
            } else if (z) {
                if (this.g > 29) {
                    this.g = 29;
                }
                this.f19660c.setAdapter(new p46(1, this.g));
            } else {
                if (this.g > 28) {
                    this.g = 28;
                }
                this.f19660c.setAdapter(new p46(1, this.g));
            }
            this.f19660c.setCurrentItem(i3 - 1);
        } else {
            int i14 = i2 + 1;
            if (listAsList.contains(String.valueOf(i14))) {
                this.f19660c.setAdapter(new p46(1, 31));
            } else if (listAsList2.contains(String.valueOf(i14))) {
                this.f19660c.setAdapter(new p46(1, 30));
            } else {
                this.f19660c.setAdapter(new p46(this.f, z ? 29 : 28));
            }
            this.f19660c.setCurrentItem(i3 - 1);
        }
        this.f19660c.setGravity(this.f19653a);
        WheelView wheelView3 = (WheelView) this.f19654a.findViewById(R.id.hour);
        this.f19661d = wheelView3;
        wheelView3.setAdapter(new p46(0, 23));
        this.f19661d.setCurrentItem(i4);
        this.f19661d.setGravity(this.f19653a);
        WheelView wheelView4 = (WheelView) this.f19654a.findViewById(R.id.min);
        this.f19662e = wheelView4;
        wheelView4.setAdapter(new p46(0, 59));
        this.f19662e.setCurrentItem(i5);
        this.f19662e.setGravity(this.f19653a);
        WheelView wheelView5 = (WheelView) this.f19654a.findViewById(R.id.second);
        this.f19663f = wheelView5;
        wheelView5.setAdapter(new p46(0, 59));
        this.f19663f.setCurrentItem(i6);
        this.f19663f.setGravity(this.f19653a);
        this.f19656a.setOnItemSelectedListener(new c(listAsList, listAsList2));
        this.f19659b.setOnItemSelectedListener(new d(listAsList, listAsList2));
        v(this.f19660c);
        v(this.f19661d);
        v(this.f19662e);
        v(this.f19663f);
        boolean[] zArr = this.f19658a;
        if (zArr.length != 6) {
            throw new IllegalArgumentException("type[] length is not 6");
        }
        this.f19656a.setVisibility(zArr[0] ? 0 : 8);
        this.f19659b.setVisibility(this.f19658a[1] ? 0 : 8);
        this.f19660c.setVisibility(this.f19658a[2] ? 0 : 8);
        this.f19661d.setVisibility(this.f19658a[3] ? 0 : 8);
        this.f19662e.setVisibility(this.f19658a[4] ? 0 : 8);
        this.f19663f.setVisibility(this.f19658a[5] ? 0 : 8);
        w();
    }

    public void M(int i) {
        this.b = i;
    }

    public void N(int i) {
        this.f19660c.setTextColorCenter(i);
        this.f19659b.setTextColorCenter(i);
        this.f19656a.setTextColorCenter(i);
        this.f19661d.setTextColorCenter(i);
        this.f19662e.setTextColorCenter(i);
        this.f19663f.setTextColorCenter(i);
    }

    public void O(int i) {
        this.f19660c.setTextColorOut(i);
        this.f19659b.setTextColorOut(i);
        this.f19656a.setTextColorOut(i);
        this.f19661d.setTextColorOut(i);
        this.f19662e.setTextColorOut(i);
        this.f19663f.setTextColorOut(i);
    }

    public void P(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f19656a.setTextXOffset(i);
        this.f19659b.setTextXOffset(i2);
        this.f19660c.setTextXOffset(i3);
        this.f19661d.setTextXOffset(i4);
        this.f19662e.setTextXOffset(i5);
        this.f19663f.setTextXOffset(i6);
    }

    public int n() {
        return this.c;
    }

    public final String o() {
        int currentItem;
        boolean z;
        StringBuilder sb = new StringBuilder();
        int currentItem2 = this.f19656a.getCurrentItem() + this.b;
        if (ak1.m(currentItem2) == 0 || (this.f19659b.getCurrentItem() + 1) - ak1.m(currentItem2) <= 0) {
            int currentItem3 = this.f19659b.getCurrentItem();
            currentItem = currentItem3 + 1;
            z = false;
        } else if ((this.f19659b.getCurrentItem() + 1) - ak1.m(currentItem2) == 1) {
            currentItem = this.f19659b.getCurrentItem();
            z = true;
        } else {
            currentItem = this.f19659b.getCurrentItem();
            z = false;
        }
        int[] iArrG = i55.g(currentItem2, currentItem, this.f19660c.getCurrentItem() + 1, z);
        sb.append(iArrG[0]);
        sb.append(c49.f40900a);
        sb.append(iArrG[1]);
        sb.append(c49.f40900a);
        sb.append(iArrG[2]);
        sb.append(" ");
        sb.append(this.f19661d.getCurrentItem());
        sb.append(u15.f19942b);
        sb.append(this.f19662e.getCurrentItem());
        sb.append(u15.f19942b);
        sb.append(this.f19663f.getCurrentItem());
        return sb.toString();
    }

    public int p() {
        return this.b;
    }

    public String q() {
        if (this.f19657a) {
            return o();
        }
        StringBuilder sb = new StringBuilder();
        if (this.h == this.b) {
            int currentItem = this.f19659b.getCurrentItem();
            int i = this.d;
            if (currentItem + i == i) {
                sb.append(this.f19656a.getCurrentItem() + this.b);
                sb.append(c49.f40900a);
                sb.append(this.f19659b.getCurrentItem() + this.d);
                sb.append(c49.f40900a);
                sb.append(this.f19660c.getCurrentItem() + this.f);
                sb.append(" ");
                sb.append(this.f19661d.getCurrentItem());
                sb.append(u15.f19942b);
                sb.append(this.f19662e.getCurrentItem());
                sb.append(u15.f19942b);
                sb.append(this.f19663f.getCurrentItem());
            } else {
                sb.append(this.f19656a.getCurrentItem() + this.b);
                sb.append(c49.f40900a);
                sb.append(this.f19659b.getCurrentItem() + this.d);
                sb.append(c49.f40900a);
                sb.append(this.f19660c.getCurrentItem() + 1);
                sb.append(" ");
                sb.append(this.f19661d.getCurrentItem());
                sb.append(u15.f19942b);
                sb.append(this.f19662e.getCurrentItem());
                sb.append(u15.f19942b);
                sb.append(this.f19663f.getCurrentItem());
            }
        } else {
            sb.append(this.f19656a.getCurrentItem() + this.b);
            sb.append(c49.f40900a);
            sb.append(this.f19659b.getCurrentItem() + 1);
            sb.append(c49.f40900a);
            sb.append(this.f19660c.getCurrentItem() + 1);
            sb.append(" ");
            sb.append(this.f19661d.getCurrentItem());
            sb.append(u15.f19942b);
            sb.append(this.f19662e.getCurrentItem());
            sb.append(u15.f19942b);
            sb.append(this.f19663f.getCurrentItem());
        }
        return sb.toString();
    }

    public View r() {
        return this.f19654a;
    }

    public void s(boolean z) {
        this.f19660c.isCenterLabel(z);
        this.f19659b.isCenterLabel(z);
        this.f19656a.isCenterLabel(z);
        this.f19661d.isCenterLabel(z);
        this.f19662e.isCenterLabel(z);
        this.f19663f.isCenterLabel(z);
    }

    public boolean t() {
        return this.f19657a;
    }

    public void u(boolean z) {
        this.f19660c.setAlphaGradient(z);
        this.f19659b.setAlphaGradient(z);
        this.f19656a.setAlphaGradient(z);
        this.f19661d.setAlphaGradient(z);
        this.f19662e.setAlphaGradient(z);
        this.f19663f.setAlphaGradient(z);
    }

    public final void v(WheelView wheelView) {
        if (this.f19655a != null) {
            wheelView.setOnItemSelectedListener(new e());
        }
    }

    public final void w() {
        this.f19660c.setTextSize(this.i);
        this.f19659b.setTextSize(this.i);
        this.f19656a.setTextSize(this.i);
        this.f19661d.setTextSize(this.i);
        this.f19662e.setTextSize(this.i);
        this.f19663f.setTextSize(this.i);
    }

    public void x(boolean z) {
        this.f19656a.setCyclic(z);
        this.f19659b.setCyclic(z);
        this.f19660c.setCyclic(z);
        this.f19661d.setCyclic(z);
        this.f19662e.setCyclic(z);
        this.f19663f.setCyclic(z);
    }

    public void y(int i) {
        this.f19660c.setDividerColor(i);
        this.f19659b.setDividerColor(i);
        this.f19656a.setDividerColor(i);
        this.f19661d.setDividerColor(i);
        this.f19662e.setDividerColor(i);
        this.f19663f.setDividerColor(i);
    }

    public void z(WheelView.DividerType dividerType) {
        this.f19660c.setDividerType(dividerType);
        this.f19659b.setDividerType(dividerType);
        this.f19656a.setDividerType(dividerType);
        this.f19661d.setDividerType(dividerType);
        this.f19662e.setDividerType(dividerType);
        this.f19663f.setDividerType(dividerType);
    }
}
