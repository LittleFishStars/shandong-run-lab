package androidx.coroutines.adapters;

import android.widget.ExpandableListView;
import androidx.annotation.RestrictTo;
import androidx.coroutines.BindingMethod;
import androidx.coroutines.BindingMethods;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@BindingMethods({@BindingMethod(attribute = "android:onChildClick", method = "setOnChildClickListener", type = ExpandableListView.class), @BindingMethod(attribute = "android:onGroupClick", method = "setOnGroupClickListener", type = ExpandableListView.class), @BindingMethod(attribute = "android:onGroupCollapse", method = "setOnGroupCollapseListener", type = ExpandableListView.class), @BindingMethod(attribute = "android:onGroupExpand", method = "setOnGroupExpandListener", type = ExpandableListView.class)})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ExpandableListViewBindingAdapter {
}
