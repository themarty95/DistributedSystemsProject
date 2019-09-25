package it.unitn.ds1;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.routing.Group;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class TreeSystem {
	final static int N_NODES = 3;

	  public static void main(String[] args) {
	    // Create the actor system
	    final ActorSystem system = ActorSystem.create("treesystem");

	    // Create bank branches and put them to a list
	    List<ActorRef> group = new ArrayList<>();
	    for (int i=0; i<N_NODES; i++) {
	    //group.add("node1");
	    //group.add(system.actorOf(Node.props(0, 0, "node1", false, false), "node0"));
	    	group.add(system.actorOf(Node.props(i), "node" + i));
	    }
	    
	    
	    
        
	    for (int i=0; i<N_NODES; i++) {
	    	System.out.print(group.get(i) + "\n");
	    }
	    
	    try {
	    	System.out.println(">>> Press ENTER to exit <<<");
		    System.in.read();
		} 
		catch (IOException ioe) {}
		system.terminate();
	  }
	  
	  

}
