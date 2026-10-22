package com.jakewharton.rxbinding.view;

import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class MenuItemActionViewEvent extends MenuItemEvent<MenuItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Kind f38630a;

    public enum Kind {
        EXPAND,
        COLLAPSE
    }

    public MenuItemActionViewEvent(@NonNull MenuItem menuItem, @NonNull Kind kind) {
        super(menuItem);
        this.f38630a = kind;
    }

    @NonNull
    @CheckResult
    public static MenuItemActionViewEvent b(@NonNull MenuItem menuItem, @NonNull Kind kind) {
        return new MenuItemActionViewEvent(menuItem, kind);
    }

    @NonNull
    public Kind c() {
        return this.f38630a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MenuItemActionViewEvent.class != obj.getClass()) {
            return false;
        }
        MenuItemActionViewEvent menuItemActionViewEvent = (MenuItemActionViewEvent) obj;
        return a().equals(menuItemActionViewEvent.a()) && this.f38630a == menuItemActionViewEvent.f38630a;
    }

    public int hashCode() {
        return (a().hashCode() * 31) + this.f38630a.hashCode();
    }

    public String toString() {
        return "MenuItemActionViewEvent{menuItem=" + a() + ", kind=" + this.f38630a + '}';
    }
}
