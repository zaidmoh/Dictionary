import java.util.*;
class BSTNode{
	String word;
	String meaning;
	BSTNode left;
	BSTNode right;
	public BSTNode(String w,String m){
		word=w;
		meaning=m;
		left=null;
		right=null;
	}
}

class Dictionary{
	private BSTNode root;
	public Dictionary(){
		root=null;
	}
	public BSTNode add(String word,String meaning){
		root=add(root,word,meaning);
		return root;
	}
	private BSTNode add(BSTNode root,String w,String m){
		if(root==null){
			return new BSTNode(w,m);
		}
		else if(root.word.compareTo(w)<0){
			root.right=add(root.right,w,m);
		}
		else{
			root.left=add(root.left,w,m);
		}
		return root;
	}
	public String search(String w){
		return search(root,w);
	}
	private String search(BSTNode root,String w){
		if(root.word.equals(w)){
			return root.meaning;
		}
		else if(root.word.compareTo(w)<0){
			if(root.right!=null){
				return search(root.right,w);
			}
			return "";
		}
		else{
			if(root.left!=null)
				return search(root.left,w);
			return "";
		}
	}
	// public static void main(String[] args) {
	// 	Scanner scan=new Scanner(System.in);
	// 	Dictionary d= new Dictionary();
	// 	int option;
	// 	do{
	// 		System.out.println("Choose the option");
	// 		System.out.println("1. Add the word");
	// 		System.out.println("2. Search the word");
	// 		System.out.println("3. Exit");
	// 		option=scan.nextInt();
	// 		scan.nextLine();
	// 		String word;
	// 		switch(option){
	// 			case 1:
	// 			System.out.println("Enter word");
	// 			word=scan.nextLine();
	// 			System.out.println("Enter meaning");
	// 			String meaning=scan.nextLine();
	// 			d.add(word,meaning);
	// 			break;
	// 			case 2:
	// 			System.out.println("Enter word");
	// 			word=scan.nextLine();
	// 			System.out.println("Meaning of "+word+" = "+d.search(word));
	// 			break;
	// 			case 3:
	// 			System.out.println("Thank you");
	// 			break;
	// 		}
	// 	}while(option!=3);
		
	//}
}