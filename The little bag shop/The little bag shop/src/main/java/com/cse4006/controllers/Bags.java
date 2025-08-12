package com.cse4006.controllers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Bags {

    public static class Bag {
        private String name;
        private String colour;
        private String categoryID;
        private String price;

        public Bag(String name, String colour, String categoryID, String price) {
            this.name = name;
            this.colour = colour;
            this.categoryID = categoryID;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getColour() {
            return colour;
        }

        public String getCategoryID() {
            return categoryID;
        }

        public String getPrice() {
            return price;
        }
        
        @Override
        public String toString() {
            return name + "," + colour + "," + categoryID + "," + price;
        }
    }

    private final String fileName = "bags.txt";

    public List<Bag> loadBagsFromFile() {
        List<Bag> bagList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    bagList.add(new Bag(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bagList;
    }

    public void saveBagsToFile(List<Bag> bagList) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Bag bag : bagList) {
                bw.write(bag.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean insertBag(String name, String colour, String categoryID, String price) {
        Bag newBag = new Bag(name, colour, categoryID, price);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(newBag.toString());
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
