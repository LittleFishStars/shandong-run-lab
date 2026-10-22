package com.jakewharton.rxbinding.view;

import android.view.MenuItem;
import rx.Observable;
import rx.Subscriber;
import rx.android.MainThreadSubscription;
import rx.functions.Func1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements Observable.OnSubscribe<MenuItemActionViewEvent> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MenuItem f38634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Func1<? super MenuItemActionViewEvent, Boolean> f15000a;

    /* JADX INFO: renamed from: com.jakewharton.rxbinding.view.a$a, reason: collision with other inner class name */
    public class MenuItemOnActionExpandListenerC0933a implements MenuItem.OnActionExpandListener {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Subscriber f15001a;

        public MenuItemOnActionExpandListenerC0933a(Subscriber subscriber) {
            this.f15001a = subscriber;
        }

        public final boolean a(MenuItemActionViewEvent menuItemActionViewEvent) {
            if (!((Boolean) a.this.f15000a.call(menuItemActionViewEvent)).booleanValue()) {
                return false;
            }
            if (this.f15001a.isUnsubscribed()) {
                return true;
            }
            this.f15001a.onNext(menuItemActionViewEvent);
            return true;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return a(MenuItemActionViewEvent.b(a.this.f38634a, MenuItemActionViewEvent.Kind.COLLAPSE));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return a(MenuItemActionViewEvent.b(a.this.f38634a, MenuItemActionViewEvent.Kind.EXPAND));
        }
    }

    public class b extends MainThreadSubscription {
        public b() {
        }

        public void onUnsubscribe() {
            a.this.f38634a.setOnActionExpandListener(null);
        }
    }

    public a(MenuItem menuItem, Func1<? super MenuItemActionViewEvent, Boolean> func1) {
        this.f38634a = menuItem;
        this.f15000a = func1;
    }

    public void call(Subscriber<? super MenuItemActionViewEvent> subscriber) {
        MainThreadSubscription.a();
        MenuItemOnActionExpandListenerC0933a menuItemOnActionExpandListenerC0933a = new MenuItemOnActionExpandListenerC0933a(subscriber);
        subscriber.b(new b());
        this.f38634a.setOnActionExpandListener(menuItemOnActionExpandListenerC0933a);
    }
}
