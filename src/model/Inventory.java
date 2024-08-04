package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory
{
    private static ObservableList<Cases> allCases = FXCollections.observableArrayList();
    private static ObservableList<Motherboards>allMotherBoards = FXCollections.observableArrayList();

    private static ObservableList<GraphicCards> allGraphicsCards = FXCollections.observableArrayList();
    private static ObservableList<PowerSupply>allPowerSupplies = FXCollections.observableArrayList();

    private static ObservableList<Processor> allProcessors = FXCollections.observableArrayList();
    private static ObservableList<Ram>allRam = FXCollections.observableArrayList();


    public static void addCase (Cases newCase)
    {
        allCases.add(newCase);
    }
    public static ObservableList<Cases> getAllCases()
    {

        return allCases;
    }
    public static ObservableList<GraphicCards> getAllGraphicsCards()
    {
        return allGraphicsCards;
    }

    public static ObservableList<Motherboards> getAllMotherBoards()
    {
        return allMotherBoards;
    }

    public static ObservableList<PowerSupply> getAllPowerSupplies()
    {
        return allPowerSupplies;
    }

    public static ObservableList<Processor> getAllProcessors()
    {
        return allProcessors;
    }

    public static ObservableList<Ram> getAllRam()
    {
        return allRam;
    }
    public static void addMotherBoard (Motherboards newMotherBoard)
    {
        allMotherBoards.add(newMotherBoard);
    }
    public static void addGraphicsCard ( GraphicCards newGraphicsCard)
    {
        allGraphicsCards.add(newGraphicsCard);
    }

    public static void addPowerSupply ( PowerSupply newPowerSupply)
    {
        allPowerSupplies.add(newPowerSupply);
    }

    public static void addProcessor ( Processor newProcessor)
    {
        allProcessors.add(newProcessor);
    }

    public static void addRam ( Ram newRam)
    {
        allRam.add(newRam);
    }

}
