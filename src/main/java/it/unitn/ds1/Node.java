package it.unitn.ds1;
import akka.actor.ActorRef;
import akka.actor.AbstractActor;
import akka.actor.Props;
import scala.concurrent.duration.Duration;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.lang.Thread;
import java.lang.InterruptedException;
import java.util.Collections;


// The bank branch actor
public class Node extends AbstractActor {
  private int id;                                     		// node ID
  private List<ActorRef> neighbours = new ArrayList<>();  	// neighbours
  
  private int holder; //holder
  private boolean using;//using 
  private Queue<Integer> request_q =  new LinkedList<Integer>();
  private boolean asked; 
  
  /*-- Actor constructors --------------------------------------------------- */
  public Node(int id) {
	    this.id = id;
  }
  
  public Node(int id, int _holder, List<ActorRef> _neighbours, boolean using, boolean asked) {
    this.id = id;
    this.holder = _holder;
    Collections.copy(neighbours, _neighbours); //
    this.using = false;
    this.asked = false;
  }

  ////ERROR HERE!
  /*static public Props props(int id, int holder, List<ActorRef> neighbours, boolean using, boolean asked) {
    return Props.create(Node.class, () -> new Node(id, holder, neighbours, using, asked));
  }*/
  static public Props props(int id){
	    return Props.create(Node.class, () -> new Node(id));
	  }
  
  public void init(int _holder, List<ActorRef> _neighbours){
	  	holder = _holder;
	    Collections.copy(neighbours, _neighbours); //
	    this.using = false;
	    this.asked = false;
  	
  }
  
 

  
  /*-- Message classes ------------------------------------------------------ */


  // Here we define the mapping between the received message types
  // and our actor methods
  @Override
  public Receive createReceive() {
    return receiveBuilder()
      
      .build();
  }
  
}
