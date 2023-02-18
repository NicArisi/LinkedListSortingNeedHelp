public class PipelineNode {
  private int position;
  private String description;
  private PipelineNode nextNode;
  private PipelineNode PreviousNode;
  public PipelineNode(int pos, String descr, PipelineNode ptr, PipelineNode Pre){
    position = pos;
    description = descr;
    nextNode = ptr;
    PreviousNode=Pre;
  }
  public int getPosition(){
    return position;
  }
  public String getDescription(){
    return description;
  }
  public PipelineNode getNextNode(){
    return nextNode;
  }
  public PipelineNode getPreNode(){
    return PreviousNode;
  }
  public void setPreNode(PipelineNode input){
    PreviousNode=input;
  }
  public void setNextNode(PipelineNode input){
    nextNode=input;
  }
  public int compareTo(PipelineNode input){
    return position-input.getPosition();
  }
}