import java.io.*;
import java.util.*;
import javax.swing.*;

class PersonInfo implements Serializable {
  String name;
  String address;
  String phoneNum;

  // parameterized constructor
  public PersonInfo(String n, String a, String p) {
    name = n;
    address = a;
    phoneNum = p;
  }

  // method for displaying person record on GUI
  public void printPersonInfo() {
    JOptionPane.showMessageDialog(null, "name: " + name + " address:" + address + " phone no:" + phoneNum);
  }

} // end class

class List {

  public static void main(String args[]) {

    PersonInfo pWrite = new PersonInfo("ali", "Lahore", "123456");
    PersonInfo pWrite1 = new PersonInfo("ahmed", "karachi", "23432423");

    try {

      // attaching FileOutput stream with "ali.txt"
      FileOutputStream fos = new FileOutputStream("ali.txt");

      // attaching ObjectOutput stream over FileOutput// stream
      ObjectOutputStream out = new ObjectOutputStream(fos);

      // serialization writing object to ‘ali.dat’
      out.writeObject(pWrite);
      out.writeObject(pWrite1);

      // closing streams
      out.close();
      fos.close();

    } catch (Exception ex) {
      System.out.println(ex);
    }

  } // end main method

} // end class

class ReadEx {

  public static void main(String args[]) {
    try {

      // attaching FileInput stream with "ali.txt"
      FileInputStream fis = new FileInputStream("ali.txt");

      // attaching FileInput stream over ObjectInput stream
      ObjectInputStream in = new ObjectInputStream(fis);

      // de-serialization reading object from ‘ali.txt’
      PersonInfo pRead = (PersonInfo) in.readObject();
      PersonInfo pRead1 = (PersonInfo) in.readObject();
      // calling printPersonInfo method to confirm that object contains same set of
      // values
      // before serializatoion
      pRead.printPersonInfo();
      pRead1.printPersonInfo();

      // closing streams
      in.close();
      fis.close();
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }// end of main method
} // end class

class ReadEx1 {

  public static void main(String args[]) {
    try {

      // attaching FileInput stream with "ali.txt"
      FileInputStream fis = new FileInputStream("ali.txt");

      // attaching FileInput stream over ObjectInput stream
      ObjectInputStream in = new ObjectInputStream(fis);

      PersonInfo temp;
      boolean isExist = true;

      while (isExist) {
        if (fis.available() != 0) {
          temp = (PersonInfo) in.readObject();
          temp.printPersonInfo();
        } else {
          isExist = false;
        }
      }

      // closing streams
      in.close();
      fis.close();
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }// end of main method
} // end class
