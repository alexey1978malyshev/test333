import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        Path path = Paths.get("src/INPUT2.txt");
        Scanner sc = new Scanner(path);
        List<Integer> dataList = new ArrayList<>();




        while (sc.hasNext()) {
            dataList.add(Integer.valueOf(sc.next()));

        }
        sc.close();

        System.out.println(dataList);

        int lengthOfdataList = dataList.toArray().length;

        System.out.println(dataList.subList(2, lengthOfdataList));

        List<Integer> listPass = dataList.subList(2, lengthOfdataList);
        int lengthOflistPass = listPass.toArray().length;
        int countOfBoats = 0;

        int i = 0;
        int j = lengthOflistPass - 1;
        for (i = 0; i <= j; ) {


                if (listPass.get(i) + listPass.get(j) <= dataList.get(1)) {
                    countOfBoats++;
                    i++;
                    j--;


                }

                if (listPass.get(i) + listPass.get(j) > dataList.get(1) && listPass.get(i) > listPass.get(j) && listPass.get(i)<=dataList.get(1)) {
                    countOfBoats++;
                    i++;

                    //break;

                }
                if (listPass.get(i) + listPass.get(j) > dataList.get(1) && listPass.get(i) < listPass.get(j) && listPass.get(j)<=dataList.get(1)) {
                    countOfBoats++;
                    j--;

                }
                if(i==j) {
                    countOfBoats++;
                    break;
                }



        }
        System.out.println(countOfBoats);
        try(FileWriter writer = new FileWriter("OUTPUT.TXT", false))
        {
            // запись всей строки
            String text = String.valueOf(countOfBoats);
            writer.write(text);
            // запись по символам
            //writer.append('\n');
            // writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }


    }
}


