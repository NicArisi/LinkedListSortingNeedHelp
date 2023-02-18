class Main {
  public static void main(String[] args) {
    /*PipelineNodeList alaskan= new PipelineNodeList();
    alaskan.append(0, "Pump station");
    alaskan.append(3050, "Hwy 35");
    alaskan.append(4573, "Tank farm");
    alaskan.traverseAndPrint();
    System.out.println("Your request is");
    alaskan.getNode(0);
    
    //inserting new index
    alaskan.PipelineAdd(-1000, "bonk", 0);
    alaskan.PipelineAdd(2000, "ValveFuckingSucksStreet", 2);
    alaskan.PipelineAdd(10000, "ScoutBonk.SFX");
    alaskan.traverseAndPrint();
    System.out.println();
    alaskan.PipelineSubtract(2);
    alaskan.PipelineSubtract(0);
    alaskan.PipelineSubtract();
    alaskan.traverseAndPrint();
    System.out.println("Your request is");
    alaskan.getNode(1);
    alaskan.PipelineAdd(80000, "bonk2");
    alaskan.traverseAndPrint();*/

    PipelineNodeList Pa= new PipelineNodeList();
    Pa.append(4573, "Tank farm");
    Pa.append(0, "Pump station");
    Pa.append(3050, "Hwy 35");
    Pa.append(200, "bopbop");
    Pa.append(6000, "11kj");
    Pa.traverseAndPrint();
    //System.out.println(Pa.PipelineSize());
    Pa.PipelineAdd(2000, "ValveFuckingSucksStreet", 5);
    Pa.insertionSort();
    Pa.traverseAndPrint();
  }
}