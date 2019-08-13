package memento;

import facade.Empresa;

import java.util.*;

public class CareTaker implements UROperation {

    private List<Empresa> states = new ArrayList<>();

    public void save(Originator state){
        this.states.add(state.save());
        System.out.println("Number of states: (UNDO) " + states.size());
    }

    public void undo(Originator state){

        if(states.size() > 1) {

            System.out.println("Maior 1");
            state.undoToLastSave(states.remove(states.size()-2));
        }else if(states.size() == 1){
            System.out.println("Igual 1");
            state.undoToLastSave(new Empresa());
            states.add(0, state.memento);
        } else {
            System.out.println("Nao e possivel fazer mais operacoes");
        }

        System.out.println("Number of states: (UNDO) " + states.size());
    }
}
