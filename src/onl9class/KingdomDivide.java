package onl9class;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum Color{
	RED, BLUE
}
class Node {
	private Color color = Color.BLUE;
	private List<Node> neighbours = new ArrayList<>();
	private Boolean isVisited = false;
	private Boolean valid = false;
	private int num = 0;
	
	public Node(int num) {
		super();
		this.num = num;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public List<Node> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}
	public Boolean getIsVisited() {
		return isVisited;
	}
	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Node [num=" + (num+1) +" "+ this.getColor()+  "]";
	}
	public Boolean isValid() {	

		for (Iterator iterator = this.getNeighbours().iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			if(node.getColor() ==this.getColor()) {
				this.setValid(true);
			}else if(node.getNeighbours().size()==1){
				this.setValid(false);
				return false;
			}
		}
		return this.getValid();
	}
}
public class KingdomDivide {
	
	public static Long visitNodes(Node n, Map<Integer, Node> visitingNodes,List<Node> tree) {
		visitingNodes.put(n.getNum(), n);
		
		Long count = 0L;
		
		for (Iterator iterator = n.getNeighbours().iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			if(!node.getIsVisited() && !visitingNodes.containsKey(node.getNum())) {
				count+=visitNodes(node,visitingNodes,tree);
			}
		}
		
		n.setColor(Color.RED);

		if(n.isValid()) {
			n.setIsVisited(true);
			//System.out.println("valid "  + (count+1));
			//System.out.println(tree);
			return count +1;
		}
//		else {
//				Boolean isBig = false;
//				Boolean isSmall = false;
//				for (Iterator iterator = n.getNeighbours().get(0).getNeighbours().iterator(); iterator.hasNext();) {
//					Node node = (Node) iterator.next();
//					if(node.getNum() != n.getNum() && !visitingNodes.containsKey(node.getNum())) {
//						if(node.getNeighbours().size()>1 )
//						isBig=true;
//						else isSmall = true;
//						//n.setColor(Color.BLUE);
//					} 
//				}
//				if(!isSmall&& isBig) {
//					n.setColor(Color.BLUE);
//				}
//			
//			//System.out.println(tree);
//		}
		return count;
	}
	public static void main(String[] args) {
	URL url = KingdomDivide.class.getResource("KingdomDivideinput.txt");
	File file = new File(url.getPath());
	BufferedReader br = null;
	FileReader fr = null;

	try {

		//br = new BufferedReader(new FileReader(FILENAME));
		fr = new FileReader(file);
		br = new BufferedReader(fr);

		String sCurrentLine;
		Boolean flag = false;
		 List<Node> tree = new ArrayList<>();
		 int s1,s2;
		 String[] ins;
		while ((sCurrentLine = br.readLine()) != null) {
			if(!flag) {
				Integer size = Integer.parseInt(sCurrentLine);
				for(int i=0;i<size;i++) {
					 tree.add(new Node(i));
				 }
				flag= true;
			}else {
				 ins = sCurrentLine.split(" ");
				 s1=Integer.parseInt(ins[0]) -1;
				 s2=Integer.parseInt(ins[1]) -1;
				 tree.get(s1).getNeighbours().add(tree.get(s2));
				 tree.get(s2).getNeighbours().add(tree.get(s1));
			}
		}
		 Map<Integer, Node> visitingNodes = new HashMap<>();
		 System.out.println((visitNodes(tree.get(0),visitingNodes,tree)*2)+2);

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (br != null)
				br.close();

			if (fr != null)
				fr.close();

		} catch (IOException ex) {

			ex.printStackTrace();

		}

	}

//	 Scanner sc = new Scanner(System.in);


	  
	}
}
