package test;

import entities.Machine;
import entities.Salle;
import lombok.Builder;
import services.MachineService;
import services.SalleService;

import java.util.Date;
@Builder
public class Test{
    public static void main(String[] args){
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();
        Salle salle1 = Salle.builder().code("A1").build();
        Salle salle2 = Salle.builder().code("B2").build();
        salleService.create(salle1);
        salleService.create(salle2);
        Machine machine1 = Machine.builder().ref("M123").dateAchat(new Date()).salle(salleService.findById(1)).build();
        Machine machine2 = Machine.builder().ref("M124").dateAchat(new Date()).salle(salleService.findById(2)).build();
        machineService.create(machine1);
        machineService.create(machine2);
        for(Salle salle : salleService.findAll()) { System.out.println("Salle: " + salle.getCode());
            for(Machine machine : salle.getMachines()) {
                System.out.println(" Machine: "+ machine.getRef());
            }
        }
        Date d1 = new Date(110, 0, 1);
        Date d2 = new Date();
        System.out.println("Machines achetées entre "+d1+":"+d2);
        for (Machine m : machineService.findBetweenDate(d1, d2)) {
            System.out.println(m.getRef() + " achetée le"+ m.getDateAchat());
        }
    }
}
