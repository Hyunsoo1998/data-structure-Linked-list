package linkedlist;

//노드3을 삭제한다고 가정해보자. 노드3이 삭제된다면 그 앞 노드 41은 tail이 되고, 포인터의 위치는 head를 가리켜야한다.

//삭제된 노드3은 참조가 끊긴 상태이고, tail은 마지막 노드 41을 바라보고 있으며 노드 41은 head를 가리키고 있는 원형 단일 연결 리스트의 조건을 만족한다.

//남은 값들도 모두 삽입하면 새로 생성된 노드는 head를 가리키고 tail은 새로 생성된 노드를 가리키는 것을 확인할 수 있다.
public class CircularLinkedList2 {
private Node head;
private Node tail;

CircularLinkedList2() {
	this.head = null;
	this.tail = null;
}
class Node {
	private int value ; // 값
	private Node next; //다음 포인터
	Node (int value) {
		this.value = value;
		this.next = null;
	}
	public int getValue() {
		return this.value;
	}
}
/*원형 단일 연결 리스트 끝에 노드 추가  @param value */

public void append(int value) {
	if(this.head == null && this.tail == null) {
		Node node = new Node(value);
		this.head = node;
		this.tail = node;
		return;
	}
	Node pointer = this.tail;
	//마지막 위치에 새 노드 삽입
	pointer.next =new Node(value);
	
	//tail은 새로 삽입한 노드를 재할당
	this.tail = pointer.next;
	//tail의 next 포인터를 head로 연결하여 원형 연결 리스트 조건 만족시킴.
	this.tail.next = head;
}
/*원형 단일 연결 리스트 노드 삭제 @param value */
	public void delete(int value ) {
		Node pointer = this.head;
		
		if(pointer.getValue() == value) {
			Node removeNode = this.head;
			this.head = this.head.next;
			removeNode = null;
			return;
		}
		//포인터가 tail이 아니며 값이 다를때 까지 반복
		Node temp = null;
		while(pointer.next!= this.tail && pointer.getValue() !=value) {
			temp = pointer;
			pointer = pointer.next;
		}
		//삭제할 노드가 tail일 경우 앞 노드를 tail로 재할당하고 next를 head 로 연결
		/*if(pointer.next.getValue() == value)는 삭제 대상 노드가 tail일 경우이다.
		 * tail을 삭제 하기 전 삭제 대상 노드의 앞 노드를 tail로 재할당하고 tail.next를 head노드와 연결해준다.
		 * head및 tail의 중간 노드가 삭제 대상인 경우는 temp노드를 이용하여 삭제 될 중간 노드의 앞과 뒤 노드를 서로 연결하여 노드를 삭제한다. */
		
		if(pointer.next.getValue()==value) {
			this.tail = pointer;
			this.tail.next = this.head;
		
		}else {
			temp.next = pointer.next;	
		}
		pointer= null;
	}
	/*모든 노드 출력 */
	public void printAll() {
		Node pointer= this.head;
		StringBuilder builder = new StringBuilder();
		while(pointer!= this.tail) {
			builder.append(pointer.getValue());
			builder.append("->");
			pointer = pointer.next;
		}
		builder.append(pointer.getValue());
		builder.append("(tail) ->");
		
		builder.append(this.head.getValue());
		builder.append("(head)");
		System.out.println(builder.toString());
	}
	
}
