//stores pipeline nodes
public class PipelineNodeList { //need sort and addtofront, and add to end. Getting description is proken in terms of previous node
  private static PipelineNode headNode;
  private static PipelineNode tailNode;
  public PipelineNodeList(){
    headNode=null;
    tailNode=null;
  }
  public static void append(int pos, String descr){ //pump highway tank
    PipelineNode newNode = new PipelineNode(pos, descr, null,null);
    PipelineNode temp=null;
    if(headNode == null){ 
      headNode = newNode;
    }else{
      tailNode.setNextNode(newNode);
      temp=tailNode;
    }
    tailNode = newNode; //specify a new tailNode
    tailNode.setPreNode(temp);
  }
  public void traverseAndPrint(){
    PipelineNode currentNode = headNode;
    int nodeNum = -1;
    do
    {
    nodeNum++;
    System.out.println("Node number: " + nodeNum);
    System.out.println("Position: " + currentNode.getPosition());
    System.out.println("Description: " + currentNode.getDescription());
    if(currentNode.getNextNode()!=null)
      System.out.println("next: " + currentNode.getNextNode().getDescription());
    if(currentNode.getPreNode()!=null)
      System.out.println("Previous: " + currentNode.getPreNode().getDescription());
    System.out.println(""); //gives a blank line between nodes
    currentNode = currentNode.getNextNode();
    }while(currentNode != null);
  }
  public void getNode(int i){
    PipelineNode currentNode = headNode;
    int nodeNum = -1;
    do
    {
    nodeNum++;
    if(nodeNum==i){
      System.out.println("Node number: " + nodeNum);
      System.out.println("Position: " + currentNode.getPosition());
      System.out.println("Description: " + currentNode.getDescription());
      System.out.println(""); //gives a blank line between nodes
      break;
    }
    currentNode = currentNode.getNextNode(); 
    }while(currentNode != null);
  }
  public int PipelineSize(){
    PipelineNode currentNode = headNode;
    int nodeNum = 0;
    do
    {
    nodeNum++;
    currentNode = currentNode.getNextNode();
    }while(currentNode != null);
    return nodeNum;
  }
  public void PipelineAdd(int pos, String descr, int index){ 
    if(index==0){
      PipelineAddFront(pos, descr);
    }else if(index == PipelineSize()){
      PipelineAdd(pos, descr);
    }else{
      PipelineNode currentNode = headNode;
      int nodeNum = -1;
      PipelineNode request =  new PipelineNode(pos, descr,null,null);
      do{
        nodeNum++;
        if(nodeNum+1==index){
          request.setNextNode(currentNode.getNextNode());
          currentNode.getNextNode().setPreNode(request);
          request.setPreNode(currentNode);
          currentNode.setNextNode(request);
          break;
        }else{
          currentNode = currentNode.getNextNode();
        }
      }while(currentNode.getNextNode() != null);
      
    }
  }
  public void PipelineAdd(int pos, String descr){ //this will add to front
    PipelineNode request =  new PipelineNode(pos, descr,null,tailNode);
    tailNode.setNextNode(request);
    tailNode=request;
  }
  public void PipelineSubtract(int index){ //beginning index request is bad
    if(index==0){
      headNode.getNextNode().setPreNode(null);
      headNode=headNode.getNextNode();
    }else if(index==PipelineSize()-1){
      PipelineSubtract();
    }else{ //pump, highway, tank    pump tank
      int nodeNum = -1;
      PipelineNode currentNode = headNode;//view elimination, view compression of list
      do{
        nodeNum++;
        if(nodeNum+1==index){
          currentNode.getNextNode().getNextNode().setPreNode(currentNode);
          currentNode.setNextNode(currentNode.getNextNode().getNextNode());
          break;
        }else{
          currentNode = currentNode.getNextNode();
        }
      }while(currentNode.getNextNode() != null);
    }
  }
  public void PipelineSubtract(){ //get rid of tailnode
    tailNode=tailNode.getPreNode();
    tailNode.setNextNode(null);
  }
  public void PipelineAddFront(int pos, String descr){
      PipelineNode currentNode = headNode;
      PipelineNode request =  new PipelineNode(pos, descr,currentNode,null);
      headNode.setPreNode(request);
      headNode=request;
  }
  public void insertionSort (){
    PipelineNode currentNode=headNode.getNextNode();//this node will progress forward
    int indexer = 0;
    do{
      indexer++;
      insertInOrder (currentNode, indexer);
      currentNode=currentNode.getNextNode();
    }while(currentNode!=null);
  }
  private void insertInOrder (PipelineNode m, int index){ 
    PipelineNode temp = null;
    PipelineNode tempPre=null;
    PipelineNode save=m;
    for(;m != headNode && m.getPreNode().compareTo (save) > 0;m.getPreNode()){
      temp=m;//0
      tempPre=temp.getPreNode();//4573
      PipelineSubtract(index);//this is the index in question(starting with the position val of 0)
      PipelineSubtract(index-1);//this is the index before the one in question(Should start with 4573)
      PipelineAdd(temp.getPosition(), temp.getDescription(), (index-1));//this is the index in question(starting with the position val of 0)
      PipelineAdd( tempPre.getPosition(), tempPre.getDescription(), index);//this is the index before the one in question(Should start with 4573)
    }
  } 
}
//4573, 0, 3050, 200, 6000
//3050, 200, 6000
//0 3050, 200, 6000
//0 4573 3050, 200, 6000

//0 4573 3050 200 6000 index is 2
//0 200 6000
//0 3050 200 6000
//0 3050 4573 200 6000

//0 3050 4573 200 6000 index is 3
//0 3050 6000
//0 3050 200 6000
//0 3050 200 4573 6000 index is now 2 again 
//0 4573 6000
//0 200 4573 6000
//0 200 3050 4573 6000

//0 200 3050 4573 6000
//pretty sure it won't do anything





