package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mi0<T> extends Event<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Priority f43308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f18221a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final T f18222a;

    public mi0(@Nullable Integer num, T t, Priority priority) {
        this.f18221a = num;
        if (t == null) {
            throw new NullPointerException("Null payload");
        }
        this.f18222a = t;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f43308a = priority;
    }

    @Override // com.google.android.datatransport.Event
    @Nullable
    public Integer a() {
        return this.f18221a;
    }

    @Override // com.google.android.datatransport.Event
    public T b() {
        return this.f18222a;
    }

    @Override // com.google.android.datatransport.Event
    public Priority c() {
        return this.f43308a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        Integer num = this.f18221a;
        if (num != null ? num.equals(event.a()) : event.a() == null) {
            if (this.f18222a.equals(event.b()) && this.f43308a.equals(event.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f18221a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f18222a.hashCode()) * 1000003) ^ this.f43308a.hashCode();
    }

    public String toString() {
        return "Event{code=" + this.f18221a + ", payload=" + this.f18222a + ", priority=" + this.f43308a + "}";
    }
}
