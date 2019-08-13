package memento;

import facade.Empresa;

import java.util.*;

public class ReCareTaker implements UROperation {

    private List<Empresa> states = new LinkedList<>();

    public void save(Originator state){
        this.states.add(state.save());
        System.out.println("Number of states: (UNDO) " + states.size());
    }

    public void undo(Originator state){

        if(!isEmpty()){
            state.undoToLastSave(states.remove(states.size()-1));
        }else{
            System.out.println("Nao e possivel fazer mais operacoes");
        }

        System.out.println("Number of states: (UNDO) " + states.size());
    }

    private boolean isEmpty(){
        return states.size() == 0;
    }
}
