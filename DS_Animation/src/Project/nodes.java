package Project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author KarigarsHome
 */
public class nodes 
{
    int info;
    nodes left,right,par;
    int gridX,gridY,level;
    nodes(int i)
    {
        this.info=i;
        this.left=null;
        this.right=null;
        
        this.par=null;
    }
    
    public nodes(nodes n)
    {
        this.info = n.info;
        this.left = n.left;
        this.right = n.right;
    }
    
    public boolean isLeaf()
    {
        return (this.left == null && this.right == null);
    }
    
    public nodes getLeft() { return this.left; }
    public nodes getRight() { return this.right; }
    public int getValue() { return this.info; }
    public void setLeft(nodes n) { this.left = n; }
    public void setRight(nodes n) { this.right = n; }
    public void setValue(int v) { this.info = v; }
    public void setGrids(nodes n){
    this.gridX=n.gridX;
    this.gridY=n.gridY;
    this.level=n.level;};
    public void getGrids(){
    System.out.println("gridX: "+this.gridX);
    System.out.println("gridY: "+this.gridY);
    System.out.println("Level: "+this.level);
    }
    
       public boolean remove(int info, nodes parent) {
            if (info < this.info) {
                  if (left != null)
                        return left.remove(info, this);
                  else
                        return false;
            } else if (info > this.info) {
                  if (right != null)
                        return right.remove(info, this);
                  else
                        return false;
            } else {
                  if (left != null && right != null) {
                        this.info = right.minValue();
                        right.remove(this.info, this);
                  } else if (parent.left == this) 
                  {
                      
                      if( left != null)
                      {
                          left.setGrids(this);
                          left.par=this.par;
                          parent.left=left;
                          
                      }
                      else
                      {
                        
                          if(right!=null)
                          {
                          right.setGrids(this);
                           right.par=this.par;
                             System.out.println(this.par.info);
                          }
                          parent.left= right;
                      }
                  } else if (parent.right == this) {
                        if( left != null)
                      {
                          left.setGrids(this);
                          left.par=this.par;
                          parent.right=left;
                          
                      }
                      else
                      {
                          if(right!=null)
                          {
                          right.setGrids(this);
                          right.par=this.par;
                          }
                          parent.right= right;
                      }
                  }
                  return true;
            }
      }
      public int minValue() {
            if (left == null)
                  return info;
            else
                  return left.minValue();
      }
    
}
