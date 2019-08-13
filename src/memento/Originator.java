package memento;

import facade.Empresa;

public class Originator {

    Empresa memento;

    public Originator(Empresa memento){
        this.memento = new Empresa(memento.getList(), memento.getUnion());
    }

    public Empresa getCompany(){ return new Empresa(this.memento.getList(), this.memento.getUnion());  }

    public void setState(Empresa memento) {
        this.memento = new Empresa(memento.getList(), memento.getUnion());
    }

    Empresa save(){ return new Empresa(this.memento.getList(), this.memento.getUnion()); }

    void undoToLastSave(Empresa state){
        this.memento = new Empresa(state.getList(), state.getUnion());
    }
}
