package linkedlist;

/*원형 단일 연결 리스트 클래스 */
//원형 연결리스트 삽입
//자연수 11,9,27,41,3을 차례대로 삽입하여 원형 단일 연결 리스트가 만들어지는 과정을 보자.
//처음 11을 삽입할 땐 빈 연결 리스트이다. head와 tail의 포인터는 노드11을 가리키고있다.
//새로 삽입된 노드9의 포인터가 head를 가리키도록 한다. tail은 항상 마지막 노드를 가리키고있다.

//남은 값들도 모두 삽입하면 새로 생성된 노드는 head를 가리키고 tail은 새로 생성된 노드를 가리키는 것을 확인할 수있다.
public class CircularLinkedList {
	private Node head;
	private Node tail;
	
	CircularLinkedList() {
		this.head =null;
		this.tail = null;
	}
	class Node {
		private int value; // 값
		private Node next; // 다음 포인터

	Node(int value) {
		this.value = value;
		this.next = null;
	}
	public int getValue() {
		return this.value;
	}
	}
	/*원형 단일 연결 리스트 끝에 노드 추가
	 * @param value */

	public void append(int value) {
		if(this.head == null &&this.tail == null) {
			Node node = new Node(value);
			this.head = node;
			this.tail = node;
			return;
		}
		Node pointer= this.tail;
		//마지막 위치에 새 노드 삽입.
		pointer.next = new Node(value);
		
		//tail은 새로 삽입한 노드를 재할당
		this.tail= pointer.next;
		//tail의 next 푄터를 head 로 연결하여 원형 연결 리스트 조건 만족시킴
		this.tail.next = head;	
	}
	/*모든 노드 출력 */
	public void printAll() {
		Node pointer= this.head;
	StringBuilder builder= new StringBuilder();
	while(pointer !=this.tail) {
		builder.append(pointer.getValue());
		builder.append(" ->");
		pointer = pointer.next;
	}
	builder.append(pointer.getValue());
	builder.append("(tail) ->");	
	
	builder.append(this.head.getValue());
	builder.append("(head)");
	
	System.out.println(builder.toString());
	}
	
	
}
//원형 연결 리스트는 마지막 노드를 기억하고 있으므로 마지막 노드를 구하기 위해 노드를 순회하지 않아도 된다.
//tail을 이용하여 삽입 연산을 수행하고있다.
