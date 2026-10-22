package bolts;

import com.zj.adlib.cz0;
import com.zj.adlib.fe1;
import com.zj.adlib.y50;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Exception f231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f232a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<Continuation<TResult, Void>> f233a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f234a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TResult f235b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f236b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ExecutorService f230a = cz0.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Executor f21516a = cz0.b();
    public static final Executor b = y50.d();

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21517a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k f237a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f238a;

        /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
        /* JADX INFO: renamed from: bolts.b$a$a, reason: collision with other inner class name */
        public class C0032a<TContinuationResult> implements Continuation<TContinuationResult, Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f21518a;

            public C0032a(a aVar) {
            }

            @Override // bolts.Continuation
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void a(b<TContinuationResult> bVar) {
            }
        }

        public a(Continuation continuation, b bVar, k kVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    /* JADX INFO: renamed from: bolts.b$b, reason: collision with other inner class name */
    public class C0033b implements Continuation<TResult, b<Void>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21519a;

        public C0033b(b bVar) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b<Void> a(b<TResult> bVar) throws Exception {
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f21520a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Callable f239a;

        public c(k kVar, Callable callable) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static class d implements Continuation<Object, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f21521a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f240a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ArrayList f241a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicBoolean f242a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicInteger f243a;

        public d(Object obj, ArrayList arrayList, AtomicBoolean atomicBoolean, AtomicInteger atomicInteger, k kVar) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(b<Object> bVar) {
        }
    }

    public class e implements Continuation<Void, b<Void>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21522a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f244a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ fe1 f245a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Callable f246a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f247a;

        public e(b bVar, Callable callable, Continuation continuation, Executor executor, fe1 fe1Var) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b<Void> a(b<Void> bVar) throws Exception {
        }
    }

    public class f implements Continuation<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21523a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k f248a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f249a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f250a;

        public f(b bVar, k kVar, Continuation continuation, Executor executor) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(b<TResult> bVar) {
        }
    }

    public class g implements Continuation<TResult, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21524a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k f251a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f252a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f253a;

        public g(b bVar, k kVar, Continuation continuation, Executor executor) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(b<TResult> bVar) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    public class h<TContinuationResult> implements Continuation<TResult, b<TContinuationResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21525a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f254a;

        public h(b bVar, Continuation continuation) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b<TContinuationResult> a(b<TResult> bVar) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [TContinuationResult] */
    public class i<TContinuationResult> implements Continuation<TResult, b<TContinuationResult>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21526a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f255a;

        public i(b bVar, Continuation continuation) {
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b<TContinuationResult> a(b<TResult> bVar) {
        }
    }

    public static class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f21527a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ k f256a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ b f257a;

        public j(Continuation continuation, b bVar, k kVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f21528a;

        public /* synthetic */ k(b bVar, C0033b c0033b) {
            this(bVar);
        }

        public b<TResult> a() {
            return this.f21528a;
        }

        public void b() {
        }

        public void c(Exception exc) {
        }

        public boolean d() {
        }

        public boolean e(Exception exc) {
        }

        public boolean f(TResult tresult) {
        }

        public void setResult(TResult tresult) {
        }

        public k(b bVar) {
        }
    }

    public static b<Void> J(Collection<? extends b<?>> collection) {
    }

    public static <TResult> b<TResult> call(Callable<TResult> callable, Executor executor) {
    }

    public static <TResult> b<TResult> j(Callable<TResult> callable) {
    }

    public static <TResult> b<TResult> k() {
    }

    public static <TContinuationResult, TResult> void m(b<TContinuationResult>.k kVar, Continuation<TResult, b<TContinuationResult>> continuation, b<TResult> bVar, Executor executor) {
    }

    public static <TContinuationResult, TResult> void n(b<TContinuationResult>.k kVar, Continuation<TResult, TContinuationResult> continuation, b<TResult> bVar, Executor executor) {
    }

    public static <TResult> b<TResult>.k u() {
    }

    public static <TResult> b<TResult> v(Exception exc) {
    }

    public static <TResult> b<TResult> w(TResult tresult) {
    }

    public boolean A() {
    }

    public boolean B() {
    }

    public b<Void> C() {
    }

    public <TContinuationResult> b<TContinuationResult> D(Continuation<TResult, TContinuationResult> continuation) {
    }

    public <TContinuationResult> b<TContinuationResult> E(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
    }

    public <TContinuationResult> b<TContinuationResult> F(Continuation<TResult, b<TContinuationResult>> continuation) {
    }

    public <TContinuationResult> b<TContinuationResult> G(Continuation<TResult, b<TContinuationResult>> continuation, Executor executor) {
    }

    public final void H() {
    }

    public void I() throws InterruptedException {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TOut> b<TOut> l() {
        return this;
    }

    public b<Void> o(Callable<Boolean> callable, Continuation<Void, b<Void>> continuation) {
    }

    public b<Void> p(Callable<Boolean> callable, Continuation<Void, b<Void>> continuation, Executor executor) {
    }

    public <TContinuationResult> b<TContinuationResult> q(Continuation<TResult, TContinuationResult> continuation) {
    }

    public <TContinuationResult> b<TContinuationResult> r(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
    }

    public <TContinuationResult> b<TContinuationResult> s(Continuation<TResult, b<TContinuationResult>> continuation) {
    }

    public <TContinuationResult> b<TContinuationResult> t(Continuation<TResult, b<TContinuationResult>> continuation, Executor executor) {
    }

    public Exception x() {
    }

    public TResult y() {
    }

    public boolean z() {
    }

    public static <TResult> b<TResult> call(Callable<TResult> callable) {
    }
}
