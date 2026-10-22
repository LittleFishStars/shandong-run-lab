package com.huachenjie.run.adapter;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import com.huachenjie.run.bean.VideoInfoData;
import com.huachenjie.run.page.free_record.FreeRecordFragment;
import com.huachenjie.run.page.geofence.GeoFenceFragment;
import com.huachenjie.run.page.geofence.VideoGuideFragment;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB7\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001d\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010 \u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010 ¢\u0006\u0004\b(\u0010)J$\u0010\b\u001a\u00020\u00072\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J \u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\t2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J \u0010\u0018\u001a\u00020\u00072\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0015j\b\u0012\u0004\u0012\u00020\u000b`\u0016H\u0002R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001eR\u001c\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\"¨\u0006*"}, d2 = {"Lcom/huachenjie/run/adapter/GuideFragmentAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "", "data", "Lcom/huachenjie/run/bean/VideoInfoData;", "videoList", "", "m", "", "position", "Landroidx/fragment/app/Fragment;", "getItem", "getCount", "", "getPageTitle", "", "obj", "getItemPosition", "type", "k", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fragments", t.d, "Landroid/content/Context;", "a", "Landroid/content/Context;", "mCtx", "Landroidx/fragment/app/FragmentManager;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "c", "Ljava/util/List;", "titleList", "d", "fragmentList", "_titleList", "_fragmentList", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/util/List;Ljava/util/List;)V", "run_release"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nGuideFragmentAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GuideFragmentAdapter.kt\ncom/huachenjie/run/adapter/GuideFragmentAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,124:1\n1#2:125\n*E\n"})
public final class GuideFragmentAdapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final Context mCtx;

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public final FragmentManager fragmentManager;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public List<String> titleList;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @Nullable
    public List<Fragment> fragmentList;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    public static final int K = 1;
    public static final int L = 2;
    public static final int M = 3;

    /* JADX INFO: renamed from: com.huachenjie.run.adapter.GuideFragmentAdapter$a, reason: from kotlin metadata */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/huachenjie/run/adapter/GuideFragmentAdapter$a;", "", "", "TYPE_SPEED_REQUIREMENT", "I", "c", "()I", "TYPE_DISTANCE", "a", "TYPE_POINT", "b", "<init>", "()V", "run_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuideFragmentAdapter.L;
        }

        public final int b() {
            return GuideFragmentAdapter.M;
        }

        public final int c() {
            return GuideFragmentAdapter.K;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuideFragmentAdapter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @Nullable List<String> list, @Nullable List<Fragment> list2) {
        super(fragmentManager);
        Intrinsics.checkNotNullParameter(context, "mCtx");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.mCtx = context;
        this.fragmentManager = fragmentManager;
        this.titleList = list == null ? new ArrayList<>() : list;
        this.fragmentList = list2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.titleList.size();
    }

    @Override // androidx.fragment.app.FragmentPagerAdapter
    @NotNull
    public Fragment getItem(int position) {
        Fragment fragment;
        List<Fragment> list = this.fragmentList;
        boolean z = false;
        int size = list != null ? list.size() : 0;
        if (position >= 0 && position < size) {
            z = true;
        }
        if (!z) {
            FreeRecordFragment freeRecordFragmentNewInstance = FreeRecordFragment.newInstance(1);
            Intrinsics.checkNotNullExpressionValue(freeRecordFragmentNewInstance, "newInstance(SportConstants.TIME_TYPE.TYPE_WEEK)");
            return freeRecordFragmentNewInstance;
        }
        List<Fragment> list2 = this.fragmentList;
        if (list2 != null && (fragment = list2.get(position)) != null) {
            return fragment;
        }
        FreeRecordFragment freeRecordFragmentNewInstance2 = FreeRecordFragment.newInstance(1);
        Intrinsics.checkNotNullExpressionValue(freeRecordFragmentNewInstance2, "newInstance(SportConstants.TIME_TYPE.TYPE_WEEK)");
        return freeRecordFragmentNewInstance2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NotNull
    public CharSequence getPageTitle(int position) {
        return this.titleList.get(position);
    }

    public final String k(int type, List<VideoInfoData> videoList) {
        Object next;
        Integer type2;
        if (videoList.isEmpty()) {
            return "";
        }
        Iterator<T> it = videoList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            type2 = ((VideoInfoData) next).getType();
        } while (!(type2 != null && type == type2.intValue()));
        VideoInfoData videoInfoData = (VideoInfoData) next;
        if (videoInfoData != null) {
            return videoInfoData.getUrl();
        }
        return null;
    }

    public final void l(ArrayList<Fragment> fragments) {
        if (this.fragmentList != null) {
            FragmentTransaction fragmentTransactionBeginTransaction = this.fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
            List<Fragment> list = this.fragmentList;
            Intrinsics.checkNotNull(list);
            Iterator<Fragment> it = list.iterator();
            while (it.hasNext()) {
                fragmentTransactionBeginTransaction.remove(it.next());
            }
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            this.fragmentManager.executePendingTransactions();
        }
        List<Fragment> list2 = this.fragmentList;
        if (list2 != null) {
            list2.clear();
        }
        List<Fragment> list3 = this.fragmentList;
        if (list3 != null) {
            list3.addAll(fragments);
        }
        notifyDataSetChanged();
    }

    public final void m(@Nullable List<String> data, @NotNull List<VideoInfoData> videoList) {
        Intrinsics.checkNotNullParameter(videoList, "videoList");
        this.titleList.clear();
        if (data != null) {
            this.titleList.addAll(data);
        }
        ArrayList<Fragment> arrayList = new ArrayList<>();
        int size = this.titleList.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                arrayList.add(GeoFenceFragment.INSTANCE.a());
            } else if (i == 1) {
                VideoGuideFragment.Companion bVar = VideoGuideFragment.INSTANCE;
                int i2 = M;
                arrayList.add(bVar.a(i2, k(i2, videoList)));
            } else if (i == 2) {
                VideoGuideFragment.Companion bVar2 = VideoGuideFragment.INSTANCE;
                int i3 = L;
                arrayList.add(bVar2.a(i3, k(i3, videoList)));
            } else if (i == 3) {
                VideoGuideFragment.Companion bVar3 = VideoGuideFragment.INSTANCE;
                int i4 = K;
                arrayList.add(bVar3.a(i4, k(i4, videoList)));
            }
        }
        l(arrayList);
    }
}
