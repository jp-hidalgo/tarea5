package tarea5;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsDisconnected {


    private static String pathName="C:\\Users\\Josue\\Documents\\Proyectos\\tarea5\\data\\distancesDisconnected.txt";
   private  int  vertices;

    private ArrayList[] adjTrue;


    public BfsDisconnected() {
        this.vertices=0;
        this.adjTrue= new ArrayList[99];
    }

    public  void getV(String pathNamea){
        File a = new File(pathName);

        BufferedReader br;

        {
            try {
                br = new BufferedReader(new FileReader(a) );
                try {
                    vertices=br.readLine().split("\t").length;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        for (int i=0; i<vertices; ++i){
            adjTrue[i] = new ArrayList();
    }

    }


public static void main(String[] args) throws IOException {
    BfsDisconnected obj=new BfsDisconnected();
    obj.run();
}



    public  void run() throws IOException {
        getV(pathName);
        File file = new File(pathName);
        try {
            BufferedReader br= new BufferedReader(new FileReader(file) );
            String[] st;
            String sf;
            int z=0;
           while ( (sf= br.readLine())!=null){
                st=sf.split("\t");
               for (int i=0;i<st.length;i++){

                   int parse= Integer.parseInt(st[i]);
                   adjTrue[z].add(parse);


               }
                z++;
           }
           BFS();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void BFS(){
     String why="";
        boolean [] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        why+="Bfs:";
        for (int i = 0; i <vertices ; i++) {
            if(!visited[i]){
                why+="("+i;
                queue.add(i);

                while(!queue.isEmpty()){

                    //get a vertex from queue
                    int vertex = queue.remove() ;

                    //mark the vertex visited
                    visited[vertex] = true;

                    for (int j=0;j<vertices;j++){
                        int aff = (int)adjTrue[i].get(j);

                        if (!visited[j] &&aff >=1){
                            why+=","+j;
                            visited[j]=true;
                        }
                        if (j==vertices-1){
                            why+=")";

                        }

                    }



                }

            }


        }
        String msg="{"+why+"}";
        System.out.println(msg);
    }
}
