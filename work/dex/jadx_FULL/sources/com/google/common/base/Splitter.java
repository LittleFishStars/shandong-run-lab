package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Splitter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31579a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharMatcher f5931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Strategy f5932a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5933a;

    public static abstract class SplittingIterator extends AbstractIterator<String> {
        public int K = 0;
        public int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharMatcher f31580a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final CharSequence f5934a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f5935a;

        public SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f31580a = splitter.f5931a;
            this.f5935a = splitter.f5933a;
            this.L = splitter.f31579a;
            this.f5934a = charSequence;
        }

        public abstract int b(int i);

        public abstract int c(int i);

        @Override // com.google.common.base.AbstractIterator
        @CheckForNull
        public String computeNext() {
            int i = this.K;
            while (true) {
                int i2 = this.K;
                if (i2 == -1) {
                    return endOfData();
                }
                int iC = c(i2);
                if (iC == -1) {
                    iC = this.f5934a.length();
                    this.K = -1;
                } else {
                    this.K = b(iC);
                }
                int i3 = this.K;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.K = i4;
                    if (i4 > this.f5934a.length()) {
                        this.K = -1;
                    }
                } else {
                    while (i < iC && this.f31580a.B(this.f5934a.charAt(i))) {
                        i++;
                    }
                    while (iC > i && this.f31580a.B(this.f5934a.charAt(iC - 1))) {
                        iC--;
                    }
                    if (!this.f5935a || i != iC) {
                        int i5 = this.L;
                        if (i5 == 1) {
                            iC = this.f5934a.length();
                            this.K = -1;
                            while (iC > i && this.f31580a.B(this.f5934a.charAt(iC - 1))) {
                                iC--;
                            }
                        } else {
                            this.L = i5 - 1;
                        }
                        return this.f5934a.subSequence(i, iC).toString();
                    }
                    i = this.K;
                }
            }
        }
    }

    public interface Strategy {
        Iterator<String> a(Splitter splitter, CharSequence charSequence);
    }

    public class a implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharMatcher f31581a;

        /* JADX INFO: renamed from: com.google.common.base.Splitter$a$a, reason: collision with other inner class name */
        public class C0711a extends SplittingIterator {
            public C0711a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int b(int i) {
                return i + 1;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int c(int i) {
                return a.this.f31581a.o(((SplittingIterator) this).f5934a, i);
            }
        }

        public a(CharMatcher charMatcher) {
            this.f31581a = charMatcher;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
            return new C0711a(splitter, charSequence);
        }
    }

    public class b implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f31583a;

        public class a extends SplittingIterator {
            public a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int b(int i) {
                return i + b.this.f31583a.length();
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int c(int i) {
                int length = b.this.f31583a.length();
                int length2 = ((SplittingIterator) this).f5934a.length() - length;
                while (i <= length2) {
                    for (int i2 = 0; i2 < length; i2++) {
                        if (((SplittingIterator) this).f5934a.charAt(i2 + i) != b.this.f31583a.charAt(i2)) {
                            i++;
                        }
                    }
                    return i;
                }
                return -1;
            }
        }

        public b(String str) {
            this.f31583a = str;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    public class c implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonPattern f31585a;

        public class a extends SplittingIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommonMatcher f31586a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c cVar, Splitter splitter, CharSequence charSequence, CommonMatcher commonMatcher) {
                super(splitter, charSequence);
                this.f31586a = commonMatcher;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int b(int i) {
                return this.f31586a.a();
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int c(int i) {
                if (this.f31586a.c(i)) {
                    return this.f31586a.f();
                }
                return -1;
            }
        }

        public c(CommonPattern commonPattern) {
            this.f31585a = commonPattern;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
            return new a(this, splitter, charSequence, this.f31585a.matcher(charSequence));
        }
    }

    public class d implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f31587a;

        public class a extends SplittingIterator {
            public a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int b(int i) {
                return i;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int c(int i) {
                int i2 = i + d.this.f31587a;
                if (i2 < ((SplittingIterator) this).f5934a.length()) {
                    return i2;
                }
                return -1;
            }
        }

        public d(int i) {
            this.f31587a = i;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    public class e implements Iterable<String> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ CharSequence f5936a;

        public e(CharSequence charSequence) {
            this.f5936a = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return Splitter.this.p(this.f5936a);
        }

        public String toString() {
            com.google.common.base.d dVarP = com.google.common.base.d.p(", ");
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            StringBuilder sbF = dVarP.f(sb, this);
            sbF.append(']');
            return sbF.toString();
        }
    }

    @Beta
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f31590a = "Chunk [%s] is not a valid entry";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Splitter f5937a;
        public final Splitter b;

        public /* synthetic */ f(Splitter splitter, Splitter splitter2, a aVar) {
            this(splitter, splitter2);
        }

        public Map<String, String> a(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f5937a.n(charSequence)) {
                Iterator itP = this.b.p(str);
                i.u(itP.hasNext(), f31590a, str);
                String str2 = (String) itP.next();
                i.u(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                i.u(itP.hasNext(), f31590a, str);
                linkedHashMap.put(str2, (String) itP.next());
                i.u(!itP.hasNext(), f31590a, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        public f(Splitter splitter, Splitter splitter2) {
            this.f5937a = splitter;
            this.b = (Splitter) i.E(splitter2);
        }
    }

    public Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.G(), Integer.MAX_VALUE);
    }

    public static Splitter e(int i) {
        i.e(i > 0, "The length may not be less than 1");
        return new Splitter(new d(i));
    }

    public static Splitter h(char c2) {
        return i(CharMatcher.q(c2));
    }

    public static Splitter i(CharMatcher charMatcher) {
        i.E(charMatcher);
        return new Splitter(new a(charMatcher));
    }

    public static Splitter j(CommonPattern commonPattern) {
        i.u(!commonPattern.matcher("").d(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new c(commonPattern));
    }

    public static Splitter k(String str) {
        i.e(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? h(str.charAt(0)) : new Splitter(new b(str));
    }

    @GwtIncompatible
    public static Splitter l(Pattern pattern) {
        return j(new JdkPattern(pattern));
    }

    @GwtIncompatible
    public static Splitter m(String str) {
        return j(h.b(str));
    }

    public Splitter f(int i) {
        i.k(i > 0, "must be greater than zero: %s", i);
        return new Splitter(this.f5932a, this.f5933a, this.f5931a, i);
    }

    public Splitter g() {
        return new Splitter(this.f5932a, true, this.f5931a, this.f31579a);
    }

    public Iterable<String> n(CharSequence charSequence) {
        i.E(charSequence);
        return new e(charSequence);
    }

    public List<String> o(CharSequence charSequence) {
        i.E(charSequence);
        Iterator<String> itP = p(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itP.hasNext()) {
            arrayList.add(itP.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> p(CharSequence charSequence) {
        return this.f5932a.a(this, charSequence);
    }

    public Splitter q() {
        return r(CharMatcher.X());
    }

    public Splitter r(CharMatcher charMatcher) {
        i.E(charMatcher);
        return new Splitter(this.f5932a, this.f5933a, charMatcher, this.f31579a);
    }

    @Beta
    public f s(char c2) {
        return t(h(c2));
    }

    @Beta
    public f t(Splitter splitter) {
        return new f(this, splitter, null);
    }

    @Beta
    public f u(String str) {
        return t(k(str));
    }

    public Splitter(Strategy strategy, boolean z, CharMatcher charMatcher, int i) {
        this.f5932a = strategy;
        this.f5933a = z;
        this.f5931a = charMatcher;
        this.f31579a = i;
    }
}
