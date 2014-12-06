package cc.broz.j_cs_refresh;

public class RepresentativeInteger<I extends Radixable> implements IntCastable {
    private int digitPlace;
    private I r;
    
    RepresentativeInteger(I r, int digitPlace) {
        this.r = r;
        this.digitPlace = digitPlace;
    }

    public int intValue() {
        return r.getDigit(this.digitPlace);
    }

    public I getItem() {
        return r;
    }
}
