import java.util.LinkedList;

public class State {
	private LinkedList<Object> states;
	private int size; 
	private int m;
	private int c;
	
	public State(LinkedList<Object> misioners,LinkedList<Object> canibals, int size) throws Exception{
		if(!validateQuantity(misioners.size(), cannibals.size(), size)){
			throw new Exception("Ay mierda");
		}else{			
			this.states = new LinkedList<>();
			this.size = size;
			this.states = generateStates(combinaciones(misioners, canibals));
		} 	
	}

	private boolean validateQuantity(int misioners, int cannibals, int size) {
		return ((misioners >= cannibals) && (size > 0) && (size <= 2));
	}
	
	public LinkedList<String> combinaciones(LinkedList<Object> A, LinkedList<Object> B){
		LinkedList<Object> newA = new LinkedList<>();
        LinkedList<Object> newB = new LinkedList<>();
        for (int i = 0; i < A.size(); i++) {
           newA.add((newA.size()==0)?A.get(1):newA.getLast()+A.get(1));
           newB.add((newB.size()==0)?B.get(1):newB.getLast()+B.get(1));           
        }
        for (int i = 0; i < newB.size(); i++) {
            newA.add(newB.get(i));
        }
        
        return newA;
    }
	
	public LinkedList<Object> generateState(LinkedList<Object> states) {
        int initM = 0;
        int initC = states.size() / 2;
        LinkedList<Object> newStates = new LinkedList<>();
        
        newStates.addAll(states);
        
        for (int i = 0; i < states.size(); i++) {
            if (i < initC) {
                for (int j = initC; j < states.size(); j++) {
                	Object s = states.get(i) + states.get(j);
                	if(validState(s, newStates))
                    	newStates.add(s);
                }
            } else {
                for (int j = 0; j < initC; j++) {
                	Object s = states.get(i) + states.get(j);
                	if(validState(s, newStates))
                		newStates.add(s);
                }
            }
        }
        
        for (int k = 0; k < newStates.size(); k++) {
			if(newStates.get(k).length() > size){
				newStates.remove(k);
			}
		}
        return newStates;
    }
	
	private void generateStates(){
		LinkedList<String> combs = combinaciones(this.misioner, this.cannibal);
		states = generateState(combs);
	}
	public boolean validState(Object s, LinkedList<Object> newState){
	
		return s.length() <= size && !newState.contains(s) && !newState.contains(new StringBuilder(s).reverse().toString());
	}
	
	public LinkedList<String> getStates(){
		return this.states;
	}
	
	public String toString(){
		LinkedList<String> s = this.misioner;
		s.addAll(this.cannibal);
		return s.toString();
		
	}
}
