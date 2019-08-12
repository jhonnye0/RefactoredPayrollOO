package memento;

import empresa.empregados.Employee;
import empresa.sindicato.Union;

import java.util.ArrayList;

public class Memento {

    private ArrayList<Employee> emp = new ArrayList<>(100);
    private ArrayList<Union> un = new ArrayList<>(100);

    public Memento(ArrayList<Employee> employees, ArrayList<Union> unions){

        if (employees != null && unions != null) {
            for (Employee e : employees) {

                    System.out.println(e.getId());

                    emp.add(e.getId(), e.makeCopy());
                    un.add(e.getUnionID() - 10000, unions.get(e.getUnionID() - 10000).makeCopy());
            }
        }
    }

    public ArrayList<Employee> getEmp() {
        return emp;
    }

    public void setEmp(ArrayList<Employee> emp) {
        this.emp = emp;
    }

    public ArrayList<Union> getUn() {
        return un;
    }

    public void setUn(ArrayList<Union> un) {
        this.un = un;
    }
}
