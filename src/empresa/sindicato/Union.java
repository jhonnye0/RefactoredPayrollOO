package empresa.sindicato;

public class Union {

    private boolean union;
    private double unionTax;

    public boolean isUnion() {
        return union;
    }

    public void setUnion(boolean union) {
        this.union = union;
    }

    protected double getUnionTax() {
        return unionTax;
    }

    public void setUnionTax(double unionTax) {
        this.unionTax = unionTax;
    }
}
