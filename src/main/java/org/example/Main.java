package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("homeWorkProperties.properties")) {

            Properties prop = new Properties();

            prop.load(input);

            //get the property value and print it out
            System.out.println(prop.getProperty("vards"));
            System.out.println(prop.getProperty("uzvards"));
            prop.replace("vards","Lagzdins");
            prop.replace("uzvards","Raimonds");
            System.out.println(prop.getProperty("vards"));
            System.out.println(prop.getProperty("uzvards"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try (OutputStream output = new FileOutputStream("src/main/resources/newProperties.properties")) {

            Properties prop = new Properties();

            prop.setProperty("vards", "Raimonds");

            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }


    }
}