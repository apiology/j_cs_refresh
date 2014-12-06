package cc.broz.j_cs_refresh;

public class RepresentativeInteger {
    private int digitPlace;
    private Radixable r;
    
    RepresentativeInteger(Radixable r, int digitPlace) {
        this.r = r;
        this.digitPlace = digitPlace;
    }

    public int asInt() {
        return r.getDigit(this.digitPlace);
    }
}
