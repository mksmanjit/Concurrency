package foo;

public class BinaryTreeExample {

    public static void main(String[] args) {

    }

}


class Node {
    int value;
    Node left;
    Node right;
    
    public Node(int value,Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class BinaryTree {
    
    
    
    public Node addElementToBinaryTree(Node current, int value) {
        if(current == null) {
            return new Node(value , null, null);
        }
        
        if(value > current.value) {
            current.left = addElementToBinaryTree(current.right, value);
        } else if( value < current.value) {
           current.right = addElementToBinaryTree(current.left, value);
        }
        
        return current;
        
    }
    
    
    public boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }

        return value > current.value ? containsNode(current.right, value) : containsNode(current.left, value);
    }
    
}