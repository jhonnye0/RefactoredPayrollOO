package memento;

import empresa.empregados.Employee;
import empresa.sindicato.Union;
import java.util.ArrayList;

public class Originator {

    Memento memento;

    public Originator(Memento memento){
        this.memento = memento;
    }

    public ArrayList<Employee> getEmp() {
        return this.memento.getEmp();
    }

    public ArrayList<Union> getUn() {
        return this.memento.getUn();
    }

    public void setState(Memento memento) {
        this.memento = memento;
    }

    public Memento save(){ return new Memento(this.memento.getEmp(), this.memento.getUn()); }

    public void undoToLastSave(Memento state){
        this.memento = state;
    }
}
