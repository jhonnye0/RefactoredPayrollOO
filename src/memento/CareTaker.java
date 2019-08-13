package memento;

import facade.Empresa;

import java.util.*;

public class CareTaker implements UROperation {

    private List<Empresa> states = new ArrayList<>();

    public void save(Originator state){
        this.states.add(state.save());
    }

    public void undo(Originator state){

        if(states.size() > 1) {
            state.undoToLastSave(states.remove(states.size()-2));
        }else if(states.size() == 1){
            state.undoToLastSave(new Empresa());
            states.add(0, state.memento);
        } else {
            System.out.println("Nao e possivel fazer mais operacoes");
        }
    }
}
