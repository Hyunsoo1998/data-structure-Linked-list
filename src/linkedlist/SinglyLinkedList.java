package linkedlist;

public class SinglyLinkedList {

	private Node head;
	SinglyLinkedList() {
		this.head =null;
		
	}
	SinglyLinkedList(int value) {
		this.head = new Node(value,null);
	}
	class Node {
		private int value; //값
		private Node next; //포인터
	
	Node(int value, Node next) {
		this.value =value;
		this.next = next;
	}
	public int getValue() {
		return this.value;
	}	
	}
	public Node getHead() {
		return this.head;
	}
	/* 단일 연결 리스트 끝에 노드를 추가
	 @param value
	 * 
	 */
	
	//public void append(int value)는 연결 리스트의 마지막 위치에 노드를 삽입하는 메소드이다.
	
	//this.head == null일 경우 빈 연결 리스트를 의미하기 때문에 새 노드를 생성하고 head에 할당한다.
	//노드가 1 이상일때 Node 타입의 pointer 변수에 head를 할당하면 pointer는 첫 노드를 가리키게된다.
	// 다음 pointer.next가 null이 아니게 될 때 까지 계속 반복문을 호출한다.
	//반복문을 빠져나오는 시점은 pointer의 다음 노드가 null이 되는 경우이므로, pointer는 마지막 노드가 된다.
	// 인자로 받은 value 값으로 새 노드를 생성하고 마지막 노드의 포인터는 새 노드를 가리키도록 한다.
	public void append(int value) {
		if(this.head== null) {
			this.head= new Node(value, null);
			return;
		}
		Node pointer = this.head;
		while(pointer.next !=null) {
			pointer = pointer.next;
		}
		pointer.next = new Node(value , null);
	}
	/* 모든 노드 출력
	 * 
	 */
	public void printAll() {
		Node pointer = this.head;
	
	StringBuilder builder = new StringBuilder();
	while(pointer.next != null) {
		builder.append(pointer.getValue());
		builder.append("->");
		pointer = pointer.next;
	}
	builder.append(pointer.getValue());
	System.out.println(builder.toString());
	
	}
}
