package com.huachenjie.social_contact.page.suit;

import androidx.coroutines.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huachenjie.social_contact.databinding.FragmentUserWearSuitBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/material/tabs/TabLayoutMediator;", BridgeDSL.INVOKE}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class UserWearSuitFragment$tabLayoutMediator$2 extends Lambda implements Function0<TabLayoutMediator> {
    final /* synthetic */ UserWearSuitFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserWearSuitFragment$tabLayoutMediator$2(UserWearSuitFragment userWearSuitFragment) {
        super(0);
        this.this$0 = userWearSuitFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(UserWearSuitFragment userWearSuitFragment, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(userWearSuitFragment, "this$0");
        Intrinsics.checkNotNullParameter(tab, "tab");
        tab.setText(userWearSuitFragment.getMAdapter().d(i));
    }

    @NotNull
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final TabLayoutMediator m765invoke() {
        ViewDataBinding binding = this.this$0.getBinding();
        Intrinsics.checkNotNull(binding, "null cannot be cast to non-null type com.huachenjie.social_contact.databinding.FragmentUserWearSuitBinding");
        FragmentUserWearSuitBinding fragmentUserWearSuitBinding = (FragmentUserWearSuitBinding) binding;
        TabLayout tabLayout = fragmentUserWearSuitBinding.f12931a;
        ViewPager2 viewPager2 = fragmentUserWearSuitBinding.f36167a;
        final UserWearSuitFragment userWearSuitFragment = this.this$0;
        return new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.huachenjie.social_contact.page.suit.a
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                UserWearSuitFragment$tabLayoutMediator$2.invoke$lambda$0(userWearSuitFragment, tab, i);
            }
        });
    }
}
