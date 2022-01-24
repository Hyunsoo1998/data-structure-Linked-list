package linkedlist;

import org.w3c.dom.Node;
/*이중연결 리스트 클래스*/
public class DoubleLinkedList2 {
private Node head;

DoubleLinkedList2() {
	this.head =null;
}
DoubleLinkedList2(int value, Node head) {
	this.head = new Node(value,head,null);
}
class Node {
	private int value; //값
	private Node prev; // 이전 포인터
	private Node next; // 다음 포인터
	Node(int value) {
		this.value = value;
		this.prev= null;
		this.next= null;
	}
	Node(int value, Node prev, Node next) {
		this.value = value;
		this.prev = prev;
		this.next = next;
	}
	public int getValue() {
		return this.value;
	}
}
public Node getHead() {
	return this.head;
}
/* 이중 연결리스트 끝에 노드 추가 
 * @param value*/
public void append(int value) {
	if(this.head==null) {
		this.head = new Node(value);
		return;
	}
	Node pointer = this.head;
	while(pointer.next!=null) {
		pointer= pointer.next;
	}
	Node newNode = new Node(value) ;
	newNode.prev = pointer;
	pointer.next = newNode;	
}
/* 노드의 값을 삭제 
 * @param value
 */
public void delete(int value) {
	Node pointer = this.head;
	if (pointer.getValue() == value) {
		Node removeNode = this.head;
		this.head= this.head.next;
		
		removeNode = null;
		return;	
	}
	//아래는 이중 연결 리스트의 삭제 메서드의 노드가 2개 이상이고, 첫 노드의 값이 인자와 다를 때를 예시로 든 코드이다.
	Node prevNode = pointer;
	while(pointer != null&& pointer.getValue() != value) {
		prevNode = pointer;
		pointer = pointer.next;
	}
	Node temp = pointer.next;
	if(temp == null) {
		prevNode.next =null;
	}else {
		temp.prev = prevNode;
		prevNode.next = pointer.next;
	}
	pointer= null;
	/*pointer는 head와 같은 곳을 가리키고 있는 상태이며 prevNode 는 삭제된 노드와 인접한 노드를 연결 시키기 위하여 사용된다.
	while(pointer!= null&&pointer.getValue() !=value)는 pointer 변수가 null이 아니거나 인자와 값이 다를 때까지 순회하면서
	노드를 찾으며 prevNode는 pointer.prev를 재할당한다. 반복문이 종료되고 삭제 대상을 가리키고 있는 pointer를 기준으로 prevNode.next는 pointer.next를
	가리키게 되고 pointer 노드는 참조를 잃거나 null로 초기화 된다.
	*
	*/
	
	
}
/* 인자 값으로 앞 노드의 값을 알아내기
 * @param value
 * @return
 */
public void printPrevNode(int value) {
	if(this.head == null) {
		System.out.println("이중 연결리스트가 비어 있습니다.");
		return;
	}
	if(this.head.getValue()==value) {
		System.out.println(String.format("노드 %s의 앞 노드는 존재하지 않습니다.", value));
		return;
	}
	Node pointer = this.head;
	while(pointer != null &&pointer.getValue() != value) {
		pointer = pointer.next;
	}
	if(pointer == null) {
		System.out.println(String.format("노드 %s은 존재하지 않습니다.",value));
	}else {
		System.out.println(String.format("노드%s의 앞 노드의 값은 %s입니다.", pointer.prev.getValue()));
	}
}
/* 모든 노드 출력 */
public void printAll() {
	Node pointer = this.head;
	StringBuilder builder = new StringBuilder();
	while(pointer != null) {
		builder.append(pointer.getValue());
		builder.append("<->");
		pointer = pointer.next;
	}
	builder.delete(builder.lastIndexOf("<->"),builder.length());
	System.out.println(builder.toString());


}

}
