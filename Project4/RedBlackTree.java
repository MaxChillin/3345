package Project4;

/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	RedBlackTree class
 * Description: This class holds the functionality for building a Red-Black tree
 * Date: 		10/19/2016
 */
public class RedBlackTree {
	
	RedBlackNode root;
	
	/**
	 * 
	 * @param key
	 */
	public void insert(int key){
		root = insert(key, root);
		root.isRed = false;
	}// end of insert(key)
	
	
	/**
	 * 
	 * @param key
	 * @param node
	 * @return
	 */
	private RedBlackNode insert(int key, RedBlackNode node){
		if(node == null){
			return new RedBlackNode(key);
		}
		
		if(key < node.key){
			node.leftChild = insert(key, node.leftChild);
			node.leftChild.isLeftChild = true;
			node.leftChild.parent = node;
		}else if(key > node.key){
			node.rightChild = insert(key, node.rightChild);
			node.rightChild.isRightChild = true;
			node.rightChild.parent = node;
		}else{
			// Duplicate: do nothing
		}		
		
		return balance(node);
	}// end of insert(key, node)
	
	
	/**
	 * 
	 * @param key
	 */
	public boolean contains(int key){
		return contains(key, root);
	}
	
	
	/**
	 * 
	 * @param key
	 * @param node
	 */
	private boolean contains(int key, RedBlackNode node){
		if(node == null){
			return false;
		}
		
		if(key < node.key){
			contains(key, node.leftChild);
		}else if(key > node.key){
			contains(key, node.rightChild);
		}else{
			return true;
		}		
		return false;
	}// end of insert(key, node)
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public RedBlackNode balance(RedBlackNode node){
		if((node.leftChild != null && node.leftChild.isRed) && (node.rightChild != null && node.rightChild.isRed)){
			
			if(node.leftChild.leftChild != null){//**********************************
				if(node.leftChild.leftChild.isRed){//  node--> b              r
					node.isRed = true;//                     /   \          /   \
					node.leftChild.isRed = false;//         r     r  -->   b     b
					node.rightChild.isRed = false;//       /              /       
				}//                                       r              r
			
			} 
				
			if(node.leftChild.rightChild != null){//***************************
				if( node.leftChild.rightChild.isRed){// node--> b              r
					node.isRed = true;//                      /   \          /   \
					node.leftChild.isRed = false;//          r     r  -->   b     b
					node.rightChild.isRed = false;//          \              \      
				}//                                            r              r
					
			}
			
			if(node.rightChild.leftChild != null){//***************************
				if( node.rightChild.leftChild.isRed){// node--> b              r
					node.isRed = true;//                      /   \          /   \
					node.leftChild.isRed = false;//          r     r  -->   b     b
					node.rightChild.isRed = false;//              /              /  
				}//                                              r              r
				
			}
			
			if(node.rightChild.rightChild != null){//**************************
				if( node.rightChild.rightChild.isRed){// node--> b              r
					node.isRed = true;//                       /   \          /   \
					node.leftChild.isRed = false;//           r     r  -->   b     b
					node.rightChild.isRed = false;//                 \              \  
				}//                                                   r              r
				
			}
			
		}else if(node.leftChild != null){
			if(node.leftChild.leftChild != null){
				if(node.leftChild.isRed && node.leftChild.leftChild.isRed){
					node = leftLeftRotate(node);
				}
			}
			
			if(node.leftChild.rightChild != null){
				if(node.leftChild.isRed && node.leftChild.rightChild.isRed){
					node = leftRightRotate(node);
				}
			}
		}
		
		if(node.rightChild != null){
			if(node.rightChild.rightChild != null){
				if(node.rightChild.isRed && node.rightChild.rightChild.isRed){
					node = rightRightRotate(node);
				}
			}
			
			if(node.rightChild.leftChild != null){
				if(node.rightChild.isRed && node.rightChild.leftChild.isRed){
					node = rightLeftRotate(node);
				}
			}
		}
		
		return node;
	}// end of balance method
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public RedBlackNode rightRightRotate(RedBlackNode node){
		RedBlackNode temp = node.rightChild;
		if(temp.leftChild != null){
			temp.leftChild.parent = node;
		}
		node.rightChild = temp.leftChild;
		temp.leftChild = node;
		temp.isRed = false;
		node.isRed = true;
		temp.parent = node.parent;
		node.parent = temp;
		return temp;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public RedBlackNode rightLeftRotate(RedBlackNode node){
		node.rightChild = leftLeftRotate(node.rightChild);
		return rightRightRotate(node);
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public RedBlackNode leftLeftRotate(RedBlackNode node){
		RedBlackNode temp = node.leftChild;
		if(temp.rightChild != null){
			temp.rightChild.parent = node;
		}
		node.leftChild = temp.rightChild;
		temp.rightChild = node;
		temp.isRed = false;
		node.isRed = true;
		temp.parent = node.parent;
		node.parent = temp;
		return temp;
	}
	
	
	/**
	 * 
	 * @param node
	 * @return
	 */
	public RedBlackNode leftRightRotate(RedBlackNode node){
		node.leftChild = rightRightRotate(node.leftChild);
		return leftLeftRotate(node);
	} 
	
	
	/**
	 * 
	 */
	public void printTree(){
		printTree(root);
	}
	
	
	/**
	 * The method recursively climbs through the tree and prints out the values
	 * 		from smallest to largest.
	 */
	public void printTree(RedBlackNode n){
		String color = "";
		if(n == null){
			System.out.println("Tree is empty.");
			return;
		}
		// left
		if(n.leftChild != null){
			printTree(n.leftChild);
		}
		
		if(n.isRed){
			color = "*";
		}
			System.out.print(color + n.key + ", ");
			
		// right
		if(n.rightChild != null){
			printTree(n.rightChild);
		}
		
	}// End of printTree method
	
//***************************
}// end of RedBlackTree class
//***************************


/**
 * 
 * @author Jeremy Pierce
 *
 */
class RedBlackNode {
	int key;
	RedBlackNode leftChild = null;
	RedBlackNode rightChild = null;
	RedBlackNode parent = null;
	RedBlackNode uncle = null;
	boolean isRed = true;
	boolean isLeftChild = false;
	boolean isRightChild = false;
	
	public RedBlackNode(){
		
	}
	
	public RedBlackNode(int key){
		this.key = key;
	}
		
	/**
	 * 
	 */
	public String toString(){
		String color = "", p = "NULL", lc = "NULL", rc = "NULL";
		if(this.leftChild != null){
			lc = "" + this.leftChild.key;
		}
		if(this.rightChild != null){
			rc = "" + this.rightChild.key;
		}
		if(this.parent != null){
			p = "" + this.parent.key;
		}
		if(isRed){
			color = "Red";
		}else{
			color = "Black";
		}
		return "\n\n\nKey = " + key +
				"\nNode Color = " + color +
				"\nLeft Child = " + lc +
				"\nRight Child = " + rc +
				"\nParent = " + p;
	}
}