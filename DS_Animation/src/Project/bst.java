package Project;




import java.awt.*;
import java.applet.Applet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane;




public class bst extends Applet implements Runnable, ActionListener
{
     String str="";
    int flag=0;
    nodes root=null;
    nodes loc,par;
    Thread t;
    Button insert;
    Button btnInorder;
    Button btnPostOrder;
    Button btnPreorder;
    Button btndel;
    Button btnEmpty,intro;
    Button demo;
    Label jLabel2,lblenter;
    Label lbl,jLabel1;
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
         btnPostOrder = new Button("Post Order");
        btnPreorder = new Button("Pre Order");
        btnInorder = new Button("In Order");
        btndel = new Button("Delete");
        jLabel1 = new Label("Traversal");
       insert = new Button("Insert");
       lblenter = new Label("Enter Element: ");
       intro=new Button("Introduction");

       intro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        intro.addActionListener(this);
        add(intro);
        
        intro.setBounds(0,360, 140, 31);

        lblenter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblenter.setText("Enter Element: ");
        add(lblenter);
        lblenter.setBounds(14,84, 130, 20);
       
       demo = new Button("Demo");
        search = new Button("Search");
        txt = new TextField();
        jLabel2 = new Label();
        lbl = new Label();
        txtText=new TextArea();
        jScrollPane1=new JScrollPane(txtText);
        btnEmpty=new Button("Empty Tree");
        txtText.setColumns(30);
        txtText.setRows(10);
        txtText.setText("Introduction\n\nA binary search tree is a binary tree with the following properties:\n\nThe data stored at each node has a distinguished key which is unique in the tree and belongs to a total order. (That is, for any two non-equal keys, x,y either x < y or y < x.)\nThe key of any node is greater than all keys occurring in its left subtree and less than all keys occurring in its right subtree.\n\n\nThe following are different binary trees:\n   (7)                  (5)\n   / \\                  / \\\n(4)   (9)      vs.   (4)   (9)\n  \\                        /\n  (5)                    (7)\nbut they represent the same binary search tree. \nOperations can we perform a BST include:\ninsert --- add an item and its key to the BST\nsearch --- look up an item in the BST by its key\nremove --- delete an item/key from the BST by its key\nAlgorithm\n\nTREE INSERT(T,z)\n1. y:=NIL; x:=root[T]\n2. while x!=NIL\n3. do y:=x\n4. if key[z] < key[x]\n5. then x:=left[x]\n6. else x:=right[x]\n7. p[z]:=y\n8. if y =NIL\n9. then root[T ]:=z /* Tree T was empty */\n10. else if key[z] < key[y]\n11. then left[y]:=z\n12. else right[y]:=z\n\n\nTREE-DELETE(T,z)\n1. ifleft[z] =NIL orright[z] =NIL\n2. then y:=z\n3. else y:=TREE-SUCCESSOR(z)\n4. ifleft[y] =NIL\n5. then x:=left[y]\n6. else x:=right[y]\n7. if x !=NIL\n8. then p[x]:=p[y]\n9. if p[y] =NIL\n10. then root[T]:=x\n11. else if y = left[p[y]]\n12. then left[p[y]]:=x\n13. else right[p[y]]:=x\n14. if y := z\n15. then key[z]:=key[y]\n16. copy y�s data into z\n17. return y\n\n\nITERATIVE-TREE-SEARCH(x, k)\n1. while x !=NIL and k != key[x]\n2. do if k < key[x]\n3. then x:=left[x]\n4. else x:=right[x]\n5. return x");
        jScrollPane1.setViewportView(txtText);

        add(jScrollPane1);
        jScrollPane1.setBounds(960, 20, 560, 770);
        txtText.setVisible(false);
         jScrollPane1.setVisible(false);
        
        btnEmpty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        
        add(btnEmpty);
        btnEmpty.setBounds(0, 320, 140, 31);

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
        jLabel2.setText("Binary Search Tree Example");
        add(jLabel2);
        jLabel2.setBounds(270, 10, 580, 50);

        lbl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl.setForeground(new java.awt.Color(204, 0, 0));
        add(lbl);
        lbl.setBounds(10, 610, 1040, 80);
       
        insert.addActionListener(this);
        btnEmpty.addActionListener(this);
        search.addActionListener(this);
        btnPreorder.addActionListener(this);
        btnPostOrder.addActionListener(this);
        btnInorder.addActionListener(this);
        btndel.addActionListener(this);
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
    
    public bst()
    {
        t=new Thread(this);
        t.start();
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
              search.enable(true);
              if(!Demo)
              insert.enable(true);
              demo.enable(true);
              txt.setText("");
              txt.requestFocus();
              
          }
     
      }
           
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

    void find(int item)
    {
        nodes ptr=null,save=null;
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

    void insert(int item)
    {
        nodes n;
        find(item);
        
        if(flag==1)
        {
            lbl.setText(txt.getText()+" is already present in the tree.You cannot repeat a number.");
            flag=0;
        }
        if(loc!=null)
        {
            System.out.println("loc != null");
            return;
        }
        
        
        n=new nodes(item);
        loc=n;
        loc.par=par;
        
        n.left=null;
        n.right=null;
        n.par=par;
         
        
        
        if(par==null)
        {
            lbl.setText(n.info+" is made the root of the tree.As the tree was empty");
            root=n;
            root.gridX=500;
            root.gridY=200;
            root.level=1;
             try
            {t.sleep(3000);}catch(Exception ex){}
            lbl.setText("");
            
        }
        else if(item<par.info)
        {
            
                    
            if(par.level<5)
            {
            par.left=n;
            n.par=par;
            n.level=par.level+1;
            lbl.setText(item+" is smaller than the root of the tree "+root.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
            lbl.setText("");
            if(n.par==root)
            {
                n.gridX=250;
                n.gridY=250;
                lbl.setText(item+" is smaller than the "+n.par.info+".So will occupy the left subtree.");
            }
            else if(n.level==3)
            {
                 lbl.setText(item+" is smaller than the "+n.par.info+".So will occupy the left subtree.");
                n.gridX=n.par.gridX-100;
                n.gridY=300;
                 try
            {t.sleep(3000);}catch(Exception ex){}
                 lbl.setText("");
            }
            else if(n.level==4)
            {
                lbl.setText(item+" is smaller than the "+root.left.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
                lbl.setText(item+" is smaller than the "+n.par.info+".So will occupy the left subtree.");
                n.gridX=n.par.gridX-50;
                n.gridY=350;  
                 try
            {t.sleep(3000);}catch(Exception ex){}
                 lbl.setText("");
            }
            else if(n.level==5)
            {
                 lbl.setText(item+" is smaller than the  "+root.left.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
            lbl.setText(item+" is smaller than the "+root.left.left.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
             
            
                 lbl.setText(item+" is smaller than the "+n.par.info+".So will occupy the left subtree.");
                n.gridX=n.par.gridX-50;
                n.gridY=400;  
                 try
            {t.sleep(3000);}catch(Exception ex){}
                 lbl.setText("");
            }
            }
            else
                JOptionPane.showMessageDialog(this, "You can generate tree upto 4th level");
        }
        else
        {
             
            if(par.level<5)
            {
            par.right=n;
            
            n.level=par.level+1;
            n.par=par;
            lbl.setText(item+" is larger than the "+root.info+".So will occupy the right subtree.");
             try
            {t.sleep(3000);}catch(Exception ex){}
             lbl.setText("");
             if(n.par==root)
            {
                
                n.gridX=750;
                n.gridY=250;
            }
            else if(n.level==3)
            {
                lbl.setText(item+" is larger than the "+n.par.info+".So will occupy the right subtree.");
                n.gridX=n.par.gridX+100;
                n.gridY=300;
                 try
            {t.sleep(3000);}catch(Exception ex){}
                 lbl.setText("");
            }
            else if(n.level==4)
            {
                 lbl.setText(item+" is smaller than the "+root.right.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
                lbl.setText(item+" is larger than the "+n.par.info+".So will occupy the right subtree.");
                n.gridX=n.par.gridX+50;
                n.gridY=350;  
                 try
            {t.sleep(3000);}catch(Exception ex){}
                 lbl.setText("");
            }
              else if(n.level==5)
            {
                lbl.setText(item+" is smaller than the  "+root.right.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
            lbl.setText(item+" is smaller than the "+root.right.right.info+".So will occupy the left subtree.");
            try
            {t.sleep(3000);}catch(Exception ex){}
             
                lbl.setText(item+" is larger than the "+n.par.info+".So will occupy the right subtree.");
                n.gridX=n.par.gridX+50;
                n.gridY=400;  
                 try
            {t.sleep(3000);}catch(Exception ex){}
                 lbl.setText("");
            }
            }
            else
                JOptionPane.showMessageDialog(this, "You can generate tree upto 4th level");
        }
    }
    
  void drawTree(nodes r,Graphics g)
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
  
  void search(int item,Graphics g)
  {
      
        nodes ptr=null,save=null;
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

  
  public void preOrder(nodes R,Graphics g )
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

   public void inOrder(nodes R,Graphics g)
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
    public void postOrder(nodes R,Graphics g)
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
                        nodes auxRoot = new nodes(0);
                        auxRoot.setLeft(root);
                        boolean result = root.remove(value, auxRoot);
                        root = auxRoot.getLeft();
                        
                        return result;
                  } else {
                        return root.remove(value, null);
                  }
                  
            }
           
            
    }
    

    

}
