package Project;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package trees;

/**
 *
 * @author KarigarsHome
 */
public class AvlNode 
{
    int info;
    AvlNode left,right,par;
    int gridX,gridY,level,height;
    AvlNode(int i)
    {
        this.info=i;
        this.left=null;
        this.right=null;
        height = 1;
        this.par=null;
    }
    
    public AvlNode(AvlNode n)
    {
        this.info = n.info;
        this.left = n.left;
        this.right = n.right;
    }
    AvlNode( int d, AvlNode lt, AvlNode rt )
    {
        this.info = d;
        this.left = lt;
        this.right = rt;
        this.height = 0;
        this.level=0;
    }
    public boolean isLeaf()
    {
        return (this.left == null && this.right == null);
    }
    
    public AvlNode getLeft() { return this.left; }
    public AvlNode getRight() { return this.right; }
    public int getValue() { return this.info; }
    public void setLeft(AvlNode n) { this.left = n; }
    public void setRight(AvlNode n) { this.right = n; }
    public void setValue(int v) { this.info = v; }
    public void setGrids(AvlNode n){
    this.gridX=n.gridX;
    this.gridY=n.gridY;
    this.level=n.level;};
    
      public boolean remove(int info, AvlNode parent) {
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
      public AvlNode setLeftGrids()
      {
          switch(this.level)
          {
              case 2:
              {
                   this.gridX=250;
                   this.gridY=250;
                   break;
              }
              case 3:
              {
                   this.gridX=this.par.gridX-100;
                   this.gridY=300;
                   break;
              }
              case 4:
              {
                 this.gridX=this.par.gridX-50;
                 this.gridY=350; 
                 break;
              }
              case 5:
              {
                   this.gridX=this.par.gridX-50;
                   this.gridY=400;  
                   break;
              }
              case 6:
              {
                  this.gridX=this.par.gridX-50;
                   this.gridY=450; 
                   break;
              }
                   
          }
          return this;
          
      }
     public AvlNode setRightGrids()
      {
          switch(this.level)
          {
              case 2:
              {
                    this.gridX=750;
                    this.gridY=250;
                    break;
              }
              
              case 3:
              {
                   this.gridX=this.par.gridX+100;
                   this.gridY=300;
                   break;
              }
              case 4:
              {
                 this.gridX=this.par.gridX+50;
                 this.gridY=350; 
                 break;
              }
              case 5:
              {
                   this.gridX=this.par.gridX+50;
                   this.gridY=400;  
                   break;
              }
              case 6:
              {
                  this.gridX=this.par.gridX+50;
                   this.gridY=450; 
                   break;
              }
                   
          }
          return this;
          
      }
    
}
