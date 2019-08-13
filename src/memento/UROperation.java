package memento;

public interface UROperation {

    void save(Originator state);

    void undo(Originator state);
}
