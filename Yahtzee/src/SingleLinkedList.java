public class SingleLinkedList {
	Node head;
	public void add(Object dataToAdd) {
		if(head == null) {
			Node newnode = new Node(dataToAdd);
			head = newnode;
		}
		else {
			Node temp = head;
			Node previous=null;
			while (temp!=null){
				previous=temp;
				temp=temp.getLink();
			}
			Node newnode = new Node(dataToAdd);
			previous.setLink(newnode);
		
	
		}
		
	}
	public void addsorted(Object dataToAdd) {
		if(head == null) {
			Node newnode = new Node(dataToAdd);
			head = newnode;
		}
		else {
			
			if((int)dataToAdd<(int)head.getData()) {
				Node newnode = new Node(dataToAdd);
				newnode.setLink(head);
				head=newnode;
				
			}
			else {
				Node temp1 = head;
				Node previous=null;
				while (temp1!=null&& (Integer)dataToAdd > (Integer)temp1.getData()){
					previous=temp1;
					temp1=temp1.getLink();
				}
				if(temp1==null) {
					Node newnode1 =new Node(dataToAdd);
					previous.setLink(newnode1);
				}
				else if(previous!=null) {
					Node newnode1 = new Node(dataToAdd);
					newnode1.setLink(temp1);
					previous.setLink(newnode1);
				}
				
			}
	
		}
		
	}
	public void remove (Object dataToRemove) {
		if(head == null)
			System.out.println("linked list is empty");
		else {
			while((Integer)head.getData()==(Integer)dataToRemove)
				head = head.getLink();
			Node temp=head;
			Node previous = null;
			while(temp!=null) {
				if((Integer)temp.getData()==(Integer)dataToRemove) {
					previous.setLink(temp.getLink());
					temp=previous;
				}
				previous = temp;
				temp=temp.getLink();
			}
			
		}
	}
	public void removeOne (Object dataToRemove) {
		Boolean flag=false;
		if(head == null)
			System.out.println("linked list is empty");
		else {
			Node temp=head;
			Node previous = null;
			while(flag==false&&temp!=null) {
				if((Integer)temp.getData()==(Integer)dataToRemove&&flag==false&&previous!=null) {
					previous.setLink(temp.getLink());
					temp=previous;
					flag=true;
				}
				previous = temp;
				temp=temp.getLink();
			}
			
		}
	}
	public void  display() {
		if(head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp!=null) {
				System.out.print(temp.getData());
				temp = temp.getLink();
			}
		}
		
	}
	public boolean search(Object itemToSearch) {
		boolean flag = false;
		if(head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp!=null) {
				if(itemToSearch==temp.getData())
					flag=true;
				temp=temp.getLink();
			}
		}
		return flag;
	}
	public int size() {
		int count=0;
		if(head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp!=null) {
				count++;
				temp=temp.getLink();
			}
		}
		return count;
	}
	public int count(Object diceNum) {
		int count=0;
		if(head == null)
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp!=null) {
				if(temp.getData()==diceNum)
				count++;
				temp=temp.getLink();
			}
		}
		
		return count;
	}
	//Procedure to add and sort scores in high score table
	public void addscore(Object nameToAdd,Object dataToAdd) {
		if(head == null) {
			Node newnode = new Node(nameToAdd);
			Node newscore= new Node(dataToAdd);
			head = newscore;
			head.setLink(newnode);
		}
		else {
			
			if(Integer.parseInt(dataToAdd.toString())>Integer.parseInt(head.getData().toString())) {
				Node newscore = new Node(dataToAdd);
				Node newnode = new Node(nameToAdd);
				newnode.setLink(head);
				newscore.setLink(newnode);
				head=newscore;
				
			}
			else {
				Node tempscore = head;
				Node tempname = tempscore.getLink();
				Node previousname=null;
				while (tempscore!=null&& Integer.parseInt(dataToAdd.toString()) < Integer.parseInt(tempscore.getData().toString())){
					previousname=tempname;
					if(tempname.getLink()!=null) {
						tempscore=tempname.getLink();
						tempname=tempscore.getLink();
					}
					else 
						tempscore=null;
					
				}
				if(tempscore==null) {
					Node newnode1 =new Node(dataToAdd);
					Node newname = new Node(nameToAdd);
					previousname.setLink(newnode1);
					newnode1.setLink(newname);
				}
				else if(previousname!=null) {
					Node newnode1 = new Node(dataToAdd);
					Node newname = new Node(nameToAdd);
					newname.setLink(tempscore);
					newnode1.setLink(newname);
					previousname.setLink(newnode1);
				}
				
			}
	
		}
		
	}
}
