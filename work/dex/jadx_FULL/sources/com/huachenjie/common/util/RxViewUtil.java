package com.huachenjie.common.util;

import android.view.View;
import android.widget.TextView;
import com.zj.adlib.d60;
import com.zj.adlib.so7;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class RxViewUtil {

    public interface CharSequenceValidAction {
        boolean a(CharSequence charSequence1);

        boolean b(CharSequence charSequence2);
    }

    public interface ClickAction {
        void onClick();
    }

    public interface CountDownAction {
        void a(long value);

        void onFinish();
    }

    public class a implements Observer<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ClickAction f33907a;

        public a(final ClickAction val$action) {
            this.f33907a = val$action;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Void aVoid) {
            ClickAction clickAction = this.f33907a;
            if (clickAction != null) {
                clickAction.onClick();
            }
        }

        public void onCompleted() {
        }

        public void onError(Throwable e) {
            e.printStackTrace();
        }
    }

    public class b implements Action1<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33908a;

        public b(final View val$view) {
            this.f33908a = val$view;
        }

        public void call(Void aVoid) {
            so7.j(this.f33908a).call(Boolean.FALSE);
        }
    }

    public class c implements Observer<Long> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f33909a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CountDownAction f8892a;

        public c(final CountDownAction val$action, final TextView val$view, final int val$wholeSecond) {
            this.f8892a = val$action;
            this.f33909a = val$view;
            this.K = val$wholeSecond;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long aLong) {
            CountDownAction countDownAction = this.f8892a;
            if (countDownAction != null) {
                countDownAction.a(((long) this.K) - aLong.longValue());
            }
        }

        public void onCompleted() {
            CountDownAction countDownAction = this.f8892a;
            if (countDownAction != null) {
                countDownAction.onFinish();
            }
            so7.j(this.f33909a).call(Boolean.TRUE);
        }

        public void onError(Throwable e) {
            e.printStackTrace();
        }
    }

    public class d implements Observer<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownAction f33910a;

        public d(final CountDownAction val$action) {
            this.f33910a = val$action;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(Long aLong) {
            CountDownAction countDownAction = this.f33910a;
            if (countDownAction != null) {
                countDownAction.a(aLong.longValue());
            }
        }

        public void onCompleted() {
            CountDownAction countDownAction = this.f33910a;
            if (countDownAction != null) {
                countDownAction.onFinish();
            }
        }

        public void onError(Throwable e) {
            e.printStackTrace();
        }
    }

    public class e implements Action1<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f33911a;

        public e(final View val$view) {
            this.f33911a = val$view;
        }

        public void call(Boolean aBoolean) {
            so7.j(this.f33911a).call(aBoolean);
        }
    }

    public class f implements Func2<CharSequence, CharSequence, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequenceValidAction f33912a;

        public f(final CharSequenceValidAction val$action) {
            this.f33912a = val$action;
        }

        public Boolean call(CharSequence charSequence1, CharSequence charSequence2) {
            return Boolean.valueOf(this.f33912a.a(charSequence1) && this.f33912a.b(charSequence2));
        }
    }

    public static void a(View view, Observable<CharSequence> observable1, Observable<CharSequence> observable2, CharSequenceValidAction action) {
        Observable.o0(observable1, observable2, new f(action)).r5(new e(view));
    }

    public static Observable b(View view, long waitDuration) {
        return so7.e(view).U5(waitDuration, TimeUnit.MILLISECONDS).u5(d60.c()).J1(new b(view));
    }

    public static Subscription c(TextView view, int wholeSecond, final CountDownAction action) {
        return Observable.H2(1L, TimeUnit.SECONDS, d60.c()).B5(wholeSecond).o5(new c(action, view, wholeSecond));
    }

    public static Subscription d(long initialDelay, long interval, int totalCount, final CountDownAction action) {
        return e(initialDelay, interval, totalCount, TimeUnit.SECONDS, action);
    }

    public static Subscription e(long initialDelay, long interval, int times, TimeUnit unit, final CountDownAction action) {
        return Observable.F2(initialDelay, interval, unit, d60.c()).B5(times).o5(new d(action));
    }

    public static void f(View view, long waitDuration, final ClickAction action) {
        so7.e(view).U5(waitDuration, TimeUnit.MILLISECONDS).u5(d60.c()).o5(new a(action));
    }
}
