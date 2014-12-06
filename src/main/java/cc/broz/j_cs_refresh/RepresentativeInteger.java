package cc.broz.j_cs_refresh;

public class RepresentativeInteger<I extends Radixable> {
    private int digitPlace;
    private I r;
    
    RepresentativeInteger(I r, int digitPlace) {
        this.r = r;
        this.digitPlace = digitPlace;
    }

    public int asInt() {
        return r.getDigit(this.digitPlace);
    }

    public I getItem() {
        return r;
    }
}
