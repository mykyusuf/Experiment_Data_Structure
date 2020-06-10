
package Exp;

import java.util.Iterator;
/**
 * ExperimentListClass
 */
public class ExperimentList implements Iterator {
  static class Node {
    Experiment data;

    ExperimentList.Node next;

    int nextD;

    /**
     * Constructor for node
     * @param d
     */
    Node(Experiment d) {

            data = d;
            next=null;
            nextD=data.day+1;
    }

  }

  ExperimentList.Node head;

  int size;

  int current;

  /**
   * Controls if list has a next element
   * @return true if list has a next element
   */
  @Override
  public boolean hasNext() {
        if(head.next==null) {
            return false;
        }
        return true;
  }

  /**
   * Iterates to next element of list
   * @return next element
   */
  @Override
  public Object next() {
        if (hasNext()){
            head=head.next;
            current++;
            return head;
        }
        return null;
  }

  /**
   * Constructor for ExperimentList
   */
  ExperimentList() {
        size=0;
        current=0;
        head=null;
  }

  /**
   * Copy Constructor for ExperimentList
   * @param  el is another list to copy
   */
  ExperimentList(ExperimentList el) {
        Node temp=el.head;
        for(int i=0;i<el.size;i++){
            this.addExp(el.head.data);
            el.head=el.head.next;
        }
        el.head=temp;
        current=0;

  }

  /**
   * Adds experiment to the list
   * @param data
   */
  public void addExp(Experiment data) {
        Node new_node = new Node(data);
        new_node.next = null;

        if (this.head == null) {
            this.head = new_node;
        }
        else {

            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;
        }
        size++;

  }

  /**
   * Returns experiment at the given index
   * @param d
   * @param index
   * @return experiment
   * @throws Exception
   */
  public Experiment getExp(int d, int index) throws Exception {

        int j=0;
        Node temp=head;
        for (int i=0;i<size;i++){
            if(temp.data.day==d){

                if(j==index){
                    return temp.data;
                }
                j++;

            }
            temp=temp.next;
        }
        throw new Exception();

  }

  /**
   * Set experiment at the given index
   * @param d
   * @param index
   * @param e
   */
  public void setExp(int d, int index, Experiment e) {

        int j=0;
        Node temp=head;
        for (int i=0;i<size;i++){
            if(head.data.day==d){
                if(j==index){
                    head.data=e;
                }
                j++;

            }
            head=head.next;
        }

        head=temp;

  }

  /**
   * removes Experiment at the given day and index
   * @param d
   * @param index
   */
  public void removeExp(int d, int index) {

        int j=0;
        Node temp=head;
        Node before=null;
        for (int i=0;i<size;i++){
            if(head.data.day==d){
                if(j==index ){
                    if(before!=null){
                        before.next=head.next;
                        head=before;
                        size--;
                    }
                    else if(before==null && hasNext()){
                        before=head.next;
                        temp=head.next;
                    }

                }
                j++;


            }
            before=head;
            head=head.next;
        }
        head=temp;

  }

  /**
   * Prints experiment to screen
   * @param d
   */
  public void listExp(int d) {

        Node temp=head;
        for (int i=0;i<size;i++){
            if(head.data.day==d) {
                System.out.println(head.data.toString());
            }
            if(hasNext()) {
                head = head.next;
            }
        }

        head=temp;
  }

  /**
   * removes experiments of the day by the given day
   * @param d
   */
  public void removeDay(int d) {

        int j=0;
        Node temp=head;
        Node before = null;
        for (int i=0;i<size;i++){

            if(head.data.day==d){

                if(before!=null){
                    before.next=head.next;
                    head=before;
                    size--;
                }
                else if(before==null && hasNext()){
                    before=head.next;
                    temp=head.next;
                    size--;
                }

            }
            before=head;
            head = head.next;

        }
        head=temp;
  }

  /**
   * Orders days according to accuracy
   * @param d
   */
  public void orderDay(int d) {

        Node temp = head;
        for (int j = 0; j < size; j++){
            for (int i = 0; i < size; i++) {
                if (hasNext() && head.data.day == d && head.next.data.day == d) {
                    if(head.data.accuracy > head.next.data.accuracy) {

                        Experiment tmp=head.data;
                        head.data=head.next.data;
                        head.next.data=tmp;


                    }
                }
                if (hasNext()) {
                    head = head.next;
                }
            }

        head = temp;
        }
  }

  /**
   * Orders experiments according to
   * @return Experiment List
   */
  public ExperimentList orderExperiments() {

        ExperimentList n=new ExperimentList(this);
        Node temp = n.head;

        for (int j = 0; j < n.size; j++){
            for (int i = 0; i < n.size; i++) {
                if (n.hasNext()) {
                    if(n.head.data.accuracy > n.head.next.data.accuracy) {

                        Experiment tmp=n.head.data;
                        n.head.data=n.head.next.data;
                        n.head.next.data=tmp;


                    }

                    n.head = n.head.next;
                }
            }
            n.head = temp;
        }
        return n;
  }

  /**
   * Prints all experiments to screen
   */
  public void listAll() {
        System.out.println("List experiment view:");
        Node last = head;
        while( last != null) {
            System.out.println(last.data.toString());
            last = last.next;
        }
        System.out.println("List day view:");
        last = head;
        int min=last.data.day;
        while( last != null) {
            if(min>last.data.day) {
                min=last.data.day;
            }
            last = last.next;

        }
        last=head;
        int max=last.data.day;
        while( last != null) {
            if(max<last.data.day) {
                max=last.data.day;
            }
            last = last.next;

        }
        last=head;

        for(int j=min;j<=max;j++) {
            for(int i=0;i<size;i++){

                if(head.data.day==j){
                    System.out.println(head.data.toString());
                    i=size+1;
                }
                if(hasNext()) {
                    head = head.next;
                }
            }
            head=last;

        }

        head=last;


  }

}
