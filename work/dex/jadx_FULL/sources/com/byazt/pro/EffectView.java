package com.byazt.pro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.byazt.atv.sp;
import com.byazt.ete.gr;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.byazt.ete.md;
import com.byazt.omf.my;
import com.byazt.omf.x;
import com.byazt.ouz.gt;
import com.byazt.sz.qy;
import com.byazt.xl.yp;
import com.byazt.xs.da;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 199, 736})
public class EffectView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f28957a;
    public ir c;
    public final my n;
    public View tt;
    public boolean uj;
    public ic ve;

    public interface c {
        void c();

        void c(String str);
    }

    public EffectView(@NonNull Context context, ic icVar, my myVar) {
        super(context);
        this.uj = false;
        this.ve = icVar;
        this.n = myVar;
        this.c = md.ve(icVar);
    }

    public void tt(final View view) {
        if (c(view)) {
            da.c(this.c.da(), this.c.i(), new com.byazt.xs.ve() { // from class: com.byazt.pro.EffectView.2
                @Override // com.byazt.xs.ve
                public void c(String str) {
                    try {
                        EffectView.this.c(new JSONObject(str), view);
                    } catch (JSONException e) {
                        EffectView.this.c("getTplInfoAndRender JSONException:" + e.getMessage());
                    }
                }

                @Override // com.byazt.xs.ve
                public void c() {
                    EffectView.this.c("getTplInfoAndRender onFailed");
                }
            });
        } else {
            c("meetRenderCondition not meet");
        }
    }

    public void c(c cVar) {
        this.f28957a = cVar;
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.byazt.pro.EffectView.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                int i9 = i3 - i;
                int i10 = i4 - i2;
                if (EffectView.this.uj || i9 <= 0 || i10 <= 0) {
                    return;
                }
                EffectView.this.uj = true;
                EffectView effectView = EffectView.this;
                effectView.tt((View) effectView);
                EffectView.this.removeOnLayoutChangeListener(this);
            }
        });
    }

    public boolean c(View view) {
        ir irVar = this.c;
        return irVar != null && view != null && irVar.t() && this.c.c(view.getWidth(), view.getHeight()) && this.c.x() != 1 && this.c.ve() == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final JSONObject jSONObject, final View view) {
        post(new Runnable() { // from class: com.byazt.pro.EffectView.3
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectC = com.byazt.jlk.tt.c(EffectView.this.ve, com.byazt.jlk.tt.c(view), jSONObject, true, null, false);
                com.byazt.atv.tt.c cVar = new com.byazt.atv.tt.c();
                cVar.c(jSONObjectC);
                cVar.c((qy) new gt());
                int height = view.getHeight();
                int width = view.getWidth();
                cVar.tt(height);
                cVar.c(width);
                cVar.c(x.m().uj());
                cVar.da(EffectView.this.ve.eo());
                cVar.sl(2);
                sp spVar = new sp(com.byazt.omf.gt.getContext(), EffectView.this.ve, cVar.c(), null);
                spVar.c(new com.byazt.xl.x() { // from class: com.byazt.pro.EffectView.3.1
                    @Override // com.byazt.xl.x
                    public void c(View view2, int i, com.byazt.sr.ve veVar, int i2) {
                        EffectView.this.c(view2, i, veVar);
                    }

                    @Override // com.byazt.xl.x
                    public void tt(View view2, int i, com.byazt.sr.ve veVar, int i2) {
                        EffectView.this.c(view2, i, veVar);
                    }
                });
                spVar.c(new com.byazt.sy.x() { // from class: com.byazt.pro.EffectView.3.2
                    @Override // com.byazt.sy.x
                    public void c() {
                        View view2 = EffectView.this.tt;
                        if (view2 != null) {
                            view2.setVisibility(8);
                            try {
                                if (EffectView.this.tt.getParent() != null) {
                                    ((ViewGroup) EffectView.this.tt.getParent()).removeView(EffectView.this.tt);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                });
                spVar.c(new com.byazt.xl.sp() { // from class: com.byazt.pro.EffectView.3.3
                    @Override // com.byazt.xl.sp
                    public void c(View view2, yp ypVar) {
                        if (view2 == null) {
                            EffectView.this.c("renderView is null");
                            return;
                        }
                        EffectView.this.tt = view2;
                        if (view2.getParent() != null) {
                            ((ViewGroup) view2.getParent()).removeView(view2);
                        }
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams.gravity = 17;
                        EffectView.this.addView(view2, layoutParams);
                        EffectView.this.c();
                        EffectView.this.uj = false;
                    }

                    @Override // com.byazt.xl.sp
                    public void c(int i, String str) {
                        EffectView.this.c(str);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(View view, int i, com.byazt.sr.ve veVar) {
        com.byazt.ete.da daVar;
        if (this.n == null) {
            return;
        }
        if ((i == 1 || i == 2) && (veVar instanceof gr)) {
            gr grVar = (gr) veVar;
            daVar = new com.byazt.ete.da();
            daVar.c(grVar.c);
            daVar.tt(grVar.tt);
            daVar.ve(grVar.ve);
            daVar.uj(grVar.uj);
            daVar.c(grVar.n);
            daVar.tt(grVar.f28489a);
            daVar.tt(grVar.z);
        } else {
            daVar = null;
        }
        if (i == 2) {
            this.n.c(view, daVar);
        }
        if (i == 1) {
            this.n.tt(view, daVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        c cVar = this.f28957a;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        c cVar = this.f28957a;
        if (cVar != null) {
            cVar.c(str);
        }
    }
}
