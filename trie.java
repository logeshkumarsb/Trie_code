public class Trienodee {
  private trie root;
  Trienodee(){
	  root=new trie('\0');
  }
  int size=0;
  private void addHelper(trie root,String word) {
	  if(word.length()==0) {
		  root.isEnd=true;
		  return;
	  }
	  int childIndex=word.charAt(0)-'A';
	  trie child=root.children[childIndex];
	  if(child==null) {
		  child=new trie(word.charAt(0));
		  root.children[childIndex]=child;
	  }
	  addHelper(root,word.substring(1));
  }
  public void add(String word) {
	  addHelper(root,word);
      size++;
  }
  private boolean searchHelper(trie root,String word) {
	  if(word.length()==0) {
		  return root.isEnd;
	  }
	  int index=word.charAt(0)-'A';
	  trie child=root.children[index];
	  if(child==null) {
		  return false;
	  }
	 return searchHelper(root,word.substring(1));
  }
  public boolean search(String word) {
	  return searchHelper(root,word);
  }
  private void removeHelper(trie root,String word) {
	  if(word.length()==0) {
		  root.isEnd=false;
		  return;
	  }
	  int index=word.charAt(0)-'A';
	  trie child=root.children[index];
	  if(child==null) {
		  return;
	  }
	  removeHelper(root,word.substring(1));
  }
  public int Count(){
      return size;
  }
  public void remove(String word) {
	  removeHelper(root,word);
        size--;
  }
 public static void main(String[] args) {
	Trienodee Word=new Trienodee();
	Word.add("DO");
    Word.add("DOCTOR");
     	System.out.println(Word.Count());
	System.out.println(Word.search("DO"));
     Word.remove("DO");
    System.out.println(Word.search("DO"));
       	System.out.println(Word.Count());


 }
}
class trie{
	 char data;
	 boolean isEnd;
	 trie[] children;
	 trie(char data){
		 this.data=data;
		 isEnd=false;
		 children=new trie[26];
	 }
}