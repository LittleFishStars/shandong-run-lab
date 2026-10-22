package com.ipd.dsp.internal.c1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.ipd.dsp.R;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.e1.d;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends Dialog implements View.OnClickListener {
    public Context f;
    public InterfaceC0864a g;
    public String h;
    public com.ipd.dsp.internal.p1.b i;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.c1.a$a, reason: collision with other inner class name */
    public interface InterfaceC0864a {
        String a();

        void b();

        boolean c();
    }

    public a(Context context, d dVar, String str, InterfaceC0864a interfaceC0864a) {
        super(context, R.style.IPD_FULL_SCREEN_DIALOG);
        this.f = context;
        a(dVar);
        this.g = interfaceC0864a;
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        a();
        a(str);
    }

    public final void a(d dVar) {
        int i;
        StringBuilder sb = new StringBuilder();
        sb.append("<b>应用名:</b> ");
        sb.append(dVar.r.q);
        sb.append("<br><b>应用版本:</b> ");
        sb.append(dVar.r.r);
        sb.append("<br><b>开发者:</b> ");
        sb.append(dVar.r.s);
        sb.append("<br><b>更新时间:</b> ");
        sb.append(dVar.r.t);
        sb.append("<br><b><a href='");
        sb.append(dVar.r.x);
        sb.append("'>功能简介</a></b>");
        sb.append("&nbsp;&nbsp;&nbsp;&nbsp;<b><a href='");
        sb.append(dVar.r.v);
        sb.append("'>隐私政策</a></b>");
        if (o.c(dVar.r.y)) {
            sb.append("&nbsp;&nbsp;&nbsp;&nbsp;<b><a href='");
            sb.append(dVar.r.y);
            sb.append("'>应用权限</a></b>");
        }
        if (o.c(dVar.r.z)) {
            try {
                long j = Long.parseLong(dVar.r.z);
                if (j > 0) {
                    sb.append("<br><b>应用包大小:</b> ");
                    sb.append(j);
                }
            } catch (NumberFormatException unused) {
            }
        }
        if (o.c(dVar.r.A)) {
            sb.append("<br><b>适用年龄:</b> ");
            sb.append(dVar.r.A);
        }
        if (o.c(dVar.r.B)) {
            sb.append("<br><b>备案号:</b> ");
            sb.append(dVar.r.B);
        }
        if (o.c(dVar.r.C)) {
            sb.append("<br><b><a href='");
            sb.append(dVar.r.C);
            sb.append("'>备案信息</a></b>");
        }
        ArrayList<String> arrayList = dVar.r.u;
        if (arrayList != null && !arrayList.isEmpty()) {
            sb.append("<br><b>应用权限:</b> ");
            int size = dVar.r.u.size();
            int i2 = 0;
            while (true) {
                i = size - 1;
                if (i2 >= i) {
                    break;
                }
                sb.append(dVar.r.u.get(i2));
                sb.append(", ");
                i2++;
            }
            sb.append(dVar.r.u.get(i));
        }
        this.h = sb.toString();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        this.f = null;
        this.i = null;
        InterfaceC0864a interfaceC0864a = this.g;
        if (interfaceC0864a != null) {
            interfaceC0864a.b();
            this.g = null;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InterfaceC0864a interfaceC0864a;
        com.ipd.dsp.internal.p1.b bVar = this.i;
        if (view == bVar.f) {
            cancel();
        } else {
            if (view != bVar.g || (interfaceC0864a = this.g) == null) {
                return;
            }
            a(interfaceC0864a.a());
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        int iA = g.a().a(this.f);
        Window window = getWindow();
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = (int) (((double) iA) * 0.4d);
            attributes.gravity = 80;
            attributes.windowAnimations = R.style.IPD_ANIM_UP;
            if (this.g.c()) {
                attributes.flags = 2;
                window.setDimAmount(0.5f);
            }
            window.setAttributes(attributes);
            setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.zj.adlib.tca
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    this.f44892a.a(dialogInterface);
                }
            });
        }
    }

    public final void a() {
        com.ipd.dsp.internal.p1.b bVar = new com.ipd.dsp.internal.p1.b(this.f, this.h);
        this.i = bVar;
        setContentView(bVar);
        this.i.f.setOnClickListener(this);
        this.i.g.setOnClickListener(this);
    }

    public void a(String str) {
        this.i.g.setText(str);
    }

    public final /* synthetic */ void a(DialogInterface dialogInterface) {
        try {
            Window window = getWindow();
            if (window != null) {
                window.setWindowAnimations(0);
            }
        } catch (Throwable unused) {
        }
    }
}
