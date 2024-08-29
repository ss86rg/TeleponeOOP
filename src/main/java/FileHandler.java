import java.io.*;


public class FileHandler implements Writable{
    public void save (Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream  = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Object read (String filePath){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


}
