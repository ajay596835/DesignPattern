package structural.AdapterDesignPattern.Client;


import structural.AdapterDesignPattern.Adaptee.WeightMachineForBabies;
import structural.AdapterDesignPattern.Adapter.WeightMachineAdapter;
import structural.AdapterDesignPattern.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]){

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
