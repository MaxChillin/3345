package Project3;

/** 
 * @author 		Jeremy Pierce
 * Class: 		SE 3345.003 Data Structures
 * Section:		003
 * Semester:	Fall 2016
 * Project 3: 	BinarySerchTree class
 * Description: This class holds the functionality for building a binary search tree
 * Date: 		10/3/2016
 */
public class BinarySearchTree {
	
	TreeNode root;
	static int height = 0;
	static int numberOfNodes = 0;
	static int numberOfDeletedNodes = 0;
	
	
	/**
	 * 
	 */
	public BinarySearchTree(){
		root = null;
	}// end of no argument constructor
	
	
	/**
	 * 
	 * @param key
	 */
	public void insert(int key){//******************************
		TreeNode currentNode = root;//                         *
		TreeNode newNode = new TreeNode();//                   *
		newNode.key = key;//                                   *
		while(true){//******************************************
			if(currentNode == null){//**************************
				root = newNode;//                              *
				newNode.level = 0;//                           *
				numberOfNodes++;
				return;//                                      *
			}else if(currentNode.key == key){//*****************
				return;//                                      *
			}else if(key < currentNode.key){//**LEFT CHILD******
				if(currentNode.leftChild != null){//************ 
					currentNode = currentNode.leftChild;//     *
					continue;//                                *
				}else{//****************************************
					currentNode.leftChild = newNode;//         *
					newNode.parent = currentNode;//            *
					newNode.level = currentNode.level + 1;//   *
					numberOfNodes++;
					if(height < newNode.level)//               *
						height = newNode.level;//              *
					return;//                                  *
				}//*********************************************
			}else if(key > currentNode.key){//***RIGHT CHILD****
				if(currentNode.rightChild != null){//***********
					currentNode = currentNode.rightChild;//    *
					continue;//                                *
				}else{//****************************************
					currentNode.rightChild = newNode;//        *
					newNode.parent = currentNode;//            *
					newNode.level = currentNode.level + 1;//   *
					numberOfNodes++;
					if(height < newNode.level)//               *
						height = newNode.level;//              *
					return;//                                  *
				}//*********************************************
			}//*************************************************
		}// end of while loop **********************************
	}// End of insert method ***********************************
	
	
	
	
	/**
	 * 
	 * @param key
	 */
	public void delete(int key){//*****************************************
		TreeNode currentNode = root;//                                    *
		while(true){//*****************************************************
			if(currentNode == null){//*************************************
				return;//                                                 *
			}else if(currentNode.key == key){//****************************
				if(!currentNode.deleted){//                               *
					numberOfDeletedNodes++;//                             *
					currentNode.deleted = true;//                         *
				}//                                                       *
				return;//                                                 *
			}else if(key < currentNode.key){//**LEFT CHILD*****************
				if(currentNode.leftChild != null){//***********************
					currentNode = currentNode.leftChild;//                *
					continue;//                                           *
				}else{//***************************************************
					if(key == currentNode.key){//                         *
						if(!currentNode.deleted){//                       *
							numberOfDeletedNodes++;//                     *
							currentNode.deleted = true;//                 *
						}//                                               *
					}//                                                   *
					return;//                                             *
				}//********************************************************
			}else if(key > currentNode.key){//***RIGHT CHILD***************
				if(currentNode.rightChild != null){//**********************
					currentNode = currentNode.rightChild;//               *
					continue;//                                           *
				}else{//***************************************************
					if(key == currentNode.key){//                         *
						if(!currentNode.deleted){//                       *
							numberOfDeletedNodes++;//                     *
							currentNode.deleted = true;//                 *
						}//                                               *
					}//                                                   *
					return;//                                             *
				}//********************************************************
			}//************************************************************
		}// end of while loop *********************************************
	}// end of delete method **********************************************

	
	
	
	
	/**
	 * 
	 * @return int The value of the smallest node
	 */
	public int findMin(){
		TreeNode currentNode = subTreeMin(root);
		return currentNode.key;
	}// End of findMin method
	
	
	/**
	 * 
	 * @return int The value of the largest node
	 */
	public int findMax(){
		TreeNode currentNode = subTreeMax(root);
		return currentNode.key;
	}// End of findMax method
	
	
	public TreeNode subTreeMax(TreeNode n){ 
		TreeNode currentNode = n;
		
		while(currentNode.rightChild != null && !currentNode.rightChild.deadEnd){
			currentNode = currentNode.rightChild;
		}
		
		if(currentNode.deleted){
			if(currentNode.leftChild != null && !currentNode.leftChild.deadEnd){
				return subTreeMax(currentNode.leftChild);
			}else {
				currentNode.deadEnd = true;
				return subTreeMax(currentNode.parent);
			}
		}
		return currentNode;
	}
	
	
	public TreeNode subTreeMin(TreeNode n){ 
		TreeNode currentNode = n;
		
		while(currentNode.leftChild != null && !currentNode.leftChild.deadEnd){
			currentNode = currentNode.leftChild;
		}
		
		if(currentNode.deleted){
			if(currentNode.rightChild != null && !currentNode.rightChild.deadEnd){
				return subTreeMin(currentNode.rightChild);
			}else {
				currentNode.deadEnd = true;
				return subTreeMin(currentNode.parent);
			}
		}
		return currentNode;
	}
	
	
	/**
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public boolean contains(int key){//*****************************************
		TreeNode currentNode = root;//                                    *
		while(true){//*****************************************************
			if(currentNode == null){//*************************************
				return false;//                                                 *
			}else if(currentNode.key == key){//****************************
				if(!currentNode.deleted){//                               *
					return true;//                         *
				}//                                                       *
				return false;//                                                 *
			}else if(key < currentNode.key){//**LEFT CHILD*****************
				if(currentNode.leftChild != null){//***********************
					currentNode = currentNode.leftChild;//                *
					continue;//                                           *
				}else{//***************************************************
					if(key == currentNode.key){//                         *
						if(!currentNode.deleted){//                       *
							return true;//                 *
						}//                                               *
					}//                                                   *
					return false;//                                             *
				}//********************************************************
			}else if(key > currentNode.key){//***RIGHT CHILD***************
				if(currentNode.rightChild != null){//**********************
					currentNode = currentNode.rightChild;//               *
					continue;//                                           *
				}else{//***************************************************
					if(key == currentNode.key){//                         *
						if(!currentNode.deleted){//                       *
							return true;//                 *
						}//                                               *
					}//                                                   *
					return false;//                                             *
				}//********************************************************
			}//************************************************************
		}// end of while loop *********************************************
	}// end of contains method **********************************************
	
	
	
	
	
	/**
	 * 
	 */
	public void inOrderTreeTraversal(TreeNode n){
		TreeNode currentNode = n;
		// left
		if(currentNode.leftChild != null){
			inOrderTreeTraversal(currentNode.leftChild);
		}
		if(currentNode.deleted){
			System.out.print("*" + currentNode.key + " ");
		}else{
			System.out.print(currentNode.key + " ");
		}
			
		// right
		if(currentNode.rightChild != null){
			inOrderTreeTraversal(currentNode.rightChild);
		}
		
	}// End of inOrderTreeTraversal method
	
	
	/**
	 * 
	 * @return
	 */
	public int heightOfTree(){
		return height;
	}// End of heightOfTree method
	
	
	/**
	 * 
	 * @return
	 */
	public int numberOfNodes(){
		return numberOfNodes - numberOfDeletedNodes;
	}
	
	/**
	 * 
	 * @author Jeremy Pierce
	 *
	 */
	public class TreeNode{
		
		private int key;
		private int level;
		private TreeNode leftChild;
		private TreeNode rightChild;
		private TreeNode parent;
		private boolean deleted = false;
		private boolean deadEnd = false;
		
	}// End of TreeNode Class
	
}// End of BinarySearchTree Class
