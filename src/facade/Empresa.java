package facade;

import java.util.ArrayList;
import empresa.agendas.Schedule;
import empresa.empregados.Employee;
import empresa.sindicato.Union;

public class Empresa {

        private ArrayList<Employee> list = new ArrayList<>(100);
        private ArrayList<Union> union = new ArrayList<>(100);
        private ArrayList<Schedule> agendas = new ArrayList<>(100);

        public ArrayList<Employee> getList() {
            return list;
        }

        public void setList(ArrayList<Employee> list) {
            this.list = list;
        }

        public ArrayList<Union> getUnion() {
            return union;
        }

        public void setUnion(ArrayList<Union> union) {
            this.union = union;
        }

        public ArrayList<Schedule> getAgendas() {
            return agendas;
        }

        public void setAgendas(ArrayList<Schedule> agendas) {
            this.agendas = agendas;
        }
}
