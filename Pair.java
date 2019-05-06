class Pair<T extends Object, P extends Object> {
    private T t;
    private P p;

    public Pair(T a, P b) {
        t = a;
        p = b;
    }

    public static <T, P> Pair of(T c, P d) {
        return new Pair<T, P>(c, d);
    }

    public T getFirst() {
        return t;
    }

    public P getSecond() {
        return p;
    }

    public boolean equals(Pair<T, P> ff) {
        if (this == ff)
            return true;
        if (this == null)
            return false;
        if (null == this.t) {
            if (null == this.p)
                return null == ff.p && null == ff.t;
            return null == ff.t && this.p.equals(ff.p);
        }
        if (null == this.p)
            return null == ff.p && this.t.equals(ff.t);
        return this.t.equals(ff.t) && this.p.equals(ff.p);
    }

    public int hashCode() {
        if (this == null)
            return 0;
        if (t == null) {
            if (p == null)
                return 0;
            return p.hashCode();
        }
        if (p == null)
            return t.hashCode() * 23;
        return t.hashCode() * 23 + p.hashCode();
    }
}