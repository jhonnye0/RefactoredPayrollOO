package empresa.empregados.comission;

public class Sells {
    private double[] arr = new double[32];

    public void registerSale(int day, double sale){
        this.arr[day] = sale;
    }

    public double getDaySale(int i){
        return this.arr[i];
    }

    public Sells makeCopy(){

        Sells sells = new Sells();

        int i;
        for(i = 0; i < 32; i++){
            sells.arr[i] = this.arr[i];
        }

        return sells;
    }
}