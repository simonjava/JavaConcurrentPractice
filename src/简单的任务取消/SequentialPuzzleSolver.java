package 简单的任务取消;

import java.util.LinkedList;
import java.util.List;

public class SequentialPuzzleSolver<P,M> {

	static class Node<P,M>
	{
		final P pos;
		final M move;
		final Node<P,M> prev;
		Node(P pos,M move,Node<P,M> prev)
		{
			this.pos=pos;
			this.move=move;
			this.prev=prev;
		}
		
		List<M> asMoveList()
		{
			List<M> solution = new LinkedList<M>();
			for(Node<P,M> now = this; now.move!=null; now=now.prev)
			{
				solution.add(0,now.move);
			}
			return solution;
		}
	}
	
}


