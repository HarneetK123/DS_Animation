package Project;
//package trees;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author KarigarsHome
 */
public class Avl_Tree extends Applet implements ActionListener,Runnable
{
    String str="";
    int flag=0;
   // AvlNode root=null;
    AvlNode loc,par;
    Thread t;
    Button insert;
    Button btnInorder;
    Button btnPostOrder;
    Button btnPreorder;
    Button btndel,intro;
    Button demo;
    Button btnEmpty;
    Label jLabel2,lblenter;
    Label lbl,jLabel1;
    Label lblBal;
    Button search;
    TextField txt;
    TextArea txtText;
    JScrollPane jScrollPane1;
    String choice="";
    boolean Demo=false;
    int[] a={56,25,78,15,49,58,69,32};
    Label [] lb;
   
    public void init()
    {
        lb= new Label[8];
         btnEmpty=new Button("Empty Tree");
         btnPostOrder = new Button("Post Order");
        btnPreorder = new Button("Pre Order");
        btnInorder = new Button("In Order");
        btndel = new Button("Delete");
        jLabel1 = new Label("Traversal");
        lblenter = new Label("Enter Element: ");
        intro=new Button("Introduction");
       insert = new Button("Insert");
       demo = new Button("Demo");
        search = new Button("Search");
        txt = new TextField();
        jLabel2 = new Label();
        lbl = new Label();
        lblBal = new Label();
 txtText=new TextArea();
        jScrollPane1=new JScrollPane(txtText);
        
        intro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        intro.addActionListener(this);
        add(intro);
        intro.setBounds(0, 360, 140, 31);

        lblenter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblenter.setText("Enter Element: ");
        add(lblenter);
        lblenter.setBounds(14, 84, 130, 20);
        
        txtText.setColumns(30);
        txtText.setRows(10);
        txtText.setText("Introduction\n\nAn AVL (Adelson-Velski/Landis) tree is a binary search tree which \nmaintains the following height-balanced \"AVL property\"\nat each node in the tree:\n\nabs( (>height of left subtree) � (height of right subtree) ) = 1\nNamely, the left and right subtrees are of equal height, \nor their heights differ by 1.\nRecall that the height of a tree is the maximum depth (from the root) of any node. A tree with one node has height 0. We will say that the empty (null) tree has height -1.\nRebalancing Strategies\n\nSuppose that a node satisfies the AVL property and that an add goes \ninto the left subtree. There will be two separate cases to consider:\nthe add goes into the left-left subtree\nthe add goes into the left-right subtree\nIf either of these causes the left subtree to increase in height so \nthat the increased height causes the AVL property to fail, \nwe perform one of the following two respective rotation operations:\nsingle rotate (from the) left\ndouble rotate (from the) left\nIn either case, the new tree will be balanced \n(i.e., the AVL property satisfied) and will have height equal to the\nheight of the tree prior to insertion. This means that an add will \nonly ever cause one rebalancing rotation to reestablish the AVL\nproperty for the entire tree.\n\n\nAlgorithm\n\nInsertion\nif (balance_factor(L) > 0) {\n// In the illustration to the right,\n// this is the first step in the left-right case.\nrotate_left(L);\n}\n// This brings us to the left-left case.\nrotate_right(P);");
        jScrollPane1.setViewportView(txtText);

        add(jScrollPane1);
        jScrollPane1.setBounds(960, 20, 560, 770);
        txtText.setVisible(false);
         jScrollPane1.setVisible(false);
        demo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        demo.addActionListener(this);
        add(demo);
        demo.setBounds(20, 20, 110, 30);
        
        setLayout(null);
        int w=0;
        for(int i=0;i<8;i++)
        {
            lb[i]=new Label("");
            add(lb[i]);
            lb[i].setBounds(380+w, 120, 50, 30);
            w+=50;
            
            
        }

        insert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInorder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(btnInorder);
        btnInorder.setBounds(0, 240, 120, 31);
        
        btnPostOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(btnPostOrder);
        btnPostOrder.setBounds(0, 280, 120, 31);

        btnPreorder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(btnPreorder);
        btnPreorder.setBounds(0, 200, 120, 31);
       
          
        
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        //jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        add(jLabel1);
        jLabel1.setBounds(10, 170, 100, 30);
        
        btndel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(btndel);
        btndel.setBounds(250, 120, 110, 30);
        
        add(insert);
        insert.setBounds(10, 120, 110, 30);

        search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        add(search);
        search.setBounds(130, 120, 110, 30);

        txt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(txt);
        txt.setBounds(150, 80, 120, 30);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("AVL Tree Example");
        add(jLabel2);
        jLabel2.setBounds(270, 10, 580, 50);

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(204, 0, 0));
        add(lbl);
        lbl.setBounds(10, 610, 1040, 80);
       
        lblBal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblBal.setForeground(new java.awt.Color(204, 0, 0));
        add(lblBal);
        lblBal.setBounds(630, 530, 420, 70);
        btnEmpty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        add(btnEmpty);
        btnEmpty.setBounds(0, 320, 140, 31);
        
        insert.addActionListener(this);
        search.addActionListener(this);
        btnPreorder.addActionListener(this);
        btnPostOrder.addActionListener(this);
        btnInorder.addActionListener(this);
        btndel.addActionListener(this);
         btnEmpty.addActionListener(this);
         this.enable(true);
         
         setSize(1600,800);
       
    }
     
       public void actionPerformed(ActionEvent e)
    {
       
        int text=0;
       
        try
        {
           if(e.getSource()==insert|| e.getSource()==search)
            {
             text=Integer.parseInt(txt.getText());
             if(text>0 && text<100)
             {
                if(e.getSource()==insert)
                 {
            
                    choice="insert";
               
                 }
                else if(e.getSource()==search)
                 {
               
                      choice="search";
                      repaint();
               
                }
             }
             else
               JOptionPane.showMessageDialog(this, "Invalid input.\nPlease provide an integer b/w 0 and 100"); 
            }
             else if(e.getSource()==btnPostOrder)
             {
                 System.out.println("into Postorder action");
                 choice="postorder";
                 repaint();
             }
           else if(e.getSource()==btnPreorder)
             {
                 System.out.println("into preorder action");
                 choice="preorder";
                 repaint();
             }
           else if(e.getSource()==btnInorder)
             {
                 System.out.println("into inorder action");
                 choice="inorder";
                 repaint();
             }
           else if(e.getSource()==btndel)
           {
               System.out.println("into del action");
               choice="del";
             repaint();
           }
           else if(e.getSource()==demo)
           {
               Demo=true;              
               
               for(int i=0;i<8;i++)
               {
                   lb[i].setText(Integer.toString(a[i]));
               }
               choice="demo";
           }
           else if(e.getSource()==btnEmpty)
           {
               root=null;
               choice="";
               insert.enable(true);
               repaint();
           }
           else if(e.getSource()==intro)
           {
               txtText.setVisible(true);
               jScrollPane1.setVisible(true);
           }
        }
        catch(NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Invalid input.\nPlease provide an integer b/w 0 and 100");
        }
        
        bst b=new bst();
      
    }
    
    // TODO overwrite start(), stop() and destroy() methods
 private AvlNode root; // The tree root
public Avl_Tree( ) // Construct the tree
{
root = null;
t=new Thread(this);
t.start();
}
/*
Insert into the tree; duplicates are ignored.
x the item to insert.
*/

public void insert( int x )
{
    System.out.println("Into insert method calling next method");
root = insert( x, root );
SetGrids(root);
}
/*
Find an item in the tree.
x the item to search for.
return true if x is found.
*/
public boolean search( int x )
{
return search( x, root );
}

public void makeEmpty( ) // Make the tree logically empty.
{
root = null;
}
/*
Test if the tree is logically empty.
return true if empty, false otherwise.
*/
public boolean isEmpty( )
{
return root == null;
}
/*
Print the tree contents in sorted order.
*/
public void printTree( )
{
if( isEmpty( ) )
    System.out.println("Empty Tree");
 else
printTree( root );
}
/*
method to insert into a subtree.
x the item to insert.
t the node that roots the subtree.
return the new root of the subtree.
*/

private AvlNode insert( int x, AvlNode t1 )
{
    System.out.println("Into insert method 2 adding elements");
if( t1 == null )
{
 lbl.setText(x+" is made the root") ;  
  try
   {t.sleep(3000);}catch(Exception ex){}
return new AvlNode( x, null, null );
}
if( x < t1.info )
{
lbl.setText(x+" is < than "+t1.info+". Inserting into left subtree.") ; 
 try
 {t.sleep(3000);}catch(Exception ex){}
t1.left = insert( x, t1.left );
if( (height( t1.left ))-(height( t1.right )) == 2 )
{
 lbl.setText("Tree is not balanced so performing rotation.") ; 
 try
 {t.sleep(3000);}catch(Exception ex){}
if( x < t1.left.info )
{
 lbl.setText(x+" < than " +t1.left.info+" so performing single left rotation.") ; 
 try
 {t.sleep(3000);}catch(Exception ex){}
t1 = rotateLeft( t1 );
}
else
{
 lbl.setText(x+" > than "+ t1.left.info+" so performing double left rotation.") ;
 try
 {t.sleep(3000);}catch(Exception ex){}
t1 = doubleLeft( t1 );
}
}
}
else if( x > t1.info )
{
 lbl.setText(x+" is > than "+t1.info+". Inserting into right subtree.") ;
  try
 {t.sleep(3000);}catch(Exception ex){}
t1.right = insert( x, t1.right );
if( height( t1.right ) - height( t1.left ) == 2 )
if( x > t1.right.info )
{
 lbl.setText(x+" < than " +t1.right.info+" so performing single right rotation.") ;
 try
 {t.sleep(3000);}catch(Exception ex){}
t1 = rotateRight( t1 );
}
else
{
 lbl.setText(x+" > than " +t1.right.info+" so performing double right rotation.") ;
 try
 {t.sleep(3000);}catch(Exception ex){}
t1 = doubleRight( t1 );
}
}
else
 lbl.setText(txt.getText()+" is already present in the tree.You cannot repeat a number.") ; // Duplicate; do nothing
t1.height = Math.max( height( t1.left ), height( t1.right )) + 1;

return t1;

}
AvlNode SetGrids(AvlNode r)
{
    if(r!=null)
    {
    if(r==root)
    {
        r.gridX=500;
        r.gridY=200;
        r.level=1;
        r.par=null;
           
    }
    if(r.left!=null)
    {
    r.left.par=r;    
    r.left.level=r.level+1;
    r.left.setLeftGrids();
    System.out.println("r.left level: "+r.left.level );
    System.out.println("r.left grids: "+r.left.gridX+" "+r.left.gridY );
    repaint();
    }
    if(r.right!=null)
    {
        r.right.par=r;
    r.right.level=r.level+1;
    r.right.setRightGrids();
    }
    repaint();
    SetGrids(r.left);
    SetGrids(r.right);
    repaint();
    return r;
    }
    return r;
}
/*
method to find an item in a subtree.
x is item to search for.
t the node that roots the tree.
return true if x is found in subtree.
*/
private boolean search( int x, AvlNode t )
{
while( t != null )
{
if( x < t.info )
t = t.left;
else if( x > t.info )
t = t.right;
else
return true; // Match
}
return false; // No match
}
/*
method to print the tree in sorted order.
t the node that roots the tree.
*/

private void printTree( AvlNode t ) // inorder traversal
{
if( t != null )
{
printTree( t.left );
System.out.print( t.info +"  ");
printTree( t.right );
}
}
private int height( AvlNode t ) // return height of node t, or -1, if null.
{
if( t == null ) return -1;
else return t.height;
}
/*
Rotate binary tree node with left child.
For AVL trees, this is a single rotation.
Update heights, then return new root.
*/
private AvlNode rotateLeft( AvlNode node2 )
{
AvlNode node1 = node2.left;
node2.left = node1.right;
node1.right = node2;
node2.height = Math.max(height(node2.left), height(node2.right))+1;
node1.height = Math.max(height(node1.left), node2.height)+1;
return node1;
}

/*
Rotate binary tree node with right child.
For AVL trees, this is a single rotation.
Update heights, then return new root.
*/
private AvlNode rotateRight( AvlNode node1 )
{
AvlNode node2 = node1.right;
node1.right = node2.left;
node2.left = node1;
node1.height = Math.max(height(node1.left), height(node1.right))+1;
node2.height = Math.max(height(node2.right), node1.height)+1;
return node2;
}
/*
Double rotate binary tree node: first left child with its right child;
then node node3 with new left child.
For AVL trees, this is a double rotation.
Update heights, then return new root.
*/
private AvlNode doubleLeft( AvlNode node3 )
{
node3.left = rotateRight( node3.left );
return rotateLeft( node3 );
}

/*
Double rotate binary tree node: first right child with its left child;
then node node1 with new right child.
For AVL trees, this is a double rotation.
Update heights, then return new root.
*/
private AvlNode doubleRight( AvlNode node1 )
{
node1.right = rotateLeft( node1.right );
return rotateRight( node1 );
}

 public void paint(Graphics g)
    {
        if(root!=null && choice!="demo" && choice!="del")  
        drawTree(root, g);
        
        if(choice.equalsIgnoreCase("search"))
            search(Integer.parseInt(txt.getText()),g);
        else if(choice.equalsIgnoreCase("demo"))
            drawTree(root, g);
        else if(choice.equalsIgnoreCase("preorder"))
        {
            if(root!=null)
            {
            str="";
            System.out.println("into preorder repainting");
            preOrder(root,g);
            }
            else
                JOptionPane.showMessageDialog(this, "Generate a tree.");
        }
         else if(choice.equalsIgnoreCase("postorder"))
        {
            if(root!=null)
            {
            str="";
            System.out.println("into postorder repainting");
            postOrder(root,g);
            }
            else
                JOptionPane.showMessageDialog(this, "Generate a tree.");
        }
         else if(choice.equalsIgnoreCase("inorder"))
        {
            if(root!=null)
            {
            str="";
            System.out.println("into inorder repainting");
            inOrder(root,g);
            }
            else
               JOptionPane.showMessageDialog(this, "Generate a tree."); 
        }
         else if(choice.equalsIgnoreCase("del"))
         {
             System.out.println("into delete paint");
            if(root!=null)
            {
                find(Integer.parseInt(txt.getText()));
                             
                if(loc!=null)
                {
                    delete(Integer.parseInt(txt.getText()),g);
                    drawTree(root, g);
                }
                 else
               JOptionPane.showMessageDialog(this, "This does not exist in the tree"); 
            }
             else
               JOptionPane.showMessageDialog(this, "Generate a tree."); 
         }
    }


 void drawTree(AvlNode r,Graphics g)
    {
        if(r==null)
            return;
            if(r.gridX!=0 && r.gridY!=0)
            {
            g.setColor(Color.cyan);    
            g.fillOval(r.gridX,r.gridY ,40,30);
            g.setColor(Color.black);
            g.drawString(Integer.toString(r.info), r.gridX+10, r.gridY+20);
            if(r.par!=null)
            {
                g.drawLine(r.gridX+20, r.gridY, r.par.gridX+20, r.par.gridY+30);
            }
           /* try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}*/
            }
           drawTree(r.left, g);
            drawTree(r.right, g);
            
        
    }
   void find(int item)
    {
        AvlNode ptr=null,save=null;
        if(root==null)
        {
            loc=null;
            par=null;
            return;
        }
        else if(item==root.info)
        {
            flag=1;
            loc=root;
            par=null;
            return;
        }
        else if(item<root.info)
        {
            ptr=root.left;
            save=root;
        }
        else if(item>root.info)
        {
            ptr=root.right;
            save=root;
        }
        
        while(ptr!=null)
        {
            if(item==ptr.info)
            {
                flag=1;
                loc=ptr;
                par=save;
                return;
            }
            else if(item<ptr.info)
            {
                save=ptr;
                ptr=ptr.left;
            }
             else if(item>ptr.info)
            {
                save=ptr;
                ptr=ptr.right;
            }
            
        }
        // Search unsuccessful
        flag=0;
        loc=null;
        par=save;
        
    }

  void search(int item,Graphics g)
  {
      
        AvlNode ptr=null,save=null;
        if(root!=null)
        {
            g.setColor(Color.red);
            g.fillOval(root.gridX, root.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(root.info), root.gridX+10, root.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
             g.fillOval(root.gridX, root.gridY, 40,30);
             g.setColor(Color.black);  
            g.drawString(Integer.toString(root.info), root.gridX+10, root.gridY+20);
            
        }
        if(root==null)
        {
           JOptionPane.showMessageDialog(this, "Please generate tree first.");
           return;
        }
        else if(item==root.info)
        {
            g.setColor(Color.red);
            g.fillOval(root.gridX, root.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(root.info), root.gridX+10, root.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
            g.setColor(Color.green);    
            g.fillOval(root.gridX, root.gridY, 40,30);
            g.setColor(Color.red);  
            g.drawString(Integer.toString(root.info), root.gridX+10, root.gridY+20);
            lbl.setText(item+" is searched.");
             try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
             g.fillOval(root.gridX, root.gridY, 40,30);
             g.setColor(Color.black);  
            g.drawString(Integer.toString(root.info), root.gridX+10, root.gridY+20);
            return;
        }
        else if(item<root.info)
        {
            lbl.setText(item+" is < than "+root.info+" so searching the left tree.");
            ptr=root.left;
            save=root;
            g.setColor(Color.red);
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
        }
        else if(item>root.info)
        {
            lbl.setText(item+" is > than "+root.info+" so searching the right tree.");
            ptr=root.right;
            save=root;
            g.setColor(Color.red);
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
             g.fillOval(ptr.gridX, ptr.gridY, 40,30);
             g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
        }
        
        while(ptr!=null)
        {
            if(item==ptr.info)
            {
               g.setColor(Color.red);
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
            g.setColor(Color.green);    
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.red);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            lbl.setText(item+" is searched.");
             try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            return;
            }
            else if(item<ptr.info)
            {
                lbl.setText(item+" is < than "+ptr.info+" so searching the left tree.");
                  g.setColor(Color.red);
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
                save=ptr;
                ptr=ptr.left;
                
            }
             else if(item>ptr.info)
            {
                lbl.setText(item+" is > than "+ptr.info+" so searching the right tree.");
                g.setColor(Color.red);
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
            g.fillOval(ptr.gridX, ptr.gridY, 40,30);
            g.setColor(Color.black);  
            g.drawString(Integer.toString(ptr.info), ptr.gridX+10, ptr.gridY+20);
                save=ptr;
                ptr=ptr.right;
                
            }
            
        }
        // Search unsuccessful
        loc=null;
        par=save;
        lbl.setText(item+" is not present in the tree.");
        
   

  }

  
  public void preOrder(AvlNode R,Graphics g )
    {
       System.out.println("into preorder");
       
        if(R != null)
        {   
            str=str+" "+R.info;
            g.setColor(Color.yellow);
            g.fillOval(R.gridX, R.gridY, 40,30);
            g.setColor(Color.red);  
            g.drawString(Integer.toString(R.info),R.gridX+10, R.gridY+20);
            System.out.println("going to sleep");
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
             g.fillOval(R.gridX, R.gridY, 40,30);
             g.setColor(Color.black);  
            g.drawString(Integer.toString(R.info),R.gridX+10, R.gridY+20);
             System.out.println("after sleep");
            lbl.setText(str);
            preOrder(R.left,g);
            preOrder(R.right,g);
        }
       
    }

   public void inOrder(AvlNode R,Graphics g)
    {
        if(R != null)
        {
            inOrder(R.left,g);
            str=str+" "+R.info;
            g.setColor(Color.yellow);
            g.fillOval(R.gridX, R.gridY, 40,30);
            g.setColor(Color.red);  
            g.drawString(Integer.toString(R.info),R.gridX+10, R.gridY+20);
            System.out.println("going to sleep");
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
             g.fillOval(R.gridX, R.gridY, 40,30);
             g.setColor(Color.black);  
            g.drawString(Integer.toString(R.info),R.gridX+10, R.gridY+20);
             System.out.println("after sleep");
            lbl.setText(str);
            inOrder(R.right,g);
        }
    }
    public void postOrder(AvlNode R,Graphics g)
    {
        if(R != null)
        {
            postOrder(R.left,g);
            postOrder(R.right,g);
            str=str+" "+R.info;
            g.setColor(Color.yellow);
            g.fillOval(R.gridX, R.gridY, 40,30);
            g.setColor(Color.red);  
            g.drawString(Integer.toString(R.info),R.gridX+10, R.gridY+20);
            System.out.println("going to sleep");
            try {
             t.sleep(3000);
             } catch (InterruptedException ex) {}
             g.setColor(Color.cyan);    
             g.fillOval(R.gridX, R.gridY, 40,30);
             g.setColor(Color.black);  
            g.drawString(Integer.toString(R.info),R.gridX+10, R.gridY+20);
             System.out.println("after sleep");
            lbl.setText(str);
        }
    }
    
    public boolean delete(int value,Graphics g) 
    {
            if (root == null)
                  return false;
            else {
                  if (root.getValue() == value) {
                        AvlNode auxRoot = new AvlNode(0);
                        auxRoot.setLeft(root);
                        boolean result = root.remove(value, auxRoot);
                        root = auxRoot.getLeft();
                        return result;
                  } else {
                        return root.remove(value, null);
                  }
                  
            }
            
            
      }
          
    public void run()
    {
     while(true)
      {
          if(choice.equalsIgnoreCase("insert"))
          {
              search.enable(false);
              txt.disable();
              insert.enable(false);
              btnPreorder.enable(false);
              btnPostOrder.enable(false);
              btnInorder.enable(false);
              btndel.enable(false);
              demo.enable(false);
              insert(Integer.parseInt(txt.getText()));
              repaint();
              choice="";
              txt.enable(true);
              btnPreorder.enable(true);
              btnPostOrder.enable(true);
              btnInorder.enable(true);
              btndel.enable(true);
              insert.enable(true);
              search.enable(true);
              demo.enable(true);
              txt.setText("");
              txt.requestFocus();
              
          }
          else if(choice.equalsIgnoreCase("search"))
          {
              search.enable(false);
              txt.disable();
              insert.enable(false);
              demo.enable(false);
               btnPreorder.enable(false);
              btnPostOrder.enable(false);
              btnInorder.enable(false);
              btndel.enable(false);
              repaint();
              choice="";
              txt.enable(true);
              btnPreorder.enable(true);
              btnPostOrder.enable(true);
              demo.enable(true);
              btnInorder.enable(true);
              btndel.enable(true);
              if(!Demo)
              insert.enable(true);
              search.enable(true);
              txt.setText("");
              txt.requestFocus();
          }
          else if(choice.equalsIgnoreCase("del"))
          {
              System.out.println("into delete run");
              search.enable(false);
              txt.disable();
              insert.enable(false);
               btnPreorder.enable(false);
              btnPostOrder.enable(false);
              btnInorder.enable(false);
              btndel.enable(false);
              demo.enable(false);
              
              repaint();
              
              choice="";
              txt.enable(true);
              demo.enable(true);
              btnPreorder.enable(true);
              btnPostOrder.enable(true);
              btnInorder.enable(true);
              btndel.enable(true);
              if(!Demo)
              insert.enable(true);
              search.enable(true);
              txt.setText("");
              txt.requestFocus();
          }
          else if(choice.equalsIgnoreCase("demo"))
          {
              
              search.enable(false);
              txt.disable();
              insert.enable(false);
              btnPreorder.enable(false);
              btnPostOrder.enable(false);
              btnInorder.enable(false);
              btndel.enable(false);
              demo.enable(false);
              for(int i=0;i<a.length;i++)
              {
                  lb[i].setForeground(Color.red);
                  lb[i].setFont(new java.awt.Font("Tahoma", 0, 18));
                  
                  insert(a[i]);
                  repaint();
                  lb[i].setForeground(Color.black);
                  lb[i].setFont(new java.awt.Font("Tahoma", 0, 12));
              }
              for(int i=0;i<8;i++)
               {
                   lb[i].setText("");
               }
              choice="";
              txt.enable(true);
              btnPreorder.enable(true);
              btnPostOrder.enable(true);
              btnInorder.enable(true);
              btndel.enable(true);
              if(!Demo)
              insert.enable(true);
              search.enable(true);
              demo.enable(true);
              txt.setText("");
              txt.requestFocus();
              
          }
     
      }
           
    }
    

}
