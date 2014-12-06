package cc.broz.j_cs_refresh;

public class RepresentativeInteger<I extends Radixable> implements IntCastable {
    private int digitPlace;
    private int lengthToCompare;
    private I r;
    
    
    RepresentativeInteger(I r, int digitPlace, int lengthToCompare) {
        this.r = r;
        this.digitPlace = digitPlace;
        this.lengthToCompare = lengthToCompare;
    }

    public int intValue() {
        return r.getDigit(this.digitPlace, lengthToCompare);
    }

    public I getItem() {
        return r;
    }
}
