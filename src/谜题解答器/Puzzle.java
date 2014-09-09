package ÃÕÌâ½â´ğÆ÷;

import java.util.Set;

public interface Puzzle<P,M> {
	P initalPosition();
	boolean isGoal(P position);
	Set<M> legalMoves(P position);
	P move(P position,M move);
}
