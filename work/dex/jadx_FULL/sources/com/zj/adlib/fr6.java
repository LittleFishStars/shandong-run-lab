package com.zj.adlib;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.huachenjie.login.R;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b¨\u0006\u000f"}, d2 = {"Lcom/zj/adlib/fr6;", "", "Landroid/content/Context;", "context", "Lcom/bigkoo/pickerview/listener/OnTimeSelectListener;", "timeSelectListener", "Lcom/zj/adlib/f79;", "e", "Lcom/bigkoo/pickerview/listener/OnOptionsSelectListener;", "optionSelectListener", "Lcom/zj/adlib/rd6;", "", "c", "<init>", "()V", "login_release"}, k = 1, mv = {1, 8, 0})
public final class fr6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final fr6 f41739a = new fr6();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"com/zj/adlib/fr6$a", "Lcom/bigkoo/pickerview/listener/CustomListener;", "Landroid/view/View;", "v", "", "a", "", "Ljava/lang/String;", "TAG_SUBMIT", "b", "TAG_CANCEL", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class a implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f41740a;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final String TAG_SUBMIT = "submit";

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final String TAG_CANCEL = "cancel";

        public a(View.OnClickListener onClickListener) {
            this.f41740a = onClickListener;
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Button button = (Button) v.findViewById(R.id.btnSubmit);
            Button button2 = (Button) v.findViewById(R.id.btnCancel);
            button.setTag(this.TAG_SUBMIT);
            button2.setTag(this.TAG_CANCEL);
            button.setOnClickListener(this.f41740a);
            button2.setOnClickListener(this.f41740a);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082D¢\u0006\u0006\n\u0004\b\t\u0010\u0007¨\u0006\u000b"}, d2 = {"com/zj/adlib/fr6$b", "Lcom/bigkoo/pickerview/listener/CustomListener;", "Landroid/view/View;", "v", "", "a", "", "Ljava/lang/String;", "TAG_SUBMIT", "b", "TAG_CANCEL", "login_release"}, k = 1, mv = {1, 8, 0})
    public static final class b implements CustomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnClickListener f41741a;

        /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
        @NotNull
        public final String TAG_SUBMIT = "submit";

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @NotNull
        public final String TAG_CANCEL = "cancel";

        public b(View.OnClickListener onClickListener) {
            this.f41741a = onClickListener;
        }

        @Override // com.bigkoo.pickerview.listener.CustomListener
        public void a(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            Button button = (Button) v.findViewById(R.id.btnSubmit);
            Button button2 = (Button) v.findViewById(R.id.btnCancel);
            button.setTag(this.TAG_SUBMIT);
            button2.setTag(this.TAG_CANCEL);
            button.setOnClickListener(this.f41741a);
            button2.setOnClickListener(this.f41741a);
        }
    }

    public static final void d(Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "$optionsPickerView");
        rd6 rd6Var = (rd6) objectRef.element;
        if (rd6Var != null) {
            rd6Var.onClick(view);
        }
    }

    public static final void f(Ref.ObjectRef objectRef, View view) {
        Intrinsics.checkNotNullParameter(objectRef, "$timePickerView");
        f79 f79Var = (f79) objectRef.element;
        if (f79Var != null) {
            f79Var.onClick(view);
        }
    }

    @NotNull
    public final rd6<String> c(@NotNull Context context, @NotNull OnOptionsSelectListener optionSelectListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(optionSelectListener, "optionSelectListener");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        rd6<String> rd6VarB = new pd6(context, optionSelectListener).r(R.layout.pickerview_custom_options, new a(new View.OnClickListener() { // from class: com.zj.adlib.dr6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                fr6.d(objectRef, view);
            }
        })).f(true).h(0).C(Color.parseColor("#191F20")).D(Color.parseColor("#757979")).n(0).p(7).s(3.0f).k(18).b();
        objectRef.element = rd6VarB;
        return rd6VarB;
    }

    @NotNull
    public final f79 e(@NotNull Context context, @NotNull OnTimeSelectListener timeSelectListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(timeSelectListener, "timeSelectListener");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1950, 0, 1);
        Calendar calendar2 = Calendar.getInstance();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new e79(context, timeSelectListener).s(R.layout.pickerview_custom_time, new b(new View.OnClickListener() { // from class: com.zj.adlib.er6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                fr6.f(objectRef, view);
            }
        })).h(0).B(Color.parseColor("#191F20")).C(Color.parseColor("#757979")).n(0).q(7).t(3.0f).k(18).x(calendar, calendar2).b();
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2000, 0, 1);
        ((f79) objectRef.element).E(calendar3);
        return (f79) objectRef.element;
    }
}
