package memento;

import facade.Empresa;

public class Originator {

    Empresa memento;

    public Originator(Empresa memento){
        this.memento = new Empresa(memento.getList());
    }

    public Empresa getCompany(){ return new Empresa(this.memento.getList());  }

    public void setState(Empresa memento) {
        this.memento = new Empresa(memento.getList());
    }

    Empresa save(){ return new Empresa(this.memento.getList()); }

    void undoToLastSave(Empresa state){
        this.memento = new Empresa(state.getList());
    }
}
