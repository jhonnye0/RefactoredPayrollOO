package facade;

import java.util.ArrayList;
import empresa.agendas.Schedule;
import empresa.empregados.Employee;
import empresa.empregados.VAZIO;

public class Empresa {

        private ArrayList<Employee> list = new ArrayList<>(100);
        private ArrayList<Schedule> agendas = new ArrayList<>(100);

        public Empresa(ArrayList<Employee> list){

            int maior = -1;
            for(Employee e : list){
                if(e != null) {
                    if (e.getId() > maior) maior = e.getId();
                }
            }

            for (int i = 0; i <= maior; i++){
                this.list.add(i, new VAZIO());
            }

            for (Employee e : list) {

                if(e != null && !(e instanceof VAZIO) ) {
                    this.list.add(e.getId(), e.makeCopy());
                }
            }
        }

        public Empresa() {

        }

        public ArrayList<Employee> getList() {
            return list;
        }

        public void setList(ArrayList<Employee> list) {
            this.list = list;
        }

        public ArrayList<Schedule> getAgendas() {
            return agendas;
        }

        public void setAgendas(ArrayList<Schedule> agendas) {
            this.agendas = agendas;
        }
}
