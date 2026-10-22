package com.zj.adlib;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.netease.nimlib.sdk.Observer;
import com.netease.nimlib.sdk.msg.model.RecentContact;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class yt1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, RecentContact> f20925a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Observer<List<RecentContact>>> f46113a = new ArrayList();
    public final List<Observer<RecentContact>> b = new ArrayList();

    public static /* synthetic */ int l(RecentContact recentContact, RecentContact recentContact2) {
        long time = recentContact.getTime();
        long time2 = recentContact2.getTime();
        if (time > time2) {
            return -1;
        }
        return time < time2 ? 1 : 0;
    }

    public void b(RecentContact recentContact) {
        this.f20925a.put(recentContact.getContactId(), recentContact);
    }

    public void c(Observer<List<RecentContact>> observer) {
        if (this.f46113a.contains(observer)) {
            return;
        }
        this.f46113a.add(observer);
    }

    public void d(Observer<RecentContact> observer) {
        if (this.b.contains(observer)) {
            return;
        }
        this.b.add(observer);
    }

    public void e() {
        this.f20925a.clear();
        this.f46113a.clear();
        this.b.clear();
    }

    public boolean f(String str) {
        return this.f20925a.containsKey(str);
    }

    public int g() {
        return this.f20925a.size();
    }

    @Nullable
    public RecentContact h(String str) {
        return this.f20925a.get(str);
    }

    public List<RecentContact> i() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.f20925a.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(this.f20925a.get(it.next()));
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.zj.adlib.xt1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return yt1.l((RecentContact) obj, (RecentContact) obj2);
            }
        });
        return arrayList;
    }

    public int j() {
        Map<String, RecentContact> map = this.f20925a;
        int unreadCount = 0;
        if (map != null && map.size() != 0) {
            Iterator<String> it = this.f20925a.keySet().iterator();
            while (it.hasNext()) {
                RecentContact recentContact = this.f20925a.get(it.next());
                if (recentContact != null) {
                    unreadCount += recentContact.getUnreadCount();
                }
            }
        }
        return unreadCount;
    }

    public int k(List<String> list) {
        int unreadCount = 0;
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                RecentContact recentContact = this.f20925a.get(it.next());
                if (recentContact != null) {
                    unreadCount += recentContact.getUnreadCount();
                }
            }
        }
        return unreadCount;
    }

    public void m(List<RecentContact> list) {
        Iterator<Observer<List<RecentContact>>> it = this.f46113a.iterator();
        while (it.hasNext()) {
            it.next().onEvent(list);
        }
    }

    public void n(RecentContact recentContact) {
        Iterator<Observer<RecentContact>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().onEvent(recentContact);
        }
    }

    public void o(String str) {
        this.f20925a.remove(str);
    }

    public void p(Observer<List<RecentContact>> observer) {
        this.f46113a.remove(observer);
    }

    @UiThread
    public void q(Observer<RecentContact> observer) {
        this.b.remove(observer);
    }
}
