package Driver;

import java.util.ArrayList;

public class longestPath {
    
//Binary tree node
static class Node
{
   Node left;
   Node right;
   int data;
};

//Function to create a new
//Binary node
static Node newNode(int data)
{
   Node temp = new Node();

   temp.data = data;
   temp.left = null;
   temp.right = null;

   return temp;
}

//Function to find and return the
//longest path
public static ArrayList<Integer> longestPath(Node root)
{
    
   // If root is null means there
   // is no binary tree so
   // return a empty vector
   if(root == null)
   {
       ArrayList<Integer> output = new ArrayList<>();
       return output;
   }
    
   // Recursive call on root.right
   ArrayList<Integer> right = longestPath(root.right);
    
   // Recursive call on root.left
   ArrayList<Integer> left = longestPath(root.left);
    
   // Compare the size of the two ArrayList
   // and insert current node accordingly
   if(right.size() < left.size())
   {
       left.add(root.data);
   }
   else
   {
       right.add(root.data);
   }
    
   // Return the appropriate ArrayList
   return (left.size() >
           right.size() ? left :right);
}

//Driver Code
public static void main(String[] args)
{
   Node node1 = newNode(100);
   Node node2 = newNode(20);
   Node node3 = newNode(130);
   Node node4 = newNode(10);
   Node node5 = newNode(50);
   Node node6 = newNode(110);
   Node node7 = newNode(140);
   Node node8 = newNode(5);
  
   
   node4.left = node8;
   node2.left = node4;
   
   node2.right = node5;
   node3.left = node6;
   node3.right = node7;
   
   node1.right = node3;
   node1.left = node2;
    
   ArrayList<Integer> output = longestPath(node1);
   int n = output.size();
    
   System.out.print(output.get(n - 1));
   for(int i = n - 2; i >= 0; i--)
   {
       System.out.print(" -> " + output.get(i));
   }
}
}
