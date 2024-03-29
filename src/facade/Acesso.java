package facade;

import empresa.agendas.Time;
import memento.*;

public class Acesso {

    private int total = 0;
    private ExceptionCatch except = new ExceptionCatch();
    private Admin adm = new Admin();
    private User user = new User();
    private Time time = new Time();
    private CareTaker careTaker = new CareTaker();
    private ReCareTaker reCareTaker = new ReCareTaker();
    private Originator originator;

    public void access() {

        Empresa empresa = new Empresa();
        ExceptionCatch except = new ExceptionCatch();
        originator = new Originator(empresa);
        careTaker.save(originator);

        while (true)
        {
            System.out.println("\n----------------------------------\n");
            System.out.println("\nModo de acesso: (Digite o numero)\n" +
                    "0. Encerrar acesso\n" +
                    "1. Admin\n" +
                    "2. Empregado\n" +
                    "3. Setar/Checar Tempo\n");

            int op = except.numcheckException(0,3);

            switch (op){
                case 0:
                    return;
                case 1:
                    setTotal(adm.admin(new Manager(), time, total, empresa, careTaker, reCareTaker, originator));
                    break;
                case 2:
                    getEmployeeData(empresa);
                    break;
                case 3:
                    time.Do();
                    break;
            }
        }
    }

    private void setTotal(int total){
        this.total = total;
    }

    private int getEmployeeData(Empresa empresa) {
        System.out.println("Digite seu ID:");
        int id = except.numcheckException(0,-1);

        try {
            if(empresa.getList().get(id) != null){
                user.user(empresa.getList().get(id), time, empresa, careTaker, originator);
            }
        }catch (Exception e){
            System.out.println("Empregado nao registrado ainda!");
        }
        return id;
    }
}
