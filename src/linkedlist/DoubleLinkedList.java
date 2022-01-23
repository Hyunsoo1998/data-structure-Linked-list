package linkedlist;

public class DoubleLinkedList {
private Node head;

DoubleLinkedList() {
	this.head= null;
}
DoubleLinkedList(int value, Node head) {
	this.head = new Node(value,head,null);
}
class Node {
	private int value; //값
	private Node prev; // 이전 포인터
	private Node next; // 다음 포인터
	
	Node(int value) {
		this.value = value;
		this.prev = null;
		this.next = null;
	}
	Node(int value ,Node prev, Node next) {
		this.value = value;
		this.prev = prev;
		this.next =next;
	}
	
	
	
	public int getValue() {
		return this.value;	
	}
	
}
/* 이중 연결 리스트 끝에 노드 추가
 @param value*/
public void append(int value) {
	if(this.head==null) {
		this.head = new Node(value);
		return;
	}
	Node pointer = this.head;
	while(pointer.next != null) {
		pointer = pointer.next;
	}
	Node newNode = new Node(value);
	newNode.prev = pointer;
	pointer.next = newNode;
}
/* 인자 값으로 앞 노드의 값을 알아내기
 * @param value, @return*/

public void printPrevNode(int value) {
	if(this.head== null) {
		System.out.println("이중 연결 리스트가 비어 있습니다.");
		return;
	}
	if(this.head.getValue()== value) {
		System.out.println(String.format("노드 %s 의 앞 노드는 존재하지 않습니다.", value));
		return;
	}
	Node pointer = this.head;
	while(pointer != null && pointer.getValue() != value) {
		pointer = pointer.next;
	}
	if(pointer == null) {
		System.out.println(String.format("노드 %s은 존재하지 않습니다.",value));
	}else {
		System.out.println(String.format("노드 %s의 앞 노드의 값은 %s입니다.",value,pointer.prev.getValue()));
	}
}
/*모든 노드 출력*/
public void printAll() {
	Node pointer = this.head;
	
	StringBuilder builder = new StringBuilder();
	while(pointer != null) {
		builder.append(pointer.getValue());
		builder.append("<->");
		pointer =pointer.next;
	}
	builder.delete(builder.lastIndexOf("<->"),builder.length());
	System.out.println(builder.toString());
}
}

/*단일 연결 리스트의 삽입 로직과 거의 유사하다. 다른점은 이중 연결 리스트에서만 존재하는 앞 노드를 가리키는 
 * prev 변수이다. 반복문이 끝난 후 newNode.prev = pointer;코드를 통해 새 노드의 prev 포인터를
 * pointer변수로 가라키게 해준다.*/
