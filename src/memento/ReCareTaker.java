package memento;

import empresa.empregados.Employee;
import empresa.sindicato.Union;

import java.util.ArrayList;
import java.util.List;

public class ReCareTaker {

    private int index;
    private List<Memento> states = new ArrayList<>();

    public void save(Originator state){
        index++;
        this.states.add(state.save());
    }

    public void undo(Originator state){

        if(index > 1) {

            state.undoToLastSave(states.get(index - 2));
            index -= 2;
        }else{
            ArrayList<Employee> list = new ArrayList<>(100);
            ArrayList<Union> union = new ArrayList<>(100);
            Originator o = new Originator(new Memento(list, union));
            state.undoToLastSave(o.save());
        }
    }

    public void clear(){
        index = 0;
        states.clear();
    }

}
