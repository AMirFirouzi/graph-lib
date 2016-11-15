import java.io.IOException;
import java.util.Iterator;

/**
 * Created by amir on 11/9/16.
 */
public class Demo {
  public static void main(String[] args) {

    Graph g = new Graph();

    //Demo1-mine
//    g.addVertex("s1").addWeights(new String[]{"1", "1"});
//    g.addVertex("s2").addWeights(new String[]{"1", "2"});
//    g.addVertex("b1").addWeights(new String[]{"2", "1"});
//    g.addVertex("b2").addWeights(new String[]{"2", "2"});
//    g.addVertex("b3").addWeights(new String[]{"2", "3"});
//
//    g.addEdge("s1", "b1").setWeight("1");
//    g.addEdge("s1", "b2").setWeight("10");
//    g.addEdge("s2", "b1").setWeight("3");
//    g.addEdge("s2", "b2").setWeight("30");
//    g.addEdge("b1", "b3").setWeight("4");
//    g.addEdge("b2", "b3").setWeight("5");

//    Demo2-P-scheduler
    g.addVertex("1");
    g.addVertex("2");
    g.addVertex("3");
    g.addVertex("4");
    g.addVertex("5");
    g.addVertex("6");
    g.addVertex("7");
    g.addVertex("8");

    g.addEdge("1", "3").setWeight("200");
    g.addEdge("1", "4").setWeight("10");
    g.addEdge("2", "3").setWeight("10");
    g.addEdge("2", "4").setWeight("10");
    g.addEdge("3", "5").setWeight("20");
    g.addEdge("3", "6").setWeight("10");
    g.addEdge("4", "5").setWeight("10");
    g.addEdge("4", "6").setWeight("20");
    g.addEdge("7", "1").setWeight("20");
    g.addEdge("7", "2").setWeight("10");
    g.addEdge("8", "1").setWeight("10");
    g.addEdge("8", "2").setWeight("20");


    //Demo3-METIS sample
//    g.addVertex("1").addWeights(new String[]{"1","2","0"});
//    g.addVertex("2").addWeights(new String[]{"0","2","2"});
//    g.addVertex("3").addWeights(new String[]{"4","1","1"});
//    g.addVertex("4").addWeights(new String[]{"2","2","3"});
//    g.addVertex("5").addWeights(new String[]{"1","1","1"});
//    g.addVertex("6").addWeights(new String[]{"2","2","1"});
//    g.addVertex("7").addWeights(new String[]{"1","2","1"});
//
//    g.addEdge("1","2").setWeight("1");
//    g.addEdge("1","3").setWeight("2");
//    g.addEdge("1","5").setWeight("1");
//    g.addEdge("2","3").setWeight("2");
//    g.addEdge("2","4").setWeight("1");
//    g.addEdge("3","4").setWeight("2");
//    g.addEdge("3","5").setWeight("3");
//    g.addEdge("4","6").setWeight("2");
//    g.addEdge("4","7").setWeight("5");
//    g.addEdge("5","6").setWeight("2");
//    g.addEdge("6","7").setWeight("6");


    // print out graph again by iterating over vertices and edges
//        System.out.println(g.toString());
//    Iterator<Vertex> neighbours = g.adjacentTo("b1").iterator();
//    while (neighbours.hasNext()) {
//      System.out.println(String.format("%s - ", neighbours.next().getName()));
//    }
    System.out.println(g.writeMetis("metis", false, false, true, 0));

    Process p = null;
    try {
      p = Runtime.getRuntime().exec("gpmetis output/metis 2");
      p.waitFor();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println(Integer.toString(p.exitValue()));


  }
}
