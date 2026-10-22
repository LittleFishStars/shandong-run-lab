package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.zj.adlib.a94;
import com.zj.adlib.ax6;
import com.zj.adlib.ch7;
import com.zj.adlib.e72;
import com.zj.adlib.h76;
import com.zj.adlib.lh3;
import com.zj.adlib.un0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Supplier<DataSource<IMAGE>> f1598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ControllerListener<? super INFO> f1599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DraweeController f1600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Object f1601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<ControllerListener> f1602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public REQUEST[] f1604a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public REQUEST f1605b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1606b;

    @Nullable
    public REQUEST c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f1607c;
    public boolean d;
    public static final ControllerListener<Object> b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NullPointerException f29968a = new NullPointerException("No image request was specified!");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicLong f1596a = new AtomicLong();

    public static class a extends un0<Object> {
        @Override // com.zj.adlib.un0, com.facebook.drawee.controller.ControllerListener
        public void a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    public class b implements Supplier<DataSource<IMAGE>> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f1608a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f1609a;
        public final /* synthetic */ Object b;

        public b(Object obj, Object obj2, boolean z) {
            this.f1608a = obj;
            this.b = obj2;
            this.f1609a = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.facebook.common.internal.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataSource<IMAGE> get() {
            return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(this.f1608a, this.b, this.f1609a);
        }

        public String toString() {
            return h76.f(this).f("request", this.f1608a.toString()).toString();
        }
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set) {
        this.f1597a = context;
        this.f1602a = set;
        q();
    }

    public static String generateUniqueControllerId() {
        return String.valueOf(f1596a.getAndIncrement());
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public BUILDER b(@Nullable DraweeController draweeController) {
        this.f1600a = draweeController;
        return (BUILDER) getThis();
    }

    public BUILDER B(boolean z) {
        this.d = z;
        return (BUILDER) getThis();
    }

    public BUILDER C(boolean z) {
        this.f1606b = z;
        return (BUILDER) getThis();
    }

    public AbstractDraweeController buildController() {
        AbstractDraweeController abstractDraweeControllerObtainController = obtainController();
        abstractDraweeControllerObtainController.setRetainImageOnFailure(o());
        maybeBuildAndSetRetryManager(abstractDraweeControllerObtainController);
        maybeAttachListeners(abstractDraweeControllerObtainController);
        return abstractDraweeControllerObtainController;
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractDraweeController d() {
        REQUEST request;
        validate();
        if (this.f1605b == null && this.f1604a == null && (request = this.c) != null) {
            this.f1605b = request;
            this.c = null;
        }
        return buildController();
    }

    public boolean g() {
        return this.f1607c;
    }

    public Context getContext() {
        return this.f1597a;
    }

    public abstract DataSource<IMAGE> getDataSourceForRequest(REQUEST request, Object obj, boolean z);

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(REQUEST request) {
        return getDataSourceSupplierForRequest(request, false);
    }

    public Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(REQUEST[] requestArr, boolean z) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z) {
            for (REQUEST request : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(request, true));
            }
        }
        for (REQUEST request2 : requestArr) {
            arrayList.add(getDataSourceSupplierForRequest(request2));
        }
        return lh3.b(arrayList);
    }

    public abstract BUILDER getThis();

    @Nullable
    public Object h() {
        return this.f1601a;
    }

    @Nullable
    public ControllerListener<? super INFO> i() {
        return this.f1599a;
    }

    @Nullable
    public Supplier<DataSource<IMAGE>> j() {
        return this.f1598a;
    }

    @Nullable
    public REQUEST[] k() {
        return this.f1604a;
    }

    @Nullable
    public REQUEST l() {
        return this.f1605b;
    }

    @Nullable
    public REQUEST m() {
        return this.c;
    }

    public void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Set<ControllerListener> set = this.f1602a;
        if (set != null) {
            Iterator<ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeController.i(it.next());
            }
        }
        ControllerListener<? super INFO> controllerListener = this.f1599a;
        if (controllerListener != null) {
            abstractDraweeController.i(controllerListener);
        }
        if (this.f1607c) {
            abstractDraweeController.i(b);
        }
    }

    public void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.c(this.f1597a));
        }
    }

    public void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.f1606b) {
            ch7 retryManager = abstractDraweeController.getRetryManager();
            if (retryManager == null) {
                retryManager = new ch7();
                abstractDraweeController.setRetryManager(retryManager);
            }
            retryManager.f(this.f1606b);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    @Nullable
    public DraweeController n() {
        return this.f1600a;
    }

    public boolean o() {
        return this.d;
    }

    public abstract AbstractDraweeController obtainController();

    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier() {
        Supplier<DataSource<IMAGE>> firstAvailableDataSourceSupplier;
        Supplier<DataSource<IMAGE>> supplier = this.f1598a;
        if (supplier != null) {
            return supplier;
        }
        REQUEST request = this.f1605b;
        if (request != null) {
            firstAvailableDataSourceSupplier = getDataSourceSupplierForRequest(request);
        } else {
            REQUEST[] requestArr = this.f1604a;
            firstAvailableDataSourceSupplier = requestArr != null ? getFirstAvailableDataSourceSupplier(requestArr, this.f1603a) : null;
        }
        if (firstAvailableDataSourceSupplier != null && this.c != null) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(firstAvailableDataSourceSupplier);
            arrayList.add(getDataSourceSupplierForRequest(this.c));
            firstAvailableDataSourceSupplier = a94.b(arrayList);
        }
        return firstAvailableDataSourceSupplier == null ? e72.a(f29968a) : firstAvailableDataSourceSupplier;
    }

    public boolean p() {
        return this.f1606b;
    }

    public final void q() {
        this.f1601a = null;
        this.f1605b = null;
        this.c = null;
        this.f1604a = null;
        this.f1603a = true;
        this.f1599a = null;
        this.f1606b = false;
        this.f1607c = false;
        this.f1600a = null;
    }

    public BUILDER r() {
        q();
        return (BUILDER) getThis();
    }

    public BUILDER s(boolean z) {
        this.f1607c = z;
        return (BUILDER) getThis();
    }

    @Override // com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public BUILDER a(Object obj) {
        this.f1601a = obj;
        return (BUILDER) getThis();
    }

    public BUILDER u(ControllerListener<? super INFO> controllerListener) {
        this.f1599a = controllerListener;
        return (BUILDER) getThis();
    }

    public void v(@Nullable Supplier<DataSource<IMAGE>> supplier) {
        this.f1598a = supplier;
    }

    public void validate() {
        boolean z = false;
        ax6.p(this.f1604a == null || this.f1605b == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.f1598a == null || (this.f1604a == null && this.f1605b == null && this.c == null)) {
            z = true;
        }
        ax6.p(z, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    public BUILDER w(REQUEST[] requestArr) {
        return (BUILDER) x(requestArr, true);
    }

    public BUILDER x(REQUEST[] requestArr, boolean z) {
        this.f1604a = requestArr;
        this.f1603a = z;
        return (BUILDER) getThis();
    }

    public BUILDER y(REQUEST request) {
        this.f1605b = request;
        return (BUILDER) getThis();
    }

    public BUILDER z(REQUEST request) {
        this.c = request;
        return (BUILDER) getThis();
    }

    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(REQUEST request, boolean z) {
        return new b(request, h(), z);
    }
}
