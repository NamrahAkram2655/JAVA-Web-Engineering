import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class noAccountAvailableException extends Exception{

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Exception: noAccountAvailableException";
    }
}
class inSufficientBalance extends Exception{

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Exception: inSufficientBalance";
    }
}
public class Bank{
    
    static String filepath="F:\\JAVA-LABS\\account.txt";
    String name;
    String accNum;
    int amount;

    Bank(String name,String accNum,int amount)
    {
       
        this.name=name;
        this.accNum=accNum;
        this.amount=amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumber(String accNum) {
        this.accNum = accNum;
    }
    public int getAmount() {
        return amount;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return accNum;
    }

    public static void addRecord(String name,String accNum,int amount)
    {
        
        try {
            FileWriter writer=new FileWriter(filepath,true);
            BufferedWriter bw=new BufferedWriter(writer);
            
            bw.write(name+";"+accNum+";"+amount+";"+"\n");
            bw.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
    public static void transfer(String senderNumber,String recipientNumber,int transferAmount)
    {
        ArrayList<Bank> list=new ArrayList<Bank>();
        loadFile(list);

        try {
            
        
        int sender_Index=-1;
        int recipient_Index=-1;

        for (int i = 0; i < list.size(); i++) {
            
            if (list.get(i).getNumber().equals(senderNumber)) 
            {
                //Check if balance is sufficient or not
                if (list.get(i).getAmount()<transferAmount) {
                    throw new inSufficientBalance();
                }
                else
                {
                    sender_Index=i;
                }
            }
            else if(list.get(i).getNumber().equals(recipientNumber))
            {
                recipient_Index=i;
            }
        }
        // Check if Recipient Exists
        if (recipient_Index==-1) {
            throw new noAccountAvailableException();
        }

        Bank senderData=list.get(sender_Index);

        //add updated amount in sender's account 
        list.set(sender_Index, new Bank(senderData.getName(), senderData.getNumber(), senderData.getAmount()-transferAmount));

        Bank receiverData=list.get(recipient_Index);

        //add updated amount in receiver's account 
        list.set(recipient_Index, new Bank(receiverData.getName(), receiverData.getNumber(), receiverData.getAmount()+transferAmount));

        //Save updated data to file
        save(list);

        } catch (inSufficientBalance e) {
            System.out.println(e);
        }catch(noAccountAvailableException e)
        {
            System.out.println(e);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void loadFile(ArrayList<Bank> list)
    {
        boolean ValidRecipient=false;
        
        try {
            FileReader fr=new FileReader(filepath);
            BufferedReader br=new BufferedReader(fr);

            while (br.ready()) {
                String [] data=br.readLine().split(";");
                Bank obj=new Bank(data[0], data[1], Integer.parseInt(data[2]));
                list.add(obj);
            }
            br.close();
            fr.close();
    }
    catch(Exception e){
        System.out.println(e);
    }
}
    public static void save(ArrayList<Bank> list)
    {
        try {
            FileWriter writer=new FileWriter(filepath);
            BufferedWriter bw=new BufferedWriter(writer);
            
            for (int j = 0; j < list.size(); j++) {
                Bank obj=list.get(j);
                bw.write(obj.getName()+";"+obj.getNumber()+";"+obj.getAmount()+";"+"\n");                
            }
            System.out.println("Data updated in File");
            bw.close();
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
    
        Scanner sc =new Scanner(System.in);

        Scanner str=new Scanner(System.in);

        while (true) {
            System.out.println("1 -> Add new Record");
            System.out.println("2 -> Transfer");
            System.out.println("3 -> Exit");

            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name=sc.nextLine();
                    
                    System.out.print("Enter account number: ");
                    String accNum=sc.nextLine();
                    
                    System.out.print("Enter Amount: ");
                    int amount=sc.nextInt();

                    sc.nextLine(); // Consume the newline character

                    addRecord(name,accNum,amount);
                    break;
            
                case 2:
                    System.out.print("Enter Sender's Account Number: ");
                    String senderNum=sc.nextLine();
                    
                    System.out.print("Enter Receiver's Account Number: ");
                    String RecNum=sc.nextLine();
                    
                    System.out.print("Enter Transfer Amount: ");
                    int transferAmount=sc.nextInt();

                    sc.nextLine(); // Consume the newline character
                    
                    transfer(senderNum, RecNum,transferAmount);
                    break;
                
                case 3:
                    System.out.println("Exiting");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

}