package server.model;

import java.io.*;
import java.util.*;

public class UserList
{
  private ArrayList<User> userLists;
  private String filename = "Profiles.txt";
  private ArrayList<String> fileList;
  private File file;
  private FileReader reader;
  private BufferedReader bufferedReader;
  private FileWriter writer;

  public UserList() throws IOException
  {
    file = new File(filename);
    try {
      file.createNewFile();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    reader = new FileReader(file);
    bufferedReader = new BufferedReader(reader);
    writer = new FileWriter(file, true);
    this.userLists = new ArrayList<>();

    insertFileIntoModule();
  }

  public void insertFileIntoModule() throws IOException
  {
    addDummyData();
    fileList = new ArrayList<>(Arrays.asList(bufferedReader.readLine().split(";:;")));
    for (int x = 0; x < fileList.size(); x = x + 2){
      userLists.add(new User(fileList.get(x), fileList.get(x+1)));
    }
  }

  public void addDummyData() throws IOException
  {
    writer.write( ";:;" +  ";:;");
    writer.close();
  }

  public void addProfile(String name, String password) throws IOException
  {
    System.out.println(name);
    writer = new FileWriter(file, true);
    userLists.add(new User(name, password));
    writer.write(name + ";:;" + password + ";:;");
    writer.close();
  }
  public boolean nameExist(String name){
    for(User x:userLists){
      if(x.getName().equals(name)){
        return true;
      }
    }
    return false;
  }
  public boolean userExist(String name, String password){
    for(User x:userLists){
      if(x.getName().equals(name) && x.getPassword().equals(password)){
        return true;
      }
    }
    return false;
  }
}
